package Spring.JSJStudy.controller;

import Spring.JSJStudy.domain.BoardEntity;
import Spring.JSJStudy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Transactional
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
    public String create(createDTO form){
        BoardEntity board = new BoardEntity();
        board.setBoardId(form.getBoardId());
        board.setCreateTime(form.getCreateTime());
        board.setAuthor(form.getAuthor());
        board.setContents(form.getContents());
        board.setTitle(form.getTitle());
        boardService.create(board);
        return "redirect:/";
    }

    @DeleteMapping("/board/{id}")
    public String remove(@PathVariable("id") Long id){
        boardService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/board/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        BoardEntity board = boardService.findBoardByBoardId(id);
        model.addAttribute("board", board);
        boardService.findBoardByBoardId(id);
        return "boards/ModifyContents";
    }

    @PutMapping("/board/{id}")
    public String modify(@PathVariable("id") Long id, updateDTO board){
        BoardEntity findBoard = boardService.findBoardByBoardId(id); // DB에 입력된 값, 1차캐시 생성 시점
        boardService.modify(findBoard, board);
        return "redirect:/";
    }

}
