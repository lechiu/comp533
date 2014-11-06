package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/


import java.util.*;

// line 80 "gameplotconcrete.ump"
public class MissionTask extends StoryLineNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MissionTask Associations
  private XSymbol xSymbol;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MissionTask(Position aPosition, XSymbol aXSymbol)
  {
    super(aPosition);
    if (!setXSymbol(aXSymbol))
    {
      throw new RuntimeException("Unable to create MissionTask due to aXSymbol");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public XSymbol getXSymbol()
  {
    return xSymbol;
  }

  public boolean setXSymbol(XSymbol aNewXSymbol)
  {
    boolean wasSet = false;
    if (aNewXSymbol != null)
    {
      xSymbol = aNewXSymbol;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    xSymbol = null;
    super.delete();
  }

}