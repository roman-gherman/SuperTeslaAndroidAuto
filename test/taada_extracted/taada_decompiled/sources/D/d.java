package D;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.crypto.tink.subtle.EngineWrapper;
import com.google.gson.internal.ObjectConstructor;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Signature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Factory, EngineWrapper, ObjectConstructor, Clock {
    public static d b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f202a;

    public d(int i) {
        int i3;
        this.f202a = 10;
        HashMap map = new HashMap();
        int i4 = i - 2;
        int iNumberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(i4);
        int i5 = -i;
        int i6 = (2 - (i5 * i5)) * i5;
        int i7 = (2 - (i5 * i6)) * i6;
        int i8 = (2 - (i5 * i7)) * i7;
        int i9 = (2 - (i5 * i8)) * i8;
        for (int i10 = 1; i10 < iNumberOfLeadingZeros; i10++) {
            int i11 = 1 << (i10 - 1);
            if (i11 >= 64 && !map.containsKey(Integer.valueOf(i11))) {
                map.put(Integer.valueOf(i11), Integer.valueOf(a(i, i9, i11)));
            }
            int i12 = 1 << i10;
            if ((i4 & i12) != 0 && (i3 = (i12 - 1) & i4) >= 64 && !map.containsKey(Integer.valueOf(i3))) {
                map.put(Integer.valueOf(i3), Integer.valueOf(a(i, i9, i3)));
            }
        }
    }

    public static int a(int i, int i3, int i4) {
        int i5 = 1;
        while (i4 >= 32) {
            i5 = (int) ((((4294967295L & ((long) (i3 * i5))) * ((long) i)) + ((long) i5)) >>> 32);
            i4 -= 32;
        }
        if (i4 <= 0) {
            return i5;
        }
        return (int) ((((4294967295L & ((long) ((i3 * i5) & ((-1) >>> (-i4))))) * ((long) i)) + ((long) i5)) >>> i4);
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f202a) {
            case 7:
                return new ArrayList();
            default:
                return new LinkedHashMap();
        }
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new com.google.android.datatransport.runtime.s(Executors.newSingleThreadExecutor());
    }

    @Override // com.google.crypto.tink.subtle.EngineWrapper
    public Object getInstance(String str, Provider provider) {
        switch (this.f202a) {
            case 5:
                return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
            default:
                return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
        }
    }

    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return System.currentTimeMillis();
    }

    public /* synthetic */ d(int i, byte b2) {
        this.f202a = i;
    }
}
