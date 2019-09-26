import java.util.Comparator;
import java.util.LinkedList;

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
		parseFile(dbFile);
	}
	
	public boolean read(String file)
	{
		/*TODO use file to update parts database. Create new entries, and 
		 * update existing ones. Quantity are additive. 
		 */
		
		return false;
	}
	
	public boolean enter(String info)
	{
		/*TODO parse part info, and add part to parts database. If part already
		 * exists, update existing one.
		 */
		
		return false;
	}
	
	public String sell(int partNum)
	{
		/*TODO find part based on partNum. Return a string with:
		 * Name and Price, Sale Status, and Time of Sale
		 * Decrement part quantity.
		 * If the part doesn't exist, return an empty string to indicate failure
		 */
		
		return "";
	}
	
	public String display(String partName)
	{
		/*TODO find part based on partName. Return a string with:
		 * Name and Price
		 * If the part doesn't exist, return an empty string to indicate failure
		 */
		
		return "";
	}
	
	public String[] sortName()
	{
		String[] val = new String[parts.size()];
		
		
		/* This sorts the warehouse inventory based on Name. This is accomplished by 
		 * using the built in .sort(Comparator<T>) method. The Comparator<BikePart>
		 * passed to the method is a custom, overridden Comparator that is designed 
		 * to compare the Names.
		 */
		parts.sort(new Comparator<BikePart>() 
		{
			@Override
			public int compare(BikePart b1, BikePart b2)
			{
				return b1.getName().compareTo(b2.getName());
			}
		}	
		);
		
		for (int i = 0; i > parts.size(); i++)
		{
			val[i] = parts.get(i).toString();
		}
		
		return val;
	}
	
	
	public String[] sortNumber()
	{
String[] val = new String[parts.size()];
		
		
		/* This sorts the warehouse inventory based on PartNumber. This is accomplished 
		 * by using the built in .sort(Comparator<T>) method. The 
		 * Comparator<BikePart> passed to the method is a custom, overridden 
		 * Comparator that is designed to compare the Names.
		 */
		parts.sort(new Comparator<BikePart>() 
		{
			@Override
			public int compare(BikePart b1, BikePart b2)
			{
				return b1.getNum() - b2.getNum();
			}
		}	
		);
		
		for (int i = 0; i > parts.size(); i++)
		{
			val[i] = parts.get(i).toString();
		}
		
		return val;
	}
	
	public void quit(String file)
	{
		/*TODO update file to reflect current warehouse database. If file
		 * exists, delete content and overwrite. 
		 */
	}
	
	private boolean parseFile(String file)
	{
		/*TODO use file to update parts database. Create new entries, and 
		 * update existing ones.
		 */
		
		return false;
	}
}
