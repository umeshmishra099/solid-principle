package com.solid.lsp.withoutlsp;

public class ManualVehicle implements Vehicle
{
  public void start()
  {
    System.out.println("Starting ManualVehicle");
  }

  public void changeGear()
  {
    System.out.println("Gear Change");
  }

  public void accelerate()
  {
    System.out.println("Accelerate ManualVehicle");
  }
}
