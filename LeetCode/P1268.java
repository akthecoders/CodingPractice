import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Search Suggestions System
public class P1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        int index = 0;
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> list = new ArrayList<>();
            while (index < products.length) {
                if (products[index].startsWith(searchWord.substring(0, i + 1))) {
                    list.add(products[index]);
                    for (int j = index + 1; j <= index + 2 && j < products.length; j++) {
                        if (products[j].startsWith(searchWord.substring(0, i + 1)))
                            list.add(products[j]);
                    }
                    break;
                } else
                    index++;
            }
            res.add(list);
        }
        return res;

    }
}
