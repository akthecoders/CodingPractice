package OrderStatistics;

import java.util.HashMap;
import java.util.Map;

/**
 * KNumbersWithMostOccurenceInArray
 */
public class KNumbersWithMostOccurenceInArray {

  public static void main(String[] args) {
    int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};
    int k = 2;
    printKNumberWithMostFrequency(arr, k);
  }

  public static void printKNumberWithMostFrequency(int[] arr, int k){
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i< arr.length; i++) {
      if(map.containsKey(arr[i])) {
        map.put(arr[i], map.get(arr[i]) + 1);
      }
      else {
        map.put(arr[i], 1);
      }
    }

    int count = 0;
    NumFre[] freq = new NumFre[map.size() + 1];
    for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
      freq[count] = new NumFre();
      freq[count].number = entry.getKey();
      freq[count].frequency = entry.getValue();
      count++;
    }

    sort(freq);
    for(int i = 0; i < k; i++) {
      System.out.println(freq[i].number + " ");
    }

  }

  public static void sort(NumFre[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 2 -i; j++) { 
        if(arr[j].frequency < arr[j+1].frequency)
        {
          NumFre temp = arr[j];
          arr[j]=arr[j+1];
          arr[j+1]=temp;
        }
        else if(arr[j].frequency == arr[j+1].frequency) {
          if(arr[j].number < arr[j+1].number){
            NumFre temp = arr[j];
            arr[j]=arr[j+1];
            arr[j+1]=temp;
          }
        }
      }
  }
}

}

class NumFre {
  int number;
  int frequency ;
  public NumFre() {
    this.number = 0;
    this.frequency = 0;
  }
}