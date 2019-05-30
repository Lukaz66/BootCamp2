package com.everis.mdc;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * MDC: Clase principal del MDC. Esta clase define las anotaciones del los
 * metodos a utilizar.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 28/05/2019
 * @since V 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "mdc.slf4jfilter")
public class Slf4jMDCFilterConfiguration {

  public static final String DEFAULT_RESPONSE_TOKEN_HEADER = "Response_Token";
  public static final String DEFAULT_MDC_UUID_TOKEN_KEY = "Slf4jMDCFilter.UUID";
  public static final String DEFAULT_MDC_CLIENT_IP_KEY = "Slf4jMDCFilter.ClientIP";

  private String responseHeader = DEFAULT_RESPONSE_TOKEN_HEADER;
  private String mdcTokenKey = DEFAULT_MDC_UUID_TOKEN_KEY;
  private String mdcClientIpKey = DEFAULT_MDC_CLIENT_IP_KEY;
  private String requestHeader = null;

}
