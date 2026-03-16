package v0;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class t extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f4922a;
    public final B.g b;
    public final Integer c;

    public t(u uVar, B.g gVar, Integer num) {
        this.f4922a = uVar;
        this.b = gVar;
        this.c = num;
    }

    public static t a(f fVar, B.g gVar, Integer num) throws GeneralSecurityException {
        f fVar2 = f.q;
        if (fVar != fVar2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + fVar + " the value of idRequirement must be non-null");
        }
        if (fVar == fVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        I0.a aVar = (I0.a) gVar.b;
        if (aVar.f749a.length != 32) {
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + aVar.f749a.length);
        }
        u uVar = new u(fVar);
        if (fVar == fVar2) {
            I0.a.a(new byte[0]);
        } else if (fVar == f.f4907p) {
            I0.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        } else {
            if (fVar != f.f4906o) {
                throw new IllegalStateException("Unknown Variant: " + fVar);
            }
            I0.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        return new t(uVar, gVar, num);
    }
}
