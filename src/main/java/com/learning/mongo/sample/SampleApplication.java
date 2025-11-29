package com.learning.mongo.sample;

import com.learning.mongo.sample.dao.ContingentDao;
import com.learning.mongo.sample.dao.EmployeeDao;
import com.learning.mongo.sample.model.Contingent;
import com.learning.mongo.sample.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SampleApplication.class, args);

		try {
			EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
			Employee employee = new Employee();
			employee.setName("some_name");
			employee.setEmployeeId(UUID.randomUUID().toString());
			employee.setProjects(List.of("PINEAPPLE", "WORLD"));
			employee.setMisc(Map.of("manager", "kanye_west", "date_of_joining", Instant.now()));
			employeeDao.persist(employee);
		}
		catch (Exception e) {
			System.out.println(Arrays.toString(e.getStackTrace()));
		}

		try {
			ContingentDao contingentDao = context.getBean(ContingentDao.class);
			Contingent contingent = new Contingent();
			System.out.println("im here");
			contingent.setName("someone_on_contract");
			contingent.setId(UUID.randomUUID().toString());
			contingent.setContractYears(2);
			contingentDao.persist(contingent);
		}
		catch (Exception e) {
			System.out.println(Arrays.toString(e.getStackTrace()));
		}

	}

}
