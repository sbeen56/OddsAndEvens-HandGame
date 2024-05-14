package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round = 0;
  private String player;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    player = options[0];
    round++;
  }

  public void play() {
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
  }

  public void endGame() {}

  public void showStats() {}
}
