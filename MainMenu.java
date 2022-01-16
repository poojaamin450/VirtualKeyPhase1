package VirtualK;

import VirtualK.FileOp;
import VirtualK.Woption;
import VirtualK.Menu;

public class MainMenu {
public static void main(String[] args) {
		
		// Create "main" folder if not present in current folder structure
		FileOp.createMainFolderIfNotPresent("main");
		
		Menu.printWelcomeScreen("VirtualK", "Pooja");
		
		Woption.handleWelcomeScreenInput();
	}
}
