package com.everis.services;

import com.everis.models.StudentClass;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Project: Interfaz para generar los métodos de servicio de
 * IStudentClassService. Esta interfaz define los métodos que realiza nuestro
 * servicio.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 29/05/2019
 * @since v1.0
 */
@Service
public interface IStudentClassService {

  /**
   * Metodo para obtener la lista de los studenClass.
   * 
   * @return una lista de todo
   */
  List<StudentClass> findAll();

  /**
   * Metodo para la insercion de un nuevo campo a la entidad studentClass.
   * 
   * @param studentClass
   *          nombre de la entidad
   * @return un nuevo campo a la entidad studentClass.
   */
  StudentClass save(StudentClass studentClass);

  /**
   * Metodo para actualizar los campos de un objeto de la entidad studentClass.
   * 
   * @param studentClass
   *          nombre de la entidad
   * @return el objeto con los campos actualizados
   */
  StudentClass update(StudentClass studentClass);

  /**
   * Metodo para desabilitar el campo, uso de eliminacion logica.
   * 
   * @param id
   *          obtiene el id del campo que se va a desabilitar
   */
  void softdelete(String id);

}
