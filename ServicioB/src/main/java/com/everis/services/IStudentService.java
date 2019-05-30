package com.everis.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.everis.models.Student;

/**
 * Project: Interfaz para generar los métodos de servicio de IStudentService.
 * Esta interfaz define los métodos que realiza nuestro servicio.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@Service
public interface IStudentService {

  /**
   * Metodo para obtener la lista de Student
   * 
   * @return studentService.findAll() lista de todos los student
   */
  List<Student> findAll();

  /**
   * Metodo para insertar un nuevo Student
   * 
   * @param Student es almacenada en el modelo.
   * @return studentService.save(stu) nuevo objeto insertado.
   */
  ResponseEntity<Student> save(Student student);

  /**
   * Metodo para actualizar un student existente.
   * 
   * @param student es para actualizar un objeto existente del modelo.
   * @return studentService.save(stu) Student actualizado.
   */
  ResponseEntity<Student> update(Student student);

  /**
   * Metodo para eliminar un student existente.
   * 
   * @param id es para eliminar un objeto del modelo existente por el Id.
   */
  void delete(int id);

  /**
   * Metodo para buscar un Student por Id
   * @return Student Long id lista de un solo Student.
   */
  Student findById(int id);
  
  List<Student> findAllById(List<Integer> listStudentById);
}
