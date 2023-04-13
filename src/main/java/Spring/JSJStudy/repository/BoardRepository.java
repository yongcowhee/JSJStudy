package Spring.JSJStudy.repository;

import Spring.JSJStudy.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board create(Board board);
    Board modifyBoard(Board board);
    List<Board> findByTitle(String title);
    List<Board> findByAuthor(String author);
    List<Board> findAll();
    void deleteById(Long id);
    }

