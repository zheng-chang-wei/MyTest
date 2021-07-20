package com.example.classic;

public class Father {
  {
    System.out.print("(3)");
  }
  private int i = test();

 
  static {
    System.out.print("(1)");
  }

  private static int j = method();

  public Father() {
    System.out.print("(2)");
  }
 

 
  public int test() {
    System.out.print("(4)");
    return 1;
  }
 
  public static int method() {
    System.out.print("(5)");
    return 1;
  }


}
 
