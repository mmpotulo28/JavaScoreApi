package org.example.sprintscoreapi.api.controllers;

import org.example.sprintscoreapi.Score;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ScoreController {
  public static Score score = new Score(30, 20, 10);

  @GetMapping("/health")
  public String getHealthCheck() {
    return "API Up and Running";
  }

  @GetMapping("/score")
  public Score getScore() {
    return score;
  }

  @GetMapping("/score/{endpoint}")
  public Object getScore(@PathVariable String endpoint) {
    return switch (endpoint) {
      case "wins" -> score.getWins();
      case "losses" -> score.getLosses();
      case "ties" -> score.getTies();
      default -> null;
    };
  }

  // post methods
  @PostMapping("/score/{endpoint}")
  public Score increaseScore(@PathVariable String endpoint) {
    return switch (endpoint) {
      case "wins" -> {
        score.setWins(score.getWins() + 1);
        yield score;
      }
      case "losses" -> {
        score.setLosses(score.getLosses() + 1);
        yield score;
      }
      case "ties" -> {
        score.setTies(score.getTies() + 1);
        yield score;
      }
      default -> score;
    };
  }

  @PatchMapping("/score/{endpoint}")
  public Score updateScore(@PathVariable String endpoint, @RequestParam int value) {
    return switch (endpoint) {
      case "all" -> score;
      case "wins" -> {
        score.setWins(value);
        yield score;
      }
      case "losses" -> {
        score.setLosses(value);
        yield score;
      }
      case "ties" -> {
        score.setTies(value);
        yield score;
      }
      default -> null;
    };
  }

  @PutMapping("/score")
  public Score replaceScore(@RequestBody Score body) {
    score = body;
    return score;
  }
}
