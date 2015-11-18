package org.softala.roboapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Tuomas Törmä
 * @Since 14.10.2015
 * 
 * <p>
 * Application class that when runned, starts the backend application.
 * </p>
 * <p>
 * Application uses some custom classes.
 * </p>
 * 
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
