import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

public class Rybki implements PropertyChangeListener, Serializable {

    public void propertyChange(PropertyChangeEvent ev) {
        System.out.println( ev.getPropertyName() + ": " + ev.getNewValue());
    }
}
