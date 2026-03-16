package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class K0 {
    public static J0 a(Object obj) {
        Q q = (Q) obj;
        J0 j02 = q.unknownFields;
        if (j02 != J0.f2833f) {
            return j02;
        }
        J0 j0C = J0.c();
        q.unknownFields = j0C;
        return j0C;
    }

    public static boolean b(Object obj, Reader reader) throws V {
        int tag = reader.getTag();
        int i = tag >>> 3;
        int i3 = tag & 7;
        if (i3 == 0) {
            ((J0) obj).d(i << 3, Long.valueOf(reader.readInt64()));
            return true;
        }
        if (i3 == 1) {
            ((J0) obj).d((i << 3) | 1, Long.valueOf(reader.readFixed64()));
            return true;
        }
        if (i3 == 2) {
            ((J0) obj).d((i << 3) | 2, reader.readBytes());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                throw V.c();
            }
            ((J0) obj).d((i << 3) | 5, Integer.valueOf(reader.readFixed32()));
            return true;
        }
        J0 j0C = J0.c();
        int i4 = i << 3;
        int i5 = i4 | 4;
        while (reader.getFieldNumber() != Integer.MAX_VALUE && b(j0C, reader)) {
        }
        if (i5 != reader.getTag()) {
            throw new V("Protocol message end-group tag did not match expected tag.");
        }
        j0C.e = false;
        ((J0) obj).d(i4 | 3, j0C);
        return true;
    }
}
