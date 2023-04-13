package Spring.JSJStudy.repository;
import Spring.JSJStudy.domain.Board;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaBoardRepository implements BoardRepository{

    private final EntityManager em;

    public JpaBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board create(Board board) {
        em.persist(board);
        return board;
    }

    @Override
    public Board modifyBoard(Board board) {
        return null;
    }

    @Override
    public List<Board> findByTitle(String title) {
        List<Board> result = em.createQuery("select b from Board b where b.title = :title", Board.class)
                .setParameter("title", title)
                .getResultList();
        return result;
    }

    @Override
    public List<Board> findByAuthor(String author) {
        List<Board> result = em.createQuery("select b from Board b where b.author = :author", Board.class)
                .setParameter("author", author)
                .getResultList();
        return result;
    }

    @Override
    public List<Board> findAll() {
        return em.createQuery("select b from Board b", Board.class)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Board findBoard = em.find(Board.class, id);
        em.remove(findBoard);
    }
}
