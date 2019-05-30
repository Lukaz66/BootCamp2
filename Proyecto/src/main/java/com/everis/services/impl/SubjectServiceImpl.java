package com.everis.services.impl;

import com.everis.models.Subject;
import com.everis.repositories.ISubjectRepositorie;
import com.everis.services.ISubjectService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project: Clase para generar el servicio implementar métodos de
 * SubjectServiceImpl. Esta clase implementa los métodos que realiza nuestro
 * servicio.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 29/05/2019
 * @since V 1.0
 */
@Service
public class SubjectServiceImpl implements ISubjectService {

  @Autowired
  private ISubjectRepositorie subjectRepo;

  /**
   * Metodo para listar todos los objetos de la entidad.
   */
  @Override
  public List<Subject> findAll() {
    return (List<Subject>) subjectRepo.findAll();
  }

  /**
   * Metodo para buscar un objeto por el id.
   */
  @Override
  public Subject findById(int id) {
    return subjectRepo.findById(id);
  }

  /**
   * Metodo para insertar un nuevo objeto.
   */
  @Override
  public Subject save(Subject subject) {
    return subjectRepo.save(subject);
  }

  /**
   * Metodo para actualizar los campos de un objeto de la entidad.
   */
  @Override
  public Subject update(Subject subject) {
    return subjectRepo.save(subject);
  }

  /**
   * Metodo para eliminar o inhabilitar un objeto de la entidad.
   */
  @Override
  public void softdelete(int id) {
    subjectRepo.softDelete(id);
  }

  /**
   * Metodo para actualizar un solo campo de la entidad subject.
   */
  @Override
  public Subject patch(Subject subject) {
    return subjectRepo.save(subject);
  }

}
