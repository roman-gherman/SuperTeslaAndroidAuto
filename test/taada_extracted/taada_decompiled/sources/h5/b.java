package h5;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f3459a = new c();

    public static byte[] a(String str) {
        try {
            return f3459a.a(str.length(), str);
        } catch (Exception e) {
            a aVar = new a("exception decoding Hex string: " + e.getMessage(), 0);
            aVar.b = e;
            throw aVar;
        }
    }

    public static byte[] b(int i, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f3459a.encode(bArr, 0, i, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            a aVar = new a("exception encoding Hex string: " + e.getMessage(), 1);
            aVar.b = e;
            throw aVar;
        }
    }
}
