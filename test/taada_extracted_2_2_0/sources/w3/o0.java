package w3;

import java.io.IOException;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 implements Enumeration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0890h f5068a;
    public AbstractC0899q b;

    public final AbstractC0899q a() {
        try {
            return this.f5068a.f();
        } catch (IOException e) {
            throw new h5.a("malformed ASN.1: " + e, e);
        }
    }

    @Override // java.util.Enumeration
    public final boolean hasMoreElements() {
        return this.b != null;
    }

    @Override // java.util.Enumeration
    public final Object nextElement() {
        AbstractC0899q abstractC0899q = this.b;
        if (abstractC0899q == null) {
            throw new NoSuchElementException();
        }
        this.b = a();
        return abstractC0899q;
    }
}
