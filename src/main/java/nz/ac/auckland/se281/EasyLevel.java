package nz.ac.auckland.se281;

public class EasyLevel implements Level {
  private Strategy strategy;

  @Override
  public int getMove() {
    this.strategy = new RandomStrategy();
    return strategy.play();
  }
}
