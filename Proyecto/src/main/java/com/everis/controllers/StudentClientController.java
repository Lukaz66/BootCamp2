package com.everis.controllers;

import com.everis.feign.StudentClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class donde se implementa el rest controller para desarrollar los endpoints
 * del cliente.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 27/05/2019
 * @since V 1.0
 *
 */

@RestController
@Api(tags = "CRUD de Datos StudentClient")
@RequestMapping("api/v1.0/client/students")
public class StudentClientController {

  final StudentClient studentClient;

  @Autowired
  public StudentClientController(StudentClient studentClient) {
    this.studentClient = studentClient;
  }

  /**
   * Metodo para consumir el servicio B.
   * 
   * @return lista de los Students.
   * @throws InterruptedException
   *           manda una Excepcion
   */
  @ApiOperation(value = "Lista de StudentClient")
  @GetMapping
  @HystrixCommand(fallbackMethod = "getList_fallback", commandProperties = {
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
  public List<Object> getList() throws InterruptedException {
    return studentClient.getList();
  }

  /**
   * Metodo para buscar los ids por el requestBody.
   * 
   * @return retorna la lista de los Students por los ids indicados. manda una
   *         Exception
   */
  @ApiOperation(value = "Lista de StudentClient")
  @PostMapping("/ids")
  @HystrixCommand(fallbackMethod = "getAllById_fallback", commandProperties = {
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
  public List<Object> getAllById(@RequestBody List<Integer> listStudentById)
      throws InterruptedException {
    return studentClient.getAllById(listStudentById);
  }

  /**
   * Metodo lista para el Fallback de Hystrix Control de Error en el servidor.
   * 
   * @return lista con el mensaje de error
   */
  public List<Object> getList_fallback() {
    List<Object> error = new ArrayList<Object>();
    error.add("Error en el servidor de Listar todos los Students");
    return error;
  }

  /**
   * Fallback para el metodo de lista de students por ids.
   * 
   * @return
   */
  public List<Object> getAllById_fallback(
      @RequestBody List<Integer> listStudentById) {
    List<Object> error = new ArrayList<Object>();
    error.add("Ahora no Joven, regrese mas tarde");
    return error;
  }

}
