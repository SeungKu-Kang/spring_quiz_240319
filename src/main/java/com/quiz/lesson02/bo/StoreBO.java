package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service // spring bean -> 어노테이션 안적는 실수 그만.
public class StoreBO {

	// input : X 
	// output: List<Store>
	
	public List<Store> getStoreList() { // DO에서 조회하는 경우 일반적으로 get을 붙인다.
		List<Store> storeList = storeMapper.selectStoreList();
		return storeList; // 컨트롤러에게 전달
		
		// return storeMapper.selectStoreList();  // 위 두줄을 한 줄로 합친 것. 
		                                          // 다만 순서가 storeMapper.selectStoreList()가 먼저이고
											      // return이 두번째 순서임.
	}
	
	@Autowired // Dependency Injection (DI) 의존성 주입
	private StoreMapper storeMapper; // mapper(마지막 계층(persistance)의 repository)와 연결하기 위한 작업
									 // 필드이기 때문에 private을 관례적으로 붙인다.
									 // 이 코드를 적는 이유는 storeMapper 안에 있는 기능을 쓰기 위함임 이 또한 함수이기 때문.
}
