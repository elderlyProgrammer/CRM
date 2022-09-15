package com.eldery.crm;

import com.eldery.crm.service.HibernateSearchService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CrmApplication {

	public static void main(String[] args) {
//		SpringApplication.run(CrmApplication.class, args);
		ConfigurableApplicationContext context =
				SpringApplication.run(CrmApplication.class, args);

		context.getBean(HibernateSearchService.class)
				.initializeHibernateSearch();
	}

}
