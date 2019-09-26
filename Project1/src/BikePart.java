
public class BikePart 
{
	private String name;
	private int num;
	private double price;
	private double salePrice;
	private boolean onSale;
	private int quantity;
	
	public BikePart()
	{
		name = "";
		num = -1;
		price = -1;
		salePrice = -1;
		onSale = false;
		quantity = -1;
	}
	
	/**
	 * @return A string representation of the bike part:
	 * 
	 */
	public String toString()
	{
		//TODO Charlie is doing this
		
		return "";
	}

	
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the num
	 */
	public int getNum()
	{
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num)
	{
		this.num = num;
	}

	/**
	 * @return the price
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}

	/**
	 * @return the salePrice
	 */
	public double getSalePrice()
	{
		return salePrice;
	}

	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(double salePrice)
	{
		this.salePrice = salePrice;
	}

	/**
	 * @return the onSale
	 */
	public boolean isOnSale()
	{
		return onSale;
	}

	/**
	 * @param onSale the onSale to set
	 */
	public void setOnSale(boolean onSale)
	{
		this.onSale = onSale;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity()
	{
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
}
