package com.everis.services.impl;

import com.everis.models.Parent;
import com.everis.repositories.IParentRepo;
import com.everis.services.IParentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/**
 * Project: Clase para generar el servicio implementar métodos de
 * IParentService. Esta clase define los métodos que realiza nuestro servicio.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@Service
public class ParentServiceImpl implements IParentService {

  /**
   * El método debe ser Autowired para la inyección de dependencia. Validación de
   * servicios con ResponceEntity manejo de status del servicio.
   */
  @Autowired
  private IParentRepo parentRepo;

  @Override
  public List<Parent> findAll() {
    return parentRepo.findAll();
  }

  @Override
  public ResponseEntity<Parent> save(Parent parent) {
    if (parentRepo.findById(parent.getParentId()) == null) {
      parentRepo.save(parent);
      return new ResponseEntity<Parent>(HttpStatus.CREATED);
    } else {
      return new ResponseEntity<Parent>(HttpStatus.METHOD_NOT_ALLOWED);
    }
  }

  @Override
  public ResponseEntity<Parent> update(Parent parent) {
    if (parentRepo.findById(parent.getParentId()) != null) {
      parentRepo.save(parent);
      return new ResponseEntity<Parent>(HttpStatus.OK);
    } else {
      return new ResponseEntity<Parent>(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public void delete(Long id) {
    parentRepo.deleteById(id);
  }

}
