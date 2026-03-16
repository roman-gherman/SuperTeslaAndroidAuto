package com.google.protobuf.util;

import com.google.common.base.b;
import com.google.common.base.c;
import com.google.common.base.f;
import com.google.common.base.h;
import com.google.common.base.l;
import com.google.common.base.m;
import com.google.common.base.n;
import com.google.common.primitives.a;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.protobuf.Descriptors;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FieldMaskUtil {
    private static final String FIELD_PATH_SEPARATOR = ",";
    private static final String FIELD_PATH_SEPARATOR_REGEX = ",";
    private static final String FIELD_SEPARATOR_REGEX = "\\.";

    public static final class MergeOptions {
        private boolean replaceMessageFields = false;
        private boolean replaceRepeatedFields = false;
        private boolean replacePrimitiveFields = false;

        public boolean replaceMessageFields() {
            return this.replaceMessageFields;
        }

        public boolean replacePrimitiveFields() {
            return this.replacePrimitiveFields;
        }

        public boolean replaceRepeatedFields() {
            return this.replaceRepeatedFields;
        }

        @CanIgnoreReturnValue
        public MergeOptions setReplaceMessageFields(boolean z6) {
            this.replaceMessageFields = z6;
            return this;
        }

        @CanIgnoreReturnValue
        public MergeOptions setReplacePrimitiveFields(boolean z6) {
            this.replacePrimitiveFields = z6;
            return this;
        }

        @CanIgnoreReturnValue
        public MergeOptions setReplaceRepeatedFields(boolean z6) {
            this.replaceRepeatedFields = z6;
            return this;
        }
    }

    private FieldMaskUtil() {
    }

    public static FieldMask fromFieldNumbers(Class<? extends Message> cls, Iterable<Integer> iterable) {
        Descriptors.Descriptor descriptorForType = ((Message) Internal.getDefaultInstance(cls)).getDescriptorForType();
        FieldMask.Builder builderNewBuilder = FieldMask.newBuilder();
        for (Integer num : iterable) {
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByNumber = descriptorForType.findFieldByNumber(num.intValue());
            String str = num + " is not a valid field number for " + cls + ".";
            if (!(fieldDescriptorFindFieldByNumber != null)) {
                throw new IllegalArgumentException(str);
            }
            builderNewBuilder.addPaths(fieldDescriptorFindFieldByNumber.getName());
        }
        return builderNewBuilder.build();
    }

    public static FieldMask fromJsonString(String str) {
        n nVar = new n(new l(new h(",".charAt(0))));
        str.getClass();
        m<String> mVar = new m(nVar, str);
        FieldMask.Builder builderNewBuilder = FieldMask.newBuilder();
        for (String strB : mVar) {
            if (!strB.isEmpty()) {
                b bVar = f.d;
                c cVar = f.e;
                cVar.getClass();
                if (bVar != cVar) {
                    strB = cVar.b(bVar, strB);
                }
                builderNewBuilder.addPaths(strB);
            }
        }
        return builderNewBuilder.build();
    }

    public static FieldMask fromString(String str) {
        return fromStringList(null, Arrays.asList(str.split(",")));
    }

    public static FieldMask fromStringList(Class<? extends Message> cls, Iterable<String> iterable) {
        FieldMask.Builder builderNewBuilder = FieldMask.newBuilder();
        for (String str : iterable) {
            if (!str.isEmpty()) {
                if (cls != null && !isValid(cls, str)) {
                    throw new IllegalArgumentException(str + " is not a valid path for " + cls);
                }
                builderNewBuilder.addPaths(str);
            }
        }
        return builderNewBuilder.build();
    }

    public static FieldMask intersection(FieldMask fieldMask, FieldMask fieldMask2) {
        FieldMaskTree fieldMaskTree = new FieldMaskTree(fieldMask);
        FieldMaskTree fieldMaskTree2 = new FieldMaskTree();
        Iterator<String> it = fieldMask2.getPathsList().iterator();
        while (it.hasNext()) {
            fieldMaskTree.intersectFieldPath(it.next(), fieldMaskTree2);
        }
        return fieldMaskTree2.toFieldMask();
    }

    public static boolean isValid(Class<? extends Message> cls, FieldMask fieldMask) {
        return isValid(((Message) Internal.getDefaultInstance(cls)).getDescriptorForType(), fieldMask);
    }

    public static void merge(FieldMask fieldMask, Message message, Message.Builder builder, MergeOptions mergeOptions) {
        new FieldMaskTree(fieldMask).merge(message, builder, mergeOptions);
    }

    public static FieldMask normalize(FieldMask fieldMask) {
        return new FieldMaskTree(fieldMask).toFieldMask();
    }

    public static String toJsonString(FieldMask fieldMask) {
        ArrayList arrayList = new ArrayList(fieldMask.getPathsCount());
        for (String strB : fieldMask.getPathsList()) {
            if (!strB.isEmpty()) {
                b bVar = f.d;
                c cVar = f.e;
                cVar.getClass();
                if (cVar != bVar) {
                    strB = bVar.b(cVar, strB);
                }
                arrayList.add(strB);
            }
        }
        l lVar = new l(",");
        Iterator it = arrayList.iterator();
        StringBuilder sb = new StringBuilder();
        lVar.a(sb, it);
        return sb.toString();
    }

    public static String toString(FieldMask fieldMask) {
        StringBuilder sb = new StringBuilder();
        boolean z6 = true;
        for (String str : fieldMask.getPathsList()) {
            if (!str.isEmpty()) {
                if (z6) {
                    z6 = false;
                } else {
                    sb.append(",");
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static FieldMask union(FieldMask fieldMask, FieldMask fieldMask2, FieldMask... fieldMaskArr) {
        FieldMaskTree fieldMaskTreeMergeFromFieldMask = new FieldMaskTree(fieldMask).mergeFromFieldMask(fieldMask2);
        for (FieldMask fieldMask3 : fieldMaskArr) {
            fieldMaskTreeMergeFromFieldMask.mergeFromFieldMask(fieldMask3);
        }
        return fieldMaskTreeMergeFromFieldMask.toFieldMask();
    }

    public static FieldMask fromString(Class<? extends Message> cls, String str) {
        return fromStringList(cls, Arrays.asList(str.split(",")));
    }

    public static void merge(FieldMask fieldMask, Message message, Message.Builder builder) {
        merge(fieldMask, message, builder, new MergeOptions());
    }

    public static boolean isValid(Descriptors.Descriptor descriptor, FieldMask fieldMask) {
        Iterator<String> it = fieldMask.getPathsList().iterator();
        while (it.hasNext()) {
            if (!isValid(descriptor, it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(Class<? extends Message> cls, String str) {
        return isValid(((Message) Internal.getDefaultInstance(cls)).getDescriptorForType(), str);
    }

    public static boolean isValid(Descriptors.Descriptor descriptor, String str) {
        Descriptors.FieldDescriptor fieldDescriptorFindFieldByName;
        String[] strArrSplit = str.split(FIELD_SEPARATOR_REGEX);
        if (strArrSplit.length == 0) {
            return false;
        }
        for (String str2 : strArrSplit) {
            if (descriptor == null || (fieldDescriptorFindFieldByName = descriptor.findFieldByName(str2)) == null) {
                return false;
            }
            descriptor = (fieldDescriptorFindFieldByName.isRepeated() || fieldDescriptorFindFieldByName.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) ? null : fieldDescriptorFindFieldByName.getMessageType();
        }
        return true;
    }

    public static FieldMask fromFieldNumbers(Class<? extends Message> cls, int... iArr) {
        List aVar;
        if (iArr.length == 0) {
            aVar = Collections.EMPTY_LIST;
        } else {
            aVar = new a(0, iArr.length, iArr);
        }
        return fromFieldNumbers(cls, aVar);
    }
}
