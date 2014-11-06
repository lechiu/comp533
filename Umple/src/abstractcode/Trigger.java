package abstractcode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 54 "gameplotabstract.ump"
public class Trigger extends StoryLineNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Trigger Associations
  private Mission mission;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Trigger(StoryLineNodeConnection aPredecessor, StoryLineNodeConnection aSuccessor, Mission aMission)
  {
    super(aPredecessor, aSuccessor);
    if (aMission == null || aMission.getTrigger() != null)
    {
      throw new RuntimeException("Unable to create Trigger due to aMission");
    }
    mission = aMission;
  }

  public Trigger(StoryLineNodeConnection aPredecessor, StoryLineNodeConnection aSuccessor, StoryLineNodeConnection aPredecessorForMission, StoryLineNodeConnection aSuccessorForMission, String aDescriptionForMission, ReturnPoint aReturnPointForMission)
  {
    super(aPredecessor, aSuccessor);
    mission = new Mission(aPredecessorForMission, aSuccessorForMission, aDescriptionForMission, aReturnPointForMission, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Mission getMission()
  {
    return mission;
  }

  public void delete()
  {
    Mission existingMission = mission;
    mission = null;
    if (existingMission != null)
    {
      existingMission.delete();
    }
    super.delete();
  }

}