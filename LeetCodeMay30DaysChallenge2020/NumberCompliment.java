// Number Compliment
public class NumberCompliment {
    public int findComplement(int num) {
        int number_of_bits =  
               (int)(Math.floor(Math.log(num) / 
                             Math.log(2))) + 1; 
        return ((1 << number_of_bits) - 1) ^ num; 
    }
}