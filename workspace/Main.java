//
//  Class author:  Travis Schultz
//  Date created:  1/14/2025
//  General description: The class contains the GUI for the Country quiz program and methods that allow the GUI elements and inputs to function,
//

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main 
{

  // array of 10 Country objects
  private Country[] countryArray = new Country[10];  
  // index of current shown country
  private int index = 0;
  private int quizPress = 0;

  // GUI elements
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;
  private JTextField input;
  
  public static void main(String[] args) {
    // Create the GUI
    Main gui = new Main();
    gui.loadCountries();
    gui.showCountry();
  }

  //
  //  Pre-condition: None
  //  Post-condition: Fills the countryArray array with all the countries in the CSV file
  //
  /* loadCountries() reads in the data from the countries-data.csv file and fills in the countryArray with data. You need to add the loop that reads in the country data into the array. */
  public void loadCountries() 
  {
    // Open the data file - do not change
    File file = new File("/workspaces/Countries/workspace/countries-data.csv");
    Scanner scan = null;
    try {
      scan = new Scanner(file);
    } catch(FileNotFoundException e) { 
        System.out.println("File not found");     
    }
    
    // Write a for loop that goes through the countryArray.
    // for(int i ....) {
    // Do the following inside the loop
    for(int i = 0; i < 10; i++){
      String input = scan.nextLine();
      String[] data = input.split(",");
      System.out.println("Read in " + data[0]);
      Country country = new Country(data[0], data[1], data[2], data[3]);
      countryArray[i] = country;
    }
      
      // inside the loop, create a new Country using your constructor with 3 arguments and pass in data[0], data[1], data[2], data[3] as arguments.
     // inside the loop, set countryArray[i] to the created Country object
     
    
  }

    //
    //  Pre-condition: None
    //  Post-condition: Displays the image relevant to the current country.
    //
  /* showCountry() will show the image associated with the current country. It should get the country at index from the countryArray. It should use its get method to get its image file name and use the code below to put the image in the GUI.
  */
  public void showCountry() {
    // Get the country at index from countryArray
    Country c = countryArray[index];
    // Use its get method to get the its image file name and save it into imagefile variable below instead of worldmap.jpg.
    String imagefile = c.getImagefile();
    // Use the following code to create an new Image Icon and put it into the GUI
    img = new ImageIcon("/workspaces/Countries/workspace/"+imagefile);
    imageLabel.setIcon(img);
  }
  
    //
    //  Pre-condition: None
    //  Post-condition: the Integer index is increased by 1 or set to 0, the output is cleared, and the country with the respective index is shown
    //
  /* nextButton should increment index. If the index is greater than 9, reset it back to 0. Clear the outputLabel to empty string using setText, and call showCountry();*/
  public void nextButtonClick()
  {
    index++;
    if(index > 9){
      index = 0;
    }
      outputLabel.setText("");
      showCountry();
    }
  
  
    //
    //  Pre-condition: None
    //  Post-condition: Sets the on-screen text to the respective information for the current country- info data from the CSV file using .toString
    //
  /* reviewButton should get the country at index from the countryArray, call its toString() method and save the result, print it out with System.out.println and as an argument to outputLabel.setText( text to print out ); */
  public void reviewButtonClick()
  {
    Country c = countryArray[index];
    String info = c.toString();
    System.out.println(info);
    outputLabel.setText(info);
     
  }

    //
    //  Pre-condition: None
    //  Post-condition: If quizPress is 1, on-screen text asks what country, if is 2 it checks the user input and and displays either correct or the incorrect answer and resets quizPress to 0
    //
  /* quizButton should clear the outputLabel (outputLabel.setText to empty string), get the country at index from countryArray, print out a question about it like What country is this? and/or What's this country's capital?. Get the user's answer using scan.nextLine() and check if it is equal to the country's data using its get methods and print out correct or incorrect.
  */
  public void quizButtonClick()
  {
    quizPress++;
    Country c = countryArray[index];
    if(quizPress == 1){
      outputLabel.setText("");
      outputLabel.setText("What country is this?");
    } else if (quizPress == 2){
      if(input.getText().toLowerCase().equals(c.getCountry().toLowerCase())){
        outputLabel.setText("Correct!");
        input.setText("");
      } else {
        outputLabel.setText("Incorrect. This is " + c.getCountry() + ".");
        input.setText("");
      } 
      quizPress = 0;
    }
  }


  /* Do NOT change anything below here */
  /* The Main() constructor is finished and will construct the GUI */
public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
        
        // create a new image icon
        img = new ImageIcon("/workspaces/Countries/workspace/worldmap.jpg");
        // create a label to display image
        imageLabel = new JLabel(img);
        // and one for output
        outputLabel = new JLabel();
        jFrame.add(imageLabel);
        jFrame.add(outputLabel);

      // input label
      input = new JTextField(20);
      jFrame.add(input);

        jFrame.setVisible(true);

  

        // add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      nextButtonClick();
    }
   });
}
  

}
