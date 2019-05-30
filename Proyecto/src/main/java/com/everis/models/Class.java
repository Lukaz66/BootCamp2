package com.everis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Proyecto: Clase para almacenar funciones útiles y variables necesarias. Esta
 * clase define las variables en el Class Table
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 27/05/2019
 * @since V 1.0
 */

@Entity
@Table(name = "class")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Class {

  /**
   * Lista de las variables utilizadas para generar el Class table.
   * Implementacion del lombook
   *
   * 
   */

  @Id
  @Column(name = "classId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int classId;

  @Column(name = "classCode", length = 5)
  private String classCode;

  @Column(name = "className", length = 50)
  private String className;

  @Column(name = "dateFrom", length = 50)
  private String dateFrom;

  @Column(name = "dateTo", length = 50)
  private String dateTo;

  @JsonIgnore
  @Column(name = "deleteStatus")
  private int deleteStatus = 0;

  @JoinColumn(name = "subjectId", referencedColumnName = "subjectId")
  @ManyToOne
  private Subject subject;

  @JoinColumn(name = "teacherId", referencedColumnName = "teacherId")
  @ManyToOne
  private Teacher teacher;

  @JsonIgnore
  @OneToMany(mappedBy = "classes")
  private List<StudentClass> studentClass;

}
