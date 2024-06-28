package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson06.domain.Bookmark;

@Mapper
public interface BookmarkMapper {

	public List<Bookmark> selectBookmarkList();
	
	public void insertBookmark(
			@Param("name") String name, 
			@Param("url") String url);
	
	// input: url
	// output: List<Bookmark>
	public List<Bookmark> selectBookmarkListByUrl(String url);
	
	
	public int deleteBookmarkById(int id);
}
