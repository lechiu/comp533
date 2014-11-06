package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/


import java.util.*;

// line 57 "gameplotconcrete.ump"
public class ReturnPoint extends StoryLineNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ReturnPoint Associations
  private Mission Mission;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ReturnPoint(Position aPosition, Mission aMission)
  {
    super(aPosition);
    if (aMission == null || aMission.getReturnPoint() != null)
    {
      throw new RuntimeException("Unable to create ReturnPoint due to aMission");
    }
    Mission = aMission;
  }

  public ReturnPoint(Position aPosition, Position aPositionForMission, String aDescriptionForMission, Diamond aDiamondForMission, Trigger aTriggerForMission)
  {
    super(aPosition);
    Mission = new Mission(aPositionForMission, aDescriptionForMission, this, aDiamondForMission, aTriggerForMission);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Mission getMission()
  {
    return Mission;
  }

  public void delete()
  {
    Mission existingMission = Mission;
    Mission = null;
    if (existingMission != null)
    {
      existingMission.delete();
    }
    super.delete();
  }

}