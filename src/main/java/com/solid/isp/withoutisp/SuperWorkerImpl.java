package com.solid.isp.withoutisp;

public class SuperWorkerImpl implements Worker
{
  public void work()
  {
    System.out.println("SuperWorkerImpl work");
  }

  public void lunch()
  {
    System.out.println("SuperWorkerImpl lunch");
  }
}
