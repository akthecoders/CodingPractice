import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

//Web Crawler
public class P1236 {
    interface HtmlParser {
        public List<String> getUrls(String url);
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> visited = new HashSet<>();

        Stack<String> stack = new Stack<>();
        String domain = getDomainName(startUrl);
        stack.push(startUrl);

        while (!stack.isEmpty()) {
            String currUrl = stack.pop();
            visited.add(currUrl);
            List<String> allURLs = htmlParser.getUrls(currUrl);
            for (String url : allURLs) {
                if (!visited.contains(url) && url.contains(domain)) {
                    stack.push(url);
                }
            }
        }
        return new ArrayList<>(visited);

    }

    public String getDomainName(String url) {
        String[] split = url.split("/");
        return split[2];
    }
}