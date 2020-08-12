package ch.kferati.roommanager.configuration;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfiguration {

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("ch.kferati.roommanager.models");
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DataSourceBuilder builder = DataSourceBuilder.create();
		return builder.url("jdbc:sqlite:roommanager.db")
				.driverClassName("org.sqlite.JDBC").build();

	}

	private final Properties hibernateProperties() {

		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.ddl-auto", "update");
		hibernateProperties.setProperty("hibernate.dialect", "ch.kferati.roommanager.Data.sqlite.SQLiteDialect");
		return hibernateProperties;
	}
}