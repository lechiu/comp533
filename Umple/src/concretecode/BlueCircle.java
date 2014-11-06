package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 144 "gameplotconcrete.ump"
public class BlueCircle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BlueCircle Attributes
  private int size;
  private String colour;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BlueCircle(int aSize)
  {
    size = aSize;
    colour = "blue";
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSize(int aSize)
  {
    boolean wasSet = false;
    size = aSize;
    wasSet = true;
    return wasSet;
  }

  public boolean setColour(String aColour)
  {
    boolean wasSet = false;
    colour = aColour;
    wasSet = true;
    return wasSet;
  }

  public int getSize()
  {
    return size;
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
            "size" + ":" + getSize()+ "," +
            "colour" + ":" + getColour()+ "]"
     + outputString;
  }
}