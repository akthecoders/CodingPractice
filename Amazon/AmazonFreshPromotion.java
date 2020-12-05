public class AmazonFreshPromotion {
    // [[apple, apple], [banana, anything, banana]] shoppingCart = [orange, apple, apple, banana, orange, banana]
    public static void main(String[] args) {
        String[][] codes = {
                                {"apple", "apple"},
                                {"banana", "anything", "banana"}
                            };
        String[] shoppingCart = {"banana", "orange", "banana", "apple", "apple"};
        System.out.println("Result : " + didCustomerWon(codes, shoppingCart));
    }

    public static int didCustomerWon(String codeList[][], String[] shoppingCart) {
        int codeListId = 0;
        int codeListWordId = 0;
        int shoppingId = 0;
        int tracker = 0;

        while(codeListId < codeList.length && shoppingId < shoppingCart.length) {
            if(isMatched(codeList[codeListId][codeListWordId], shoppingCart[shoppingId])) {
                System.out.println("IF");
                codeListWordId++;
                shoppingId++;
                if(codeListWordId == codeList[codeListId].length) {
                    tracker = shoppingId;
                    codeListWordId = 0;
                    codeListId++;
                }
            }
            else {
                System.out.println("ELSE");
                tracker++;
                codeListWordId = 0;
                shoppingId = tracker;
            }
        }
        return codeListId == codeList.length ? 1 : 0;
    }

    public static  boolean isMatched(String code, String shopped) {
        System.out.println("x: " + code + " y : " + shopped);
        return "anything".equals(code) || code.equals(shopped);
    }
}
