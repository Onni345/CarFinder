import java.util.*;
import java.io.*;
import javax.swing.*;
public class Main
{
    public static void main(String[] args)
    {
        /*JFrame f = new JFrame();
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);*/
        //public static ArrayList<Car> posAdjectives = new ArrayList<Car>();
        carProgram program = new carProgram("data.csv");
        program.loadData();
        //program.printList();
        program.cleanData();
        //arrayHandler temp = new arrayHandler("first3000.csv");
        program.recursiveRun(program.getCars());
    }
}