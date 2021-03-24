package com.BBMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BBMS.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
