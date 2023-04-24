package Spring.JSJStudy.repository;

import Spring.JSJStudy.domain.BoardEntity;

import java.util.List;

public interface BoardRepository {
    BoardEntity create(BoardEntity board);
    List<BoardEntity> findByTitle(String title);
    List<BoardEntity> findByAuthor(String author);
    List<BoardEntity> findAll();
    BoardEntity findById(Long id);
    void deleteById(Long id);
    }

