import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.Serializable;

public class Termostat implements VetoableChangeListener, Serializable {
    int maxlim = 25;
    int minlim = 15;
    public void vetoableChange(PropertyChangeEvent ev) throws PropertyVetoException {
      if (!ev.getPropertyName().equals("Temperatura")) return;
        int newtemp= (Integer) ev.getNewValue();
        if(newtemp<minlim)
        { System.out.println("Rybki zamarzły i zdechły");
            throw new PropertyVetoException ("Rybki zamarzły i zdechły",ev);

        }
            if(newtemp>maxlim)
            {  System.out.println("Rybki się ugotowały. Masz teraz zupę rybną");
                throw new PropertyVetoException ("Rybki się ugotowały. Masz teraz zupę rybną",ev);
            }
    }
}
