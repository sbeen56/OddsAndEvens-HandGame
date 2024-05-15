package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public interface Level {
  int getMove(int round, int oddCount, int evenCount, Choice choice);
}
