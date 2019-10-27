package com.example.healthassist;

public class Date{
  private static int month;
  private static int day;
  private static int year;

  //constructor
  public Date (int m, int d, int y){
    month = m;
    day = d;
    year = y;
  }

  public static String getDate(){
    return month + "/" + day + "/" + year;
  }

  public static int getMonth(){
    return month;
  }

  public static int getDay(){
    return day;
  }

  public static int getYear(){
    return year;
  }

  public static void setMonth(int m){
    month = m;
  }

  public static void setDay(int d){
    day = d;
  }

  public static void setYear(int y){
    year = y;
  }
}
