package com.everis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.everis.models.Parent;
import com.everis.services.IParentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Proyecto: Clase para consumir los servicios e implementar métodos de
 * IParentService. Esta clase consume los métodos que realiza el servicio..
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@RestController
@RequestMapping("/api/v2.0/parents")
@Api(tags = "CRUD de datos Parent")
public class ParentController {

  Logger log = LoggerFactory.getLogger(this.getClass());

  /**
   * La anotación Autowired para la inyección de dependencia de IParentService.
   */
  @Autowired
  private IParentService parentService;

  /**
   * Metodo para obtener la lista de un Parent
   * 
   * @return parentService.findAll() lista de todos los Parent
   */
  @ApiOperation(value = "Lista Parent")
  @GetMapping
  public List<Parent> get() {
    log.info("Los Parent Fueron Listados");
    return parentService.findAll();
  }

  /**
   * Metodo para insertar un nuevo Parent
   * 
   * @param Parent es almacenada en el modelo.
   * @return parentService.save(par) nuevo objeto insertado.
   */
  @ApiOperation(value = "Inserta Parent")
  @PostMapping
  public ResponseEntity<Parent> save(@RequestBody Parent par) {
    log.info("Parent Fue Registrado");
    return parentService.save(par);
  }

  /**
   * Metodo para actualizar un Parent existente.
   * 
   * @param Parent es para actualizar un objeto existente del modelo.
   * @return parentService.save(par) Parent actualizado.
   */
  @ApiOperation(value = "Actualiza Parent")
  @PutMapping
  public ResponseEntity<Parent> update(@RequestBody Parent par) {
    log.info("Parent Actualizado");
    return parentService.update(par);
  }

  /**
   * Metodo para eliminar un parent existente.
   * 
   * @param id es para eliminar un objeto del modelo existente por el Id.
   */
  @ApiOperation(value = "Elimina Parent")
  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable("id") Long id) {
    log.warn("Parent Fue Eliminado");
    parentService.delete(id);
  }
}
