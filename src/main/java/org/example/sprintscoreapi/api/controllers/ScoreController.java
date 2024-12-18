package org.example.sprintscoreapi.api.controllers;

import org.example.sprintscoreapi.Score;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ScoreController {
    public static Score score = new Score(30, 20, 10);

    @GetMapping("/")
    public String getHealthCheck() {
        return "API Up and Running";
    }

    @GetMapping("/score/{endpoint}")
    public Object getScore(@PathVariable String endpoint) {
        switch (endpoint) {
            case "all":
                return score;
            case "wins":
                return score.getWins();
            case "losses":
                return score.getLosses();
            case "ties":
                return score.getTies();
            default:
                return null;
        }
    }

    // post methods
    @PostMapping("/score/{endpoint}")
    public Score increaseWins(@PathVariable String endpoint) {
        switch (endpoint) {
            case "all":
                return score;
            case "wins":
                score.setWins(score.getWins() + 1);
                return score;
            case "losses":
                score.setLosses(score.getLosses() + 1);
                return score;
            case "ties":
                score.setTies(score.getTies() + 1);
                return score;
            default:
                return null;
        }
    }
}
