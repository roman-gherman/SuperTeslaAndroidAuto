package io.ktor.utils.io.internal;

import a3.F;
import a3.L;
import c4.AbstractC0246d;
import com.android.multidex.ClassPathElement;
import io.ktor.util.StringValues;
import io.ktor.utils.io.Z;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.collections.A;
import kotlin.collections.u;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import m3.AbstractC0690y;
import m3.C0677k;
import net.bytebuddy.description.type.TypeDescription;
import org.bouncycastle.crypto.Digest;
import u1.C0833B;
import u1.C0840e;
import u1.w;
import u1.y;
import u1.z;
import w2.AbstractC0875i;
import w3.H;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t {
    public static final void a(y yVar, StringBuilder sb) {
        List listP;
        sb.append(yVar.f4879a.f4846a);
        String str = yVar.f4879a.f4846a;
        if (str.equals("file")) {
            CharSequence charSequence = yVar.b;
            String strI = i(yVar);
            sb.append("://");
            sb.append(charSequence);
            if (!kotlin.text.i.R(strI, ClassPathElement.SEPARATOR_CHAR)) {
                sb.append(ClassPathElement.SEPARATOR_CHAR);
            }
            sb.append((CharSequence) strI);
            return;
        }
        if (str.equals("mailto")) {
            StringBuilder sb2 = new StringBuilder();
            String str2 = yVar.e;
            String str3 = yVar.f4880f;
            if (str2 != null) {
                sb2.append(str2);
                if (str3 != null) {
                    sb2.append(':');
                    sb2.append(str3);
                }
                sb2.append("@");
            }
            CharSequence string = sb2.toString();
            kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
            CharSequence charSequence2 = yVar.b;
            sb.append(":");
            sb.append(string);
            sb.append(charSequence2);
            return;
        }
        sb.append("://");
        sb.append(h(yVar));
        String encodedPath = i(yVar);
        w encodedQueryParameters = yVar.i;
        boolean z6 = yVar.d;
        kotlin.jvm.internal.h.f(encodedPath, "encodedPath");
        kotlin.jvm.internal.h.f(encodedQueryParameters, "encodedQueryParameters");
        if (!kotlin.text.r.y(encodedPath) && !kotlin.text.r.C(encodedPath, "/")) {
            sb.append(ClassPathElement.SEPARATOR_CHAR);
        }
        sb.append((CharSequence) encodedPath);
        if (!((Map) encodedQueryParameters.f4280a).isEmpty() || z6) {
            sb.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
        }
        Set<Map.Entry> setEntries = encodedQueryParameters.entries();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : setEntries) {
            String str4 = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.isEmpty()) {
                listP = Z.p(new N1.e(str4, null));
            } else {
                ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(list));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new N1.e(str4, (String) it.next()));
                }
                listP = arrayList2;
            }
            kotlin.collections.s.F(listP, arrayList);
        }
        kotlin.collections.m.U(arrayList, sb, "&", null, null, C0833B.f4847a, 60);
        if (yVar.f4881g.length() > 0) {
            sb.append('#');
            sb.append(yVar.f4881g);
        }
    }

    public static P1.j b(P1.j jVar) {
        P1.e eVar = jVar.f1215a;
        eVar.b();
        eVar.f1210l = true;
        return jVar;
    }

    public static void c(byte[] bArr, Digest digest) {
        digest.update(bArr, 0, bArr.length);
    }

    public static final Charset d(C0840e c0840e) {
        kotlin.jvm.internal.h.f(c0840e, "<this>");
        String strF = c0840e.f("charset");
        if (strF == null) {
            return null;
        }
        try {
            return Charset.forName(strF);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static void e(H h3) {
        if (h3.hasTagClass(128)) {
            return;
        }
        int i = h3.b;
        throw new IllegalStateException(androidx.constraintlayout.core.motion.a.r("Expected ", "CONTEXT", " tag but found ", i != 64 ? i != 128 ? i != 192 ? "UNIVERSAL" : "PRIVATE" : "CONTEXT" : "APPLICATION"));
    }

    public static final L f(ClassDescriptor from, ClassDescriptor to) {
        kotlin.jvm.internal.h.f(from, "from");
        kotlin.jvm.internal.h.f(to, "to");
        from.getDeclaredTypeParameters().size();
        to.getDeclaredTypeParameters().size();
        List<TypeParameterDescriptor> declaredTypeParameters = from.getDeclaredTypeParameters();
        kotlin.jvm.internal.h.e(declaredTypeParameters, "from.declaredTypeParameters");
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(declaredTypeParameters));
        Iterator<T> it = declaredTypeParameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeParameterDescriptor) it.next()).getTypeConstructor());
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = to.getDeclaredTypeParameters();
        kotlin.jvm.internal.h.e(declaredTypeParameters2, "to.declaredTypeParameters");
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(declaredTypeParameters2));
        Iterator<T> it2 = declaredTypeParameters2.iterator();
        while (it2.hasNext()) {
            F defaultType = ((TypeParameterDescriptor) it2.next()).getDefaultType();
            kotlin.jvm.internal.h.e(defaultType, "it.defaultType");
            arrayList2.add(AbstractC0246d.f(defaultType));
        }
        return new L(A.L(kotlin.collections.m.u0(arrayList, arrayList2)), 1);
    }

    public static void g(StringValues stringValues, Function2 function2) {
        Iterator<T> it = stringValues.entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            function2.mo5invoke((String) entry.getKey(), (List) entry.getValue());
        }
    }

    public static final String h(y yVar) {
        kotlin.jvm.internal.h.f(yVar, "<this>");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String str = yVar.e;
        String str2 = yVar.f4880f;
        if (str != null) {
            sb2.append(str);
            if (str2 != null) {
                sb2.append(':');
                sb2.append(str2);
            }
            sb2.append("@");
        }
        String string = sb2.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        sb.append(string);
        sb.append(yVar.b);
        int i = yVar.c;
        if (i != 0 && i != yVar.f4879a.b) {
            sb.append(":");
            sb.append(String.valueOf(yVar.c));
        }
        String string2 = sb.toString();
        kotlin.jvm.internal.h.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public static final String i(y yVar) {
        kotlin.jvm.internal.h.f(yVar, "<this>");
        List list = yVar.f4882h;
        return list.isEmpty() ? "" : list.size() == 1 ? ((CharSequence) kotlin.collections.m.P(list)).length() == 0 ? "/" : (String) kotlin.collections.m.P(list) : kotlin.collections.m.V(list, "/", null, null, null, 62);
    }

    public static final int j(int i, String str) {
        String property;
        Integer numV;
        try {
            property = System.getProperty("io.ktor.utils.io.".concat(str));
        } catch (SecurityException unused) {
            property = null;
        }
        return (property == null || (numV = kotlin.text.q.v(property)) == null) ? i : numV.intValue();
    }

    public static String k(int i, int i3) {
        return B2.b.d(i3, i != 64 ? i != 128 ? i != 192 ? "[UNIVERSAL " : "[PRIVATE " : "[CONTEXT " : "[APPLICATION ", "]");
    }

    public static boolean l(CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.h.f(callableMemberDescriptor, "callableMemberDescriptor");
        if (!AbstractC0875i.d.contains(callableMemberDescriptor.getName())) {
            return false;
        }
        if (kotlin.collections.m.L(R2.e.c(callableMemberDescriptor), AbstractC0875i.c) && callableMemberDescriptor.getValueParameters().isEmpty()) {
            return true;
        }
        if (!k2.i.y(callableMemberDescriptor)) {
            return false;
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        kotlin.jvm.internal.h.e(overriddenDescriptors, "overriddenDescriptors");
        if (overriddenDescriptors.isEmpty()) {
            return false;
        }
        for (CallableMemberDescriptor it : overriddenDescriptors) {
            kotlin.jvm.internal.h.e(it, "it");
            if (l(it)) {
                return true;
            }
        }
        return false;
    }

    public static final void m(q1.c cVar, String str) {
        if (str != null) {
            cVar.c.append("Authorization", str.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object n(o3.C0744b r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof o3.s
            if (r0 == 0) goto L13
            r0 = r5
            o3.s r0 = (o3.s) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            o3.s r0 = new o3.s
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlinx.coroutines.channels.ChannelIterator r4 = r0.f4353a
            kotlin.reflect.l.e0(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.reflect.l.e0(r5)
            r0.f4353a = r4
            r0.c = r3
            java.lang.Object r5 = r4.hasNext(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L4c
            java.lang.Object r4 = r4.next()
            return r4
        L4c:
            o3.x r4 = new o3.x
            java.lang.String r5 = "Channel was closed"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.t.n(o3.b, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void o(y yVar, String value) {
        kotlin.jvm.internal.h.f(yVar, "<this>");
        kotlin.jvm.internal.h.f(value, "value");
        List listP0 = kotlin.text.r.y(value) ? u.f3805a : value.equals("/") ? z.f4884a : kotlin.collections.m.p0(kotlin.text.i.Q(value, new char[]{ClassPathElement.SEPARATOR_CHAR}));
        kotlin.jvm.internal.h.f(listP0, "<set-?>");
        yVar.f4882h = listP0;
    }

    public static Set p(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        kotlin.jvm.internal.h.e(setSingleton, "singleton(element)");
        return setSingleton;
    }

    public static final Object q(r3.t tVar, r3.t tVar2, Function2 function2) throws Throwable {
        Object c0677k;
        Object objU;
        try {
            kotlin.jvm.internal.z.d(2, function2);
            c0677k = function2.mo5invoke(tVar2, tVar);
        } catch (Throwable th) {
            c0677k = new C0677k(th, false);
        }
        T1.a aVar = T1.a.f1304a;
        if (c0677k == aVar || (objU = tVar.u(c0677k)) == AbstractC0690y.e) {
            return aVar;
        }
        if (objU instanceof C0677k) {
            throw ((C0677k) objU).f4134a;
        }
        return AbstractC0690y.l(objU);
    }

    public static void r(short s3, Digest digest) {
        digest.update((byte) (s3 >>> 8));
        digest.update((byte) s3);
    }

    public static void s(int i, Digest digest) {
        digest.update((byte) (i >>> 24));
        digest.update((byte) (i >>> 16));
        digest.update((byte) (i >>> 8));
        digest.update((byte) i);
    }

    public static final C0840e t(C0840e c0840e, Charset charset) {
        kotlin.jvm.internal.h.f(c0840e, "<this>");
        kotlin.jvm.internal.h.f(charset, "charset");
        String lowerCase = c0840e.d.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.h.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return !lowerCase.equals("text") ? c0840e : c0840e.h(H1.a.c(charset));
    }
}
