package com.android.dx.merge;

import B2.b;
import E1.k;
import a.AbstractC0132a;
import com.android.dx.command.dexer.DxContext;
import f.C0435a;
import f.C0436b;
import f.C0437c;
import f.C0438d;
import f.e;
import f.f;
import f.g;
import f.h;
import f.i;
import f.j;
import f.l;
import f.m;
import f.n;
import f.o;
import f.p;
import f.q;
import f.r;
import f.s;
import f.t;
import f.u;
import f.v;
import f.w;
import f.x;
import f.y;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UTFDataFormatException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.Adler32;

/* JADX INFO: loaded from: classes.dex */
public final class DexMerger {
    private static final byte DBG_ADVANCE_LINE = 2;
    private static final byte DBG_ADVANCE_PC = 1;
    private static final byte DBG_END_LOCAL = 5;
    private static final byte DBG_END_SEQUENCE = 0;
    private static final byte DBG_RESTART_LOCAL = 6;
    private static final byte DBG_SET_EPILOGUE_BEGIN = 8;
    private static final byte DBG_SET_FILE = 9;
    private static final byte DBG_SET_PROLOGUE_END = 7;
    private static final byte DBG_START_LOCAL = 3;
    private static final byte DBG_START_LOCAL_EXTENDED = 4;
    private final l annotationOut;
    private final l annotationSetOut;
    private final l annotationSetRefListOut;
    private final l annotationsDirectoryOut;
    private final l classDataOut;
    private final l codeOut;
    private final CollisionPolicy collisionPolicy;
    private int compactWasteThreshold;
    private final x contentsOut;
    private final DxContext context;
    private final l debugInfoOut;
    private final m dexOut;
    private final m[] dexes;
    private final l encodedArrayOut;
    private final l headerOut;
    private final l idsDefsOut;
    private final IndexMap[] indexMaps;
    private final InstructionTransformer instructionTransformer;
    private final l mapListOut;
    private final l stringDataOut;
    private final l typeListOut;
    private final WriterSizes writerSizes;

    public abstract class IdMerger<T extends Comparable<T>> {
        private final l out;

        public class UnsortedValue implements Comparable<IdMerger<T>.UnsortedValue> {
            final int index;
            final IndexMap indexMap;
            final int offset;
            final m source;
            final T value;

            public UnsortedValue(m mVar, IndexMap indexMap, T t6, int i, int i3) {
                this.source = mVar;
                this.indexMap = indexMap;
                this.value = t6;
                this.index = i;
                this.offset = i3;
            }

            @Override // java.lang.Comparable
            public int compareTo(IdMerger<T>.UnsortedValue unsortedValue) {
                return this.value.compareTo(unsortedValue.value);
            }
        }

        public IdMerger(l lVar) {
            this.out = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private int readIntoMap(l lVar, w wVar, IndexMap indexMap, int i, TreeMap<T, List<Integer>> treeMap, int i3) {
            int iPosition = lVar != null ? lVar.b.position() : -1;
            if (i < wVar.b) {
                Comparable comparable = read(lVar, indexMap, i);
                List arrayList = (List) treeMap.get(comparable);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    treeMap.put(comparable, arrayList);
                }
                arrayList.add(Integer.valueOf(i3));
            }
            return iPosition;
        }

        private List<IdMerger<T>.UnsortedValue> readUnsortedValues(m mVar, IndexMap indexMap) {
            w section = getSection(mVar.b);
            if (!section.a()) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            l lVarD = mVar.d(section.c);
            for (int i = 0; i < section.b; i++) {
                arrayList.add(new UnsortedValue(mVar, indexMap, read(lVarD, indexMap, 0), i, lVarD.b.position()));
            }
            return arrayList;
        }

        public abstract w getSection(x xVar);

        public final void mergeSorted() {
            w[] wVarArr = new w[DexMerger.this.dexes.length];
            l[] lVarArr = new l[DexMerger.this.dexes.length];
            int[] iArr = new int[DexMerger.this.dexes.length];
            int[] iArr2 = new int[DexMerger.this.dexes.length];
            TreeMap<T, List<Integer>> treeMap = new TreeMap<>();
            int i = 0;
            for (int i3 = 0; i3 < DexMerger.this.dexes.length; i3++) {
                w section = getSection(DexMerger.this.dexes[i3].b);
                wVarArr[i3] = section;
                l lVarD = section.a() ? DexMerger.this.dexes[i3].d(wVarArr[i3].c) : null;
                lVarArr[i3] = lVarD;
                iArr[i3] = readIntoMap(lVarD, wVarArr[i3], DexMerger.this.indexMaps[i3], iArr2[i3], treeMap, i3);
            }
            if (treeMap.isEmpty()) {
                getSection(DexMerger.this.contentsOut).c = 0;
                getSection(DexMerger.this.contentsOut).b = 0;
                return;
            }
            getSection(DexMerger.this.contentsOut).c = this.out.b.position();
            while (!treeMap.isEmpty()) {
                Map.Entry<T, List<Integer>> entryPollFirstEntry = treeMap.pollFirstEntry();
                for (Integer num : entryPollFirstEntry.getValue()) {
                    int i4 = iArr[num.intValue()];
                    IndexMap indexMap = DexMerger.this.indexMaps[num.intValue()];
                    int iIntValue = num.intValue();
                    int i5 = iArr2[iIntValue];
                    iArr2[iIntValue] = i5 + 1;
                    updateIndex(i4, indexMap, i5, i);
                    iArr[num.intValue()] = readIntoMap(lVarArr[num.intValue()], wVarArr[num.intValue()], DexMerger.this.indexMaps[num.intValue()], iArr2[num.intValue()], treeMap, num.intValue());
                }
                write(entryPollFirstEntry.getKey());
                i++;
            }
            getSection(DexMerger.this.contentsOut).b = i;
        }

        public final void mergeUnsorted() {
            int i;
            getSection(DexMerger.this.contentsOut).c = this.out.b.position();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < DexMerger.this.dexes.length; i3++) {
                arrayList.addAll(readUnsortedValues(DexMerger.this.dexes[i3], DexMerger.this.indexMaps[i3]));
            }
            if (arrayList.isEmpty()) {
                getSection(DexMerger.this.contentsOut).c = 0;
                getSection(DexMerger.this.contentsOut).b = 0;
                return;
            }
            Collections.sort(arrayList);
            int i4 = 0;
            for (int i5 = 0; i5 < arrayList.size(); i5 = i) {
                i = i5 + 1;
                UnsortedValue unsortedValue = (UnsortedValue) arrayList.get(i5);
                int i6 = i4 - 1;
                updateIndex(unsortedValue.offset, unsortedValue.indexMap, unsortedValue.index, i6);
                while (i < arrayList.size() && unsortedValue.compareTo((UnsortedValue) arrayList.get(i)) == 0) {
                    int i7 = i + 1;
                    UnsortedValue unsortedValue2 = (UnsortedValue) arrayList.get(i);
                    updateIndex(unsortedValue2.offset, unsortedValue2.indexMap, unsortedValue2.index, i6);
                    i = i7;
                }
                write(unsortedValue.value);
                i4++;
            }
            getSection(DexMerger.this.contentsOut).b = i4;
        }

        public abstract T read(l lVar, IndexMap indexMap, int i);

        public abstract void updateIndex(int i, IndexMap indexMap, int i3, int i4);

        public abstract void write(T t6);
    }

    public static class WriterSizes {
        private int annotation;
        private int annotationsDirectory;
        private int annotationsSet;
        private int annotationsSetRefList;
        private int classData;
        private int code;
        private int debugInfo;
        private int encodedArray;
        private int header;
        private int idsDefs;
        private int mapList;
        private int stringData;
        private int typeList;

        public WriterSizes(m[] mVarArr) {
            this.header = 112;
            for (m mVar : mVarArr) {
                plus(mVar.b, false);
            }
            fourByteAlign();
        }

        private static int fourByteAlign(int i) {
            return (i + 3) & (-4);
        }

        private void plus(x xVar, boolean z6) {
            this.idsDefs = (xVar.f3174g.b * 32) + (xVar.f3173f.b * 8) + (xVar.e.b * 8) + (xVar.d.b * 12) + (xVar.c.b * 4) + (xVar.b.b * 4) + this.idsDefs;
            this.mapList = (xVar.u.length * 12) + 4;
            this.typeList += fourByteAlign(xVar.f3177k.d);
            this.stringData += xVar.f3182p.d;
            this.annotationsDirectory += xVar.f3185t.d;
            this.annotationsSet += xVar.f3179m.d;
            this.annotationsSetRefList += xVar.f3178l.d;
            w wVar = xVar.q;
            w wVar2 = xVar.f3183r;
            w wVar3 = xVar.f3184s;
            w wVar4 = xVar.f3180n;
            w wVar5 = xVar.f3181o;
            if (z6) {
                this.code += wVar5.d;
                this.classData += wVar4.d;
                this.encodedArray += wVar3.d;
                this.annotation += wVar2.d;
                this.debugInfo += wVar.d;
                return;
            }
            this.code += (int) Math.ceil(((double) wVar5.d) * 1.25d);
            this.classData += (int) Math.ceil(((double) wVar4.d) * 1.67d);
            this.encodedArray = (wVar3.d * 2) + this.encodedArray;
            this.annotation += (int) Math.ceil(wVar2.d * 2);
            this.debugInfo = (wVar.d * 2) + 8 + this.debugInfo;
        }

        public int size() {
            return this.header + this.idsDefs + this.mapList + this.typeList + this.classData + this.code + this.stringData + this.debugInfo + this.encodedArray + this.annotationsDirectory + this.annotationsSet + this.annotationsSetRefList + this.annotation;
        }

        private void fourByteAlign() {
            this.header = fourByteAlign(this.header);
            this.idsDefs = fourByteAlign(this.idsDefs);
            this.mapList = fourByteAlign(this.mapList);
            this.typeList = fourByteAlign(this.typeList);
            this.classData = fourByteAlign(this.classData);
            this.code = fourByteAlign(this.code);
            this.stringData = fourByteAlign(this.stringData);
            this.debugInfo = fourByteAlign(this.debugInfo);
            this.encodedArray = fourByteAlign(this.encodedArray);
            this.annotationsDirectory = fourByteAlign(this.annotationsDirectory);
            this.annotationsSet = fourByteAlign(this.annotationsSet);
            this.annotationsSetRefList = fourByteAlign(this.annotationsSetRefList);
            this.annotation = fourByteAlign(this.annotation);
        }

        public WriterSizes(DexMerger dexMerger) {
            this.header = 112;
            this.header = dexMerger.headerOut.f();
            this.idsDefs = dexMerger.idsDefsOut.f();
            this.mapList = dexMerger.mapListOut.f();
            this.typeList = dexMerger.typeListOut.f();
            this.classData = dexMerger.classDataOut.f();
            this.code = dexMerger.codeOut.f();
            this.stringData = dexMerger.stringDataOut.f();
            this.debugInfo = dexMerger.debugInfoOut.f();
            this.encodedArray = dexMerger.encodedArrayOut.f();
            this.annotationsDirectory = dexMerger.annotationsDirectoryOut.f();
            this.annotationsSet = dexMerger.annotationSetOut.f();
            this.annotationsSetRefList = dexMerger.annotationSetRefListOut.f();
            this.annotation = dexMerger.annotationOut.f();
            fourByteAlign();
        }
    }

    public DexMerger(m[] mVarArr, CollisionPolicy collisionPolicy, DxContext dxContext) {
        this(mVarArr, collisionPolicy, dxContext, new WriterSizes(mVarArr));
    }

    private SortableType[] getSortedTypes() {
        boolean zTryAssignDepth;
        int i = this.contentsOut.c.b;
        SortableType[] sortableTypeArr = new SortableType[i];
        int i3 = 0;
        while (true) {
            m[] mVarArr = this.dexes;
            if (i3 >= mVarArr.length) {
                break;
            }
            readSortableTypes(sortableTypeArr, mVarArr[i3], this.indexMaps[i3]);
            i3++;
        }
        do {
            zTryAssignDepth = true;
            for (int i4 = 0; i4 < i; i4++) {
                SortableType sortableType = sortableTypeArr[i4];
                if (sortableType != null && !sortableType.isDepthAssigned()) {
                    zTryAssignDepth &= sortableType.tryAssignDepth(sortableTypeArr);
                }
            }
        } while (!zTryAssignDepth);
        Arrays.sort(sortableTypeArr, SortableType.NULLS_LAST_ORDER);
        int iIndexOf = Arrays.asList(sortableTypeArr).indexOf(null);
        return iIndexOf != -1 ? (SortableType[]) Arrays.copyOfRange(sortableTypeArr, 0, iIndexOf) : sortableTypeArr;
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length < 2) {
            printUsage();
            return;
        }
        m[] mVarArr = new m[strArr.length - 1];
        for (int i = 1; i < strArr.length; i++) {
            mVarArr[i - 1] = new m(new File(strArr[i]));
        }
        m mVarMerge = new DexMerger(mVarArr, CollisionPolicy.KEEP_FIRST, new DxContext()).merge();
        File file = new File(strArr[0]);
        mVarMerge.getClass();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            mVarMerge.g(fileOutputStream);
            fileOutputStream.close();
        } finally {
        }
    }

    private void mergeAnnotations() {
        new IdMerger<C0435a>(this.annotationOut) { // from class: com.android.dx.merge.DexMerger.9
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public w getSection(x xVar) {
                return xVar.f3183r;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public C0435a read(l lVar, IndexMap indexMap, int i) {
                ByteBuffer byteBuffer = lVar.b;
                byte b = byteBuffer.get();
                int iPosition = byteBuffer.position();
                new q(lVar, 29).g();
                ByteBuffer byteBuffer2 = lVar.b;
                byte[] bArr = new byte[byteBuffer2.position() - iPosition];
                byteBuffer2.position(iPosition);
                byteBuffer2.get(bArr);
                return indexMap.adjust(new C0435a(lVar.d, b, new p(bArr)));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i3, int i4) {
                indexMap.putAnnotationOffset(i, DexMerger.this.annotationOut.b.position());
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(C0435a c0435a) {
                l lVar = DexMerger.this.annotationOut;
                lVar.writeByte(c0435a.b);
                lVar.write(c0435a.c.f3162a);
            }
        }.mergeUnsorted();
    }

    private int mergeApiLevels() {
        int i = -1;
        int i3 = 0;
        while (true) {
            m[] mVarArr = this.dexes;
            if (i3 >= mVarArr.length) {
                return i;
            }
            int i4 = mVarArr[i3].b.f3186v;
            if (i < i4) {
                i = i4;
            }
            i3++;
        }
    }

    private void mergeCallSiteIds() {
        new IdMerger<C0436b>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.5
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public w getSection(x xVar) {
                return xVar.f3175h;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public C0436b read(l lVar, IndexMap indexMap, int i) {
                return indexMap.adjust(new C0436b(lVar.d, lVar.b.getInt()));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i3, int i4) {
                indexMap.callSiteIds[i3] = i4;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(C0436b c0436b) {
                DexMerger.this.idsDefsOut.writeInt(c0436b.b);
            }
        }.mergeSorted();
    }

    private void mergeClassDefs() {
        SortableType[] sortedTypes = getSortedTypes();
        this.contentsOut.f3174g.c = this.idsDefsOut.b.position();
        this.contentsOut.f3174g.b = sortedTypes.length;
        for (SortableType sortableType : sortedTypes) {
            transformClassDef(sortableType.getDex(), sortableType.getClassDef(), sortableType.getIndexMap());
        }
    }

    private m mergeDexes() {
        mergeStringIds();
        mergeTypeIds();
        mergeTypeLists();
        mergeProtoIds();
        mergeFieldIds();
        mergeMethodIds();
        mergeMethodHandles();
        mergeAnnotations();
        unionAnnotationSetsAndDirectories();
        mergeCallSiteIds();
        mergeClassDefs();
        Arrays.sort(this.contentsOut.u);
        x xVar = this.contentsOut;
        w wVar = xVar.f3172a;
        wVar.c = 0;
        wVar.b = 1;
        xVar.y = this.dexOut.f3158a.capacity();
        this.contentsOut.a();
        x xVar2 = this.contentsOut;
        l lVar = this.headerOut;
        int iMergeApiLevels = mergeApiLevels();
        xVar2.getClass();
        lVar.write(AbstractC0132a.f(iMergeApiLevels).getBytes("UTF-8"));
        lVar.writeInt(xVar2.f3187w);
        lVar.write(xVar2.x);
        lVar.writeInt(xVar2.y);
        lVar.writeInt(112);
        lVar.writeInt(305419896);
        lVar.writeInt(xVar2.f3188z);
        lVar.writeInt(xVar2.f3170A);
        lVar.writeInt(xVar2.f3176j.c);
        w wVar2 = xVar2.b;
        lVar.writeInt(wVar2.b);
        lVar.writeInt(wVar2.c);
        w wVar3 = xVar2.c;
        lVar.writeInt(wVar3.b);
        lVar.writeInt(wVar3.c);
        w wVar4 = xVar2.d;
        lVar.writeInt(wVar4.b);
        lVar.writeInt(wVar4.c);
        w wVar5 = xVar2.e;
        lVar.writeInt(wVar5.b);
        lVar.writeInt(wVar5.c);
        w wVar6 = xVar2.f3173f;
        lVar.writeInt(wVar6.b);
        lVar.writeInt(wVar6.c);
        w wVar7 = xVar2.f3174g;
        lVar.writeInt(wVar7.b);
        lVar.writeInt(wVar7.c);
        lVar.writeInt(xVar2.f3171B);
        lVar.writeInt(xVar2.C);
        x xVar3 = this.contentsOut;
        l lVar2 = this.mapListOut;
        w[] wVarArr = xVar3.u;
        int i = 0;
        for (w wVar8 : wVarArr) {
            if (wVar8.a()) {
                i++;
            }
        }
        lVar2.writeInt(i);
        for (w wVar9 : wVarArr) {
            if (wVar9.a()) {
                lVar2.g(wVar9.f3169a);
                lVar2.g((short) 0);
                lVar2.writeInt(wVar9.b);
                lVar2.writeInt(wVar9.c);
            }
        }
        m mVar = this.dexOut;
        l lVarD = mVar.d(12);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[8192];
            ByteBuffer byteBufferDuplicate = mVar.f3158a.duplicate();
            byteBufferDuplicate.limit(byteBufferDuplicate.capacity());
            byteBufferDuplicate.position(32);
            while (byteBufferDuplicate.hasRemaining()) {
                int iMin = Math.min(8192, byteBufferDuplicate.remaining());
                byteBufferDuplicate.get(bArr, 0, iMin);
                messageDigest.update(bArr, 0, iMin);
            }
            lVarD.write(messageDigest.digest());
            l lVarD2 = mVar.d(8);
            Adler32 adler32 = new Adler32();
            byte[] bArr2 = new byte[8192];
            ByteBuffer byteBufferDuplicate2 = mVar.f3158a.duplicate();
            byteBufferDuplicate2.limit(byteBufferDuplicate2.capacity());
            byteBufferDuplicate2.position(12);
            while (byteBufferDuplicate2.hasRemaining()) {
                int iMin2 = Math.min(8192, byteBufferDuplicate2.remaining());
                byteBufferDuplicate2.get(bArr2, 0, iMin2);
                adler32.update(bArr2, 0, iMin2);
            }
            lVarD2.writeInt((int) adler32.getValue());
            return this.dexOut;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private void mergeFieldIds() {
        new IdMerger<r>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.7
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public w getSection(x xVar) {
                return xVar.e;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public r read(l lVar, IndexMap indexMap, int i) {
                return indexMap.adjust(new r(lVar.d, lVar.e(), lVar.e(), lVar.b.getInt()));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i3, int i4) {
                if (i4 < 0 || i4 > 65535) {
                    throw new o(b.c(i4, "field ID not in [0, 0xffff]: "), null);
                }
                indexMap.fieldIds[i3] = (short) i4;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(r rVar) {
                l lVar = DexMerger.this.idsDefsOut;
                lVar.j(rVar.b);
                lVar.j(rVar.c);
                lVar.writeInt(rVar.d);
            }
        }.mergeSorted();
    }

    private void mergeMethodHandles() {
        new IdMerger<t>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.6
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public w getSection(x xVar) {
                return xVar.i;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public t read(l lVar, IndexMap indexMap, int i) {
                int iE = lVar.e();
                for (int i3 : s.d(9)) {
                    if (s.b(i3) == iE) {
                        return indexMap.adjust(new t(lVar.d, i3, lVar.e(), lVar.e(), lVar.e()));
                    }
                }
                throw new IllegalArgumentException(String.valueOf(iE));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i3, int i4) {
                indexMap.methodHandleIds.put(Integer.valueOf(i3), Integer.valueOf(indexMap.methodHandleIds.size()));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(t tVar) {
                l lVar = DexMerger.this.idsDefsOut;
                lVar.j(s.b(tVar.b));
                lVar.j(tVar.c);
                lVar.j(tVar.d);
                lVar.j(tVar.e);
            }
        }.mergeUnsorted();
    }

    private void mergeMethodIds() {
        new IdMerger<u>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.8
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public w getSection(x xVar) {
                return xVar.f3173f;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public u read(l lVar, IndexMap indexMap, int i) {
                return indexMap.adjust(new u(lVar.d, lVar.e(), lVar.e(), lVar.b.getInt()));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i3, int i4) {
                if (i4 < 0 || i4 > 65535) {
                    throw new o(b.c(i4, "method ID not in [0, 0xffff]: "), null);
                }
                indexMap.methodIds[i3] = (short) i4;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(u uVar) {
                l lVar = DexMerger.this.idsDefsOut;
                lVar.j(uVar.b);
                lVar.j(uVar.c);
                lVar.writeInt(uVar.d);
            }
        }.mergeSorted();
    }

    private void mergeProtoIds() {
        new IdMerger<v>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.4
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public w getSection(x xVar) {
                return xVar.d;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public v read(l lVar, IndexMap indexMap, int i) {
                ByteBuffer byteBuffer = lVar.b;
                return indexMap.adjust(new v(lVar.d, byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt()));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i3, int i4) {
                if (i4 < 0 || i4 > 65535) {
                    throw new o(b.c(i4, "proto ID not in [0, 0xffff]: "), null);
                }
                indexMap.protoIds[i3] = (short) i4;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(v vVar) {
                l lVar = DexMerger.this.idsDefsOut;
                lVar.writeInt(vVar.b);
                lVar.writeInt(vVar.c);
                lVar.writeInt(vVar.d);
            }
        }.mergeSorted();
    }

    private void mergeStringIds() {
        new IdMerger<String>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.1
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public w getSection(x xVar) {
                return xVar.b;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i3, int i4) {
                indexMap.stringIds[i3] = i4;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public String read(l lVar, IndexMap indexMap, int i) {
                return lVar.c();
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(String str) {
                DexMerger.this.contentsOut.f3182p.b++;
                DexMerger.this.idsDefsOut.writeInt(DexMerger.this.stringDataOut.b.position());
                l lVar = DexMerger.this.stringDataOut;
                lVar.getClass();
                try {
                    lVar.i(str.length());
                    lVar.write(k.y(str));
                    lVar.writeByte(0);
                } catch (UTFDataFormatException unused) {
                    throw new AssertionError();
                }
            }
        }.mergeSorted();
    }

    private void mergeTypeIds() {
        new IdMerger<Integer>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.2
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public w getSection(x xVar) {
                return xVar.c;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public Integer read(l lVar, IndexMap indexMap, int i) {
                return Integer.valueOf(indexMap.adjustString(lVar.b.getInt()));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i3, int i4) {
                if (i4 < 0 || i4 > 65535) {
                    throw new o(b.c(i4, "type ID not in [0, 0xffff]: "), null);
                }
                indexMap.typeIds[i3] = (short) i4;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(Integer num) {
                DexMerger.this.idsDefsOut.writeInt(num.intValue());
            }
        }.mergeSorted();
    }

    private void mergeTypeLists() {
        new IdMerger<y>(this.typeListOut) { // from class: com.android.dx.merge.DexMerger.3
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public w getSection(x xVar) {
                return xVar.f3177k;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i3, int i4) {
                indexMap.putTypeListOffset(i, DexMerger.this.typeListOut.b.position());
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public y read(l lVar, IndexMap indexMap, int i) {
                return indexMap.adjustTypeList(lVar.d());
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(y yVar) {
                l lVar = DexMerger.this.typeListOut;
                lVar.getClass();
                short[] sArr = yVar.b;
                lVar.writeInt(sArr.length);
                for (short s3 : sArr) {
                    lVar.g(s3);
                }
                while (true) {
                    ByteBuffer byteBuffer = lVar.b;
                    if ((byteBuffer.position() & 3) == 0) {
                        return;
                    } else {
                        byteBuffer.put(DexMerger.DBG_END_SEQUENCE);
                    }
                }
            }
        }.mergeUnsorted();
    }

    private static void printUsage() {
        System.out.println("Usage: DexMerger <out.dex> <a.dex> <b.dex> ...");
        System.out.println();
        System.out.println("If a class is defined in several dex, the class found in the first dex will be used.");
    }

    private void readSortableTypes(SortableType[] sortableTypeArr, m mVar, IndexMap indexMap) {
        mVar.getClass();
        Iterator it = !mVar.b.f3174g.a() ? Collections.EMPTY_SET.iterator() : new j(mVar);
        while (it.hasNext()) {
            f fVar = (f) it.next();
            SortableType sortableTypeAdjust = indexMap.adjust(new SortableType(mVar, indexMap, fVar));
            int typeIndex = sortableTypeAdjust.getTypeIndex();
            if (sortableTypeArr[typeIndex] == null) {
                sortableTypeArr[typeIndex] = sortableTypeAdjust;
            } else if (this.collisionPolicy != CollisionPolicy.KEEP_FIRST) {
                throw new n("Multiple dex files define ".concat((String) mVar.f3159f.get(fVar.c)), null);
            }
        }
    }

    private void transformAnnotationDirectories(m mVar, IndexMap indexMap) {
        w wVar = mVar.b.f3185t;
        if (wVar.a()) {
            l lVarD = mVar.d(wVar.c);
            for (int i = 0; i < wVar.b; i++) {
                transformAnnotationDirectory(lVarD, indexMap);
            }
        }
    }

    private void transformAnnotationDirectory(l lVar, IndexMap indexMap) {
        this.contentsOut.f3185t.b++;
        this.annotationsDirectoryOut.a();
        indexMap.putAnnotationDirectoryOffset(lVar.b.position(), this.annotationsDirectoryOut.b.position());
        ByteBuffer byteBuffer = lVar.b;
        this.annotationsDirectoryOut.writeInt(indexMap.adjustAnnotationSet(byteBuffer.getInt()));
        int i = byteBuffer.getInt();
        this.annotationsDirectoryOut.writeInt(i);
        int i3 = byteBuffer.getInt();
        this.annotationsDirectoryOut.writeInt(i3);
        int i4 = byteBuffer.getInt();
        this.annotationsDirectoryOut.writeInt(i4);
        for (int i5 = 0; i5 < i; i5++) {
            this.annotationsDirectoryOut.writeInt(indexMap.adjustField(byteBuffer.getInt()));
            this.annotationsDirectoryOut.writeInt(indexMap.adjustAnnotationSet(byteBuffer.getInt()));
        }
        for (int i6 = 0; i6 < i3; i6++) {
            this.annotationsDirectoryOut.writeInt(indexMap.adjustMethod(byteBuffer.getInt()));
            this.annotationsDirectoryOut.writeInt(indexMap.adjustAnnotationSet(byteBuffer.getInt()));
        }
        for (int i7 = 0; i7 < i4; i7++) {
            this.annotationsDirectoryOut.writeInt(indexMap.adjustMethod(byteBuffer.getInt()));
            this.annotationsDirectoryOut.writeInt(indexMap.adjustAnnotationSetRefList(byteBuffer.getInt()));
        }
    }

    private void transformAnnotationSet(IndexMap indexMap, l lVar) {
        this.contentsOut.f3179m.b++;
        this.annotationSetOut.a();
        indexMap.putAnnotationSetOffset(lVar.b.position(), this.annotationSetOut.b.position());
        ByteBuffer byteBuffer = lVar.b;
        int i = byteBuffer.getInt();
        this.annotationSetOut.writeInt(i);
        for (int i3 = 0; i3 < i; i3++) {
            this.annotationSetOut.writeInt(indexMap.adjustAnnotation(byteBuffer.getInt()));
        }
    }

    private void transformAnnotationSetRefList(IndexMap indexMap, l lVar) {
        this.contentsOut.f3178l.b++;
        this.annotationSetRefListOut.a();
        indexMap.putAnnotationSetRefListOffset(lVar.b.position(), this.annotationSetRefListOut.b.position());
        ByteBuffer byteBuffer = lVar.b;
        int i = byteBuffer.getInt();
        this.annotationSetRefListOut.writeInt(i);
        for (int i3 = 0; i3 < i; i3++) {
            this.annotationSetRefListOut.writeInt(indexMap.adjustAnnotationSet(byteBuffer.getInt()));
        }
    }

    private void transformAnnotationSetRefLists(m mVar, IndexMap indexMap) {
        w wVar = mVar.b.f3178l;
        if (wVar.a()) {
            l lVarD = mVar.d(wVar.c);
            for (int i = 0; i < wVar.b; i++) {
                transformAnnotationSetRefList(indexMap, lVarD);
            }
        }
    }

    private void transformAnnotationSets(m mVar, IndexMap indexMap) {
        w wVar = mVar.b.f3179m;
        if (wVar.a()) {
            l lVarD = mVar.d(wVar.c);
            for (int i = 0; i < wVar.b; i++) {
                transformAnnotationSet(indexMap, lVarD);
            }
        }
    }

    private int[] transformCatchHandlers(IndexMap indexMap, g[] gVarArr) {
        int iPosition = this.codeOut.b.position();
        this.codeOut.i(gVarArr.length);
        int[] iArr = new int[gVarArr.length];
        for (int i = 0; i < gVarArr.length; i++) {
            iArr[i] = this.codeOut.b.position() - iPosition;
            transformEncodedCatchHandler(gVarArr[i], indexMap);
        }
        return iArr;
    }

    private void transformClassData(m mVar, e eVar, IndexMap indexMap) {
        this.contentsOut.f3180n.b++;
        C0437c[] c0437cArr = eVar.f3143a;
        this.classDataOut.i(c0437cArr.length);
        l lVar = this.classDataOut;
        C0437c[] c0437cArr2 = eVar.b;
        lVar.i(c0437cArr2.length);
        l lVar2 = this.classDataOut;
        C0438d[] c0438dArr = eVar.c;
        lVar2.i(c0438dArr.length);
        l lVar3 = this.classDataOut;
        C0438d[] c0438dArr2 = eVar.d;
        lVar3.i(c0438dArr2.length);
        transformFields(indexMap, c0437cArr);
        transformFields(indexMap, c0437cArr2);
        transformMethods(mVar, indexMap, c0438dArr);
        transformMethods(mVar, indexMap, c0438dArr2);
    }

    private void transformClassDef(m mVar, f fVar, IndexMap indexMap) {
        this.idsDefsOut.a();
        this.idsDefsOut.writeInt(fVar.c);
        this.idsDefsOut.writeInt(fVar.d);
        this.idsDefsOut.writeInt(fVar.e);
        this.idsDefsOut.writeInt(fVar.f3145f);
        this.idsDefsOut.writeInt(indexMap.adjustString(fVar.f3146g));
        this.idsDefsOut.writeInt(indexMap.adjustAnnotationDirectory(fVar.f3147h));
        if (fVar.i == 0) {
            this.idsDefsOut.writeInt(0);
        } else {
            this.idsDefsOut.writeInt(this.classDataOut.b.position());
            transformClassData(mVar, mVar.e(fVar), indexMap);
        }
        this.idsDefsOut.writeInt(indexMap.adjustEncodedArray(fVar.f3148j));
    }

    private void transformCode(m mVar, i iVar, IndexMap indexMap) {
        this.contentsOut.f3181o.b++;
        this.codeOut.a();
        this.codeOut.j(iVar.f3151a);
        this.codeOut.j(iVar.b);
        this.codeOut.j(iVar.c);
        l lVar = this.codeOut;
        h[] hVarArr = iVar.f3152f;
        lVar.j(hVarArr.length);
        int i = iVar.d;
        if (i != 0) {
            this.codeOut.writeInt(this.debugInfoOut.b.position());
            transformDebugInfoItem(mVar.d(i), indexMap);
        } else {
            this.codeOut.writeInt(0);
        }
        short[] sArrTransform = this.instructionTransformer.transform(indexMap, iVar.e);
        this.codeOut.writeInt(sArrTransform.length);
        l lVar2 = this.codeOut;
        lVar2.getClass();
        for (short s3 : sArrTransform) {
            lVar2.g(s3);
        }
        if (hVarArr.length > 0) {
            if (sArrTransform.length % 2 == 1) {
                this.codeOut.g((short) 0);
            }
            l lVarD = this.dexOut.d(this.codeOut.b.position());
            l lVar3 = this.codeOut;
            int length = hVarArr.length * 8;
            if (length < 0) {
                lVar3.getClass();
                throw new IllegalArgumentException();
            }
            ByteBuffer byteBuffer = lVar3.b;
            byteBuffer.position(byteBuffer.position() + length);
            transformTries(lVarD, hVarArr, transformCatchHandlers(indexMap, iVar.f3153g));
        }
    }

    private void transformDebugInfoItem(l lVar, IndexMap indexMap) {
        this.contentsOut.q.b++;
        lVar.getClass();
        this.debugInfoOut.i(C5.f.Z(lVar));
        int iZ = C5.f.Z(lVar);
        this.debugInfoOut.i(iZ);
        for (int i = 0; i < iZ; i++) {
            this.debugInfoOut.i(indexMap.adjustString(C5.f.Z(lVar) - 1) + 1);
        }
        while (true) {
            byte b = lVar.b.get();
            this.debugInfoOut.writeByte(b);
            if (b != 9) {
                switch (b) {
                    case 0:
                        return;
                    case 1:
                        this.debugInfoOut.i(C5.f.Z(lVar));
                        break;
                    case 2:
                        this.debugInfoOut.h(C5.f.Y(lVar));
                        break;
                    case 3:
                    case 4:
                        this.debugInfoOut.i(C5.f.Z(lVar));
                        this.debugInfoOut.i(indexMap.adjustString(C5.f.Z(lVar) - 1) + 1);
                        this.debugInfoOut.i(indexMap.adjustType(C5.f.Z(lVar) - 1) + 1);
                        if (b == 4) {
                            this.debugInfoOut.i(indexMap.adjustString(C5.f.Z(lVar) - 1) + 1);
                        }
                        break;
                    case 5:
                    case 6:
                        this.debugInfoOut.i(C5.f.Z(lVar));
                        break;
                }
            } else {
                this.debugInfoOut.i(indexMap.adjustString(C5.f.Z(lVar) - 1) + 1);
            }
        }
    }

    private void transformEncodedCatchHandler(g gVar, IndexMap indexMap) {
        int i = gVar.c;
        int[] iArr = gVar.f3149a;
        if (i != -1) {
            this.codeOut.h(-iArr.length);
        } else {
            this.codeOut.h(iArr.length);
        }
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.codeOut.i(indexMap.adjustType(iArr[i3]));
            this.codeOut.i(gVar.b[i3]);
        }
        if (i != -1) {
            this.codeOut.i(i);
        }
    }

    private void transformFields(IndexMap indexMap, C0437c[] c0437cArr) {
        int length = c0437cArr.length;
        int i = 0;
        int i3 = 0;
        while (i < length) {
            C0437c c0437c = c0437cArr[i];
            int iAdjustField = indexMap.adjustField(c0437c.f3141a);
            this.classDataOut.i(iAdjustField - i3);
            this.classDataOut.i(c0437c.b);
            i++;
            i3 = iAdjustField;
        }
    }

    private void transformMethods(m mVar, IndexMap indexMap, C0438d[] c0438dArr) {
        int length = c0438dArr.length;
        int i = 0;
        int i3 = 0;
        while (i < length) {
            C0438d c0438d = c0438dArr[i];
            int iAdjustMethod = indexMap.adjustMethod(c0438d.f3142a);
            this.classDataOut.i(iAdjustMethod - i3);
            this.classDataOut.i(c0438d.b);
            if (c0438d.c == 0) {
                this.classDataOut.i(0);
            } else {
                l lVar = this.codeOut;
                while (true) {
                    ByteBuffer byteBuffer = lVar.b;
                    if ((byteBuffer.position() & 3) == 0) {
                        break;
                    } else {
                        byteBuffer.put(DBG_END_SEQUENCE);
                    }
                }
                this.classDataOut.i(this.codeOut.b.position());
                transformCode(mVar, mVar.f(c0438d), indexMap);
            }
            i++;
            i3 = iAdjustMethod;
        }
    }

    private void transformStaticValues(m mVar, IndexMap indexMap) {
        w wVar = mVar.b.f3184s;
        if (wVar.a()) {
            l lVarD = mVar.d(wVar.c);
            for (int i = 0; i < wVar.b; i++) {
                transformStaticValues(lVarD, indexMap);
            }
        }
    }

    private void transformTries(l lVar, h[] hVarArr, int[] iArr) {
        for (h hVar : hVarArr) {
            lVar.writeInt(hVar.f3150a);
            lVar.j(hVar.b);
            lVar.j(iArr[hVar.c]);
        }
    }

    private void unionAnnotationSetsAndDirectories() {
        int i = 0;
        int i3 = 0;
        while (true) {
            m[] mVarArr = this.dexes;
            if (i3 >= mVarArr.length) {
                break;
            }
            transformAnnotationSets(mVarArr[i3], this.indexMaps[i3]);
            i3++;
        }
        int i4 = 0;
        while (true) {
            m[] mVarArr2 = this.dexes;
            if (i4 >= mVarArr2.length) {
                break;
            }
            transformAnnotationSetRefLists(mVarArr2[i4], this.indexMaps[i4]);
            i4++;
        }
        int i5 = 0;
        while (true) {
            m[] mVarArr3 = this.dexes;
            if (i5 >= mVarArr3.length) {
                break;
            }
            transformAnnotationDirectories(mVarArr3[i5], this.indexMaps[i5]);
            i5++;
        }
        while (true) {
            m[] mVarArr4 = this.dexes;
            if (i >= mVarArr4.length) {
                return;
            }
            transformStaticValues(mVarArr4[i], this.indexMaps[i]);
            i++;
        }
    }

    public m merge() {
        m[] mVarArr = this.dexes;
        int i = 0;
        if (mVarArr.length == 1) {
            return mVarArr[0];
        }
        if (mVarArr.length == 0) {
            return null;
        }
        long jNanoTime = System.nanoTime();
        m mVarMergeDexes = mergeDexes();
        WriterSizes writerSizes = new WriterSizes(this);
        int size = this.writerSizes.size() - writerSizes.size();
        if (size > this.compactWasteThreshold) {
            mVarMergeDexes = new DexMerger(new m[]{this.dexOut, new m(0)}, CollisionPolicy.FAIL, this.context, writerSizes).mergeDexes();
            this.context.out.printf("Result compacted from %.1fKiB to %.1fKiB to save %.1fKiB%n", Float.valueOf(this.dexOut.f3158a.capacity() / 1024.0f), Float.valueOf(mVarMergeDexes.f3158a.capacity() / 1024.0f), Float.valueOf(size / 1024.0f));
        }
        long jNanoTime2 = System.nanoTime() - jNanoTime;
        while (i < this.dexes.length) {
            int i3 = i + 1;
            this.context.out.printf("Merged dex #%d (%d defs/%.1fKiB)%n", Integer.valueOf(i3), Integer.valueOf(this.dexes[i].b.f3174g.b), Float.valueOf(this.dexes[i].f3158a.capacity() / 1024.0f));
            i = i3;
        }
        this.context.out.printf("Result is %d defs/%.1fKiB. Took %.1fs%n", Integer.valueOf(mVarMergeDexes.b.f3174g.b), Float.valueOf(mVarMergeDexes.f3158a.capacity() / 1024.0f), Float.valueOf(jNanoTime2 / 1.0E9f));
        return mVarMergeDexes;
    }

    public void setCompactWasteThreshold(int i) {
        this.compactWasteThreshold = i;
    }

    private DexMerger(m[] mVarArr, CollisionPolicy collisionPolicy, DxContext dxContext, WriterSizes writerSizes) {
        this.compactWasteThreshold = 1048576;
        this.dexes = mVarArr;
        this.collisionPolicy = collisionPolicy;
        this.context = dxContext;
        this.writerSizes = writerSizes;
        this.dexOut = new m(writerSizes.size());
        this.indexMaps = new IndexMap[mVarArr.length];
        for (int i = 0; i < mVarArr.length; i++) {
            this.indexMaps[i] = new IndexMap(this.dexOut, mVarArr[i].b);
        }
        this.instructionTransformer = new InstructionTransformer();
        this.headerOut = this.dexOut.a(writerSizes.header, "header");
        this.idsDefsOut = this.dexOut.a(writerSizes.idsDefs, "ids defs");
        m mVar = this.dexOut;
        x xVar = mVar.b;
        this.contentsOut = xVar;
        int i3 = mVar.c;
        xVar.C = i3;
        w wVar = xVar.f3176j;
        wVar.c = i3;
        wVar.b = 1;
        this.mapListOut = mVar.a(writerSizes.mapList, "map list");
        w wVar2 = xVar.f3177k;
        m mVar2 = this.dexOut;
        wVar2.c = mVar2.c;
        this.typeListOut = mVar2.a(writerSizes.typeList, "type list");
        w wVar3 = xVar.f3178l;
        m mVar3 = this.dexOut;
        wVar3.c = mVar3.c;
        this.annotationSetRefListOut = mVar3.a(writerSizes.annotationsSetRefList, "annotation set ref list");
        w wVar4 = xVar.f3179m;
        m mVar4 = this.dexOut;
        wVar4.c = mVar4.c;
        this.annotationSetOut = mVar4.a(writerSizes.annotationsSet, "annotation sets");
        w wVar5 = xVar.f3180n;
        m mVar5 = this.dexOut;
        wVar5.c = mVar5.c;
        this.classDataOut = mVar5.a(writerSizes.classData, "class data");
        w wVar6 = xVar.f3181o;
        m mVar6 = this.dexOut;
        wVar6.c = mVar6.c;
        this.codeOut = mVar6.a(writerSizes.code, "code");
        w wVar7 = xVar.f3182p;
        m mVar7 = this.dexOut;
        wVar7.c = mVar7.c;
        this.stringDataOut = mVar7.a(writerSizes.stringData, "string data");
        w wVar8 = xVar.q;
        m mVar8 = this.dexOut;
        wVar8.c = mVar8.c;
        this.debugInfoOut = mVar8.a(writerSizes.debugInfo, "debug info");
        w wVar9 = xVar.f3183r;
        m mVar9 = this.dexOut;
        wVar9.c = mVar9.c;
        this.annotationOut = mVar9.a(writerSizes.annotation, "annotation");
        w wVar10 = xVar.f3184s;
        m mVar10 = this.dexOut;
        wVar10.c = mVar10.c;
        this.encodedArrayOut = mVar10.a(writerSizes.encodedArray, "encoded array");
        w wVar11 = xVar.f3185t;
        m mVar11 = this.dexOut;
        wVar11.c = mVar11.c;
        this.annotationsDirectoryOut = mVar11.a(writerSizes.annotationsDirectory, "annotations directory");
        xVar.f3171B = this.dexOut.c - xVar.C;
    }

    private void transformStaticValues(l lVar, IndexMap indexMap) {
        this.contentsOut.f3184s.b++;
        indexMap.putEncodedArrayValueOffset(lVar.b.position(), this.encodedArrayOut.b.position());
        ByteBuffer byteBuffer = lVar.b;
        int iPosition = byteBuffer.position();
        new q(lVar, 28).g();
        byte[] bArr = new byte[byteBuffer.position() - iPosition];
        byteBuffer.position(iPosition);
        byteBuffer.get(bArr);
        this.encodedArrayOut.write(indexMap.adjustEncodedArray(new p(bArr)).f3162a);
    }
}
