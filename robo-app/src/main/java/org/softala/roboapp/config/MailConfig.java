package org.softala.roboapp.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 
 * @author Tuomas Törmä
 * @since	2.12.2015 
 *
 *	<p>
 *	Configuration class for sending mails Accessed by other classes by
 *	JavaMailSender. In server side, there is email sender softaware 
 *	called sendmail. It uses now localhost, but developer wants he/she can
 *	make host with name. Then the receiver is set to that user who runs
 *	application.
 *	</p>
 */
@Configuration
public class MailConfig {

	 	@Value("${email.host}")
	    private String host;

	    @Value("${email.port}")
	    private Integer port;

	    /**
	     *	Generate JavaMailSender instance using application.properties
	     *	values
	     * 
	     * @return	JavaMailSender instance
	     */
	    @Bean
	    public JavaMailSender javaMailService() {
	        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

	        javaMailSender.setHost(host);
	        javaMailSender.setPort(port);

	        javaMailSender.setJavaMailProperties(getMailProperties());

	        return javaMailSender;
	    }

	    /**
	     * <p>
	     * Set mail properties and return them back. Currently these are
	     * listed
	     * </p>
	     * <pre>
	     * <code>
	     *	properties.setProperty("mail.transport.protocol", "smtp");
	     *	properties.setProperty("mail.smtp.auth", "false");\n
	     *	properties.setProperty("mail.smtp.starttls.enable", "false");\n
	     *	properties.setProperty("mail.debug", "false");\n
	     * </code>
	     * </pre>
	     * 
	     * @return	Properties
	     */
	    private Properties getMailProperties() {
	        Properties properties = new Properties();
	        properties.setProperty("mail.transport.protocol", "smtp");
	        properties.setProperty("mail.smtp.auth", "false");
	        properties.setProperty("mail.smtp.starttls.enable", "false");
	        properties.setProperty("mail.debug", "false");
	        return properties;
	    }
}