package observerPractice;
import java.util.Observable;

public class WhetherDataSubject extends Observable {
	private float temperature = 25.0f;
	private float rainfall = 0.0f;

	// default constructor
	public WhetherDataSubject() {
	}
	
	public void setMeasurements(float temperature, float rainfall) {
		this.temperature = temperature;
		this.rainfall = rainfall;
		setChanged();
		currentState();
		notifyObservers();
	}

	@Override
	public void notifyObservers(){
		super.notifyObservers(this); // 옵저버들에게 이 객체(현재 상태)를 전달
	}
	
	public void currentState() {
		System.out.printf("===== Current state ===== \n Temperature : %.1f'c \n Rainfall : %.1fmm \n=========================\n",
				temperature, rainfall);
	}

	public float getTemperature() {
		return temperature;
	}

	public float getRainfall() {
		return rainfall;
	}
}
