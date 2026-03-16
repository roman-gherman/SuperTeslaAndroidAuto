package com.google.gson.internal;

import net.bytebuddy.ClassFileVersion;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3002a;

    static {
        int i;
        String property = System.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION);
        try {
            String[] strArrSplit = property.split("[._]");
            i = Integer.parseInt(strArrSplit[0]);
            if (i == 1 && strArrSplit.length > 1) {
                i = Integer.parseInt(strArrSplit[1]);
            }
        } catch (NumberFormatException unused) {
            i = -1;
        }
        if (i == -1) {
            try {
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < property.length(); i3++) {
                    char cCharAt = property.charAt(i3);
                    if (!Character.isDigit(cCharAt)) {
                        break;
                    }
                    sb.append(cCharAt);
                }
                i = Integer.parseInt(sb.toString());
            } catch (NumberFormatException unused2) {
                i = -1;
            }
        }
        if (i == -1) {
            i = 6;
        }
        f3002a = i;
    }
}
