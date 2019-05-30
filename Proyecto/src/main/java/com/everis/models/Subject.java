package com.everis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Proyecto: Clase para almacenar funciones útiles y variables necesarias. Esta
 * clase define las variables en el Subject Table
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 27/05/2019
 * @since V 1.0
 */

@Entity
@Table(name = "subject")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

  /**
   * Declaracion de las variables.
   */
  @Id
  @Column(name = "subjectId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int subjectId;

  @Column(name = "subjectName", length = 50)
  private String subjectName;

  @JsonIgnore
  @Column(name = "deleteStatus")
  private int deleteStatus = 0;

  @JsonIgnore
  @OneToMany(mappedBy = "subject")
  private List<Class> clas;

}
