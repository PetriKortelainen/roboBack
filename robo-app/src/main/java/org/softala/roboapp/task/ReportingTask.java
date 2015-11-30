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
 * @author Tuomas Törmä
 *
 *	Reporting task are automated task based on Cron time
 *
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
	 * Cron presenttion
	 * 
	 * second, minute, hour, day of month, month, day(s) of week
	 * 
	 * Send email each Friday at 16:00
	 * cron pattern 0 0 16 * * 5
	 */
	@Scheduled(cron = "0 0 16 * * 5")
	public void sendEmailFromCurrentClosings() {
		// this day
		date = LocalDate.now();

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