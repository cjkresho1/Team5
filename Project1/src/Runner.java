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
	
	public static void main(String[] args)
	{
		//TODO create new Warehouse from database file
		Warehouse warehouse = new Warehouse("warehouseDB.txt");
		Scanner scan = new Scanner(System.in);
		//TODO loop over user I/O process
		
		
		while(true)
		{
			printOptions();
			int choice = getChoice(scan.next());
			
			switch(choice)
			{
			case 1: //Read
				System.out.println("Please enter a filename for delivery: ");
				warehouse.read(scan.next());
				break;
			case 2: //Enter
				System.out.println("Please enter a part:");
				warehouse.enter(scan.next());
				break;
			case 3: //Sell
				System.out.println("Please enter a party number: ");
				String temp = warehouse.sell(scan.nextInt());
				if (!temp.contentEquals(""))
				{
					System.out.println(temp);
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					System.out.println("Product sold at: " + dtf.format(LocalDateTime.now()));
				}
				break;
			case 4: //Display
				System.out.println("Please enter the part name: ");
				System.out.println(warehouse.display(scan.next()));
				break;
			case 5: //SortName
				String[] tempArray = warehouse.sortName();
				for (int i = 0; i < tempArray.length; i++)
				{
					System.out.println(tempArray[i]);
				}
				break;
			case 6: //SortNumber
				String[] numberArray = warehouse.sortName();
				for (int i = 0; i < numberArray.length; i++)
				{
					System.out.println(numberArray[i]);
				}
				break;
			case 7: //Quit
				warehouse.quit("warehouseDB.txt");
				break;
			default:
				System.out.println("Invalid input, please try again");
			}
			
		}
		//TODO update database file and exit
	}
	
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
