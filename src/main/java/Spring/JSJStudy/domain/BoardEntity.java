package Spring.JSJStudy.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "BOARD")
@Getter
public class BoardEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    private String title;
    private String author;
    private LocalDateTime createTime; // modified: snake case to camel case, Date to LocalDateTime
    private String contents;


    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
