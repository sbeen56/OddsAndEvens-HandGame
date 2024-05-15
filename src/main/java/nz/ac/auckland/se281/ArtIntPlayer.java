package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** This interface defines the methods that an AI player should implement. */
public interface ArtIntPlayer {
  void setStrategy(Strategy strategy);

  void setArtIntPlayer(Choice choice);

  int makeMove(String winner, int round, int oddCount, int evenCount);

  int getMove();

  Choice getArtIntChoice();

  String getArtIntName();

  void printMove();
}
