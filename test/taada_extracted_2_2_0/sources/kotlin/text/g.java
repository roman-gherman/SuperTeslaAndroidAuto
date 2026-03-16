package kotlin.text;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f3948a;

    public g(Pattern pattern) {
        this.f3948a = pattern;
    }

    private final Object writeReplace() {
        Pattern pattern = this.f3948a;
        String strPattern = pattern.pattern();
        kotlin.jvm.internal.h.e(strPattern, "nativePattern.pattern()");
        return new f(strPattern, pattern.flags());
    }

    public final String toString() {
        String string = this.f3948a.toString();
        kotlin.jvm.internal.h.e(string, "nativePattern.toString()");
        return string;
    }

    public g(String str) {
        Pattern patternCompile = Pattern.compile(str);
        kotlin.jvm.internal.h.e(patternCompile, "compile(pattern)");
        this.f3948a = patternCompile;
    }
}
