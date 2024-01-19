package com.projects.votemanagmentassesment.Service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public   interface VoteService  {
    void enterCandidate(String name);
     int castVote(String name);

     int countVote(String name);

     Map<String, Integer> listVote();

     String getWinner();
    }
