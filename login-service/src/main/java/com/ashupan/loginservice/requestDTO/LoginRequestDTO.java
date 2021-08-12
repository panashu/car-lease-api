package com.ashupan.loginservice.requestDTO;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@Getter
@Setter
@ApiModel(value = "This is login request class")
public class LoginRequestDTO implements Serializable {
    
	@ApiModelProperty(value = "This is the user credential fed in the login request")
	private String userCredential;

	@ApiModelProperty(value = "This is the password fed in the login request")
    private String password;
}
