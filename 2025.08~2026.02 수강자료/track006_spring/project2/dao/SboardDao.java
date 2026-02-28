package com.thejoa703.dao;

import java.util.HashMap;
import java.util.List;

import com.thejoa703.dto.SboardDto;

@MyDao
public interface SboardDao {

	// public [resultType/int]	[id]  (parameterType/ )
	
//	1.  <insert id="insert" parameterType="SboardDto"> 
	public int insert(SboardDto dto);
	
//	2.	<select resultType="SboardDto"	id="selectAll">	**여기는 리스트 사용!**
	public List<SboardDto> selectAll();
	
//  3.	<select	resultType="SboardDto"	 id="select" parameterType="int">
	public SboardDto select(int id);
	
//  4. <update id="update" parameterType="SboardDto">
	public int update(SboardDto dto);
	
//  5. <delete id="delete" parameterType="SboardDto">	
	public int delete(SboardDto dto);
	
//	6.	<update id="updateBhit" parameterType="int">
	public int updateBhit(int id);

	
	
	//파일 업로드용
//	<insert id="insertForUpload" parameterType="SboardDto">
	public int insertForUpload(SboardDto dto);
	
//	<update id="updateForUpload" parameterType="SboardDto">	
	public int updateForUpload(SboardDto dto);
	
	
	//검색
	//	<select resultMap="sboardMap" id="selectSearch" parameterType="java.util.HashMap">
												//key	value
	public List<SboardDto> selectSearch(HashMap<String, String> para);

	
	
}

