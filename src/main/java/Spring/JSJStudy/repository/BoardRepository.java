package Spring.JSJStudy.repository;

import Spring.JSJStudy.controller.BoardController;
import Spring.JSJStudy.domain.Board;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board write(Board board);
    Optional<Board> findByTitle(String title);
    Optional<Board> findByAuthor(String author);
    List<Board> findAll();
}