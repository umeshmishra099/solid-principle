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
```
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
  ```
  
  
All looks good, until you would want to reuse the checkAccess code at some other place OR you want to make changes to the way checkAccess is being done OR you want to make change to the way email changes are being approved. In all the later 2 cases you would end up changing the same class and in the first case you would have to use UserSettingService to check for access as well, which is unnecessary.

The correct way to implement this is to decompose the UserSettingService into 2 classes one is to checkAccess , other one is to Change the email Addresses as explained below.
```
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
```

##	Open close Principle:
Software entities like Classes, modules, functions should be OPEN for EXTENSION, CLOSED for MODIFICATION.
In simple words, once written shouldn’t be modified to add new functionality, instead one has to extend the same to add new functionality.
In other words, you don’t touch the existing modules thereby not disturbing the existing functionality; instead you extend the modules to implement the new requirement. So your code is less rigid and fragile and also extensible.

Example:
Let s take the example of loan Approval system.
```
   public class LoanApprovalHandler
    {
    public void approveLoan(PersonalValidator validator)
      {
        if ( validator.isValid())
          {
          //Process the loan.
          }
      }
    }

public class PersonalLoanValidator
{
  public boolean isValid()
  {
    //Validation logic
  }
}
```
So far so good. As you all know the requirements are never the same and now it’s required to approve vehicle loans, consumer goods loans and what not. So one approach to solve this requirement is to:
```
public class LoanApprovalHandler
{
  public void approvePersonalLoan (PersonalLoanValidator validator)
  {
    if ( validator.isValid())
    {
      //Process the loan.
    }
  }
  /*This method is added for vehicle loan but we are changing the existing class */
  public void approveVehicleLoan (VehicleLoanValidator validator )
  {
    if ( validator.isValid())
    {
      //Process the loan.
    }
  }
  // Method for approving other loans.

}

/*Presonal loan class*/
public class PersonalLoanValidator
{
  public boolean isValid()
  {
    //Validation logic
  }
}

/*new class for vehicle loan*/
public class VehicleLoanValidator
{
  public boolean isValid()
  {
    //Validation logic
  }
}
```
We have edited the existing class to accommodate the new requirements- in the process we ended up changing the name of the existing method and also adding new methods for different types of loan approval. This clearly violates the OCP
Let’s try to implement the requirement in a different way:
```
/**
 * Abstract Validator class
 * Extended to add different
 * validators for different loan type
 */
public abstract class Validator
{
  public boolean isValid();
}
/**
 * Personal loan validator
 */
public class PersonalLoanValidator  extends Validator
{
  public boolean isValid()
  {
    //Validation logic.
  }
}
/*
 * Similarly any new type of validation can
 * be accommodated by creating a new subclass
 * of Validator
 */
 
Now using the above validators we can write a LoanApprovalHandler to use the Validator abstraction.

public class LoanApprovalHandler
{
  public void approveLoan(Validator validator)
  {
    if ( validator.isValid())
    {
      //Process the loan.
    }
  }
}
```
So to accommodate any type of loan validators we would just have create a subclass of Validator and then pass it to the approveLoan method. That way the class is CLOSED for modification but OPEN for extension.

