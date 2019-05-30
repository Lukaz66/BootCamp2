package com.everis.repositories;

import com.everis.models.Subject;
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
public interface ISubjectRepositorie extends CrudRepository<Subject, Integer> {

  /**
   * Metodo para obtener el id del Subject.
   * 
   * @param id
   *          toma el parametro y obtiene los campos
   * @return un Subject completo
   */
  public Subject findById(int id);

  @Query("select s from Subject s where s.deleteStatus=0")
  public List<Subject> findAll();

  @Query("select s from Subject s where s.deleteStatus=1")
  public List<Subject> findDelete();

  @Query("update Subject s set s.deleteStatus=1 where s.id=?1")
  @Modifying
  @Transactional
  public void softDelete(int id);

}
