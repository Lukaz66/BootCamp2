package com.everis.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.everis.models.Student;
import com.everis.repositories.IStudentRepo;
import com.everis.services.IStudentService;

/**
 * Project: Clase para generar el servicio implementar métodos de
 * IStudentService. Esta clase define los métodos que realiza nuestro servicio.
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@Service
public class StudentServiceImpl implements IStudentService {

	/**
	 * El método debe ser Autowired para la inyección de dependencia. Validación de
	 * servicios con ResponceEntity manejo de status del servicio.
	 */
	@Autowired
	private IStudentRepo studentRepo;

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public ResponseEntity<Student> save(Student student) {
		if (studentRepo.findById(student.getStudentId()) == null) {
			studentRepo.save(student);
			return new ResponseEntity<Student>(student, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Student>(HttpStatus.METHOD_NOT_ALLOWED);
		}
	}

	@Override
	public ResponseEntity<Student> update(Student student) {
		if (studentRepo.findById(student.getStudentId()) != null) {
			studentRepo.save(student);
			return new ResponseEntity<Student>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void delete(int id) {
		studentRepo.deleteById(id);
	}

	@Override
	public Student findById(int id) {
		return studentRepo.findById(id);
	}

	@Override
	public List<Student> findAllById(List<Integer> listStudentById) {
		return studentRepo.findAllById(listStudentById);
	}

}
