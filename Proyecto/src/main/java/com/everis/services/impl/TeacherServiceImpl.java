package com.everis.services.impl;

import com.everis.models.Teacher;
import com.everis.repositories.ITeacherRepositorie;
import com.everis.services.ITeacherService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project: Clase para generar el servicio implementar métodos de
 * TeacherServiceImpl. Esta clase implementa los métodos que realiza nuestro
 * servicio.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 29/05/2019
 * @since V 1.0
 */
@Service
public class TeacherServiceImpl implements ITeacherService {

  @Autowired
  private ITeacherRepositorie teacherRepo;

  /**
   * Metodo para listar los campos de la entidad teacher.
   */
  @Override
  public List<Teacher> findAll() {
    return (List<Teacher>) teacherRepo.findAll();
  }

  /**
   * Metodo para insertar un nuevo objeto en la entidad.
   */
  @Override
  public Teacher save(Teacher teacher) {
    return teacherRepo.save(teacher);
  }

  /**
   * Metodo para actualizar los campos de un objeto de la entidad.
   */
  @Override
  public Teacher update(Teacher teacher) {
    return teacherRepo.save(teacher);
  }

  /**
   * Metodo para eliminar o inhabilitar un objeto de la entidad.
   */
  @Override
  public void softDelete(int id) {
    teacherRepo.softDelete(id);
  }

  /**
   * Metodo para buscar un objeto por el id seleccionado.
   */
  @Override
  public Teacher findById(int id) {
    return teacherRepo.findById(id);
  }

  /**
   * Metodo para actualizar un solo campo de un objeto de la entidad.
   */
  @Override
  public Teacher patch(Teacher teacher) {
    return teacherRepo.save(teacher);
  }

}
