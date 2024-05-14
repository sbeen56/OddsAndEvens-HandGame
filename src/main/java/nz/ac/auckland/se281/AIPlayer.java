package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AIPlayer {
  private Level level;
  private String ai = "HAL-9000";

  public AIPlayer(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        this.level = new EasyLevel();
        break;

      default:
        break;
    }
  }

  public void getMove() {
    MessageCli.PRINT_INFO_HAND.printMessage(ai, Integer.toString(level.getMove()));
  }
}
