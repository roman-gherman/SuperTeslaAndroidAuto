package m1;

/* JADX INFO: renamed from: m1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0636e extends com.google.android.gms.tasks.a {
    public final /* synthetic */ int c;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0636e(r1.b response, String cachedResponseText, int i) {
        super(response, cachedResponseText);
        this.c = i;
        switch (i) {
            case 1:
                kotlin.jvm.internal.h.f(response, "response");
                kotlin.jvm.internal.h.f(cachedResponseText, "cachedResponseText");
                super(response, cachedResponseText);
                this.d = "Unhandled redirect: " + response.getCall().c().getMethod().f4871a + ' ' + response.getCall().c().getUrl() + ". Status: " + response.d() + ". Text: \"" + cachedResponseText + '\"';
                break;
            case 2:
                kotlin.jvm.internal.h.f(response, "response");
                kotlin.jvm.internal.h.f(cachedResponseText, "cachedResponseText");
                super(response, cachedResponseText);
                this.d = "Server error(" + response.getCall().c().getMethod().f4871a + ' ' + response.getCall().c().getUrl() + ": " + response.d() + ". Text: \"" + cachedResponseText + '\"';
                break;
            default:
                kotlin.jvm.internal.h.f(response, "response");
                kotlin.jvm.internal.h.f(cachedResponseText, "cachedResponseText");
                this.d = "Client request(" + response.getCall().c().getMethod().f4871a + ' ' + response.getCall().c().getUrl() + ") invalid: " + response.d() + ". Text: \"" + cachedResponseText + '\"';
                break;
        }
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        switch (this.c) {
        }
        return this.d;
    }
}
