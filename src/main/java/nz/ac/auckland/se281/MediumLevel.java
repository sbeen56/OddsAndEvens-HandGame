package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumLevel implements Level {
  private Strategy strategy;

  @Override
  public int getMove(int round, int oddCount, int evenCount, Choice choice) {
    this.strategy = new RandomStrategy();
    return strategy.play(round, oddCount, evenCount, choice);
  }
}
