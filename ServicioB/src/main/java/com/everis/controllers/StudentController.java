package com.everis.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.everis.models.Student;
import com.everis.services.IStudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Proyecto: Clase para consumir los servicios e implementar métodos de
 * IStudentService. Esta clase consume los métodos que realiza el servicio..
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@RestController
@RequestMapping("/api/v2.0/students")
@Api(tags = "CRUD de datos Student")
public class StudentController {

  Logger log = LoggerFactory.getLogger(this.getClass());
  
  /**
   * La anotación Autowired para la inyección de dependencia de IStudentService.
   */
  @Autowired
  private IStudentService studentService;

//  public StudentController(IStudentService studentService) {
//	this.studentService = studentService;
//  }
  
  /**
   * Metodo para obtener la lista de Student
   * 
   * @return studentService.findAll() lista de todos los student
   */
  @ApiOperation(value = "Lista Student")
  @GetMapping
  public List<Student> findAll() {
    log.info("Los Student fueron listados");
    return studentService.findAll();
  }

  /**
   * Metodo para insertar un nuevo Student
   * 
   * @param Student es almacenada en el modelo.
   * @return studentService.save(stu) nuevo objeto insertado.
   */
  @ApiOperation(value = "Inserta Student")
  @PostMapping
  @ResponseStatus(value = HttpStatus.CREATED)
  public void save(@RequestBody Student stu) {
    log.info("Student fue insertado");
    studentService.save(stu);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Location",
        ServletUriComponentsBuilder.fromCurrentRequest()
          .path("/{name}")
          .buildAndExpand(stu.getStudentId()).toUri()
          .toString());
  }

  /**
   * Metodo para actualizar un student existente.
   * 
   * @param student es para actualizar un objeto existente del modelo.
   * @return studentService.save(stu) Student actualizado.
   */
  @ApiOperation(value = "Actualiza Student")
  @PutMapping
  public void update(@RequestBody Student stu) {
    log.info("Student fue actualizado");
    studentService.update(stu);
  }

  /**
   * Metodo para eliminar un student existente.
   * 
   * @param id es para eliminar un objeto del modelo existente por el Id.
   */
  @ApiOperation(value = "Elimina Student")
  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable("id") int id) {
    log.warn("Student eliminado");
    studentService.delete(id);
  }

  /**
   * Metodo para buscar a Student por Id.
   * 
   * @param id variable para buscar el id de Student
   * @return Lista de Student por el Id
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<Student> findById(@PathVariable(value = "id") int id) {
    return new ResponseEntity<Student>(studentService.findById(id), HttpStatus.OK);
  }
  
  @PostMapping("/ids")
  public List<Student> getAllById(@RequestBody List<Integer> listStudentId) {
    return studentService.findAllById(listStudentId);
  }

}
