package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Realtor;
import com.quiz.lesson04.mapper.RealtorMapper;

@Service
public class RealtorBO {

	@Autowired
	private RealtorMapper realtorMapper;
	// input :  Realtor
	// output : X
	
	public void addRealtor(Realtor realtor) { // input 자리 설명: Controller로부터 Realtor 단건 객체를 받아오는 것임
											  // return 타입이 int이면 성공한 행의 개수를 반환하는 것
		realtorMapper.insertRealtor(realtor);
	}
	
	// input : id
	// output : Realtor
	public Realtor getRealtorById(int id) {
		return realtorMapper.selectRealtorById(id);
	}
}
