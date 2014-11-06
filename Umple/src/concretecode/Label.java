package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 155 "gameplotconcrete.ump"
public class Label
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Label Attributes
  private String description;
  private int xPosition;
  private int yPosition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Label(String aDescription, int aXPosition, int aYPosition)
  {
    description = aDescription;
    xPosition = aXPosition;
    yPosition = aYPosition;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setXPosition(int aXPosition)
  {
    boolean wasSet = false;
    xPosition = aXPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setYPosition(int aYPosition)
  {
    boolean wasSet = false;
    yPosition = aYPosition;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
  }

  public int getXPosition()
  {
    return xPosition;
  }

  public int getYPosition()
  {
    return yPosition;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "," +
            "xPosition" + ":" + getXPosition()+ "," +
            "yPosition" + ":" + getYPosition()+ "]"
     + outputString;
  }
}