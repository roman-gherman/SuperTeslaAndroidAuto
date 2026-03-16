package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends k1.j {
    public static String t(String str) {
        int length;
        Comparable comparable;
        String strSubstring;
        kotlin.jvm.internal.h.f(str, "<this>");
        List listN = i.N(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listN) {
            if (!r.y((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(arrayList));
        Iterator it = arrayList.iterator();
        while (true) {
            length = 0;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            int length2 = str2.length();
            while (true) {
                if (length >= length2) {
                    length = -1;
                    break;
                }
                if (!io.ktor.utils.io.jvm.javaio.q.m(str2.charAt(length))) {
                    break;
                }
                length++;
            }
            if (length == -1) {
                length = str2.length();
            }
            arrayList2.add(Integer.valueOf(length));
        }
        Iterator it2 = arrayList2.iterator();
        if (it2.hasNext()) {
            comparable = (Comparable) it2.next();
            while (it2.hasNext()) {
                Comparable comparable2 = (Comparable) it2.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
        } else {
            comparable = null;
        }
        Integer num = (Integer) comparable;
        int iIntValue = num != null ? num.intValue() : 0;
        int length3 = str.length();
        listN.size();
        int iX = kotlin.collections.n.x(listN);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listN) {
            int i = length + 1;
            if (length < 0) {
                kotlin.collections.n.C();
                throw null;
            }
            String str3 = (String) obj2;
            if ((length == 0 || length == iX) && r.y(str3)) {
                strSubstring = null;
            } else {
                kotlin.jvm.internal.h.f(str3, "<this>");
                if (iIntValue < 0) {
                    throw new IllegalArgumentException(B2.b.d(iIntValue, "Requested character count ", " is less than zero.").toString());
                }
                int length4 = str3.length();
                if (iIntValue <= length4) {
                    length4 = iIntValue;
                }
                strSubstring = str3.substring(length4);
                kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                j.f3950a.getClass();
            }
            if (strSubstring != null) {
                arrayList3.add(strSubstring);
            }
            length = i;
        }
        StringBuilder sb = new StringBuilder(length3);
        kotlin.collections.m.U(arrayList3, sb, "\n", null, null, null, 124);
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }
}
