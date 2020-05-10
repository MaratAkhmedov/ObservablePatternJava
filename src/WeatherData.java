import java.util.ArrayList;
import java.util.Observable;

public class WeatherData extends Observable {
    private double temperature;
    private double humidity;
    private double pression;
    //private ArrayList<Observer> observers;

    public WeatherData() {
        //observers = new ArrayList<Observer>();
        temperature = 0.0;
        humidity = 0.0;
        pression = 0.0;
    }


    /**
     * set data of the weather
     * @param temp
     * @param humidity
     * @param pres
     */
   public void setMeasurements(double temp, double humidity, double pres) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pression = pres;

        setChanged();   //changed = true; -->  marks the observale object as having been changed
        notifyObservers();
   }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Subject.WeatherData{");
        sb.append("temperature=").append(temperature);
        sb.append(", humidity=").append(humidity).append("%");
        sb.append(", pression=").append(pression);
        sb.append('}');
        return sb.toString();
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPression() {
        return pression;
    }
}
