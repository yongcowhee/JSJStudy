package Spring.JSJStudy.controller;

import java.time.LocalDateTime;

public class updateDTO {
        private Long boardId;
        private String title;
        private String author;
        private LocalDateTime createTime;
        private String contents;

        public Long getBoardId() {
            return boardId;
        }

        public void setBoardId(Long boardId) {
            this.boardId = boardId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public LocalDateTime getCreateTime() {
            createTime = LocalDateTime.now();
            return createTime;
        }

        public void setCreateTime(LocalDateTime createTime) {
            this.createTime = createTime;
        }

        public String getContents() {
            return contents;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }

}
