/**
 * 
 */
package com.dinesh.conversionservice.proxy;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dinesh.conversionservice.bean.ConversionBean;


/**
 * @author Dinesh
 *
 */
//@FeignClient(serviceId="exchange-service", url="localhost:8001")
//@FeignClient(serviceId="exchange-service")
@FeignClient(serviceId="netflix-zuul-api-gateway-server")
@RibbonClient(name = "exchange-service")
public interface ExchangeServiceProxy {

//	@GetMapping("/exchange/{from}/to/{to}")
	@GetMapping("/exchange-service/exchange/{from}/to/{to}")
	public ConversionBean retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);
}
