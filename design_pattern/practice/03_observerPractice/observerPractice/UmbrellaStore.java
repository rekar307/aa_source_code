package observerPractice;
import java.util.Observable;
import java.util.Observer;

public class UmbrellaStore implements Observer {
	
	private boolean sellingState;
	// default constructor
	public UmbrellaStore() {
		this.sellingState = false;
	}
	
	public void whetherChanged(float rainfall) {
		if (rainfall >= 5.0f) // when rainfall exceeds 5.0mm
			sellingState = true; // selling umbrella
		else // when rainfall < 5.0
			sellingState = false;
		
		isSelling();
	}

	private void isSelling() {
		System.out.println("Umbrella "+ ((sellingState) ? "":"Not ") + "Sale !");
	}

	@Override
	public void update(Observable o, Object arg) {
		WhetherDataSubject whetherData = (WhetherDataSubject)o;
		whetherChanged(whetherData.getRainfall());
	}
}
