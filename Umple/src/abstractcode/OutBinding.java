package abstractcode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 24 "gameplotabstract.ump"
public class OutBinding
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OutBinding Associations
  private Binding binding;
  private EndPoint endpoint;

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
      throw new RuntimeException("Unable to create outBinding due to endpoint");
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
    return endpoint;
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

    EndPoint existingEndpoint = endpoint;
    endpoint = aEndpoint;
    if (existingEndpoint != null && !existingEndpoint.equals(aEndpoint))
    {
      existingEndpoint.removeOutBinding(this);
    }
    endpoint.addOutBinding(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Binding placeholderBinding = binding;
    this.binding = null;
    placeholderBinding.removeOutBinding(this);
    EndPoint placeholderEndpoint = endpoint;
    this.endpoint = null;
    placeholderEndpoint.removeOutBinding(this);
  }

}