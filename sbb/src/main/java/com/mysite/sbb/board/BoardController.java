package com.mysite.sbb.board;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardService boardService;

	@GetMapping("/board/list")
    public String list(Model model) {
        List<Board> boardList = this.boardService.getList();
        model.addAttribute("boardList", boardList);
        return "board_list";
    }
	
	@GetMapping(value = "/board/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
		Board board = this.boardService.getBoard(id);
        model.addAttribute("board", board);
			
		return "board_detail";
    }
	
	@GetMapping("/board/create")
    public String boardCreate() {
        return "board_form";
    }
	 @PostMapping("/board/create")
	    public String boardCreate(@Valid BoardForm boardForm, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "board_form";
	        }
	        this.boardService.create(boardForm.getSubject(), boardForm.getContent());
	        return "redirect:/board/list"; // 질문 저장후 질문목록으로 이동
	    }
	}

