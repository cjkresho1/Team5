
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
		
		//TODO loop over user I/O process
		
		//TODO update database file and exit
	}
	
	private void printOptions()
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
	
	private int getChoice(String val)
	{
		for (int i = 0; i < CHOICES.length; i++)
		{
			if (val.equals(CHOICES[i]))
			{
				return i;
			}
		}
		
		return -1;
	}
}
