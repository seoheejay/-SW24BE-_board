package com.mysite.sbb.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	Board findBySubject(String subject);
	Board findBySubjectAndContent(String subject, String content);
	List<Board> findBySubjectLike(String subject);
}
