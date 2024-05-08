import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class ChartFrame extends JFrame
{ 
       private static final int FRAME_WIDTH = 400;
       private static final int FRAME_HEIGHT = 400;
       private static final int CHART_WIDTH = 300;
       private static final int CHART_HEIGHT = 300;
       private static final String DEFAULT_LABEL = "Description";
       private static final double DEFAULT_VALUE = 100;
       private JTextField labelField;
       private JTextField valueField;
       private JButton addButton;
       private JButton removeButton;
       private ChartComponent chart;
       public ChartFrame()   
       {  
           chart = new ChartComponent();
           chart.setPreferredSize(new Dimension(CHART_WIDTH, CHART_HEIGHT));
           chart.append(DEFAULT_LABEL, DEFAULT_VALUE);
           createTextFields(); 
           createButtons();
           createPanel();   
           setSize(FRAME_WIDTH, FRAME_HEIGHT);  
        }
       private void createTextFields()  
       {
            final int LABEL_FIELD_WIDTH = 20;
            labelField = new JTextField(LABEL_FIELD_WIDTH);
            labelField.setText(DEFAULT_LABEL);
            final int VALUE_FIELD_WIDTH = 10;
            valueField = new JTextField(VALUE_FIELD_WIDTH);
            valueField.setText("" + DEFAULT_VALUE); 
        }
       class AddBarListener implements ActionListener 
       {
          public void actionPerformed(ActionEvent event)
          {       String label = labelField.getText();
              double value = Double.parseDouble(valueField.getText());
              chart.append(label, value);     
          }              
       }
       class RemoveBarListener implements ActionListener  
       {      public void actionPerformed(ActionEvent event)
         {   
             chart.removeLast();
         }            
       }
        public void createButtons()
       {
       addButton = new JButton("Add"); 
       addButton.addActionListener(new AddBarListener());
       removeButton = new JButton("Remove last");
       removeButton.addActionListener(new RemoveBarListener());
       }  
        public void createPanel()
       {   JPanel panel = new JPanel();
        panel.add(labelField);
        panel.add(valueField);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(chart);      
        add(panel);
       }
}