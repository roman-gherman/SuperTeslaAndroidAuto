package v0;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class p extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f4918a;
    public final B.g b;
    public final Integer c;

    public p(q qVar, B.g gVar, Integer num) {
        this.f4918a = qVar;
        this.b = gVar;
        this.c = num;
    }

    public static p a(f fVar, B.g gVar, Integer num) throws GeneralSecurityException {
        f fVar2 = f.f4905n;
        if (fVar != fVar2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + fVar + " the value of idRequirement must be non-null");
        }
        if (fVar == fVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        I0.a aVar = (I0.a) gVar.b;
        if (aVar.f749a.length != 32) {
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + aVar.f749a.length);
        }
        q qVar = new q(fVar);
        if (fVar == fVar2) {
            I0.a.a(new byte[0]);
        } else if (fVar == f.f4904m) {
            I0.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        } else {
            if (fVar != f.f4903l) {
                throw new IllegalStateException("Unknown Variant: " + fVar);
            }
            I0.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        return new p(qVar, gVar, num);
    }
}
