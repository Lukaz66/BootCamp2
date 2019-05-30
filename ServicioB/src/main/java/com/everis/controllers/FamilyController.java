package com.everis.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.everis.models.Family;
import com.everis.models.FamilyMember;
import com.everis.services.IFamilyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Proyecto: Clase para consumir los servicios e implementar métodos de
 * IFamilyService. Esta clase consume los métodos que realiza el servicio..
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@RestController
@RequestMapping("/api/V1.0/families")
@Api(tags = "CRUD de datos Family")
public class FamilyController {

  Logger log = LoggerFactory.getLogger(this.getClass());

  /**
   * La anotación Autowired para la inyección de dependencia de IFamilyService.
   */
  @Autowired
  private IFamilyService family;

  /**
   * Metodo para obtener la lista de la Familia
   * 
   * @return family.findAll() lista de todas las familias
   */
  @ApiOperation(value = "Lista Family")
  @GetMapping
  public List<Family> get() {
    log.info("Las familias fueron listadas");
    return family.findAll();
  }

  /**
   * Método para obtener la lista de Family con FamilyMember por ID
   * 
   * @param id obtiene el Id de un miembro de familia
   * @return family.findById(id) la lista de la familia con sus miembros de
   *         familia.
   */
  @ApiOperation(value = "Lista Family y FamilyMember por Id")
  @GetMapping("/{id}")
  public List<FamilyMember> getFamily(@PathVariable("id") Long id) {
    log.info("Listar Family con FamilyMember por Id");
    return family.findById(id);
  }

  /**
   * Metodo para insertar una nueva Familia
   * 
   * @param family es almacenada en el modelo.
   * @return family.save(fam) nuevo objeto insertado.
   */
  @ApiOperation(value = "Inserta Family")
  @PostMapping
  public ResponseEntity<Family> save(@RequestBody Family fam) {
    log.info("Family fue insertada");
    return family.save(fam);
  }

  /**
   * Metodo para actualizar una familia existente.
   * 
   * @param Family es para actualizar un objeto existente del modelo.
   * @return family.save(fam) Familia actualizada.
   */
  @ApiOperation(value = "Actualiza Family")
  @PutMapping
  public ResponseEntity<Family> update(@RequestBody Family fam) {
    log.info("Family fue actualizada");
    return family.update(fam);
  }

  /**
   * Metodo para eliminar una familia existente.
   * 
   * @param id es para eliminar un objeto del modelo existente por el Id.
   */
  @ApiOperation(value = "Elimina Family")
  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable("id") Long id) {
    log.info("FamilY fue eliminada");
    family.delete(id);
  }
}
