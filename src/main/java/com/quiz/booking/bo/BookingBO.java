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
	
	// input: 
	// output: boolean
	public boolean isDuplicationUrl(String name, String phoneNumber) {
		// 중복 있음:List     중복 없음:[]
		List<Booking> bookingList = bookingMapper.selectBookingListByName(name, phoneNumber);
		// [] => false, 비어있지 않으면 => true
		return bookingList.isEmpty() ? false : true;
	}
}
