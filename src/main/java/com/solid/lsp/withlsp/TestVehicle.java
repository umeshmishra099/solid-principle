package com.solid.lsp.withlsp;

import java.util.ArrayList;
import java.util.List;

public class TestVehicle
{
  public static void main(String[] args)
  {
    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    vehicles.add(new ManualVehicle());
    vehicles.add(new ManualVehicle());
    vehicles.add(new AutomaticVehicle());
    vehicles.add(new AutomaticVehicle());

    for (Vehicle vehicle : vehicles)
    {
      vehicle.start();
      vehicle.accelerate();
      System.out.println("---------------------------------------");
    }
  }
}
