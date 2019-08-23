package com.solid.srp.withoutsrp;

import com.solid.srp.User;

public class UserSettings
{
  public void changeEmail(User user)
  {
    if (checkAccess(user))
    {
      System.out.println("Change email details");
    }
  }

  private boolean checkAccess(User user)
  {
    System.out.println("Access to change");
    return true;
  }
}
