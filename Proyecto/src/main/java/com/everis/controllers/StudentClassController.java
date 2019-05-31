package com.everis.controllers;

import com.everis.feign.StudentClient;
import com.everis.models.Class;
import com.everis.models.Student;
import com.everis.models.StudentClass;
import com.everis.models.dtoprojection.StudentDto;
import com.everis.services.IClassService;
import com.everis.services.IStudentClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("api/v1.0/studentClasses")
@Api(tags = "CRUD de Datos StudentClass")
@Log
public class StudentClassController {

  @Autowired
  private IStudentClassService studentClassService;

  @Autowired
  private StudentClient studentClient;

  @Autowired
  private IClassService classService;

  @Autowired
  private StudentDto studentDto;

  List<Student> listStudent = new ArrayList<Student>();

  List<Integer> listStudentIds = new ArrayList<Integer>();

  Class clas = new Class();

  /**
   * Listar toda la lista de los StudentClass.
   * 
   * @return una lista con los StudentClass
   */
  @ApiOperation(value = "Lista de StudentClass")
  @GetMapping
  public List<StudentClass> findAll() {
    log.info("Los StudentClass fueron Listados");
    return studentClassService.findAll();
  }

  @GetMapping("/ids")
  public List<Integer> findIdStudentByClassId(@RequestBody Integer id) {
    return studentClassService.findIdStudentByClassId(id);
  }

  /**
   * Metodo para listar una classId con los students.
   * @param classId valor entero.
   * @return lista del classId con los students.
   */
  @GetMapping("/ids/{classId}")
  public StudentDto findAllStudentByClassId(@PathVariable Integer classId) {
    listStudentIds = (List<Integer>) findIdStudentByClassId(classId);
    log.info("Los students por ids se listaron");
    try {
      listStudent = (List<Student>) studentClient.getAllById(listStudentIds);
    } catch (Exception e) {
      e.printStackTrace();
    }

    clas = classService.findById(classId);
    studentDto.setClassId(clas.getClassId());
    studentDto.setClassCode(clas.getClassCode());
    studentDto.setClassName(clas.getClassName());
    studentDto.setSubject(clas.getSubject());
    studentDto.setTeacher(clas.getTeacher());
    studentDto.setDateFrom(clas.getDateFrom());
    studentDto.setDateTo(clas.getDateTo());
    studentDto.setListStudentsDto(listStudent);
    return studentDto;
  }

  /**
   * Metodo para almacenar un nuevo StudentClass.
   * 
   * @param stucl
   *          variable donde se va a almacenar el nuevo campo
   */
  @ApiOperation(value = "Insertar StudentClass")
  @PostMapping
  public ResponseEntity<StudentClass> save(@RequestBody StudentClass stucl) {
    return new ResponseEntity<StudentClass>(studentClassService.save(stucl),
        HttpStatus.CREATED);
  }

  /**
   * Eliminacion Logica para el campo de StudentClass.
   * 
   * @param id
   *          obtiene el id por un String de la Fecha.
   */
  @ApiOperation(value = "Eliminacion de Class")
  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable("id") String id) {
    log.warning("Un StudentClass fue Eliminado");
    studentClassService.softdelete(id);
  }

}
