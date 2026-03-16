package B0;

import G0.C0067k1;
import G0.C0073m1;
import G0.C0076n1;
import G0.C0083q0;
import G0.C0084r0;
import G0.EnumC0052f1;
import G0.r1;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.crypto.tink.e;
import com.google.crypto.tink.f;
import com.google.crypto.tink.o;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.D;
import com.google.crypto.tink.shaded.protobuf.V;
import com.google.crypto.tink.subtle.q;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;
import java.util.concurrent.Executor;
import javax.inject.Provider;
import s.j;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Factory {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f117g;
    public Object b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f115a = null;
    public Object c = null;
    public Object d = null;
    public Object e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f116f = null;

    public static byte[] c(Context context, String str, String str2) throws CharConversionException {
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        Context applicationContext = context.getApplicationContext();
        try {
            String string = (str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0)).getString(str, null);
            if (string == null) {
                return null;
            }
            return q.c(string);
        } catch (ClassCastException | IllegalArgumentException unused) {
            throw new CharConversionException(androidx.constraintlayout.core.motion.a.q("can't read keyset; the pref value ", str, " is not a valid hex string"));
        }
    }

    public synchronized b a() {
        b bVar;
        try {
            if (((String) this.f115a) == null) {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            synchronized (b.b) {
                try {
                    byte[] bArrC = c((Context) this.b, (String) this.f115a, (String) this.c);
                    if (bArrC == null) {
                        if (((String) this.d) != null) {
                            this.e = e();
                        }
                        this.f117g = b();
                    } else if (((String) this.d) != null) {
                        this.f117g = d(bArrC);
                    } else {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrC);
                        try {
                            C0076n1 c0076n1W = C0076n1.w(byteArrayInputStream, D.a());
                            byteArrayInputStream.close();
                            this.f117g = new e((C0067k1) ((C0076n1) B2.d.i(c0076n1W).b).toBuilder(), 3);
                        } catch (Throwable th) {
                            byteArrayInputStream.close();
                            throw th;
                        }
                    }
                    bVar = new b(this);
                } finally {
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return bVar;
    }

    public e b() throws GeneralSecurityException, IOException {
        if (((f) this.f116f) == null) {
            throw new GeneralSecurityException("cannot read or generate keyset");
        }
        e eVar = new e(C0076n1.v(), 3);
        f fVar = (f) this.f116f;
        synchronized (eVar) {
            eVar.a(fVar.f2795a);
        }
        int keyId = o.a((C0076n1) eVar.c().b).getKeyInfo(0).getKeyId();
        synchronized (eVar) {
            for (int i = 0; i < ((C0067k1) eVar.b).getKeyCount(); i++) {
                try {
                    C0073m1 key = ((C0067k1) eVar.b).getKey(i);
                    if (key.getKeyId() == keyId) {
                        if (!key.getStatus().equals(EnumC0052f1.ENABLED)) {
                            throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + keyId);
                        }
                        C0067k1 c0067k1 = (C0067k1) eVar.b;
                        c0067k1.p();
                        C0076n1.t((C0076n1) c0067k1.b, keyId);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new GeneralSecurityException("key not found: " + keyId);
        }
        Context context = (Context) this.b;
        String str = (String) this.f115a;
        String str2 = (String) this.c;
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        Context applicationContext = context.getApplicationContext();
        SharedPreferences.Editor editorEdit = str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext).edit() : applicationContext.getSharedPreferences(str2, 0).edit();
        if (((c) this.e) != null) {
            B2.d dVarC = eVar.c();
            c cVar = (c) this.e;
            byte[] bArr = new byte[0];
            C0076n1 c0076n1 = (C0076n1) dVarC.b;
            byte[] bArrEncrypt = cVar.encrypt(c0076n1.toByteArray(), bArr);
            try {
                if (!C0076n1.x(cVar.decrypt(bArrEncrypt, bArr), D.a()).equals(c0076n1)) {
                    throw new GeneralSecurityException("cannot encrypt keyset");
                }
                C0083q0 c0083q0V = C0084r0.v();
                C0379n c0379nC = AbstractC0381o.c(bArrEncrypt, 0, bArrEncrypt.length);
                c0083q0V.p();
                C0084r0.t((C0084r0) c0083q0V.b, c0379nC);
                r1 r1VarA = o.a(c0076n1);
                c0083q0V.p();
                C0084r0.u((C0084r0) c0083q0V.b, r1VarA);
                if (!editorEdit.putString(str, q.d(((C0084r0) c0083q0V.build()).toByteArray())).commit()) {
                    throw new IOException("Failed to write to SharedPreferences");
                }
            } catch (V unused) {
                throw new GeneralSecurityException("invalid keyset, corrupted key material");
            }
        } else if (!editorEdit.putString(str, q.d(((C0076n1) eVar.c().b).toByteArray())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
        return eVar;
    }

    public e d(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        try {
            this.e = (c) new d().getAead((String) this.d);
            try {
                return new e((C0067k1) ((C0076n1) B2.d.m(new e(new ByteArrayInputStream(bArr), 2), (c) this.e).b).toBuilder(), 3);
            } catch (IOException | GeneralSecurityException e) {
                try {
                    byteArrayInputStream = new ByteArrayInputStream(bArr);
                    try {
                        C0076n1 c0076n1W = C0076n1.w(byteArrayInputStream, D.a());
                        byteArrayInputStream.close();
                        return new e((C0067k1) ((C0076n1) B2.d.i(c0076n1W).b).toBuilder(), 3);
                    } finally {
                    }
                } catch (IOException unused) {
                    throw e;
                }
            }
        } catch (GeneralSecurityException | ProviderException e6) {
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    C0076n1 c0076n1W2 = C0076n1.w(byteArrayInputStream, D.a());
                    byteArrayInputStream.close();
                    e eVar = new e((C0067k1) ((C0076n1) B2.d.i(c0076n1W2).b).toBuilder(), 3);
                    Log.w("b", "cannot use Android Keystore, it'll be disabled", e6);
                    return eVar;
                } finally {
                }
            } catch (IOException unused2) {
                throw e6;
            }
        }
    }

    public c e() throws KeyStoreException {
        d dVar = new d();
        try {
            boolean zA = d.a((String) this.d);
            try {
                return (c) dVar.getAead((String) this.d);
            } catch (GeneralSecurityException | ProviderException e) {
                if (!zA) {
                    throw new KeyStoreException(androidx.constraintlayout.core.motion.a.q("the master key ", (String) this.d, " exists but is unusable"), e);
                }
                Log.w("b", "cannot use Android Keystore, it'll be disabled", e);
                return null;
            }
        } catch (GeneralSecurityException | ProviderException e6) {
            Log.w("b", "cannot use Android Keystore, it'll be disabled", e6);
            return null;
        }
    }

    public void f(String str) {
        if (!str.startsWith("android-keystore://")) {
            throw new IllegalArgumentException("key URI must start with android-keystore://");
        }
        this.d = str;
    }

    public void g(Context context, String str, String str2) {
        if (context == null) {
            throw new IllegalArgumentException("need an Android context");
        }
        if (str == null) {
            throw new IllegalArgumentException("need a keyset name");
        }
        this.b = context;
        this.f115a = str;
        this.c = str2;
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new j((Context) ((com.google.android.material.snackbar.f) this.b).f2591a, (BackendRegistry) ((Provider) this.f115a).get(), (EventStore) ((Provider) this.c).get(), (WorkScheduler) ((B2.d) this.d).get(), (Executor) ((Provider) this.e).get(), (SynchronizationGuard) ((Provider) this.f116f).get(), new D.d(11, (byte) 0), new z5.b(10), (ClientHealthMetricsStore) ((Provider) this.f117g).get());
    }
}
