package com.BBMS.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.BBMS.model.enums.BloodType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Donor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donorId;

	@OneToMany(targetEntity = BloodBank.class)
	@JsonIgnore
	private List<BloodBank> bloodBank;
	
	private String name;
	private String email;
	private String password;
	private String contactNumber;
	private String address;
	private BloodType bloodGroup;
	private String gender;
	private int age;

}
