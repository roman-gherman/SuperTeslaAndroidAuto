package k1;

import A2.C0029k;
import C0.t;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import h0.C0492a;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.util.StringValues;
import io.ktor.utils.io.Z;
import io.ktor.utils.io.b0;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.o;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import u1.AbstractC0837b;
import u1.C0840e;
import u1.m;
import u1.q;
import u1.w;
import w4.C0909b;
import w4.l;
import x2.C0914a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static t f3701a;

    public static /* synthetic */ void a(int i) {
        String str = i != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 18 ? 3 : 2];
        switch (i) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "name";
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i == 18) {
            throw new IllegalStateException(str2);
        }
    }

    public static final void b(w wVar, StringValues stringValues) {
        for (String str : stringValues.names()) {
            List<String> all = stringValues.getAll(str);
            if (all == null) {
                all = u.f3805a;
            }
            String strF = AbstractC0837b.f(str, false);
            ArrayList arrayList = new ArrayList(o.D(all));
            for (String str2 : all) {
                kotlin.jvm.internal.h.f(str2, "<this>");
                arrayList.add(AbstractC0837b.f(str2, true));
            }
            wVar.appendAll(strF, arrayList);
        }
    }

    public static void c(StringBuilder sb, Object obj, Function1 function1) {
        kotlin.jvm.internal.h.f(sb, "<this>");
        if (function1 != null) {
            sb.append((CharSequence) function1.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) String.valueOf(obj));
        }
    }

    public static final z1.e d(String str) {
        kotlin.jvm.internal.h.f(str, "<this>");
        return new z1.e(str);
    }

    public static final C0840e e(HttpMessageBuilder httpMessageBuilder) {
        kotlin.jvm.internal.h.f(httpMessageBuilder, "<this>");
        m headers = httpMessageBuilder.getHeaders();
        List list = q.f4870a;
        String str = headers.get("Content-Type");
        if (str == null) {
            return null;
        }
        C0840e c0840e = C0840e.f4862f;
        return b0.x(str);
    }

    public static io.ktor.utils.io.jvm.javaio.q f(int i) {
        if (i != 0 && i == 1) {
            return new n0.c();
        }
        return new n0.h();
    }

    public static final Parameters g(ParametersBuilder parameters) {
        kotlin.jvm.internal.h.f(parameters, "parameters");
        w wVarA = Z.a();
        for (String str : parameters.names()) {
            List<String> all = parameters.getAll(str);
            if (all == null) {
                all = u.f3805a;
            }
            String strE = AbstractC0837b.e(str, 0, 0, 15);
            ArrayList arrayList = new ArrayList(o.D(all));
            Iterator<T> it = all.iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC0837b.e((String) it.next(), 0, 0, 11));
            }
            wVarA.appendAll(strE, arrayList);
        }
        return wVarA.build();
    }

    public static boolean h(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor) {
        kotlin.jvm.internal.h.f(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.h.f(subDescriptor, "subDescriptor");
        if (!(subDescriptor instanceof y2.e) || !(superDescriptor instanceof FunctionDescriptor)) {
            return false;
        }
        y2.e eVar = (y2.e) subDescriptor;
        eVar.getValueParameters().size();
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) superDescriptor;
        functionDescriptor.getValueParameters().size();
        List<ValueParameterDescriptor> valueParameters = eVar.getOriginal().getValueParameters();
        kotlin.jvm.internal.h.e(valueParameters, "subDescriptor.original.valueParameters");
        List<ValueParameterDescriptor> valueParameters2 = functionDescriptor.getOriginal().getValueParameters();
        kotlin.jvm.internal.h.e(valueParameters2, "superDescriptor.original.valueParameters");
        for (N1.e eVar2 : kotlin.collections.m.u0(valueParameters, valueParameters2)) {
            ValueParameterDescriptor subParameter = (ValueParameterDescriptor) eVar2.f1121a;
            ValueParameterDescriptor superParameter = (ValueParameterDescriptor) eVar2.b;
            kotlin.jvm.internal.h.e(subParameter, "subParameter");
            boolean z6 = k((FunctionDescriptor) subDescriptor, subParameter) instanceof E2.j;
            kotlin.jvm.internal.h.e(superParameter, "superParameter");
            if (z6 != (k(functionDescriptor, superParameter) instanceof E2.j)) {
                return true;
            }
        }
        return false;
    }

    public static ValueParameterDescriptor i(L2.f fVar, ClassDescriptor classDescriptor) {
        if (fVar == null) {
            a(19);
            throw null;
        }
        if (classDescriptor == null) {
            a(20);
            throw null;
        }
        Collection<ClassConstructorDescriptor> constructors = classDescriptor.getConstructors();
        if (constructors.size() != 1) {
            return null;
        }
        for (ValueParameterDescriptor valueParameterDescriptor : constructors.iterator().next().getValueParameters()) {
            if (valueParameterDescriptor.getName().equals(fVar)) {
                return valueParameterDescriptor;
            }
        }
        return null;
    }

    public static t j() {
        t tVar;
        t tVar2 = f3701a;
        if (tVar2 != null) {
            return tVar2;
        }
        try {
            tVar = new t(Class.class.getMethod("isSealed", new Class[0]), Class.class.getMethod("getPermittedSubclasses", new Class[0]), Class.class.getMethod("isRecord", new Class[0]), Class.class.getMethod("getRecordComponents", new Class[0]), 17);
        } catch (NoSuchMethodException unused) {
            Object obj = null;
            tVar = new t(obj, obj, obj, obj, 17);
        }
        f3701a = tVar;
        return tVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0114, code lost:
    
        if (R2.e.g(r0).equals(R2.e.g(r2)) == false) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static E2.k k(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r8, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r9) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.j.k(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor):E2.k");
    }

    public static void l(C0909b c0909b) {
        long j6;
        synchronized (c0909b) {
            try {
                synchronized (c0909b) {
                    j6 = c0909b.f5081g;
                }
                return;
            } finally {
            }
        }
        if (j6 >= c0909b.f5080f) {
            StringBuilder sb = new StringBuilder("hss private key");
            sb.append(c0909b.c ? " shard" : "");
            sb.append(" is exhausted");
            throw new com.google.android.gms.tasks.a(sb.toString(), 7);
        }
        int i = c0909b.b;
        List listB = c0909b.b();
        int i3 = i;
        while (true) {
            int i4 = i3 - 1;
            if (((l) listB.get(i4)).d() != (1 << ((l) listB.get(i4)).c.c)) {
                while (i3 < i) {
                    c0909b.c(i3);
                    i3++;
                }
                return;
            } else {
                if (i4 == 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("hss private key");
                    sb2.append(c0909b.c ? " shard" : "");
                    sb2.append(" is exhausted the maximum limit for this HSS private key");
                    throw new com.google.android.gms.tasks.a(sb2.toString(), 7);
                }
                i3 = i4;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object m(o3.n r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof o3.D
            if (r0 == 0) goto L13
            r0 = r5
            o3.D r0 = (o3.D) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            o3.D r0 = new o3.D
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f4319a
            T1.a r1 = T1.a.f1304a
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.reflect.l.e0(r5)
            o3.v r5 = (o3.v) r5
            java.lang.Object r4 = r5.f4355a
            goto L42
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.reflect.l.e0(r5)
            r0.b = r3
            r4.getClass()
            java.lang.Object r4 = o3.n.v(r4, r0)
            if (r4 != r1) goto L42
            return r1
        L42:
            boolean r5 = r4 instanceof o3.u
            if (r5 != 0) goto L47
            return r4
        L47:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.j.m(o3.n, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static LinkedHashSet n(L2.f fVar, Collection collection, Collection collection2, ClassDescriptor classDescriptor, ErrorReporter errorReporter, N2.o oVar, boolean z6) {
        if (fVar == null) {
            a(12);
            throw null;
        }
        if (collection == null) {
            a(13);
            throw null;
        }
        if (classDescriptor == null) {
            a(15);
            throw null;
        }
        if (errorReporter == null) {
            a(16);
            throw null;
        }
        if (oVar == null) {
            a(17);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        oVar.h(fVar, collection, collection2, classDescriptor, new C0914a(errorReporter, linkedHashSet, z6));
        return linkedHashSet;
    }

    public static LinkedHashSet o(L2.f fVar, AbstractCollection abstractCollection, Collection collection, ClassDescriptor classDescriptor, ErrorReporter errorReporter, N2.o oVar) {
        if (fVar == null) {
            a(0);
            throw null;
        }
        if (classDescriptor == null) {
            a(3);
            throw null;
        }
        if (errorReporter == null) {
            a(4);
            throw null;
        }
        if (oVar != null) {
            return n(fVar, abstractCollection, collection, classDescriptor, errorReporter, oVar, false);
        }
        a(5);
        throw null;
    }

    public static LinkedHashSet p(L2.f fVar, Collection collection, AbstractCollection abstractCollection, C0029k c0029k, s2.g gVar, N2.o oVar) {
        if (fVar == null) {
            a(6);
            throw null;
        }
        if (collection == null) {
            a(7);
            throw null;
        }
        if (c0029k == null) {
            a(9);
            throw null;
        }
        if (gVar == null) {
            a(10);
            throw null;
        }
        if (oVar != null) {
            return n(fVar, collection, abstractCollection, c0029k, gVar, oVar, true);
        }
        a(11);
        throw null;
    }

    public static void q(View view, n0.f fVar) {
        C0492a c0492a = fVar.f4178a.b;
        if (c0492a == null || !c0492a.f3351a) {
            return;
        }
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ViewCompat.getElevation((View) parent);
        }
        n0.e eVar = fVar.f4178a;
        if (eVar.f4172l != elevation) {
            eVar.f4172l = elevation;
            fVar.p();
        }
    }

    public static void r(byte[] bArr, int i, long j6) {
        bArr[i] = (byte) (j6 & 255);
        bArr[i + 1] = (byte) ((j6 >> 8) & 255);
        bArr[i + 2] = (byte) ((j6 >> 16) & 255);
        bArr[i + 3] = (byte) ((j6 >> 24) & 255);
        bArr[i + 4] = (byte) ((j6 >> 32) & 255);
        bArr[i + 5] = (byte) ((j6 >> 40) & 255);
        bArr[i + 6] = (byte) ((j6 >> 48) & 255);
        bArr[i + 7] = (byte) ((j6 >> 56) & 255);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object s(java.net.HttpURLConnection r4, q1.d r5, a3.C0137B r6, U1.c r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof k1.i
            if (r0 == 0) goto L13
            r0 = r7
            k1.i r0 = (k1.i) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            k1.i r0 = new k1.i
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Throwable r4 = r0.b
            q1.d r5 = r0.f3700a
            kotlin.reflect.l.e0(r7)
            goto L49
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.reflect.l.e0(r7)
            java.lang.Object r4 = r6.invoke(r4)     // Catch: java.lang.Throwable -> L3b
            return r4
        L3b:
            r4 = move-exception
            r0.f3700a = r5
            r0.b = r4
            r0.d = r3
            java.lang.Object r6 = m3.AbstractC0690y.o(r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            boolean r6 = r4 instanceof java.net.SocketTimeoutException
            if (r6 != 0) goto L64
            boolean r6 = r4 instanceof java.net.ConnectException
            r7 = 0
            if (r6 == 0) goto L63
            java.lang.String r6 = r4.getMessage()
            if (r6 == 0) goto L5f
            java.lang.String r0 = "timed out"
            boolean r6 = kotlin.text.i.D(r6, r0, r7)
            goto L60
        L5f:
            r6 = r7
        L60:
            if (r6 == 0) goto L63
            goto L64
        L63:
            r3 = r7
        L64:
            if (r3 == 0) goto La0
            org.slf4j.Logger r6 = m1.Q.f4047a
            java.lang.String r6 = "request"
            kotlin.jvm.internal.h.f(r5, r6)
            l1.a r6 = new l1.a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Connect timeout has expired [url="
            r7.<init>(r0)
            u1.D r0 = r5.f4515a
            r7.append(r0)
            java.lang.String r0 = ", connect_timeout="
            r7.append(r0)
            m1.O r0 = m1.P.d
            java.lang.Object r5 = r5.a()
            m1.M r5 = (m1.M) r5
            if (r5 == 0) goto L8e
            java.lang.Long r5 = r5.b
            if (r5 != 0) goto L90
        L8e:
            java.lang.String r5 = "unknown"
        L90:
            r7.append(r5)
            java.lang.String r5 = " ms]"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5, r4)
            r4 = r6
        La0:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.j.s(java.net.HttpURLConnection, q1.d, a3.B, U1.c):java.lang.Object");
    }
}
