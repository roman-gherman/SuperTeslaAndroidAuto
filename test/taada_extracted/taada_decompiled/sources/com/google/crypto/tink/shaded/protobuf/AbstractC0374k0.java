package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.bytebuddy.utility.JavaConstant;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0374k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f2885a;

    static {
        char[] cArr = new char[80];
        f2885a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static void a(int i, StringBuilder sb) {
        while (i > 0) {
            int i3 = 80;
            if (i <= 80) {
                i3 = i;
            }
            sb.append(f2885a, 0, i3);
            i -= i3;
        }
    }

    public static void b(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                b(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                b(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        a(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i3 = 1; i3 < str.length(); i3++) {
                char cCharAt = str.charAt(i3);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append(JavaConstant.Dynamic.DEFAULT_NAME);
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(AbstractC0369i.s(AbstractC0381o.d((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC0381o) {
            sb.append(": \"");
            sb.append(AbstractC0369i.s((AbstractC0381o) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof Q) {
            sb.append(" {");
            c((Q) obj, sb, i + 2);
            sb.append("\n");
            a(i, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i4 = i + 2;
        b(sb, i4, "key", entry.getKey());
        b(sb, i4, "value", entry.getValue());
        sb.append("\n");
        a(i, sb);
        sb.append("}");
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(com.google.crypto.tink.shaded.protobuf.Q r21, java.lang.StringBuilder r22, int r23) {
        /*
            Method dump skipped, instruction units count: 561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.AbstractC0374k0.c(com.google.crypto.tink.shaded.protobuf.Q, java.lang.StringBuilder, int):void");
    }
}
