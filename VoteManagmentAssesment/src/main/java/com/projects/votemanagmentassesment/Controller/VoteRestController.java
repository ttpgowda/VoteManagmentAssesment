package com.projects.votemanagmentassesment.Controller;


import com.projects.votemanagmentassesment.Service.VoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class VoteRestController {

//    @Autowired
    private VoteService voteService;

    public VoteRestController(VoteService voteService) {
        this.voteService = voteService;
    }

    //    http://localhost:8080/entercandidate?name=ajay

    @PostMapping("/entercandidate")
    public String enterCandidate(@RequestParam String name) {
        voteService.enterCandidate(name);
        return "You are Registerd";
    }


//    http://localhost:8080/castvote?name=ajay

    @PostMapping("/castvote")
    public int castVote(@RequestParam String name) {
        return voteService.castVote(name);
    }


//    http://localhost:8080/countvote?name=ajay


    @GetMapping("/countvote")
    public int countVote(@RequestParam String name) {
        return voteService.countVote(name);
    }



//    http://localhost:8080/listvote

    @GetMapping("/listvote")
    public Map<String, Integer> listVote() {
        return voteService.listVote();
    }

//    http://localhost:8080/getwinner

    @GetMapping("/getwinner")
    public String getWinner() {
        return voteService.getWinner();
    }
}
