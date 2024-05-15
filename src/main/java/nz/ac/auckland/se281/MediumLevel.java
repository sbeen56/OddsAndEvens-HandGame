package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumLevel implements Level {
  private Strategy strategy;

  @Override
  public int getMove(String winner, int round, int oddCount, int evenCount, Choice choice) {
    if (round < 4) {
      this.strategy = new RandomStrategy();
    } else {
      this.strategy = new TopStrategy();
    }
    return strategy.play(round, oddCount, evenCount, choice);
  }
}
