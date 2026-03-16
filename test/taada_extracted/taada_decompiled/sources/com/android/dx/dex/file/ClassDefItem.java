package com.android.dx.dex.file;

import androidx.constraintlayout.core.motion.a;
import com.android.dx.rop.annotation.Annotations;
import com.android.dx.rop.annotation.AnnotationsList;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstArray;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import com.android.dx.util.Writers;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ClassDefItem extends IndexedItem {
    private final int accessFlags;
    private AnnotationsDirectoryItem annotationsDirectory;
    private final ClassDataItem classData;
    private TypeListItem interfaces;
    private final CstString sourceFile;
    private EncodedArrayItem staticValuesItem;
    private final CstType superclass;
    private final CstType thisClass;

    public ClassDefItem(CstType cstType, int i, CstType cstType2, TypeList typeList, CstString cstString) {
        if (cstType == null) {
            throw new NullPointerException("thisClass == null");
        }
        if (typeList == null) {
            throw new NullPointerException("interfaces == null");
        }
        this.thisClass = cstType;
        this.accessFlags = i;
        this.superclass = cstType2;
        this.interfaces = typeList.size() == 0 ? null : new TypeListItem(typeList);
        this.sourceFile = cstString;
        this.classData = new ClassDataItem(cstType);
        this.staticValuesItem = null;
        this.annotationsDirectory = new AnnotationsDirectoryItem();
    }

    @Override // com.android.dx.dex.file.Item
    public void addContents(DexFile dexFile) {
        TypeIdsSection typeIds = dexFile.getTypeIds();
        MixedItemSection byteData = dexFile.getByteData();
        MixedItemSection wordData = dexFile.getWordData();
        MixedItemSection typeLists = dexFile.getTypeLists();
        StringIdsSection stringIds = dexFile.getStringIds();
        typeIds.intern(this.thisClass);
        if (!this.classData.isEmpty()) {
            dexFile.getClassData().add(this.classData);
            CstArray staticValuesConstant = this.classData.getStaticValuesConstant();
            if (staticValuesConstant != null) {
                this.staticValuesItem = (EncodedArrayItem) byteData.intern(new EncodedArrayItem(staticValuesConstant));
            }
        }
        CstType cstType = this.superclass;
        if (cstType != null) {
            typeIds.intern(cstType);
        }
        TypeListItem typeListItem = this.interfaces;
        if (typeListItem != null) {
            this.interfaces = (TypeListItem) typeLists.intern(typeListItem);
        }
        CstString cstString = this.sourceFile;
        if (cstString != null) {
            stringIds.intern(cstString);
        }
        if (this.annotationsDirectory.isEmpty()) {
            return;
        }
        if (this.annotationsDirectory.isInternable()) {
            this.annotationsDirectory = (AnnotationsDirectoryItem) wordData.intern(this.annotationsDirectory);
        } else {
            wordData.add(this.annotationsDirectory);
        }
    }

    public void addDirectMethod(EncodedMethod encodedMethod) {
        this.classData.addDirectMethod(encodedMethod);
    }

    public void addFieldAnnotations(CstFieldRef cstFieldRef, Annotations annotations, DexFile dexFile) {
        this.annotationsDirectory.addFieldAnnotations(cstFieldRef, annotations, dexFile);
    }

    public void addInstanceField(EncodedField encodedField) {
        this.classData.addInstanceField(encodedField);
    }

    public void addMethodAnnotations(CstMethodRef cstMethodRef, Annotations annotations, DexFile dexFile) {
        this.annotationsDirectory.addMethodAnnotations(cstMethodRef, annotations, dexFile);
    }

    public void addParameterAnnotations(CstMethodRef cstMethodRef, AnnotationsList annotationsList, DexFile dexFile) {
        this.annotationsDirectory.addParameterAnnotations(cstMethodRef, annotationsList, dexFile);
    }

    public void addStaticField(EncodedField encodedField, Constant constant) {
        this.classData.addStaticField(encodedField, constant);
    }

    public void addVirtualMethod(EncodedMethod encodedMethod) {
        this.classData.addVirtualMethod(encodedMethod);
    }

    public void debugPrint(Writer writer, boolean z6) {
        PrintWriter printWriterPrintWriterFor = Writers.printWriterFor(writer);
        printWriterPrintWriterFor.println(ClassDefItem.class.getName().concat(" {"));
        printWriterPrintWriterFor.println("  accessFlags: " + Hex.u2(this.accessFlags));
        printWriterPrintWriterFor.println("  superclass: " + this.superclass);
        StringBuilder sb = new StringBuilder("  interfaces: ");
        Object obj = this.interfaces;
        if (obj == null) {
            obj = "<none>";
        }
        sb.append(obj);
        printWriterPrintWriterFor.println(sb.toString());
        StringBuilder sb2 = new StringBuilder("  sourceFile: ");
        CstString cstString = this.sourceFile;
        sb2.append(cstString != null ? cstString.toQuoted() : "<none>");
        printWriterPrintWriterFor.println(sb2.toString());
        this.classData.debugPrint(writer, z6);
        this.annotationsDirectory.debugPrint(printWriterPrintWriterFor);
        printWriterPrintWriterFor.println("}");
    }

    public int getAccessFlags() {
        return this.accessFlags;
    }

    public TypeList getInterfaces() {
        TypeListItem typeListItem = this.interfaces;
        return typeListItem == null ? StdTypeList.EMPTY : typeListItem.getList();
    }

    public Annotations getMethodAnnotations(CstMethodRef cstMethodRef) {
        return this.annotationsDirectory.getMethodAnnotations(cstMethodRef);
    }

    public ArrayList<EncodedMethod> getMethods() {
        return this.classData.getMethods();
    }

    public AnnotationsList getParameterAnnotations(CstMethodRef cstMethodRef) {
        return this.annotationsDirectory.getParameterAnnotations(cstMethodRef);
    }

    public CstString getSourceFile() {
        return this.sourceFile;
    }

    public CstType getSuperclass() {
        return this.superclass;
    }

    public CstType getThisClass() {
        return this.thisClass;
    }

    @Override // com.android.dx.dex.file.Item
    public ItemType itemType() {
        return ItemType.TYPE_CLASS_DEF_ITEM;
    }

    public void setClassAnnotations(Annotations annotations, DexFile dexFile) {
        this.annotationsDirectory.setClassAnnotations(annotations, dexFile);
    }

    @Override // com.android.dx.dex.file.Item
    public int writeSize() {
        return 32;
    }

    @Override // com.android.dx.dex.file.Item
    public void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        boolean zAnnotates = annotatedOutput.annotates();
        TypeIdsSection typeIds = dexFile.getTypeIds();
        int iIndexOf = typeIds.indexOf(this.thisClass);
        CstType cstType = this.superclass;
        int iIndexOf2 = cstType == null ? -1 : typeIds.indexOf(cstType);
        int absoluteOffsetOr0 = OffsettedItem.getAbsoluteOffsetOr0(this.interfaces);
        int absoluteOffset = this.annotationsDirectory.isEmpty() ? 0 : this.annotationsDirectory.getAbsoluteOffset();
        int iIndexOf3 = this.sourceFile != null ? dexFile.getStringIds().indexOf(this.sourceFile) : -1;
        int absoluteOffset2 = this.classData.isEmpty() ? 0 : this.classData.getAbsoluteOffset();
        int absoluteOffsetOr02 = OffsettedItem.getAbsoluteOffsetOr0(this.staticValuesItem);
        if (zAnnotates) {
            annotatedOutput.annotate(0, indexString() + ' ' + this.thisClass.toHuman());
            StringBuilder sb = new StringBuilder("  class_idx:           ");
            sb.append(Hex.u4(iIndexOf));
            annotatedOutput.annotate(4, sb.toString());
            annotatedOutput.annotate(4, "  access_flags:        " + AccessFlags.classString(this.accessFlags));
            StringBuilder sb2 = new StringBuilder("  superclass_idx:      ");
            sb2.append(Hex.u4(iIndexOf2));
            sb2.append(" // ");
            CstType cstType2 = this.superclass;
            sb2.append(cstType2 == null ? "<none>" : cstType2.toHuman());
            annotatedOutput.annotate(4, sb2.toString());
            a.t(absoluteOffsetOr0, new StringBuilder("  interfaces_off:      "), annotatedOutput, 4);
            if (absoluteOffsetOr0 != 0) {
                TypeList list = this.interfaces.getList();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    annotatedOutput.annotate(0, "    " + list.getType(i).toHuman());
                }
            }
            StringBuilder sb3 = new StringBuilder("  source_file_idx:     ");
            sb3.append(Hex.u4(iIndexOf3));
            sb3.append(" // ");
            CstString cstString = this.sourceFile;
            sb3.append(cstString != null ? cstString.toHuman() : "<none>");
            annotatedOutput.annotate(4, sb3.toString());
            annotatedOutput.annotate(4, "  annotations_off:     " + Hex.u4(absoluteOffset));
            annotatedOutput.annotate(4, "  class_data_off:      " + Hex.u4(absoluteOffset2));
            a.t(absoluteOffsetOr02, new StringBuilder("  static_values_off:   "), annotatedOutput, 4);
        }
        annotatedOutput.writeInt(iIndexOf);
        annotatedOutput.writeInt(this.accessFlags);
        annotatedOutput.writeInt(iIndexOf2);
        annotatedOutput.writeInt(absoluteOffsetOr0);
        annotatedOutput.writeInt(iIndexOf3);
        annotatedOutput.writeInt(absoluteOffset);
        annotatedOutput.writeInt(absoluteOffset2);
        annotatedOutput.writeInt(absoluteOffsetOr02);
    }
}
