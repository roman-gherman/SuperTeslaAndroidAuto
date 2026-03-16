package J1;

import I1.f;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f830a = new byte[0];

    public static final void a(f fVar, b bVar) {
        h.f(fVar, "<this>");
        if (bVar == fVar) {
            return;
        }
        int i = bVar.c;
        int i3 = bVar.b;
        if (i <= i3) {
            fVar.b(bVar);
            return;
        }
        int i4 = bVar.e;
        int i5 = bVar.f751f;
        if (i5 - i4 >= 8) {
            fVar.d = i3;
            return;
        }
        b bVarH = bVar.h();
        if (bVarH == null) {
            fVar.c(bVar);
            return;
        }
        int i6 = bVar.c - bVar.b;
        int iMin = Math.min(i6, 8 - (i5 - bVar.e));
        if (bVarH.d < iMin) {
            fVar.c(bVar);
            return;
        }
        bVarH.d(bVarH.b - iMin);
        if (i6 > iMin) {
            bVar.e = i5;
            fVar.e = bVar.c;
            fVar.i(fVar.f761f + ((long) iMin));
        } else {
            fVar.j(bVarH);
            fVar.i(fVar.f761f - ((long) ((bVarH.c - bVarH.b) - iMin)));
            bVar.g();
            bVar.j(fVar.f760a);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x010e, code lost:
    
        if (r5 != r7) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0110, code lost:
    
        r7 = r4 - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0112, code lost:
    
        if (r7 <= 0) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0114, code lost:
    
        if (r6 < r3) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0118, code lost:
    
        r8 = r6 + 1;
        r19 = r22.charAt(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0122, code lost:
    
        if (java.lang.Character.isHighSurrogate(r19) != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0124, code lost:
    
        r6 = r8;
        r19 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0125, code lost:
    
        r8 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0128, code lost:
    
        if (r8 == r3) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0132, code lost:
    
        if (java.lang.Character.isLowSurrogate(r22.charAt(r8)) != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0135, code lost:
    
        r6 = r6 + 2;
        r19 = ((r19 - 55232) << 10) | (r22.charAt(r8) - 56320);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0144, code lost:
    
        r6 = r8;
        r8 = 63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0146, code lost:
    
        if (1 > r8) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0148, code lost:
    
        if (r8 >= 128) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x014a, code lost:
    
        r12 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x014c, code lost:
    
        if (128 > r8) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x014e, code lost:
    
        if (r8 >= 2048) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0150, code lost:
    
        r12 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0152, code lost:
    
        if (2048 > r8) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0154, code lost:
    
        if (r8 >= 65536) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0156, code lost:
    
        r12 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0158, code lost:
    
        if (65536 > r8) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x015a, code lost:
    
        if (r8 >= 1114112) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x015c, code lost:
    
        r12 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x015e, code lost:
    
        if (r12 <= r7) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0160, code lost:
    
        r6 = r6 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0164, code lost:
    
        if (r8 < 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0166, code lost:
    
        if (r8 >= 128) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0168, code lost:
    
        r21.put(r5, (byte) r8);
        r7 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x016e, code lost:
    
        if (128 > r8) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0170, code lost:
    
        if (r8 >= 2048) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0172, code lost:
    
        r21.put(r5, (byte) (((r8 >> 6) & 31) | 192));
        r21.put(r5 + 1, (byte) ((r8 & 63) | 128));
        r7 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0187, code lost:
    
        if (2048 > r8) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0189, code lost:
    
        if (r8 >= 65536) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x018b, code lost:
    
        r21.put(r5, (byte) (((r8 >> 12) & 15) | 224));
        r21.put(r5 + 1, (byte) (((r8 >> 6) & 63) | 128));
        r21.put(r5 + 2, (byte) ((r8 & 63) | 128));
        r7 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01aa, code lost:
    
        if (65536 > r8) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01ac, code lost:
    
        if (r8 >= 1114112) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ae, code lost:
    
        r21.put(r5, (byte) (((r8 >> 18) & 7) | fr.sd.taada.proto.KeyCode.KEYCODE_TV_SATELLITE_SERVICE_VALUE));
        r21.put(r5 + 1, (byte) (((r8 >> 12) & 63) | 128));
        r21.put(r5 + 2, (byte) (((r8 >> 6) & 63) | 128));
        r21.put(r5 + 3, (byte) ((r8 & 63) | 128));
        r7 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01d7, code lost:
    
        r5 = r5 + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01da, code lost:
    
        c(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01dd, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01de, code lost:
    
        c(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01e1, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01e2, code lost:
    
        r0 = (short) (r6 - r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01f0, code lost:
    
        r0 = (short) (r6 - r23);
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int b(java.nio.ByteBuffer r21, java.lang.CharSequence r22, int r23, int r24, int r25, int r26) {
        /*
            Method dump skipped, instruction units count: 504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.c.b(java.nio.ByteBuffer, java.lang.CharSequence, int, int, int, int):int");
    }

    public static final void c(int i) {
        throw new IllegalArgumentException(B2.b.d(i, "Malformed code-point ", " found"));
    }

    public static final b d(f fVar, int i) {
        h.f(fVar, "<this>");
        return fVar.g(i, fVar.e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final b e(f fVar, b bVar) {
        h.f(fVar, "<this>");
        if (bVar != fVar) {
            return fVar.b(bVar);
        }
        if (fVar.d == fVar.e && fVar.f761f == 0) {
            return null;
        }
        return (b) fVar;
    }

    public static final b f(I1.c cVar, int i, b bVar) {
        h.f(cVar, "<this>");
        if (bVar != null) {
            cVar.a();
        }
        return cVar.d(i);
    }
}
