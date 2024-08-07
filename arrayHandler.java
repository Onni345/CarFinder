import java.util.*;
import java.io.*;
public class arrayHandler {
    protected String filename;
    protected ArrayList<Car> cars;
    public arrayHandler(String filename) {
        this.filename = filename;
        this.cars = new ArrayList<Car>();
    }
    //simple arraylist getter
    public ArrayList<Car> getCars() {
        return cars;
    }
    
    //printing any car arraylist
    public void printList () {
        for (int i = 1; i<cars.size(); i++) {
            Car temp = cars.get(i);
            System.out.println(temp.print(temp));
        }
    }
    
    //the same print method but if ever not on an object
    public void printList (ArrayList<Car> cars) {
        /*if (cars.size() <2) {
            System.out.println("no cars found");
        }*/
        for (int i = 1; i<cars.size(); i++) {
            Car temp = cars.get(i);
            System.out.println(temp.print(temp));
        }
    }
    
    //extracting and loading data
    public void loadData () {
        try (Scanner input = new Scanner(new File(filename))) {
            int linenum = 0;
            String thisLine = "";
            while(input.hasNextLine()) {
                thisLine = input.nextLine();
                if (thisLine.indexOf('"')>=0) {
                    thisLine = input.nextLine();
                }
                String[] temp = thisLine.split(",", -1);
                Car tempCar = new Car();
                for (int i = 0; i<temp.length; i++) {
                    tempCar.attributes[i] = temp[i];
                }
                cars.add(tempCar);
                //System.out.println(listLength);
                /*Car tempCar = new Car();
                tempCar.price=temp[0];
                tempCar.year=temp[1];
                tempCar.manufacturer=temp[2];
                tempCar.model=temp[3];
                tempCar.condition=temp[4];
                tempCar.cylinders=temp[5];
                tempCar.fuel=temp[6];
                tempCar.odometer=temp[7];
                tempCar.title=temp[8];
                tempCar.transmission=temp[9];
                tempCar.drive=temp[10];
                tempCar.type=temp[11];
                tempCar.attributes[]
                cars.add(tempCar);*/
            }
        }
        catch (Exception e) {
            System.out.println("didn't work - " + e);
        }
    }
    
    //cleaning data
    public void cleanData () {
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car temp = iterator.next(); 
            if (!temp.nullZeroCheck()) {
                iterator.remove();
            }
            /*if (temp.attributes[3].equals("civic")) {
                System.out.println(true);
            }*/
        }
    }
    
    
}