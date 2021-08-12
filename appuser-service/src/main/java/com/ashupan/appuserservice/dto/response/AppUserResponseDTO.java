package com.ashupan.appuserservice.dto.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUserResponseDTO  implements Serializable{

    private String emailAddress;

    private Long id;

    private String password;
}
