package com.solid.lsp.withoutlsp;

import java.util.ArrayList;
import java.util.List;

/*
 What do you think would happen when this code is executed?
 As soon as an AutomaticVehicle instance is passed, it blows up!!! Here the sub type is not replaceable for the super type
 */
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
      vehicle.changeGear();
      vehicle.accelerate();
      System.out.println("---------------------------------------");
    }
  }
}
