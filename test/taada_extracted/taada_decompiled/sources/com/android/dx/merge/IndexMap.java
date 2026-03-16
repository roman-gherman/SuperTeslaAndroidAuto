package com.android.dx.merge;

import C5.f;
import com.android.billingclient.api.z;
import com.android.dex.util.ByteInput;
import com.android.dex.util.ByteOutput;
import com.android.dx.util.ByteArrayAnnotatedOutput;
import f.C0435a;
import f.C0436b;
import f.m;
import f.n;
import f.p;
import f.q;
import f.r;
import f.s;
import f.t;
import f.u;
import f.v;
import f.x;
import f.y;
import java.util.HashMap;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes.dex */
public final class IndexMap {
    private final HashMap<Integer, Integer> annotationDirectoryOffsets;
    private final HashMap<Integer, Integer> annotationOffsets;
    private final HashMap<Integer, Integer> annotationSetOffsets;
    private final HashMap<Integer, Integer> annotationSetRefListOffsets;
    public final int[] callSiteIds;
    private final HashMap<Integer, Integer> encodedArrayValueOffset;
    public final short[] fieldIds;
    public final HashMap<Integer, Integer> methodHandleIds = new HashMap<>();
    public final short[] methodIds;
    public final short[] protoIds;
    public final int[] stringIds;
    private final m target;
    public final short[] typeIds;
    private final HashMap<Integer, Integer> typeListOffsets;

    public final class EncodedValueTransformer {
        private final ByteOutput out;

        public EncodedValueTransformer(ByteOutput byteOutput) {
            this.out = byteOutput;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void transformAnnotation(q qVar) {
            int iC = qVar.c();
            f.r0(this.out, IndexMap.this.adjustType(qVar.c));
            f.r0(this.out, iC);
            for (int i = 0; i < iC; i++) {
                f.r0(this.out, IndexMap.this.adjustString(f.Z(qVar.f3163a)));
                transform(qVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void transformArray(q qVar) {
            qVar.a(28);
            qVar.b = -1;
            int iZ = f.Z(qVar.f3163a);
            f.r0(this.out, iZ);
            for (int i = 0; i < iZ; i++) {
                transform(qVar);
            }
        }

        private void writeTypeAndArg(int i, int i3) {
            this.out.writeByte(i | (i3 << 5));
        }

        public void transform(q qVar) {
            int iB = qVar.b();
            ByteInput byteInput = qVar.f3163a;
            if (iB == 0) {
                ByteOutput byteOutput = this.out;
                qVar.a(0);
                qVar.b = -1;
                l.m0(byteOutput, 0, (byte) l.V(byteInput, qVar.d));
                return;
            }
            if (iB == 6) {
                l.m0(this.out, 6, qVar.e());
                return;
            }
            if (iB == 2) {
                ByteOutput byteOutput2 = this.out;
                qVar.a(2);
                qVar.b = -1;
                l.m0(byteOutput2, 2, (short) l.V(byteInput, qVar.d));
                return;
            }
            if (iB == 3) {
                ByteOutput byteOutput3 = this.out;
                qVar.a(3);
                qVar.b = -1;
                l.n0(byteOutput3, 3, (char) l.W(byteInput, qVar.d, false));
                return;
            }
            if (iB == 4) {
                ByteOutput byteOutput4 = this.out;
                qVar.a(4);
                qVar.b = -1;
                l.m0(byteOutput4, 4, l.V(byteInput, qVar.d));
                return;
            }
            if (iB == 16) {
                qVar.a(16);
                qVar.b = -1;
                l.l0(this.out, 16, ((long) Float.floatToIntBits(Float.intBitsToFloat(l.W(byteInput, qVar.d, true)))) << 32);
                return;
            }
            if (iB == 17) {
                l.l0(this.out, 17, Double.doubleToLongBits(qVar.d()));
                return;
            }
            switch (iB) {
                case 21:
                    ByteOutput byteOutput5 = this.out;
                    IndexMap indexMap = IndexMap.this;
                    qVar.a(21);
                    qVar.b = -1;
                    l.n0(byteOutput5, 21, indexMap.adjustProto(l.W(byteInput, qVar.d, false)));
                    return;
                case 22:
                    ByteOutput byteOutput6 = this.out;
                    IndexMap indexMap2 = IndexMap.this;
                    qVar.a(22);
                    qVar.b = -1;
                    l.n0(byteOutput6, 22, indexMap2.adjustMethodHandle(l.W(byteInput, qVar.d, false)));
                    return;
                case 23:
                    l.n0(this.out, 23, IndexMap.this.adjustString(qVar.f()));
                    return;
                case 24:
                    ByteOutput byteOutput7 = this.out;
                    IndexMap indexMap3 = IndexMap.this;
                    qVar.a(24);
                    qVar.b = -1;
                    l.n0(byteOutput7, 24, indexMap3.adjustType(l.W(byteInput, qVar.d, false)));
                    return;
                case 25:
                    ByteOutput byteOutput8 = this.out;
                    IndexMap indexMap4 = IndexMap.this;
                    qVar.a(25);
                    qVar.b = -1;
                    l.n0(byteOutput8, 25, indexMap4.adjustField(l.W(byteInput, qVar.d, false)));
                    return;
                case 26:
                    ByteOutput byteOutput9 = this.out;
                    IndexMap indexMap5 = IndexMap.this;
                    qVar.a(26);
                    qVar.b = -1;
                    l.n0(byteOutput9, 26, indexMap5.adjustMethod(l.W(byteInput, qVar.d, false)));
                    return;
                case 27:
                    ByteOutput byteOutput10 = this.out;
                    IndexMap indexMap6 = IndexMap.this;
                    qVar.a(27);
                    qVar.b = -1;
                    l.n0(byteOutput10, 27, indexMap6.adjustField(l.W(byteInput, qVar.d, false)));
                    return;
                case 28:
                    writeTypeAndArg(28, 0);
                    transformArray(qVar);
                    return;
                case 29:
                    writeTypeAndArg(29, 0);
                    transformAnnotation(qVar);
                    return;
                case 30:
                    qVar.a(30);
                    qVar.b = -1;
                    writeTypeAndArg(30, 0);
                    return;
                case 31:
                    qVar.a(31);
                    qVar.b = -1;
                    writeTypeAndArg(31, qVar.d != 0 ? 1 : 0);
                    return;
                default:
                    throw new n("Unexpected type: " + Integer.toHexString(qVar.b()), null);
            }
        }
    }

    public IndexMap(m mVar, x xVar) {
        this.target = mVar;
        this.stringIds = new int[xVar.b.b];
        this.typeIds = new short[xVar.c.b];
        this.protoIds = new short[xVar.d.b];
        this.fieldIds = new short[xVar.e.b];
        this.methodIds = new short[xVar.f3173f.b];
        this.callSiteIds = new int[xVar.f3175h.b];
        HashMap<Integer, Integer> map = new HashMap<>();
        this.typeListOffsets = map;
        this.annotationOffsets = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        this.annotationSetOffsets = map2;
        this.annotationSetRefListOffsets = new HashMap<>();
        HashMap<Integer, Integer> map3 = new HashMap<>();
        this.annotationDirectoryOffsets = map3;
        HashMap<Integer, Integer> map4 = new HashMap<>();
        this.encodedArrayValueOffset = map4;
        map.put(0, 0);
        map2.put(0, 0);
        map3.put(0, 0);
        map4.put(0, 0);
    }

    public u adjust(u uVar) {
        return new u(this.target, adjustType(uVar.b), adjustProto(uVar.c), adjustString(uVar.d));
    }

    public int adjustAnnotation(int i) {
        return this.annotationOffsets.get(Integer.valueOf(i)).intValue();
    }

    public int adjustAnnotationDirectory(int i) {
        return this.annotationDirectoryOffsets.get(Integer.valueOf(i)).intValue();
    }

    public int adjustAnnotationSet(int i) {
        return this.annotationSetOffsets.get(Integer.valueOf(i)).intValue();
    }

    public int adjustAnnotationSetRefList(int i) {
        return this.annotationSetRefListOffsets.get(Integer.valueOf(i)).intValue();
    }

    public int adjustCallSite(int i) {
        return this.callSiteIds[i];
    }

    public int adjustEncodedArray(int i) {
        return this.encodedArrayValueOffset.get(Integer.valueOf(i)).intValue();
    }

    public p adjustEncodedValue(p pVar) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput(32);
        new EncodedValueTransformer(byteArrayAnnotatedOutput).transform(new q(new z(pVar.f3162a)));
        return new p(byteArrayAnnotatedOutput.toByteArray());
    }

    public int adjustField(int i) {
        return this.fieldIds[i] & 65535;
    }

    public int adjustMethod(int i) {
        return this.methodIds[i] & 65535;
    }

    public int adjustMethodHandle(int i) {
        return this.methodHandleIds.get(Integer.valueOf(i)).intValue();
    }

    public int adjustProto(int i) {
        return this.protoIds[i] & 65535;
    }

    public int adjustString(int i) {
        if (i == -1) {
            return -1;
        }
        return this.stringIds[i];
    }

    public int adjustType(int i) {
        if (i == -1) {
            return -1;
        }
        return this.typeIds[i] & 65535;
    }

    public y adjustTypeList(y yVar) {
        if (yVar == y.c) {
            return yVar;
        }
        short[] sArr = (short[]) yVar.b.clone();
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) adjustType(sArr[i]);
        }
        return new y(this.target, sArr);
    }

    public int adjustTypeListOffset(int i) {
        return this.typeListOffsets.get(Integer.valueOf(i)).intValue();
    }

    public void putAnnotationDirectoryOffset(int i, int i3) {
        if (i <= 0 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        this.annotationDirectoryOffsets.put(Integer.valueOf(i), Integer.valueOf(i3));
    }

    public void putAnnotationOffset(int i, int i3) {
        if (i <= 0 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        this.annotationOffsets.put(Integer.valueOf(i), Integer.valueOf(i3));
    }

    public void putAnnotationSetOffset(int i, int i3) {
        if (i <= 0 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        this.annotationSetOffsets.put(Integer.valueOf(i), Integer.valueOf(i3));
    }

    public void putAnnotationSetRefListOffset(int i, int i3) {
        if (i <= 0 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        this.annotationSetRefListOffsets.put(Integer.valueOf(i), Integer.valueOf(i3));
    }

    public void putEncodedArrayValueOffset(int i, int i3) {
        if (i <= 0 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        this.encodedArrayValueOffset.put(Integer.valueOf(i), Integer.valueOf(i3));
    }

    public void putTypeListOffset(int i, int i3) {
        if (i <= 0 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        this.typeListOffsets.put(Integer.valueOf(i), Integer.valueOf(i3));
    }

    public p adjustEncodedArray(p pVar) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput(32);
        new EncodedValueTransformer(byteArrayAnnotatedOutput).transformArray(new q(pVar, 28));
        return new p(byteArrayAnnotatedOutput.toByteArray());
    }

    public C0436b adjust(C0436b c0436b) {
        return new C0436b(this.target, adjustEncodedArray(c0436b.b));
    }

    public t adjust(t tVar) {
        int iAdjustMethod;
        m mVar = this.target;
        int i = tVar.b;
        int iB = s.b(i);
        boolean z6 = true;
        if (iB != 0 && iB != 1 && iB != 2 && iB != 3) {
            z6 = false;
        }
        int i3 = tVar.d;
        if (z6) {
            iAdjustMethod = adjustField(i3);
        } else {
            iAdjustMethod = adjustMethod(i3);
        }
        return new t(mVar, i, tVar.c, iAdjustMethod, tVar.e);
    }

    public r adjust(r rVar) {
        return new r(this.target, adjustType(rVar.b), adjustType(rVar.c), adjustString(rVar.d));
    }

    public v adjust(v vVar) {
        return new v(this.target, adjustString(vVar.b), adjustType(vVar.c), adjustTypeListOffset(vVar.d));
    }

    public f.f adjust(f.f fVar) {
        return new f.f(this.target, fVar.b, adjustType(fVar.c), fVar.d, adjustType(fVar.e), adjustTypeListOffset(fVar.f3145f), fVar.f3146g, fVar.f3147h, fVar.i, fVar.f3148j);
    }

    public SortableType adjust(SortableType sortableType) {
        return new SortableType(sortableType.getDex(), sortableType.getIndexMap(), adjust(sortableType.getClassDef()));
    }

    public C0435a adjust(C0435a c0435a) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput(32);
        new EncodedValueTransformer(byteArrayAnnotatedOutput).transformAnnotation(new q(c0435a.c, 29));
        return new C0435a(this.target, c0435a.b, new p(byteArrayAnnotatedOutput.toByteArray()));
    }
}
