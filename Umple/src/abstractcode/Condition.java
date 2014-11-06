package abstractcode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 8 "gameplotabstract.ump"
public class Condition
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Condition Attributes
  private String expression;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Condition(String aExpression)
  {
    expression = aExpression;
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

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "expression" + ":" + getExpression()+ "]"
     + outputString;
  }
}