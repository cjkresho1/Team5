import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Group5
 */
public class Network 
{
	private Warehouse warehouse;
	private LinkedList<Warehouse> vans;
	private LinkedList<PartInfo> parts;
	
	
	public Network()
	{
		warehouse = new Warehouse("");
		vans = new LinkedList<Warehouse>();
		parts = new LinkedList<PartInfo>();
	}
	
	
	public Network(String filename)
	{
		
	}
	
	
	public boolean deliver(String filename)
	{
		return false;
	}
	
	
	public boolean add(String part)
	{
		return false;
	}
	
	
	public String display(String partName)
	{
		return "";
	}
	
	
	public String sell(int partNum, String warehouse)
	{
		return "";
	}
	
	
	public String[] sortName(String warehouse)
	{
		return null;
	}
	
	
	public String[] sortNum(String warehouse)
	{
		return null;
	}
	
	
	public boolean addVan(String vanName)
	{
		return false;
	}
	
	
	public boolean transfer(String filename)
	{
		return false;
	}
	
	
	public boolean quit(String filename)
	{
		return false;
	}
	
	/*********************************HELPER METHODS HERE USE ME PLZ***************/
	
	
	private boolean addPartToDatabase(PartInfo part)
	{
		return false;
	}
	
	private PartInfo getPartFromDatabase(int partNum)
	{
		return null;
	}
	
	private PartInfo getPartFromDatabase(String partName)
	{
		return null;
	}
}
