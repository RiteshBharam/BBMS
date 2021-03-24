package com.BBMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BBMS.model.Seeker;
import com.BBMS.model.data.BloodBankData;
import com.BBMS.model.data.BloodRequestData;
import com.BBMS.model.enums.BloodType;
import com.BBMS.services.impl.SeekerService;

@RestController
@RequestMapping("/request")
public class SeekerController {

	@Autowired
	private SeekerService service;

	@GetMapping("/sample")
	public ResponseEntity<Object> sample() {
		return new ResponseEntity<>(new Seeker(), HttpStatus.OK);

	}

	@GetMapping("/inventory/{bloodType}")
	public ResponseEntity<Object> seekBlood(@PathVariable BloodType bloodType) {
		List<BloodBankData> seekBlood = service.seekBlood(bloodType);
		if (seekBlood != null)
			return new ResponseEntity<>(seekBlood, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/blood/{bloodType}")
	public ResponseEntity<Object> requestBlood(@RequestBody Seeker seeker,@PathVariable BloodType bloodType) {
		List<BloodRequestData> seekBlood = service.requestBlood(seeker,bloodType);
		if (seekBlood != null)
			return new ResponseEntity<>(seekBlood, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
