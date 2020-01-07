package Rearrangement;

/**
 * PrintBinaryStringAlternateXY
 */
public class PrintBinaryStringAlternateXY {

    public static void main(String[] args) {
        String str = "01101101101101101000000"; 
        int x = 1; 
        int y = 2; 
        arrangeString(str, x, y); 
    }

    public static void arrangeString(String str, int x, int y) {
        int count0 = 0;
        int count1 = 0;
        int len = str.length();

        for(int i = 0; i < len; i++) {
            if(str.charAt(i) == '0') {
                count0++;
            }
            else {
                count1++;
            }
        }

        while(count0 > 0 || count1 > 0) {
            for(int i = 0; i < x && count0 > 0; i++) {
                if(count0 > 0) {
                    System.out.print("0");
                    count0--;
                }
            }
            for(int j = 0; j < y && count1 > 0; j++) {
                if(count1 > 0) {
                    System.out.print("1");
                    count1--;
                }
            }
        }
    }
}