package com.BBMS.converter;

import java.util.Arrays;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.BBMS.model.data.BloodBankData;
import com.BBMS.model.enums.BloodType;

import lombok.extern.slf4j.Slf4j;

@Converter
@Slf4j
public class BloodBankDataConverter implements AttributeConverter<BloodBankData, String> {

	@Override
	public String convertToDatabaseColumn(BloodBankData attribute) {
		return attribute.toString();
	}

	@Override
	public BloodBankData convertToEntityAttribute(String dbData) {
		String seperator = ",";

		String[] split = dbData.split(seperator);
		BloodBankData bloodBankData = 
				new BloodBankData(Integer.parseInt(split[0]),BloodType.getEnumName(Integer.parseInt(split[1])),"","");
		// Arrays.asList(dbData.split(seperator)).stream().forEach(action->
		// log.warn(action.trim()));
		return bloodBankData;
	}

}
