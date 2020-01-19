package Sorting;

/**
 * SwapsREquired
 */
public class SwapsREquired {

  public static void main(String[] args) {
    int arr[] = {1, 5, 4, 3, 2}; 
    System.out.println(swapsRequired(arr));
  }

  public static int swapsRequired(int[] arr) {
    int swaps = 0;
    Pair[] pairs = new Pair[arr.length];
    for(int i = 0; i < arr.length;i++) {
      pairs[i] = new Pair();
      pairs[i].num = arr[i];
      pairs[i].index = i;
    }
    sort(pairs);
    for(int i = 0; i < pairs.length; i++ ) {
      if(pairs[i].index == i) {
        continue;
      }
      else {
        Pair temp = pairs[i];
        pairs[i] = pairs[temp.index];
        pairs[temp.index] = temp;
      }
      if(i!=pairs[i].index) 
        --i; 
      swaps++;

    }
    return swaps;
  }


  public static void sort(Pair[] pairs) {
    for(int i = 0; i < pairs.length; i++) {
      for(int j = 0; j < pairs.length - i - 1; j++) {
        if(pairs[j].num > pairs[j+1].num) {
          Pair temp = pairs[j];
          pairs[j] = pairs[j+1];
          pairs[j+1] = temp;
        }
      }
    }
  }
}
class Pair {
  int num;
  int index;
  public Pair() {
    this.num = 0;
    this.index = 0;
  }
}