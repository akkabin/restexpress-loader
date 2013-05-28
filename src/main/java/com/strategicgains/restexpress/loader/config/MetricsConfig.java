package com.strategicgains.restexpress.loader.config;

import com.strategicgains.restexpress.loader.dto.BaseBean;

public class MetricsConfig extends BaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean isEnabled;
	private String machineName;
	private Boolean isGraphiteEnabled;
	private String graphiteHost;
	private Integer graphitePort;
	private Integer publishSeconds;

	/**
	 * @return the isEnabled
	 */
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	/**
	 * @param isEnabled
	 *            the isEnabled to set
	 */
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * @return the machineName
	 */
	public String getMachineName() {
		return machineName;
	}

	/**
	 * @param machineName
	 *            the machineName to set
	 */
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	/**
	 * @return the isGraphiteEnabled
	 */
	public Boolean getIsGraphiteEnabled() {
		return isGraphiteEnabled;
	}

	/**
	 * @param isGraphiteEnabled
	 *            the isGraphiteEnabled to set
	 */
	public void setIsGraphiteEnabled(Boolean isGraphiteEnabled) {
		this.isGraphiteEnabled = isGraphiteEnabled;
	}

	/**
	 * @return the graphiteHost
	 */
	public String getGraphiteHost() {
		return graphiteHost;
	}

	/**
	 * @param graphiteHost
	 *            the graphiteHost to set
	 */
	public void setGraphiteHost(String graphiteHost) {
		this.graphiteHost = graphiteHost;
	}

	/**
	 * @return the graphitePort
	 */
	public Integer getGraphitePort() {
		return graphitePort;
	}

	/**
	 * @param graphitePort
	 *            the graphitePort to set
	 */
	public void setGraphitePort(Integer graphitePort) {
		this.graphitePort = graphitePort;
	}

	/**
	 * @return the publishSeconds
	 */
	public Integer getPublishSeconds() {
		return publishSeconds;
	}

	/**
	 * @param publishSeconds
	 *            the publishSeconds to set
	 */
	public void setPublishSeconds(Integer publishSeconds) {
		this.publishSeconds = publishSeconds;
	}

}
