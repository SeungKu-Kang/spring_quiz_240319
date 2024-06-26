package com.quiz.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {

	@Autowired
	//private BookmarkBO bookmarkBO;
	
	// 즐겨찾기 추가하는 화면
	// http://localhost:8080/lesson06/add-page-view
	@GetMapping("/add-page-view")
	public String addPageView() {
		return "lesson06/addPage";
	}
	
	// AJAX가 하는 요청 String값 내려주기
	@ResponseBody
	@PostMapping("/add-page")
	public String addPage (
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// db insert
		//bookmarkBO.addPage(name,url);
		
		// 응답값 내리기 
		return "성공";
	}
	
}
