package com.android.dx.command.grep;

import f.m;
import java.io.File;
import java.io.PrintWriter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class Main {
    public static void main(String[] strArr) {
        System.exit(new Grep(new m(new File(strArr[0])), Pattern.compile(strArr[1]), new PrintWriter(System.out)).grep() <= 0 ? 1 : 0);
    }
}
