package V2;

import a3.AbstractC0162z;
import io.ktor.utils.io.b0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.List;
import javax.crypto.AEADBadTagException;
import kotlin.collections.n;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.text.r;
import net.bytebuddy.description.method.MethodDescription;
import u1.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements ReceiverValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1371a = 0;
    public final Object b;
    public final Object c;

    public a(String content, List parameters) {
        h.f(content, "content");
        h.f(parameters, "parameters");
        this.b = content;
        this.c = parameters;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i == 1) {
            objArr[1] = "getType";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 1 && i != 2) {
            objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static byte[] d(ByteBuffer byteBuffer, byte[] bArr) {
        int length = bArr.length % 16 == 0 ? bArr.length : (bArr.length + 16) - (bArr.length % 16);
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining % 16;
        int i3 = (i == 0 ? iRemaining : (iRemaining + 16) - i) + length;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i3 + 16).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.put(bArr);
        byteBufferOrder.position(length);
        byteBufferOrder.put(byteBuffer);
        byteBufferOrder.position(i3);
        byteBufferOrder.putLong(bArr.length);
        byteBufferOrder.putLong(iRemaining);
        return byteBufferOrder.array();
    }

    public byte[] b(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        int iPosition = byteBuffer.position();
        byte[] bArr3 = new byte[16];
        byteBuffer.position(byteBuffer.limit() - 16);
        byteBuffer.get(bArr3);
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        try {
            byte[] bArr4 = new byte[32];
            ((w0.c) this.c).a(0, bArr).get(bArr4);
            if (!MessageDigest.isEqual(b0.e(bArr4, d(byteBuffer, bArr2)), bArr3)) {
                throw new GeneralSecurityException("invalid MAC");
            }
            byteBuffer.position(iPosition);
            w0.c cVar = (w0.c) this.b;
            cVar.getClass();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
            cVar.c(bArr, byteBufferAllocate, byteBuffer);
            return byteBufferAllocate.array();
        } catch (GeneralSecurityException e) {
            throw new AEADBadTagException(e.toString());
        }
    }

    public void c(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (byteBuffer.remaining() < bArr2.length + 16) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        int iPosition = byteBuffer.position();
        w0.c cVar = (w0.c) this.b;
        cVar.getClass();
        if (byteBuffer.remaining() < bArr2.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        cVar.c(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr3 == null) {
            bArr3 = new byte[0];
        }
        byte[] bArr4 = new byte[32];
        ((w0.c) this.c).a(0, bArr).get(bArr4);
        byte[] bArrE = b0.e(bArr4, d(byteBuffer, bArr3));
        byteBuffer.limit(byteBuffer.limit() + 16);
        byteBuffer.put(bArrE);
    }

    public abstract w0.c e(int i, byte[] bArr);

    public String f(String name) {
        h.f(name, "name");
        List list = (List) this.c;
        int iX = n.x(list);
        if (iX < 0) {
            return null;
        }
        int i = 0;
        while (true) {
            j jVar = (j) list.get(i);
            if (r.x(jVar.f4866a, name)) {
                return jVar.b;
            }
            if (i == iX) {
                return null;
            }
            i++;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public AbstractC0162z getType() {
        AbstractC0162z abstractC0162z = (AbstractC0162z) this.b;
        if (abstractC0162z != null) {
            return abstractC0162z;
        }
        a(1);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0130 A[LOOP:1: B:16:0x0055->B:69:0x0130, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: V2.a.toString():java.lang.String");
    }

    public a(AbstractC0162z abstractC0162z, ReceiverValue receiverValue) {
        if (abstractC0162z != null) {
            this.b = abstractC0162z;
            this.c = receiverValue == null ? this : receiverValue;
        } else {
            a(0);
            throw null;
        }
    }

    public a(byte[] bArr) throws GeneralSecurityException {
        if (com.google.protobuf.a.a(1)) {
            this.b = e(1, bArr);
            this.c = e(0, bArr);
            return;
        }
        throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
    }
}
