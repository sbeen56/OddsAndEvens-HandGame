package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardLevel implements Level {
  private Strategy strategy;

  @Override
  public int getMove(String winner, int round, int oddCount, int evenCount, Choice choice) {
    if (round < 4) {
      this.strategy = new RandomStrategy();
    } else {
      if (!winner.equals("HAL-9000")) {
        if (strategy instanceof RandomStrategy) {
          this.strategy = new TopStrategy();
        } else {
          this.strategy = new RandomStrategy();
        }
      }
    }

    return strategy.play(round, oddCount, evenCount, choice);
  }
}
