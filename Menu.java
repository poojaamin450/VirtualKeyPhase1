package VirtualK;

public class Menu {
	public static void printWelcomeScreen(String appName, String developerName) {
		String companyDetails = String.format(
				 "** Welcome to %s.com. \n" + "** Developed by %s.\n"
				, appName, developerName);
		}

	public static void displayMenu() {
		String menu = "Select an option  below and press Enter \n"
				+ "1) Retrieve all files inside \"main\" folder\n" + "2) Display menu \n"
				+ "3) Exit \n";
		System.out.println(menu);

	}

	public static void displayFileMenuOptions() {
		String fileMenu = "Select an option  below and press Enter\n"
				+ "1) Add a file to \"main\" folder\n" + "2) Delete a file from \"main\" folder\n"
				+ "3) Search for a file from \"main\" folder\n" + "4) Show Previous Menu\n" + "5) Exit program\n";


		System.out.println(fileMenu);
	}

}


