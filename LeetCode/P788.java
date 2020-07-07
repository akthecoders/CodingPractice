// import java.util.Set;
// // Rotated Digits
// public class P788 {
//     public int rotatedDigits(int N) {
//         int dp[] = new int[N + 1];
//         int res = 0;
//         Set<Integer> s1 = Set.of(0, 1, 8), s2 = Set.of(2, 5, 6, 9);
//         for (int i = 0; i < Math.min(10, N + 1); i++) {
//             if (s1.contains(i))
//                 dp[i] = 1;
//             else if (s2.contains(i)) {
//                 dp[i] = 2;
//                 res++;
//             }
//         }

//         for (int i = 10; i <= N; i++) {
//             int a = dp[i / 10];
//             int b = dp[i % 10];
//             if (a == 1 && b == 1)
//                 dp[i] = 1;
//             else if (a >= 1 && b >= 1) {
//                 dp[i] = 2;
//                 res++;
//             }
//         }
//         return res;
//     }
// }