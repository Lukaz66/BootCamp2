package com.everis.mdc;

import com.everis.mdc.Slf4jMDCFilterConfiguration;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * MDC: Clase principal del MDC. Esta clase define las anotaciones del
 * los metodos a utilizar.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 28/05/2019
 * @since V 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class Slf4jMDCFilter extends OncePerRequestFilter {

  private final String responseHeader;
  private final String mdcTokenKey;
  private final String mdcClientIpKey;
  private final String requestHeader;

  /**
   * Metodo para el Log MDC.
   */
  public Slf4jMDCFilter() {
    responseHeader = Slf4jMDCFilterConfiguration.DEFAULT_RESPONSE_TOKEN_HEADER;
    mdcTokenKey = Slf4jMDCFilterConfiguration.DEFAULT_MDC_UUID_TOKEN_KEY;
    mdcClientIpKey = Slf4jMDCFilterConfiguration.DEFAULT_MDC_CLIENT_IP_KEY;
    requestHeader = null;
  }

  /**
   * Constructor para el Slf4jMDCFilter.
   * @param responseHeader response token header
   * @param mdcTokenKey MDC UUID token key
   * @param mdcClientIPKey MDC client ip key
   * @param requestHeader es nulo.
   */
  public Slf4jMDCFilter(final String responseHeader, final String mdcTokenKey,
      final String mdcClientIPKey, final String requestHeader) {
    this.responseHeader = responseHeader;
    this.mdcTokenKey = mdcTokenKey;
    this.mdcClientIpKey = mdcClientIPKey;
    this.requestHeader = requestHeader;
  }

  @Override
  protected void doFilterInternal(final HttpServletRequest request,
      final HttpServletResponse response, final FilterChain chain)
      throws java.io.IOException, ServletException {
    try {
      final String token = extractToken(request);
      final String clientIP = extractClientIP(request);
      MDC.put(mdcClientIpKey, clientIP);
      MDC.put(mdcTokenKey, token);
      if (!StringUtils.isEmpty(responseHeader)) {
        response.addHeader(responseHeader, token);
      }
      chain.doFilter(request, response);
    } finally {
      MDC.remove(mdcTokenKey);
      MDC.remove(mdcClientIpKey);
    }
  }

  private String extractToken(final HttpServletRequest request) {
    final String token;
    if (!StringUtils.isEmpty(requestHeader)
        && !StringUtils.isEmpty(request.getHeader(requestHeader))) {
      token = request.getHeader(requestHeader);
    } else {
      token = UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }
    return token;
  }

  private String extractClientIP(final HttpServletRequest request) {
    final String clientIP;
    if (request.getHeader("X-Forwarded-For") != null) {
      clientIP = request.getHeader("X-Forwarded-For").split(",")[0];
    } else {
      clientIP = request.getRemoteAddr();
    }
    return clientIP;
  }

  @Override
  protected boolean isAsyncDispatch(final HttpServletRequest request) {
    return false;
  }

  @Override
  protected boolean shouldNotFilterErrorDispatch() {
    return false;
  }

}
