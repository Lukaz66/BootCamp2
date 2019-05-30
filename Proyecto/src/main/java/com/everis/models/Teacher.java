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
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Proyecto: Clase para almacenar funciones útiles y variables necesarias. Esta
 * clase define las variables en el Teacher Table
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 27/05/2019
 * @since V 1.0
 */

@Entity
@Table(name = "teacher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

  /**
   * Declaracion de las Variables. Uso de OneToMany
   */
  @Id
  @Column(name = "teacherId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int teacherId;

  @Column(name = "schoolName")
  @Size(min = 5, max = 20)
  private String schoolName;

  @Column(name = "gender", length = 1)
  private String gender;

  @Column(name = "firstName", length = 50)
  @Size(min = 5, max = 20)
  private String firstName;

  @Column(name = "middleName")
  @Size(min = 5, max = 20)
  private String middleName;

  @Column(name = "lastName")
  @Size(min = 5, max = 20)
  private String lastName;

  @Column(name = "otherTeacherDetail")
  @Size(min = 5, max = 30)
  private String otherTeacherDetail;

  @JsonIgnore
  @Column(name = "deleteStatus")
  private int deleteStatus = 0;

  @JsonIgnore
  @OneToMany(mappedBy = "teacher")
  private List<Class> clas;

}
