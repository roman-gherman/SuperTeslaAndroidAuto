package com.android.dx.dex.file;

import com.android.dx.rop.annotation.Annotation;
import com.android.dx.rop.annotation.AnnotationVisibility;
import com.android.dx.rop.annotation.NameValuePair;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstAnnotation;
import com.android.dx.rop.cst.CstArray;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstKnownNull;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AnnotationUtils {
    private static final CstType ANNOTATION_DEFAULT_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/AnnotationDefault;"));
    private static final CstType ENCLOSING_CLASS_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/EnclosingClass;"));
    private static final CstType ENCLOSING_METHOD_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/EnclosingMethod;"));
    private static final CstType INNER_CLASS_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/InnerClass;"));
    private static final CstType MEMBER_CLASSES_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/MemberClasses;"));
    private static final CstType SIGNATURE_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/Signature;"));
    private static final CstType SOURCE_DEBUG_EXTENSION_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/SourceDebugExtension;"));
    private static final CstType THROWS_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/Throws;"));
    private static final CstString ACCESS_FLAGS_STRING = new CstString("accessFlags");
    private static final CstString NAME_STRING = new CstString("name");
    private static final CstString VALUE_STRING = new CstString("value");

    private AnnotationUtils() {
    }

    public static Annotation makeAnnotationDefault(Annotation annotation) {
        Annotation annotation2 = new Annotation(ANNOTATION_DEFAULT_TYPE, AnnotationVisibility.SYSTEM);
        annotation2.put(new NameValuePair(VALUE_STRING, new CstAnnotation(annotation)));
        annotation2.setImmutable();
        return annotation2;
    }

    private static CstArray makeCstArray(TypeList typeList) {
        int size = typeList.size();
        CstArray.List list = new CstArray.List(size);
        for (int i = 0; i < size; i++) {
            list.set(i, CstType.intern(typeList.getType(i)));
        }
        list.setImmutable();
        return new CstArray(list);
    }

    public static Annotation makeEnclosingClass(CstType cstType) {
        Annotation annotation = new Annotation(ENCLOSING_CLASS_TYPE, AnnotationVisibility.SYSTEM);
        annotation.put(new NameValuePair(VALUE_STRING, cstType));
        annotation.setImmutable();
        return annotation;
    }

    public static Annotation makeEnclosingMethod(CstMethodRef cstMethodRef) {
        Annotation annotation = new Annotation(ENCLOSING_METHOD_TYPE, AnnotationVisibility.SYSTEM);
        annotation.put(new NameValuePair(VALUE_STRING, cstMethodRef));
        annotation.setImmutable();
        return annotation;
    }

    public static Annotation makeInnerClass(CstString cstString, int i) {
        Annotation annotation = new Annotation(INNER_CLASS_TYPE, AnnotationVisibility.SYSTEM);
        Constant constant = cstString;
        if (cstString == null) {
            constant = CstKnownNull.THE_ONE;
        }
        annotation.put(new NameValuePair(NAME_STRING, constant));
        annotation.put(new NameValuePair(ACCESS_FLAGS_STRING, CstInteger.make(i)));
        annotation.setImmutable();
        return annotation;
    }

    public static Annotation makeMemberClasses(TypeList typeList) {
        CstArray cstArrayMakeCstArray = makeCstArray(typeList);
        Annotation annotation = new Annotation(MEMBER_CLASSES_TYPE, AnnotationVisibility.SYSTEM);
        annotation.put(new NameValuePair(VALUE_STRING, cstArrayMakeCstArray));
        annotation.setImmutable();
        return annotation;
    }

    public static Annotation makeSignature(CstString cstString) {
        Annotation annotation = new Annotation(SIGNATURE_TYPE, AnnotationVisibility.SYSTEM);
        String string = cstString.getString();
        int length = string.length();
        ArrayList arrayList = new ArrayList(20);
        int i = 0;
        while (i < length) {
            int i3 = i + 1;
            if (string.charAt(i) == 'L') {
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    char cCharAt = string.charAt(i3);
                    if (cCharAt == ';') {
                        i3++;
                        break;
                    }
                    if (cCharAt == '<') {
                        break;
                    }
                    i3++;
                }
            } else {
                while (i3 < length && string.charAt(i3) != 'L') {
                    i3++;
                }
            }
            arrayList.add(string.substring(i, i3));
            i = i3;
        }
        int size = arrayList.size();
        CstArray.List list = new CstArray.List(size);
        for (int i4 = 0; i4 < size; i4++) {
            list.set(i4, new CstString((String) arrayList.get(i4)));
        }
        list.setImmutable();
        annotation.put(new NameValuePair(VALUE_STRING, new CstArray(list)));
        annotation.setImmutable();
        return annotation;
    }

    public static Annotation makeSourceDebugExtension(CstString cstString) {
        Annotation annotation = new Annotation(SOURCE_DEBUG_EXTENSION_TYPE, AnnotationVisibility.SYSTEM);
        annotation.put(new NameValuePair(VALUE_STRING, cstString));
        annotation.setImmutable();
        return annotation;
    }

    public static Annotation makeThrows(TypeList typeList) {
        CstArray cstArrayMakeCstArray = makeCstArray(typeList);
        Annotation annotation = new Annotation(THROWS_TYPE, AnnotationVisibility.SYSTEM);
        annotation.put(new NameValuePair(VALUE_STRING, cstArrayMakeCstArray));
        annotation.setImmutable();
        return annotation;
    }
}
