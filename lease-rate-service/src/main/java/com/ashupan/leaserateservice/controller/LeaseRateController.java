package com.ashupan.leaserateservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.FieldError;




import com.ashupan.leaserateservice.model.Lease;
import com.ashupan.leaserateservice.service.LeaseRateService;



@RestController
@RequestMapping("/api/v1")
@Api(value = "This is lease rate controller")
public class LeaseRateController {

	@Autowired
	private LeaseRateService leaseRateService;
	
	@PostMapping("/leaserate")
	@ApiOperation(value = "Calculates the lease rate")
	public String calculateLeaseRate(@Valid @RequestBody Lease lease) {
		return leaseRateService.calculateLeaseRate(lease);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
