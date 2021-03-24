package com.BBMS.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.BBMS.model.enums.BloodType;
import com.BBMS.model.enums.RequestStatus;
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
public class Seeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seekerId;

	@OneToOne(targetEntity = BloodBank.class)
	@JsonIgnore
	private BloodBank bloodBank;
	private String name;
	private String email;
	private String contactNumber;
	private String address;
	private String reason;
	private BloodType bloodGroup;
	private int quantity;
	private Date dateRequested;
	private RequestStatus requestStatus;
}
