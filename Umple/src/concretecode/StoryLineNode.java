package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/


import java.util.*;

// line 92 "gameplotconcrete.ump"
public class StoryLineNode
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextStoryLineNodeid = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private int storyLineNodeid;

  //StoryLineNode Associations
  private List<StoryLineNodeConnection> predecessor;
  private List<StoryLineNodeConnection> successor;
  private Position position;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StoryLineNode(Position aPosition)
  {
    storyLineNodeid = nextStoryLineNodeid++;
    predecessor = new ArrayList<StoryLineNodeConnection>();
    successor = new ArrayList<StoryLineNodeConnection>();
    if (!setPosition(aPosition))
    {
      throw new RuntimeException("Unable to create StoryLineNode due to aPosition");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getStoryLineNodeid()
  {
    return storyLineNodeid;
  }

  public StoryLineNodeConnection getPredecessor(int index)
  {
    StoryLineNodeConnection aPredecessor = predecessor.get(index);
    return aPredecessor;
  }

  public List<StoryLineNodeConnection> getPredecessor()
  {
    List<StoryLineNodeConnection> newPredecessor = Collections.unmodifiableList(predecessor);
    return newPredecessor;
  }

  public int numberOfPredecessor()
  {
    int number = predecessor.size();
    return number;
  }

  public boolean hasPredecessor()
  {
    boolean has = predecessor.size() > 0;
    return has;
  }

  public int indexOfPredecessor(StoryLineNodeConnection aPredecessor)
  {
    int index = predecessor.indexOf(aPredecessor);
    return index;
  }

  public StoryLineNodeConnection getSuccessor(int index)
  {
    StoryLineNodeConnection aSuccessor = successor.get(index);
    return aSuccessor;
  }

  public List<StoryLineNodeConnection> getSuccessor()
  {
    List<StoryLineNodeConnection> newSuccessor = Collections.unmodifiableList(successor);
    return newSuccessor;
  }

  public int numberOfSuccessor()
  {
    int number = successor.size();
    return number;
  }

  public boolean hasSuccessor()
  {
    boolean has = successor.size() > 0;
    return has;
  }

  public int indexOfSuccessor(StoryLineNodeConnection aSuccessor)
  {
    int index = successor.indexOf(aSuccessor);
    return index;
  }

  public Position getPosition()
  {
    return position;
  }

  public static int minimumNumberOfPredecessor()
  {
    return 0;
  }

  public StoryLineNodeConnection addPredecessor(SolidLine aSolidLine, Position aPosition, StoryLineNode aSource)
  {
    return new StoryLineNodeConnection(aSolidLine, aPosition, this, aSource);
  }

  public boolean addPredecessor(StoryLineNodeConnection aPredecessor)
  {
    boolean wasAdded = false;
    if (predecessor.contains(aPredecessor)) { return false; }
    if (predecessor.contains(aPredecessor)) { return false; }
    if (predecessor.contains(aPredecessor)) { return false; }
    if (predecessor.contains(aPredecessor)) { return false; }
    if (predecessor.contains(aPredecessor)) { return false; }
    if (predecessor.contains(aPredecessor)) { return false; }
    if (predecessor.contains(aPredecessor)) { return false; }
    if (predecessor.contains(aPredecessor)) { return false; }
    if (predecessor.contains(aPredecessor)) { return false; }
    if (predecessor.contains(aPredecessor)) { return false; }
    StoryLineNode existingTarget = aPredecessor.getTarget();
    boolean isNewTarget = existingTarget != null && !this.equals(existingTarget);
    if (isNewTarget)
    {
      aPredecessor.setTarget(this);
    }
    else
    {
      predecessor.add(aPredecessor);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePredecessor(StoryLineNodeConnection aPredecessor)
  {
    boolean wasRemoved = false;
    //Unable to remove aPredecessor, as it must always have a target
    if (!this.equals(aPredecessor.getTarget()))
    {
      predecessor.remove(aPredecessor);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPredecessorAt(StoryLineNodeConnection aPredecessor, int index)
  {  
    boolean wasAdded = false;
    if(addPredecessor(aPredecessor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPredecessor()) { index = numberOfPredecessor() - 1; }
      predecessor.remove(aPredecessor);
      predecessor.add(index, aPredecessor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePredecessorAt(StoryLineNodeConnection aPredecessor, int index)
  {
    boolean wasAdded = false;
    if(predecessor.contains(aPredecessor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPredecessor()) { index = numberOfPredecessor() - 1; }
      predecessor.remove(aPredecessor);
      predecessor.add(index, aPredecessor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPredecessorAt(aPredecessor, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfSuccessor()
  {
    return 0;
  }

  public StoryLineNodeConnection addSuccessor(SolidLine aSolidLine, Position aPosition, StoryLineNode aTarget)
  {
    return new StoryLineNodeConnection(aSolidLine, aPosition, aTarget, this);
  }

  public boolean addSuccessor(StoryLineNodeConnection aSuccessor)
  {
    boolean wasAdded = false;
    if (successor.contains(aSuccessor)) { return false; }
    if (successor.contains(aSuccessor)) { return false; }
    if (successor.contains(aSuccessor)) { return false; }
    if (successor.contains(aSuccessor)) { return false; }
    if (successor.contains(aSuccessor)) { return false; }
    if (successor.contains(aSuccessor)) { return false; }
    if (successor.contains(aSuccessor)) { return false; }
    if (successor.contains(aSuccessor)) { return false; }
    if (successor.contains(aSuccessor)) { return false; }
    if (successor.contains(aSuccessor)) { return false; }
    StoryLineNode existingSource = aSuccessor.getSource();
    boolean isNewSource = existingSource != null && !this.equals(existingSource);
    if (isNewSource)
    {
      aSuccessor.setSource(this);
    }
    else
    {
      successor.add(aSuccessor);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSuccessor(StoryLineNodeConnection aSuccessor)
  {
    boolean wasRemoved = false;
    //Unable to remove aSuccessor, as it must always have a source
    if (!this.equals(aSuccessor.getSource()))
    {
      successor.remove(aSuccessor);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSuccessorAt(StoryLineNodeConnection aSuccessor, int index)
  {  
    boolean wasAdded = false;
    if(addSuccessor(aSuccessor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSuccessor()) { index = numberOfSuccessor() - 1; }
      successor.remove(aSuccessor);
      successor.add(index, aSuccessor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSuccessorAt(StoryLineNodeConnection aSuccessor, int index)
  {
    boolean wasAdded = false;
    if(successor.contains(aSuccessor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSuccessor()) { index = numberOfSuccessor() - 1; }
      successor.remove(aSuccessor);
      successor.add(index, aSuccessor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSuccessorAt(aSuccessor, index);
    }
    return wasAdded;
  }

  public boolean setPosition(Position aNewPosition)
  {
    boolean wasSet = false;
    if (aNewPosition != null)
    {
      position = aNewPosition;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    for(int i=predecessor.size(); i > 0; i--)
    {
      StoryLineNodeConnection aPredecessor = predecessor.get(i - 1);
      aPredecessor.delete();
    }
    for(int i=successor.size(); i > 0; i--)
    {
      StoryLineNodeConnection aSuccessor = successor.get(i - 1);
      aSuccessor.delete();
    }
    position = null;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "storyLineNodeid" + ":" + getStoryLineNodeid()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "position = "+(getPosition()!=null?Integer.toHexString(System.identityHashCode(getPosition())):"null")
     + outputString;
  }
}