package com.solid.dip.withoutdip;

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
