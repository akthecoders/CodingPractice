public class P551 {
    public boolean checkRecord(String s) {
        if (s.length() == 0)
            return true;
        int noOfA = 0;
        int noOfLL = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (c == 'A') {
                noOfA++;
                if (noOfA > 1)
                    return false;
            }
            if (c == 'L') {
                while (i < s.length() && s.charAt(i) == 'L') {
                    i++;
                    noOfLL++;
                }
                if (noOfLL > 2)
                    return false;
                noOfLL = 0;
                i--;
            }
        }
        return true;

    }
}