# Mastermind Game in Java

## Project Overview
This project is a console-based Java implementation of the classic code-breaking game **Mastermind**. It features interactive, two-way gameplay where you can guess the computer's secret code, or challenge the computer's AI (elimination algorithm) to break yours.

## Game Settings
By default, the game uses the following standard configuration, which can be modified directly in the `MasterMind.java` class:
* **Code Length (`codeLenght`):** 4
* **Number of Colors (`colorNumber`):** 6 (represented as digits 1-6)

## Game Modes
* **Mode 1 (Computer Guesses):** You set a secret code, and the computer uses its algorithm to guess it.
* **Mode 2 (Player Guesses):** The computer generates a random secret code, and you try to guess it.

## Visual Feedback System
When playing, the game uses the `PlayerFeedback` class to print visual feedback for each guess. The printed characters indicate your accuracy:
* **`C` (Correct / Black marker):** You guessed the right color (number) in the exact correct position.
* **`B` (White marker):** You guessed a correct color (number), but it is placed in the wrong position.
* **`X` (Miss):** The guessed color is completely incorrect and does not exist in the secret code.

## How the Computer AI Works
The computer uses an intelligent elimination algorithm inside the `computerPlayer.java` class to crack the code:
* **Initialization:** It recursively generates a complete list of all possible code combinations based on the configured length and colors.
* **Guessing:** It makes a move by picking the first available code from its list of possibilities.
* **Filtering:** After receiving feedback for its guess, the algorithm evaluates all remaining codes. It keeps only the combinations that would produce the *exact same feedback* if they were the true secret code. This rapidly narrows down the search space until the code is cracked.

## How to Run
1. Compile the Java files using your preferred IDE or command line (`javac`).
2. Run the `MasterMind` class to start the application.
3. Follow the on-screen prompts to select your mode. Input your guesses or secret codes as a continuous string of numbers (e.g., `1234`).
