package com.everis.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.everis.models.Family;
import com.everis.models.FamilyMember;
import com.everis.repositories.IFamilyMemberRepo;
import com.everis.repositories.IFamilyRepo;
import com.everis.services.IFamilyService;

/** Project: Clase para generar el servicio implementar métodos de IFamilyService.
 * Esta clase define los métodos que realiza nuestro servicio.
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@Service
public class FamilyServiceImpl implements IFamilyService {

  /**
   * Los métodos son Autowired para la inyección de dependencia.
   * Validación de servicios con ResponceEntity
   * manejo de status del servicio.
   */
	@Autowired
	private IFamilyRepo familyRepo;
	
	@Autowired
	private IFamilyMemberRepo familyMemberRepo;
	
	@Override
	public List<Family> findAll() {
		return familyRepo.findAll();
	}

	@Override
	public ResponseEntity<Family> save(Family family) {

		if (familyRepo.findById(family.getFamilyId()) == null) {
			familyRepo.save(family);
			return new ResponseEntity<Family>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Family>(HttpStatus.METHOD_NOT_ALLOWED);
		}
		
	}
	
	@Override
	public ResponseEntity<Family> update(Family family) {

		if (familyRepo.findById(family.getFamilyId()) != null) {
			familyRepo.save(family);
			return new ResponseEntity<Family>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Family>(HttpStatus.NOT_FOUND);
		}
		
	}

	@Override
	public void delete(Long id) {
		familyRepo.deleteById(id);
	}	

	@Override
	public List<FamilyMember> findById(Long id) {
		return familyMemberRepo.findByFamilyIdFamilyId(id);		
	}	

}
