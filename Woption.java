package VirtualK;

import java.util.List;
import java.util.Scanner;

import VirtualK.FileOp;
import VirtualK.Woption;
import VirtualK.Menu;

public class Woption {
	public static void handleWelcomeScreenInput() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				Menu.displayMenu();
				int input = sc.nextInt();

				switch (input) {
				case 1:
					FileOp.displayAllFiles("main");
					break;
				case 2:
					Woption.handleFileMenuOptions();
					break;
				case 3:
					System.out.println(" exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select an  option .");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleWelcomeScreenInput();
			} 
		} while (running == true);
	}
	
	public static void handleFileMenuOptions() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				Menu.displayFileMenuOptions();
				FileOp.createMainFolderIfNotPresent("main");
				
				int input = sc.nextInt();
				switch (input) {
				case 1:
					// File Add
					System.out.println("Enter the  file name to be added to the \"main\" folder");
					String fileToAdd = sc.next();
					
					FileOp.createFile(fileToAdd, sc);
					
					break;
				case 2:
					// File/Folder delete
					System.out.println("Enter the  file to be deleted from \"main\" folder");
					String fileToDelete = sc.next();
					
					FileOp.createMainFolderIfNotPresent("main");
					List<String> filesToDelete = FileOp.displayFileLocations(fileToDelete, "main");
					
					String deletionPrompt = "\nSelect index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
					System.out.println(deletionPrompt);
				
					int idx = sc.nextInt();
					
					if (idx != 0) {
						FileOp.deleteFileRecursively(filesToDelete.get(idx - 1));
					} else {
						
						
						for (String path : filesToDelete) {
							FileOp.deleteFileRecursively(path);
						}
					}
					

					break;
				case 3:
					
					System.out.println("Enter the name of the file to be searched from \"main\" folder");
					String fileName = sc.next();
					
					FileOp.createMainFolderIfNotPresent("main");
					FileOp.displayFileLocations(fileName, "main");

					
					break;
				case 4:
					
					return;
				case 5:
					
					System.out.println("Thank you");
					running = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select an option");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (running == true);
	}
}
