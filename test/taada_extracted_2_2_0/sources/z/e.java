package z;

import C0.x;
import a3.AbstractC0162z;
import a3.K;
import a3.U;
import a3.b0;
import a3.d0;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.datatransport.Transformer;
import com.google.android.gms.internal.play_billing.a2;
import com.google.crypto.tink.subtle.EngineWrapper;
import com.google.gson.internal.ObjectConstructor;
import f.s;
import java.security.Provider;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Transformer, EngineWrapper, ObjectConstructor {
    public static e b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5162a;

    public /* synthetic */ e(int i) {
        this.f5162a = i;
    }

    public static U a(TypeParameterDescriptor typeParameterDescriptor, B2.a typeAttr, B.h typeParameterUpperBoundEraser, AbstractC0162z abstractC0162z) {
        kotlin.jvm.internal.h.f(typeAttr, "typeAttr");
        kotlin.jvm.internal.h.f(typeParameterUpperBoundEraser, "typeParameterUpperBoundEraser");
        if (!typeAttr.c) {
            typeAttr = typeAttr.b(1);
        }
        int iB = s.b(typeAttr.b);
        d0 d0Var = d0.INVARIANT;
        if (iB != 0 && iB != 1) {
            if (iB == 2) {
                return new K(abstractC0162z, d0Var);
            }
            throw new x();
        }
        if (!typeParameterDescriptor.getVariance().b) {
            return new K(R2.e.e(typeParameterDescriptor).m(), d0Var);
        }
        List<TypeParameterDescriptor> parameters = abstractC0162z.c().getParameters();
        kotlin.jvm.internal.h.e(parameters, "erasedUpperBound.constructor.parameters");
        return !parameters.isEmpty() ? new K(abstractC0162z, d0.OUT_VARIANCE) : b0.l(typeParameterDescriptor, typeAttr);
    }

    public static final i b(PackageInfo packageInfo, i... iVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            j jVar = new j(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < iVarArr.length; i++) {
                if (iVarArr[i].equals(jVar)) {
                    return iVarArr[i];
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean c(android.content.pm.PackageInfo r4) {
        /*
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L2c
            java.lang.String r2 = "com.android.vending"
            java.lang.String r3 = r4.packageName
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L1c
            java.lang.String r2 = r4.packageName
            java.lang.String r3 = "com.google.android.gms"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L19
            goto L1c
        L19:
            r2 = r4
        L1a:
            r3 = r0
            goto L2e
        L1c:
            android.content.pm.ApplicationInfo r2 = r4.applicationInfo
            if (r2 != 0) goto L22
        L20:
            r2 = r1
            goto L29
        L22:
            int r2 = r2.flags
            r2 = r2 & 129(0x81, float:1.81E-43)
            if (r2 == 0) goto L20
            r2 = r0
        L29:
            r3 = r2
            r2 = r4
            goto L2e
        L2c:
            r2 = 0
            goto L1a
        L2e:
            if (r4 == 0) goto L4c
            android.content.pm.Signature[] r4 = r2.signatures
            if (r4 == 0) goto L4c
            if (r3 == 0) goto L3d
            z.i[] r4 = z.k.f5166a
            z.i r4 = b(r2, r4)
            goto L49
        L3d:
            z.i[] r4 = z.k.f5166a
            r4 = r4[r1]
            z.i[] r4 = new z.i[]{r4}
            z.i r4 = b(r2, r4)
        L49:
            if (r4 == 0) goto L4c
            return r0
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: z.e.c(android.content.pm.PackageInfo):boolean");
    }

    @Override // com.google.android.datatransport.Transformer
    public Object apply(Object obj) {
        return ((a2) obj).b();
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f5162a) {
            case 6:
                return new LinkedHashSet();
            default:
                return new ConcurrentHashMap();
        }
    }

    @Override // com.google.crypto.tink.subtle.EngineWrapper
    public Object getInstance(String str, Provider provider) {
        switch (this.f5162a) {
            case 4:
                return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
            default:
                return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
        }
    }
}
