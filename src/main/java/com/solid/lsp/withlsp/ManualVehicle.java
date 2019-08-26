package com.solid.lsp.withlsp;

public class ManualVehicle implements Vehicle
{
  public void start()
  {
    System.out.println("Starting ManualVehicle");
    changeGear();
  }

  public void accelerate()
  {
    System.out.println("Accelerate ManualVehicle");
  }

  private void changeGear()
  {
    System.out.println("Gear Change");
  }
}
