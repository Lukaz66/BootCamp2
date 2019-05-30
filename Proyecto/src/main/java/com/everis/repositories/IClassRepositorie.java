package com.everis.repositories;

import com.everis.models.Class;
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
public interface IClassRepositorie extends CrudRepository<Class, Integer> {

  /**
   * Metodo para la busqueda por id.
   * 
   * @param id
   *          obtiene el id
   * @return un class por el id dado.
   */
  public Class findById(int id);

  /**
   * Eliminacion logica. uso de @Query para la eliminacion
   */
  @Query("select c from Class c where c.deleteStatus=0")
  public List<Class> findAll();

  @Query("select c from Class c where c.deleteStatus=1")
  public List<Class> findDelete();

  @Query("update Class c set c.deleteStatus=1 where c.id=?1")
  @Modifying
  @Transactional
  public void softDelete(int id);

}
