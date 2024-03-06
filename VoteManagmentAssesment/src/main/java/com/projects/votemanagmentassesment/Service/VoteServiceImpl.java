package com.projects.votemanagmentassesment.Service;

import com.projects.votemanagmentassesment.Entity.Candidate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VoteServiceImpl implements VoteService{

    private static final Map<String, Candidate> candidates = new HashMap<>();

    public void enterCandidate(String name) {
        if(candidates.get(name) != null){
            System.out.println("You Alredy Registerd and Be Cool:  ");
        }else {
            candidates.put(name, new Candidate(name, 0));
        }
    }

    @Override
    public int castVote(String name) {
        Candidate candidate = candidates.get(name);
        if (candidate != null) {
            candidate.setVoteCount(candidate.getVoteCount() + 1);
            return candidate.getVoteCount();
        }

        return -1;
    }

    @Override
    public int countVote(String name) {
        Candidate candidate = candidates.get(name);
        return candidate != null ? candidate.getVoteCount() : -1;
    }

    @Override
    public Map<String, Integer> listVote() {
        Map<String, Integer> result = new HashMap<>();
        for (Candidate candidate : candidates.values()) {
            result.put(candidate.getName(), candidate.getVoteCount());
        }
        return result;
    }

    @Override
    public String getWinner() {

        int maxVote= Integer.MIN_VALUE;
        String winnerName ="";
        for(Map.Entry<String, Candidate> candidateEntry :candidates.entrySet()){
            if(candidateEntry.getValue().getVoteCount() > maxVote){
             maxVote = candidateEntry.getValue().getVoteCount();
             winnerName =candidateEntry.getKey();
            }

        }
        return winnerName;
    }
}
