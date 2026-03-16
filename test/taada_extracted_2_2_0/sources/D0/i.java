package D0;

import com.google.crypto.tink.mac.ChunkedMac;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.mac.ChunkedMacVerification;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class i implements ChunkedMac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.crypto.tink.l f240a;

    public i(com.google.crypto.tink.l lVar) {
        this.f240a = lVar;
    }

    @Override // com.google.crypto.tink.mac.ChunkedMac
    public final ChunkedMacComputation createComputation() {
        return ((ChunkedMac) this.f240a.b.f2798a).createComputation();
    }

    @Override // com.google.crypto.tink.mac.ChunkedMac
    public final ChunkedMacVerification createVerification(byte[] bArr) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
        ArrayList arrayList = new ArrayList();
        com.google.crypto.tink.l lVar = this.f240a;
        Iterator it = lVar.a(bArrCopyOf).iterator();
        while (it.hasNext()) {
            arrayList.add(((ChunkedMac) ((com.google.crypto.tink.j) it.next()).f2798a).createVerification(bArr));
        }
        Iterator it2 = lVar.a(com.google.crypto.tink.a.f2791a).iterator();
        while (it2.hasNext()) {
            arrayList.add(((ChunkedMac) ((com.google.crypto.tink.j) it2.next()).f2798a).createVerification(bArr));
        }
        return new j(arrayList);
    }
}
