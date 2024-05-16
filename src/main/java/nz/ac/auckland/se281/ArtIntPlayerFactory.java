package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

/** This class is a factory class that creates an AI player based on the difficulty level. */
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
        return new EasyArtIntPlayer(); // Make easy AI player when difficulty is easy.
      case MEDIUM:
        return new MediumArtIntPlayer(); // Make medium AI player when difficulty is medium.
      case HARD:
        return new HardArtIntPlayer(); // Make hard AI player when difficulty is hard.

      default:
        return null;
    }
  }
}
