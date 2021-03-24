package com.BBMS.model.data;

import java.io.Serializable;

import javax.persistence.Convert;

import com.BBMS.converter.BloodBankDataConverter;
import com.BBMS.model.enums.BloodType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Convert(converter = BloodBankDataConverter.class)
public class BloodBankData implements Serializable {
	
	private int count;
	private BloodType bloodType;
	private String bloodBankName;
	private String bloodBankAddress;
	
}
