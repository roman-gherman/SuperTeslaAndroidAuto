package com.android.dx.merge;

import B2.b;
import f.f;
import f.m;
import f.n;
import f.y;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class SortableType {
    public static final Comparator<SortableType> NULLS_LAST_ORDER = new Comparator<SortableType>() { // from class: com.android.dx.merge.SortableType.1
        @Override // java.util.Comparator
        public int compare(SortableType sortableType, SortableType sortableType2) {
            int typeIndex;
            int typeIndex2;
            if (sortableType == sortableType2) {
                return 0;
            }
            if (sortableType2 == null) {
                return -1;
            }
            if (sortableType == null) {
                return 1;
            }
            if (sortableType.depth != sortableType2.depth) {
                typeIndex = sortableType.depth;
                typeIndex2 = sortableType2.depth;
            } else {
                typeIndex = sortableType.getTypeIndex();
                typeIndex2 = sortableType2.getTypeIndex();
            }
            return typeIndex - typeIndex2;
        }
    };
    private final f classDef;
    private int depth = -1;
    private final m dex;
    private final IndexMap indexMap;

    public SortableType(m mVar, IndexMap indexMap, f fVar) {
        this.dex = mVar;
        this.indexMap = indexMap;
        this.classDef = fVar;
    }

    public f getClassDef() {
        return this.classDef;
    }

    public m getDex() {
        return this.dex;
    }

    public IndexMap getIndexMap() {
        return this.indexMap;
    }

    public int getTypeIndex() {
        return this.classDef.c;
    }

    public boolean isDepthAssigned() {
        return this.depth != -1;
    }

    public boolean tryAssignDepth(SortableType[] sortableTypeArr) {
        int iMax;
        y yVarD;
        f fVar = this.classDef;
        int i = fVar.e;
        if (i == -1) {
            iMax = 0;
        } else {
            if (i == fVar.c) {
                throw new n(b.g(new StringBuilder("Class with type index "), " extends itself", this.classDef.c), null);
            }
            SortableType sortableType = sortableTypeArr[i];
            if (sortableType != null) {
                iMax = sortableType.depth;
                if (iMax != -1) {
                }
                return false;
            }
            iMax = 1;
        }
        m mVar = fVar.f3144a;
        int i3 = fVar.f3145f;
        if (i3 == 0) {
            mVar.getClass();
            yVarD = y.c;
        } else {
            yVarD = mVar.d(i3).d();
        }
        for (short s3 : yVarD.b) {
            SortableType sortableType2 = sortableTypeArr[s3];
            if (sortableType2 == null) {
                iMax = Math.max(iMax, 1);
            } else {
                int i4 = sortableType2.depth;
                if (i4 == -1) {
                    return false;
                }
                iMax = Math.max(iMax, i4);
            }
        }
        this.depth = iMax + 1;
        return true;
    }
}
