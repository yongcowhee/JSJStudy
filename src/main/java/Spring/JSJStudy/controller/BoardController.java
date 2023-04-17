package Spring.JSJStudy.controller;

import Spring.JSJStudy.domain.Board;
import Spring.JSJStudy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

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

    @DeleteMapping("/delete/{id}")
    public String remove(@PathVariable("id") Long id){
        boardService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        Board board = boardService.findBoardByBoardId(id);
        model.addAttribute("board", board);
        boardService.findBoardByBoardId(id);
        return "boards/ModifyContents";
    }

    @PutMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id, Board board){
        Board findBoard = boardService.findBoardByBoardId(id); // DB에 입력된 값, 1차캐시 생성 시점
        boardService.modify(findBoard, board);
        return "redirect:/";
    }

}
