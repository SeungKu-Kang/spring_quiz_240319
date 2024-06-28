package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {

	@Autowired
	private BookmarkMapper bookmarkMapper;
	// input : X
	// output : List<Bookmark>
	public List<Bookmark> getBookmarkList() { // db select 단계이기 때문에 method명에 get을 붙인다.
		
		return bookmarkMapper.selectBookmarkList();
	}
	
	// input: name, url
	// output: X
	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
}
