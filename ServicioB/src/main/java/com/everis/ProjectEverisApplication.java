package com.everis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/** Proyecto: Clase del proyecto ProjectEverisApplication.
 * Esta clase consume los métodos que realiza el servicio..
 * @author Llanos_Canahuire_Waldo
 * @version 16/05/2019
 * @since V 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProjectEverisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectEverisApplication.class, args);
	}

}