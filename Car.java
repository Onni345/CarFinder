public class Car {
    public String[] attributes;
    

    //car object
    public Car () {
        /*price = "";
        year = "";
        manufacturer = "";
        model = "";
        condition = "";
        cylinders = "";
        fuel = "";
        odometer = "";
        title = "";
        transmission = "";
        drive = "";
        type = "";*/
        attributes = new String[12];
    }
    
    //printing car - only used for testing not in final
    public String print (Car car) {
        System.out.println();
        String output = "";
        for (int i = 0; i<attributes.length; i++) {
            output += attributes[i] + " ";
        }
        return output;
    }
    
    //method that goes hand in hand with clean data - detects null values
    public boolean nullZeroCheck () {
        for (int i = 0; i<attributes.length; i++) {
            String val = attributes[i];
            if (val.equals("") || val.equals("0")) {
                return false;
            }
        }
        return true;
    }

}