package com.quiz.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateMapper RealEstateMapper;
	// input : id(int)
	// output : RealEstate(단건) or null
	public RealEstate getRealEstateById(int id) {
		return RealEstateMapper.selectRealEstateById(id);
	}
	
	// input : rentPrice(필수)
	// output : List<RealEstate> 단건이 아니기 때문에 List임
	public RealEstate getRealEstateListByRentPrice(int rentPrice) { // Integer 아니고 int 인 이유?
		return RealEstateMapper.selectRealEstateListByRentPrice(rentPrice);
	}
}

