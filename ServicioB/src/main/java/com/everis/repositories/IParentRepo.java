package com.everis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.models.Parent;

/** Proyecto: Interfaz para generar el repositorio heredado de un modelo.
 * Esta interfaz define las herencias con JpaRepository.
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@Repository
public interface IParentRepo extends JpaRepository<Parent, Long> {

	/**
	 * 
	 * @param id obtiene el id de Parent.
	 * @return lista por el id dado.
	 */
	public Parent findById(long id);
}
