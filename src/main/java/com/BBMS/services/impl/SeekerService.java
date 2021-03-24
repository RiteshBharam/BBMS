package com.BBMS.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BBMS.model.BloodDetails;
import com.BBMS.model.Seeker;
import com.BBMS.model.data.BloodBankData;
import com.BBMS.model.data.BloodRequestData;
import com.BBMS.model.enums.BloodType;
import com.BBMS.repository.BloodDetailsRepository;
import com.BBMS.repository.SeekerRepository;
import com.BBMS.services.ISeekerService;

@Service
public class SeekerService implements ISeekerService {

	@Autowired
	private SeekerRepository seekerRepository;

	@Autowired
	private BloodDetailsRepository bloodDetailsRepository;

	@Override
	public List<BloodBankData> seekBlood(BloodType bloodType) {

		String seperator = ",";
		List<String> details = seekerRepository.seekBlood(bloodType.ordinal());
		List<BloodBankData> dataSet = new ArrayList<>();
		for (String bloodData : details) {
			System.out.println(bloodData);
			String[] strings = bloodData.split(seperator);
			BloodBankData bankData = new BloodBankData(Integer.parseInt(strings[0]),
					BloodType.values()[Integer.parseInt(strings[1])], strings[2], strings[3]);
			dataSet.add(bankData);
		}
		return dataSet;
	}

	@Override
	public Seeker seekerExists(Long seekerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seeker getAllSeekers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BloodRequestData> requestBlood(Seeker seeker, BloodType bloodType) {
		List<BloodRequestData> data = new ArrayList<>();
		int quantity = seeker.getQuantity();
		seekerRepository.save(seeker);
		for (int i = 0; i < quantity; i++) {
			String data1 = seekerRepository.requestBlood(bloodType.ordinal());
			if (data1 != null) {
				String[] requestBlood = data1.split(",");
				long bloodId = Long.parseLong(requestBlood[0]);
				BloodRequestData requestData = new BloodRequestData(bloodId, requestBlood[1],
						Long.parseLong(requestBlood[2]), requestBlood[3], Integer.parseInt(requestBlood[4]));
				BloodDetails bloodDetails = bloodDetailsRepository.findById(bloodId).get();
				bloodDetails.setSeeker(seeker);
				bloodDetailsRepository.save(bloodDetails);
				data.add(requestData);
			}
		}
		return data;
	}

}
