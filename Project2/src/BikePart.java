/**
 * 
 */

/**
 * @author Team5
 *
 */
public class BikePart 
{
	private String name;
	private int num;
	private double price;
	private double salePrice;
	private boolean onSale;
	private int quantity;
	
	/*
	 * Creates a new, empty BikePart. Should never be used unless values are to 
	 * be set right after.
	 */
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
	 * Creates a new custom BikePart
	 * @param name the name of the bike part
	 * @param num the part number
	 * @param listPrice the price the part is sold for
	 * @param salePrice the price to produce the part
	 * @param isBeingSold true if the part is on sale, false otherwise
	 * @param quantity the number of parts being stored
	 */
	public BikePart(String name, int num, double listPrice, double salePrice, 
			boolean isBeingSold, int quantity)
	{
		this.name = name;
		this.num = num;
		this.price = listPrice;
		this.salePrice = salePrice;
		this.onSale = isBeingSold;
		this.quantity = quantity;
	}
	
	/**
	 * @return A string representation of the bike part:
	 * 	partName,partNumber,listPrice,salePrice,onSale,quantity
	 */
	public String toString()
	{
		String val = String.format("%s,%d,%.2f,%.2f,", name, num, price,
				salePrice);
		
		if (onSale)
		{
			return val + "true," + quantity;
		}
		return val + "false," + quantity;
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
	 * @return the price, or the sale price if onSale is true
	 */
	public double getPrice()
	{
		//Ternary operator. Returns the proper price
		return (onSale) ? salePrice : price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price)
	{
		this.price = price;
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
