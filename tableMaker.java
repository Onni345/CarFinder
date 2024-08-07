import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class tableMaker extends JFrame{
    private String[][] cars;
    private String[] columns;
    public tableMaker (String[][] cars, String[] columns) {
        this.cars = cars;
        this.columns = columns;
    }
    
    public void display() {
        DefaultTableModel model = new DefaultTableModel(cars, columns);
        JTable table = new JTable(model);
        JFrame frame = new JFrame("final output");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setSize(1000, 400);
        frame.setVisible(true);
    }
}