package com.projects.votemanagmentassesment;
import com.projects.votemanagmentassesment.Service.VoteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VoteManagmentAssesmentApplicationTests {

    @Test
    void contextLoads() {

        VoteServiceImpl voteService = new VoteServiceImpl();


        voteService.enterCandidate("Thimmegowda");
        voteService.enterCandidate("ajay");
        voteService.enterCandidate("Mahesh");
        voteService.enterCandidate("Bob");

        assertEquals(1, voteService.castVote("Thimmegowda"));
        assertEquals(2, voteService.castVote("Thimmegowda"));
        assertEquals(1, voteService.castVote("ajay"));
        assertEquals(2, voteService.castVote("ajay"));
        assertEquals(3, voteService.castVote("ajay"));
        assertEquals(4, voteService.castVote("ajay"));
        assertEquals(1, voteService.castVote("Mahesh"));
        assertEquals(2, voteService.castVote("Mahesh"));
        assertEquals(1, voteService.castVote("Bob"));

        assertEquals(-1, voteService.countVote("slihshd"));
        assertEquals(2, voteService.countVote("Thimmegowda"));


        assertEquals("ajay", voteService.getWinner());

    }
    }
