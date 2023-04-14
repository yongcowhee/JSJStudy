package Spring.JSJStudy.repository;

import Spring.JSJStudy.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board create(Board board);
    Board modify(Long id);
    List<Board> findByTitle(String title);
    List<Board> findByAuthor(String author);
    List<Board> findAll();
    Board findById(Long id);
    void deleteById(Long id);
    }

