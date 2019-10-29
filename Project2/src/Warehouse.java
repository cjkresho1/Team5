import java.util.LinkedList;

/**
 * @author Group5
 */
public class Warehouse 
{
	private String name;
	private LinkedList<PartQuantity> parts;
	
	
	public Warehouse(String name)
	{
		parts = new LinkedList<PartQuantity>();
		this.name = name;
		
	}
	
	public void add(String name, int num, int quantity)
	{
		
	}
	
	public void add(PartQuantity part)
	{
		
	}
	
	public void add(BikePart part)
	{
		add(new PartQuantity(part));
	}
	
	
	public String sell(int partNum)
	{
		return "";
	}
	
	
	public String display(String partName)
	{
		return "";
		
	}
	
	
	public String[] sortName()
	{
		return null;
		
	}
	
	
	public String[] sortNumber()
	{
		return null;
		
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
}
