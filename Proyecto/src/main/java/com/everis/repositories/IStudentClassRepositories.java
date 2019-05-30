package com.everis.repositories;

import com.everis.models.Student;
import com.everis.models.StudentClass;
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
public interface IStudentClassRepositories
    extends
      CrudRepository<StudentClass, String> {

  /**
   * Metodo para la busqueda del classId con los studentId.
   * 
   * @param classId
   *          obtiene la clase
   * @return lista del class con los students
   */
  @Query(value = "select s.studentId from StudentClass s where s.classId = ?1", nativeQuery = true)
  List<Student> findIdStudentByClassId(Integer classId);

  /**
   * Metodos para la eliminacion logica.
   */
  @Query("select s from StudentClass s where s.deleteStatus=0")
  public List<StudentClass> findAll();

  @Query("select s from StudentClass s where s.deleteStatus=1")
  public List<StudentClass> findDelete();

  @Query("update StudentClass s set s.deleteStatus=1 where s.id=?1")
  @Modifying
  @Transactional
  public void softDelete(String id);

}
