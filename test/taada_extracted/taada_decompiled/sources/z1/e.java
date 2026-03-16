package z1;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5174a;
    public final int b;

    public e(String content) {
        kotlin.jvm.internal.h.f(content, "content");
        this.f5174a = content;
        String lowerCase = content.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.h.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        this.b = lowerCase.hashCode();
    }

    public final boolean equals(Object obj) {
        String str;
        e eVar = obj instanceof e ? (e) obj : null;
        return (eVar == null || (str = eVar.f5174a) == null || !str.equalsIgnoreCase(this.f5174a)) ? false : true;
    }

    public final int hashCode() {
        return this.b;
    }

    public final String toString() {
        return this.f5174a;
    }
}
