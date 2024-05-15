package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyArtIntPlayer implements ArtIntPlayer {
  private Strategy strategy;
  private String ai = "HAL-9000";
  private Choice choice;
  private int finger;

  /**
   * This method sets the strategy for the AI player.
   *
   * @param strategy strategy to be set
   * @return void
   */
  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * This method sets the choice of the AI player.
   *
   * @param choice choice from the human player
   * @return void
   */
  @Override
  public void setArtIntPlayer(Choice choice) {
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

  /**
   * This method generates a finger for the AI player. It uses the random strategy to generate a
   * finger.
   *
   * @param winner winner of the previous round
   * @param round round of the game
   * @param oddCount number of odd numbers of human player
   * @param evenCount number of even numbers of human player
   * @return int finger generated by the AI player
   */
  @Override
  public int makeMove(String winner, int round, int oddCount, int evenCount) {
    setStrategy(new RandomStrategy());
    this.finger = strategy.play(round, oddCount, evenCount, choice);
    return finger;
  }

  /**
   * This method returns the finger generated by the AI player.
   *
   * @return int finger generated by the AI player
   */
  @Override
  public int getMove() {
    return finger;
  }

  /**
   * This method returns the choice of the AI player.
   *
   * @return Choice choice of the AI player
   */
  @Override
  public Choice getArtIntChoice() {
    return choice;
  }

  /**
   * This method returns the name of the AI player.
   *
   * @return String name of the AI player
   */
  @Override
  public String getArtIntName() {
    return ai;
  }

  /**
   * This method prints the the finger generated by the AI player.
   *
   * @return void
   */
  @Override
  public void printMove() {
    MessageCli.PRINT_INFO_HAND.printMessage(ai, Integer.toString(finger));
  }
}
