//
//  Class author:  Travis Schultz
//  Date created:  1/14/2025
//  General description: The class contains methods that hold the information about a country with getters/setters to populate the info
//

public class Country
{
  // add private instance variables for the name, capital, language, and image file.
  private String country;
  private String capital;
  private String language;
  private String image;
  // add constructors
  // no pre condition as no input, all variables get set to blank
  public Country (){
    country = "";
    capital = "";
    language = "";
    image = "";
  }

  //
  //  Pre-condition: country, capital, language, and image all must be Strings that correlate with those listed in the CSV file
  //  Post-condition: will set the current country and respective info to what is inputted
  //
  public Country (String country, String capital, String language, String image){
    this.country = country;
    this.capital = capital;
    this.language = language;
    this.image = image;
  }
  // Write accessor/get methods for each instance variable that returns it.
  // setters
  // i really hope i don't need pre/post conditions for these - inputs are strings they're just setters/getters
  public void setCountry(String country){
    this.country = country;
  }

  public void setCapital(String capital){
    this.capital = capital;
  }

  public void setLanguage(String language){
    this.language = language;
  }

  public void setImage(String image){
    this.image = image;
  }
  
  // getters
  public String getCountry(){
    return country;
  }

  public String getCapital(){
    return capital;
  }

  public String getLanguage(){
    return language;
  }

  public String getImagefile(){
    return image;
  }

  // results in a concatenated string with info from 3 of the instance variables
  // Write a toString() method that returns a concatenated String of 3 of the instance variables in a sentence like "..'s capital is .. and its primary language is ..."
 public String toString(){
  return country + "'s capital is " + capital + " and its primary language is " + language;
 }


  
}