package com.ashupan.appuserservice.controller;

import com.ashupan.appuserservice.dto.request.AppUserRequestDTO;
import com.ashupan.appuserservice.dto.response.ResponseDTO;
import com.ashupan.appuserservice.service.AppUserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ashupan.appuserservice.constants.WebResourceKeyConstants.*;
import static org.springframework.http.ResponseEntity.ok;

/**
 * @author 
 */
@RestController
@RequestMapping(value = BASE_API)
@Api(value = "This is appUser controller")
public class AppUserController {
	
	private final AppUserService appUserService;
	
	public AppUserController(AppUserService appUserService) {
		this.appUserService = appUserService;
	}
	
	@PostMapping(value = SAVE)
	@ApiOperation(value = "Save new appUser")
	@ResponseBody
	public ResponseEntity<?> saveAppUser(@RequestBody AppUserRequestDTO requestDTO) {
		appUserService.saveAppUser(requestDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping(value = SEARCH)
	@ApiOperation(value = "Search appUser by given parameters in request")
	public ResponseEntity<?> searchAppUser(@ApiParam(value = "Parameter value is appUser username")
										 @RequestBody AppUserRequestDTO requestDTO) {
		return ok().body(appUserService.searchAppUser(requestDTO));
	}
	
	@GetMapping(value = FETCH_APPUSER_BY_USERNAME)
	public ResponseEntity fetchAppUserByUsername(@PathVariable("username") String username) {
		return ok(appUserService.fetchAppUserByUsername(username));
	}	
	
}
