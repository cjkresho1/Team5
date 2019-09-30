import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Runner 
{
	private static final String[] CHOICES = {"Read",
	                                         "Enter",
	                                         "Sell",
	                                         "Display",
	                                         "SortName",
	                                         "SortNumber",
	                                         "Quit"};
	private static final String WAREHOUSE_DB = "warehouseDB.txt";
	
	/**
	 * Main method of the program. Loops over user input and output.
	 * @param args CMD line arguments
	 */
	public static void main(String[] args)
	{
		//create new Warehouse from database file
		Warehouse warehouse = new Warehouse(WAREHOUSE_DB);
		Scanner scan = new Scanner(System.in);
		
		//loop over user I/O process
		while(true)
		{
			printOptions();
			int choice = getChoice(scan.next());
			
			switch(choice)
			{
			case 0: //Read
				System.out.println("Please enter a filename for delivery: ");
				warehouse.read(scan.next());
				break;
			case 1: //Enter
				System.out.println("Please enter a part:");
				warehouse.enter(scan.next());
				break;
			case 2: //Sell
				System.out.println("Please enter a party number: ");
				String temp = warehouse.sell(scan.nextInt());
				if (!temp.contentEquals(""))
				{
					System.out.println(temp);
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					System.out.println("Product sold at: " + dtf.format(LocalDateTime.now()));
				}
				else
				{
					System.out.println("The part could not be found");
				}
				break;
			case 3: //Display
				System.out.println("Please enter the part name: ");
				System.out.println(warehouse.display(scan.next()));
				break;
			case 4: //SortName
				String[] tempArray = warehouse.sortName();
				for (int i = 0; i < tempArray.length; i++)
				{
					System.out.println(tempArray[i]);
				}
				break;
			case 5: //SortNumber
				String[] numberArray = warehouse.sortNumber();
				for (int i = 0; i < numberArray.length; i++)
				{
					System.out.println(numberArray[i]);
				}
				break;
			case 6: //Quit
				warehouse.quit(WAREHOUSE_DB);
				scan.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input, please try again");
			}
		}
	}
	
	/**
	 * Helper method to print out the user options.
	 */
	private static void printOptions()
	{
		System.out.println("Please select your option from the following "
				+ "menu:");
		System.out.println("Read: Read an inventory delivery file");
		System.out.println("Enter: Enter a part");
		System.out.println("Sell: Sell a part");
		System.out.println("Display: Display a part");
		System.out.println("SortName: Sort parts by part name");
		System.out.println("SortNumber: Sort parts by part number");
		System.out.println("Quit:");
		System.out.println("Enter your choice:");
	}
	
	/**
	 * Helper method to manage user selection
	 * @param val string containing the user selection
	 * @return int representation of the user selection. -1 if not a valid input
	 */
	private static int getChoice(String val)
	{
		for (int i = 0; i < CHOICES.length; i++)
		{
			if (val.equalsIgnoreCase(CHOICES[i]))
			{
				return i;
			}
		}
		
		return -1;
	}
}
