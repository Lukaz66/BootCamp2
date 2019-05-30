package com.everis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.everis.models.Student;

/** Proyecto: Interfaz para generar el repositorio heredado de un modelo.
 * Esta interfaz define las herencias con JpaRepository.
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@Repository
public interface IStudentRepo extends JpaRepository<Student, Integer> {

	/**
	 * 
	 * @param id obtiene el id de student.
	 * @return lista por el id dado.
	 */	
	public Student findById(int id);
	
	@Query("select s from Student s where s.studentId IN :listStudentById")
	List<Student> findAllById(List<Integer> listStudentById);
}
