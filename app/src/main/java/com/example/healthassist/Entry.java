package com.example.healthassist;

public class Entry{
  static int size = 18;
  //hashmap to hold data: 0-17 hold the 18 symptoms (0 for nothing, 1-5 for how
  //severe), 18 is the severity rating for the day; 19 20 and 21 is mm/dd/yyyy.
  private static int[] hashmap = new int [size+4];
  private static double weight = 1.25;

  public Entry(Date d){
    for (int i = 0; i < size; i++){
      hashmap[i] = 0;
    }
    hashmap[18] = 0;
    hashmap[19] = d.getMonth();
    hashmap[20] = d.getDay();
    hashmap[21] = d.getYear();
  }

  public Entry(int[] input){
    for (int i = 0; i < size; i++){
      hashmap[i] = input[i];
    }
    updateSeverity();
  }

  public static void editEntry(int pos, int rating){
    hashmap[pos] = rating;
    updateSeverity();
  }

  public static void editEntry(Date d){
    hashmap[19] = d.getMonth();
    hashmap[20] = d.getDay();
    hashmap[21] = d.getYear();
  }

  private static void calculator(){
    int severity = 0;
    for (int i = 0; i < size; i++){
      severity += hashmap[i]*weight;
    }
    hashmap[size] = severity;
  }

  public static void updateSeverity(){
    calculator();
  }

  public static double getSeverity(){
    return hashmap[size];
  }
}
