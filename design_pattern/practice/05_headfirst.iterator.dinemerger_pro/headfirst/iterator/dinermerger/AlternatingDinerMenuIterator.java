package headfirst.iterator.dinermerger;

import java.util.Calendar;

public class AlternatingDinerMenuIterator implements Iterator {
	MenuItem[] items;
	int position;

	public AlternatingDinerMenuIterator(MenuItem[] items) {
		this.items = items;
		Calendar rightNow = Calendar.getInstance();
		position = rightNow.DAY_OF_WEEK % 2;
	}

	public Object next() {
		MenuItem menuItem = items[position];
		position = position + 2;
		return menuItem;
	}

	public boolean hasNext() {
		if (position >= items.length || items[position] == null) {
			return false;
		} else {
			return true;
		}
	}

	public String toString() {
		return "Alternating Diner Menu Iterator";
	}
}