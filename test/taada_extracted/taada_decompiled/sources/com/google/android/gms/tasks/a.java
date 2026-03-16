package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes.dex */
public class a extends IllegalStateException {
    public static final /* synthetic */ int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2173a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i, String str, Throwable th) {
        super(str, th);
        this.f2173a = i;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        switch (this.f2173a) {
            case 2:
                return null;
            default:
                return super.getCause();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(String str, int i) {
        super(str);
        this.f2173a = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(r1.b response, String cachedResponseText) {
        super("Bad response: " + response + ". Text: \"" + cachedResponseText + '\"');
        this.f2173a = 3;
        kotlin.jvm.internal.h.f(response, "response");
        kotlin.jvm.internal.h.f(cachedResponseText, "cachedResponseText");
    }
}
