package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 10 "gameplotconcrete.ump"
public class Condition
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Condition Attributes
  private String expression;

  //Condition Associations
  private ConcreteCondition concreteCondition;
  private Label label;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Condition(String aExpression, ConcreteCondition aConcreteCondition, Label aLabel)
  {
    expression = aExpression;
    if (!setConcreteCondition(aConcreteCondition))
    {
      throw new RuntimeException("Unable to create Condition due to aConcreteCondition");
    }
    if (!setLabel(aLabel))
    {
      throw new RuntimeException("Unable to create Condition due to aLabel");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setExpression(String aExpression)
  {
    boolean wasSet = false;
    expression = aExpression;
    wasSet = true;
    return wasSet;
  }

  public String getExpression()
  {
    return expression;
  }

  public ConcreteCondition getConcreteCondition()
  {
    return concreteCondition;
  }

  public Label getLabel()
  {
    return label;
  }

  public boolean setConcreteCondition(ConcreteCondition aNewConcreteCondition)
  {
    boolean wasSet = false;
    if (aNewConcreteCondition != null)
    {
      concreteCondition = aNewConcreteCondition;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setLabel(Label aNewLabel)
  {
    boolean wasSet = false;
    if (aNewLabel != null)
    {
      label = aNewLabel;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    concreteCondition = null;
    label = null;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "expression" + ":" + getExpression()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "concreteCondition = "+(getConcreteCondition()!=null?Integer.toHexString(System.identityHashCode(getConcreteCondition())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "label = "+(getLabel()!=null?Integer.toHexString(System.identityHashCode(getLabel())):"null")
     + outputString;
  }
}