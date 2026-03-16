package net.bytebuddy.jar.asm;

import com.android.dx.cf.attrib.AttAnnotationDefault;
import com.android.dx.cf.attrib.AttBootstrapMethods;
import com.android.dx.cf.attrib.AttCode;
import com.android.dx.cf.attrib.AttConstantValue;
import com.android.dx.cf.attrib.AttDeprecated;
import com.android.dx.cf.attrib.AttEnclosingMethod;
import com.android.dx.cf.attrib.AttExceptions;
import com.android.dx.cf.attrib.AttInnerClasses;
import com.android.dx.cf.attrib.AttRuntimeInvisibleAnnotations;
import com.android.dx.cf.attrib.AttRuntimeInvisibleParameterAnnotations;
import com.android.dx.cf.attrib.AttRuntimeVisibleAnnotations;
import com.android.dx.cf.attrib.AttRuntimeVisibleParameterAnnotations;
import com.android.dx.cf.attrib.AttSignature;
import com.android.dx.cf.attrib.AttSourceDebugExtension;
import com.android.dx.cf.attrib.AttSourceFile;
import com.android.dx.cf.attrib.AttSynthetic;
import com.android.multidex.ClassPathElement;
import fr.sd.taada.proto.MessageStatus;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public class ClassReader {
    static final int EXPAND_ASM_INSNS = 256;
    public static final int EXPAND_FRAMES = 8;
    private static final int INPUT_STREAM_DATA_CHUNK_SIZE = 4096;
    private static final int MAX_BUFFER_SIZE = 1048576;
    public static final int SKIP_CODE = 1;
    public static final int SKIP_DEBUG = 2;
    public static final int SKIP_FRAMES = 4;

    @Deprecated
    public final byte[] b;
    private final int[] bootstrapMethodOffsets;
    final byte[] classFileBuffer;
    private final ConstantDynamic[] constantDynamicValues;
    private final String[] constantUtf8Values;
    private final int[] cpInfoOffsets;
    public final int header;
    private final int maxStringLength;

    public ClassReader(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    private static int computeBufferSize(InputStream inputStream) throws IOException {
        int iAvailable = inputStream.available();
        if (iAvailable < 256) {
            return 4096;
        }
        return Math.min(iAvailable, 1048576);
    }

    private void computeImplicitFrame(Context context) {
        int i;
        String str = context.currentMethodDescriptor;
        Object[] objArr = context.currentFrameLocalTypes;
        int i3 = 0;
        if ((context.currentMethodAccessFlags & 8) == 0) {
            if (MethodDescription.CONSTRUCTOR_INTERNAL_NAME.equals(context.currentMethodName)) {
                objArr[0] = Opcodes.UNINITIALIZED_THIS;
            } else {
                objArr[0] = readClass(this.header + 2, context.charBuffer);
            }
            i3 = 1;
        }
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char cCharAt = str.charAt(i4);
            if (cCharAt == 'F') {
                i = i3 + 1;
                objArr[i3] = Opcodes.FLOAT;
            } else if (cCharAt != 'L') {
                if (cCharAt != 'S' && cCharAt != 'I') {
                    if (cCharAt == 'J') {
                        i = i3 + 1;
                        objArr[i3] = Opcodes.LONG;
                    } else if (cCharAt != 'Z') {
                        if (cCharAt != '[') {
                            switch (cCharAt) {
                                case 'B':
                                case 'C':
                                    break;
                                case 'D':
                                    i = i3 + 1;
                                    objArr[i3] = Opcodes.DOUBLE;
                                    break;
                                default:
                                    context.currentFrameLocalCount = i3;
                                    return;
                            }
                        } else {
                            while (str.charAt(i5) == '[') {
                                i5++;
                            }
                            if (str.charAt(i5) == 'L') {
                                do {
                                    i5++;
                                } while (str.charAt(i5) != ';');
                            }
                            int i6 = i5 + 1;
                            objArr[i3] = str.substring(i4, i6);
                            i4 = i6;
                            i3++;
                        }
                    }
                }
                i = i3 + 1;
                objArr[i3] = Opcodes.INTEGER;
            } else {
                int i7 = i5;
                while (str.charAt(i7) != ';') {
                    i7++;
                }
                objArr[i3] = str.substring(i5, i7);
                i3++;
                i4 = i7 + 1;
            }
            i3 = i;
            i4 = i5;
        }
    }

    private void createDebugLabel(int i, Label[] labelArr) {
        if (labelArr[i] == null) {
            Label label = readLabel(i, labelArr);
            label.flags = (short) (label.flags | 1);
        }
    }

    private Label createLabel(int i, Label[] labelArr) {
        Label label = readLabel(i, labelArr);
        label.flags = (short) (label.flags & (-2));
        return label;
    }

    private int getTypeAnnotationBytecodeOffset(int[] iArr, int i) {
        if (iArr == null || i >= iArr.length || readByte(iArr[i]) < 67) {
            return -1;
        }
        return readUnsignedShort(iArr[i] + 1);
    }

    private Attribute readAttribute(Attribute[] attributeArr, String str, int i, int i3, char[] cArr, int i4, Label[] labelArr) {
        for (Attribute attribute : attributeArr) {
            if (attribute.type.equals(str)) {
                return attribute.read(this, i, i3, cArr, i4, labelArr);
            }
        }
        return new Attribute(str).read(this, i, i3, null, -1, null);
    }

    private int[] readBootstrapMethodsAttribute(int i) {
        char[] cArr = new char[i];
        int firstAttributeOffset = getFirstAttributeOffset();
        for (int unsignedShort = readUnsignedShort(firstAttributeOffset - 2); unsignedShort > 0; unsignedShort--) {
            String utf8 = readUTF8(firstAttributeOffset, cArr);
            int i3 = readInt(firstAttributeOffset + 2);
            int i4 = firstAttributeOffset + 6;
            if (AttBootstrapMethods.ATTRIBUTE_NAME.equals(utf8)) {
                int unsignedShort2 = readUnsignedShort(i4);
                int[] iArr = new int[unsignedShort2];
                int unsignedShort3 = firstAttributeOffset + 8;
                for (int i5 = 0; i5 < unsignedShort2; i5++) {
                    iArr[i5] = unsignedShort3;
                    unsignedShort3 += (readUnsignedShort(unsignedShort3 + 2) * 2) + 4;
                }
                return iArr;
            }
            firstAttributeOffset = i4 + i3;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x062f  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0641  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0669  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x067d  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x069c  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x06e0  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x03e9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void readCode(net.bytebuddy.jar.asm.MethodVisitor r40, net.bytebuddy.jar.asm.Context r41, int r42) {
        /*
            Method dump skipped, instruction units count: 3124
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.ClassReader.readCode(net.bytebuddy.jar.asm.MethodVisitor, net.bytebuddy.jar.asm.Context, int):void");
    }

    private ConstantDynamic readConstantDynamic(int i, char[] cArr) {
        ConstantDynamic constantDynamic = this.constantDynamicValues[i];
        if (constantDynamic != null) {
            return constantDynamic;
        }
        int[] iArr = this.cpInfoOffsets;
        int i3 = iArr[i];
        int i4 = iArr[readUnsignedShort(i3 + 2)];
        String utf8 = readUTF8(i4, cArr);
        String utf82 = readUTF8(i4 + 2, cArr);
        int i5 = this.bootstrapMethodOffsets[readUnsignedShort(i3)];
        Handle handle = (Handle) readConst(readUnsignedShort(i5), cArr);
        int unsignedShort = readUnsignedShort(i5 + 2);
        Object[] objArr = new Object[unsignedShort];
        int i6 = i5 + 4;
        for (int i7 = 0; i7 < unsignedShort; i7++) {
            objArr[i7] = readConst(readUnsignedShort(i6), cArr);
            i6 += 2;
        }
        ConstantDynamic[] constantDynamicArr = this.constantDynamicValues;
        ConstantDynamic constantDynamic2 = new ConstantDynamic(utf8, utf82, handle, objArr);
        constantDynamicArr[i] = constantDynamic2;
        return constantDynamic2;
    }

    private int readElementValue(AnnotationVisitor annotationVisitor, int i, String str, char[] cArr) {
        int i3 = 0;
        if (annotationVisitor == null) {
            int i4 = this.classFileBuffer[i] & 255;
            return i4 != 64 ? i4 != 91 ? i4 != 101 ? i + 3 : i + 5 : readElementValues(null, i + 1, false, cArr) : readElementValues(null, i + 3, true, cArr);
        }
        int i5 = i + 1;
        int i6 = this.classFileBuffer[i] & 255;
        if (i6 == 64) {
            return readElementValues(annotationVisitor.visitAnnotation(str, readUTF8(i5, cArr)), i + 3, true, cArr);
        }
        if (i6 != 70) {
            if (i6 == 83) {
                annotationVisitor.visit(str, Short.valueOf((short) readInt(this.cpInfoOffsets[readUnsignedShort(i5)])));
                return i + 3;
            }
            if (i6 == 99) {
                annotationVisitor.visit(str, Type.getType(readUTF8(i5, cArr)));
                return i + 3;
            }
            if (i6 == 101) {
                annotationVisitor.visitEnum(str, readUTF8(i5, cArr), readUTF8(i + 3, cArr));
                return i + 5;
            }
            if (i6 == 115) {
                annotationVisitor.visit(str, readUTF8(i5, cArr));
                return i + 3;
            }
            if (i6 != 73 && i6 != 74) {
                if (i6 == 90) {
                    annotationVisitor.visit(str, readInt(this.cpInfoOffsets[readUnsignedShort(i5)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                    return i + 3;
                }
                if (i6 == 91) {
                    int unsignedShort = readUnsignedShort(i5);
                    int i7 = i + 3;
                    if (unsignedShort == 0) {
                        return readElementValues(annotationVisitor.visitArray(str), i + 1, false, cArr);
                    }
                    int i8 = this.classFileBuffer[i7] & 255;
                    if (i8 == 70) {
                        float[] fArr = new float[unsignedShort];
                        while (i3 < unsignedShort) {
                            fArr[i3] = Float.intBitsToFloat(readInt(this.cpInfoOffsets[readUnsignedShort(i7 + 1)]));
                            i7 += 3;
                            i3++;
                        }
                        annotationVisitor.visit(str, fArr);
                        return i7;
                    }
                    if (i8 == 83) {
                        short[] sArr = new short[unsignedShort];
                        while (i3 < unsignedShort) {
                            sArr[i3] = (short) readInt(this.cpInfoOffsets[readUnsignedShort(i7 + 1)]);
                            i7 += 3;
                            i3++;
                        }
                        annotationVisitor.visit(str, sArr);
                        return i7;
                    }
                    if (i8 == 90) {
                        boolean[] zArr = new boolean[unsignedShort];
                        for (int i9 = 0; i9 < unsignedShort; i9++) {
                            zArr[i9] = readInt(this.cpInfoOffsets[readUnsignedShort(i7 + 1)]) != 0;
                            i7 += 3;
                        }
                        annotationVisitor.visit(str, zArr);
                        return i7;
                    }
                    if (i8 == 73) {
                        int[] iArr = new int[unsignedShort];
                        while (i3 < unsignedShort) {
                            iArr[i3] = readInt(this.cpInfoOffsets[readUnsignedShort(i7 + 1)]);
                            i7 += 3;
                            i3++;
                        }
                        annotationVisitor.visit(str, iArr);
                        return i7;
                    }
                    if (i8 == 74) {
                        long[] jArr = new long[unsignedShort];
                        while (i3 < unsignedShort) {
                            jArr[i3] = readLong(this.cpInfoOffsets[readUnsignedShort(i7 + 1)]);
                            i7 += 3;
                            i3++;
                        }
                        annotationVisitor.visit(str, jArr);
                        return i7;
                    }
                    switch (i8) {
                        case 66:
                            byte[] bArr = new byte[unsignedShort];
                            while (i3 < unsignedShort) {
                                bArr[i3] = (byte) readInt(this.cpInfoOffsets[readUnsignedShort(i7 + 1)]);
                                i7 += 3;
                                i3++;
                            }
                            annotationVisitor.visit(str, bArr);
                            return i7;
                        case 67:
                            char[] cArr2 = new char[unsignedShort];
                            while (i3 < unsignedShort) {
                                cArr2[i3] = (char) readInt(this.cpInfoOffsets[readUnsignedShort(i7 + 1)]);
                                i7 += 3;
                                i3++;
                            }
                            annotationVisitor.visit(str, cArr2);
                            return i7;
                        case 68:
                            double[] dArr = new double[unsignedShort];
                            while (i3 < unsignedShort) {
                                dArr[i3] = Double.longBitsToDouble(readLong(this.cpInfoOffsets[readUnsignedShort(i7 + 1)]));
                                i7 += 3;
                                i3++;
                            }
                            annotationVisitor.visit(str, dArr);
                            return i7;
                        default:
                            return readElementValues(annotationVisitor.visitArray(str), i + 1, false, cArr);
                    }
                }
                switch (i6) {
                    case 66:
                        annotationVisitor.visit(str, Byte.valueOf((byte) readInt(this.cpInfoOffsets[readUnsignedShort(i5)])));
                        return i + 3;
                    case 67:
                        annotationVisitor.visit(str, Character.valueOf((char) readInt(this.cpInfoOffsets[readUnsignedShort(i5)])));
                        return i + 3;
                    case 68:
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
        annotationVisitor.visit(str, readConst(readUnsignedShort(i5), cArr));
        return i + 3;
    }

    private int readElementValues(AnnotationVisitor annotationVisitor, int i, boolean z6, char[] cArr) {
        int unsignedShort = readUnsignedShort(i);
        int elementValue = i + 2;
        if (!z6) {
            while (true) {
                int i3 = unsignedShort - 1;
                if (unsignedShort <= 0) {
                    break;
                }
                elementValue = readElementValue(annotationVisitor, elementValue, null, cArr);
                unsignedShort = i3;
            }
        } else {
            while (true) {
                int i4 = unsignedShort - 1;
                if (unsignedShort <= 0) {
                    break;
                }
                elementValue = readElementValue(annotationVisitor, elementValue + 2, readUTF8(elementValue, cArr), cArr);
                unsignedShort = i4;
            }
        }
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
        return elementValue;
    }

    private int readField(ClassVisitor classVisitor, Context context, int i) {
        int i3;
        int i4;
        int i5;
        Context context2 = context;
        char[] cArr = context2.charBuffer;
        int unsignedShort = readUnsignedShort(i);
        String utf8 = readUTF8(i + 2, cArr);
        String utf82 = readUTF8(i + 4, cArr);
        int unsignedShort2 = readUnsignedShort(i + 6);
        int i6 = i + 8;
        int i7 = unsignedShort;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        String utf83 = null;
        Object obj = null;
        Attribute attribute = null;
        while (true) {
            int i12 = unsignedShort2 - 1;
            if (unsignedShort2 <= 0) {
                break;
            }
            int i13 = i8;
            String utf84 = readUTF8(i6, cArr);
            int i14 = readInt(i6 + 2);
            int i15 = i6 + 6;
            if (AttConstantValue.ATTRIBUTE_NAME.equals(utf84)) {
                int unsignedShort3 = readUnsignedShort(i15);
                obj = unsignedShort3 == 0 ? null : readConst(unsignedShort3, cArr);
            } else if (AttSignature.ATTRIBUTE_NAME.equals(utf84)) {
                utf83 = readUTF8(i15, cArr);
            } else {
                if (AttDeprecated.ATTRIBUTE_NAME.equals(utf84)) {
                    i5 = 131072 | i7;
                } else if (AttSynthetic.ATTRIBUTE_NAME.equals(utf84)) {
                    i5 = i7 | 4096;
                } else {
                    if (AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME.equals(utf84)) {
                        i8 = i15;
                        i3 = i8;
                        i15 = i9;
                        i4 = i14;
                    } else {
                        if ("RuntimeVisibleTypeAnnotations".equals(utf84)) {
                            i3 = i15;
                            i10 = i3;
                        } else if (AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME.equals(utf84)) {
                            i3 = i15;
                            i4 = i14;
                            i8 = i13;
                        } else if ("RuntimeInvisibleTypeAnnotations".equals(utf84)) {
                            i3 = i15;
                            i11 = i3;
                        } else {
                            i3 = i15;
                            int i16 = i9;
                            i4 = i14;
                            Attribute attribute2 = readAttribute(context2.attributePrototypes, utf84, i3, i4, cArr, -1, null);
                            attribute2.nextAttribute = attribute;
                            attribute = attribute2;
                            i10 = i10;
                            i15 = i16;
                            i8 = i13;
                            i11 = i11;
                        }
                        i15 = i9;
                        i4 = i14;
                        i8 = i13;
                    }
                    int i17 = i3 + i4;
                    context2 = context;
                    i9 = i15;
                    i6 = i17;
                    unsignedShort2 = i12;
                }
                i3 = i15;
                i7 = i5;
                i15 = i9;
                i4 = i14;
                i8 = i13;
                int i172 = i3 + i4;
                context2 = context;
                i9 = i15;
                i6 = i172;
                unsignedShort2 = i12;
            }
            i3 = i15;
            i15 = i9;
            i4 = i14;
            i8 = i13;
            int i1722 = i3 + i4;
            context2 = context;
            i9 = i15;
            i6 = i1722;
            unsignedShort2 = i12;
        }
        int i18 = i8;
        int i19 = i10;
        int i20 = i11;
        FieldVisitor fieldVisitorVisitField = classVisitor.visitField(i7, utf8, utf82, utf83, obj);
        if (fieldVisitorVisitField == null) {
            return i6;
        }
        if (i18 != 0) {
            int unsignedShort4 = readUnsignedShort(i18);
            int elementValues = i18 + 2;
            while (true) {
                int i21 = unsignedShort4 - 1;
                if (unsignedShort4 <= 0) {
                    break;
                }
                elementValues = readElementValues(fieldVisitorVisitField.visitAnnotation(readUTF8(elementValues, cArr), true), elementValues + 2, true, cArr);
                unsignedShort4 = i21;
            }
        }
        if (i9 != 0) {
            int unsignedShort5 = readUnsignedShort(i9);
            int elementValues2 = i9 + 2;
            while (true) {
                int i22 = unsignedShort5 - 1;
                if (unsignedShort5 <= 0) {
                    break;
                }
                elementValues2 = readElementValues(fieldVisitorVisitField.visitAnnotation(readUTF8(elementValues2, cArr), false), elementValues2 + 2, true, cArr);
                unsignedShort5 = i22;
            }
        }
        if (i19 != 0) {
            int unsignedShort6 = readUnsignedShort(i19);
            int elementValues3 = i19 + 2;
            while (true) {
                int i23 = unsignedShort6 - 1;
                if (unsignedShort6 <= 0) {
                    break;
                }
                int typeAnnotationTarget = readTypeAnnotationTarget(context, elementValues3);
                elementValues3 = readElementValues(fieldVisitorVisitField.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, readUTF8(typeAnnotationTarget, cArr), true), typeAnnotationTarget + 2, true, cArr);
                unsignedShort6 = i23;
            }
        }
        if (i20 != 0) {
            int unsignedShort7 = readUnsignedShort(i20);
            int elementValues4 = i20 + 2;
            while (true) {
                int i24 = unsignedShort7 - 1;
                if (unsignedShort7 <= 0) {
                    break;
                }
                int typeAnnotationTarget2 = readTypeAnnotationTarget(context, elementValues4);
                elementValues4 = readElementValues(fieldVisitorVisitField.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, readUTF8(typeAnnotationTarget2, cArr), false), typeAnnotationTarget2 + 2, true, cArr);
                unsignedShort7 = i24;
            }
        }
        while (attribute != null) {
            Attribute attribute3 = attribute.nextAttribute;
            attribute.nextAttribute = null;
            fieldVisitorVisitField.visitAttribute(attribute);
            attribute = attribute3;
        }
        fieldVisitorVisitField.visitEnd();
        return i6;
    }

    private int readMethod(ClassVisitor classVisitor, Context context, int i) {
        int i3;
        char[] cArr;
        int i4;
        int i5;
        int i6;
        char[] cArr2;
        ClassReader classReader = this;
        char[] cArr3 = context.charBuffer;
        context.currentMethodAccessFlags = classReader.readUnsignedShort(i);
        context.currentMethodName = classReader.readUTF8(i + 2, cArr3);
        int i7 = i + 4;
        context.currentMethodDescriptor = classReader.readUTF8(i7, cArr3);
        int unsignedShort = classReader.readUnsignedShort(i + 6);
        int i8 = i + 8;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        Attribute attribute = null;
        int unsignedShort2 = 0;
        int i13 = 0;
        int i14 = 0;
        String[] strArr = null;
        boolean z6 = false;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            int i19 = unsignedShort - 1;
            if (unsignedShort <= 0) {
                break;
            }
            int i20 = i9;
            String utf8 = classReader.readUTF8(i8, cArr3);
            int i21 = classReader.readInt(i8 + 2);
            int i22 = i10;
            int i23 = i8 + 6;
            int i24 = i20;
            if (AttCode.ATTRIBUTE_NAME.equals(utf8)) {
                if ((context.parsingOptions & 1) == 0) {
                    i18 = i23;
                }
            } else if (AttExceptions.ATTRIBUTE_NAME.equals(utf8)) {
                int unsignedShort3 = classReader.readUnsignedShort(i23);
                int i25 = i8 + 8;
                strArr = new String[unsignedShort3];
                for (int i26 = 0; i26 < unsignedShort3; i26++) {
                    strArr[i26] = classReader.readClass(i25, cArr3);
                    i25 += 2;
                }
                i15 = i23;
            } else if (AttSignature.ATTRIBUTE_NAME.equals(utf8)) {
                unsignedShort2 = classReader.readUnsignedShort(i23);
            } else if (AttDeprecated.ATTRIBUTE_NAME.equals(utf8)) {
                context.currentMethodAccessFlags |= 131072;
            } else if (AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME.equals(utf8)) {
                i24 = i23;
            } else if ("RuntimeVisibleTypeAnnotations".equals(utf8)) {
                i5 = i23;
                cArr2 = cArr3;
                i6 = i21;
                i8 = i23 + i6;
                cArr3 = cArr2;
                unsignedShort = i19;
                i10 = i22;
                i9 = i24;
                i11 = i5;
            } else if (AttAnnotationDefault.ATTRIBUTE_NAME.equals(utf8)) {
                i14 = i23;
            } else {
                if (AttSynthetic.ATTRIBUTE_NAME.equals(utf8)) {
                    context.currentMethodAccessFlags |= 4096;
                    i5 = i11;
                    cArr2 = cArr3;
                    i6 = i21;
                    z6 = true;
                } else if (AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME.equals(utf8)) {
                    i22 = i23;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(utf8)) {
                    i12 = i23;
                } else if (AttRuntimeVisibleParameterAnnotations.ATTRIBUTE_NAME.equals(utf8)) {
                    i16 = i23;
                } else if (AttRuntimeInvisibleParameterAnnotations.ATTRIBUTE_NAME.equals(utf8)) {
                    i17 = i23;
                } else if ("MethodParameters".equals(utf8)) {
                    i13 = i23;
                } else {
                    i5 = i11;
                    i6 = i21;
                    Attribute attribute2 = classReader.readAttribute(context.attributePrototypes, utf8, i23, i6, cArr3, -1, null);
                    cArr2 = cArr3;
                    attribute2.nextAttribute = attribute;
                    attribute = attribute2;
                    i12 = i12;
                }
                i8 = i23 + i6;
                cArr3 = cArr2;
                unsignedShort = i19;
                i10 = i22;
                i9 = i24;
                i11 = i5;
            }
            i5 = i11;
            cArr2 = cArr3;
            i6 = i21;
            i8 = i23 + i6;
            cArr3 = cArr2;
            unsignedShort = i19;
            i10 = i22;
            i9 = i24;
            i11 = i5;
        }
        int i27 = i9;
        int i28 = i10;
        int i29 = i11;
        char[] cArr4 = cArr3;
        int i30 = i12;
        int i31 = i14;
        int i32 = i13;
        MethodVisitor methodVisitorVisitMethod = classVisitor.visitMethod(context.currentMethodAccessFlags, context.currentMethodName, context.currentMethodDescriptor, unsignedShort2 == 0 ? null : classReader.readUtf(unsignedShort2, cArr4), strArr);
        if (methodVisitorVisitMethod == null) {
            return i8;
        }
        if (methodVisitorVisitMethod instanceof MethodWriter) {
            MethodWriter methodWriter = (MethodWriter) methodVisitorVisitMethod;
            i4 = i31;
            boolean z7 = (context.currentMethodAccessFlags & 131072) != 0;
            int unsignedShort4 = classReader.readUnsignedShort(i7);
            int i33 = unsignedShort2;
            i3 = i32;
            cArr = cArr4;
            boolean zCanCopyMethodAttributes = methodWriter.canCopyMethodAttributes(classReader, z6, z7, unsignedShort4, i33, i15);
            classReader = classReader;
            if (zCanCopyMethodAttributes) {
                methodWriter.setMethodAttributesSource(i, i8 - i);
                return i8;
            }
        } else {
            i3 = i32;
            cArr = cArr4;
            i4 = i31;
        }
        if (i3 != 0 && (context.parsingOptions & 2) == 0) {
            int i34 = classReader.readByte(i3);
            int i35 = i3 + 1;
            while (true) {
                int i36 = i34 - 1;
                if (i34 <= 0) {
                    break;
                }
                methodVisitorVisitMethod.visitParameter(classReader.readUTF8(i35, cArr), classReader.readUnsignedShort(i35 + 2));
                i35 += 4;
                i34 = i36;
            }
        }
        if (i4 != 0) {
            AnnotationVisitor annotationVisitorVisitAnnotationDefault = methodVisitorVisitMethod.visitAnnotationDefault();
            classReader.readElementValue(annotationVisitorVisitAnnotationDefault, i4, null, cArr);
            if (annotationVisitorVisitAnnotationDefault != null) {
                annotationVisitorVisitAnnotationDefault.visitEnd();
            }
        }
        if (i27 != 0) {
            int unsignedShort5 = classReader.readUnsignedShort(i27);
            int elementValues = i27 + 2;
            while (true) {
                int i37 = unsignedShort5 - 1;
                if (unsignedShort5 <= 0) {
                    break;
                }
                elementValues = classReader.readElementValues(methodVisitorVisitMethod.visitAnnotation(classReader.readUTF8(elementValues, cArr), true), elementValues + 2, true, cArr);
                unsignedShort5 = i37;
            }
        }
        if (i28 != 0) {
            int unsignedShort6 = classReader.readUnsignedShort(i28);
            int elementValues2 = i28 + 2;
            while (true) {
                int i38 = unsignedShort6 - 1;
                if (unsignedShort6 <= 0) {
                    break;
                }
                elementValues2 = classReader.readElementValues(methodVisitorVisitMethod.visitAnnotation(classReader.readUTF8(elementValues2, cArr), false), elementValues2 + 2, true, cArr);
                unsignedShort6 = i38;
            }
        }
        if (i29 != 0) {
            int unsignedShort7 = classReader.readUnsignedShort(i29);
            int elementValues3 = i29 + 2;
            while (true) {
                int i39 = unsignedShort7 - 1;
                if (unsignedShort7 <= 0) {
                    break;
                }
                int typeAnnotationTarget = classReader.readTypeAnnotationTarget(context, elementValues3);
                elementValues3 = classReader.readElementValues(methodVisitorVisitMethod.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, classReader.readUTF8(typeAnnotationTarget, cArr), true), typeAnnotationTarget + 2, true, cArr);
                unsignedShort7 = i39;
            }
        }
        if (i30 != 0) {
            int unsignedShort8 = classReader.readUnsignedShort(i30);
            int elementValues4 = i30 + 2;
            while (true) {
                int i40 = unsignedShort8 - 1;
                if (unsignedShort8 <= 0) {
                    break;
                }
                int typeAnnotationTarget2 = classReader.readTypeAnnotationTarget(context, elementValues4);
                elementValues4 = classReader.readElementValues(methodVisitorVisitMethod.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, classReader.readUTF8(typeAnnotationTarget2, cArr), false), typeAnnotationTarget2 + 2, true, cArr);
                unsignedShort8 = i40;
            }
        }
        int i41 = i16;
        if (i41 != 0) {
            classReader.readParameterAnnotations(methodVisitorVisitMethod, context, i41, true);
        }
        int i42 = i17;
        if (i42 != 0) {
            classReader.readParameterAnnotations(methodVisitorVisitMethod, context, i42, false);
        }
        while (attribute != null) {
            Attribute attribute3 = attribute.nextAttribute;
            attribute.nextAttribute = null;
            methodVisitorVisitMethod.visitAttribute(attribute);
            attribute = attribute3;
        }
        int i43 = i18;
        if (i43 != 0) {
            methodVisitorVisitMethod.visitCode();
            classReader.readCode(methodVisitorVisitMethod, context, i43);
        }
        methodVisitorVisitMethod.visitEnd();
        return i8;
    }

    private void readModuleAttributes(ClassVisitor classVisitor, Context context, int i, int i3, String str) {
        String[] strArr;
        char[] cArr = context.charBuffer;
        int i4 = i + 6;
        ModuleVisitor moduleVisitorVisitModule = classVisitor.visitModule(readModule(i, cArr), readUnsignedShort(i + 2), readUTF8(i + 4, cArr));
        if (moduleVisitorVisitModule == null) {
            return;
        }
        if (str != null) {
            moduleVisitorVisitModule.visitMainClass(str);
        }
        if (i3 != 0) {
            int unsignedShort = readUnsignedShort(i3);
            int i5 = i3 + 2;
            while (true) {
                int i6 = unsignedShort - 1;
                if (unsignedShort <= 0) {
                    break;
                }
                moduleVisitorVisitModule.visitPackage(readPackage(i5, cArr));
                i5 += 2;
                unsignedShort = i6;
            }
        }
        int unsignedShort2 = readUnsignedShort(i4);
        int i7 = i + 8;
        while (true) {
            int i8 = unsignedShort2 - 1;
            if (unsignedShort2 <= 0) {
                break;
            }
            String module = readModule(i7, cArr);
            int unsignedShort3 = readUnsignedShort(i7 + 2);
            String utf8 = readUTF8(i7 + 4, cArr);
            i7 += 6;
            moduleVisitorVisitModule.visitRequire(module, unsignedShort3, utf8);
            unsignedShort2 = i8;
        }
        int unsignedShort4 = readUnsignedShort(i7);
        int i9 = i7 + 2;
        while (true) {
            int i10 = unsignedShort4 - 1;
            String[] strArr2 = null;
            if (unsignedShort4 <= 0) {
                break;
            }
            String str2 = readPackage(i9, cArr);
            int unsignedShort5 = readUnsignedShort(i9 + 2);
            int unsignedShort6 = readUnsignedShort(i9 + 4);
            i9 += 6;
            if (unsignedShort6 != 0) {
                strArr2 = new String[unsignedShort6];
                for (int i11 = 0; i11 < unsignedShort6; i11++) {
                    strArr2[i11] = readModule(i9, cArr);
                    i9 += 2;
                }
            }
            moduleVisitorVisitModule.visitExport(str2, unsignedShort5, strArr2);
            unsignedShort4 = i10;
        }
        int unsignedShort7 = readUnsignedShort(i9);
        int i12 = i9 + 2;
        while (true) {
            int i13 = unsignedShort7 - 1;
            if (unsignedShort7 <= 0) {
                break;
            }
            String str3 = readPackage(i12, cArr);
            int unsignedShort8 = readUnsignedShort(i12 + 2);
            int unsignedShort9 = readUnsignedShort(i12 + 4);
            i12 += 6;
            if (unsignedShort9 != 0) {
                strArr = new String[unsignedShort9];
                for (int i14 = 0; i14 < unsignedShort9; i14++) {
                    strArr[i14] = readModule(i12, cArr);
                    i12 += 2;
                }
            } else {
                strArr = null;
            }
            moduleVisitorVisitModule.visitOpen(str3, unsignedShort8, strArr);
            unsignedShort7 = i13;
        }
        int unsignedShort10 = readUnsignedShort(i12);
        int i15 = i12 + 2;
        while (true) {
            int i16 = unsignedShort10 - 1;
            if (unsignedShort10 <= 0) {
                break;
            }
            moduleVisitorVisitModule.visitUse(readClass(i15, cArr));
            i15 += 2;
            unsignedShort10 = i16;
        }
        int unsignedShort11 = readUnsignedShort(i15);
        int i17 = i15 + 2;
        while (true) {
            int i18 = unsignedShort11 - 1;
            if (unsignedShort11 <= 0) {
                moduleVisitorVisitModule.visitEnd();
                return;
            }
            String str4 = readClass(i17, cArr);
            int unsignedShort12 = readUnsignedShort(i17 + 2);
            i17 += 4;
            String[] strArr3 = new String[unsignedShort12];
            for (int i19 = 0; i19 < unsignedShort12; i19++) {
                strArr3[i19] = readClass(i17, cArr);
                i17 += 2;
            }
            moduleVisitorVisitModule.visitProvide(str4, strArr3);
            unsignedShort11 = i18;
        }
    }

    private void readParameterAnnotations(MethodVisitor methodVisitor, Context context, int i, boolean z6) {
        int elementValues = i + 1;
        int i3 = this.classFileBuffer[i] & 255;
        methodVisitor.visitAnnotableParameterCount(i3, z6);
        char[] cArr = context.charBuffer;
        for (int i4 = 0; i4 < i3; i4++) {
            int unsignedShort = readUnsignedShort(elementValues);
            elementValues += 2;
            while (true) {
                int i5 = unsignedShort - 1;
                if (unsignedShort > 0) {
                    elementValues = readElementValues(methodVisitor.visitParameterAnnotation(i4, readUTF8(elementValues, cArr), z6), elementValues + 2, true, cArr);
                    unsignedShort = i5;
                }
            }
        }
    }

    private int readRecordComponent(ClassVisitor classVisitor, Context context, int i) {
        int i3;
        int i4;
        Attribute attribute;
        char[] cArr = context.charBuffer;
        String utf8 = readUTF8(i, cArr);
        String utf82 = readUTF8(i + 2, cArr);
        int unsignedShort = readUnsignedShort(i + 4);
        int i5 = i + 6;
        int i6 = 0;
        Attribute attribute2 = null;
        int i7 = 0;
        String utf83 = null;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = unsignedShort - 1;
            if (unsignedShort <= 0) {
                break;
            }
            String utf84 = readUTF8(i5, cArr);
            int i11 = readInt(i5 + 2);
            int i12 = i5 + 6;
            if (AttSignature.ATTRIBUTE_NAME.equals(utf84)) {
                utf83 = readUTF8(i12, cArr);
                int i13 = i6;
                i3 = i12;
                i12 = i13;
            } else {
                if (AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME.equals(utf84)) {
                    i8 = i12;
                    attribute = attribute2;
                    i4 = i11;
                    i12 = i6;
                    i3 = i8;
                } else if ("RuntimeVisibleTypeAnnotations".equals(utf84)) {
                    i3 = i12;
                } else if (AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME.equals(utf84)) {
                    i9 = i12;
                    attribute = attribute2;
                    i4 = i11;
                    i12 = i6;
                    i3 = i9;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(utf84)) {
                    i7 = i12;
                    attribute = attribute2;
                    i4 = i11;
                    i12 = i6;
                    i3 = i7;
                } else {
                    int i14 = i6;
                    i3 = i12;
                    Attribute attribute3 = attribute2;
                    i4 = i11;
                    Attribute attribute4 = readAttribute(context.attributePrototypes, utf84, i3, i4, cArr, -1, null);
                    attribute4.nextAttribute = attribute3;
                    attribute = attribute4;
                    i12 = i14;
                    i7 = i7;
                }
                int i15 = i3 + i4;
                i6 = i12;
                i5 = i15;
                attribute2 = attribute;
                unsignedShort = i10;
            }
            attribute = attribute2;
            i4 = i11;
            int i152 = i3 + i4;
            i6 = i12;
            i5 = i152;
            attribute2 = attribute;
            unsignedShort = i10;
        }
        int i16 = i6;
        Attribute attribute5 = attribute2;
        int i17 = i7;
        RecordComponentVisitor recordComponentVisitorVisitRecordComponent = classVisitor.visitRecordComponent(utf8, utf82, utf83);
        if (recordComponentVisitorVisitRecordComponent == null) {
            return i5;
        }
        if (i8 != 0) {
            int unsignedShort2 = readUnsignedShort(i8);
            int elementValues = i8 + 2;
            while (true) {
                int i18 = unsignedShort2 - 1;
                if (unsignedShort2 <= 0) {
                    break;
                }
                elementValues = readElementValues(recordComponentVisitorVisitRecordComponent.visitAnnotation(readUTF8(elementValues, cArr), true), elementValues + 2, true, cArr);
                unsignedShort2 = i18;
            }
        }
        if (i9 != 0) {
            int unsignedShort3 = readUnsignedShort(i9);
            int elementValues2 = i9 + 2;
            while (true) {
                int i19 = unsignedShort3 - 1;
                if (unsignedShort3 <= 0) {
                    break;
                }
                elementValues2 = readElementValues(recordComponentVisitorVisitRecordComponent.visitAnnotation(readUTF8(elementValues2, cArr), false), elementValues2 + 2, true, cArr);
                unsignedShort3 = i19;
            }
        }
        if (i16 != 0) {
            int unsignedShort4 = readUnsignedShort(i16);
            int elementValues3 = i16 + 2;
            while (true) {
                int i20 = unsignedShort4 - 1;
                if (unsignedShort4 <= 0) {
                    break;
                }
                int typeAnnotationTarget = readTypeAnnotationTarget(context, elementValues3);
                elementValues3 = readElementValues(recordComponentVisitorVisitRecordComponent.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, readUTF8(typeAnnotationTarget, cArr), true), typeAnnotationTarget + 2, true, cArr);
                unsignedShort4 = i20;
            }
        }
        if (i17 != 0) {
            int unsignedShort5 = readUnsignedShort(i17);
            int elementValues4 = i17 + 2;
            while (true) {
                int i21 = unsignedShort5 - 1;
                if (unsignedShort5 <= 0) {
                    break;
                }
                int typeAnnotationTarget2 = readTypeAnnotationTarget(context, elementValues4);
                elementValues4 = readElementValues(recordComponentVisitorVisitRecordComponent.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, readUTF8(typeAnnotationTarget2, cArr), false), typeAnnotationTarget2 + 2, true, cArr);
                unsignedShort5 = i21;
            }
        }
        Attribute attribute6 = attribute5;
        while (attribute6 != null) {
            Attribute attribute7 = attribute6.nextAttribute;
            attribute6.nextAttribute = null;
            recordComponentVisitorVisitRecordComponent.visitAttribute(attribute6);
            attribute6 = attribute7;
        }
        recordComponentVisitorVisitRecordComponent.visitEnd();
        return i5;
    }

    private int readStackMapFrame(int i, boolean z6, boolean z7, Context context) {
        int verificationTypeInfo;
        int i3;
        char[] cArr = context.charBuffer;
        Label[] labelArr = context.currentMethodLabels;
        if (z6) {
            verificationTypeInfo = i + 1;
            i3 = this.classFileBuffer[i] & 255;
        } else {
            context.currentFrameOffset = -1;
            verificationTypeInfo = i;
            i3 = 255;
        }
        context.currentFrameLocalCountDelta = 0;
        if (i3 < 64) {
            context.currentFrameType = 3;
            context.currentFrameStackCount = 0;
        } else if (i3 < 128) {
            i3 -= 64;
            verificationTypeInfo = readVerificationTypeInfo(verificationTypeInfo, context.currentFrameStackTypes, 0, cArr, labelArr);
            context.currentFrameType = 4;
            context.currentFrameStackCount = 1;
        } else {
            if (i3 < 247) {
                throw new IllegalArgumentException();
            }
            int unsignedShort = readUnsignedShort(verificationTypeInfo);
            int i4 = verificationTypeInfo;
            verificationTypeInfo = i4 + 2;
            if (i3 == 247) {
                verificationTypeInfo = readVerificationTypeInfo(verificationTypeInfo, context.currentFrameStackTypes, 0, cArr, labelArr);
                context.currentFrameType = 4;
                context.currentFrameStackCount = 1;
            } else if (i3 >= 248 && i3 < 251) {
                context.currentFrameType = 2;
                int i5 = 251 - i3;
                context.currentFrameLocalCountDelta = i5;
                context.currentFrameLocalCount -= i5;
                context.currentFrameStackCount = 0;
            } else if (i3 == 251) {
                context.currentFrameType = 3;
                context.currentFrameStackCount = 0;
            } else if (i3 < 255) {
                int i6 = z7 ? context.currentFrameLocalCount : 0;
                int i7 = i3 + MessageStatus.STATUS_FRAMING_ERROR_VALUE;
                int i8 = i6;
                int i9 = i7;
                while (i9 > 0) {
                    verificationTypeInfo = readVerificationTypeInfo(verificationTypeInfo, context.currentFrameLocalTypes, i8, cArr, labelArr);
                    i9--;
                    i8++;
                }
                context.currentFrameType = 1;
                context.currentFrameLocalCountDelta = i7;
                context.currentFrameLocalCount += i7;
                context.currentFrameStackCount = 0;
            } else {
                int unsignedShort2 = readUnsignedShort(verificationTypeInfo);
                int verificationTypeInfo2 = i4 + 4;
                context.currentFrameType = 0;
                context.currentFrameLocalCountDelta = unsignedShort2;
                context.currentFrameLocalCount = unsignedShort2;
                for (int i10 = 0; i10 < unsignedShort2; i10++) {
                    verificationTypeInfo2 = readVerificationTypeInfo(verificationTypeInfo2, context.currentFrameLocalTypes, i10, cArr, labelArr);
                }
                int unsignedShort3 = readUnsignedShort(verificationTypeInfo2);
                verificationTypeInfo = verificationTypeInfo2 + 2;
                context.currentFrameStackCount = unsignedShort3;
                for (int i11 = 0; i11 < unsignedShort3; i11++) {
                    verificationTypeInfo = readVerificationTypeInfo(verificationTypeInfo, context.currentFrameStackTypes, i11, cArr, labelArr);
                }
            }
            i3 = unsignedShort;
        }
        int i12 = i3 + 1 + context.currentFrameOffset;
        context.currentFrameOffset = i12;
        createLabel(i12, labelArr);
        return verificationTypeInfo;
    }

    private static byte[] readStream(InputStream inputStream, boolean z6) throws IOException {
        if (inputStream == null) {
            throw new IOException("Class not found");
        }
        int iComputeBufferSize = computeBufferSize(inputStream);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[iComputeBufferSize];
                int i = 0;
                while (true) {
                    int i3 = inputStream.read(bArr, 0, iComputeBufferSize);
                    if (i3 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i3);
                    i++;
                }
                byteArrayOutputStream.flush();
                if (i == 1) {
                    byteArrayOutputStream.close();
                    return bArr;
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                if (z6) {
                    inputStream.close();
                }
                return byteArray;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } finally {
            if (z6) {
                inputStream.close();
            }
        }
    }

    private String readStringish(int i, char[] cArr) {
        return readUTF8(this.cpInfoOffsets[readUnsignedShort(i)], cArr);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int readTypeAnnotationTarget(net.bytebuddy.jar.asm.Context r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.readInt(r11)
            int r1 = r0 >>> 24
            r2 = 1
            if (r1 == 0) goto L70
            if (r1 == r2) goto L70
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            switch(r1) {
                case 16: goto L6d;
                case 17: goto L6d;
                case 18: goto L6d;
                case 19: goto L6a;
                case 20: goto L6a;
                case 21: goto L6a;
                case 22: goto L70;
                case 23: goto L6d;
                default: goto L10;
            }
        L10:
            switch(r1) {
                case 64: goto L24;
                case 65: goto L24;
                case 66: goto L6d;
                case 67: goto L20;
                case 68: goto L20;
                case 69: goto L20;
                case 70: goto L20;
                case 71: goto L19;
                case 72: goto L19;
                case 73: goto L19;
                case 74: goto L19;
                case 75: goto L19;
                default: goto L13;
            }
        L13:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>()
            throw r10
        L19:
            r1 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r0 = r0 & r1
            int r11 = r11 + 4
            goto L75
        L20:
            r0 = r0 & r3
        L21:
            int r11 = r11 + 3
            goto L75
        L24:
            r0 = r0 & r3
            int r1 = r11 + 1
            int r1 = r9.readUnsignedShort(r1)
            int r11 = r11 + 3
            net.bytebuddy.jar.asm.Label[] r3 = new net.bytebuddy.jar.asm.Label[r1]
            r10.currentLocalVariableAnnotationRangeStarts = r3
            net.bytebuddy.jar.asm.Label[] r3 = new net.bytebuddy.jar.asm.Label[r1]
            r10.currentLocalVariableAnnotationRangeEnds = r3
            int[] r3 = new int[r1]
            r10.currentLocalVariableAnnotationRangeIndices = r3
            r3 = 0
        L3a:
            if (r3 >= r1) goto L75
            int r4 = r9.readUnsignedShort(r11)
            int r5 = r11 + 2
            int r5 = r9.readUnsignedShort(r5)
            int r6 = r11 + 4
            int r6 = r9.readUnsignedShort(r6)
            int r11 = r11 + 6
            net.bytebuddy.jar.asm.Label[] r7 = r10.currentLocalVariableAnnotationRangeStarts
            net.bytebuddy.jar.asm.Label[] r8 = r10.currentMethodLabels
            net.bytebuddy.jar.asm.Label r8 = r9.createLabel(r4, r8)
            r7[r3] = r8
            net.bytebuddy.jar.asm.Label[] r7 = r10.currentLocalVariableAnnotationRangeEnds
            int r4 = r4 + r5
            net.bytebuddy.jar.asm.Label[] r5 = r10.currentMethodLabels
            net.bytebuddy.jar.asm.Label r4 = r9.createLabel(r4, r5)
            r7[r3] = r4
            int[] r4 = r10.currentLocalVariableAnnotationRangeIndices
            r4[r3] = r6
            int r3 = r3 + 1
            goto L3a
        L6a:
            r0 = r0 & r3
            int r11 = r11 + r2
            goto L75
        L6d:
            r0 = r0 & (-256(0xffffffffffffff00, float:NaN))
            goto L21
        L70:
            r1 = -65536(0xffffffffffff0000, float:NaN)
            r0 = r0 & r1
            int r11 = r11 + 2
        L75:
            r10.currentTypeAnnotationTarget = r0
            int r0 = r9.readByte(r11)
            if (r0 != 0) goto L7f
            r1 = 0
            goto L86
        L7f:
            net.bytebuddy.jar.asm.TypePath r1 = new net.bytebuddy.jar.asm.TypePath
            byte[] r3 = r9.classFileBuffer
            r1.<init>(r3, r11)
        L86:
            r10.currentTypeAnnotationTargetPath = r1
            int r11 = r11 + r2
            int r0 = r0 * 2
            int r0 = r0 + r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.ClassReader.readTypeAnnotationTarget(net.bytebuddy.jar.asm.Context, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int[] readTypeAnnotations(net.bytebuddy.jar.asm.MethodVisitor r11, net.bytebuddy.jar.asm.Context r12, int r13, boolean r14) {
        /*
            r10 = this;
            char[] r0 = r12.charBuffer
            int r1 = r10.readUnsignedShort(r13)
            int[] r2 = new int[r1]
            int r13 = r13 + 2
            r3 = 0
        Lb:
            if (r3 >= r1) goto L84
            r2[r3] = r13
            int r4 = r10.readInt(r13)
            int r5 = r4 >>> 24
            r6 = 23
            if (r5 == r6) goto L4d
            switch(r5) {
                case 16: goto L4d;
                case 17: goto L4d;
                case 18: goto L4d;
                default: goto L1c;
            }
        L1c:
            switch(r5) {
                case 64: goto L28;
                case 65: goto L28;
                case 66: goto L4d;
                case 67: goto L4d;
                case 68: goto L4d;
                case 69: goto L4d;
                case 70: goto L4d;
                case 71: goto L25;
                case 72: goto L25;
                case 73: goto L25;
                case 74: goto L25;
                case 75: goto L25;
                default: goto L1f;
            }
        L1f:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            r11.<init>()
            throw r11
        L25:
            int r13 = r13 + 4
            goto L4f
        L28:
            int r6 = r13 + 1
            int r6 = r10.readUnsignedShort(r6)
            int r13 = r13 + 3
        L30:
            int r7 = r6 + (-1)
            if (r6 <= 0) goto L4f
            int r6 = r10.readUnsignedShort(r13)
            int r8 = r13 + 2
            int r8 = r10.readUnsignedShort(r8)
            int r13 = r13 + 6
            net.bytebuddy.jar.asm.Label[] r9 = r12.currentMethodLabels
            r10.createLabel(r6, r9)
            int r6 = r6 + r8
            net.bytebuddy.jar.asm.Label[] r8 = r12.currentMethodLabels
            r10.createLabel(r6, r8)
            r6 = r7
            goto L30
        L4d:
            int r13 = r13 + 3
        L4f:
            int r6 = r10.readByte(r13)
            r7 = 66
            r8 = 0
            r9 = 1
            if (r5 != r7) goto L78
            if (r6 != 0) goto L5c
            goto L63
        L5c:
            net.bytebuddy.jar.asm.TypePath r8 = new net.bytebuddy.jar.asm.TypePath
            byte[] r5 = r10.classFileBuffer
            r8.<init>(r5, r13)
        L63:
            int r6 = r6 * 2
            int r6 = r6 + r9
            int r6 = r6 + r13
            java.lang.String r13 = r10.readUTF8(r6, r0)
            int r6 = r6 + 2
            r4 = r4 & (-256(0xffffffffffffff00, float:NaN))
            net.bytebuddy.jar.asm.AnnotationVisitor r13 = r11.visitTryCatchAnnotation(r4, r8, r13, r14)
            int r13 = r10.readElementValues(r13, r6, r9, r0)
            goto L81
        L78:
            int r6 = r6 * 2
            int r6 = r6 + 3
            int r6 = r6 + r13
            int r13 = r10.readElementValues(r8, r6, r9, r0)
        L81:
            int r3 = r3 + 1
            goto Lb
        L84:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.ClassReader.readTypeAnnotations(net.bytebuddy.jar.asm.MethodVisitor, net.bytebuddy.jar.asm.Context, int, boolean):int[]");
    }

    private int readVerificationTypeInfo(int i, Object[] objArr, int i3, char[] cArr, Label[] labelArr) {
        int i4 = i + 1;
        switch (this.classFileBuffer[i] & 255) {
            case 0:
                objArr[i3] = Opcodes.TOP;
                return i4;
            case 1:
                objArr[i3] = Opcodes.INTEGER;
                return i4;
            case 2:
                objArr[i3] = Opcodes.FLOAT;
                return i4;
            case 3:
                objArr[i3] = Opcodes.DOUBLE;
                return i4;
            case 4:
                objArr[i3] = Opcodes.LONG;
                return i4;
            case 5:
                objArr[i3] = Opcodes.NULL;
                return i4;
            case 6:
                objArr[i3] = Opcodes.UNINITIALIZED_THIS;
                return i4;
            case 7:
                objArr[i3] = readClass(i4, cArr);
                break;
            case 8:
                objArr[i3] = createLabel(readUnsignedShort(i4), labelArr);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return i + 3;
    }

    public void accept(ClassVisitor classVisitor, int i) {
        accept(classVisitor, new Attribute[0], i);
    }

    public int getAccess() {
        return readUnsignedShort(this.header);
    }

    public String getClassName() {
        return readClass(this.header + 2, new char[this.maxStringLength]);
    }

    public final int getFirstAttributeOffset() {
        int i = this.header;
        int unsignedShort = (readUnsignedShort(i + 6) * 2) + i + 8;
        int unsignedShort2 = readUnsignedShort(unsignedShort);
        int i3 = unsignedShort + 2;
        while (true) {
            int i4 = unsignedShort2 - 1;
            if (unsignedShort2 <= 0) {
                break;
            }
            int unsignedShort3 = readUnsignedShort(i3 + 6);
            i3 += 8;
            while (true) {
                int i5 = unsignedShort3 - 1;
                if (unsignedShort3 > 0) {
                    i3 += readInt(i3 + 2) + 6;
                    unsignedShort3 = i5;
                }
            }
            unsignedShort2 = i4;
        }
        int unsignedShort4 = readUnsignedShort(i3);
        int i6 = i3 + 2;
        while (true) {
            int i7 = unsignedShort4 - 1;
            if (unsignedShort4 <= 0) {
                return i6 + 2;
            }
            int unsignedShort5 = readUnsignedShort(i6 + 6);
            i6 += 8;
            while (true) {
                int i8 = unsignedShort5 - 1;
                if (unsignedShort5 > 0) {
                    i6 += readInt(i6 + 2) + 6;
                    unsignedShort5 = i8;
                }
            }
            unsignedShort4 = i7;
        }
    }

    public String[] getInterfaces() {
        int i = this.header + 6;
        int unsignedShort = readUnsignedShort(i);
        String[] strArr = new String[unsignedShort];
        if (unsignedShort > 0) {
            char[] cArr = new char[this.maxStringLength];
            for (int i3 = 0; i3 < unsignedShort; i3++) {
                i += 2;
                strArr[i3] = readClass(i, cArr);
            }
        }
        return strArr;
    }

    public int getItem(int i) {
        return this.cpInfoOffsets[i];
    }

    public int getItemCount() {
        return this.cpInfoOffsets.length;
    }

    public int getMaxStringLength() {
        return this.maxStringLength;
    }

    public String getSuperName() {
        return readClass(this.header + 4, new char[this.maxStringLength]);
    }

    public int readByte(int i) {
        return this.classFileBuffer[i] & 255;
    }

    public String readClass(int i, char[] cArr) {
        return readStringish(i, cArr);
    }

    public Object readConst(int i, char[] cArr) {
        int i3 = this.cpInfoOffsets[i];
        byte b = this.classFileBuffer[i3 - 1];
        switch (b) {
            case 3:
                return Integer.valueOf(readInt(i3));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(readInt(i3)));
            case 5:
                return Long.valueOf(readLong(i3));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(readLong(i3)));
            case 7:
                return Type.getObjectType(readUTF8(i3, cArr));
            case 8:
                return readUTF8(i3, cArr);
            default:
                switch (b) {
                    case 15:
                        int i4 = readByte(i3);
                        int i5 = this.cpInfoOffsets[readUnsignedShort(i3 + 1)];
                        int i6 = this.cpInfoOffsets[readUnsignedShort(i5 + 2)];
                        return new Handle(i4, readClass(i5, cArr), readUTF8(i6, cArr), readUTF8(i6 + 2, cArr), this.classFileBuffer[i5 - 1] == 11);
                    case 16:
                        return Type.getMethodType(readUTF8(i3, cArr));
                    case 17:
                        return readConstantDynamic(i, cArr);
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    public int readInt(int i) {
        byte[] bArr = this.classFileBuffer;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public Label readLabel(int i, Label[] labelArr) {
        if (labelArr[i] == null) {
            labelArr[i] = new Label();
        }
        return labelArr[i];
    }

    public long readLong(int i) {
        return (((long) readInt(i)) << 32) | (((long) readInt(i + 4)) & 4294967295L);
    }

    public String readModule(int i, char[] cArr) {
        return readStringish(i, cArr);
    }

    public String readPackage(int i, char[] cArr) {
        return readStringish(i, cArr);
    }

    public short readShort(int i) {
        byte[] bArr = this.classFileBuffer;
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public String readUTF8(int i, char[] cArr) {
        int unsignedShort = readUnsignedShort(i);
        if (i == 0 || unsignedShort == 0) {
            return null;
        }
        return readUtf(unsignedShort, cArr);
    }

    public int readUnsignedShort(int i) {
        byte[] bArr = this.classFileBuffer;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public final String readUtf(int i, char[] cArr) {
        String[] strArr = this.constantUtf8Values;
        String str = strArr[i];
        if (str != null) {
            return str;
        }
        int i3 = this.cpInfoOffsets[i];
        String utf = readUtf(i3 + 2, readUnsignedShort(i3), cArr);
        strArr[i] = utf;
        return utf;
    }

    public ClassReader(byte[] bArr, int i, int i3) {
        this(bArr, i, true);
    }

    public void accept(ClassVisitor classVisitor, Attribute[] attributeArr, int i) {
        Context context;
        ClassReader classReader;
        Context context2;
        String str;
        int i3;
        int i4;
        String utf8;
        int i5;
        String str2;
        String str3;
        int i6;
        Context context3 = new Context();
        context3.attributePrototypes = attributeArr;
        context3.parsingOptions = i;
        char[] cArr = new char[this.maxStringLength];
        context3.charBuffer = cArr;
        int i7 = this.header;
        int unsignedShort = readUnsignedShort(i7);
        String str4 = readClass(i7 + 2, cArr);
        String str5 = readClass(i7 + 4, cArr);
        int unsignedShort2 = readUnsignedShort(i7 + 6);
        String[] strArr = new String[unsignedShort2];
        int i8 = i7 + 8;
        for (int i9 = 0; i9 < unsignedShort2; i9++) {
            strArr[i9] = readClass(i8, cArr);
            i8 += 2;
        }
        int firstAttributeOffset = getFirstAttributeOffset();
        int unsignedShort3 = readUnsignedShort(firstAttributeOffset - 2);
        String str6 = null;
        String utf = null;
        String str7 = null;
        int i10 = 0;
        int i11 = 0;
        String utf82 = null;
        int i12 = 0;
        int i13 = 0;
        String str8 = null;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        Attribute attribute = null;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        while (unsignedShort3 > 0) {
            int i21 = firstAttributeOffset;
            String utf83 = readUTF8(i21, cArr);
            int i22 = readInt(i21 + 2);
            String str9 = str6;
            int i23 = i21 + 6;
            String str10 = utf;
            if (AttSourceFile.ATTRIBUTE_NAME.equals(utf83)) {
                utf8 = readUTF8(i23, cArr);
                i6 = unsignedShort;
                i4 = i23;
                str2 = str4;
                utf = str10;
                i5 = i22;
                context2 = context3;
            } else {
                if (AttInnerClasses.ATTRIBUTE_NAME.equals(utf83)) {
                    i6 = unsignedShort;
                    i4 = i23;
                    i19 = i4;
                } else if (AttEnclosingMethod.ATTRIBUTE_NAME.equals(utf83)) {
                    i6 = unsignedShort;
                    i4 = i23;
                    i11 = i4;
                } else {
                    if ("NestHost".equals(utf83)) {
                        str7 = readClass(i23, cArr);
                    } else if ("NestMembers".equals(utf83)) {
                        i6 = unsignedShort;
                        i4 = i23;
                        i17 = i4;
                    } else if ("PermittedSubclasses".equals(utf83)) {
                        i6 = unsignedShort;
                        i4 = i23;
                        i18 = i4;
                    } else if (AttSignature.ATTRIBUTE_NAME.equals(utf83)) {
                        utf82 = readUTF8(i23, cArr);
                    } else if (AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME.equals(utf83)) {
                        i6 = unsignedShort;
                        i4 = i23;
                        i10 = i4;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(utf83)) {
                        i6 = unsignedShort;
                        i4 = i23;
                        i15 = i4;
                    } else {
                        if (AttDeprecated.ATTRIBUTE_NAME.equals(utf83)) {
                            i6 = 131072 | unsignedShort;
                        } else if (AttSynthetic.ATTRIBUTE_NAME.equals(utf83)) {
                            i6 = unsignedShort | 4096;
                        } else if (AttSourceDebugExtension.ATTRIBUTE_NAME.equals(utf83)) {
                            if (i22 > this.classFileBuffer.length - i23) {
                                throw new IllegalArgumentException();
                            }
                            utf = readUtf(i23, i22, new char[i22]);
                            i6 = unsignedShort;
                            i4 = i23;
                            context2 = context3;
                            utf8 = str9;
                            i5 = i22;
                            str2 = str4;
                        } else if (AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME.equals(utf83)) {
                            i6 = unsignedShort;
                            i4 = i23;
                            i14 = i4;
                        } else if ("RuntimeInvisibleTypeAnnotations".equals(utf83)) {
                            i6 = unsignedShort;
                            i4 = i23;
                            i16 = i4;
                        } else if ("Record".equals(utf83)) {
                            i6 = 65536 | unsignedShort;
                            i4 = i23;
                            i20 = i4;
                        } else if ("Module".equals(utf83)) {
                            i6 = unsignedShort;
                            i4 = i23;
                            i12 = i4;
                        } else if ("ModuleMainClass".equals(utf83)) {
                            str8 = readClass(i23, cArr);
                        } else if ("ModulePackages".equals(utf83)) {
                            i6 = unsignedShort;
                            i4 = i23;
                            i13 = i4;
                        } else {
                            if (AttBootstrapMethods.ATTRIBUTE_NAME.equals(utf83)) {
                                context2 = context3;
                                str = str10;
                                i3 = unsignedShort;
                                i4 = i23;
                                utf8 = str9;
                                i5 = i22;
                                str2 = str4;
                                str3 = str7;
                            } else {
                                context2 = context3;
                                str = str10;
                                utf8 = str9;
                                str2 = str4;
                                str3 = str7;
                                i3 = unsignedShort;
                                i4 = i23;
                                i5 = i22;
                                Attribute attribute2 = readAttribute(attributeArr, utf83, i4, i5, cArr, -1, null);
                                attribute2.nextAttribute = attribute;
                                attribute = attribute2;
                            }
                            utf = str;
                            str7 = str3;
                            i6 = i3;
                        }
                        i4 = i23;
                    }
                    i6 = unsignedShort;
                    i4 = i23;
                }
                utf = str10;
                utf8 = str9;
                i5 = i22;
                context2 = context3;
                str2 = str4;
            }
            int i24 = i4 + i5;
            unsignedShort3--;
            unsignedShort = i6;
            str6 = utf8;
            context3 = context2;
            str4 = str2;
            firstAttributeOffset = i24;
        }
        String str11 = str6;
        Context context4 = context3;
        String str12 = str4;
        String str13 = utf;
        String str14 = str7;
        Attribute attribute3 = attribute;
        classVisitor.visit(readInt(this.cpInfoOffsets[1] - 7), unsignedShort, str12, utf82, str5, strArr);
        if ((i & 2) == 0 && (str11 != null || str13 != null)) {
            classVisitor.visitSource(str11, str13);
        }
        if (i12 != 0) {
            context = context4;
            classReader = this;
            classReader.readModuleAttributes(classVisitor, context, i12, i13, str8);
        } else {
            context = context4;
            classReader = this;
        }
        if (str14 != null) {
            classVisitor.visitNestHost(str14);
        }
        if (i11 != 0) {
            String str15 = classReader.readClass(i11, cArr);
            int unsignedShort4 = classReader.readUnsignedShort(i11 + 2);
            classVisitor.visitOuterClass(str15, unsignedShort4 == 0 ? null : classReader.readUTF8(classReader.cpInfoOffsets[unsignedShort4], cArr), unsignedShort4 == 0 ? null : classReader.readUTF8(classReader.cpInfoOffsets[unsignedShort4] + 2, cArr));
        }
        if (i10 != 0) {
            int unsignedShort5 = classReader.readUnsignedShort(i10);
            int elementValues = i10 + 2;
            while (true) {
                int i25 = unsignedShort5 - 1;
                if (unsignedShort5 <= 0) {
                    break;
                }
                elementValues = classReader.readElementValues(classVisitor.visitAnnotation(classReader.readUTF8(elementValues, cArr), true), elementValues + 2, true, cArr);
                unsignedShort5 = i25;
            }
        }
        int i26 = i14;
        if (i26 != 0) {
            int unsignedShort6 = classReader.readUnsignedShort(i26);
            int elementValues2 = i26 + 2;
            while (true) {
                int i27 = unsignedShort6 - 1;
                if (unsignedShort6 <= 0) {
                    break;
                }
                elementValues2 = classReader.readElementValues(classVisitor.visitAnnotation(classReader.readUTF8(elementValues2, cArr), false), elementValues2 + 2, true, cArr);
                unsignedShort6 = i27;
            }
        }
        int i28 = i15;
        if (i28 != 0) {
            int unsignedShort7 = classReader.readUnsignedShort(i28);
            int elementValues3 = i28 + 2;
            while (true) {
                int i29 = unsignedShort7 - 1;
                if (unsignedShort7 <= 0) {
                    break;
                }
                int typeAnnotationTarget = classReader.readTypeAnnotationTarget(context, elementValues3);
                elementValues3 = classReader.readElementValues(classVisitor.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, classReader.readUTF8(typeAnnotationTarget, cArr), true), typeAnnotationTarget + 2, true, cArr);
                unsignedShort7 = i29;
            }
        }
        int i30 = i16;
        if (i30 != 0) {
            int unsignedShort8 = classReader.readUnsignedShort(i30);
            int elementValues4 = i30 + 2;
            while (true) {
                int i31 = unsignedShort8 - 1;
                if (unsignedShort8 <= 0) {
                    break;
                }
                int typeAnnotationTarget2 = classReader.readTypeAnnotationTarget(context, elementValues4);
                elementValues4 = classReader.readElementValues(classVisitor.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, classReader.readUTF8(typeAnnotationTarget2, cArr), false), typeAnnotationTarget2 + 2, true, cArr);
                unsignedShort8 = i31;
            }
        }
        while (attribute3 != null) {
            Attribute attribute4 = attribute3.nextAttribute;
            attribute3.nextAttribute = null;
            classVisitor.visitAttribute(attribute3);
            attribute3 = attribute4;
        }
        int i32 = i17;
        if (i32 != 0) {
            int unsignedShort9 = classReader.readUnsignedShort(i32);
            int i33 = i32 + 2;
            while (true) {
                int i34 = unsignedShort9 - 1;
                if (unsignedShort9 <= 0) {
                    break;
                }
                classVisitor.visitNestMember(classReader.readClass(i33, cArr));
                i33 += 2;
                unsignedShort9 = i34;
            }
        }
        int i35 = i18;
        if (i35 != 0) {
            int unsignedShort10 = classReader.readUnsignedShort(i35);
            int i36 = i35 + 2;
            while (true) {
                int i37 = unsignedShort10 - 1;
                if (unsignedShort10 <= 0) {
                    break;
                }
                classVisitor.visitPermittedSubclass(classReader.readClass(i36, cArr));
                i36 += 2;
                unsignedShort10 = i37;
            }
        }
        int i38 = i19;
        if (i38 != 0) {
            int unsignedShort11 = classReader.readUnsignedShort(i38);
            int i39 = i38 + 2;
            while (true) {
                int i40 = unsignedShort11 - 1;
                if (unsignedShort11 <= 0) {
                    break;
                }
                classVisitor.visitInnerClass(classReader.readClass(i39, cArr), classReader.readClass(i39 + 2, cArr), classReader.readUTF8(i39 + 4, cArr), classReader.readUnsignedShort(i39 + 6));
                i39 += 8;
                unsignedShort11 = i40;
            }
        }
        int i41 = i20;
        if (i41 != 0) {
            int unsignedShort12 = classReader.readUnsignedShort(i41);
            int recordComponent = i41 + 2;
            while (true) {
                int i42 = unsignedShort12 - 1;
                if (unsignedShort12 <= 0) {
                    break;
                }
                recordComponent = classReader.readRecordComponent(classVisitor, context, recordComponent);
                unsignedShort12 = i42;
            }
        }
        int unsignedShort13 = classReader.readUnsignedShort(i8);
        int field = i8 + 2;
        while (true) {
            int i43 = unsignedShort13 - 1;
            if (unsignedShort13 <= 0) {
                break;
            }
            field = classReader.readField(classVisitor, context, field);
            unsignedShort13 = i43;
        }
        int unsignedShort14 = classReader.readUnsignedShort(field);
        int method = field + 2;
        while (true) {
            int i44 = unsignedShort14 - 1;
            if (unsignedShort14 <= 0) {
                classVisitor.visitEnd();
                return;
            } else {
                method = classReader.readMethod(classVisitor, context, method);
                unsignedShort14 = i44;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060 A[PHI: r8
      0x0060: PHI (r8v3 int) = (r8v0 int), (r8v1 int), (r8v4 int) binds: [B:12:0x004f, B:22:0x006c, B:18:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ClassReader(byte[] r11, int r12, boolean r13) {
        /*
            r10 = this;
            r10.<init>()
            r10.classFileBuffer = r11
            r10.b = r11
            if (r13 == 0) goto L2c
            int r13 = r12 + 6
            short r0 = r10.readShort(r13)
            r1 = 64
            if (r0 > r1) goto L14
            goto L2c
        L14:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Unsupported class file major version "
            r12.<init>(r0)
            short r13 = r10.readShort(r13)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L2c:
            int r13 = r12 + 8
            int r13 = r10.readUnsignedShort(r13)
            int[] r0 = new int[r13]
            r10.cpInfoOffsets = r0
            java.lang.String[] r0 = new java.lang.String[r13]
            r10.constantUtf8Values = r0
            int r12 = r12 + 10
            r0 = 0
            r1 = 1
            r2 = r0
            r3 = r2
            r4 = r1
        L41:
            if (r4 >= r13) goto L72
            int[] r5 = r10.cpInfoOffsets
            int r6 = r4 + 1
            int r7 = r12 + 1
            r5[r4] = r7
            r5 = r11[r12]
            r8 = 3
            r9 = 5
            switch(r5) {
                case 1: goto L67;
                case 2: goto L52;
                case 3: goto L59;
                case 4: goto L59;
                case 5: goto L62;
                case 6: goto L62;
                case 7: goto L60;
                case 8: goto L60;
                case 9: goto L59;
                case 10: goto L59;
                case 11: goto L59;
                case 12: goto L59;
                case 13: goto L52;
                case 14: goto L52;
                case 15: goto L5f;
                case 16: goto L60;
                case 17: goto L5c;
                case 18: goto L58;
                case 19: goto L60;
                case 20: goto L60;
                default: goto L52;
            }
        L52:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            r11.<init>()
            throw r11
        L58:
            r3 = r1
        L59:
            r4 = r6
            r8 = r9
            goto L70
        L5c:
            r2 = r1
            r3 = r2
            goto L59
        L5f:
            r8 = 4
        L60:
            r4 = r6
            goto L70
        L62:
            int r4 = r4 + 2
            r8 = 9
            goto L70
        L67:
            int r4 = r10.readUnsignedShort(r7)
            int r8 = r8 + r4
            if (r8 <= r0) goto L60
            r4 = r6
            r0 = r8
        L70:
            int r12 = r12 + r8
            goto L41
        L72:
            r10.maxStringLength = r0
            r10.header = r12
            r11 = 0
            if (r2 == 0) goto L7c
            net.bytebuddy.jar.asm.ConstantDynamic[] r12 = new net.bytebuddy.jar.asm.ConstantDynamic[r13]
            goto L7d
        L7c:
            r12 = r11
        L7d:
            r10.constantDynamicValues = r12
            if (r3 == 0) goto L85
            int[] r11 = r10.readBootstrapMethodsAttribute(r0)
        L85:
            r10.bootstrapMethodOffsets = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.ClassReader.<init>(byte[], int, boolean):void");
    }

    private String readUtf(int i, int i3, char[] cArr) {
        int i4;
        int i5 = i3 + i;
        byte[] bArr = this.classFileBuffer;
        int i6 = 0;
        while (i < i5) {
            int i7 = i + 1;
            byte b = bArr[i];
            if ((b & 128) == 0) {
                cArr[i6] = (char) (b & 127);
                i6++;
                i = i7;
            } else {
                if ((b & 224) == 192) {
                    i4 = i6 + 1;
                    i += 2;
                    cArr[i6] = (char) (((b & 31) << 6) + (bArr[i7] & 63));
                } else {
                    i4 = i6 + 1;
                    int i8 = i + 2;
                    i += 3;
                    cArr[i6] = (char) (((b & 15) << 12) + ((bArr[i7] & 63) << 6) + (bArr[i8] & 63));
                }
                i6 = i4;
            }
        }
        return new String(cArr, 0, i6);
    }

    public ClassReader(InputStream inputStream) {
        this(readStream(inputStream, false));
    }

    public ClassReader(String str) {
        this(readStream(ClassLoader.getSystemResourceAsStream(str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR) + ".class"), true));
    }
}
