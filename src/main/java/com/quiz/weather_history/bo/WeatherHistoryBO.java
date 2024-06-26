package com.quiz.weather_history.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {

	// input: X
	// output: List<WeatherHistory>
	
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	public List<WeatherHistory> getWeatherHistory() {
		
		return weatherHistoryMapper.selectWeatherHistoryList();
	}
	
	public void addWeatherHistory(String date, String weather, double temperatures, 
			double precipitation, String microDust, double windSpeed) {
		weatherHistoryMapper.insertWeatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
}
