package com.rabbitmq.publisher.utils;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.rabbitmq.publisher.domain.SystemPolicy;
import com.rabbitmq.publisher.repo.JPA;

public class Utils {
	
	@Autowired
	JPA jPARepo;
	
	@PostConstruct
	public void insertPolicies() {
		if (jPARepo.findAll().isEmpty()) {
			SystemPolicy policy1 = new SystemPolicy("Health Insurance Policy 1", "Health Policy 1", "250000", "5",
					"yearly");
			SystemPolicy policy2 = new SystemPolicy("Health Insurance Policy 2", "Health Policy 2", "250000", "5",
					"yearly");
			SystemPolicy policy3 = new SystemPolicy("Health Insurance Policy 3", "Health Policy 3", "250000", "5",
					"yearly");
			jPARepo.save(policy1);
			jPARepo.save(policy2);
			jPARepo.save(policy3);
		} else {
			// Do nothing
		}

	}

}
