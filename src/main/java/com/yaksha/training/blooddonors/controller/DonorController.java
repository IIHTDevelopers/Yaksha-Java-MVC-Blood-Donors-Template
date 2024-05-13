package com.yaksha.training.blooddonors.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaksha.training.blooddonors.entity.Donor;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = { "/donor", "/" })
public class DonorController {

	@GetMapping(value = { "/list", "/", "/search" })
	public String listDonors(@RequestParam(value = "theSearchName", required = false) String theSearchName,
			@PageableDefault(size = 5) Pageable pageable, Model theModel) {
		// write your logic here
		return "";
	}

	@GetMapping("/addDonorForm")
	public String showFormForAdd(Model model) {
		// write your logic here
		return "";
	}

	@PostMapping("/saveDonor")
	public String saveDonor(@Valid @ModelAttribute("donor") Donor donor, BindingResult bindingResult) {
		// write your logic here
		return "";
	}

	@GetMapping("/updateDonorForm")
	public String showFormForUpdate(@RequestParam("donorId") Long id, Model model) {
		// write your logic here
		return "";
	}

	@GetMapping("/delete")
	public String deleteDonor(@RequestParam("donorId") Long id) {
		// write your logic here
		return "";
	}
}
