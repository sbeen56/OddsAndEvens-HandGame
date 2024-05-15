package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AIPlayerFactory {

  public static AIPlayer createAiPlayer(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyAIPlayer();
      case MEDIUM:
        return new MediumAIPlayer();
      case HARD:
        return new HardAIPlayer();

      default:
        return null;
    }
  }
}
