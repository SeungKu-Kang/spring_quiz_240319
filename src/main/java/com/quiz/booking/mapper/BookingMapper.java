package com.quiz.booking.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.booking.domain.Booking;

@Mapper
public interface BookingMapper {

	public List<Booking> selectBookingList();
	
	public int deleteBookingById(int id);
	
	public void insertBooking(
			@Param("name") String name,
			@Param("date") LocalDate date, 
			@Param("day") int day, 
			@Param("headcount") int headcount, 
			@Param("phoneNumber") String phoneNumber);
	
	public List<Booking> selectBookingListByName(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
	
	// input : name, phoneNumber 
	// output: List<Booking>
	// method 명 변경 : get -> select, 최신꺼 하나만 가져오는게 아닌 모든 행을 가져올 것이므로 Latest삭제
	public List<Booking> selectBookingByNamePhoneNumber(
			@Param("name") String name , 
			@Param("phoneNumber") String phoneNumber);
}
