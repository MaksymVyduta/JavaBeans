import java.beans.*;
import java.io.Serializable;

class AkwariumBean implements Serializable {
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    public synchronized void addPropertyChangeListener(PropertyChangeListener lst) {
        pcs.addPropertyChangeListener(lst);
    }

    public synchronized void removePropertyChangeListener(PropertyChangeListener lst) {
        pcs.removePropertyChangeListener(lst);
    }

    private VetoableChangeSupport vcs = new VetoableChangeSupport(this);
    public synchronized void addVetoableChangeListener(VetoableChangeListener lst) {
        vcs.addVetoableChangeListener(lst);
    }

    public synchronized void removeVetoableChangeListener(VetoableChangeListener lst) {
        vcs.removeVetoableChangeListener(lst);
    }

    public AkwariumBean() {
    }

    protected int temperatura;
    protected String text;


    public synchronized int getTemperatura() {
        return temperatura;
    }
    public synchronized String getText() {
        return text;
    }
    public synchronized void setText(String nowyText) throws PropertyVetoException{
        String staryText =text ;
        text=nowyText;
        pcs.firePropertyChange(new PropertyChangeEvent(this, "Sytuacja w Akwarium: ", staryText, nowyText));
    }
    public synchronized void setTemperatura(int nowaTemperatura) throws PropertyVetoException{
        int staraTemp =temperatura ;
        vcs.fireVetoableChange("Temperatura",staraTemp,nowaTemperatura);
        temperatura=nowaTemperatura;
        pcs.firePropertyChange(new PropertyChangeEvent(this, "Temperatura w Akwarium", staraTemp, nowaTemperatura));
    }

}
