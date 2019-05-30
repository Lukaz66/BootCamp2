package com.everis.services;

import com.everis.models.Class;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Project: Interfaz para generar los métodos de servicio de IClassService. Esta
 * interfaz define los métodos que realiza nuestro servicio.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 29/05/2019
 * @since v1.0
 */

@Service
public interface IClassService {

  /**
   * Metodo para obtener la lista de Class.
   * 
   * @return classService.findAll() lista de todos los class
   */
  List<Class> findAll();

  /**
   * Metodo para insertar un nuevo Class.
   * es almacenada en el modelo.
   * 
   * @return classService.save(cla) nuevo objeto insertado.
   */
  Class save(Class clas);

  /**
   * Metodo para actualizar un class existente. es para actualizar un objeto
   * existente del modelo.
   * 
   * @return classService.save(cla) Class actualizado.
   */
  Class update(Class clas);

  /**
   * Metodo para eliminar un class existente, uso de eliminacion logica.
   * 
   * @param id
   *          es para eliminar un objeto del modelo existente por el Id.
   */
  void softDelete(int id);

  /**
   * Metodo para buscar un Class por Id.
   * 
   * @return Class int id lista de un solo Class.
   */
  Class findById(int id);

  /**
   * Metodo para actualizar un solo campo de un objeto existente de la tabla
   * Class.
   * 
   * @param clas
   *          obtiene el objeto que se va a modificar
   * @return el objeto modificado y actualiza el campo seleccionado.
   */
  Class patch(Class clas);
  
}
