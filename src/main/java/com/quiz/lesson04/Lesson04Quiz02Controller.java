package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {

	@Autowired
	private RealtorBO realtorBO; // BO에 요청해야 하기 때문에 작성하는 코드
	// 정보 입력 화면
	// http://localhost:8080/lesson04/quiz02/add-realtor-view
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	// DB Insert => 방금 입력된 정보 select => 화면
	
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		
		// DB Insert
		realtorBO.addRealtor(realtor);
		
		// id를 가지고 1개의 정보DB를 Select
//		int id = realtor.getId();
//		Realtor latestRealtor = realtorBO.getRealtorById(id);
		
		Realtor latestRealtor = realtorBO.getRealtorById(realtor.getId());
		
		
		
		// Model에 데이터 담기
		model.addAttribute("realtor", latestRealtor); // 이 코드 작성 시에 model의 메소드를 부르기 위해 위에 파라미터 자리에 Model model적는다.
		
		// 화면 이동
		return "lesson04/afterAddRealtor";
	}
}
