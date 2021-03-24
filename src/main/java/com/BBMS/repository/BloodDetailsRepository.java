package com.BBMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BBMS.model.BloodDetails;

@Repository
public interface BloodDetailsRepository extends JpaRepository<BloodDetails, Long> {

	@Query(value="select bd Blood_Details bd where blood_Group=?1 and blood_Id="
			+ "(Select MIN(blood_Id) from Blood_Details bd where blood_group=?1)",nativeQuery = true)
	BloodDetails allocateBlood(int ordinal);
	
}
