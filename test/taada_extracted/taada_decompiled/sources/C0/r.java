package C0;

import G0.A1;
import G0.EnumC0046d1;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Serialization {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f153a;
    public final I0.a b;
    public final AbstractC0381o c;
    public final EnumC0046d1 d;
    public final A1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f154f;

    public r(String str, AbstractC0381o abstractC0381o, EnumC0046d1 enumC0046d1, A1 a12, Integer num) {
        this.f153a = str;
        this.b = y.b(str);
        this.c = abstractC0381o;
        this.d = enumC0046d1;
        this.e = a12;
        this.f154f = num;
    }

    public static r a(String str, AbstractC0381o abstractC0381o, EnumC0046d1 enumC0046d1, A1 a12, Integer num) throws GeneralSecurityException {
        if (a12 == A1.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new r(str, abstractC0381o, enumC0046d1, a12, num);
    }

    @Override // com.google.crypto.tink.internal.Serialization
    public final I0.a getObjectIdentifier() {
        return this.b;
    }
}
