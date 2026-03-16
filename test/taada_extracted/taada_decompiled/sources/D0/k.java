package D0;

import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.mac.ChunkedMac;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class k implements PrimitiveWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f242a = new k();

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class getInputPrimitiveClass() {
        return ChunkedMac.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class getPrimitiveClass() {
        return ChunkedMac.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Object wrap(com.google.crypto.tink.l lVar) throws GeneralSecurityException {
        if (lVar == null) {
            throw new GeneralSecurityException("primitive set must be non-null");
        }
        if (lVar.b == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        Iterator it = lVar.f2803a.values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
            }
        }
        return new i(lVar);
    }
}
