package M2;

/* JADX INFO: loaded from: classes2.dex */
public final class D extends F {
    public D() {
        super("HTML", 1);
    }

    @Override // M2.F
    public final String a(String string) {
        kotlin.jvm.internal.h.f(string, "string");
        return kotlin.text.r.B(kotlin.text.r.B(string, "<", "&lt;"), ">", "&gt;");
    }
}
