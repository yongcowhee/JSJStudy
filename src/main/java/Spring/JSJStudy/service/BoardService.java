package Spring.JSJStudy.service;

import Spring.JSJStudy.domain.Board;
import Spring.JSJStudy.repository.BoardRepository;
import org.springframework.stereotype.Service;

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
    public Long write(Board board){
        boardRepository.write(board);
        return board.getBoard_id();
    }

    /**
     * 전체 글 조회
     */
    public List<Board> findBoards(){
        return boardRepository.findAll();
    }
}
