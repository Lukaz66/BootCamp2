package com.everis.services.impl;

import com.everis.models.FamilyMember;
import com.everis.repositories.IFamilyMemberRepo;
import com.everis.services.IFamilyMemberService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Project: Clase para generar el servicio implementar métodos de IFamilyMemberService.
 * Esta clase define los métodos que realiza nuestro servicio.
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@Service
public class FamilyMemberServiceImpl implements IFamilyMemberService {

  /**
   * El método debe ser Autowired para la inyección de dependencia.
   * Validación de servicios con ResponceEntity
   * manejo de status del servicio.
   */	
  @Autowired
  private IFamilyMemberRepo familyMemberRepo;

  @Override
  public List<FamilyMember> findAll() {
    return familyMemberRepo.findAll();
  }

	@Override
	public ResponseEntity<FamilyMember> save(FamilyMember familyMember) {
	
		if (familyMemberRepo.findById(familyMember.getFamilyMemberId()) == null) {
			familyMemberRepo.save(familyMember);
			return new ResponseEntity<FamilyMember>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<FamilyMember>(HttpStatus.METHOD_NOT_ALLOWED);
		}
		
	}

	@Override
	public ResponseEntity<FamilyMember> update(FamilyMember familyMember) {
		if (familyMemberRepo.findById(familyMember.getFamilyMemberId()) != null) {
			familyMemberRepo.save(familyMember);
			return new ResponseEntity<FamilyMember>(HttpStatus.OK);
		} else {
			return new ResponseEntity<FamilyMember>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void delete(Long id) {
		familyMemberRepo.deleteById(id);
	}

	
}
