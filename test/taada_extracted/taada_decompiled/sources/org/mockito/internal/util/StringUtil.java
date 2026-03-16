package org.mockito.internal.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class StringUtil {
    private static final Pattern CAPS = Pattern.compile("([A-Z\\d][^A-Z\\d]*)");

    private StringUtil() {
    }

    private static String decamelizeClassName(String str) {
        Matcher matcher = CAPS.matcher(str);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            if (sb.length() == 0) {
                sb.append(matcher.group());
            } else {
                sb.append(" ");
                sb.append(matcher.group().toLowerCase());
            }
        }
        return sb.toString();
    }

    public static String decamelizeMatcherName(String str) {
        if (str.length() == 0) {
            return "<custom argument matcher>";
        }
        String strDecamelizeClassName = decamelizeClassName(str);
        return strDecamelizeClassName.length() == 0 ? androidx.constraintlayout.core.motion.a.q("<", str, ">") : androidx.constraintlayout.core.motion.a.q("<", strDecamelizeClassName, ">");
    }

    public static String join(Object... objArr) {
        return join("\n", Arrays.asList(objArr));
    }

    public static String removeFirstLine(String str) {
        return str.replaceFirst(".*?\n", "");
    }

    public static String join(String str, Collection<?> collection) {
        return join(str, "", collection);
    }

    public static String join(String str, String str2, Collection<?> collection) {
        if (collection.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        for (Object obj : collection) {
            sb.append(str2);
            sb.append(obj);
            sb.append("\n");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
