package H0;

import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.l;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class g implements PrimitiveWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f736a = new g();

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class getInputPrimitiveClass() {
        return StreamingAead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class getPrimitiveClass() {
        return StreamingAead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Object wrap(l lVar) throws GeneralSecurityException {
        f fVar = new f();
        if (lVar.b == null) {
            throw new GeneralSecurityException("Missing primary primitive.");
        }
        fVar.f735a = lVar;
        return fVar;
    }
}
