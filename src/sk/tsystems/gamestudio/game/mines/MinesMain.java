package sk.tsystems.gamestudio.game.mines;

import sk.tsystems.gamestudio.game.mines.consoleUI.ConsoleUI;
import sk.tsystems.gamestudio.game.mines.core.Field;

public class MinesMain {
	public void startMines() {
		Field field = new Field(9, 9, 2);
		ConsoleUI ui = new ConsoleUI(field);
		ui.play();

	}


}
