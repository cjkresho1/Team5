import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author Group5
 */
public class Runner 
{
	private static final String[] CHOICES = {"Read",
	                                         "Enter",
	                                         "Sell",
	                                         "Display",
	                                         "SortName",
	                                         "SortNumber",
	                                         "Transfer",
	                                         "AddVan",
	                                         "Quit"};
	private static final String WAREHOUSE_DB = "warehouseDB.txt";
	
	/**
	 * Main method of the program. Loops over user input and output.
	 * @param args CMD line arguments
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		//create new Warehouse from database file 
		Network network = new Network(WAREHOUSE_DB);
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
				network.deliver(scan.next());
				break;
			case 1: //Enter
				System.out.println("Please enter a part name:");
				String name = scan.next();
				
				System.out.println("Please enter a part number:");
				int num = scan.nextInt();
				
				System.out.println("Please enter a price:");
				double price = scan.nextDouble();
				
				System.out.println("Please enter a sale price:");
				double salePrice = scan.nextDouble();
				
				System.out.println("Please enter true for on sale, false otherwise");
				boolean onSale = scan.nextBoolean();
				
				System.out.println("Please enter quantity:");
				int quantity = scan.nextInt();
				
				System.out.println("Please enter warehouse to add to");
				String ware = scan.next();
				
				network.add(new BikePart(name, num, price, salePrice, onSale, quantity), ware);
				break;
			case 2: //Sell
				System.out.println("Please enter a part number: ");
				int partNum = scan.nextInt();
				System.out.println("Please enter the target warehouse");
				String temp = network.sell(partNum, scan.next());
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
				System.out.println(network.display(scan.next()));
				break;
			case 4: //SortName
				System.out.println("Enter the warehouse to print, or type 'all' for all:");
				BikePart[] tempArray = network.sortName(scan.next());
				for (int i = 0; i < tempArray.length; i++)
				{
					System.out.println(tempArray[i].toString());
				}
				break;
			case 5: //SortNumber
				System.out.println("Enter the warehouse to print, or hit enter for all:");
				BikePart[] numberArray = network.sortNum(scan.next());
				for (int i = 0; i < numberArray.length; i++)
				{
					System.out.println(numberArray[i].toString());
				}
				break;
			case 6: //Transfer
				System.out.println("Enter transfer file name:");
				network.transfer(scan.next());
				break;
			case 7: //Add Van
				System.out.println("Enter van name:");
				network.addVan(scan.next());
				break;
			case 8: //Quit
				network.quit(WAREHOUSE_DB);
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
		System.out.println("Transfer: Read an inventory transfer file");
		System.out.println("Add Van: Add a new van");
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
