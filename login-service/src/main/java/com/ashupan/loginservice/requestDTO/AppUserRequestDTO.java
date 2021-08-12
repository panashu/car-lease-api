package com.ashupan.loginservice.requestDTO;

import lombok.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author ashutosh on 8/11/21
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "This is appUser request class")
public class AppUserRequestDTO implements Serializable {
    
	@ApiModelProperty(value = "This is the username of appUser")
	private String username;
	
	@ApiModelProperty(value = "This is the email address of appUser")
    private String emailAddress;
}
