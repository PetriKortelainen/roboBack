package org.softala.roboapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 
 * @author 	Tuomas Törmä
 * @Since	2.12.2015
 * 
 * <p>
 * Application class that when runned, starts the backend application.
 * </p>
 * <p>
 * Application uses some custom classes in order to save data to database. Also
 * some custom configuration has also been done in order to make application
 * better. Custom configuration has been done with pooling and email.
 * </p>
 * 
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableScheduling
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
