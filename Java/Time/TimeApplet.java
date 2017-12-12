/* Author: Sau Ma
 * Student ID - 001205963
 * CSI205 
 * Assignment 8 - TimeApplet.java 
 * Description: This class uses our Time.java (HW7) GUI interface we created and converts it into a Java Applet
 * -extend JApplet
 * -change constructor to public void init()
 * -remove super()
 * -remove setVisible() and setSize()
 */

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
  
public class TimeApplet extends JApplet
{
  /* Here we create the Buttons/Labels/Drop Down Lists. Adding them to JFrame will be done in Constructor */
  /*-----Variable Declarations-----*/
  TimeAndDate t;            //Declare TimeAndDate object
  JFrame frame;
  JPanel panel;
  /*-----These JPanels are for separate JPanels that are inserted into the JFRAME-----*/
  JPanel comboBox;
  JPanel textField;
  JPanel buttons;
  JPanel b;
  Container contentPane;
  private int hours;        
  private int minutes;
  private int seconds;
  //String Array that holds all months to be inserted into Month Combo Box
  private static final String[] months = {"January", "February","March","April","May","June", "July","August","September",
                                           "October", "November", "December"};
  private String month;
  private int month_Num;
  private int days;
  private int years;
  
  
  /*-----Labels-----*/
  private JLabel label_Hours;         //Declare JLabel for Hour
  private JLabel label_Minute;        //Declare JLabel for Minute
  private JLabel label_Seconds;       //Declare JLabel for Second
  private JLabel label_Months;        //Declare JLabel for Month
  private JLabel label_Days;          //Declare JLabel for Day
  private JLabel label_Years;         //Declare JLabel for Year
    
  /*-----Drop Down Lists-----*/
  private JComboBox<String> list_Months;    //Declare drop down list for Months
  private JComboBox<Integer> list_Days;     //Declare drop down list for Days
  private JComboBox<Integer> list_Years;    //Declare drop down list for Years
  private JComboBox<Integer> list_Hours;    //Declare drop down list for Hours
  private JComboBox<Integer> list_Minutes;  //Declare drop down list for Minutes
  private JComboBox<Integer> list_Seconds;  //Declare drop down list for Seconds
  
  /*-----JButtons-----*/
  private JButton set;          //Declare JButton "Set"
  private JButton day_inc;      //Declare JButton "Increase Day"
  private JButton day_dec;      //Declare JButton "Decrease Day"
  private JButton sec_inc;      //Declare JButton "Increase Second"
  private JButton sec_dec;      //Declare JButton "Decrease Second"
  
  /*-----Non Editable Text Field-----*/
  private JTextField output_Field;    //Declare text field that will be uneditable
  private JTextField hidden_Field;    //Hidden Textfield
  
  
  //Constructor
  public void init()
  {
    //create a TimeAndDate Object
    t = new TimeAndDate();
    frame = new JFrame("Time");
    contentPane = frame.getContentPane();
    panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    frame.setLayout(new GridLayout(8,2,0,0));
   
    /*-----Creating JLabels-----*/
  label_Hours = new JLabel("Hour");              //Create JLabel for Hour
  label_Minute = new JLabel("Minute");          //Create JLabel for Minute
  label_Seconds = new JLabel("Second");        //Create JLabel for Second
  label_Months = new JLabel("Month");         //Create JLabel for Month
  label_Days = new JLabel("Day");            //Create JLabel for Day
  label_Years = new JLabel("Year");         //Create JLabel for Year
  
  /*-----Creating Combo Boxes (Drop Down Lists)-----*/
  list_Months = new JComboBox<String>(months);    //Create drop down list for Months
  list_Days = new JComboBox<Integer>();          //Create drop down list for Days
  list_Years = new JComboBox<Integer>();        //Create drop down list for Years
  list_Hours = new JComboBox<Integer>();       //Create drop down list for Hours
  list_Minutes = new JComboBox<Integer>();    //Create drop down list for Minutes
  list_Seconds = new JComboBox<Integer>();   //Create drop down list for Seconds
  
  /*-----Creating JButtons-----*/
  set = new JButton("Set");               //Create JButton "Set"
  day_inc = new JButton("Incr Day");      //Create JButton "Increase Day"
  day_dec = new JButton("Decr Day");      //Create JButton "Decrease Day"
  sec_inc = new JButton("Incr Second");   //Create JButton "Increase Second"
  sec_dec = new JButton("Decr Second");   //Create JButton "Decrease Second"
  
  /*-----Create Uneditable Textfield-----*/
  output_Field = new JTextField("",15);
  hidden_Field = new JTextField("",5);
    
    /*------------------------------------Adding to JFrame-------------------------------*/
    /*-----Adding Months Label and Dropdown------*/
    comboBox = new JPanel();
    comboBox.setLayout(new FlowLayout());
    frame.add(label_Months); //add Month label to Jframe
    frame.add(list_Months);  //list already populated since an array of strings was created. Add to Jframe
    
    /* Adding Days Label and Dropdown */
    frame.add(label_Days);   //Add Days Label to Jframe
    //Populate the Days DropDown List
    for(int i = 1; i <= 31; i++)
    {
      list_Days.addItem(i);
    }
    frame.add(list_Days);    //Add Days list to JFrame  
    
     /*-----Adding Years Label and Dropdown-----*/
    frame.add(label_Years);
    //Populate Years DropDown List
    for(int i = 1900; i <= 2100; i++)
    {
      list_Years.addItem(i);
    }
    frame.add(list_Years);
    /*-----Adding Hours Label and Dropdown-----*/
    frame.add(label_Hours);   //Add Hours Label to JFrame
    //Populate Hours DropDown list
    for(int i = 0; i <= 23; i++)
    {
      list_Hours.addItem(i);
    }
    frame.add(list_Hours);    //Add Dropdown for Hours to JFrame
    
    /*-----Adding Minutes Label and Dropdown-----*/
    JPanel f = new JPanel();
    frame.add(label_Minute);   //Add Minute Label to JFrame
    //Populate Minutes DropDown list
    for(int i = 0; i <= 59; i++)
    {
      list_Minutes.addItem(i);
    }
    frame.add(list_Minutes);   //Add Dropdown for Hours to JFrame
    
    /*-----Adding Seconds Label and Dropdown-----*/
    frame.add(label_Seconds);
    //Populate Seconds DropDown list
    for(int i = 0; i <= 59; i++)
    {
      list_Seconds.addItem(i);
    }
    frame.add(list_Seconds);  //Add DropDown for Seconds to JFrame
   
    /*--------Adding Textfields to a separate JPanel and then adding it into the JFrame------------------*/
    textField = new JPanel();                                  //create new JPanel for uneditable field
    textField.setLayout(new FlowLayout());                     //Set FlowLayout
    textField.add(output_Field);                               //Add textfield to panel
    output_Field.setHorizontalAlignment(JTextField.CENTER);    //Set text textfield to be centered
    output_Field.setEditable(false);                           //Set editable field to False so it's uneditable
    frame.getContentPane().add(textField);                     //Add uneditable textfield to JFrame
    textField = new JPanel();                                  //create new jpanel for hidden field
    textField.add(hidden_Field);                               //Add hidden text to panel (for formatting)
    hidden_Field.setVisible(false);                            //Hide this field (for gridlayout and so buttons go to new line
    frame.getContentPane().add(textField);                     //Add hidden textfield to Jframe
    
     /*-----Adding Buttons-----*/    
    buttons = new JPanel();               //Create new JPanel for the buttons
    buttons.setLayout(new FlowLayout());  //Set FlowLayout
    buttons.add(set);                     //Add Set Button to Jframe
    buttons.add(day_inc);                 //Add Incr Day button to Jframe
    buttons.add(day_dec);                 //Add Decr Day Button to Jframe
    //Add JPanel onto the JFRAME
    frame.getContentPane().add(buttons,BorderLayout.PAGE_END);
    
    b = new JPanel();        //Create new jpanel
    b.add(sec_inc);         //Add Incr Sec button to Jframe
    b.add(sec_dec);         //Add Decr Sec button to Jframe
    //Add JPanel onto the JFRAME
    frame.getContentPane().add(b,BorderLayout.PAGE_END);
    //Set Frame to Visible
    frame.pack();
    
    /*-----------------------------ButtonHandler & Action Listener---------------------------*/
    ButtonHandler handler = new ButtonHandler();
    set.addActionListener(handler);
    day_inc.addActionListener(handler);
    day_dec.addActionListener(handler);
    sec_inc.addActionListener(handler);
    sec_dec.addActionListener(handler);
  }//end of constructor
  
  /*-----------------------------Private Inner Class with ActionListener---------------------*/
  private class ButtonHandler implements ActionListener
  {
    String choice = "";
    //Process Button Press Events
    //@Override
    public void actionPerformed(ActionEvent event)
    {
      //Pressing Set button, set time based on dropdown list selection by calling setTimeAndDate()
      if(event.getSource() == set)
      {

        month = list_Months.getSelectedItem().toString();
        //Switch to determine the month #, since setDateAndTime takes in (int,int,int,int,int,int)
        switch(month)
        {
          case "January":
            month_Num = 1;
            break;          
          case "February":
            month_Num = 2;
            break;    
          case "March":
            month_Num = 3;         
          case "April":
            month_Num = 4;
            break;            
          case "May":
            month_Num = 5;
            break;         
          case "June":
            month_Num = 6;
            break;         
          case "July":
            month_Num = 7;
            break;
          case "August":
            month_Num = 8;
            break;
          case "September":
            month_Num = 9;
            break;
          case "October":
            month_Num = 10;
            break;
          case "November":
            month_Num = 11;
            break;
          case "December":
            month_Num = 12;
            break;            
        }

        //Get Day value from Combo Box
        Integer d = (Integer)list_Days.getSelectedItem();
        days = d.intValue();
        
        //Get Year value from Combo box
        Integer y = (Integer)list_Years.getSelectedItem();
        years = y.intValue();
        
        //Get Hours value from Combo Box
        Integer h = (Integer)list_Hours.getSelectedItem();
        hours = h.intValue();
        
        //Get Minute value from Combo Box
        Integer mi = (Integer)list_Minutes.getSelectedItem();
        minutes = mi.intValue();
        
        //Get Second value from Combo Box
        Integer s = (Integer)list_Seconds.getSelectedItem();
        seconds = s.intValue();
        
        //Check if chosen date/time is valid
        if(t.setTimeAndDate(hours,minutes,seconds,month_Num,days,years))
          //Output selected values to the textfield
          output_Field.setText(t.showDateAndTime());
        else
          output_Field.setText("Invalid Date/Time");
      }
      
      //Pressing Increase Day Button, call increaseDay() and showDateAndTime on uneditable text field
      if(event.getSource() == day_inc)
      {
        t.increaseDay();
        output_Field.setText(t.showDateAndTime());
      }
      
      //Pressing Decrease Day Button, call increaseDay() and showDateAndTime on uneditable text field
      if(event.getSource() == day_dec)
      {
        t.decreaseDay();
        output_Field.setText(t.showDateAndTime());
      }
      
      //Pressing Increase Second Button, call increaseSecond() and showDateAndTime on uneditable text field
      if(event.getSource() == sec_inc)
      {
        t.increaseSecond();
        output_Field.setText(t.showDateAndTime());
      }
            
      //Pressing Decrease Day Button, call decreaseSecond() and showDateAndTime on uneditable text field
      if(event.getSource() == sec_dec)
      {
        t.decreaseSecond();
        output_Field.setText(t.showDateAndTime());
      }
    }
  }//end of Inner Private Class actionHandler
  
}//end of Time class