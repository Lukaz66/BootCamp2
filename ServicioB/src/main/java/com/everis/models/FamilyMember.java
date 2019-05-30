package com.everis.models;

import com.everis.models.Family;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Proyecto: Clase para almacenar funciones útiles y variables necesarias. Esta
 * clase define las variables en el FamilyMember Table
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@Entity
@Table(name = "FAMILYMEMBER")
@Data
public class FamilyMember {

  /**
   * Lista de las variables utilizadas para generar la tabla FamilyMember. Utilice
   * la anotación ManyToOne para relacionar dos tablas (Family to FamilyMember).
   * ManyToOne: muchos miembros de familia pueden tener una familia. OneToOne: un
   * FamilyMember solo puede ser un Parent or Student.
   */
  @Id
  @Column(name = "FAMILY_MEMBER_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long familyMemberId;

  @JoinColumn(name = "FAMILY_ID", referencedColumnName = "FAMILY_ID")
  @ManyToOne
  private Family familyId;

  @Column(name = "PARENT_OR_STUDENT_MEMBER")
  private String parentOrStudentMember;

  @JoinColumn(name = "PARENT_ID", referencedColumnName = "PARENT_ID")
  @OneToOne
  private Parent parentId;

  @JoinColumn(name = "studentId", referencedColumnName = "studentId")
  @OneToOne
  private Student studentId;

}
