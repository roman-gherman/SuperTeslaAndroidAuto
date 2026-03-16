package E0;

import D0.f;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.subtle.p;
import com.google.crypto.tink.subtle.q;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ChunkedMacComputation {
    public static final byte[] i = {0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cipher f278a;
    public final D0.a b;
    public final byte[] c;
    public final byte[] d;
    public final ByteBuffer e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ByteBuffer f279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ByteBuffer f280g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f281h = false;

    public a(D0.a aVar) throws InvalidKeyException {
        this.b = aVar;
        Cipher cipher = (Cipher) p.b.a("AES/ECB/NoPadding");
        this.f278a = cipher;
        cipher.init(1, new SecretKeySpec(((I0.a) aVar.b.b).b(), "AES"));
        byte[] bArrP = l.p(cipher.doFinal(new byte[16]));
        this.c = bArrP;
        this.d = l.p(bArrP);
        this.e = ByteBuffer.allocate(16);
        this.f279f = ByteBuffer.allocate(16);
        this.f280g = ByteBuffer.allocate(16);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacComputation
    public final byte[] computeMac() throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        if (this.f281h) {
            throw new IllegalStateException("Can not compute after computing the MAC tag. Please create a new object.");
        }
        D0.a aVar = this.b;
        if (aVar.f224a.c == f.e) {
            update(ByteBuffer.wrap(i));
        }
        this.f281h = true;
        ByteBuffer byteBuffer = this.e;
        return q.b(aVar.c.b(), Arrays.copyOf(this.f278a.doFinal(q.g(byteBuffer.remaining() > 0 ? q.g(l.i(Arrays.copyOf(byteBuffer.array(), byteBuffer.position())), this.d) : q.f(byteBuffer.array(), 0, 0, this.c, 16), this.f279f.array())), aVar.f224a.b));
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacComputation
    public final void update(ByteBuffer byteBuffer) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        if (this.f281h) {
            throw new IllegalStateException("Can not update after computing the MAC tag. Please create a new object.");
        }
        ByteBuffer byteBuffer2 = this.e;
        if (byteBuffer2.remaining() != 16) {
            int iMin = Math.min(byteBuffer2.remaining(), byteBuffer.remaining());
            for (int i3 = 0; i3 < iMin; i3++) {
                byteBuffer2.put(byteBuffer.get());
            }
        }
        int iRemaining = byteBuffer2.remaining();
        Cipher cipher = this.f278a;
        ByteBuffer byteBuffer3 = this.f279f;
        ByteBuffer byteBuffer4 = this.f280g;
        if (iRemaining == 0 && byteBuffer.remaining() > 0) {
            byteBuffer2.rewind();
            byteBuffer4.rewind();
            byteBuffer3.rewind();
            q.e(byteBuffer4, byteBuffer3, byteBuffer2, 16);
            byteBuffer4.rewind();
            byteBuffer3.rewind();
            cipher.doFinal(byteBuffer4, byteBuffer3);
            byteBuffer2.rewind();
        }
        while (byteBuffer.remaining() > 16) {
            byteBuffer4.rewind();
            byteBuffer3.rewind();
            q.e(byteBuffer4, byteBuffer3, byteBuffer, 16);
            byteBuffer4.rewind();
            byteBuffer3.rewind();
            cipher.doFinal(byteBuffer4, byteBuffer3);
        }
        byteBuffer2.put(byteBuffer);
    }
}
