package com.catch_me_study.catch_me_study.domain.board.controller;

import com.catch_me_study.catch_me_study.domain.board.dto.BoardDto;
import com.catch_me_study.catch_me_study.domain.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@Tag(name = "Board", description = "게시판 CRUD")
public class BoardRestController {

    private final BoardService boardService;

    @GetMapping
    @Tag(name = "Board")
    @Operation(summary = "Board 조회", description = "모든 게시판을 조회합니다.")
    public List<BoardDto> getBoardList() {
        return boardService.getBoardList();
    }

    @GetMapping("{id}")
    @Tag(name = "Board")
    @Operation(summary = "Board 조회", description = "Unique ID를 사용하여 특정 게시판을 조회합니다.")
    public BoardDto getBoardById(@PathVariable String id) {
        return boardService.getBoardById(id);
    }

    @PostMapping
    @Tag(name = "Board")
    @Operation(summary = "Board 생성", description = "Board를 생성합니다.")
    public BoardDto createBoard(@RequestBody @Valid BoardDto boardDto) {
        return boardService.createBoard(boardDto);
    }

    @PutMapping
    @Tag(name = "Board")
    @Operation(summary = "Board 수정", description = "Unique ID를 사용하여 특정 Board를 수정합니다.")
    public BoardDto updateBoard(@RequestBody @Valid BoardDto boardDto) {
        return boardService.updateBoard(boardDto);
    }

    @DeleteMapping("{id}")
    @Tag(name = "Board")
    @Operation(summary = "Board 수정", description = "Unique ID를 사용하여 특정 Board를 삭제합니다.")
    public String deleteBoardById(@PathVariable String id) {
        return boardService.deleteBoardById(id);
    }

}
