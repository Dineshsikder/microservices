/**
 * 
 */
package com.dinesh.exchangeservice.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Dinesh
 *
 */
@Entity
public class ExchangeValue {

	@Id
	private Long id;
	@Column(name="currency_to")
	private String to;
	@Column(name="currency_from")
	private String from;
	private BigDecimal conversion;
	private int port;
	
	public ExchangeValue() {
		
	}

	public ExchangeValue(Long id, String to, String from, BigDecimal conversion) {
		super();
		this.id = id;
		this.to = to;
		this.from = from;
		this.conversion = conversion;
	}

	public Long getId() {
		return id;
	}

	public String getTo() {
		return to;
	}

	public String getFrom() {
		return from;
	}

	public BigDecimal getConversion() {
		return conversion;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
}
