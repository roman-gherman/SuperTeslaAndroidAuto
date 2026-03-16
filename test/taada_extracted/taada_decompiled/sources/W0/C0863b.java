package w0;

import C0.y;
import android.os.Build;
import com.google.crypto.tink.subtle.C;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Objects;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: renamed from: w0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0863b {
    public static final c2.b c = new c2.b(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f4958a;
    public final boolean b;

    public C0863b(byte[] bArr) throws GeneralSecurityException {
        if (!com.google.protobuf.a.b(2)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        C.a(bArr.length);
        this.f4958a = new SecretKeySpec(bArr, "AES");
        this.b = true;
    }

    public static AlgorithmParameterSpec a(byte[] bArr) {
        int length = bArr.length;
        if ("The Android Project".equals(System.getProperty("java.vendor"))) {
            int i = y.f160a;
            Integer numValueOf = !Objects.equals(System.getProperty("java.vendor"), "The Android Project") ? null : Integer.valueOf(Build.VERSION.SDK_INT);
            if ((numValueOf != null ? numValueOf.intValue() : -1) <= 19) {
                return new IvParameterSpec(bArr, 0, length);
            }
        }
        return new GCMParameterSpec(128, bArr, 0, length);
    }
}
