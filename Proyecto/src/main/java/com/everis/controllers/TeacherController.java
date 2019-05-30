package com.everis.controllers;

import com.everis.models.Teacher;
import com.everis.services.ITeacherService;

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
@RequestMapping("api/v1.0/teachers")
@Api(tags = "CRUD de Datos Teacher")
@Log
public class TeacherController {

  @Autowired
  private ITeacherService teacherService;

  /**
   * Metodo para listar los Teachers.
   * 
   * @return lista de todos los Teachers
   */
  @ApiOperation(value = "Lista de Teacher")
  @GetMapping
  public List<Teacher> findAll() {
    log.info("Los Teachers Fueron Listados");
    return teacherService.findAll();
  }

  /**
   * Metodo para buscar el Subject por el Id.
   * 
   * @param id
   *          variable para identificar el id
   * @return el subject por el id indicado
   */
  @ApiOperation(value = "Buscador de Teacher por Id")
  @GetMapping(value = "/{id}")
  public ResponseEntity<Teacher> findById(@PathVariable("id") int id) {
    if (teacherService.findById(id) != null) {
      log.info("Un Teacher Fue Buscado");
      teacherService.findById(id);
      return new ResponseEntity<Teacher>(teacherService.findById(id),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<Teacher>(teacherService.findById(id),
          HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Metodo para insertar un nuevo Teacher.
   * 
   * @param tec
   *          variable para almacenar el nuevo Teacher
   */
  @ApiOperation(value = "Insertar Teacher")
  @PostMapping
  public ResponseEntity<Teacher> save(@RequestBody Teacher tec) {
    return new ResponseEntity<Teacher>(teacherService.save(tec),
        HttpStatus.CREATED);
  }

  /**
   * Metodo para actualizar el Teacher.
   * 
   * @param tec
   *          obtiene el campo y lo actualiza.
   */
  @ApiOperation(value = "Actualizar Teacher")
  @PutMapping
  public ResponseEntity<Teacher> update(@RequestBody Teacher tec) {
    return new ResponseEntity<Teacher>(teacherService.update(tec), HttpStatus.NO_CONTENT);
  }

  /**
   * Metodo PATCH para modificar un campo de un Teacher.
   * 
   * @param id
   *          busca el campo por el id
   * @param fields
   *          remplaza el campo por uno nuevo
   */
  @ApiOperation(value = "Actualizar Teacher por Campo")
  @PatchMapping(value = "/{id}")
  public ResponseEntity<Teacher> patch(@PathVariable("id") int id,
      @RequestBody Map<String, Object> fields) {
    Teacher teacher = teacherService.findById(id);
    fields.forEach((k, v) -> {
      Field field = ReflectionUtils.findRequiredField(Teacher.class, k);
      field.setAccessible(true);
      ReflectionUtils.setField(field, teacher, v);
    });

    return new ResponseEntity<Teacher>(teacherService.patch(teacher), HttpStatus.NO_CONTENT);
  }

  /**
   * Metodo para la implementacion de la eliminacion logica.
   * 
   * @param id
   *          obtiene el id del Teacher con los campos y lo desabilita para que
   *          no sea listado.
   */
  @ApiOperation(value = "Eliminar Teacher")
  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable("id") int id) {
    log.warning("Un Teacher Fue Eliminado");
    teacherService.softDelete(id);
  }

}
