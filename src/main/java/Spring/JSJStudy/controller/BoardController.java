package Spring.JSJStudy.controller;

import Spring.JSJStudy.domain.Board;
import Spring.JSJStudy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping(value = "/new")
    public String createForm(){
        return "boards/CreateContents";
    }

    @PostMapping("/new")
    public String create(BoardForm form){
        Board board = new Board();
        board.setBoardId(form.getBoardId());
        board.setCreateTime(form.getCreateTime());
        board.setAuthor(form.getAuthor());
        board.setContents(form.getContents());
        board.setTitle(form.getTitle());
        boardService.create(board);
        return "redirect:/";
    }

}
