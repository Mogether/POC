package com.example.test.application;

import com.example.test.application.dto.BoardCreateRequest;
import com.example.test.application.dto.BoardResponse;
import com.example.test.domain.Board;
import com.example.test.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public long create(final BoardCreateRequest boardCreateRequest) {
        Board board = createBoardFrom(boardCreateRequest);
        boardRepository.save(board);
        return board.getId();
    }

    private Board createBoardFrom(final BoardCreateRequest boardCreateRequest) {
        return Board.builder()
                .title(boardCreateRequest.getTitle())
                .content(boardCreateRequest.getContent())
                .build();
    }

    public BoardResponse findById(final long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        return createBoardResponseFrom(board);
    }

    private BoardResponse createBoardResponseFrom(final Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }
}
