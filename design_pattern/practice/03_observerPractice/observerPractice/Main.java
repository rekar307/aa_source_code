package observerPractice;

public class Main {
	public static void main(String[] args) {

		//subject object
		WhetherDataSubject wdSubject = new WhetherDataSubject();

		//observer objects
		UmbrellaStore umbrellaStore = new UmbrellaStore();
		ClothingStore clothingStore = new ClothingStore();
		IceCreamStore iceCreamStore = new IceCreamStore();

		// add observer
		wdSubject.addObserver(umbrellaStore);
		wdSubject.addObserver(clothingStore);
		wdSubject.addObserver(iceCreamStore);

		// whether changed : temperature = 10.0'c, rainfall = 10.0mm
		System.out.println();
		wdSubject.setMeasurements(10.0f, 10.0f);

		// whether changed : temperature = 16.0'c, rainfall = 1.0mm
		System.out.println();
		wdSubject.setMeasurements(16.0f, 1.0f);

		// whether changed : temperature = 30.0'c, rainfall = 0.0mm
		System.out.println();
		wdSubject.setMeasurements(30.0f, 0.0f);
	}
}

/*
===== Current state =====
 Temperature : 10.0'c
 Rainfall : 10.0mm
=========================
IceCream Not Sale !
Selling Winter cloths !
Umbrella Sale !

===== Current state =====
 Temperature : 16.0'c
 Rainfall : 1.0mm
=========================
IceCream Not Sale !
Selling Summer cloths !
Umbrella Not Sale !

===== Current state =====
 Temperature : 30.0'c
 Rainfall : 0.0mm
=========================
IceCream Sale !
Selling Summer cloths !
Umbrella Not Sale !
 */