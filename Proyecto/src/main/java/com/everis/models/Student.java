package com.everis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Proyecto: Clase para almacenar funciones útiles y variables necesarias. Esta
 * clase define las variables en el Class Student
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 27/05/2019
 * @since V 1.0
 */
@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  /**
   * Declaracion de las columnas de la tabla.
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

}
