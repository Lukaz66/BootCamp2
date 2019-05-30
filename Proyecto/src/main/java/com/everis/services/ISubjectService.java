package com.everis.services;

import com.everis.models.Subject;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Project: Interfaz para generar los métodos de servicio de ISubjectService.
 * Esta interfaz define los métodos que realiza nuestro servicio.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 29/05/2019
 * @since v1.0
 */
@Service
public interface ISubjectService {

  /**
   * Metodo para realizar la lista de todos los Subject.
   * 
   * @return la lista completa de tdos los Subjects
   */
  List<Subject> findAll();

  /**
   * Metodo para insertar un nuevo campo en la entidad subjecct.
   * 
   * @param subject
   *          nombre de la entidad
   * @return un nuevo campo insertado en la entidad.
   */
  Subject save(Subject subject);

  /**
   * Metodo para actualizar un campo de la entidad subject.
   * 
   * @param subject
   *          nombre de la entidad
   * @return el objeto con los campos actualizado
   */
  Subject update(Subject subject);

  /**
   * Metodo para desabilitar un subject, uso de la eliminacion logica.
   * 
   * @param id
   *          obtiene el id de la entidad para la eliminacion.
   */
  void softdelete(int id);

  /**
   * Metodo para buscar un subject pasando el id para devolver un solo objeto.
   * 
   * @param id
   *          obtiene el id del objeto.
   * @return un objeto de la entidad
   */
  Subject findById(int id);

  /**
   * Metodo para actualizar un solo campo de un objeto de la entidad Subject.
   * 
   * @param subject
   *          nombre de la entidad
   * @return el campo actualizado.
   */
  Subject patch(Subject subject);

}
