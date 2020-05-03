/**
 * 
 */
package com.dinesh.microservice.bean;

/**
 * @author developer
 *
 */
public class BasicConfiguration {

	private int max;
	private int min;
	
	protected BasicConfiguration() {
		
	}
	
	public BasicConfiguration(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	
	
}
