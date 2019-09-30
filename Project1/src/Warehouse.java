import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class Warehouse 
{
	private LinkedList<BikePart> parts;

	public Warehouse() 
	{
		parts = new LinkedList<BikePart>();
	}

	public Warehouse(String dbFile) 
	{
		parts = new LinkedList<BikePart>();
		File file = new File(dbFile);

		if (file.exists()) 
		{
			try 
			{
				Scanner scan = new Scanner(file);
				while (scan.hasNextLine()) 
				{
					String temp = scan.nextLine();
					String[] data = temp.split(",");

					parts.add(new BikePart(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2]),
							Double.parseDouble(data[3]), Boolean.getBoolean(data[4]), Integer.parseInt(data[5])));
				}
				scan.close();
			} 
			catch (FileNotFoundException e) 
			{
				System.out.print("HOW DID YOU DO THIS");
				System.exit(1);
				// THIS SHOULD NEVER EVER HAPPEN BUT IF IT DOES...HOW?
			}
		}
	}

	public boolean read(String invFile) 
	{
		File file = new File(invFile);
		try 
		{
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) 
			{
				String temp = scan.nextLine();
				String[] data = temp.split(",");
				String partName = data[0];
				
				int i = 0;
				while (i < parts.size())
				{
					if(parts.get(i).getName().equals(partName)) 
					{
						parts.get(i).setQuantity((parts.get(i).getQuantity())+Integer.parseInt(data[5]));
						i = parts.size();
						break;
					} 
					else 
					{
						if (i == (parts.size() - 1)) 
						{
							parts.add(new BikePart(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2]),
									Double.parseDouble(data[3]), Boolean.getBoolean(data[4]), Integer.parseInt(data[5])));
							i++;
						} 
						else 
						{
							i++;
						}
					}
				}	
			}
			scan.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.print("Please enter a valid file name.");
			return false;
		}
		
		return true;
	}

	public boolean enter(String info) {
		
		String[] partInfo = info.split(",");

		BikePart newPart = new BikePart(partInfo[0], Integer.parseInt(partInfo[1]), Double.parseDouble(partInfo[2]),
				Double.parseDouble(partInfo[3]), Boolean.parseBoolean(partInfo[4]), Integer.parseInt(partInfo[5]));
		
		boolean exists = false;
		
		for (int i = 0; i < parts.size(); i++) 
		{
			if (newPart.getNum()==parts.get(i).getNum()) 
			{
				parts.get(i).setQuantity((parts.get(i).getQuantity()) + newPart.getQuantity());
				i = parts.size();
				exists = true;
			}
		}
		if (!exists) 
		{
			parts.add(newPart);
		}

		return exists;
	}

	public String sell(int partNum) 
	{
		String partInfo = "";
		for (int i = 0; i < parts.size(); i++) 
		{
			if (partNum == parts.get(i).getNum()) 
			{
				partInfo = parts.get(i).getName() + " - $" + parts.get(i).getPrice();
				if (parts.get(i).isOnSale())
				{
					partInfo = partInfo + ", This part is on sale";
				}
				else
				{
					partInfo = partInfo + ", This part is not on sale";
				}
				parts.get(i).setQuantity(parts.get(i).getQuantity() - 1);
				i = parts.size();
			}
		}

		return partInfo;
	}

	public String display(String partName)
	/*
	 * TODO make sure partInfo is formatted acceptably
	 */
	{
		String partInfo = "";
		for (int i = 0; i < parts.size(); i++) 
		{
			if (parts.get(i).getName().equals(partName)) 
			{
				partInfo = partName + " - $" + parts.get(i).getPrice();
				i = parts.size();
			}
		}
		return partInfo;
	}

	public String[] sortName() 
	{
		String[] val = new String[parts.size()];

		/*
		 * This sorts the warehouse inventory based on Name. This is accomplished by
		 * using the built in .sort(Comparator<T>) method. The Comparator<BikePart>
		 * passed to the method is a custom, overridden Comparator that is designed to
		 * compare the Names.
		 */
		parts.sort(new Comparator<BikePart>() 
		{
			@Override
			public int compare(BikePart b1, BikePart b2)
			{
				return b1.getName().compareToIgnoreCase(b2.getName());
			}
		});

		for (int i = 0; i < parts.size(); i++) 
		{
			val[i] = parts.get(i).toString();
		}

		return val;
	}

	public String[] sortNumber() 
	{
		String[] val = new String[parts.size()];

		/*
		 * This sorts the warehouse inventory based on PartNumber. This is accomplished
		 * by using the built in .sort(Comparator<T>) method. The Comparator<BikePart>
		 * passed to the method is a custom, overridden Comparator that is designed to
		 * compare the Names.
		 */
		parts.sort(new Comparator<BikePart>() 
		{
			@Override
			public int compare(BikePart b1, BikePart b2) 
			{
				return b1.getNum() - b2.getNum();
			}
		});

		for (int i = 0; i < parts.size(); i++) 
		{
			val[i] = parts.get(i).toString();
		}

		return val;
	}

	public void quit(String file) {

		/*
		 * This method deletes the current Warehouse file and then creates a new one
		 * with the updated part info based on everything the user has given it so
		 * far. TODO probably change the system.exit catch error to something that
		 * doesn't quit
		 */
		File oldDB = new File(file);
		if (oldDB.exists())
		oldDB.delete();
		File newDB = new File(file);		
		
		try {
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newDB));
			
			for (int i = 0; i < parts.size(); i++) {
				BikePart tempPart = parts.get(i);
				String partInfo = tempPart.toString();
				bufferedWriter.write(partInfo);
				bufferedWriter.newLine();
			}			
			
			bufferedWriter.close();
			
		} catch (IOException e) {
			System.out.println("Please enter correct file name.");
			System.exit(1);
		}
	}
}
