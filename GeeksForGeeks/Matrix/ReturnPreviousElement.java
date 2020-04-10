
public class ReturnPreviousElement {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("aacbddc"); 
        System.out.print("Left of " + str + " is " +  
                                    findLeft(str)); 
    }

    public static StringBuilder findLeft(StringBuilder str) {
        int n = str.length(); 
        while(n > 0) {
            n--;
            if (str.charAt(n) == 'd') 
            { 
                str.setCharAt(n,'c'); 
                break; 
            } 
            if (str.charAt(n) == 'b') 
            { 
                str.setCharAt(n,'a'); 
                break; 
            } 
            if (str.charAt(n) == 'a') 
                str.setCharAt(n,'b'); 
            else if (str.charAt(n) == 'c') 
                str.setCharAt(n,'d'); 
        }
        return str;
    }
}