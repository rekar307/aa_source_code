package observerPractice;

import java.util.Observable;
import java.util.Observer;

public class ClothingStore implements Observer {
	private static final int SUMMER_CLOTHS = 1;
	private static final int WINTER_CLOTHS = 2;
	
	private int state;
	
	public ClothingStore() {
		state = SUMMER_CLOTHS;
	}
	
	public void whetherChanged(float temperature) {
		if(temperature >= 15.0f) // when temperature exceeds 15.0'c
			state = SUMMER_CLOTHS; // selling summer cloths
		else // when temperature < 15.0
			state = WINTER_CLOTHS;
		
		kindOfSellingCloths();
	}

	private void kindOfSellingCloths() {
		System.out.println("Selling " + ((state == SUMMER_CLOTHS) ? "Summer" : "Winter") + " cloths !");
	}

	@Override
	public void update(Observable o, Object arg) {
		WhetherDataSubject whetherData = (WhetherDataSubject)o;
		whetherChanged(whetherData.getTemperature());
	}
}
