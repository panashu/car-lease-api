package com.ashupan.appuserservice.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "This is appUser request class")
public class AppUserRequestDTO implements Serializable {

    @ApiModelProperty(value = "This is the id of appUser")
    private Long id;

    @ApiModelProperty(value = "This is the username of appUser")
    private String username;

    @ApiModelProperty(value = "This is full name of appUser")
    private String fullName;

    @ApiModelProperty(value = "This is the email address of appUser")
    private String emailAddress;

    @ApiModelProperty(value = "This is the password of appUser")
    private String password;
    
}






