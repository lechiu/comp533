package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 101 "gameplotconcrete.ump"
public class StoryLineNodeConnection
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextStoryLineNodeConnectionId = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private int storyLineNodeConnectionId;

  //StoryLineNodeConnection Associations
  private SolidLine solidLine;
  private Position position;
  private StoryLineNode target;
  private StoryLineNode source;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StoryLineNodeConnection(SolidLine aSolidLine, Position aPosition, StoryLineNode aTarget, StoryLineNode aSource)
  {
    storyLineNodeConnectionId = nextStoryLineNodeConnectionId++;
    if (!setSolidLine(aSolidLine))
    {
      throw new RuntimeException("Unable to create StoryLineNodeConnection due to aSolidLine");
    }
    if (!setPosition(aPosition))
    {
      throw new RuntimeException("Unable to create StoryLineNodeConnection due to aPosition");
    }
    boolean didAddTarget = setTarget(aTarget);
    if (!didAddTarget)
    {
      throw new RuntimeException("Unable to create predecessor due to target");
    }
    boolean didAddSource = setSource(aSource);
    if (!didAddSource)
    {
      throw new RuntimeException("Unable to create successor due to source");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getStoryLineNodeConnectionId()
  {
    return storyLineNodeConnectionId;
  }

  public SolidLine getSolidLine()
  {
    return solidLine;
  }

  public Position getPosition()
  {
    return position;
  }

  public StoryLineNode getTarget()
  {
    return target;
  }

  public StoryLineNode getSource()
  {
    return source;
  }

  public boolean setSolidLine(SolidLine aNewSolidLine)
  {
    boolean wasSet = false;
    if (aNewSolidLine != null)
    {
      solidLine = aNewSolidLine;
      wasSet = true;
    }
    return wasSet;
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

  public boolean setTarget(StoryLineNode aTarget)
  {
    boolean wasSet = false;
    if (aTarget == null)
    {
      return wasSet;
    }

    StoryLineNode existingTarget = target;
    target = aTarget;
    if (existingTarget != null && !existingTarget.equals(aTarget))
    {
      existingTarget.removePredecessor(this);
    }
    target.addPredecessor(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setSource(StoryLineNode aSource)
  {
    boolean wasSet = false;
    if (aSource == null)
    {
      return wasSet;
    }

    StoryLineNode existingSource = source;
    source = aSource;
    if (existingSource != null && !existingSource.equals(aSource))
    {
      existingSource.removeSuccessor(this);
    }
    source.addSuccessor(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    solidLine = null;
    position = null;
    StoryLineNode placeholderTarget = target;
    this.target = null;
    placeholderTarget.removePredecessor(this);
    StoryLineNode placeholderSource = source;
    this.source = null;
    placeholderSource.removeSuccessor(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "storyLineNodeConnectionId" + ":" + getStoryLineNodeConnectionId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "solidLine = "+(getSolidLine()!=null?Integer.toHexString(System.identityHashCode(getSolidLine())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "position = "+(getPosition()!=null?Integer.toHexString(System.identityHashCode(getPosition())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "target = "+(getTarget()!=null?Integer.toHexString(System.identityHashCode(getTarget())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "source = "+(getSource()!=null?Integer.toHexString(System.identityHashCode(getSource())):"null")
     + outputString;
  }
}