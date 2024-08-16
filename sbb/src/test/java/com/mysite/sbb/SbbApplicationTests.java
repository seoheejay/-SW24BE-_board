package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.board.Board;
import com.mysite.sbb.board.BoardRepository;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired
    private BoardRepository boardRepository;

	@Test
	void testJpa() {        
		List<Board> bList = this.boardRepository.findBySubjectLike("sbb%");
		Board b = bList.get(0);
        assertEquals("sbb가 무엇인가요?", b.getSubject());
	}
}
