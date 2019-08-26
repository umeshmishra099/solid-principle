package com.solid.ocp.withocp;

public class LoanApprovalHandler
{
  public void approveLoan(PersonalLoanValidator personalLoanValidator)
  {
    if ( personalLoanValidator.isValid())
    {

    }
  }

  /*This method is added for vehicle loan but we are changing the existing class */
  public void approveVehicleLoan (VehicleLoanValidator vehicleLoanValidator )
  {
    if ( vehicleLoanValidator.isValid())
    {
      //Process the loan.
    }
  }

}
