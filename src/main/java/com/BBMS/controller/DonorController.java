package com.BBMS.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BBMS.model.BloodBank;
import com.BBMS.model.BloodDetails;
import com.BBMS.model.Donor;
import com.BBMS.model.enums.BloodType;
import com.BBMS.services.impl.DonorService;

@RestController
@RequestMapping("/donor")
public class DonorController {

	@Autowired
	private DonorService donorService;
	

	@GetMapping(path = "/sample")
	public Donor getSample() {
		return new Donor(1L,Arrays.asList(new BloodBank("test", "test")) , "test", "test", "test", "test", "test", BloodType.ONEGATIVE, "test", 19);
	}
	
	@GetMapping
	public ResponseEntity<Object> getDonors(){
		List<Donor> donors = donorService.getDonors();
		if(donors!=null) return new ResponseEntity<>(donors, HttpStatus.OK);
		return new ResponseEntity<>("Donors not available!", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path = "/{donorId}")
	public ResponseEntity<Object> getDonor(@PathVariable Long donorId) {
		Donor donor = donorService.getDonor(donorId);
		if(donor!=null) return new ResponseEntity<>(donor, HttpStatus.OK);
		return new ResponseEntity<>("Donor not found!", HttpStatus.NOT_FOUND);
	}
	@PostMapping(path = "/{donorId}/donate/{bloodBankId}")
	public ResponseEntity<Object> donate(@PathVariable Long donorId,@PathVariable Long bloodBankId) {
		BloodDetails donatedBlood = donorService.donate(donorId,bloodBankId);
		if(donatedBlood!=null) return new ResponseEntity<>(donatedBlood, HttpStatus.OK);
		return new ResponseEntity<>("Donor not found!", HttpStatus.NOT_FOUND);
	}

	@PostMapping(path = "/registeration")
	public ResponseEntity<Object> register(@RequestBody Donor donor) {
		Donor register = donorService.register(donor);
		if (register != null)
			return new ResponseEntity<>(register, HttpStatus.CREATED);
		return new ResponseEntity<>("Registeration has Failed!", HttpStatus.CREATED);
	}

	@PatchMapping(path = "/update/{donorId}")
	public ResponseEntity<Object> update(@PathVariable Long donorId,@RequestBody Donor donor) {
		Donor newDonorDetails = donorService.update(donorId,donor);
		if (newDonorDetails != null)
			return new ResponseEntity<>(newDonorDetails, HttpStatus.OK);
		return new ResponseEntity<>("Update has Failed!", HttpStatus.NOT_FOUND);
	}

	@PostMapping(path = "/login")
	public ResponseEntity<Object> login(@RequestBody Donor donor) {
		Donor login = donorService.login(donor);
		if (login != null)
			return new ResponseEntity<>(login, HttpStatus.OK);
		return new ResponseEntity<>("Login has Failed!", HttpStatus.UNAUTHORIZED);
	}

}
