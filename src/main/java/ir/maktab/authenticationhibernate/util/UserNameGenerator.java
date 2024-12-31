package ir.maktab.authenticationhibernate.util;

public class UserNameGenerator {
    private static String username;

    public static String getUsername(String username) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) == '@') {
                break;
            }
            stringBuilder.append(username.charAt(i));
        }
        return stringBuilder.toString();
    }
}
