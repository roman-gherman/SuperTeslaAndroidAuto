package w3;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import org.bouncycastle.asn1.ASN1Encodable;

/* JADX INFO: renamed from: w3.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0900s implements Enumeration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5071a = 0;
    public final /* synthetic */ AbstractC0902u b;

    public C0900s(AbstractC0902u abstractC0902u) {
        this.b = abstractC0902u;
    }

    @Override // java.util.Enumeration
    public final boolean hasMoreElements() {
        return this.f5071a < this.b.f5073a.length;
    }

    @Override // java.util.Enumeration
    public final Object nextElement() {
        int i = this.f5071a;
        ASN1Encodable[] aSN1EncodableArr = this.b.f5073a;
        if (i >= aSN1EncodableArr.length) {
            throw new NoSuchElementException();
        }
        this.f5071a = i + 1;
        return aSN1EncodableArr[i];
    }
}
