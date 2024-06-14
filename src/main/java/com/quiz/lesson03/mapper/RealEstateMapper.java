package com.quiz.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	// input : id
	// output : RealEstate
	public RealEstate selectRealEstateById(int id);
	
	// input : rentPrice
	// output : RealEstate
	public RealEstate selectRealEstateListByRentPrice(int rentPrice);
}
