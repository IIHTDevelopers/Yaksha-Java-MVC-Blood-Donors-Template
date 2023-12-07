package com.yaksha.training.blooddonors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaksha.training.blooddonors.entity.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {

	// please update this method as per requirement
	Object findByStateAndCity(String searchKey);
}
