package com.android.dx.command.findusages;

import f.m;
import java.io.File;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public final class Main {
    public static void main(String[] strArr) {
        String str = strArr[0];
        String str2 = strArr[1];
        String str3 = strArr[2];
        m mVar = new m(new File(str));
        PrintWriter printWriter = new PrintWriter(System.out);
        new FindUsages(mVar, str2, str3, printWriter).findUsages();
        printWriter.flush();
    }
}
