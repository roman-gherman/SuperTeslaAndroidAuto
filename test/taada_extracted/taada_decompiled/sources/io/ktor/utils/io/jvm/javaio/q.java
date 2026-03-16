package io.ktor.utils.io.jvm.javaio;

import A2.B;
import a.AbstractC0132a;
import e2.C0430f;
import io.ktor.util.StringValuesBuilder;
import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.u;
import kotlinx.coroutines.channels.Channel;
import n0.t;
import o3.EnumC0743a;
import o3.y;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import t2.C0819a;
import u1.C0832A;
import u1.w;
import w3.C0896n;
import w4.C0908a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static C0819a f3615a;

    public static o3.n a(int i, EnumC0743a enumC0743a, int i3) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        int i4 = i3 & 2;
        EnumC0743a enumC0743a2 = EnumC0743a.f4320a;
        if (i4 != 0) {
            enumC0743a = enumC0743a2;
        }
        if (i == -2) {
            if (enumC0743a != enumC0743a2) {
                return new y(1, enumC0743a);
            }
            Channel.Factory.getClass();
            return new o3.n(o3.q.b);
        }
        if (i != -1) {
            return i != 0 ? i != Integer.MAX_VALUE ? enumC0743a == enumC0743a2 ? new o3.n(i) : new y(i, enumC0743a) : new o3.n(Integer.MAX_VALUE) : enumC0743a == enumC0743a2 ? new o3.n(0) : new y(1, enumC0743a);
        }
        if (enumC0743a == enumC0743a2) {
            return new y(1, EnumC0743a.b);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }

    public static final void b(StringValuesBuilder stringValuesBuilder, StringValuesBuilder builder) {
        kotlin.jvm.internal.h.f(stringValuesBuilder, "<this>");
        kotlin.jvm.internal.h.f(builder, "builder");
        Iterator<T> it = builder.entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            stringValuesBuilder.appendAll((String) entry.getKey(), (List) entry.getValue());
        }
    }

    public static void c(int i) {
        if (new C0430f(2, 36, 1).b(i)) {
            return;
        }
        StringBuilder sbJ = B2.b.j(i, "radix ", " was not in valid range ");
        sbJ.append(new C0430f(2, 36, 1));
        throw new IllegalArgumentException(sbJ.toString());
    }

    public static void d(int i, int i3, int i4) {
        if (i >= 0 && i3 <= i4) {
            if (i > i3) {
                throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.n("fromIndex: ", i, " > toIndex: ", i3));
            }
            return;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i3 + ", size: " + i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r1v0, types: [K1.a, K1.e] */
    /* JADX WARN: Type inference failed for: r1v3, types: [K1.a, K1.e] */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0088 -> B:49:0x008c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(io.ktor.utils.io.ByteReadChannel r18, java.io.OutputStream r19, long r20, U1.c r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.q.e(io.ktor.utils.io.ByteReadChannel, java.io.OutputStream, long, U1.c):java.lang.Object");
    }

    public static Digest f(int i, C0896n c0896n) {
        ExtendedDigest gVar;
        if (c0896n.f(NISTObjectIdentifiers.id_sha256)) {
            gVar = new N3.c();
        } else {
            if (!c0896n.f(NISTObjectIdentifiers.id_shake256_len)) {
                throw new IllegalArgumentException("unrecognized digest OID: " + c0896n);
            }
            gVar = new N3.g(256);
        }
        return (NISTObjectIdentifiers.id_shake256_len.f(c0896n) || gVar.getDigestSize() != i) ? new C0908a(i, gVar) : gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g(java.util.ArrayList r5, io.ktor.utils.io.ByteReadChannel r6, F1.a r7, java.nio.charset.Charset r8, U1.c r9) throws A.a {
        /*
            boolean r0 = r9 instanceof x1.e
            if (r0 == 0) goto L13
            r0 = r9
            x1.e r0 = (x1.e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            x1.e r0 = new x1.e
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            F1.a r7 = r0.b
            io.ktor.utils.io.ByteReadChannel r6 = r0.f5108a
            kotlin.reflect.l.e0(r9)
            goto L53
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.reflect.l.e0(r9)
            p3.h r9 = new p3.h
            r9.<init>(r5)
            x1.d r5 = new x1.d
            r5.<init>(r9, r8, r7, r6)
            x1.f r8 = new x1.f
            r8.<init>(r6, r3)
            r0.f5108a = r6
            r0.b = r7
            r0.d = r4
            java.lang.Object r9 = p3.v.f(r5, r8, r0)
            if (r9 != r1) goto L53
            return r1
        L53:
            if (r9 != 0) goto L80
            boolean r5 = r6.isClosedForRead()
            if (r5 != 0) goto L5c
            return r6
        L5c:
            kotlin.reflect.KType r5 = r7.c
            boolean r5 = r5.isMarkedNullable()
            if (r5 != r4) goto L67
            v1.d r5 = v1.d.f4927a
            return r5
        L67:
            A.a r5 = new A.a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "No suitable converter found for "
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "message"
            kotlin.jvm.internal.h.f(r6, r7)
            r5.<init>(r6, r3)
            throw r5
        L80:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.q.g(java.util.ArrayList, io.ktor.utils.io.ByteReadChannel, F1.a, java.nio.charset.Charset, U1.c):java.lang.Object");
    }

    public static final boolean h(char c, char c6, boolean z6) {
        if (c == c6) {
            return true;
        }
        if (!z6) {
            return false;
        }
        char upperCase = Character.toUpperCase(c);
        char upperCase2 = Character.toUpperCase(c6);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static Digest j(w4.f fVar) {
        return f(fVar.b, fVar.f5084f);
    }

    public static boolean m(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    public static final List n(String str) {
        N1.e eVar;
        u uVar = u.f3804a;
        if (str == null) {
            return uVar;
        }
        int i = 3;
        Lazy lazyN = AbstractC0132a.N(3, u1.p.b);
        int i3 = 0;
        while (i3 <= kotlin.text.i.F(str)) {
            Lazy lazyN2 = AbstractC0132a.N(i, u1.p.c);
            Integer numValueOf = null;
            int i4 = i3;
            while (true) {
                if (i4 <= kotlin.text.i.F(str)) {
                    char cCharAt = str.charAt(i4);
                    if (cCharAt == ',') {
                        ((ArrayList) lazyN.getValue()).add(new u1.i(p(i3, numValueOf != null ? numValueOf.intValue() : i4, str), lazyN2.isInitialized() ? (List) lazyN2.getValue() : uVar));
                        i4++;
                    } else if (cCharAt == ';') {
                        if (numValueOf == null) {
                            numValueOf = Integer.valueOf(i4);
                        }
                        int i5 = i4 + 1;
                        int i6 = i5;
                        while (i6 <= kotlin.text.i.F(str)) {
                            char cCharAt2 = str.charAt(i6);
                            if (cCharAt2 != '=') {
                                if (cCharAt2 == ';' || cCharAt2 == ',') {
                                    o(lazyN2, str, i5, i6, "");
                                    break;
                                }
                                i6++;
                            } else {
                                int i7 = i6 + 1;
                                if (str.length() == i7) {
                                    eVar = new N1.e(Integer.valueOf(i7), "");
                                } else {
                                    char c = '\"';
                                    if (str.charAt(i7) == '\"') {
                                        int i8 = i6 + 2;
                                        StringBuilder sb = new StringBuilder();
                                        while (i8 <= kotlin.text.i.F(str)) {
                                            char cCharAt3 = str.charAt(i8);
                                            if (cCharAt3 == c) {
                                                int i9 = i8 + 1;
                                                int i10 = i9;
                                                while (i10 < str.length() && str.charAt(i10) == ' ') {
                                                    i10++;
                                                }
                                                if (i10 == str.length() || str.charAt(i10) == ';') {
                                                    Integer numValueOf2 = Integer.valueOf(i9);
                                                    String string = sb.toString();
                                                    kotlin.jvm.internal.h.e(string, "builder.toString()");
                                                    eVar = new N1.e(numValueOf2, string);
                                                    break;
                                                }
                                            }
                                            if (cCharAt3 != '\\' || i8 >= kotlin.text.i.F(str) - 2) {
                                                sb.append(cCharAt3);
                                                i8++;
                                            } else {
                                                sb.append(str.charAt(i8 + 1));
                                                i8 += 2;
                                            }
                                            c = '\"';
                                        }
                                        Integer numValueOf3 = Integer.valueOf(i8);
                                        String string2 = sb.toString();
                                        kotlin.jvm.internal.h.e(string2, "builder.toString()");
                                        eVar = new N1.e(numValueOf3, "\"".concat(string2));
                                    } else {
                                        int i11 = i7;
                                        while (i11 <= kotlin.text.i.F(str)) {
                                            char cCharAt4 = str.charAt(i11);
                                            if (cCharAt4 == ';' || cCharAt4 == ',') {
                                                eVar = new N1.e(Integer.valueOf(i11), p(i7, i11, str));
                                                break;
                                            }
                                            i11++;
                                        }
                                        eVar = new N1.e(Integer.valueOf(i11), p(i7, i11, str));
                                    }
                                }
                                int iIntValue = ((Number) eVar.f1121a).intValue();
                                o(lazyN2, str, i5, i6, (String) eVar.b);
                                i4 = iIntValue;
                            }
                        }
                        o(lazyN2, str, i5, i6, "");
                        i4 = i6;
                    } else {
                        i4++;
                    }
                } else {
                    ((ArrayList) lazyN.getValue()).add(new u1.i(p(i3, numValueOf != null ? numValueOf.intValue() : i4, str), lazyN2.isInitialized() ? (List) lazyN2.getValue() : uVar));
                }
            }
            i3 = i4;
            i = 3;
        }
        return lazyN.isInitialized() ? (List) lazyN.getValue() : uVar;
    }

    public static final void o(Lazy lazy, String str, int i, int i3, String str2) {
        String strP = p(i, i3, str);
        if (strP.length() == 0) {
            return;
        }
        ((ArrayList) lazy.getValue()).add(new u1.j(strP, str2));
    }

    public static final String p(int i, int i3, String str) {
        String strSubstring = str.substring(i, i3);
        kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return kotlin.text.i.X(strSubstring).toString();
    }

    public static final void q(u1.y yVar, u1.y url) {
        kotlin.jvm.internal.h.f(yVar, "<this>");
        kotlin.jvm.internal.h.f(url, "url");
        C0832A c0832a = url.f4878a;
        kotlin.jvm.internal.h.f(c0832a, "<set-?>");
        yVar.f4878a = c0832a;
        String str = url.b;
        kotlin.jvm.internal.h.f(str, "<set-?>");
        yVar.b = str;
        yVar.c = url.c;
        List list = url.f4881h;
        kotlin.jvm.internal.h.f(list, "<set-?>");
        yVar.f4881h = list;
        yVar.e = url.e;
        yVar.f4879f = url.f4879f;
        w wVarA = Z.a();
        b(wVarA, url.i);
        yVar.i = wVarA;
        yVar.f4882j = new B(wVarA);
        String str2 = url.f4880g;
        kotlin.jvm.internal.h.f(str2, "<set-?>");
        yVar.f4880g = str2;
        yVar.d = url.d;
    }

    public abstract void i(t tVar, float f6, float f7);

    public abstract short k(short s3);

    public abstract short l(short s3, short s6);
}
