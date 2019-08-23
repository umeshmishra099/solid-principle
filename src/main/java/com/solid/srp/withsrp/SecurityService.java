package com.solid.srp.withsrp;

import com.solid.srp.User;

public class SecurityService
{
  public static boolean checkAccess(User user)
  {
    System.out.println("Access to change");
    return true;
  }

}
