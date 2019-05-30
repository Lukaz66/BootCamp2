package com.everis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Proyecto: Clase para almacenar funciones útiles y variables necesarias. Esta
 * clase define las variables en el StudentClass Table
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 27/05/2019
 * @since V 1.0
 */

@Entity
@Table(name = "studentClass")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(PkStudentClass.class)
public class StudentClass {

  /**
   * Declaracion de las columnas.
   */
  @Id
  private String dateFrom;

  @Id
  private Student student;

  @Id
  private Class classes;

  @Column(name = "dateTo", length = 50)
  private String dateTo;

  @JsonIgnore
  @Column(name = "deleteStatus")
  private int deleteStatus = 0;

}
