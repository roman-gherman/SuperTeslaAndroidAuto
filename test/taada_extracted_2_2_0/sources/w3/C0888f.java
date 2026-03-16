package w3;

import java.io.IOException;

/* JADX INFO: renamed from: w3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0888f extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RuntimeException f5055a;

    public C0888f(RuntimeException runtimeException, String str) {
        super(str);
        this.f5055a = runtimeException;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f5055a;
    }
}
