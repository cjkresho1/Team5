import java.util.LinkedList;

import java.lang.IllegalArgumentException;

import java.util.Scanner;

import java.io.File;

/**
 * Simulates a network of a primary warehouse, and a fleet of vans.
 * 
 * @author Group5
 */
public class Network {
	/**
	 * Name of the primary warehouse. No van can have this name.
	 */
	public static final String WAREHOUSE_NAME = "PRIMARY";

	/**
	 * Primary warehouse.
	 */
	private Warehouse warehouse;

	/**
	 * List of vans.
	 */
	private LinkedList<Warehouse> vans;

	/**
	 * Cumulative list of parts in all warehouses.
	 */
	private LinkedList<PartInfo> parts;

	/**
	 * Creates an empty network with no parts and no vans.
	 */
	public Network() {
		warehouse = new Warehouse(WAREHOUSE_NAME);
		vans = new LinkedList<Warehouse>();
		parts = new LinkedList<PartInfo>();
	}

	/**
	 * Creates a network with parts and vans based on the passed file.
	 * 
	 * @param filename file to pull data from
	 */
	public Network(String filename) {
			//TODO Sean lied about doing this one, it's big hard, ima do an easier one
		File theFile = new File("db.txt");
		
		
	}

	/**
	 * Add parts based on an inventory file
	 * 
	 * @param filename inventory file to pull data from
	 * @return true if the file is valid, false otherwise
	 */
	public boolean deliver(String filename) {
		return false;
	}

	/**
	 * Add an individual part to a warehouse.
	 * 
	 * @param part      part to be added
	 * @param warehouse warehouse to add part to
	 * @return true if the part is added, false otherwise (ex: invalid warehouse)
	 */
	public boolean add(BikePart part, String warehouse) {
		return false;
	}

	/**
	 * Return information about a part
	 * 
	 * @param partName part to return
	 * @return part info, empty string (ie: "") if part cannot be found
	 */
	public PartInfo display(String partName) {
		return null;
	}

	/**
	 * Sell a part from a specific warehouse.
	 * 
	 * @param partNum   part to sell
	 * @param warehouse warehouse to sell part from
	 * @return info about sale, empty string (ie: "") if sale cannot be made
	 */
	public String sell(int partNum, String warehouse) {
		PartInfo tempPart = getPartFromDatabase(partNum);
		Warehouse tempWarehouse = null;
		
		for (int i = 0; i < vans.size(); i++) {
			if (warehouse.equals(vans.get(i).getName())) {
				tempWarehouse = vans.get(i);
				break;
			} 
			if (i == vans.size() - 1) {
				return "";
			}
		}
		
		if (parts.contains(tempPart)) {
			String quantString = tempWarehouse.sell(partNum);
			if (quantString.equals("")){
				return "";
			}
			int newQuant = Integer.parseInt(quantString);
			return "";
		} else {
			return "";
		}
		
	}

	/**
	 * Return a sorted array of the contents of a warehouse, or of all warehouses
	 * 
	 * @param warehouse warehouse to sort, empty string (ie: "") indicates all
	 *                  warehouses
	 * @return a sorted array of parts by name
	 */
	public BikePart[] sortName(String warehouse) {
		return null;
	}

	/**
	 * Return a sorted array of the contents of a warehouse, or of all warehouses
	 * 
	 * @param warehouse warehouse to sort, empty string (ie: "") indicates all
	 *                  warehouses
	 * @return a sorted array of parts by number
	 */
	public BikePart[] sortNum(String warehouse) {
		return null;
	}

	/**
	 * Add a new van to the fleet. Must be a unique, non-empty name
	 * 
	 * @param vanName name of van. Must be unique and non-empty (ie: not "")
	 * @return true if the van is added, false if there is a name conflict
	 */
	public boolean addVan(String vanName) {
		if (vans.contains(new Warehouse(vanName))) {
			return false;
		} else {
			vans.add(new Warehouse(vanName));
			return true;
		}
	}

	/**
	 * Transfer parts between vans. Attempt to move as many as quantity allows.
	 * Ignore parts that do not exist in a van.
	 * 
	 * @param filename name of transfer file
	 */
	public void transfer(String filename) {

	}

	public boolean quit(String filename) {
		return false;
	}

	/*********************************
	 * HELPER METHODS HERE USE ME PLZ
	 ***************/

	/**
	 * Add new part to the inventory list, or update an existing part
	 * 
	 * @param part complete part info of part to be added/updated
	 * @throws IllegalArgumentException if the passed part has a matching part
	 *                                  number as a part in the list, but a
	 *                                  different name.
	 */
	private void addPartToDatabase(PartInfo part) throws IllegalArgumentException {
		boolean found = false;
		for (PartInfo val : parts) {
			if (val.getNum() == part.getNum()) {
				if (!val.getName().equals(part.getName())) {
					throw new IllegalArgumentException("Part data mismatch.");
				} else {
					val.setOnSale(part.isOnSale());
					val.setPrice(part.getPrice());
					val.setSalePrice(part.getSalePrice());
				}
				found = true;
				break;
			}
		}

		if (!found) {
			parts.add(part);
		}
	}

	/**
	 * Return information about a part by part number
	 * 
	 * @param partNum number of part to be found
	 * @return PartInfo on the part. val.equals(new PartInfo()) if partNum is not
	 *         found
	 */
	private PartInfo getPartFromDatabase(int partNum) {
		for (PartInfo val : parts) {
			if (val.getNum() == partNum) {
				return val;
			}
		}

		return new PartInfo();
	}

	/**
	 * Return information about a part by part name
	 * 
	 * @param partName name of part to be found
	 * @return PartInfo on the part. val.equals(new PartInfo()) iff partNum is not
	 *         found
	 */
	private PartInfo getPartFromDatabase(String partName) {
		for (PartInfo val : parts) {
			if (val.getName().equals(partName)) {
				return val;
			}
		}

		return new PartInfo();
	}
}
