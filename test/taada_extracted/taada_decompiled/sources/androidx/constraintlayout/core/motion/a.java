package androidx.constraintlayout.core.motion;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import com.google.android.gms.internal.play_billing.V0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0398x;
import com.google.protobuf.DescriptorProtos;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static int A(int i, int i3, int i4, int i5) {
        return V0.b0(i) + i3 + i4 + i5;
    }

    public static int B(int i, int i3, int i4, int i5) {
        return AbstractC0398x.I(i) + i3 + i4 + i5;
    }

    public static /* synthetic */ String C(int i) {
        switch (i) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case 4:
                return "END_OBJECT";
            case 5:
                return "NAME";
            case 6:
                return "STRING";
            case 7:
                return "NUMBER";
            case 8:
                return "BOOLEAN";
            case 9:
                return "NULL";
            case 10:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }

    public static int a(int i, int i3, int i4) {
        return V0.b0(i) + i3 + i4;
    }

    public static int b(int i, int i3, int i4, int i5) {
        return ((i * i3) + i4) * i5;
    }

    public static int c(int i, int i3, String str) {
        return (str.hashCode() + i) * i3;
    }

    public static int d(List list, int i, int i3) {
        return (list.hashCode() + i) * i3;
    }

    public static long e(long j6, long j7, long j8, long j9) {
        return (j6 * j7) + j8 + j9;
    }

    public static Object f(int i) {
        return DescriptorProtos.getDescriptor().getMessageTypes().get(i);
    }

    public static Object g(int i, ArrayList arrayList) {
        return arrayList.get(arrayList.size() - i);
    }

    public static String h(int i, StringBuilder sb) {
        sb.append(Integer.toHexString(i));
        return sb.toString();
    }

    public static String i(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String j(Class cls, String str) {
        return str + cls;
    }

    public static String k(Class cls, String str, String str2) {
        return str + cls + str2;
    }

    public static String l(Class cls, StringBuilder sb) {
        sb.append(cls.getCanonicalName());
        return sb.toString();
    }

    public static String m(Object obj, String str) {
        return str + obj;
    }

    public static String n(String str, int i, String str2, int i3) {
        return str + i + str2 + i3;
    }

    public static String o(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String p(String str, String str2) {
        return str + str2;
    }

    public static String q(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String r(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String s(StringBuilder sb, String str, char c) {
        sb.append(str);
        sb.append(c);
        return sb.toString();
    }

    public static void t(int i, StringBuilder sb, AnnotatedOutput annotatedOutput, int i3) {
        sb.append(Hex.u4(i));
        annotatedOutput.annotate(i3, sb.toString());
    }

    public static void u(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
    }

    public static /* synthetic */ void v(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void w(StringBuilder sb, String str, int i) {
        sb.append(Integer.toHexString(i));
        sb.append(str);
    }

    public static int x(int i, int i3, int i4) {
        return AbstractC0398x.G(i) + i3 + i4;
    }

    public static int y(int i, int i3, int i4, int i5) {
        return ((i * i3) / i4) + i5;
    }

    public static String z(int i, StringBuilder sb) {
        sb.append(Hex.u2(i));
        return sb.toString();
    }
}
