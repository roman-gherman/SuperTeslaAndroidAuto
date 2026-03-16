package com.android.dx.dex.file;

import B2.b;
import com.android.dx.rop.annotation.Annotation;
import com.android.dx.rop.annotation.AnnotationVisibility;
import com.android.dx.rop.annotation.NameValuePair;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstString;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.ByteArrayAnnotatedOutput;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class AnnotationItem extends OffsettedItem {
    private static final int ALIGNMENT = 1;
    private static final TypeIdSorter TYPE_ID_SORTER = new TypeIdSorter(null);
    private static final int VISIBILITY_BUILD = 0;
    private static final int VISIBILITY_RUNTIME = 1;
    private static final int VISIBILITY_SYSTEM = 2;
    private final Annotation annotation;
    private byte[] encodedForm;
    private TypeIdItem type;

    /* JADX INFO: renamed from: com.android.dx.dex.file.AnnotationItem$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$dx$rop$annotation$AnnotationVisibility;

        static {
            int[] iArr = new int[AnnotationVisibility.values().length];
            $SwitchMap$com$android$dx$rop$annotation$AnnotationVisibility = iArr;
            try {
                iArr[AnnotationVisibility.BUILD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$dx$rop$annotation$AnnotationVisibility[AnnotationVisibility.RUNTIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$android$dx$rop$annotation$AnnotationVisibility[AnnotationVisibility.SYSTEM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class TypeIdSorter implements Comparator<AnnotationItem> {
        private TypeIdSorter() {
        }

        public /* synthetic */ TypeIdSorter(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(AnnotationItem annotationItem, AnnotationItem annotationItem2) {
            int index = annotationItem.type.getIndex();
            int index2 = annotationItem2.type.getIndex();
            if (index < index2) {
                return -1;
            }
            return index > index2 ? 1 : 0;
        }
    }

    public AnnotationItem(Annotation annotation, DexFile dexFile) {
        super(1, -1);
        if (annotation == null) {
            throw new NullPointerException("annotation == null");
        }
        this.annotation = annotation;
        this.type = null;
        this.encodedForm = null;
        addContents(dexFile);
    }

    public static void sortByTypeIdIndex(AnnotationItem[] annotationItemArr) {
        Arrays.sort(annotationItemArr, TYPE_ID_SORTER);
    }

    @Override // com.android.dx.dex.file.Item
    public void addContents(DexFile dexFile) {
        this.type = dexFile.getTypeIds().intern(this.annotation.getType());
        ValueEncoder.addContents(dexFile, this.annotation);
    }

    public void annotateTo(AnnotatedOutput annotatedOutput, String str) {
        StringBuilder sbL = b.l(str, "visibility: ");
        sbL.append(this.annotation.getVisibility().toHuman());
        annotatedOutput.annotate(0, sbL.toString());
        annotatedOutput.annotate(0, str + "type: " + this.annotation.getType().toHuman());
        for (NameValuePair nameValuePair : this.annotation.getNameValuePairs()) {
            CstString name = nameValuePair.getName();
            Constant value = nameValuePair.getValue();
            StringBuilder sbK = b.k(str);
            sbK.append(name.toHuman());
            sbK.append(": ");
            sbK.append(ValueEncoder.constantToHuman(value));
            annotatedOutput.annotate(0, sbK.toString());
        }
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    public int compareTo0(OffsettedItem offsettedItem) {
        return this.annotation.compareTo(((AnnotationItem) offsettedItem).annotation);
    }

    public int hashCode() {
        return this.annotation.hashCode();
    }

    @Override // com.android.dx.dex.file.Item
    public ItemType itemType() {
        return ItemType.TYPE_ANNOTATION_ITEM;
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    public void place0(Section section, int i) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput();
        new ValueEncoder(section.getFile(), byteArrayAnnotatedOutput).writeAnnotation(this.annotation, false);
        byte[] byteArray = byteArrayAnnotatedOutput.toByteArray();
        this.encodedForm = byteArray;
        setWriteSize(byteArray.length + 1);
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    public String toHuman() {
        return this.annotation.toHuman();
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        boolean zAnnotates = annotatedOutput.annotates();
        AnnotationVisibility visibility = this.annotation.getVisibility();
        if (zAnnotates) {
            annotatedOutput.annotate(0, offsetString() + " annotation");
            StringBuilder sb = new StringBuilder("  visibility: VISBILITY_");
            sb.append(visibility);
            annotatedOutput.annotate(1, sb.toString());
        }
        int i = AnonymousClass1.$SwitchMap$com$android$dx$rop$annotation$AnnotationVisibility[visibility.ordinal()];
        if (i == 1) {
            annotatedOutput.writeByte(0);
        } else if (i == 2) {
            annotatedOutput.writeByte(1);
        } else {
            if (i != 3) {
                throw new RuntimeException("shouldn't happen");
            }
            annotatedOutput.writeByte(2);
        }
        if (zAnnotates) {
            new ValueEncoder(dexFile, annotatedOutput).writeAnnotation(this.annotation, true);
        } else {
            annotatedOutput.write(this.encodedForm);
        }
    }
}
