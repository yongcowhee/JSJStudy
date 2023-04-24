package Spring.JSJStudy.repository;
import Spring.JSJStudy.domain.BoardEntity;
import javax.persistence.EntityManager;
import java.util.List;

public class JpaBoardRepository implements BoardRepository{

    private final EntityManager em;

    public JpaBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public BoardEntity create(BoardEntity board) {
        em.persist(board);
        return board;
    }

    @Override
    public BoardEntity findById(Long id) {
        BoardEntity findBoard = em.find(BoardEntity.class, id);
        return findBoard;
    }

    @Override
    public List<BoardEntity> findByTitle(String title) {
        List<BoardEntity> result = em.createQuery("select b from BoardEntity b where b.title = :title", BoardEntity.class)
                .setParameter("title", title)
                .getResultList();
        return result;
    }

    @Override
    public List<BoardEntity> findByAuthor(String author) {
        List<BoardEntity> result = em.createQuery("select b from BoardEntity b where b.author = :author", BoardEntity.class)
                .setParameter("author", author)
                .getResultList();
        return result;
    }

    @Override
    public List<BoardEntity> findAll() {
        return em.createQuery("select b from BoardEntity b", BoardEntity.class)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        em.remove(findById(id));
    }
}
