package org.mockito.internal.util;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class Platform {
    private static final Pattern JAVA_8_RELEASE_VERSION_SCHEME = Pattern.compile("1\\.8\\.0_(\\d+)(?:-ea)?(?:-b\\d+)?");
    private static final Pattern JAVA_8_DEV_VERSION_SCHEME = Pattern.compile("1\\.8\\.0b\\d+_u(\\d+)");
    public static final String JAVA_VERSION = System.getProperty("java.specification.version");
    public static final String JVM_VERSION = System.getProperty("java.runtime.version");
    public static final String JVM_VENDOR = System.getProperty("java.vm.vendor");
    public static final String JVM_VENDOR_VERSION = System.getProperty("java.vm.version");
    public static final String JVM_NAME = System.getProperty("java.vm.name");
    public static final String JVM_INFO = System.getProperty("java.vm.info");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String OS_VERSION = System.getProperty("os.version");

    private Platform() {
    }

    public static String describe() {
        String str = "Java               : " + JAVA_VERSION + "\nJVM vendor name    : " + JVM_VENDOR + "\nJVM vendor version : " + JVM_VENDOR_VERSION + "\nJVM name           : " + JVM_NAME + "\nJVM version        : " + JVM_VERSION + "\nJVM info           : " + JVM_INFO + "\nOS name            : " + OS_NAME + "\nOS version         : " + OS_VERSION + "\n";
        return isAndroid() ? StringUtil.join("IMPORTANT INFORMATION FOR ANDROID USERS:", "", "The regular Byte Buddy mock makers cannot generate code on an Android VM!", "To resolve this, please use the 'mockito-android' dependency for your application:", "https://search.maven.org/artifact/org.mockito/mockito-android", "", str) : str;
    }

    public static boolean isAndroid() {
        return System.getProperty("java.vendor", "").toLowerCase(Locale.US).contains("android");
    }

    public static boolean isAndroidMockMakerRequired() {
        return Boolean.getBoolean("org.mockito.mock.android");
    }

    public static boolean isJava8BelowUpdate45() {
        String str = JVM_VERSION;
        if (str == null) {
            return false;
        }
        return isJava8BelowUpdate45(str);
    }

    public static String warnForVM(String str, String str2, String str3, String str4) {
        return warnForVM(JVM_NAME, str, str2, str3, str4);
    }

    public static String warnForVM(String str, String str2, String str3, String str4, String str5) {
        return (str2 == null || !str.contains(str2)) ? (str4 == null || !str.contains(str4)) ? "" : str5 : str3;
    }

    public static boolean isJava8BelowUpdate45(String str) {
        Matcher matcher = JAVA_8_RELEASE_VERSION_SCHEME.matcher(str);
        if (matcher.matches()) {
            return Integer.parseInt(matcher.group(1)) < 45;
        }
        Matcher matcher2 = JAVA_8_DEV_VERSION_SCHEME.matcher(str);
        if (matcher2.matches()) {
            return Integer.parseInt(matcher2.group(1)) < 45;
        }
        return Pattern.compile("1\\.8\\.0-b\\d+").matcher(str).matches();
    }
}
