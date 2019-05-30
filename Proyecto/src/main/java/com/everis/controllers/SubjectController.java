package com.everis.controllers;

import com.everis.models.Subject;
import com.everis.services.ISubjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class donde se implementa el rest controller para desarrollar los endpoints.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 27/05/2019
 * @since V 1.0
 *
 */

@RestController
@RequestMapping("api/v1.0/subjects")
@Api(tags = "CRUD de Datos Subject")
@Log
public class SubjectController {

  @Autowired
  private ISubjectService subjectService;

  /**
   * Metodo para listar todos los Subjects.
   * 
   * @return lista de Subjects
   */
  @ApiOperation(value = "Lista de Subject")
  @GetMapping
  public List<Subject> findAll() {
    log.info("Los Subjects Fueron Listados");
    return subjectService.findAll();
  }

  /**
   * Metodo para buscar in Subject por el Id.
   * 
   * @param id
   *          permite la busqueda por el id seleccionado
   * @return devuelve el Subject por el Id
   */
  @ApiOperation(value = "Buscar Subject por Id")
  @GetMapping(value = "/{id}")
  public ResponseEntity<Subject> findById(@PathVariable("id") int id) {
    if (subjectService.findById(id) != null) {
      log.info("Un Subject Fue Buscado");
      subjectService.findById(id);
      return new ResponseEntity<Subject>(subjectService.findById(id),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<Subject>(subjectService.findById(id),
          HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Metodo para insertar un nuevo Subject.
   * 
   * @param sub
   *          variable para almacenar el nuevo Subject
   */
  @ApiOperation(value = "Insertar Subject")
  @PostMapping
  public ResponseEntity<Subject> save(@RequestBody Subject sub) {
    return new ResponseEntity<Subject>(subjectService.save(sub),
        HttpStatus.CREATED);
  }

  /**
   * Metodo para actualizar un Subject.
   * 
   * @param sub
   *          variable para actualizar el Subject
   */
  @ApiOperation(value = "Actualizar Subject")
  @PutMapping
  public ResponseEntity<Subject> update(@RequestBody Subject sub) {
    return new ResponseEntity<Subject>(subjectService.update(sub),
        HttpStatus.NO_CONTENT);
  }

  /**
   * Metodo PATCH para modificar un campo de un Subject.
   * 
   * @param id
   *          busca el campo por el id
   * @param fields
   *          remplaza el campo por uno nuevo
   */
  @ApiOperation(value = "Actualizar Subject por Campo")
  @PatchMapping(value = "/{id}")
  public ResponseEntity<Subject> patch(@PathVariable("id") int id,
      @RequestBody Map<String, Object> fields) {
    Subject subject = subjectService.findById(id);
    fields.forEach((k, v) -> {
      Field field = ReflectionUtils.findRequiredField(Subject.class, k);
      field.setAccessible(true);
      ReflectionUtils.setField(field, subject, v);
    });

    return new ResponseEntity<Subject>(subjectService.patch(subject),
        HttpStatus.NO_CONTENT);

  }

  /**
   * Metodo para la eliminacion logica.
   * 
   * @param id
   *          cambia el status de la tabla cuando se elimina el Subject, lo
   *          desabilita.
   * 
   */
  @ApiOperation(value = "Eliminar Subject")
  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable("id") int id) {
    log.warning("Un Subject Fue Eliminado");
    subjectService.softdelete(id);
  }

}
