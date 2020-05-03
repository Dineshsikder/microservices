package com.dinesh.exchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dinesh.exchangeservice.bean.ExchangeValue;

public interface ExchangeValueRepo extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from, String to);
}
