/**
 * 
 */
package com.dinesh.conversionservice.endpoint;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dinesh.conversionservice.bean.ConversionBean;
import com.dinesh.conversionservice.proxy.ExchangeServiceProxy;

/**
 * @author Dinesh
 *
 */
@RestController
public class Controller {

	@Autowired
	private ExchangeServiceProxy proxy;
	
	@GetMapping("/conversion/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionBean currencyConversion(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		Map<String,String> uriVariables = new HashMap<String,String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<ConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8001/exchange/{from}/to/{to}",
				ConversionBean.class, uriVariables);
		ConversionBean response = responseEntity.getBody();
		return new ConversionBean(response.getId(),from,to,response.getConversion(),quantity,quantity.multiply(response.getConversion()),response.getPort());
	}
	
	@GetMapping("/conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionBean currencyConversionFeign(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		ConversionBean response = proxy.retrieveExchangeValue(from, to);
		return new ConversionBean(response.getId(),from,to,response.getConversion(),quantity,quantity.multiply(response.getConversion()),response.getPort());
	}
}
