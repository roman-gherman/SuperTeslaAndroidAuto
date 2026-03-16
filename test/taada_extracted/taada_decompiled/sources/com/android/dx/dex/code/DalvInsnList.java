package com.android.dx.dex.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstBaseMethodRef;
import com.android.dx.rop.cst.CstCallSiteRef;
import com.android.dx.rop.cst.CstProtoRef;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.FixedSizeList;
import com.android.dx.util.IndentingWriter;
import g.C0476a;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class DalvInsnList extends FixedSizeList {
    private final int regCount;

    public DalvInsnList(int i, int i3) {
        super(i);
        this.regCount = i3;
    }

    public static DalvInsnList makeImmutable(ArrayList<DalvInsn> arrayList, int i) {
        int size = arrayList.size();
        DalvInsnList dalvInsnList = new DalvInsnList(size, i);
        for (int i3 = 0; i3 < size; i3++) {
            dalvInsnList.set(i3, arrayList.get(i3));
        }
        dalvInsnList.setImmutable();
        return dalvInsnList;
    }

    public int codeSize() {
        int size = size();
        if (size == 0) {
            return 0;
        }
        return get(size - 1).getNextAddress();
    }

    public void debugPrint(Writer writer, String str, boolean z6) {
        IndentingWriter indentingWriter = new IndentingWriter(writer, 0, str);
        int size = size();
        for (int i = 0; i < size; i++) {
            try {
                DalvInsn dalvInsn = (DalvInsn) get0(i);
                String strListingString = (dalvInsn.codeSize() != 0 || z6) ? dalvInsn.listingString("", 0, z6) : null;
                if (strListingString != null) {
                    indentingWriter.write(strListingString);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        indentingWriter.flush();
    }

    public DalvInsn get(int i) {
        return (DalvInsn) get0(i);
    }

    public int getOutsSize() {
        int wordCount;
        int size = size();
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            DalvInsn dalvInsn = (DalvInsn) get0(i3);
            if (dalvInsn instanceof CstInsn) {
                Constant constant = ((CstInsn) dalvInsn).getConstant();
                wordCount = constant instanceof CstBaseMethodRef ? ((CstBaseMethodRef) constant).getParameterWordCount(dalvInsn.getOpcode().getFamily() == 113) : constant instanceof CstCallSiteRef ? ((CstCallSiteRef) constant).getPrototype().getParameterTypes().getWordCount() : 0;
            } else if (!(dalvInsn instanceof MultiCstInsn)) {
                continue;
            } else {
                if (dalvInsn.getOpcode().getFamily() != 250) {
                    throw new RuntimeException("Expecting invoke-polymorphic");
                }
                wordCount = ((CstProtoRef) ((MultiCstInsn) dalvInsn).getConstant(1)).getPrototype().getParameterTypes().getWordCount() + 1;
            }
            if (wordCount > i) {
                i = wordCount;
            }
        }
        return i;
    }

    public int getRegistersSize() {
        return this.regCount;
    }

    public void set(int i, DalvInsn dalvInsn) {
        set0(i, dalvInsn);
    }

    public void writeTo(AnnotatedOutput annotatedOutput) {
        int cursor = annotatedOutput.getCursor();
        int size = size();
        if (annotatedOutput.annotates()) {
            boolean zIsVerbose = annotatedOutput.isVerbose();
            for (int i = 0; i < size; i++) {
                DalvInsn dalvInsn = (DalvInsn) get0(i);
                int iCodeSize = dalvInsn.codeSize() * 2;
                String strListingString = (iCodeSize != 0 || zIsVerbose) ? dalvInsn.listingString("  ", annotatedOutput.getAnnotationWidth(), true) : null;
                if (strListingString != null) {
                    annotatedOutput.annotate(iCodeSize, strListingString);
                } else if (iCodeSize != 0) {
                    annotatedOutput.annotate(iCodeSize, "");
                }
            }
        }
        for (int i3 = 0; i3 < size; i3++) {
            DalvInsn dalvInsn2 = (DalvInsn) get0(i3);
            try {
                dalvInsn2.writeTo(annotatedOutput);
            } catch (RuntimeException e) {
                throw C0476a.withContext(e, "...while writing " + dalvInsn2);
            }
        }
        int cursor2 = (annotatedOutput.getCursor() - cursor) / 2;
        if (cursor2 == codeSize()) {
            return;
        }
        throw new RuntimeException("write length mismatch; expected " + codeSize() + " but actually wrote " + cursor2);
    }

    public void debugPrint(OutputStream outputStream, String str, boolean z6) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        debugPrint(outputStreamWriter, str, z6);
        try {
            outputStreamWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
