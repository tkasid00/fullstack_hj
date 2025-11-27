package com.thejoa703.dao;

import java.util.List;
import java.util.Map;

import com.thejoa703.dto.*;

@MyDao
public interface EmpDao {
//	<select resultType="EmpDto" id="test1" parameterType="java.util.HashMap">
	public List<EmpDto> test1(Map<String, String > para);

	//<select resultType="EmpDto" id="test2" parameterType="EmpDto">
	public List<EmpDto> test2(EmpDto dto);
	
	//	<select resultType="EmpDto" id="test3" parameterType="EmpDto">
	public List<EmpDto> test3(EmpDto dto);

	public List<EmpDto> test4(EmpDto dto);
	
	//	<update id="test5" parameterType="EmpDto">
	public int test5(EmpDto dto);
	
	public List<EmpDto> test6(List<Integer> list);

	public List<EmpDto> readAuth(AppUserAuthDto dto);
	
}
