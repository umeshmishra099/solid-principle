package com.solid.srp.withsrp;

import com.solid.srp.User;

public class UserSettings
{
  public void changeEmail(User user)
  {
    if (SecurityService.checkAccess(user))
    {
      System.out.println("Change email details");
    }
  }
}
