package Spring.JSJStudy;

import Spring.JSJStudy.domain.Board;
import Spring.JSJStudy.repository.BoardRepository;
import Spring.JSJStudy.repository.JpaBoardRepository;
import Spring.JSJStudy.service.BoardService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(boardRepository());
    }
    @Bean
    public BoardRepository boardRepository() {
        return new JpaBoardRepository(em);
    }
}