package Spring.JSJStudy.service;

import Spring.JSJStudy.domain.Board;
import Spring.JSJStudy.repository.BoardRepository;

import java.util.List;

// @Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /**
     * 글쓰기
     */
    public Long create(Board board){
        boardRepository.create(board);
        return board.getBoardId();
    }

    /**
     * 전체 글 조회
     */
    public List<Board> findBoards(){
        return boardRepository.findAll();
    }
}
