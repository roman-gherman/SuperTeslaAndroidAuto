package net.bytebuddy.jar.asm;

import B2.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RecordComponentVisitor {
    protected final int api;
    protected RecordComponentVisitor delegate;

    public RecordComponentVisitor(int i) {
        this(i, null);
    }

    public RecordComponentVisitor getDelegate() {
        return this.delegate;
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z6) {
        RecordComponentVisitor recordComponentVisitor = this.delegate;
        if (recordComponentVisitor != null) {
            return recordComponentVisitor.visitAnnotation(str, z6);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        RecordComponentVisitor recordComponentVisitor = this.delegate;
        if (recordComponentVisitor != null) {
            recordComponentVisitor.visitAttribute(attribute);
        }
    }

    public void visitEnd() {
        RecordComponentVisitor recordComponentVisitor = this.delegate;
        if (recordComponentVisitor != null) {
            recordComponentVisitor.visitEnd();
        }
    }

    public AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z6) {
        RecordComponentVisitor recordComponentVisitor = this.delegate;
        if (recordComponentVisitor != null) {
            return recordComponentVisitor.visitTypeAnnotation(i, typePath, str, z6);
        }
        return null;
    }

    public RecordComponentVisitor(int i, RecordComponentVisitor recordComponentVisitor) {
        if (i != 589824 && i != 524288 && i != 458752 && i != 393216 && i != 327680 && i != 262144 && i != 17432576) {
            throw new IllegalArgumentException(b.c(i, "Unsupported api "));
        }
        if (i == 17432576) {
            Constants.checkAsmExperimental(this);
        }
        this.api = i;
        this.delegate = recordComponentVisitor;
    }
}
