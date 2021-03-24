package com.BBMS.services;

import java.util.List;

import com.BBMS.model.Seeker;
import com.BBMS.model.data.BloodBankData;
import com.BBMS.model.data.BloodRequestData;
import com.BBMS.model.enums.BloodType;

public interface ISeekerService {
	
	public List<BloodBankData> seekBlood(BloodType bloodType);
	public Seeker seekerExists(Long seekerId);
	public Seeker getAllSeekers();
	List<BloodRequestData> requestBlood(Seeker seeker, BloodType bloodType);
}
