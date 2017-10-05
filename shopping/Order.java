/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/



// line 14 "main.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private String shippingDate;
  private String arrivalDate;

  //Order Associations
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(String aShippingDate, String aArrivalDate, Account aAccount)
  {
    shippingDate = aShippingDate;
    arrivalDate = aArrivalDate;
    boolean didAddAccount = setAccount(aAccount);
    if (!didAddAccount)
    {
      throw new RuntimeException("Unable to create order due to account");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setShippingDate(String aShippingDate)
  {
    boolean wasSet = false;
    shippingDate = aShippingDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setArrivalDate(String aArrivalDate)
  {
    boolean wasSet = false;
    arrivalDate = aArrivalDate;
    wasSet = true;
    return wasSet;
  }

  public String getShippingDate()
  {
    return shippingDate;
  }

  public String getArrivalDate()
  {
    return arrivalDate;
  }

  public Account getAccount()
  {
    return account;
  }

  public boolean setAccount(Account aAccount)
  {
    boolean wasSet = false;
    if (aAccount == null)
    {
      return wasSet;
    }

    Account existingAccount = account;
    account = aAccount;
    if (existingAccount != null && !existingAccount.equals(aAccount))
    {
      existingAccount.removeOrder(this);
    }
    account.addOrder(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Account placeholderAccount = account;
    this.account = null;
    placeholderAccount.removeOrder(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "shippingDate" + ":" + getShippingDate()+ "," +
            "arrivalDate" + ":" + getArrivalDate()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null");
  }
}