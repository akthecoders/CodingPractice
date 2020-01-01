package Rotation;

/**
 * StringRotateEqual
 */
public class StringRotateEqual {
    static boolean isRotated(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        String clock_rot = "";
        String anticlock_rot = "";
        int len = str2.length();

        anticlock_rot = anticlock_rot + str2.substring(len - 2, len) + str2.substring(0, len - 2);

        clock_rot = clock_rot + str2.substring(2) + str2.substring(0, 2);

        return (str1.equals(clock_rot) || str1.equals(anticlock_rot));
    }

    public static void main(String[] args) {
        String str1 = "geeks";
        String str2 = "eksge";

        System.out.println(isRotated(str1, str2) ? "Yes" : "No");
    }
}