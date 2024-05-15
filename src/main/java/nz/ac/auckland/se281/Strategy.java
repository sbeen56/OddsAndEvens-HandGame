package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** This interface defines the methods that an AI player should implement. */
public interface Strategy {
  int play(int round, int oddCount, int evenCount, Choice choice);
}
