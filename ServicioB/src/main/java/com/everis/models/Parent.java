package com.everis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * Proyecto: Clase para almacenar funciones útiles y variables necesarias. Esta
 * clase define las variables en el Parent Table
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@Entity
@Table(name = "PARENTS")
@Data
public class Parent {

  /**
   * Lista de las variables utilizadas para generar el Parent table. Use la
   * anotación ManyToMany para relacionar dos tablas (Parent to Student).
   */
  @Id
  @Column(name = "PARENT_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long parentId;

  @Column(name = "GENDER", length = 1)
  private String gender;

  @Column(name = "FIRST_NAME", length = 50)
  private String firstName;

  @Column(name = "MIDDLE_NAME", length = 50)
  private String middleName;

  @Column(name = "LAST_NAME", length = 50)
  private String lastName;

  @Column(name = "OTHER_PARENT_DETAIL", length = 50)
  private String otherParentDetail;

  @JsonIgnore
  @ManyToMany(mappedBy = "parents", cascade = CascadeType.PERSIST)
  private Set<Student> students;

}
