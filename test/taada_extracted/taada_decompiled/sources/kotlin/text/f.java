package kotlin.text;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3946a;
    public final int b;

    public f(String str, int i) {
        this.f3946a = str;
        this.b = i;
    }

    private final Object readResolve() {
        Pattern patternCompile = Pattern.compile(this.f3946a, this.b);
        kotlin.jvm.internal.h.e(patternCompile, "compile(pattern, flags)");
        return new g(patternCompile);
    }
}
