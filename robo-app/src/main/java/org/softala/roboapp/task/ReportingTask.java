package org.softala.roboapp.task;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import org.softala.roboapp.model.OrderContact;
import org.softala.roboapp.process.IteratorProcesser;
import org.softala.roboapp.repository.OrderContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * @author 	Tuomas Törmä
 * @since	2.12.2015
 *
 *	<p>
 *	Reporting task are automated task based on Cron time. Reporting task
 *	is automatically added to Spring Boot application. 
 *	</p>
 */
@Component
public class ReportingTask {

	
	private LocalDate date;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private OrderContactRepository orderContactRepository;
	
	@Value("${email.sendto.email}")
    private String sendTo;

	/**
	 * <p>
	 * Cron presenttion. * means any time 
	 * <ul>
	 * 	<li>second</li>
	 * 	<li>minute</li>
	 * 	<li>hour</li>
	 * 	<li>day of month</li>
	 * 	<li>month</li>
	 * 	<li> day(s) of week</li>
	 * </ul>
	 * </p>
	 * <p>
	 * Send email each Friday at 16:00
	 * </p>
	 * <code>
	 *  0 0 16 * * 5
	 * </code>
	 */
	@Scheduled(cron = "0 0 16 * * 5")
	public void sendEmailFromCurrentClosings() {
		// this day
		date = LocalDate.now();

		//week after
		LocalDate weekAfter = date.minusWeeks(1);

		IteratorProcesser<OrderContact> processor = new IteratorProcesser<OrderContact>();

		ArrayList<OrderContact> allOrders = processor.processToArrayList(orderContactRepository.findAll());
		ArrayList<OrderContact> sendEmailToThese = new ArrayList<OrderContact>();

		for (OrderContact orderContact : allOrders) {
			// Inserted day
			LocalDate inserted = orderContact.getCreated().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			// we want all dates that are from this day and week before it. All
			// future or less than last week are not listed
			//for example.
			if (inserted.isEqual(date) || inserted.isBefore(date) && inserted.isAfter(weekAfter)) {
				sendEmailToThese.add(orderContact);
			} 
		}
		
		//Generate text
		String orders = "Aika välin " + weekAfter.toString()+ " - " + date.toString() + "\n";
		for (OrderContact orderContact : sendEmailToThese) {
			orders += "Tilaus numero:" + orderContact.getOrderId() + ", päivältä " + orderContact.getCreated() + "\n";
		}
		
		//Send email if the Email can be send
		 SimpleMailMessage mailMessage=new SimpleMailMessage();
		 mailMessage.setTo(sendTo);
		 mailMessage.setSubject("Tilaukset");
		 mailMessage.setText(orders);
		 mailSender.send(mailMessage);
	}
}