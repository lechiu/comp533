package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 29 "gameplotconcrete.ump"
public class OutBinding
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OutBinding Associations
  private Binding binding;
  private EndPoint Endpoint;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OutBinding(Binding aBinding, EndPoint aEndpoint)
  {
    boolean didAddBinding = setBinding(aBinding);
    if (!didAddBinding)
    {
      throw new RuntimeException("Unable to create outBinding due to binding");
    }
    boolean didAddEndpoint = setEndpoint(aEndpoint);
    if (!didAddEndpoint)
    {
      throw new RuntimeException("Unable to create outBinding due to Endpoint");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Binding getBinding()
  {
    return binding;
  }

  public EndPoint getEndpoint()
  {
    return Endpoint;
  }

  public boolean setBinding(Binding aBinding)
  {
    boolean wasSet = false;
    if (aBinding == null)
    {
      return wasSet;
    }

    Binding existingBinding = binding;
    binding = aBinding;
    if (existingBinding != null && !existingBinding.equals(aBinding))
    {
      existingBinding.removeOutBinding(this);
    }
    binding.addOutBinding(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setEndpoint(EndPoint aEndpoint)
  {
    boolean wasSet = false;
    if (aEndpoint == null)
    {
      return wasSet;
    }

    EndPoint existingEndpoint = Endpoint;
    Endpoint = aEndpoint;
    if (existingEndpoint != null && !existingEndpoint.equals(aEndpoint))
    {
      existingEndpoint.removeOutBinding(this);
    }
    Endpoint.addOutBinding(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Binding placeholderBinding = binding;
    this.binding = null;
    placeholderBinding.removeOutBinding(this);
    EndPoint placeholderEndpoint = Endpoint;
    this.Endpoint = null;
    placeholderEndpoint.removeOutBinding(this);
  }

}