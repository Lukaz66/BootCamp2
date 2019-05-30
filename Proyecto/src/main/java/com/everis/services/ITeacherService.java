package com.everis.services;

import com.everis.models.Teacher;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Project: Interfaz para generar los métodos de servicio de ITeacherService.
 * Esta interfaz define los métodos que realiza nuestro servicio.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 29/05/2019
 * @since v1.0
 */
@Service
public interface ITeacherService {

  /**
   * Metodo para listar todos los objetos de la entidad.
   * 
   * @return una lista completa con todos los datos
   */
  List<Teacher> findAll();

  /**
   * Metodo para la insercion de un nuevo objeto.
   * 
   * @param teacher
   *          nombre de la entidad
   * @return un nuevo objeto en la entidad.
   */
  Teacher save(Teacher teacher);

  /**
   * Metodo para actualizar un objeto de la entidad.
   * 
   * @param teacher
   *          nombre de la entidad
   * @return el objeto modificado
   */
  Teacher update(Teacher teacher);

  /**
   * Metodo para desabilitar el objeto, uso de la eliminacion logica.
   * 
   * @param id
   *          obtiene el id de la entidad.
   */
  void softDelete(int id);

  /**
   * Metodo para buscar un Teacher por le id seleccionado.
   * 
   * @param id
   *          obtiene el id de la entidad.
   * @return el onbejpo del id dado.
   */
  Teacher findById(int id);

  /**
   * Metodo para actualizar un solo campo de un objeto de la entidad.
   * 
   * @param teacher
   *          nombre de la entidad
   * @return el campo modificado del objeto
   */
  Teacher patch(Teacher teacher);

}
