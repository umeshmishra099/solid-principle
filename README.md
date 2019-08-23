# Solid principle
S – Single Responsibility Principle (SRP)

O- Open close Principle

L- Liskov’s Substitution Principle 

I – Interface segregation Principle 

D- Dependency Inversion Principle

## Single Responsibility Principle:
There should not be more than one reason to change a class.
In other words, Single responsibility should be given to a class.
If we have 2 reasons to change a class then if we change the class for 1st reason it might impact the 2nd functionality.

Example:
Imagine designing classes with more than one responsibility/implementing more than one functionality. There’s no one stopping you to do this. But imagine the amount of dependency your class can create within itself in the due course of the development time. So when you are asked to change certain functionality, you are not really sure how it would impact the other functionalities implemented in the class. The change might or might not impact other features, but you really can’t take risk, especially in production applications. So you end up testing all the dependent features.
You might say, we have automated tests, and the number of tests to be checked are low, but imagine the impact over time. This kind of changes get accumulates owing to the viscosity of the code making it really fragile and rigid.
One way to correct the violation of SRP is to decompose the class functionalities into different classes, each of which confirms to SRP.
An example to clarify this principle:
Used in project:
We have to change the email address of the user  in the application , first we have to check user have access to change the email address then change the email address.
   public class UserSettingService
   {
        public void changeEmail(User user)
             {
               if(checkAccess(user))
              {
                //Grant option to change
              }
        }
       public boolean checkAccess(User user)
       {
          //Verify if the user is valid.
       }
  }
  
All looks good, until you would want to reuse the checkAccess code at some other place OR you want to make changes to the way checkAccess is being done OR you want to make change to the way email changes are being approved. In all the later 2 cases you would end up changing the same class and in the first case you would have to use UserSettingService to check for access as well, which is unnecessary.

The correct way to implement this is to decompose the UserSettingService into 2 classes one is to checkAccess , other one is to Change the email Addresses as explained below.
     public class UserSettingService
     {
         public void changeEmail(User user)
           {
              if(SecurityService.checkAccess(user))
              {
                //Grant option to change
              }
           }
     }

    /*Second class for access check only*/
    public class SecurityService
    {
         public static boolean checkAccess(User user)
          {
           //check the access.
          }
    }

