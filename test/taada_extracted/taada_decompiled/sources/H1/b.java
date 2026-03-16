package H1;

import java.nio.charset.MalformedInputException;

/* JADX INFO: loaded from: classes2.dex */
public class b extends MalformedInputException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f738a;

    public b(String str) {
        super(0);
        this.f738a = str;
    }

    @Override // java.nio.charset.MalformedInputException, java.lang.Throwable
    public final String getMessage() {
        return this.f738a;
    }
}
