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

import com.everis.models.FamilyMember;
import com.everis.services.IFamilyMemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Proyecto: Clase para consumir los servicios e implementar métodos de
 * IFamilyMemberService. Esta clase consume los métodos que realiza el
 * servicio..
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@RestController
@RequestMapping("/api/V1.0/familymember")
@Api(tags = "CRUD de datos FamilyMember")
public class FamilyMemberController {

  /**
   * La anotación Autowired para la inyección de dependencia de
   * IFamilyMemberService.
   */
  @Autowired
  private IFamilyMemberService familyMember;

  /**
   * Metodo para obtener la lista de la Familia
   * 
   * @return familyMember.findAll() lista de todas las miembros de familias.
   */
  @ApiOperation(value = "Lista FamilyMember")
  @GetMapping
  public List<FamilyMember> get() {
    return familyMember.findAll();
  }

  /**
   * Metodo para insertar una nueva FamilyMember
   * 
   * @param family es almacenada en el modelo.
   * @return family.save(fam) nuevo objeto insertado.
   */
  @ApiOperation(value = "Inserta FamilyMember")
  @PostMapping
  public ResponseEntity<FamilyMember> save(@RequestBody FamilyMember family) {
    return familyMember.save(family);
  }

  /**
   * Metodo para actualizar un FamilyMember existente.
   * 
   * @param FamilyMember es para actualizar un objeto existente del modelo.
   * @return family.save(fam) FamilyMember actualizada.
   */
  @ApiOperation(value = "Actualiza FamilyMember")
  @PutMapping
  public ResponseEntity<FamilyMember> update(@RequestBody FamilyMember family) {
    return familyMember.update(family);
  }

  /**
   * Metodo para eliminar un FamilyMember existente.
   * 
   * @param id es para eliminar un objeto del modelo existente por el Id.
   */
  @ApiOperation(value = "Elimina FamilyMember")
  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable("id") Long id) {
    familyMember.delete(id);
  }
}
