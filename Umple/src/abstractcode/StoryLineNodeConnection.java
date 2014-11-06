package abstractcode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 87 "gameplotabstract.ump"
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
  private StoryLineNode target;
  private StoryLineNode source;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StoryLineNodeConnection(StoryLineNode aTarget, StoryLineNode aSource)
  {
    storyLineNodeConnectionId = nextStoryLineNodeConnectionId++;
    if (aTarget == null || aTarget.getPredecessor() != null)
    {
      throw new RuntimeException("Unable to create StoryLineNodeConnection due to aTarget");
    }
    target = aTarget;
    if (aSource == null || aSource.getSuccessor() != null)
    {
      throw new RuntimeException("Unable to create StoryLineNodeConnection due to aSource");
    }
    source = aSource;
  }

  public StoryLineNodeConnection(StoryLineNodeConnection aSuccessorForTarget, StoryLineNodeConnection aPredecessorForSource)
  {
    storyLineNodeConnectionId = nextStoryLineNodeConnectionId++;
    target = new StoryLineNode(this, aSuccessorForTarget);
    source = new StoryLineNode(aPredecessorForSource, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getStoryLineNodeConnectionId()
  {
    return storyLineNodeConnectionId;
  }

  public StoryLineNode getTarget()
  {
    return target;
  }

  public StoryLineNode getSource()
  {
    return source;
  }

  public void delete()
  {
    StoryLineNode existingTarget = target;
    target = null;
    if (existingTarget != null)
    {
      existingTarget.delete();
    }
    StoryLineNode existingSource = source;
    source = null;
    if (existingSource != null)
    {
      existingSource.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "storyLineNodeConnectionId" + ":" + getStoryLineNodeConnectionId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "target = "+(getTarget()!=null?Integer.toHexString(System.identityHashCode(getTarget())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "source = "+(getSource()!=null?Integer.toHexString(System.identityHashCode(getSource())):"null")
     + outputString;
  }
}