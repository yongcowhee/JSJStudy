package Spring.JSJStudy.service;

import Spring.JSJStudy.domain.Board;
import Spring.JSJStudy.repository.BoardRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    /**
     * 글 삭제
     */
    @Transactional
    public void delete(Long id){
        boardRepository.deleteById(id);
    }
}
