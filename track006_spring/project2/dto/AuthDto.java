package com.thejoa703.dto;

import lombok.Data;

@Data
public class AuthDto {
	private String email;
	private String auth;

}

/* 
     이름    널?       유형            
    ----- -------- ------------- 
    EMAIL NOT NULL VARCHAR2(100) 
    AUTH  NOT NULL VARCHAR2(100) 
 */