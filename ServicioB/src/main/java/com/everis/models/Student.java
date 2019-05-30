package com.everis.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Proyecto: Clase para almacenar funciones útiles y variables necesarias. Esta
 * clase define las variables en el Student Table
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */

@Entity
@Table(name = "student")
@Data
public class Student {

  /**
   * Lista de las variables utilizadas para generar el Student table. Use la
   * anotación ManyToMany para relacionar dos tablas (Student to Parent). Generar
   * la tabla Student_Parent a través de la persistencia JoinTable.
   */

  @Id
  @Column(name = "studentId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int studentId;

  @Column(name = "gender", length = 1)
  private String gender;

  @Column(name = "firstName", length = 50)
  private String firstName;

  @Column(name = "middleName", length = 50)
  private String middleName;

  @Column(name = "lastName", length = 50)
  private String lastName;

  @Column(name = "dateOfBirth", length = 50)
  private String dateOfBirth;

  @Column(name = "otherStudentDetail", length = 50)
  private String otherStudentDetail;

  @JsonIgnore
  @ManyToMany
  @JoinTable(name = "STUDENT_PARENTS", joinColumns = @JoinColumn(name = "studentId",
      referencedColumnName = "studentId"), inverseJoinColumns = @JoinColumn(name = "PARENT_ID", 
      referencedColumnName = "PARENT_ID"))
  private Set<Parent> parents;

}
