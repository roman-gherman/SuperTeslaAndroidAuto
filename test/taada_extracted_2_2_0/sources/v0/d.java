package v0;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.PrimitiveWrapper;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class d implements PrimitiveWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f4896a = Logger.getLogger(d.class.getName());
    public static final d b = new d();

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class getInputPrimitiveClass() {
        return Aead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class getPrimitiveClass() {
        return Aead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Object wrap(com.google.crypto.tink.l lVar) {
        return new c(lVar);
    }
}
