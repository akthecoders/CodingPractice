//Jump Game II
public class P45 {
    public int fpos(int a[], int p) {
        int pos = -1;
        for (int i = p - 2; i >= 0; i--) {
            if ((p - 1 - a[i]) <= i) {
                pos = i;

            }
        }
        System.out.println(pos);
        return pos;
    }

    public int jump(int[] a) {
        int c = 0;
        int n = a.length;
        int pos = n; // stores a copy of the array length

        while (pos > 0) // we operate from the end of the array until the beginning is reachable
        {
            if (c == 0)
                pos = fpos(a, pos); // for first time i.e the last index's value must not be taken into account so
                                    // we skip it
            else
                pos = fpos(a, pos + 1); // all following iterations the values must be checked for optimisation check
                                        // pos+1
            ++c;

            // the variable c counts the minimum number of jumps required ( as mentioned
            // always possible
        }

        if (n == 1) // for n==1 o jump required hence 0 is returned
            return 0;
        else
            return c; // else return c
    }
}