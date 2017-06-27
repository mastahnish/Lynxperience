package myosolutions.pl.lynxperience.utils;

public class StringUtils {
    private StringUtils() {
    }

    public static String Blank = "";

    public static boolean isEmpty(String str) {
        return str == null || str.length() <= 0;
    }

    public static String notNull(String str) {
        return str == null ? Blank : str;
    }

    public static boolean containsIgnoreCase(CharSequence searchIn, CharSequence searchFor) {
        if (searchIn == null || searchFor == null) {
            return false;
        }
        return searchIn.toString().toLowerCase().contains(searchFor.toString().toLowerCase());
    }

}
