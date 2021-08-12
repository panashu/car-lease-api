package com.ashupan.leaserateservice.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import org.hamcrest.core.Is;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

import com.ashupan.leaserateservice.model.Lease;
import com.ashupan.leaserateservice.service.LeaseRateService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=LeaseRateController.class)
public class LeaseRateControllerTests {

	 @MockBean
	 private LeaseRateService leaseRateService;
	 
	 @Autowired
	 private MockMvc mockMvc;
	 
	 @Before
	 public void setUp() throws Exception{
		 MockitoAnnotations.initMocks(this);
	 }
	 
	 @Test
	 public void contextLoads() throws Exception{
			assertThat(leaseRateService).isNotNull();
	}
	 
	 /*@Test
	 public void whenPostRequestToLeaseRateAndValidLease_thenCorrectResponse() throws Exception {
        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
        String lease = "{\"mileage\": \"45000\", \"duration\" : \"60\", \"interestRate\" : \"4.5\", \"netPrice\" : \"63000\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/leaserate")
                .content(lease)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(textPlainUtf8));
	 }
	    
	 @Test
	 public void whenPostRequestToLeaseRateAndInValidLease_thenCorrectReponse() throws Exception {
		 String lease = "{\"mileage\": \"0\", \"duration\" : \"60\", \"interestRate\" : \"4.5\", \"netPrice\" : \"63000\"}";
	        mockMvc.perform(MockMvcRequestBuilders.post("/leaserate")
	                .content(lease)
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isBadRequest())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.mileage", Is.is("Mileage cannot be less than 1")))
	                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
	 }*/
	 
	 public void calculateLeaseRateTest() throws Exception{
		 Lease lease = new Lease();
		 lease.setMileage(45000);
		 lease.setDuration(60);
		 lease.setInterestRate(4.5);
		 lease.setNetPrice(63000);
		 String leaseString = "{\"mileage\": \"45000\", \"duration\" : \"60\", \"interestRate\" : \"4.5\", \"netPrice\" : \"63000\"}";
		 when(leaseRateService.calculateLeaseRate(lease)).thenReturn("239,82");
		 
		 mockMvc.perform(MockMvcRequestBuilders.post("/leaserate")
	                .content(leaseString)
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andExpect(MockMvcResultMatchers.jsonPath("$", Is.is("239,82")));
	 }
}
