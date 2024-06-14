package com.quiz.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson02.domain.Store;

@Mapper // 어노테이션 안적는 실수 그만. 만약 import가 안되면 gradle에 문제가 있는 것.
public interface StoreMapper {

	// input : X 
	// output: List<Store>
	
	public List<Store> selectStoreList(); // interface이기 때문에 구현없이 끝나는 것임.
	// .xml은 미리 만들면 서버를 켜는 순간 미완성된 .xml을 먼저 읽어보기 때문에 오류가 발생하여 서버가 켜지지 않음.
	// 따라서 .xml은 가장 마지막에 만들어야 할 때 만들어야 함.
}
