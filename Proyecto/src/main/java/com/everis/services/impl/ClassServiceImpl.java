package com.everis.services.impl;

import com.everis.models.Class;
import com.everis.models.dtoprojection.StudentProjection;
import com.everis.repositories.IClassRepositorie;
import com.everis.services.IClassService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project: Clase para generar el servicio implementar métodos de
 * ClassServiceImpl. Esta clase implementa los métodos que realiza nuestro
 * servicio.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 29/05/2019
 * @since V 1.0
 */
@Service
public class ClassServiceImpl implements IClassService {

  @Autowired
  private IClassRepositorie classRepo;

  /**
   * Implementando el metodo listar.
   */
  @Override
  public List<Class> findAll() {
    return (List<Class>) classRepo.findAll();
  }

  /**
   * Implementando el metodo insertar.
   */
  @Override
  public Class save(Class clas) {
    return classRepo.save(clas);
  }

  /**
   * Implementando el metodo actualizar.
   */
  @Override
  public Class update(Class clas) {
    return classRepo.save(clas);
  }

  /**
   * Implementando el metodo eliminacion logica.
   */
  @Override
  public void softDelete(int id) {
    classRepo.softDelete(id);
  }

  /**
   * Implementando el metodo buscar por id.
   */
  @Override
  public Class findById(int id) {
    return classRepo.findById(id);
  }

  /**
   * Implementando el metodo PATCH actualizar por un solo campo.
   */
  @Override
  public Class patch(Class clas) {
    return classRepo.save(clas);
  }

  @Override
  public List<StudentProjection> findAllStudents() {
    return classRepo.getAll();
  }

}
