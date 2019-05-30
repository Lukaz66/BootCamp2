package com.everis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Proyecto: Clase para almacenar funciones útiles y variables necesarias. Esta
 * clase define las variables en el Family Table
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@Entity
@Table(name = "FAMILIES")
@Data
public class Family {

  /**
   * Lista de las variables utilizadas para generar el Family table. Use la
   * anotación OneToOne, para asociarse con una columna de clave externa. (Head of
   * Family to Parent), para definir a la cabeza de la familia con Parent ID. Use
   * la anotación OneToMany para especificar una relación con una colección de
   * entidades.
   */
  @Id
  @Column(name = "FAMILY_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long familyId;

  @Column(name = "FAMILY_NAME", length = 50)
  private String familyName;

  @JoinColumn(name = "HEAD_OF_FAMILY", referencedColumnName = "PARENT_ID")
  @OneToOne
  private Parent headOfFamily;

  @JsonIgnore
  @OneToMany(mappedBy = "familyId")
  private List<FamilyMember> familyMembers;

}
