package J4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.TreeMap;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Serializable {
    private static final long serialVersionUID = -3464451825208522308L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeMap f879a = new TreeMap();
    public transient long b;

    public b(long j6) {
        this.b = j6;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.b = objectInputStream.available() != 0 ? objectInputStream.readLong() : 0L;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(this.b);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(J4.o r28, long r29, byte[] r31, byte[] r32) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J4.b.a(J4.o, long, byte[], byte[]):void");
    }

    public final b b(C0896n c0896n) {
        b bVar = new b(this.b);
        TreeMap treeMap = this.f879a;
        for (Integer num : treeMap.keySet()) {
            a aVar = (a) treeMap.get(num);
            aVar.getClass();
            bVar.f879a.put(num, new a(aVar, c0896n));
        }
        return bVar;
    }

    public b(b bVar, long j6) {
        for (Integer num : bVar.f879a.keySet()) {
            this.f879a.put(num, new a((a) bVar.f879a.get(num)));
        }
        this.b = j6;
    }

    public b(o oVar, long j6, byte[] bArr, byte[] bArr2) {
        this.b = (1 << oVar.c) - 1;
        for (long j7 = 0; j7 < j6; j7++) {
            a(oVar, j7, bArr, bArr2);
        }
    }
}
