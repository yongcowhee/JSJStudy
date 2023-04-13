package Spring.JSJStudy.controller;

import Spring.JSJStudy.domain.Board;
import Spring.JSJStudy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class
BoardHomeController {

    private final BoardService boardService;

    @Autowired
    public BoardHomeController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping(value = "/")
    public String list(Model model){
        List<Board> board = boardService.findBoards();
        model.addAttribute("board", board);
        return "BoardHome";
    }
}
