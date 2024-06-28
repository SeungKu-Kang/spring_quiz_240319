package com.quiz.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	
	
	// 예약 목록을 나타내는 화면 -- 테이블로 뿌릴거니까 model에 담아야함
	// http://localhost:8080/booking/booking-list-view
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		// db select => List<Booking>
		List<Booking> bookingList = bookingBO.getBookingList();
		
		// model 에 담기
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	// 같은 예약 목록 화면에서 삭제 버튼을 통해 삭제
	// id로 삭제할 지 이름으로 삭제할 지 미정
	// AJAX 요청
	// http://localhost:8080/booking/delete-booking
	//@ResponseBody
	//@DeleteMapping("/delete-booking")
	
	
	// 예약하기 화면
	// http://localhost:8080/booking/make-booking-view
	//@PostMapping("")
	
	
	
	
	// 예약조회 화면
	// http://localhost:8080/booking/check-booking-view
}
