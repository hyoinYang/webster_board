package web1.web1.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import web1.web1.dto.BoardDto;
import web1.web1.repository.BoardRepository;
import web1.web1.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web1.web1.domain.DevNumberOfPeople;
import web1.web1.domain.DevLocation;
import web1.web1.domain.DevSelectTime;
import web1.web1.domain.GenderType;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostConstruct
    public void postConstruct() {
        if (boardService == null) {
            throw new IllegalStateException("boardService is not initialized");
        }
    }
    private BoardRepository boardRepository;


    private DevLocation location;


    private DevNumberOfPeople numberOfPeople;


    private GenderType gender;


    private DevSelectTime selectTime;

    public void LocationBean(){
        switch (location){
            case 부대통령:
                this.location = DevLocation.부대통령;
                break;

        }
    }

    /*리스트 출력*/
    @GetMapping("/")
    public String list(Model model){
        List<BoardDto> boardList = boardService.getBoardlist();
        model.addAttribute("boardList", boardList);

        return "/list.html";
    }

    /*방 만들기 페이지*/
    @GetMapping("/list")
    public String write() {
        return "board/write.html";
    }


    @GetMapping("/post/fin")
    public String writeFin(){
        return "/list";
    }

    /*자동삭제*/
    @DeleteMapping("/list/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);

        return "redirect:/";
    }


}
