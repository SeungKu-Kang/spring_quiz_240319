package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {

	@Autowired
	private RecruitRepository recruitRepository;
	// 1)
	@GetMapping("/1")
	public List<RecruitEntity> select1() {
		return recruitRepository.findById(8);
	}
	
	@GetMapping("/2")
	public List<RecruitEntity> select2(
			@RequestParam("companyId") int companyId) {
		return recruitRepository.findByCompanyId(1);
	}
	
//	@GetMapping("/3")
//	public List<RecruitEntity> select3() {
//		
//	}
//	@GetMapping("/4")
//	public List<RecruitEntity> select4() {
//		
//	}
//	@GetMapping("/5")
//	public List<RecruitEntity> select5() {
//		
//	}
//	@GetMapping("/6")
//	public List<RecruitEntity> select6() {
//		
//	}
	
	
}
