package com.quiz.booking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
