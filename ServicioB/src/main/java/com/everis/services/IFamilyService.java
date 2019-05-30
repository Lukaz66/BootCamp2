package com.everis.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.everis.models.Family;
import com.everis.models.FamilyMember;

/** Project: Interfaz para generar los métodos de servicio de IFamilyService.
 * Esta interfaz define los métodos que realiza nuestro servicio.
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@Service
public interface IFamilyService {
	
	/**
	 * Método para obtener la lista de Family con FamilyMember por ID
	 * @param id obtiene el Id de un miembro de familia
	 * @return family.findById(id) la lista de la familia con sus miembros de familia.
	 */
	List<FamilyMember> findById(Long id);

	/**
	 * Metodo para obtener la lista de la Familia
	 * @return family.findAll() lista de todas las familias
	 */
	List<Family> findAll();

	/**
	 * Metodo para insertar una nueva Familia
	 * @param family es almacenada en el modelo. 
	 * @return family.save(fam) nuevo objeto insertado.
	 */
	ResponseEntity<Family> save(Family family);
	
	/**
	 * Metodo para actualizar una familia existente.
	 * @param Family es para actualizar un objeto existente del modelo.
	 * @return family.save(fam) Familia actualizada.
	 */
	ResponseEntity<Family> update(Family family);
	
	/**
	 * Metodo para eliminar una familia existente.
	 * @param id es para eliminar un objeto del modelo existente por el Id.
	 */
	void delete(Long id);
	
}
