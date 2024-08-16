package com.mysite.sbb.board;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;
import com.mysite.sbb.DataNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    
    
    public List<Board> getList() {
        return this.boardRepository.findAll();
         
    }
    public Board getBoard(Integer id) {  
        Optional<Board> board = this.boardRepository.findById(id);
        if (board.isPresent()) {
            return board.get();
        } else {
            throw new DataNotFoundException("board not found");
        }
    }
    public void create(String subject, String content) {
    	Board b = new Board();
        b.setSubject(subject);
        b.setContent(content);
        b.setCreateDate(LocalDateTime.now());
        this.boardRepository.save(b);
    }
}
