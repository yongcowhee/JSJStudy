package Spring.JSJStudy.service;

import Spring.JSJStudy.domain.Board;
import Spring.JSJStudy.repository.BoardRepository;
import java.util.List;

// @Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /**
     * 글쓰기
     */
    public void create(Board board){
        boardRepository.create(board);
    }

    /**
     * 전체 글 조회
     */
    public List<Board> findBoards(){
        return boardRepository.findAll();
    }

    /**
     * 특정 글 조회
     */
    public Board findBoardByBoardId(Long id){
        return boardRepository.findById(id);
    }
    /**
     * 글 삭제
     */
    public void delete(Long id){
        boardRepository.deleteById(id);
    }

    public void modify(Board findBoard, Board inputBoard){
        // 더티 체킹을 위해선 뭘 해줘야 할까?
        // 더티 체킹이 뭐였더라?
        // 1차 캐시는 이미 생성되었고, 그럼 뭘 해야 할까
        // inputBoard, findBoard 랑 이 두개가 비교가 된다고?
        // 프론트(타임리프) - 백엔드(스프링) ---- (JPA) ----DB 이 그림을 보면서...
        // inputBoard 라는 객체는 영속성 컨텍스트에 저장이 되어있다 -> x
        // findBoard 라는 객체는 영속성 컨텍스트에 저장이 되어있다. -> o
        // findBoard id는 key값이고, findBoard 주소가 value로 저장되어있다. -> o
        // findBoard 를 최초에 조회 했을때 모습이 1차 캐시에 저장되어 있다.
        // findBoard 의 현재 데이터를 JPA는 영속성 컨텍스트에 key값으로 찾을 수 있다. -> o
        // 영속성 컨텍스트의 무엇(value => value 의 주소값으로 참조한 객체의 값)과 1차캐시의 무엇(스냅샷)을 비교를 할까요? ()

        //findBoard = inputBoard;
        // findBoard id -> 3;
        // inputBoard id -> null;
        // findboar id -> null;

        findBoard.setTitle(inputBoard.getTitle());
        findBoard.setAuthor(inputBoard.getAuthor());
        findBoard.setContents(inputBoard.getContents());
    }
}
