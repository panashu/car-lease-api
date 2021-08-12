package com.ashupan.appuserservice.dto.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO implements Serializable{
    private List<AppUserResponseDTO> appUserResponseDTOS;

    private String message;
}
