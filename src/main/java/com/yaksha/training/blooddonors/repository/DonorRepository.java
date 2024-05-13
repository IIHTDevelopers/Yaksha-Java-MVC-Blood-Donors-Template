package com.yaksha.training.blooddonors.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.yaksha.training.blooddonors.entity.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {

	// feel free to update this
	Page<Donor> findByStateAndCityAndBloodGroup(@Param("keyword") String keyword, Pageable pageable);

}
