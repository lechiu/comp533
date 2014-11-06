package abstractcode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 49 "gameplotabstract.ump"
public class ReturnPoint extends StoryLineNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ReturnPoint Associations
  private Mission mission;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ReturnPoint(StoryLineNodeConnection aPredecessor, StoryLineNodeConnection aSuccessor, Mission aMission)
  {
    super(aPredecessor, aSuccessor);
    if (aMission == null || aMission.getReturnPoint() != null)
    {
      throw new RuntimeException("Unable to create ReturnPoint due to aMission");
    }
    mission = aMission;
  }

  public ReturnPoint(StoryLineNodeConnection aPredecessor, StoryLineNodeConnection aSuccessor, StoryLineNodeConnection aPredecessorForMission, StoryLineNodeConnection aSuccessorForMission, String aDescriptionForMission, Trigger aTriggerForMission)
  {
    super(aPredecessor, aSuccessor);
    mission = new Mission(aPredecessorForMission, aSuccessorForMission, aDescriptionForMission, this, aTriggerForMission);
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