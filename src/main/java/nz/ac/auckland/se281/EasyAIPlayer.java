package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyAIPlayer implements AIPlayer {
  private Strategy strategy;
  private String ai = "HAL-9000";
  private Choice choice;
  private int finger;

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public void setAIPlayer(Choice choice) {
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
  }

  @Override
  public int makeMove(String winner, int round, int oddCount, int evenCount) {
    setStrategy(new RandomStrategy());
    this.finger = strategy.play(round, oddCount, evenCount, choice);
    return finger;
  }

  @Override
  public int getMove() {
    return finger;
  }

  @Override
  public Choice getAIChoice() {
    return choice;
  }

  @Override
  public String getAIName() {
    return ai;
  }

  @Override
  public void printMove() {
    MessageCli.PRINT_INFO_HAND.printMessage(ai, Integer.toString(finger));
  }
}
