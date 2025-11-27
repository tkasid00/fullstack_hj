package com.thejoa703.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SboardDto {
	private int id;
	private int appUserId;
	private String btitle;
	private String bcontent;
	private String bpass;
	private String bfile;
	private int bhit;
	private String bip;
	private String createdAt;
}

/*

SQL> desc sboard1
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 ID                                        NOT NULL NUMBER
 APP_USER_ID                               NOT NULL NUMBER
 BTITLE                                    NOT NULL VARCHAR2(1000)
 BCONTENT                                  NOT NULL CLOB
 BPASS                                     NOT NULL VARCHAR2(255)
 BFILE                                              VARCHAR2(255)
 BHIT                                               NUMBER
 BIP                                       NOT NULL VARCHAR2(255)
 CREATED_AT                                         TIMESTAMP(6)

 */
