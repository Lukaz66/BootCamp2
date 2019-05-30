package com.everis.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Proyecto: Clase para almacenar funciones útiles y variables necesarias. Esta
 * clase define las variables del PKStudentClass
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 27/05/2019
 * @since V 1.0
 */
@Embeddable
public class PkStudentClass implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * Implementando las anotaciones del ManyToOne y JoinColumn.
   */
  @ManyToOne
  @JoinColumn(name = "studentId", nullable = true)
  private Student student;

  @ManyToOne
  @JoinColumn(name = "classId", nullable = true)
  private Class classes;

  @Column(name = "dateFrom")
  private String dateFrom;

}
