class SubSetSum {
  public static void main(String args[]) {
    int[] input = new int[4];
    input[0] = 4;
    input[1] = 2;
    input[2] = 3;
    input[3] = 1;
    int k = 4;
    int si = 0;
    int ei = 4;
    int[][] result = findAllSubSet(input, k, si, ei);
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static int[][] findAllSubSet(int[] input, int k, int si, int ei) {
    if (si == ei) {
      if (k == 0) {
        return new int[1][0];
      } else {
        return new int[0][0];
      }
    } else {
      int[][] temp1 = findAllSubSet(input, k - input[si], si + 1, ei);
      int[][] temp2 = findAllSubSet(input, k, si + 1, ei);

      int[][] newArray = new int[temp1.length + temp2.length][];
      int count = 0;
      for (int i = 0; i < temp1.length; i++) {
        int temp1Ary[] = new int[temp1[i].length + 1];
        temp1Ary[0] = input[si];
        for (int j = 0; j < temp1[i].length; j++) {
          temp1Ary[j + 1] = temp1[i][j];
        }
        newArray[count++] = temp1Ary;
      }
      for (int i = 0; i < temp2.length; i++) {
        int temp2Ary[] = new int[temp2[i].length];
        for (int j = 0; j < temp2[i].length; j++) {
          temp2Ary[j] = temp2[i][j];
        }
        newArray[count++] = temp2Ary;
      }
      return newArray;
    }
  }
}
// Revision