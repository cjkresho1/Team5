/**
 * Stores a part's name, number, and quantity stored.
 * @author Group5
 */
public class PartQuantity extends Part 
{
	/**
	 * Number of parts stored.
	 */
	protected int quantity;
	
	/**
	 * Creates a new PartQuantity with trash values.
	 */
	public PartQuantity()
	{
		super();
		quantity = -1;
	}
	
	/**
	 * Create a new PartQuantity.
	 * @param name part name
	 * @param num part number
	 * @param quantity number of parts stored
	 */
	public PartQuantity(String name, int num, int quantity)
	{
		super(name, num);
		this.quantity = quantity;
	}
	
	/**
	 * Creates a new PartQuantity from a BikePart.
	 * @param part BikePart supplying information
	 */
	public PartQuantity(BikePart part)
	{
		super(part.getName(), part.getNum());
		this.quantity = part.getQuantity();
	}
	
	/**
	 * @return the part quantity
	 */
	public int getQuantity()
	{
		return quantity;
	}
	
	/**
	 * @param quantity the new quantity to be set
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	/**
	 * Add to the existing quantity.
	 * @param quantity quantity to be added.
	 * @return new quantity.
	 */
	public int addQuantity(int quantity)
	{
		this.quantity += quantity;
		return this.quantity;
	}
	
	/**
	 * Decrement the quantity if quantity > 0.
	 * @return true if quantity is decremented, false if quantity <= 0.
	 */
	public boolean decrement()
	{
		if (quantity > 0)
		{
			quantity--;
		}
		else
		{
			return false;
		}
		
		return true;
	}
}
