package com.solid.dip.withdip;

public class Manager
{
  private Worker worker;

  public Worker getWorker()
  {
    return worker;
  }

  public void setWorker(Worker worker)
  {
    this.worker = worker;
  }
}
