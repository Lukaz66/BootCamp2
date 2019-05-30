package com.everis.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.everis.models.FamilyMember;

/**
 * Project: Interfaz para generar los métodos de servicio de
 * IFamilyMemberService. Esta interfaz define los métodos que realiza nuestro
 * servicio.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@Service
public interface IFamilyMemberService {

  /**
   * Metodo para obtener la lista de la Familia por el findAll()
   */
  List<FamilyMember> findAll();

  /**
   * Metodo para insertar una nueva FamilyMember
   * 
   * @param family es almacenada en el modelo.
   * @return family.save(fam) nuevo objeto insertado.
   */
  ResponseEntity<FamilyMember> save(FamilyMember familyMember);

  /**
   * Metodo para actualizar un FamilyMember existente.
   * 
   * @param FamilyMember es para actualizar un objeto existente del modelo.
   * @return family.save(fam) FamilyMember actualizada.
   */
  ResponseEntity<FamilyMember> update(FamilyMember familyMember);

  /**
   * Metodo para eliminar un FamilyMember existente.
   * 
   * @param id es para eliminar un objeto del modelo existente por el Id.
   */
  void delete(Long id);
}
