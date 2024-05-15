package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * This class implements the Strategy interface. This strategy involves monitors how frequently the
 * human player chooses odd or even numbers.
 */
public class TopStrategy implements Strategy {

  /**
   * This method generates a random number between 0 and 5 when the number of odd numbers of human
   * player is greater than the number of even numbers of human player. If the number of even
   * numbers of human player is greater than the number of odd numbers of human player, it generates
   * a random even number. If the number of odd numbers of human player is equal to the number of
   * even numbers of human player, it generates a random number between 0 and 5.
   *
   * @param round round of the game
   * @param oddCount number of odd numbers of human player
   * @param evenCount number of even numbers of human player
   * @param choice choice of the AI player
   * @return int random number generated
   */
  @Override
  public int play(int round, int oddCount, int evenCount, Choice choice) {
    if (oddCount > evenCount) {
      if (choice == Choice.ODD) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomOddNumber();
      }
    } else if (evenCount > oddCount) {
      if (choice == Choice.ODD) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomEvenNumber();
      }
    } else {
      return Utils.getRandomNumberRange(0, 5);
    }
  }
}
