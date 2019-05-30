package com.everis.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Feign: interfaz del cliente. Esta interfaz define las anotaciones del Feign
 * Client.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 27/05/2019
 * @since V 1.0
 */

@FeignClient("rest-app")
public interface StudentClient {

  /**
   * Metodo para consumir la lista de Student.
   * 
   * @return lista de todos los student
   */
  @RequestMapping("/api/v1.0/students")
  List<Object> getList();

  /**
   * Metodo para obtener la lista de Student por los ids dados.
   * 
   * @param listStudentId
   *          guarda la lista de los students
   * @return la lista por los ids puentos en el body.
   */
  @RequestMapping("/api/v1.0/students/ids")
  List<Object> getAllById(@RequestBody List<Integer> listStudentId);

}
