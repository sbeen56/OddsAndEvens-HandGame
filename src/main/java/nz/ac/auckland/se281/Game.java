package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round;
  private String player;
  private AIPlayer aiPlayer;
  private int oddCount;
  private int evenCount;
  private String winner;
  private int playerWinCount;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    player = options[0];
    round = 1;
    oddCount = 0;
    evenCount = 0;
    winner = null;
    playerWinCount = 0;
    aiPlayer = new AIPlayer(difficulty, choice);
  }

  public void play() {
    if (player == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    aiPlayer.setPlayer(oddCount, evenCount, round, winner);
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();

    Boolean validInteger = false;
    while (!validInteger) {
      if (Utils.isInteger(input)) {
        if (Integer.parseInt(input) >= 0 && Integer.parseInt(input) <= 5) {
          validInteger = true;
        }
      }
      if (validInteger) {
        break;
      } else {
        MessageCli.INVALID_INPUT.printMessage();
        input = Utils.scanner.nextLine();
      }
    }

    MessageCli.PRINT_INFO_HAND.printMessage(player, input);
    aiPlayer.printMove();

    int sum = Integer.parseInt(input) + aiPlayer.getMove();
    if (Utils.isEven(sum)) {
      if (aiPlayer.getChoice() == Choice.EVEN) {
        winner = aiPlayer.getName();
      } else {
        winner = player;
      }
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", winner);
    }

    if (Utils.isOdd(sum)) {
      if (aiPlayer.getChoice() == Choice.ODD) {
        winner = aiPlayer.getName();
      } else {
        winner = player;
      }
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", winner);
    }

    if (winner == player) {
      playerWinCount++;
    }

    if (Utils.isEven(Integer.parseInt(input))) {
      evenCount++;
    } else {
      oddCount++;
    }

    round++;
  }

  public void endGame() {
    int playerLostCount = round - playerWinCount - 1;
    if (playerWinCount > playerLostCount) {
      MessageCli.PRINT_END_GAME.printMessage(player);
    } else if (playerWinCount == playerLostCount) {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    } else {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    }
  }

  public void showStats() {
    if (player == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    int playerLostCount = round - playerWinCount - 1;
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        player, Integer.toString(playerWinCount), Integer.toString(playerLostCount));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", Integer.toString(playerLostCount), Integer.toString(playerWinCount));
  }
}
