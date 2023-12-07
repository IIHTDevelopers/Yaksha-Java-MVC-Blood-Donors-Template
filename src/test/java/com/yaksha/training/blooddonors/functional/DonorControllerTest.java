package com.yaksha.training.blooddonors.functional;

import static com.yaksha.training.blooddonors.utils.MasterData.asJsonString;
import static com.yaksha.training.blooddonors.utils.MasterData.getDonor;
import static com.yaksha.training.blooddonors.utils.MasterData.getDonorList;
import static com.yaksha.training.blooddonors.utils.MasterData.randomStringWithSize;
import static com.yaksha.training.blooddonors.utils.TestUtils.businessTestFile;
import static com.yaksha.training.blooddonors.utils.TestUtils.currentTest;
import static com.yaksha.training.blooddonors.utils.TestUtils.testReport;
import static com.yaksha.training.blooddonors.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.yaksha.training.blooddonors.controller.DonorController;
import com.yaksha.training.blooddonors.entity.Donor;
import com.yaksha.training.blooddonors.service.DonorService;

public class DonorControllerTest {

	@Mock
	private DonorService donorService;

	@InjectMocks
	private DonorController donorController;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(donorController).build();
	}

	@After
	public void afterAll() {
		testReport();
	}

	@Test
	public void testControllerListDonorsHome() throws Exception {
		try {
			List<Donor> expected = getDonorList(5);
			when(donorService.getDonors()).thenReturn(expected);
			MvcResult result = this.mockMvc.perform(get("/")).andReturn();
			yakshaAssert(currentTest(),
					result.getModelAndView() != null && result.getModelAndView().getViewName() != null
							&& result.getModelAndView().getViewName().contentEquals("list-donors")
							&& asJsonString(expected)
									.equals(asJsonString(result.getModelAndView().getModel().get("donors"))) ? "true"
											: "false",
					businessTestFile);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}

	}

	@Test
	public void testControllerListDonors() throws Exception {
		List<Donor> expected = getDonorList(5);
		when(donorService.getDonors()).thenReturn(expected);
		MvcResult result = this.mockMvc.perform(get("/list")).andReturn();
		yakshaAssert(currentTest(),
				result.getModelAndView() != null && result.getModelAndView().getViewName() != null
						&& result.getModelAndView().getViewName().contentEquals("list-donors")
						&& asJsonString(expected)
								.equals(asJsonString(result.getModelAndView().getModel().get("donors"))) ? "true"
										: "false",
				businessTestFile);
	}

	@Test
	public void testControllerShowFormForAdd() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/addDonorForm")).andReturn();
		yakshaAssert(currentTest(), result.getModelAndView() != null && result.getModelAndView().getViewName() != null
				&& result.getModelAndView().getViewName().contentEquals("add-donor-form"), businessTestFile);
	}

	@Test
	public void testControllerSaveDonor() throws Exception {
		Donor donor = getDonor();
		MvcResult result = this.mockMvc.perform(post("/saveDonor").flashAttr("donor", donor)).andReturn();
		yakshaAssert(currentTest(),
				result.getModelAndView() != null && result.getModelAndView().getViewName() != null
						&& result.getModelAndView().getViewName().contentEquals("redirect:/donor/list"),
				businessTestFile);
	}

	@Test
	public void testControllerSaveDonorHasError() throws Exception {
		Donor donor = getDonor();
		donor.setId(null);
		donor.setFirstName(null);
		MvcResult result = this.mockMvc.perform(post("/saveDonor").flashAttr("donor", donor)).andReturn();
		yakshaAssert(currentTest(), result.getModelAndView() != null && result.getModelAndView().getViewName() != null
				&& result.getModelAndView().getViewName().contentEquals("add-donor-form"), businessTestFile);
	}

	@Test
	public void testControllerUpdateDonorHasError() throws Exception {
		Donor donor = getDonor();
		donor.setFirstName(null);
		MvcResult result = this.mockMvc.perform(post("/saveDonor").flashAttr("donor", donor)).andReturn();
		yakshaAssert(currentTest(), result.getModelAndView() != null && result.getModelAndView().getViewName() != null
				&& result.getModelAndView().getViewName().contentEquals("update-donor-form"), businessTestFile);
	}

	@Test
	public void testControllerShowFormForUpdate() throws Exception {
		Donor donor = getDonor();
		when(donorService.getDonor(donor.getId())).thenReturn(donor);
		MvcResult result = this.mockMvc.perform(get("/updateDonorForm").param("donorId", donor.getId().toString()))
				.andReturn();
		yakshaAssert(currentTest(), result.getModelAndView() != null && result.getModelAndView().getViewName() != null
				&& result.getModelAndView().getViewName().contentEquals("update-donor-form"), businessTestFile);
	}

	@Test
	public void testControllerDeleteDonor() throws Exception {
		Donor donor = getDonor();
		MvcResult result = this.mockMvc.perform(get("/delete").param("donorId", donor.getId().toString())).andReturn();
		yakshaAssert(currentTest(),
				result.getModelAndView() != null && result.getModelAndView().getViewName() != null
						&& result.getModelAndView().getViewName().contentEquals("redirect:/donor/list"),
				businessTestFile);
	}

	@Test
	public void testControllerSearchDonors() throws Exception {
		String key = randomStringWithSize(2);
		List<Donor> expected = getDonorList(5);
		when(donorService.searchDonors(key)).thenReturn(expected);
		MvcResult result = this.mockMvc.perform(post("/search").param("theSearchName", key)).andReturn();
		yakshaAssert(currentTest(),
				result.getModelAndView() != null && result.getModelAndView().getViewName() != null
						&& result.getModelAndView().getViewName().contentEquals("list-donors")
						&& asJsonString(expected)
								.equals(asJsonString(result.getModelAndView().getModel().get("donors"))) ? "true"
										: "false",
				businessTestFile);
	}

}
