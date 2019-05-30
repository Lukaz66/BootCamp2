package com.everis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.models.FamilyMember;

/** Proyecto: Interfaz para generar el repositorio heredado de un modelo.
 * Esta interfaz define las herencias con JpaRepository.
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@Repository
public interface IFamilyMemberRepo extends JpaRepository<FamilyMember, Long> {

	/**
	 * 
	 * @param id obtiene el id de FamilyMember.
	 * @return lista por el id dado.
	 */
	public FamilyMember findById(long id);
	
	/**
	 * 
	 * @param id obtiene la lista FamilyMember por FamilyId
	 * @return Listar todos los miembros de la familia por el FamilyId dado.
	 */
	public List<FamilyMember> findByFamilyIdFamilyId(long id);
	
}
