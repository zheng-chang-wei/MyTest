package com.example.classic;

public class Out {
  private static int a;
  private int b;

  public static void main(String[] args) {
    //
  }

  public class Inner {
    private int c;

    public void print() {
      System.out.println(a);
      System.out.println(b);
    }
  }

  public static class Inner2 {
    private static int c;

    public void print() {
      System.out.println(a);
    }
  }

  class Inner3 {
    private int c;

    public void print() {
      System.out.println(a);
      System.out.println(b);
    }
  }
}

class Inner4 {
  private static int c;

  public void print() {
    System.out.println(c);
  }
}
