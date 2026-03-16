package Y1;

import c2.c;
import c2.f;
import d2.C0416a;
import e2.C0430f;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public class b extends X1.b {
    @Override // W1.b
    public final f b() {
        Integer num = a.f1481a;
        return (num == null || num.intValue() >= 34) ? new C0416a() : new c();
    }

    @Override // W1.b
    public final kotlin.text.c c(String str, MatchResult matchResult) {
        Matcher matcher = matchResult instanceof Matcher ? (Matcher) matchResult : null;
        if (matcher == null) {
            throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        }
        int iStart = matcher.start(str);
        C0430f c0430f = new C0430f(iStart, matcher.end(str) - 1, 1);
        if (iStart < 0) {
            return null;
        }
        String strGroup = matcher.group(str);
        h.e(strGroup, "matcher.group(name)");
        return new kotlin.text.c(strGroup, c0430f);
    }
}
