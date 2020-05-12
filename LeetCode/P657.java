//Robot Return to Origin
public class P657 {
    public boolean judgeCircle(String moves) {
        int hCount = 0;
        int vCount = 0;
        for(Character c: moves.toCharArray()) {
            if(c == 'U') hCount++;
            if(c == 'D') hCount--;
            if(c == 'R') vCount++;
            if(c == 'L') vCount--;
        }
        
        return hCount == 0 && vCount == 0 ? true : false;
    }
}