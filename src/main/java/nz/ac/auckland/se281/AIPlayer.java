package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class AIPlayer {
  private Level level;
  private String ai = "HAL-9000";
  private Choice choice;
  private int finger;
  private int oddCount;
  private int evenCount;
  private int round;

  public AIPlayer(Difficulty difficulty, Choice choice) {
    switch (choice) {
      case EVEN:
        this.choice = Choice.ODD;
        break;

      case ODD:
        this.choice = Choice.EVEN;
        break;

      default:
        break;
    }

    switch (difficulty) {
      case EASY:
        this.level = new EasyLevel();
        break;
      case MEDIUM:
        this.level = new MediumLevel();
        break;
      case HARD:
        this.level = new HardLevel();
        break;

      default:
        break;
    }
  }

  public void setPlayer(int oddCount, int evenCount, int round) {
    this.round = round;
    this.oddCount = oddCount;
    this.evenCount = evenCount;
  }

  public int makeMove() {
    this.finger = level.getMove(round, oddCount, evenCount, choice);
    return finger;
  }

  public int getMove() {
    return finger;
  }

  public Choice getChoice() {
    return choice;
  }

  public String getName() {
    return ai;
  }

  public void printMove() {
    MessageCli.PRINT_INFO_HAND.printMessage(ai, Integer.toString(makeMove()));
  }
}
