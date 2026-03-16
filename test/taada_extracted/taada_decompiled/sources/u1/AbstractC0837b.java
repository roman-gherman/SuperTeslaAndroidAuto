package u1;

import c4.AbstractC0246d;
import com.android.multidex.ClassPathElement;
import e2.C0427c;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.E;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: renamed from: u1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0837b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f4858a;
    public static final Set b;
    public static final ArrayList c;
    public static final ArrayList d;

    static {
        ArrayList arrayListB0 = kotlin.collections.m.b0(new C0427c('0', '9'), kotlin.collections.m.a0(new C0427c('a', 'z'), new C0427c('A', 'Z')));
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(arrayListB0));
        Iterator it = arrayListB0.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf((byte) ((Character) it.next()).charValue()));
        }
        f4858a = kotlin.collections.m.s0(arrayList);
        b = kotlin.collections.m.s0(kotlin.collections.m.b0(new C0427c('0', '9'), kotlin.collections.m.a0(new C0427c('a', 'z'), new C0427c('A', 'Z'))));
        kotlin.collections.m.s0(kotlin.collections.m.b0(new C0427c('0', '9'), kotlin.collections.m.a0(new C0427c('a', 'f'), new C0427c('A', 'F'))));
        Set setN = kotlin.collections.j.N(new Character[]{':', Character.valueOf(ClassPathElement.SEPARATOR_CHAR), '?', '#', Character.valueOf(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH), ']', '@', '!', '$', '&', '\'', '(', ')', Character.valueOf(TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH), ',', Character.valueOf(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER), Character.valueOf(SignatureVisitor.INSTANCEOF), Character.valueOf(SignatureVisitor.SUPER), Character.valueOf(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH), '_', '~', Character.valueOf(SignatureVisitor.EXTENDS)});
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(setN));
        Iterator it2 = setN.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Byte.valueOf((byte) ((Character) it2.next()).charValue()));
        }
        c = arrayList2;
        kotlin.collections.j.N(new Character[]{':', '@', '!', '$', '&', '\'', '(', ')', Character.valueOf(TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH), Character.valueOf(SignatureVisitor.EXTENDS), ',', Character.valueOf(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER), Character.valueOf(SignatureVisitor.INSTANCEOF), Character.valueOf(SignatureVisitor.SUPER), Character.valueOf(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH), '_', '~'});
        E.w(b, kotlin.collections.j.N(new Character[]{'!', '#', '$', '&', Character.valueOf(SignatureVisitor.EXTENDS), Character.valueOf(SignatureVisitor.SUPER), Character.valueOf(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH), '^', '_', '`', '|', '~'}));
        List listY = kotlin.collections.n.y(Character.valueOf(SignatureVisitor.SUPER), Character.valueOf(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH), '_', '~');
        ArrayList arrayList3 = new ArrayList(kotlin.collections.o.D(listY));
        Iterator it3 = listY.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Byte.valueOf((byte) ((Character) it3.next()).charValue()));
        }
        d = arrayList3;
    }

    public static final String a(byte b2) {
        int i = (b2 & 255) >> 4;
        int i3 = b2 & 15;
        return new String(new char[]{'%', (char) ((i < 0 || i >= 10) ? ((char) (i + 65)) - '\n' : i + 48), (char) ((i3 < 0 || i3 >= 10) ? ((char) (i3 + 65)) - '\n' : i3 + 48)});
    }

    public static final int b(char c6) {
        if ('0' <= c6 && c6 < ':') {
            return c6 - '0';
        }
        if ('A' <= c6 && c6 < 'G') {
            return c6 - '7';
        }
        if ('a' > c6 || c6 >= 'g') {
            return -1;
        }
        return c6 - 'W';
    }

    public static final String c(String str, int i, int i3, boolean z6, Charset charset) throws A.a {
        int i4 = i;
        while (i4 < i3) {
            char cCharAt = str.charAt(i4);
            if (cCharAt == '%' || (z6 && cCharAt == '+')) {
                int i5 = i3 - i;
                if (i5 > 255) {
                    i5 /= 3;
                }
                StringBuilder sb = new StringBuilder(i5);
                if (i4 > i) {
                    sb.append((CharSequence) str, i, i4);
                }
                byte[] bArr = null;
                while (i4 < i3) {
                    char cCharAt2 = str.charAt(i4);
                    if (z6 && cCharAt2 == '+') {
                        sb.append(' ');
                    } else if (cCharAt2 == '%') {
                        if (bArr == null) {
                            bArr = new byte[(i3 - i4) / 3];
                        }
                        int i6 = 0;
                        while (i4 < i3 && str.charAt(i4) == '%') {
                            int i7 = i4 + 2;
                            if (i7 >= i3) {
                                throw new A.a("Incomplete trailing HEX escape: " + str.subSequence(i4, str.length()).toString() + ", in " + ((Object) str) + " at " + i4, 7);
                            }
                            int i8 = i4 + 1;
                            int iB = b(str.charAt(i8));
                            int iB2 = b(str.charAt(i7));
                            if (iB == -1 || iB2 == -1) {
                                throw new A.a("Wrong HEX escape: %" + str.charAt(i8) + str.charAt(i7) + ", in " + ((Object) str) + ", at " + i4, 7);
                            }
                            bArr[i6] = (byte) ((iB * 16) + iB2);
                            i4 += 3;
                            i6++;
                        }
                        sb.append(new String(bArr, 0, i6, charset));
                    } else {
                        sb.append(cCharAt2);
                    }
                    i4++;
                }
                String string = sb.toString();
                kotlin.jvm.internal.h.e(string, "sb.toString()");
                return string;
            }
            i4++;
        }
        if (i == 0 && i3 == str.length()) {
            return str.toString();
        }
        String strSubstring = str.substring(i, i3);
        kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String d(String str) {
        int length = str.length();
        Charset charset = kotlin.text.a.f3942a;
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(charset, "charset");
        return c(str, 0, length, false, charset);
    }

    public static String e(String str, int i, int i3, int i4) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        boolean z6 = (i4 & 4) == 0;
        Charset charset = kotlin.text.a.f3942a;
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(charset, "charset");
        return c(str, i, i3, z6, charset);
    }

    public static final String f(String str, boolean z6) {
        kotlin.jvm.internal.h.f(str, "<this>");
        StringBuilder sb = new StringBuilder();
        CharsetEncoder charsetEncoderNewEncoder = kotlin.text.a.f3942a.newEncoder();
        kotlin.jvm.internal.h.e(charsetEncoderNewEncoder, "UTF_8.newEncoder()");
        g(AbstractC0246d.H(charsetEncoderNewEncoder, str, 0, str.length()), new C0836a(sb, z6));
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        throw new java.io.EOFException("No readable bytes available.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(I1.d r4, kotlin.jvm.functions.Function1 r5) {
        /*
            r0 = 1
            J1.b r1 = J1.c.d(r4, r0)
            if (r1 != 0) goto L8
            goto L32
        L8:
            int r2 = r1.c     // Catch: java.lang.Throwable -> L22
            int r3 = r1.b     // Catch: java.lang.Throwable -> L22
            if (r2 <= r3) goto L2c
            if (r3 == r2) goto L24
            int r2 = r3 + 1
            r1.b = r2     // Catch: java.lang.Throwable -> L22
            java.nio.ByteBuffer r2 = r1.f750a     // Catch: java.lang.Throwable -> L22
            byte r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L22
            java.lang.Byte r2 = java.lang.Byte.valueOf(r2)     // Catch: java.lang.Throwable -> L22
            r5.invoke(r2)     // Catch: java.lang.Throwable -> L22
            goto L8
        L22:
            r5 = move-exception
            goto L35
        L24:
            java.io.EOFException r5 = new java.io.EOFException     // Catch: java.lang.Throwable -> L22
            java.lang.String r2 = "No readable bytes available."
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L22
            throw r5     // Catch: java.lang.Throwable -> L22
        L2c:
            J1.b r1 = J1.c.e(r4, r1)     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L8
        L32:
            return
        L33:
            r5 = move-exception
            r0 = 0
        L35:
            if (r0 == 0) goto L3a
            J1.c.a(r4, r1)
        L3a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.AbstractC0837b.g(I1.d, kotlin.jvm.functions.Function1):void");
    }
}
