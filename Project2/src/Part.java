/**
 * Part stores a linked name and number. Meant as a parent for inheritance.
 * @author Group5
 */
public class Part 
{
	/**
	 * Name of the part.
	 */
	protected String name;
	
	/**
	 * Number of the part.
	 */
	protected int num;
	
	/**
	 * Creates a new Part with trash values.
	 */
	public Part()
	{
		name = "";
		num = -1;
	}
	
	/**
	 * Creates a new Part.
	 * @param name the part name
	 * @param num the part number
	 */
	public Part(String name, int num)
	{
		this.name = name;
		this.num = num;
	}

	/**
	 * @return the part name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the new part name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the part number
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the new part number to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
}
