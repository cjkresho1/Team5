import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Warehouse {
	private LinkedList<BikePart> parts;

	public Warehouse() {
		parts = new LinkedList<BikePart>();
	}

	public Warehouse(String dbFile) {
		parts = new LinkedList<BikePart>();
		File file = new File(dbFile);

		if (file.exists()) {
			try {
				Scanner scan = new Scanner(file);
				while (scan.hasNextLine()) {
					String temp = scan.nextLine();
					String[] data = temp.split(",");

					parts.add(new BikePart(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2]),
							Double.parseDouble(data[3]), Boolean.getBoolean(data[4]), Integer.parseInt(data[5])));
				}
				scan.close();
			} catch (FileNotFoundException e) {
				System.out.print("HOW DID YOU DO THIS");
				System.exit(1);
				// THIS SHOULD NEVER EVER HAPPEN BUT IF IT DOES...HOW?
			}

		}
	}

	public boolean read(String file) {
		/*
		 * TODO use file to update parts database. Create new entries, and update
		 * existing ones. Quantity are additive.
		 */

		return false;
	}

	public boolean enter(String info) {
		/*
		 * TODO add a return value corresponding to success or failure
		 */
		String[] partInfo = info.split(",");

		BikePart newPart = new BikePart(partInfo[0], Integer.parseInt(partInfo[1]), Double.parseDouble(partInfo[2]),
				Double.parseDouble(partInfo[3]), Boolean.parseBoolean(partInfo[4]), Integer.parseInt(partInfo[5]));
		
		boolean exists = false;
		
		for (int i = 0; i<parts.size(); i++) {
			if (newPart.getNum()==parts.get(i).getNum()) {
				parts.set(i, newPart);
				exists = true;
			}
		}
		if (exists==false) {
			parts.add(newPart);
		}

		return false;
	}

	public String sell(int partNum) {
		String partInfo = null;
		for (int i = 0; i < parts.size(); i++) {
			if (partNum == parts.get(i).getNum()) {
				partInfo = parts.get(i).getName() + " " + parts.get(i).getPrice() + " " + parts.get(i).isOnSale() + " ";
				parts.get(i).setQuantity(parts.get(i).getQuantity() - 1);
			}
		}
		if (partInfo == null) {
			partInfo = "";
		}
		/*
		 * TODO format partInfo and add time of sale to end
		 */

		return partInfo;
	}

	public String display(String partName)
	/*
	 * TODO make sure partInfo is formatted acceptably
	 */
	{
		String partInfo = null;
		for (int i = 0; i < parts.size(); i++) {
			if (parts.get(i).getName() == partName) {
				partInfo = partName + " " + parts.get(i).getPrice();
			}
		}
		if (partInfo == null) {
			partInfo = "";
		}
		return partInfo;
	}

	public String[] sortName() {
		String[] val = new String[parts.size()];

		/*
		 * This sorts the warehouse inventory based on Name. This is accomplished by
		 * using the built in .sort(Comparator<T>) method. The Comparator<BikePart>
		 * passed to the method is a custom, overridden Comparator that is designed to
		 * compare the Names.
		 */
		parts.sort(new Comparator<BikePart>() {
			@Override
			public int compare(BikePart b1, BikePart b2) {
				return b1.getName().compareTo(b2.getName());
			}
		});

		for (int i = 0; i > parts.size(); i++) {
			val[i] = parts.get(i).toString();
		}

		return val;
	}

	public String[] sortNumber() {
		String[] val = new String[parts.size()];

		/*
		 * This sorts the warehouse inventory based on PartNumber. This is accomplished
		 * by using the built in .sort(Comparator<T>) method. The Comparator<BikePart>
		 * passed to the method is a custom, overridden Comparator that is designed to
		 * compare the Names.
		 */
		parts.sort(new Comparator<BikePart>() {
			@Override
			public int compare(BikePart b1, BikePart b2) {
				return b1.getNum() - b2.getNum();
			}
		});

		for (int i = 0; i > parts.size(); i++) {
			val[i] = parts.get(i).toString();
		}

		return val;
	}

	public void quit(String file) {

		/*
		 * TODO update file to reflect current warehouse database. If file exists,
		 * delete content and overwrite.
		 */
	}

	private boolean parseFile(String file) {
		/*
		 * TODO use file to update parts database. Create new entries, and update
		 * existing ones.
		 */

		return false;
	}
}
