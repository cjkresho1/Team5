import java.util.Comparator;
import java.util.LinkedList;

/**
 * Stores a list of parts and their quantities stored.
 * @author Group5
 */
public class Warehouse 
{
	/**
	 * Name of the warehouse.
	 */
	private String name;
	
	/**
	 * All parts contained in the warehouse.
	 */
	private LinkedList<PartQuantity> parts;
	
	/**
	 * Creates a new warehouse with the provided name.
	 * @param name name of the warehouse
	 */
	public Warehouse(String name)
	{
		parts = new LinkedList<PartQuantity>();
		this.name = name;
	}
	
	/**
	 * Add a new part to the warehouse, or add to the quantity of an existing part.
	 * @param name name of part
	 * @param num number of part
	 * @param quantity quantity to be added
	 */
	public void add(String name, int num, int quantity)
	{
		
	}
	
	/**
	 * Add a new part to the warehouse, or add to the quantity of an existing part.
	 * @param part complete PartQuantity on the part to be added
	 */
	public void add(PartQuantity part)
	{
		
	}
	
	/**
	 * Add a new part to the warehouse, or add to the quantity of an existing part.
	 * @param part complete BikePart on the part to be added
	 */
	public void add(BikePart part)
	{
		add(new PartQuantity(part));
	}
	
	/**
	 * Attempt to sell a part from the warehouse. Decrement quantity if sold.
	 * @param partNum number of part to be sold
	 * @return Information about part sold. Empty string (ie: "") if sale isn't possible.
	 */
	public String sell(int partNum)
	{
		return "";
	}
	
	/**
	 * Return a sorted array of the parts in the warehouse.
	 * @return a sorted array of the parts, by name.
	 */
	public PartQuantity[] sortName()
	{
		PartQuantity[] val = new PartQuantity[parts.size()];

		/*
		 * This sorts the warehouse inventory based on Name. This is accomplished by
		 * using the built in .sort(Comparator<T>) method. The Comparator<PartQuantity>
		 * passed to the method is a custom, overridden Comparator that is designed to
		 * compare the Names.
		 */
		parts.sort(new Comparator<PartQuantity>() 
		{
			@Override
			public int compare(PartQuantity b1, PartQuantity b2)
			{
				return b1.getName().compareToIgnoreCase(b2.getName());
			}
		});

		for (int i = 0; i < parts.size(); i++) 
		{
			val[i] = parts.get(i);
		}

		return val;
	}
	
	/**
	 * Return a sorted array of the parts in the warehouse.
	 * @return a sorted array of the parts, by number.
	 */
	public PartQuantity[] sortNumber()
	{
		PartQuantity[] val = new PartQuantity[parts.size()];

		/*
		 * This sorts the warehouse inventory based on PartNumber. This is accomplished
		 * by using the built in .sort(Comparator<T>) method. The Comparator<PartQuantity>
		 * passed to the method is a custom, overridden Comparator that is designed to
		 * compare the numbers.
		 */
		parts.sort(new Comparator<PartQuantity>() 
		{
			@Override
			public int compare(PartQuantity b1, PartQuantity b2) 
			{
				return b1.getNum() - b2.getNum();
			}
		});

		for (int i = 0; i < parts.size(); i++) 
		{
			val[i] = parts.get(i);
		}

		return val;
	}
	
	/**
	 * @param name name of the warehouse
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * @return name of the warehouse
	 */
	public String getName()
	{
		return name;
	}
}
