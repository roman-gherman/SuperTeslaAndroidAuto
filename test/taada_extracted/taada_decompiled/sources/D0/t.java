package D0;

import com.google.crypto.tink.Mac;
import com.google.crypto.tink.PrimitiveWrapper;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class t implements PrimitiveWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f247a = Logger.getLogger(t.class.getName());
    public static final byte[] b = {0};
    public static final t c = new t();

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class getInputPrimitiveClass() {
        return Mac.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class getPrimitiveClass() {
        return Mac.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Object wrap(com.google.crypto.tink.l lVar) throws GeneralSecurityException {
        Iterator it = lVar.f2803a.values().iterator();
        while (it.hasNext()) {
            for (com.google.crypto.tink.j jVar : (List) it.next()) {
                com.google.crypto.tink.b bVar = jVar.f2801h;
                if (bVar instanceof q) {
                    q qVar = (q) bVar;
                    byte[] bArr = jVar.c;
                    I0.a aVarA = I0.a.a(bArr == null ? null : Arrays.copyOf(bArr, bArr.length));
                    if (!aVarA.equals(qVar.a())) {
                        throw new GeneralSecurityException("Mac Key with parameters " + qVar.b() + " has wrong output prefix (" + qVar.a() + ") instead of (" + aVarA + ")");
                    }
                }
            }
        }
        return new s(lVar);
    }
}
