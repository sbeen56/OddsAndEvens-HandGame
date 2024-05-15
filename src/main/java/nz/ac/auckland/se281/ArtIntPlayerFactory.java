package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class ArtIntPlayerFactory {

  public static ArtIntPlayer createAiPlayer(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyArtIntPlayer();
      case MEDIUM:
        return new MediumArtIntPlayer();
      case HARD:
        return new HardArtIntPlayer();

      default:
        return null;
    }
  }
}
