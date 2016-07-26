/*
 * Computes the angular size of an astronomical object from a certain distance.
 */
package angular.diameter.calculation;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed
 */
public class AngularDiameterCalculation {

    /**
     * @param args the command line arguments
     */
    
    public static final double KILOMETERS_PER_AU = 1.495e8;
    
    public static double getAngularSize(double trueDiameter, double distance) {
        return Math.toDegrees(2 * Math.atan((trueDiameter / 2.0) / (distance * KILOMETERS_PER_AU))); 
    }
        
    public static void main(String[] args) {
        double trueDiameter;
        double viewingDistance; 
        double angularSize; 
        
       DecimalFormat decimalFormat = new DecimalFormat("0.00");
       
       // 1. Get the true diameter of the object. 
       trueDiameter = Double.parseDouble(JOptionPane.showInputDialog("True diameter (in km): "));
       // 2. Get the viewing distance.
       viewingDistance = Double.parseDouble((JOptionPane.showInputDialog("From how far (in AU)?")));
       // 3. Compute the angular size of the object. 
       angularSize = getAngularSize(trueDiameter, viewingDistance);
       // 4. Display the value of the angular size. 
       JOptionPane.showMessageDialog(null, "From " + viewingDistance + " AU away, " 
               + "the angular diameter of an object whose true diameter is " 
               + trueDiameter + " km is equal to about " + decimalFormat.format(angularSize)
               + " degrees.");
    } 
}
