package headfirst.iterator.dinermerger;

import java.util.*;

public class Main {
	public static void main(String args[]) {

		// Practice 5-1
		printMenu_1();			// not using Iterator
		System.out.println("=========================");
		printMenu_2();			// using Iterator

		// Practice 5-2
//		printMenu_3();
	}

	// Practice 5-1
	public static void printMenu_1() {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();

		ArrayList<MenuItem> breakfastItems = pancakeHouseMenu.getMenuItems();

		for (int i = 0; i < breakfastItems.size(); i++) {
			MenuItem menuItem = breakfastItems.get(i);
			System.out.print(menuItem.getName());
			System.out.println("\t\t" + menuItem.getPrice());
			System.out.println("\t" + menuItem.getDescription());
		}

		MenuItem[] lunchItems = dinerMenu.getMenuItems();

		for (int i = 0; i < lunchItems.length; i++) {
			MenuItem menuItem = lunchItems[i];
			System.out.print(menuItem.getName());
			System.out.println("\t\t" + menuItem.getPrice());
			System.out.println("\t" + menuItem.getDescription());
		}
	}

	// Practice 5-1
	public static void printMenu_2() {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();

		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
		waitress.printMenu();
	}

	// Practice 5-2
//	public static void printMenu_3() {
//		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
//		DinerMenu dinerMenu = new DinerMenu();
//		CafeMenu cafeMenu = new CafeMenu();
//
//		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, cafeMenu);
//
//		waitress.printMenu();
//		waitress.printVegetarianMenu();
//
//		System.out.println("\nCustomer asks, is the Hotdog vegetarian?");
//		System.out.print("Waitress says: ");
//		if (waitress.isItemVegetarian("Hotdog")) {
//			System.out.println("Yes");
//		} else {
//			System.out.println("No");
//		}
//		System.out.println("\nCustomer asks, are the Waffles vegetarian?");
//		System.out.print("Waitress says: ");
//		if (waitress.isItemVegetarian("Waffles")) {
//			System.out.println("Yes");
//		} else {
//			System.out.println("No");
//		}
//	}
}