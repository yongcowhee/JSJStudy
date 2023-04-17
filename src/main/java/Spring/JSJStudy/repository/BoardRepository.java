package Spring.JSJStudy.repository;

import Spring.JSJStudy.domain.Board;

import java.util.List;

public interface BoardRepository {
    Board create(Board board);
    List<Board> findByTitle(String title);
    List<Board> findByAuthor(String author);
    List<Board> findAll();
    Board findById(Long id);
    void deleteById(Long id);
    }

