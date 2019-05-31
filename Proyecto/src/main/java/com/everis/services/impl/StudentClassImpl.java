package com.everis.services.impl;

import com.everis.models.StudentClass;
import com.everis.repositories.IStudentClassRepositories;
import com.everis.services.IStudentClassService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Project: Clase para generar el servicio implementar métodos de
 * StudentClassImpl. Esta clase implementa los métodos que realiza nuestro
 * servicio.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 29/05/2019
 * @since V 1.0
 */
@Service
public class StudentClassImpl implements IStudentClassService {

  @Autowired
  private IStudentClassRepositories studentClassRepo;

  /**
   * Metodo para listar los StudentClass.
   */
  @Override
  public List<StudentClass> findAll() {
    return (List<StudentClass>) studentClassRepo.findAll();
  }

  /**
   * Metodo para insertar un nuevo objeto.
   */
  @Override
  public StudentClass save(StudentClass studentClass) {
    return studentClassRepo.save(studentClass);
  }

  /**
   * Metodo para eliminar o desabilitar un objeto.
   */
  @Override
  public void softdelete(String id) {
    studentClassRepo.softDelete(id);
  }

  /**
   * Metodo para listar los students por un classId.
   */
  @Override
  public List<Integer> findIdStudentByClassId(int classId) {
    return studentClassRepo.findIdStudentByClassId(classId);
  }

}
