package com.everis.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.everis.models.Parent;

/**
 * Project: Interfaz para generar los métodos de servicio de IParentService.
 * Esta interfaz define los métodos que realiza nuestro servicio.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@Service
public interface IParentService {

  /**
   * Metodo para obtener la lista de un Parent
   * 
   * @return parentService.findAll() lista de todos los Parent
   */
  List<Parent> findAll();

  /**
   * Metodo para insertar un nuevo Parent
   * 
   * @param Parent es almacenada en el modelo.
   * @return parentService.save(par) nuevo objeto insertado.
   */
  ResponseEntity<Parent> save(Parent parent);

  /**
   * Metodo para actualizar un Parent existente.
   * 
   * @param Parent es para actualizar un objeto existente del modelo.
   * @return parentService.save(par) Parent actualizado.
   */
  ResponseEntity<Parent> update(Parent parent);

  /**
   * Metodo para eliminar un parent existente.
   * 
   * @param id es para eliminar un objeto del modelo existente por el Id.
   */
  void delete(Long id);

}
