package com.android.dx.dex.file;

import androidx.constraintlayout.core.motion.a;
import com.android.dx.rop.annotation.AnnotationsList;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import com.android.dx.util.ToHuman;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ParameterAnnotationStruct implements ToHuman, Comparable<ParameterAnnotationStruct> {
    private final UniformListItem<AnnotationSetRefItem> annotationsItem;
    private final AnnotationsList annotationsList;
    private final CstMethodRef method;

    public ParameterAnnotationStruct(CstMethodRef cstMethodRef, AnnotationsList annotationsList, DexFile dexFile) {
        if (cstMethodRef == null) {
            throw new NullPointerException("method == null");
        }
        if (annotationsList == null) {
            throw new NullPointerException("annotationsList == null");
        }
        this.method = cstMethodRef;
        this.annotationsList = annotationsList;
        int size = annotationsList.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new AnnotationSetRefItem(new AnnotationSetItem(annotationsList.get(i), dexFile)));
        }
        this.annotationsItem = new UniformListItem<>(ItemType.TYPE_ANNOTATION_SET_REF_LIST, arrayList);
    }

    public void addContents(DexFile dexFile) {
        MethodIdsSection methodIds = dexFile.getMethodIds();
        MixedItemSection wordData = dexFile.getWordData();
        methodIds.intern(this.method);
        wordData.add(this.annotationsItem);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParameterAnnotationStruct) {
            return this.method.equals(((ParameterAnnotationStruct) obj).method);
        }
        return false;
    }

    public AnnotationsList getAnnotationsList() {
        return this.annotationsList;
    }

    public CstMethodRef getMethod() {
        return this.method;
    }

    public int hashCode() {
        return this.method.hashCode();
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.method.toHuman());
        sb.append(": ");
        boolean z6 = true;
        for (T t6 : this.annotationsItem.getItems()) {
            if (z6) {
                z6 = false;
            } else {
                sb.append(", ");
            }
            sb.append(t6.toHuman());
        }
        return sb.toString();
    }

    public void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        int iIndexOf = dexFile.getMethodIds().indexOf(this.method);
        int absoluteOffset = this.annotationsItem.getAbsoluteOffset();
        if (annotatedOutput.annotates()) {
            annotatedOutput.annotate(0, "    " + this.method.toHuman());
            annotatedOutput.annotate(4, "      method_idx:      " + Hex.u4(iIndexOf));
            a.t(absoluteOffset, new StringBuilder("      annotations_off: "), annotatedOutput, 4);
        }
        annotatedOutput.writeInt(iIndexOf);
        annotatedOutput.writeInt(absoluteOffset);
    }

    @Override // java.lang.Comparable
    public int compareTo(ParameterAnnotationStruct parameterAnnotationStruct) {
        return this.method.compareTo((Constant) parameterAnnotationStruct.method);
    }
}
