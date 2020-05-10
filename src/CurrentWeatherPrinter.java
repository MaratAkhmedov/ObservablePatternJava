import java.util.Observable;
import java.util.Observer;

public class CurrentWeatherPrinter implements Display, Observer {
    private double temp;
    private double humidity;
    private double pression;
    private Observable observable;

    public CurrentWeatherPrinter(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    /**
     * display the data in the console
     */
    @Override
    public void display() {
        System.out.println(
                "Current weather: \nTemperature:" + temp +
                "\nHumidity" + humidity + " %" +
                "\nPressure: " + pression
        );
    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData) {
            WeatherData weather = (WeatherData)o;
            this.temp = weather.getTemperature();
            this.humidity = weather.getHumidity();
            this.pression = weather.getPression();
            display();
        }
    }
}
