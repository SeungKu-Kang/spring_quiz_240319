package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	// input : X
	// output : List<Booking>
	public List<Booking> getBookingList() {// db select 단계이기 때문에 method명에 get을 붙인다.
		
		return bookingMapper.selectBookingList();
	}
	
	// input: id
	// output: int(rowCount)
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	
	// input:
	// output:
	
	public void addBooking(String name, LocalDate date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);

	}
	
	// 이름과 번호로 조회하기
	// input: name, phoneNumber
	// output: Booking(최신) or null
	public Booking getLatestBookingByNamePhoneNumber(String name , String phoneNumber) {
		// 리스트가 없는 경우: [](null이 아님을 알아야함)   있는 경우: [booking1, booking2 ...]
		List<Booking> bookingList = bookingMapper.selectBookingByNamePhoneNumber(name, phoneNumber);
		// if문을 사용할 경우
//		if (bookingList.isEmpty()) {
//			return null;
//		}
		
		// 삼항 연산자
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1) ;
	}
}
