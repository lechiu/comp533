package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 135 "gameplotconcrete.ump"
public class SolidLine
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SolidLine Attributes
  private String colour;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SolidLine()
  {
    colour = "black";
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setColour(String aColour)
  {
    boolean wasSet = false;
    colour = aColour;
    wasSet = true;
    return wasSet;
  }

  public String getColour()
  {
    return colour;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "colour" + ":" + getColour()+ "]"
     + outputString;
  }
}