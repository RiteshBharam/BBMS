package com.BBMS.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BBMS.model.Donor;

@Service
public interface IDonorService {
	public Donor register(Donor donor);
	public Donor login(Donor donor);
	public List<Donor> getDonors();
	public Donor update(Long donorId, Donor donor);
}
