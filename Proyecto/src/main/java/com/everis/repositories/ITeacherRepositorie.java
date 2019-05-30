package com.everis.repositories;

import com.everis.models.Teacher;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Proyecto: Interfaz para almacenar funciones útiles y variables necesarias.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 27/05/2019
 * @since V 1.0
 */
@Repository
public interface ITeacherRepositorie extends CrudRepository<Teacher, Integer> {

  /**
   * Metodo para buscar por el id.
   * 
   * @param id
   *          obtiene el id y lo muentra en el body
   * @return
   */
  public Teacher findById(int id);

  /**
   * Metodo para la eliminacion logica.
   */
  @Query("select t from Teacher t where t.deleteStatus=0")
  public List<Teacher> findAll();

  @Query("select t from Teacher t where t.deleteStatus=1")
  public List<Teacher> findDelete();

  @Query("update Teacher t set t.deleteStatus=1 where t.id=?1")
  @Modifying
  @Transactional
  public void softDelete(int id);

}
