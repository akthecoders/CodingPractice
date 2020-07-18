//Integer to English Words
public class P273 {
    String[] ones = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    String[] ten = new String[] { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen" };
    String[] tens = new String[] { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };
    String[] large = new String[] { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int i = 0;
        String output = "";

        while (num != 0) {
            if (num % 1000 != 0) {
                output = formatNumber(num % 1000) + " " + large[i] + " " + output;
            }
            num = num / 1000;
            i++;
        }
        return output.trim().replaceAll("\\s\\s+", " ");

    }
 
    private String formatNumber(int num) {
        if (num < 10) {
            return ones[num];
        } else if (num < 20) {
            return ten[num - 10];
        } else if (num < 100) {
            return tens[num / 10] + " " + formatNumber(num % 10);
        } else if (num < 1000) {
            return ones[num / 100] + " Hundred " + formatNumber(num % 100);
        } else {
            return "";
        }
    }
}