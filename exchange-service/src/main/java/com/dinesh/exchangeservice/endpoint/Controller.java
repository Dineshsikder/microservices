/**
 * 
 */
package com.dinesh.exchangeservice.endpoint;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.exchangeservice.bean.ExchangeValue;
import com.dinesh.exchangeservice.repository.ExchangeValueRepo;

/**
 * @author Dinesh
 *
 */
@RestController
public class Controller {

	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeValueRepo exrepo;
	
	@GetMapping("/exchange/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		
		ExchangeValue exchangeValue = exrepo.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return exchangeValue;
	}
}
