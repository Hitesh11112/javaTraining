package com.coforge.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@org.springframework.context.annotation.Configuration
@ComponentScan("com.coforge")
@EnableTransactionManagement
public class AppConfig {
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
		factoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
		return factoryBean;
		
	}
	
//	@Bean
//	public SessionFactory sessionFactory() {
//		return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//	}
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager tm= new HibernateTransactionManager();
		tm.setSessionFactory(sessionFactory);
		tm.setAutodetectDataSource(false);
		return tm;
	}

}