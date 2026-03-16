package com.android.dx.cf.direct;

import B2.b;
import androidx.constraintlayout.core.motion.a;
import com.android.dx.cf.attrib.AttAnnotationDefault;
import com.android.dx.cf.attrib.AttBootstrapMethods;
import com.android.dx.cf.attrib.AttCode;
import com.android.dx.cf.attrib.AttConstantValue;
import com.android.dx.cf.attrib.AttDeprecated;
import com.android.dx.cf.attrib.AttEnclosingMethod;
import com.android.dx.cf.attrib.AttExceptions;
import com.android.dx.cf.attrib.AttInnerClasses;
import com.android.dx.cf.attrib.AttLineNumberTable;
import com.android.dx.cf.attrib.AttLocalVariableTable;
import com.android.dx.cf.attrib.AttLocalVariableTypeTable;
import com.android.dx.cf.attrib.AttRuntimeInvisibleAnnotations;
import com.android.dx.cf.attrib.AttRuntimeInvisibleParameterAnnotations;
import com.android.dx.cf.attrib.AttRuntimeVisibleAnnotations;
import com.android.dx.cf.attrib.AttRuntimeVisibleParameterAnnotations;
import com.android.dx.cf.attrib.AttSignature;
import com.android.dx.cf.attrib.AttSourceDebugExtension;
import com.android.dx.cf.attrib.AttSourceFile;
import com.android.dx.cf.attrib.AttSynthetic;
import com.android.dx.cf.attrib.InnerClassList;
import com.android.dx.cf.code.BootstrapMethodArgumentsList;
import com.android.dx.cf.code.BootstrapMethodsList;
import com.android.dx.cf.code.ByteCatchList;
import com.android.dx.cf.code.BytecodeArray;
import com.android.dx.cf.code.LineNumberList;
import com.android.dx.cf.code.LocalVariableList;
import com.android.dx.cf.iface.Attribute;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.cf.iface.StdAttributeList;
import com.android.dx.rop.annotation.AnnotationVisibility;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstMethodHandle;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.TypedConstant;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class StdAttributeFactory extends AttributeFactory {
    public static final StdAttributeFactory THE_ONE = new StdAttributeFactory();

    private Attribute annotationDefault(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 < 2) {
            throwSeverelyTruncated();
        }
        return new AttAnnotationDefault(new AnnotationParser(directClassFile, i, i3, parseObserver).parseValueAttribute(), i3);
    }

    private Attribute bootstrapMethods(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile.getBytes();
        int unsignedShort = bytes.getUnsignedShort(i);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i, 2, a.z(unsignedShort, new StringBuilder("num_boostrap_methods: ")));
        }
        return new AttBootstrapMethods(parseBootstrapMethods(bytes, directClassFile.getConstantPool(), directClassFile.getThisClass(), unsignedShort, i + 2, i3 - 2, parseObserver));
    }

    private Attribute code(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 < 12) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile.getBytes();
        ConstantPool constantPool = directClassFile.getConstantPool();
        int unsignedShort = bytes.getUnsignedShort(i);
        int i4 = i + 2;
        int unsignedShort2 = bytes.getUnsignedShort(i4);
        int i5 = i + 4;
        int i6 = bytes.getInt(i5);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i, 2, a.z(unsignedShort, new StringBuilder("max_stack: ")));
            parseObserver.parsed(bytes, i4, 2, a.z(unsignedShort2, new StringBuilder("max_locals: ")));
            parseObserver.parsed(bytes, i5, 4, "code_length: " + Hex.u4(i6));
        }
        int i7 = i + 8;
        int i8 = i3 - 8;
        if (i8 < i6 + 4) {
            return throwTruncated();
        }
        int i9 = i7 + i6;
        int i10 = i8 - i6;
        BytecodeArray bytecodeArray = new BytecodeArray(bytes.slice(i7, i9), constantPool);
        if (parseObserver != null) {
            bytecodeArray.forEach(new CodeObserver(bytecodeArray.getBytes(), parseObserver));
        }
        int unsignedShort3 = bytes.getUnsignedShort(i9);
        ByteCatchList byteCatchList = unsignedShort3 == 0 ? ByteCatchList.EMPTY : new ByteCatchList(unsignedShort3);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i9, 2, a.z(unsignedShort3, new StringBuilder("exception_table_length: ")));
        }
        int i11 = i9 + 2;
        int i12 = i10 - 2;
        if (i12 < (unsignedShort3 * 8) + 2) {
            return throwTruncated();
        }
        for (int i13 = 0; i13 < unsignedShort3; i13++) {
            if (parseObserver != null) {
                parseObserver.changeIndent(1);
            }
            int unsignedShort4 = bytes.getUnsignedShort(i11);
            int unsignedShort5 = bytes.getUnsignedShort(i11 + 2);
            int unsignedShort6 = bytes.getUnsignedShort(i11 + 4);
            CstType cstType = (CstType) constantPool.get0Ok(bytes.getUnsignedShort(i11 + 6));
            byteCatchList.set(i13, unsignedShort4, unsignedShort5, unsignedShort6, cstType);
            if (parseObserver != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(Hex.u2(unsignedShort4));
                sb.append("..");
                sb.append(Hex.u2(unsignedShort5));
                sb.append(" -> ");
                sb.append(Hex.u2(unsignedShort6));
                sb.append(" ");
                sb.append(cstType == null ? "<any>" : cstType.toHuman());
                parseObserver.parsed(bytes, i11, 8, sb.toString());
            }
            i11 += 8;
            i12 -= 8;
            if (parseObserver != null) {
                parseObserver.changeIndent(-1);
            }
        }
        byteCatchList.setImmutable();
        AttributeListParser attributeListParser = new AttributeListParser(directClassFile, 3, i11, this);
        attributeListParser.setObserver(parseObserver);
        StdAttributeList list = attributeListParser.getList();
        list.setImmutable();
        int endOffset = attributeListParser.getEndOffset() - i11;
        return endOffset != i12 ? throwBadLength((i11 - i) + endOffset) : new AttCode(unsignedShort, unsignedShort2, bytecodeArray, byteCatchList, list);
    }

    private Attribute constantValue(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 != 2) {
            return throwBadLength(2);
        }
        ByteArray bytes = directClassFile.getBytes();
        TypedConstant typedConstant = (TypedConstant) directClassFile.getConstantPool().get(bytes.getUnsignedShort(i));
        AttConstantValue attConstantValue = new AttConstantValue(typedConstant);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i, 2, "value: " + typedConstant);
        }
        return attConstantValue;
    }

    private Attribute deprecated(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        return i3 != 0 ? throwBadLength(0) : new AttDeprecated();
    }

    private Attribute enclosingMethod(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 != 4) {
            throwBadLength(4);
        }
        ByteArray bytes = directClassFile.getBytes();
        ConstantPool constantPool = directClassFile.getConstantPool();
        CstType cstType = (CstType) constantPool.get(bytes.getUnsignedShort(i));
        int i4 = i + 2;
        CstNat cstNat = (CstNat) constantPool.get0Ok(bytes.getUnsignedShort(i4));
        AttEnclosingMethod attEnclosingMethod = new AttEnclosingMethod(cstType, cstNat);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i, 2, "class: " + cstType);
            parseObserver.parsed(bytes, i4, 2, "method: " + DirectClassFile.stringOrNone(cstNat));
        }
        return attEnclosingMethod;
    }

    private Attribute exceptions(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile.getBytes();
        int unsignedShort = bytes.getUnsignedShort(i);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i, 2, a.z(unsignedShort, new StringBuilder("number_of_exceptions: ")));
        }
        int i4 = i + 2;
        int i5 = unsignedShort * 2;
        if (i3 - 2 != i5) {
            throwBadLength(i5 + 2);
        }
        return new AttExceptions(directClassFile.makeTypeList(i4, unsignedShort));
    }

    private Attribute innerClasses(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile.getBytes();
        ConstantPool constantPool = directClassFile.getConstantPool();
        int unsignedShort = bytes.getUnsignedShort(i);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i, 2, a.z(unsignedShort, new StringBuilder("number_of_classes: ")));
        }
        int i4 = i + 2;
        int i5 = unsignedShort * 8;
        if (i3 - 2 != i5) {
            throwBadLength(i5 + 2);
        }
        InnerClassList innerClassList = new InnerClassList(unsignedShort);
        for (int i6 = 0; i6 < unsignedShort; i6++) {
            int unsignedShort2 = bytes.getUnsignedShort(i4);
            int i7 = i4 + 2;
            int unsignedShort3 = bytes.getUnsignedShort(i7);
            int i8 = i4 + 4;
            int unsignedShort4 = bytes.getUnsignedShort(i8);
            int i9 = i4 + 6;
            int unsignedShort5 = bytes.getUnsignedShort(i9);
            CstType cstType = (CstType) constantPool.get(unsignedShort2);
            CstType cstType2 = (CstType) constantPool.get0Ok(unsignedShort3);
            CstString cstString = (CstString) constantPool.get0Ok(unsignedShort4);
            innerClassList.set(i6, cstType, cstType2, cstString, unsignedShort5);
            if (parseObserver != null) {
                parseObserver.parsed(bytes, i4, 2, "inner_class: " + DirectClassFile.stringOrNone(cstType));
                parseObserver.parsed(bytes, i7, 2, "  outer_class: " + DirectClassFile.stringOrNone(cstType2));
                parseObserver.parsed(bytes, i8, 2, "  name: " + DirectClassFile.stringOrNone(cstString));
                parseObserver.parsed(bytes, i9, 2, "  access_flags: " + AccessFlags.innerClassString(unsignedShort5));
            }
            i4 += 8;
        }
        innerClassList.setImmutable();
        return new AttInnerClasses(innerClassList);
    }

    private Attribute lineNumberTable(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile.getBytes();
        int unsignedShort = bytes.getUnsignedShort(i);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i, 2, a.z(unsignedShort, new StringBuilder("line_number_table_length: ")));
        }
        int i4 = i + 2;
        int i5 = unsignedShort * 4;
        if (i3 - 2 != i5) {
            throwBadLength(i5 + 2);
        }
        LineNumberList lineNumberList = new LineNumberList(unsignedShort);
        for (int i6 = 0; i6 < unsignedShort; i6++) {
            int unsignedShort2 = bytes.getUnsignedShort(i4);
            int unsignedShort3 = bytes.getUnsignedShort(i4 + 2);
            lineNumberList.set(i6, unsignedShort2, unsignedShort3);
            if (parseObserver != null) {
                parseObserver.parsed(bytes, i4, 4, Hex.u2(unsignedShort2) + " " + unsignedShort3);
            }
            i4 += 4;
        }
        lineNumberList.setImmutable();
        return new AttLineNumberTable(lineNumberList);
    }

    private Attribute localVariableTable(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile.getBytes();
        int unsignedShort = bytes.getUnsignedShort(i);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i, 2, a.z(unsignedShort, new StringBuilder("local_variable_table_length: ")));
        }
        return new AttLocalVariableTable(parseLocalVariables(bytes.slice(i + 2, i + i3), directClassFile.getConstantPool(), parseObserver, unsignedShort, false));
    }

    private Attribute localVariableTypeTable(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile.getBytes();
        int unsignedShort = bytes.getUnsignedShort(i);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i, 2, a.z(unsignedShort, new StringBuilder("local_variable_type_table_length: ")));
        }
        return new AttLocalVariableTypeTable(parseLocalVariables(bytes.slice(i + 2, i + i3), directClassFile.getConstantPool(), parseObserver, unsignedShort, true));
    }

    private BootstrapMethodsList parseBootstrapMethods(ByteArray byteArray, ConstantPool constantPool, CstType cstType, int i, int i3, int i4, ParseObserver parseObserver) {
        BootstrapMethodsList bootstrapMethodsList = new BootstrapMethodsList(i);
        int i5 = i3;
        int i6 = i4;
        for (int i7 = 0; i7 < i; i7++) {
            if (i6 < 4) {
                throwTruncated();
            }
            int unsignedShort = byteArray.getUnsignedShort(i5);
            int i8 = i5 + 2;
            int unsignedShort2 = byteArray.getUnsignedShort(i8);
            if (parseObserver != null) {
                parseObserver.parsed(byteArray, i5, 2, a.z(unsignedShort, new StringBuilder("bootstrap_method_ref: ")));
                parseObserver.parsed(byteArray, i8, 2, a.z(unsignedShort2, new StringBuilder("num_bootstrap_arguments: ")));
            }
            i5 += 4;
            i6 -= 4;
            if (i6 < unsignedShort2 * 2) {
                throwTruncated();
            }
            BootstrapMethodArgumentsList bootstrapMethodArgumentsList = new BootstrapMethodArgumentsList(unsignedShort2);
            int i9 = 0;
            while (i9 < unsignedShort2) {
                int unsignedShort3 = byteArray.getUnsignedShort(i5);
                if (parseObserver != null) {
                    parseObserver.parsed(byteArray, i5, 2, a.z(unsignedShort3, b.j(i9, "bootstrap_arguments[", "]")));
                }
                bootstrapMethodArgumentsList.set(i9, constantPool.get(unsignedShort3));
                i9++;
                i5 += 2;
                i6 -= 2;
            }
            bootstrapMethodArgumentsList.setImmutable();
            bootstrapMethodsList.set(i7, cstType, (CstMethodHandle) constantPool.get(unsignedShort), bootstrapMethodArgumentsList);
        }
        bootstrapMethodsList.setImmutable();
        if (i6 != 0) {
            throwBadLength(i6);
        }
        return bootstrapMethodsList;
    }

    private LocalVariableList parseLocalVariables(ByteArray byteArray, ConstantPool constantPool, ParseObserver parseObserver, int i, boolean z6) {
        CstString cstString;
        int i3 = i * 10;
        if (byteArray.size() != i3) {
            throwBadLength(i3 + 2);
        }
        ByteArray.MyDataInputStream myDataInputStreamMakeDataInputStream = byteArray.makeDataInputStream();
        LocalVariableList localVariableList = new LocalVariableList(i);
        for (int i4 = 0; i4 < i; i4++) {
            try {
                int unsignedShort = myDataInputStreamMakeDataInputStream.readUnsignedShort();
                int unsignedShort2 = myDataInputStreamMakeDataInputStream.readUnsignedShort();
                int unsignedShort3 = myDataInputStreamMakeDataInputStream.readUnsignedShort();
                int unsignedShort4 = myDataInputStreamMakeDataInputStream.readUnsignedShort();
                int unsignedShort5 = myDataInputStreamMakeDataInputStream.readUnsignedShort();
                CstString cstString2 = (CstString) constantPool.get(unsignedShort3);
                CstString cstString3 = (CstString) constantPool.get(unsignedShort4);
                CstString cstString4 = null;
                if (z6) {
                    cstString = cstString3;
                } else {
                    cstString = null;
                    cstString4 = cstString3;
                }
                localVariableList.set(i4, unsignedShort, unsignedShort2, cstString2, cstString4, cstString, unsignedShort5);
                if (parseObserver != null) {
                    parseObserver.parsed(byteArray, i4 * 10, 10, Hex.u2(unsignedShort) + ".." + Hex.u2(unsignedShort + unsignedShort2) + " " + Hex.u2(unsignedShort5) + " " + cstString2.toHuman() + " " + cstString3.toHuman());
                }
            } catch (IOException e) {
                throw new RuntimeException("shouldn't happen", e);
            }
        }
        localVariableList.setImmutable();
        return localVariableList;
    }

    private Attribute runtimeInvisibleAnnotations(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 < 2) {
            throwSeverelyTruncated();
        }
        return new AttRuntimeInvisibleAnnotations(new AnnotationParser(directClassFile, i, i3, parseObserver).parseAnnotationAttribute(AnnotationVisibility.BUILD), i3);
    }

    private Attribute runtimeInvisibleParameterAnnotations(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 < 2) {
            throwSeverelyTruncated();
        }
        return new AttRuntimeInvisibleParameterAnnotations(new AnnotationParser(directClassFile, i, i3, parseObserver).parseParameterAttribute(AnnotationVisibility.BUILD), i3);
    }

    private Attribute runtimeVisibleAnnotations(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 < 2) {
            throwSeverelyTruncated();
        }
        return new AttRuntimeVisibleAnnotations(new AnnotationParser(directClassFile, i, i3, parseObserver).parseAnnotationAttribute(AnnotationVisibility.RUNTIME), i3);
    }

    private Attribute runtimeVisibleParameterAnnotations(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 < 2) {
            throwSeverelyTruncated();
        }
        return new AttRuntimeVisibleParameterAnnotations(new AnnotationParser(directClassFile, i, i3, parseObserver).parseParameterAttribute(AnnotationVisibility.RUNTIME), i3);
    }

    private Attribute signature(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 != 2) {
            throwBadLength(2);
        }
        ByteArray bytes = directClassFile.getBytes();
        CstString cstString = (CstString) directClassFile.getConstantPool().get(bytes.getUnsignedShort(i));
        AttSignature attSignature = new AttSignature(cstString);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i, 2, "signature: " + cstString);
        }
        return attSignature;
    }

    private Attribute sourceDebugExtension(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        ByteArray byteArraySlice = directClassFile.getBytes().slice(i, i + i3);
        CstString cstString = new CstString(byteArraySlice);
        AttSourceDebugExtension attSourceDebugExtension = new AttSourceDebugExtension(cstString);
        if (parseObserver != null) {
            parseObserver.parsed(byteArraySlice, i, i3, a.p("sourceDebugExtension: ", cstString.getString()));
        }
        return attSourceDebugExtension;
    }

    private Attribute sourceFile(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        if (i3 != 2) {
            throwBadLength(2);
        }
        ByteArray bytes = directClassFile.getBytes();
        CstString cstString = (CstString) directClassFile.getConstantPool().get(bytes.getUnsignedShort(i));
        AttSourceFile attSourceFile = new AttSourceFile(cstString);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i, 2, "source: " + cstString);
        }
        return attSourceFile;
    }

    private Attribute synthetic(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        return i3 != 0 ? throwBadLength(0) : new AttSynthetic();
    }

    private static Attribute throwBadLength(int i) {
        throw new ParseException("bad attribute length; expected length " + Hex.u4(i));
    }

    private static Attribute throwSeverelyTruncated() {
        throw new ParseException("severely truncated attribute");
    }

    private static Attribute throwTruncated() {
        throw new ParseException("truncated attribute");
    }

    @Override // com.android.dx.cf.direct.AttributeFactory
    public Attribute parse0(DirectClassFile directClassFile, int i, String str, int i3, int i4, ParseObserver parseObserver) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        if (str == AttLineNumberTable.ATTRIBUTE_NAME) {
                            return lineNumberTable(directClassFile, i3, i4, parseObserver);
                        }
                        if (str == AttLocalVariableTable.ATTRIBUTE_NAME) {
                            return localVariableTable(directClassFile, i3, i4, parseObserver);
                        }
                        if (str == AttLocalVariableTypeTable.ATTRIBUTE_NAME) {
                            return localVariableTypeTable(directClassFile, i3, i4, parseObserver);
                        }
                    }
                } else {
                    if (str == AttAnnotationDefault.ATTRIBUTE_NAME) {
                        return annotationDefault(directClassFile, i3, i4, parseObserver);
                    }
                    if (str == AttCode.ATTRIBUTE_NAME) {
                        return code(directClassFile, i3, i4, parseObserver);
                    }
                    if (str == AttDeprecated.ATTRIBUTE_NAME) {
                        return deprecated(directClassFile, i3, i4, parseObserver);
                    }
                    if (str == AttExceptions.ATTRIBUTE_NAME) {
                        return exceptions(directClassFile, i3, i4, parseObserver);
                    }
                    if (str == AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME) {
                        return runtimeInvisibleAnnotations(directClassFile, i3, i4, parseObserver);
                    }
                    if (str == AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME) {
                        return runtimeVisibleAnnotations(directClassFile, i3, i4, parseObserver);
                    }
                    if (str == AttRuntimeInvisibleParameterAnnotations.ATTRIBUTE_NAME) {
                        return runtimeInvisibleParameterAnnotations(directClassFile, i3, i4, parseObserver);
                    }
                    if (str == AttRuntimeVisibleParameterAnnotations.ATTRIBUTE_NAME) {
                        return runtimeVisibleParameterAnnotations(directClassFile, i3, i4, parseObserver);
                    }
                    if (str == AttSignature.ATTRIBUTE_NAME) {
                        return signature(directClassFile, i3, i4, parseObserver);
                    }
                    if (str == AttSynthetic.ATTRIBUTE_NAME) {
                        return synthetic(directClassFile, i3, i4, parseObserver);
                    }
                }
            } else {
                if (str == AttConstantValue.ATTRIBUTE_NAME) {
                    return constantValue(directClassFile, i3, i4, parseObserver);
                }
                if (str == AttDeprecated.ATTRIBUTE_NAME) {
                    return deprecated(directClassFile, i3, i4, parseObserver);
                }
                if (str == AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME) {
                    return runtimeInvisibleAnnotations(directClassFile, i3, i4, parseObserver);
                }
                if (str == AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME) {
                    return runtimeVisibleAnnotations(directClassFile, i3, i4, parseObserver);
                }
                if (str == AttSignature.ATTRIBUTE_NAME) {
                    return signature(directClassFile, i3, i4, parseObserver);
                }
                if (str == AttSynthetic.ATTRIBUTE_NAME) {
                    return synthetic(directClassFile, i3, i4, parseObserver);
                }
            }
        } else {
            if (str == AttBootstrapMethods.ATTRIBUTE_NAME) {
                return bootstrapMethods(directClassFile, i3, i4, parseObserver);
            }
            if (str == AttDeprecated.ATTRIBUTE_NAME) {
                return deprecated(directClassFile, i3, i4, parseObserver);
            }
            if (str == AttEnclosingMethod.ATTRIBUTE_NAME) {
                return enclosingMethod(directClassFile, i3, i4, parseObserver);
            }
            if (str == AttInnerClasses.ATTRIBUTE_NAME) {
                return innerClasses(directClassFile, i3, i4, parseObserver);
            }
            if (str == AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME) {
                return runtimeInvisibleAnnotations(directClassFile, i3, i4, parseObserver);
            }
            if (str == AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME) {
                return runtimeVisibleAnnotations(directClassFile, i3, i4, parseObserver);
            }
            if (str == AttSynthetic.ATTRIBUTE_NAME) {
                return synthetic(directClassFile, i3, i4, parseObserver);
            }
            if (str == AttSignature.ATTRIBUTE_NAME) {
                return signature(directClassFile, i3, i4, parseObserver);
            }
            if (str == AttSourceDebugExtension.ATTRIBUTE_NAME) {
                return sourceDebugExtension(directClassFile, i3, i4, parseObserver);
            }
            if (str == AttSourceFile.ATTRIBUTE_NAME) {
                return sourceFile(directClassFile, i3, i4, parseObserver);
            }
        }
        return super.parse0(directClassFile, i, str, i3, i4, parseObserver);
    }
}
