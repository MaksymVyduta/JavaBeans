import java.beans.PropertyVetoException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws PropertyVetoException {
        Scanner we=new Scanner(System.in);
        System.out.println("Ustaw temperaturę w Akwarium");
        AkwariumBean Aquarium = new AkwariumBean();

        Rybki Ryb = new Rybki();
        Termostat Term=new Termostat();

        Aquarium.addPropertyChangeListener(Ryb);
        Aquarium.addVetoableChangeListener(Term);

      try{  Aquarium.setTemperatura(we.nextInt());}
      catch (Exception PropertyVetoException )
      {}

        if (Aquarium.getTemperatura()==0)
        {
            Aquarium.setText("Nie spotkasz tutaj żadnej żywej duszy...");
        }
       else if (Aquarium.getTemperatura()<20)
        {
            Aquarium.setText("Rybkom trochę zimno");
        }
       else if (Aquarium.getTemperatura()>20)
        {
            Aquarium.setText("Rybkom trochę za gorąco");
        }
       else if (Aquarium.getTemperatura()==20)
        {
            Aquarium.setText("Rybki czują się idealnie");
        }


    }
}
