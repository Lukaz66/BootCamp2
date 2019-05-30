package com.everis.controllers;

import com.everis.models.StudentClass;
import com.everis.services.IStudentClassService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class donde se implementa el rest controller para desarrollar los endpoints.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 27/05/2019
 * @since V 1.0
 *
 */

@RestController
@RequestMapping("api/v1.0/studentClasses")
@Api(tags = "CRUD de Datos StudentClass")
@Log
public class StudentClassController {

  @Autowired
  private IStudentClassService studentClassService;

  /**
   * Listar toda la lista de los StudentClass.
   * 
   * @return una lista con los StudentClass
   */
  @ApiOperation(value = "Lista de StudentClass")
  @GetMapping
  public List<StudentClass> findAll() {
    log.info("Los StudentClass fueron Listados");
    return studentClassService.findAll();
  }

  /**
   * Metodo para almacenar un nuevo StudentClass.
   * 
   * @param stucl
   *          variable donde se va a almacenar el nuevo campo
   */
  @ApiOperation(value = "Insertar StudentClass")
  @PostMapping
  public ResponseEntity<StudentClass> save(@RequestBody StudentClass stucl) {
    return new ResponseEntity<StudentClass>(studentClassService.save(stucl),
        HttpStatus.CREATED);
  }

  /**
   * Metodo para actualizar un StudentClass existente.
   * 
   * @param stucl
   *          variable donde se va a actualizar el nuevo campo
   */
  @ApiOperation(value = "Actualizar Class")
  @PutMapping
  public ResponseEntity<StudentClass> update(@RequestBody StudentClass stucl) {
    return new ResponseEntity<StudentClass>(studentClassService.update(stucl),
        HttpStatus.NO_CONTENT);
  }

  /**
   * Eliminacion Logica para el campo de StudentClass.
   * 
   * @param id
   *          obtiene el id por un String de la Fecha.
   */
  @ApiOperation(value = "Eliminacion de Class")
  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable("id") String id) {
    log.warning("Un StudentClass fue Eliminado");
    studentClassService.softdelete(id);
  }

}
