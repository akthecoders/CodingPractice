import java.util.HashMap;

class NoOfNo {
  public static void main(String args[]) {
    Long lng = 122L;
    String str = Long.toString(lng);
    HashMap<String, Integer> map = new HashMap<>();
    int n = str.length();
    NoOfNo permutation = new NoOfNo();
    permutation.permute(str, 0, n - 1, str, map);
    System.out.println("No of combination" + map.size());
  }

  
  private HashMap<String, Integer> permute(String str, int l, int r, String orig, HashMap<String, Integer> map) {
    if (l == r) {
      int orign = Integer.parseInt(orig);
      int curr = Integer.parseInt(str);
      if (curr > orign) {
        map.put("" + curr, curr);
      }
    } else {
      for (int i = l; i <= r; i++) {
        str = swap(str, l, i);
        permute(str, l + 1, r, orig, map);
        str = swap(str, l, i);
      }
    }
    return map;
  }

  /**
   * Swap Characters at position
   * 
   * @param a string value
   * @param i position 1
   * @param j position 2
   * @return swapped string
   */
  public String swap(String a, int i, int j) {
    char temp;
    char[] charArray = a.toCharArray();
    temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);
  }

}
