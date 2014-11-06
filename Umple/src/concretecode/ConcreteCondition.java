package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 114 "gameplotconcrete.ump"
public class ConcreteCondition
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ConcreteCondition Attributes
  private String label;
  private String description;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConcreteCondition(String aLabel, String aDescription)
  {
    label = aLabel;
    description = aDescription;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLabel(String aLabel)
  {
    boolean wasSet = false;
    label = aLabel;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getLabel()
  {
    return label;
  }

  public String getDescription()
  {
    return description;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "label" + ":" + getLabel()+ "," +
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}