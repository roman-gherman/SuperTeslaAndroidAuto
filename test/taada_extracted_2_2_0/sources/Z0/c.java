package z0;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.l;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class c implements PrimitiveWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f5170a = Logger.getLogger(c.class.getName());
    public static final c b = new c();

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class getInputPrimitiveClass() {
        return DeterministicAead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class getPrimitiveClass() {
        return DeterministicAead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Object wrap(l lVar) {
        return new b(lVar);
    }
}
