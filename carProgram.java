//class that actually runs
import java.util.*;
import javax.swing.*;
public class carProgram extends carFinder{
    //public ArrayList<Car> currentCars;
    public carProgram(String filename) {
        super(filename);
        //this.currentCars = new ArrayList<Car>();
    }
    
    //recursively calls searchByAnything method
    public void recursiveRun (ArrayList<Car> cars) {
        //javac -Xlint:unchecked carProgram.java
        //@SuppressWarnings("unchecked")
        ArrayList<Car> currentCars = new ArrayList<Car>(cars);
        System.out.println("Run? Y/N");
        Scanner input = new Scanner(System.in);
        if (input.next().equals("Y")) {
            System.out.println("search by what: (price,year,manufacturer,model,condition,cylinders,fuel,odometer,title_status,transmission,drive,type)");
            String next = input.next();
            findAttribute(next);
            searchByAnything(next, currentCars);
            recursiveRun(currentCars);
        }
        else {
            //System.out.println("Thanks for using!");
            //printList(currentCars);
            String[][] temp1 = to2dArray(currentCars);
            String[] temp2 = firstColumn(currentCars);
            //firstColumn(currentCars);
            //to2dArray(currentCars);
            tableMaker table = new tableMaker(temp1, temp2);
            table.display();
            return;
        }
        
    }
    
    //for JTable first parameter
    public String[] firstColumn (ArrayList <Car> cars) {
        String [] columns = new String[11];
        for (int i = 0; i< columns.length; i++) {
            columns[i] = cars.get(0).attributes[i];
        }
        /*for (int j = 0; j<columns.length; j++) {
            System.out.println(columns[j]);
        }*/
        return columns;
    }
    //for JTable second parameter
    public String[][] to2dArray (ArrayList<Car> cars) {
        String[][] carsIn2D = new String[cars.size()][11];
        for (int i = 0; i<carsIn2D.length; i++) {
            for (int j = 0; j< carsIn2D[i].length; j++) {
                carsIn2D[i][j] = cars.get(i).attributes[j];
            }
        }
        /*for (int i = 0; i<carsIn2D.length; i++) {
            for (int j = 0; j< carsIn2D[i].length; j++) {
                System.out.print(carsIn2D[i][j] + " ");
            }
            System.out.println();
        }*/
        return carsIn2D;
    }
}