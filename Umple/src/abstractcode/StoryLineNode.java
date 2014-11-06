package abstractcode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 80 "gameplotabstract.ump"
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
  private StoryLineNodeConnection predecessor;
  private StoryLineNodeConnection successor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StoryLineNode(StoryLineNodeConnection aPredecessor, StoryLineNodeConnection aSuccessor)
  {
    storyLineNodeid = nextStoryLineNodeid++;
    if (aPredecessor == null || aPredecessor.getTarget() != null)
    {
      throw new RuntimeException("Unable to create StoryLineNode due to aPredecessor");
    }
    predecessor = aPredecessor;
    if (aSuccessor == null || aSuccessor.getSource() != null)
    {
      throw new RuntimeException("Unable to create StoryLineNode due to aSuccessor");
    }
    successor = aSuccessor;
  }

  public StoryLineNode(StoryLineNode aSourceForPredecessor, StoryLineNode aTargetForSuccessor)
  {
    storyLineNodeid = nextStoryLineNodeid++;
    predecessor = new StoryLineNodeConnection(this, aSourceForPredecessor);
    successor = new StoryLineNodeConnection(aTargetForSuccessor, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getStoryLineNodeid()
  {
    return storyLineNodeid;
  }

  public StoryLineNodeConnection getPredecessor()
  {
    return predecessor;
  }

  public StoryLineNodeConnection getSuccessor()
  {
    return successor;
  }

  public void delete()
  {
    StoryLineNodeConnection existingPredecessor = predecessor;
    predecessor = null;
    if (existingPredecessor != null)
    {
      existingPredecessor.delete();
    }
    StoryLineNodeConnection existingSuccessor = successor;
    successor = null;
    if (existingSuccessor != null)
    {
      existingSuccessor.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "storyLineNodeid" + ":" + getStoryLineNodeid()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "predecessor = "+(getPredecessor()!=null?Integer.toHexString(System.identityHashCode(getPredecessor())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "successor = "+(getSuccessor()!=null?Integer.toHexString(System.identityHashCode(getSuccessor())):"null")
     + outputString;
  }
}