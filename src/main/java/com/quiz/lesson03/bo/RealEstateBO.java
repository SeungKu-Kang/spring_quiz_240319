package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateMapper realEstateMapper;
	// input : id(int)
	// output : RealEstate(단건) or null
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	// input : rentPrice(필수)
	// output : List<RealEstate> 단건이 아니기 때문에 List임
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) { // Integer 아니고 int 인 이유?
		return realEstateMapper.selectRealEstateListByRentPrice(rentPrice);
	}
	
	// input: area , price
	// output : List<RealEstate>
	public List<RealEstate> getRealEstateListByAreaPrice(int area, int price) {
		return realEstateMapper.selectRealEstateListByAreaPrice(area, price);
	}
	// input: RealEstate
	// output : 성공한 행의 횟수 (int)
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	

//	address : 썅떼빌리버 오피스텔 814호
//	area : 45
//	type : 월세
//	price : 100000
//	rentPrice : 120
	public int addRealEstateAsField(int realtorId , String address, int area, String type, int price, Integer rentPrice) {
		return realEstateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
	
	// input: id, type, price -> 변경시킬 파라미터들
	// output: int (업데이트에 성공한 행의 개수)
	public int updateRealEstateById(int id, String type, int price) {
		return realEstateMapper.updateRealEstateById(id, type, price);
	}
	
	public int deleteRealEstateById(int id) {
		return realEstateMapper.deleteRealEstateById(id);
	}
	
}

