package com.yaksha.training.blooddonors.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaksha.training.blooddonors.entity.Donor;

@Controller
@RequestMapping(value = { "/donor", "/" })
public class DonorController {

	@GetMapping(value = { "/list", "/" })
	public String listDonors(Model model) {
		return "";
	}

	@GetMapping("/addDonorForm")
	public String showFormForAdd(Model model) {
		return "";
	}

	@PostMapping("/saveDonor")
	public String saveDonor(@Valid @ModelAttribute("donor") Donor donor, BindingResult bindingResult) {
		return "";
	}

	@GetMapping("/updateDonorForm")
	public String showFormForUpdate(@RequestParam("donorId") Long id, Model model) {
		return "";
	}

	@GetMapping("/delete")
	public String deleteDonor(@RequestParam("donorId") Long id) {
		return "";
	}

	@PostMapping("/search")
	public String searchDonors(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		return "";
	}
}
