package com.solid.lsp.withoutlsp;

public class AutomaticVehicle implements Vehicle
{
  public void start()
  {
    System.out.println("Starting AutomaticVehicle");
  }

  public void changeGear()
  {
    throw new UnsupportedOperationException();
  }

  public void accelerate()
  {
    System.out.println("Accelerate AutomaticVehicle");
  }
}
