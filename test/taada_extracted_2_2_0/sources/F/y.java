package f;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class y implements Comparable {
    public static final y c = new y(null, m.f3157j);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f3189a;
    public final short[] b;

    public y(m mVar, short[] sArr) {
        this.f3189a = mVar;
        this.b = sArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
    
        return kotlin.reflect.l.j(r2.length, r6.b.length);
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int compareTo(java.lang.Object r6) {
        /*
            r5 = this;
            f.y r6 = (f.y) r6
            r0 = 0
            r1 = r0
        L4:
            short[] r2 = r5.b
            int r3 = r2.length
            if (r1 >= r3) goto L26
            short[] r3 = r6.b
            int r4 = r3.length
            if (r1 >= r4) goto L26
            short r2 = r2[r1]
            short r3 = r3[r1]
            if (r2 == r3) goto L23
            if (r2 != r3) goto L17
            return r0
        L17:
            r6 = 65535(0xffff, float:9.1834E-41)
            r0 = r2 & r6
            r6 = r6 & r3
            if (r0 >= r6) goto L21
            r6 = -1
            return r6
        L21:
            r6 = 1
            return r6
        L23:
            int r1 = r1 + 1
            goto L4
        L26:
            int r0 = r2.length
            short[] r6 = r6.b
            int r6 = r6.length
            int r6 = kotlin.reflect.l.j(r0, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: f.y.compareTo(java.lang.Object):int");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        short[] sArr = this.b;
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            m mVar = this.f3189a;
            sb.append(mVar != null ? (Serializable) mVar.f3159f.get((int) sArr[i]) : Short.valueOf(sArr[i]));
        }
        sb.append(")");
        return sb.toString();
    }
}
