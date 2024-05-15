package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {

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
