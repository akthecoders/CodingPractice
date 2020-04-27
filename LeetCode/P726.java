// Number of Atoms

import java.util.*;
public class P726 {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = countHelper(formula);
        StringBuilder sb = new StringBuilder();

        for (String atom : map.keySet()) {
            String count = map.get(atom) > 1 ? map.get(atom) + "" : "";
            sb.append(atom).append(count);
        }

        return sb.toString();
    }

    public Map<String, Integer> countHelper(String formula) {
        Map<String, Integer> map = new TreeMap<>();
        if (formula.isEmpty())
            return map;

        int i = 0;
        while (i < formula.length()) {
            if (formula.charAt(i) == '(') {
                int j = findCloseParentheseIdx(formula, i);
                Map<String, Integer> subMap = countHelper(formula.substring(i + 1, j));

                j++;
                int k = j;
                while (k < formula.length() && Character.isDigit(formula.charAt(k)))
                    k++;
                int num = k > j ? Integer.parseInt(formula.substring(j, k)) : 1;

                for (String atom : subMap.keySet()) {
                    map.put(atom, subMap.get(atom) * num + map.getOrDefault(atom, 0));
                }
            } else {
                int j = i + 1;
                while (j < formula.length() && formula.charAt(j) >= 'a' && formula.charAt(j) <= 'z')
                    j++;
                String atom = formula.substring(i, j);

                int k = j;
                while (k < formula.length() && Character.isDigit(formula.charAt(k)))
                    k++;
                int num = k > j ? Integer.parseInt(formula.substring(j, k)) : 1;

                map.put(atom, num + map.getOrDefault(atom, 0));

                i = k;
            }
        }
        return map;
    }

    private int findCloseParentheseIdx(String s, int i) {
        int count = 1;
        int j;
        for (j = i + 1; j < s.length(); j++) {
            if (s.charAt(j) == '(')
                count++;
            else if (s.charAt(j) == ')')
                count--;
            if (count == 0)
                break;
        }
        return j;
    }
}