import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//IPO
public class P502 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        List<Project> projects = new LinkedList<>();
        for (int i = 0; i < Capital.length; i++)
            projects.add(new Project(Capital[i], Profits[i]));
        Collections.sort(projects, (Project a, Project b) -> b.profit - a.profit);
        int totalCapital = W;
        while (k-- > 0) {
            Iterator<Project> itr = projects.iterator();
            while (itr.hasNext()) {
                Project pr = itr.next();
                if (totalCapital >= pr.capital) {
                    totalCapital += pr.profit;
                    itr.remove();
                    break;
                }
            }
        }
        return totalCapital;
    }
}

class Project {
    int capital;
    int profit;

    Project(int capital, int profit) {
        this.capital = capital;
        this.profit = profit;
    }
}
