package net.bytebuddy.jar.asm;

import com.android.dx.cf.attrib.AttDeprecated;
import com.android.dx.cf.attrib.AttSignature;
import com.android.dx.cf.attrib.AttSynthetic;

/* JADX INFO: loaded from: classes2.dex */
public class Attribute {
    private byte[] content;
    Attribute nextAttribute;
    public final String type;

    public static final class Set {
        private static final int SIZE_INCREMENT = 6;
        private Attribute[] data = new Attribute[6];
        private int size;

        private void add(Attribute attribute) {
            int i = this.size;
            Attribute[] attributeArr = this.data;
            if (i >= attributeArr.length) {
                Attribute[] attributeArr2 = new Attribute[attributeArr.length + 6];
                System.arraycopy(attributeArr, 0, attributeArr2, 0, i);
                this.data = attributeArr2;
            }
            Attribute[] attributeArr3 = this.data;
            int i3 = this.size;
            this.size = i3 + 1;
            attributeArr3[i3] = attribute;
        }

        private boolean contains(Attribute attribute) {
            for (int i = 0; i < this.size; i++) {
                if (this.data[i].type.equals(attribute.type)) {
                    return true;
                }
            }
            return false;
        }

        public void addAttributes(Attribute attribute) {
            while (attribute != null) {
                if (!contains(attribute)) {
                    add(attribute);
                }
                attribute = attribute.nextAttribute;
            }
        }

        public Attribute[] toArray() {
            int i = this.size;
            Attribute[] attributeArr = new Attribute[i];
            System.arraycopy(this.data, 0, attributeArr, 0, i);
            return attributeArr;
        }
    }

    public Attribute(String str) {
        this.type = str;
    }

    public final int computeAttributesSize(SymbolTable symbolTable) {
        return computeAttributesSize(symbolTable, null, 0, -1, -1);
    }

    public final int getAttributeCount() {
        int i = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.nextAttribute) {
            i++;
        }
        return i;
    }

    public Label[] getLabels() {
        return new Label[0];
    }

    public boolean isCodeAttribute() {
        return false;
    }

    public boolean isUnknown() {
        return true;
    }

    public final void putAttributes(SymbolTable symbolTable, ByteVector byteVector) {
        putAttributes(symbolTable, null, 0, -1, -1, byteVector);
    }

    public Attribute read(ClassReader classReader, int i, int i3, char[] cArr, int i4, Label[] labelArr) {
        Attribute attribute = new Attribute(this.type);
        byte[] bArr = new byte[i3];
        attribute.content = bArr;
        System.arraycopy(classReader.classFileBuffer, i, bArr, 0, i3);
        return attribute;
    }

    public ByteVector write(ClassWriter classWriter, byte[] bArr, int i, int i3, int i4) {
        return new ByteVector(this.content);
    }

    public final int computeAttributesSize(SymbolTable symbolTable, byte[] bArr, int i, int i3, int i4) {
        ClassWriter classWriter = symbolTable.classWriter;
        int i5 = 0;
        Attribute attribute = this;
        while (attribute != null) {
            symbolTable.addConstantUtf8(attribute.type);
            byte[] bArr2 = bArr;
            i5 += attribute.write(classWriter, bArr2, i, i3, i4).length + 6;
            attribute = attribute.nextAttribute;
            bArr = bArr2;
        }
        return i5;
    }

    public final void putAttributes(SymbolTable symbolTable, byte[] bArr, int i, int i3, int i4, ByteVector byteVector) {
        ClassWriter classWriter = symbolTable.classWriter;
        Attribute attribute = this;
        while (attribute != null) {
            byte[] bArr2 = bArr;
            int i5 = i;
            int i6 = i3;
            ByteVector byteVectorWrite = attribute.write(classWriter, bArr2, i5, i6, i4);
            byteVector.putShort(symbolTable.addConstantUtf8(attribute.type)).putInt(byteVectorWrite.length);
            byteVector.putByteArray(byteVectorWrite.data, 0, byteVectorWrite.length);
            attribute = attribute.nextAttribute;
            bArr = bArr2;
            i = i5;
            i3 = i6;
        }
    }

    public static int computeAttributesSize(SymbolTable symbolTable, int i, int i3) {
        int i4;
        if ((i & 4096) == 0 || symbolTable.getMajorVersion() >= 49) {
            i4 = 0;
        } else {
            symbolTable.addConstantUtf8(AttSynthetic.ATTRIBUTE_NAME);
            i4 = 6;
        }
        if (i3 != 0) {
            symbolTable.addConstantUtf8(AttSignature.ATTRIBUTE_NAME);
            i4 += 8;
        }
        if ((i & 131072) == 0) {
            return i4;
        }
        symbolTable.addConstantUtf8(AttDeprecated.ATTRIBUTE_NAME);
        return i4 + 6;
    }

    public static void putAttributes(SymbolTable symbolTable, int i, int i3, ByteVector byteVector) {
        if ((i & 4096) != 0 && symbolTable.getMajorVersion() < 49) {
            byteVector.putShort(symbolTable.addConstantUtf8(AttSynthetic.ATTRIBUTE_NAME)).putInt(0);
        }
        if (i3 != 0) {
            byteVector.putShort(symbolTable.addConstantUtf8(AttSignature.ATTRIBUTE_NAME)).putInt(2).putShort(i3);
        }
        if ((i & 131072) != 0) {
            byteVector.putShort(symbolTable.addConstantUtf8(AttDeprecated.ATTRIBUTE_NAME)).putInt(0);
        }
    }
}
