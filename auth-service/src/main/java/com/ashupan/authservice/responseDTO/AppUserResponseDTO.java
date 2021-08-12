package com.ashupan.authservice.responseDTO;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ashutosh on 8/11/21
 */

@Getter
@Setter
@ApiModel(value = "This is appUser request class")
public class AppUserResponseDTO implements Serializable{

	@ApiModelProperty(value = "This is the id of appUser")
    private Long id;

	@ApiModelProperty(value = "This is the username of appUser")
    private String username;

	@ApiModelProperty(value = "This is the email address of appUser")
    private String emailAddress;
	
	@ApiModelProperty(value = "This is the password of appUser")
    private String password;

    private List<String> roles = new ArrayList<>();
}
