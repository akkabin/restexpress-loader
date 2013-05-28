package com.strategicgains.restexpress.loader.config;

import java.util.List;

import com.strategicgains.restexpress.loader.dto.BaseBean;


public class AppConfiguration extends BaseBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int port;
	private String defaultFormat;
	private String baseUrl;
	private int executorThreadPoolSize;
	private MetricsConfig metricsConfig;
	private List<String> serviceClasses;
	private String exceptionMapper;
	private String dtoPackage;
	/**
	 * @return the exceptionMapper
	 */
	public String getExceptionMapper() {
		return exceptionMapper;
	}
	/**
	 * @param exceptionMapper the exceptionMapper to set
	 */
	public void setExceptionMapper(String exceptionMapper) {
		this.exceptionMapper = exceptionMapper;
	}
	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
	/**
	 * @return the defaultFormat
	 */
	public String getDefaultFormat() {
		return defaultFormat;
	}
	/**
	 * @param defaultFormat the defaultFormat to set
	 */
	public void setDefaultFormat(String defaultFormat) {
		this.defaultFormat = defaultFormat;
	}
	/**
	 * @return the baseUrl
	 */
	public String getBaseUrl() {
		return baseUrl;
	}
	/**
	 * @param baseUrl the baseUrl to set
	 */
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	/**
	 * @return the executorThreadPoolSize
	 */
	public int getExecutorThreadPoolSize() {
		return executorThreadPoolSize;
	}
	/**
	 * @param executorThreadPoolSize the executorThreadPoolSize to set
	 */
	public void setExecutorThreadPoolSize(int executorThreadPoolSize) {
		this.executorThreadPoolSize = executorThreadPoolSize;
	}
	/**
	 * @return the metricsConfig
	 */
	public MetricsConfig getMetricsConfig() {
		return metricsConfig;
	}
	/**
	 * @param metricsConfig the metricsConfig to set
	 */
	public void setMetricsConfig(MetricsConfig metricsConfig) {
		this.metricsConfig = metricsConfig;
	}
	/**
	 * @return the serviceClasses
	 */
	public List<String> getServiceClasses() {
		return serviceClasses;
	}
	/**
	 * @param serviceClasses the serviceClasses to set
	 */
	public void setServiceClasses(List<String> serviceClasses) {
		this.serviceClasses = serviceClasses;
	}
	/**
	 * @return the dtoPackage
	 */
	public String getDtoPackage() {
		return dtoPackage;
	}
	/**
	 * @param dtoPackage the dtoPackage to set
	 */
	public void setDtoPackage(String dtoPackage) {
		this.dtoPackage = dtoPackage;
	}
	
	

}
