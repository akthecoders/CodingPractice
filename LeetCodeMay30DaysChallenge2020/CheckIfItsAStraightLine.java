//CheckIfItsAStraightLine
public class CheckIfItsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length <= 2) return true;
        int[] p1 = coordinates[0];
        int[] p2 = coordinates[1];
        float gFloat = slope(p1, p2);
        
        for(int i = 1; i < coordinates.length ; i++) {
            p1 = coordinates[i-1];
            p2 = coordinates[i];
            if(gFloat != slope(p1, p2)) {return false;}
        }
        return true;
    }
    
    private float slope(int[] p1, int[] p2) {
        if ((p1[0] - p2[0]) == 0) return 0;
        return (float)(p2[1] - p1[1]) / (p2[0] - p1[0]);
    }
}