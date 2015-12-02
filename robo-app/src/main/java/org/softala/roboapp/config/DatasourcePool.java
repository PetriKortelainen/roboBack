package org.softala.roboapp.config;

import java.beans.PropertyVetoException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 
 * @author Tuomas Törmä
 * @since	2.12.2015
 *	
 *<p>
 *	Datasource is also set to use C3P0 as pooling parts. With this in use, application
 *	is able to create connection in pool like form. When requested connection, one of the
 *	pool datasources is going to be used. This helps to maintain connection and makes
 *	that there are spare connection in when someone else tries to make connection
 *</p>
 */
@Configuration
public class DatasourcePool {

		//Values are gained from application.properties
	 	@Value("${c3p0.max_pool_size}")
	    private int maxSize;
	 
	    @Value("${c3p0.min_pool_size}")
	    private int minSize;
	 
	    @Value("${c3p0.acquire_increment}")
	    private int acquireIncrement;
	 
	    @Value("${c3p0.idle_connection_test_period}")
	    private int idleTestPeriod;
	 
	    @Value("${c3p0.max_statements}")
	    private int maxStatements;
	 
	    @Value("${c3p0.max_idle_time}")
	    private int maxIdleTime;
	 
	    @Value("${c3p0.url}")
	    private String url;
	 
	    @Value("${c3p0.username}")
	    private String username;
	 
	    @Value("${c3p0.password}")
	    private String password;
	 
	    @Value("${c3p0.driverClassName}")
	    private String driverClassName;
	    
	    @Value("${c3p0.debug_unreturned_connection_stackTraces}")
	    private boolean debugUnreturnedConnectionStackTraces;
	    
	    @Value("${c3p0.unreturned_Connection_Timeout}")
	    private int unreturnedConnectionTimeout;
	   
	    /**
	     * Generate ComboPooledDataSource objects via application.properies values
	     * 
	     * @return	ComboPooledDataSource
	     * @throws PropertyVetoException
	     */
	    @Bean(destroyMethod = "close")
	    public ComboPooledDataSource dataSource() throws PropertyVetoException {
	        ComboPooledDataSource dataSource = new ComboPooledDataSource();
	        dataSource.setMaxPoolSize(maxSize);
	        dataSource.setMinPoolSize(minSize);
	        dataSource.setAcquireIncrement(acquireIncrement);
	        dataSource.setIdleConnectionTestPeriod(idleTestPeriod);
	        dataSource.setMaxStatements(maxStatements);
	        dataSource.setMaxIdleTime(maxIdleTime);
	        dataSource.setJdbcUrl(url);
	        dataSource.setPassword(password);
	        dataSource.setUser(username);
	        dataSource.setDriverClass(driverClassName);
	        dataSource.setDebugUnreturnedConnectionStackTraces(debugUnreturnedConnectionStackTraces);
	        dataSource.setUnreturnedConnectionTimeout(unreturnedConnectionTimeout);
	        return dataSource;
	    }
}