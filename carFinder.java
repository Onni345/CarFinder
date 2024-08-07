import java.util.*;
import java.io.*;
public class carFinder extends arrayHandler{
    //inherits arrayHandler
    public carFinder(String filename) {
        super(filename);
    }
    
    //finds column of an attribute using complex selection
    public int columnFinder(String key) {
        int index = 0;
        switch (key) {
            case "price":
                index = 0;
                break;
            case "year":
                index = 1;
                break;
            case "odometer":
                index = 7;
                break;
            case "manufacturer":
                index = 2;
                break;
            case "model":
                index = 3;
                break;
            case "condition":
                index = 4;
                break;
            case "cylinders":
                index = 5;
                break;
            case "fuel":
                index = 6;
                break;
            case "title_status":
                index = 8;
                break;
            case "transmission":
                index = 9;
                break;
            case "drive":
                index = 10;
                break;
            case "type":
                index = 11;
                break;
            default:
                index = -1;
                break;
        }
        return index;
    }
    
    //used to print all unique values of an attribute giving client something to search by
    public void findAttribute(String attribute) {
        int column = columnFinder(attribute);
        /*if (column == -1) {
            System.out.println("Attribute " + attribute + " doesn't exist");
            return;
        }*/
        if (column == 0 || column == 1 || column == 7) {
            return;
        }
        int count = 0;
        ArrayList<String> specials = new ArrayList<String>();
        HashMap<String, Integer> uniques = new HashMap<String, Integer>();
        try (Scanner input = new Scanner(new File(filename))) {
            ArrayList<String> allConditions = new ArrayList<String>();
            while (input.hasNextLine()) {
                String[] temp = input.nextLine().split(",", -1);
                allConditions.add(temp[column]);
            }
            for (String i : allConditions) {
                if (uniques.containsKey(i)) {
                    uniques.put(i, uniques.get(i)+1);
                }
                else {
                    uniques.put(i,1);
                }
            }
            for (Map.Entry<String,Integer> entry: uniques.entrySet()) {
                if (entry.getValue()>1) {
                    specials.add(entry.getKey());
                }
            }
            for (String h : specials) {
                //count++;
                System.out.println(h);
            }
        }
        catch (Exception e) {
            System.out.println("didn't work - " + e);
        }
    }
    
    //actual searching method - returns a narrowed / cut down arraylist of inputted arraylist
    public void searchByAnything(String key, ArrayList<Car> currentCars) {
        int index = 0;
        if (columnFinder(key) == -1) {
            System.out.println("attribute " + key + " doesn't exist");
            return;
        }
        if (columnFinder(key) == 0 || columnFinder(key) == 1 || columnFinder(key) == 7) {
            index = columnFinder(key);
        }
        boolean found = true;
        ArrayList<Car> currents = new ArrayList<Car>();
        Scanner input = new Scanner(System.in);
        if (key.equals("price") || key.equals("odometer") || key.equals("year")) {
            System.out.println("Input a " + key + ", and you will get out different cars of that " + key);
            System.out.println("Enter a range of " + key + " values. Lower number first:");
            try {
                int lower = input.nextInt();
                System.out.println("Higher number: ");
                int higher = input.nextInt();
                Iterator<Car> it = currentCars.iterator();
                while (it.hasNext()) {
                    Car current = it.next();
                    int ranger = 0;
                    if (current.attributes[index].equals(key)) {
                        continue;
                    }
                    try {
                        ranger = Integer.parseInt(current.attributes[index]);
                        if (ranger<lower || ranger>higher) {
                            it.remove();
                        }
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
            catch (Exception e) {
                System.out.println("that isn't a valid price value. input an integer");
            }
            //printList(currentCars);
        }
        else {
            index = columnFinder(key);
            System.out.println("Input a " + key + ", and you will get out different cars of that " + key);
            String search = input.next();
            Iterator<Car> it = currentCars.iterator();
            while (it.hasNext()) {
                Car current = it.next();
                if (current.attributes[index].equals(key)) {
                    continue;
                }
                else {
                    if (!current.attributes[index].contains(search)) {
                        it.remove();
                    }
                }
            }
            //printList(currentCars);
        }
        //if list is less than size 2, it means the method narrowed every othe car, which means none were found
        if (currentCars.size() < 2) {
            System.out.println("no cars found");
        }
    }
}