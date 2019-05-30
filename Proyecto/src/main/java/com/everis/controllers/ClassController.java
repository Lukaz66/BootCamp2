package com.everis.controllers;

import com.everis.models.Class;
import com.everis.services.IClassService;

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
@RequestMapping("api/v1.0/classes")
@Api(tags = "CRUD de Datos Class")
@Log
public class ClassController {

  @Autowired
  private IClassService classService;

  @ApiOperation(value = "Lista de Class")
  @GetMapping
  public List<Class> findAll() {
    log.info("Las Clases Fueron Listadas");
    return classService.findAll();
  }

  /**
   * Metodo para una busqueda por el Id.
   * 
   * @param id
   *          Lista el Class onteniendo el id.
   * @return retorna el Class por el id solicitado.
   */
  @ApiOperation(value = "Buscador de Class por Id")
  @GetMapping(value = "/{id}")
  public ResponseEntity<Class> findById(@PathVariable("id") int id) {
    if (classService.findById(id) != null) {
      log.info("Una Clase Fue Buscada");
      classService.findById(id);
      return new ResponseEntity<Class>(classService.findById(id), HttpStatus.OK);
    } else {
      return new ResponseEntity<Class>(classService.findById(id), HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Metodo para insertar un nuevo Class.
   * 
   * @param cla
   *          guarda el nuevo campo en el servicio cla
   */
  @ApiOperation(value = "Insertar Class")
  @PostMapping
  public ResponseEntity<Class> save(@RequestBody Class cla) {
    return new ResponseEntity<Class>(classService.save(cla),HttpStatus.CREATED);
  }

  /**
   * Metodo para actualizar un Class existente.
   * 
   * @param cla
   *          guarda el nuevo campo en el servicio cla
   */
  @ApiOperation(value = "Actualizar Class")
  @PutMapping
  public ResponseEntity<Class> update(@RequestBody Class cla) {
    return new ResponseEntity<Class>(classService.update(cla),HttpStatus.NO_CONTENT);
  }

  /**
   * Metodo PACTH para modificar un dato de Class.
   * 
   * @param id
   *          Busca el campo por el id de Class
   * @param fields
   *          Obtiene el campo y lo modifica por uno nuevo
   */
  @ApiOperation(value = "Actualizar Class por Campo")
  @PatchMapping(value = "/{id}")
  public ResponseEntity<Class> patch(@PathVariable("id") int id,
      @RequestBody Map<String, Object> fields) {
    Class clas = classService.findById(id);
    fields.forEach((k, v) -> {
      Field field = ReflectionUtils.findRequiredField(Class.class, k);
      field.setAccessible(true);
      ReflectionUtils.setField(field, clas, v);
    });

    return new ResponseEntity<Class>(classService.patch(clas),HttpStatus.NO_CONTENT);
  }

  /**
   * Eliminacion Logica obtenida por el id solicitado.
   * 
   * @param id
   *          obtiene el id de un Class existente para cambiar el status 0 o 1;
   */
  @ApiOperation(value = "Eliminar Class")
  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable("id") int id) {
    log.warning("Se Elimino una Clase");
    classService.softDelete(id);
  }

}
