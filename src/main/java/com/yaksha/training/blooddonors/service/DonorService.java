package com.yaksha.training.blooddonors.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yaksha.training.blooddonors.entity.Donor;

@Service
public class DonorService {

	public List<Donor> getDonors() {
		// write your logic here
		return null;
	}

	public Donor saveDonor(Donor donor) {
		// write your logic here
		return null;
	}

	public Donor getDonor(Long id) {
		// write your logic here
		return null;
	}

	public boolean deleteDonor(Long id) {
		// write your logic here
		return false;
	}

	public Page<Donor> searchDonors(String theSearchName, Pageable pageable) {
		// write your logic here
		return null;
	}
}
