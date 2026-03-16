package com.android.dx.cf.iface;

import g.C0476a;

/* JADX INFO: loaded from: classes.dex */
public class ParseException extends C0476a {
    public ParseException(String str, Throwable th) {
        super(str, th);
    }

    public ParseException(String str) {
        super(str, null);
    }

    public ParseException(Throwable th) {
        super(null, th);
    }
}
