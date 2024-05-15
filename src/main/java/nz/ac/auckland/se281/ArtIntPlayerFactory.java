package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class ArtIntPlayerFactory {

  /**
   * This method creates an AI player based on the difficulty level. If the difficulty level is
   * easy, it creates an EasyArtIntPlayer. If the difficulty level is medium, it creates a
   * MediumArtIntPlayer. If the difficulty level is hard, it creates a HardArtIntPlayer. If the
   * level is not any of the above, it returns null.
   *
   * @param difficulty difficulty level of the AI player
   * @return ArtIntPlayer AI player created
   */
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
