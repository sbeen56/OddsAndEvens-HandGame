package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round;
  private String player;
  private ArtIntPlayer aiPlayer;
  private int oddCount;
  private int evenCount;
  private String winner;
  private int playerWinCount;
  private Choice playerChoice;

  /**
   * This method starts a new game by reseting everything. It also initializes the playerChoice
   * whether the human player choses ODD or EVEN and aiPlayer based on the difficulty.
   *
   * @param difficulty difficulty of the game
   * @param choice choice of the player
   * @param options name of the player
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // Print welcome message.
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    // Initialize the game.
    player = options[0];
    round = 1;
    oddCount = 0;
    evenCount = 0;
    winner = null;
    playerWinCount = 0;
    playerChoice = choice;
    aiPlayer = ArtIntPlayerFactory.createAiPlayer(difficulty);
  }

  /**
   * This method plays a round of the game. It asks the player for input until a valid input is
   * given. It gets a random number for the AI player and calculates the sum of the two numbers. It
   * then determines the winner based on the sum and the choices of the players. It prints the
   * outcome of the round. It also keeps track of the number of rounds played and the number of wins
   * for the player.
   */
  public void play() {
    // Check if the game has started and return if not.
    if (player == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Start the game by setting the AI player choice based on the player choice.
    aiPlayer.setArtIntPlayer(playerChoice);

    // Ask human player for input.
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();

    // Check if the input is valid and ask until a valid input is given. Check if the input is an
    // integer between 0 and 5.
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

    // Print the human player finger.
    MessageCli.PRINT_INFO_HAND.printMessage(player, input);

    // Make a finger for the AI player and print it.
    aiPlayer.makeMove(winner, round, oddCount, evenCount);
    aiPlayer.printMove();

    // Calculate the sum of the fingers and determine the winner.
    int sum = Integer.parseInt(input) + aiPlayer.getMove();

    // Determine the winner of the round when the sum is even considering the player choice. Then
    // print the outcome of the round.
    if (Utils.isEven(sum)) {
      if (aiPlayer.getArtIntChoice() == Choice.EVEN) {
        winner = aiPlayer.getArtIntName();
      } else {
        winner = player;
      }
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", winner);
    }

    // Determine the winner of the round when the sum is odd considering the player choice. Then
    // print the outcome of the round.
    if (Utils.isOdd(sum)) {
      if (aiPlayer.getArtIntChoice() == Choice.ODD) {
        winner = aiPlayer.getArtIntName();
      } else {
        winner = player;
      }
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", winner);
    }

    // Update the statistics of the game by incrementing the number of wins for the human player.
    if (winner == player) {
      playerWinCount++;
    }

    // Update the statistics of the game by incrementing the number of odd and even numbers of the
    // human player.
    if (Utils.isEven(Integer.parseInt(input))) {
      evenCount++;
    } else {
      oddCount++;
    }

    // Increment the round number at the end of the round to be ready for the next round.
    round++;
  }

  /**
   * This method ends the game and prints the number of wins for the player and the AI player, and
   * the overall winner of the game. It resets the player to null. If the game has not started, it
   * prints a message saying the game has not been started.
   */
  public void endGame() {
    // Check if the game has started and return if not.
    if (player == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Calculate the number of lost rounds for the player.
    int playerLostCount = round - playerWinCount - 1;

    // Print the number of wins for the human player and the AI player.
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        player, Integer.toString(playerWinCount), Integer.toString(playerLostCount));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", Integer.toString(playerLostCount), Integer.toString(playerWinCount));

    // Print the overall winner of the game depending on the number of wins.
    if (playerWinCount > playerLostCount) {
      MessageCli.PRINT_END_GAME.printMessage(player);
    } else if (playerWinCount == playerLostCount) {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    } else {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    }

    // Reset the player to null for the next game.
    player = null;
  }

  /**
   * This method shows the statistics of the game. It prints the number of wins and losts for the
   * player and the AI player. If the game has not started, it prints a message saying the game has
   * not been started.
   */
  public void showStats() {
    // Check if the game has started and return if not.
    if (player == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Calculate the number of lost rounds for the player.
    int playerLostCount = round - playerWinCount - 1;

    // Print the number of wins for the human player and the AI player.
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        player, Integer.toString(playerWinCount), Integer.toString(playerLostCount));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", Integer.toString(playerLostCount), Integer.toString(playerWinCount));
  }
}
