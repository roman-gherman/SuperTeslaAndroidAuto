package kotlin.text;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f3943a;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        kotlin.jvm.internal.h.e(charsetForName, "forName(\"UTF-8\")");
        f3943a = charsetForName;
        kotlin.jvm.internal.h.e(Charset.forName("UTF-16"), "forName(\"UTF-16\")");
        kotlin.jvm.internal.h.e(Charset.forName("UTF-16BE"), "forName(\"UTF-16BE\")");
        kotlin.jvm.internal.h.e(Charset.forName("UTF-16LE"), "forName(\"UTF-16LE\")");
        kotlin.jvm.internal.h.e(Charset.forName("US-ASCII"), "forName(\"US-ASCII\")");
        kotlin.jvm.internal.h.e(Charset.forName("ISO-8859-1"), "forName(\"ISO-8859-1\")");
    }
}
