package Y0;

import A2.P;
import B.g;
import N1.m;
import android.content.SharedPreferences;
import android.util.Log;
import f.s;
import io.ktor.utils.io.U;
import io.ktor.utils.io.WriterSuspendSession;
import io.ktor.utils.io.internal.r;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.l;
import t2.q;
import z2.C0946f;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements WriterSuspendSession, TypeParameterResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1478a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;

    public b(C0946f c, DeclarationDescriptorNonRoot declarationDescriptorNonRoot, JavaTypeParameterListOwner typeParameterOwner, int i) {
        h.f(c, "c");
        h.f(typeParameterOwner, "typeParameterOwner");
        this.b = c;
        this.c = declarationDescriptorNonRoot;
        this.f1478a = i;
        List<JavaTypeParameter> typeParameters = typeParameterOwner.getTypeParameters();
        h.f(typeParameters, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = typeParameters.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i3));
            i3++;
        }
        this.d = linkedHashMap;
        this.e = ((C0946f) this.b).f5204a.f5184a.createMemoizedFunctionWithNullableValues(new q(this, 6));
    }

    public static String d(int i, int i3) {
        int iB = s.b(i);
        String str = "tenjinGoogleInstallReferrer";
        if (iB != 0 && iB == 1) {
            str = "tenjinHuaweiInstallReferrer";
        }
        int iB2 = s.b(i3);
        String str2 = "";
        if (iB2 != 0) {
            if (iB2 == 1) {
                str2 = "ClickTs";
            } else if (iB2 == 2) {
                str2 = "InstallTs";
            }
        }
        return str.concat(str2);
    }

    public static b f(g gVar, int i) {
        if (!((SharedPreferences) gVar.b).contains(d(i, 1))) {
            return null;
        }
        String string = gVar.getString(d(i, 1), "");
        Long lValueOf = Long.valueOf(gVar.getString(d(i, 2), "0"));
        Long lValueOf2 = Long.valueOf(gVar.getString(d(i, 3), "0"));
        if (i == 1 || i == 2) {
            return new b(i, string, lValueOf, lValueOf2);
        }
        throw null;
    }

    public void a(Map map) {
        if (((String) this.c) == null) {
            return;
        }
        map.put(e(1), (String) this.c);
        Long l6 = (Long) this.d;
        if (l6 != null) {
            map.put(e(2), String.valueOf(l6));
        }
        Long l7 = (Long) this.e;
        if (l7 != null) {
            map.put(e(3), String.valueOf(l7));
        }
    }

    public void b() {
        U u = (U) this.b;
        u.getClass();
        this.b = u;
        this.c = u.P();
        J1.b bVarB = l.b(((U) this.b).k().f3589a);
        this.d = bVarB;
        l.Y(bVarB, (ByteBuffer) this.c);
        this.e = ((U) this.b).k().b;
    }

    public void c() {
        int i = this.f1478a;
        if (i > 0) {
            ((r) this.e).a(i);
            this.f1478a = 0;
        }
        ((U) this.b).K();
        ((U) this.b).R();
    }

    public String e(int i) {
        int iB = s.b(this.f1478a);
        String str = "referrer";
        if (iB != 0 && iB == 1) {
            str = "huawei_referrer";
        }
        int iB2 = s.b(i);
        return iB2 != 1 ? iB2 != 2 ? str : str.concat("_install_ts") : str.concat("_click_ts");
    }

    @Override // io.ktor.utils.io.WriterSession
    public void flush() {
        ((U) this.b).m(1);
    }

    public void g(g gVar) {
        String str = (String) this.b;
        if (str == null || str.length() == 0) {
            return;
        }
        int i = this.f1478a;
        gVar.putString(d(i, 1), str);
        gVar.putString(d(i, 2), Long.toString(((Long) this.d).longValue()));
        gVar.putString(d(i, 3), Long.toString(((Long) this.e).longValue()));
    }

    @Override // io.ktor.utils.io.WriterSession
    public J1.b request(int i) {
        int i3;
        int i4 = this.f1478a;
        r rVar = (r) this.e;
        while (true) {
            i3 = rVar._availableForWrite$internal;
            if (i3 < 0) {
                i3 = 0;
                break;
            }
            if (r.c.compareAndSet(rVar, i3, 0)) {
                break;
            }
        }
        int i5 = i3 + i4;
        this.f1478a = i5;
        if (i5 < i) {
            return null;
        }
        ((U) this.b).q((ByteBuffer) this.c, i5);
        if (((ByteBuffer) this.c).remaining() < i) {
            return null;
        }
        l.Y((J1.b) this.d, (ByteBuffer) this.c);
        return (J1.b) this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
    public TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter javaTypeParameter) {
        h.f(javaTypeParameter, "javaTypeParameter");
        P p5 = (P) ((MemoizedFunctionToNullable) this.e).invoke(javaTypeParameter);
        return p5 != null ? p5 : ((C0946f) this.b).b.resolveTypeParameter(javaTypeParameter);
    }

    @Override // io.ktor.utils.io.WriterSuspendSession
    public Object tryAwait(int i, Continuation continuation) {
        ((U) this.b).getClass();
        int i3 = this.f1478a;
        m mVar = m.f1129a;
        if (i3 < i) {
            if (i3 > 0) {
                ((r) this.e).a(i3);
                this.f1478a = 0;
            }
            Object objT = ((U) this.b).T(i, continuation);
            if (objT == T1.a.f1304a) {
                return objT;
            }
        }
        return mVar;
    }

    @Override // io.ktor.utils.io.WriterSession
    public void written(int i) {
        int i3;
        if (i < 0 || i > (i3 = this.f1478a)) {
            if (i >= 0) {
                throw new IllegalStateException(B2.b.g(B2.b.j(i, "Unable to mark ", " bytes as written: only "), " were pre-locked.", this.f1478a));
            }
            throw new IllegalArgumentException(B2.b.c(i, "Written bytes count shouldn't be negative: "));
        }
        this.f1478a = i3 - i;
        U u = (U) this.b;
        ByteBuffer buffer = (ByteBuffer) this.c;
        r capacity = (r) this.e;
        u.getClass();
        h.f(buffer, "buffer");
        h.f(capacity, "capacity");
        u.g(buffer, capacity, i);
    }

    public b(int i, String str, Long l6, Long l7) {
        this.c = null;
        this.f1478a = i;
        this.b = str;
        this.d = l6;
        this.e = l7;
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            if (Charset.isSupported("UTF-8")) {
                this.c = URLEncoder.encode(str, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            Log.e("StoreAttribution", "Error UTF-8 encoding " + e(1) + " data " + str + ", " + e.getMessage());
        }
    }
}
