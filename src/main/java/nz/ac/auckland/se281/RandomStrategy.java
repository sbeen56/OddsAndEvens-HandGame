package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * This class implements the Strategy interface. This strategy involves generating a random number
 * between 0 and 5.
 */
public class RandomStrategy implements Strategy {

  /**
   * This method generates a random number between 0 and 5.
   *
   * @param round round of the game
   * @param oddCount number of odd numbers of human player
   * @param evenCount number of even numbers of human player
   * @param choice choice of the AI player
   * @return int random number generated
   */
  @Override
  public int play(int round, int oddCount, int evenCount, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
