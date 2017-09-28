package com.rabbitmq.publisher.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rabbitmq.publisher.domain.SystemPolicy;


public interface JPA extends JpaRepository<SystemPolicy, Long> {

}
