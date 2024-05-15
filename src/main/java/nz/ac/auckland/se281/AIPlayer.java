package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public interface AIPlayer {
  void setAIPlayer(Choice choice);

  int makeMove(String winner, int round, int oddCount, int evenCount);

  int getMove();

  Choice getAIChoice();

  String getAIName();

  void printMove();
}
