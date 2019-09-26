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
		//TODO return a String[] of all the BikeParts
		//CHARLIE IS DOING THIS
		
		return null;
	}
	
	
	public String[] sortNumber()
	{
		//TODO return a String[] of all the BikeParts
		//CHARLIE IS DOING THIS
		
		return null;
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
