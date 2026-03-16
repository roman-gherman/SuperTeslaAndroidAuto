package z5;

import android.os.SystemClock;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener;
import com.google.android.material.internal.r;
import com.google.crypto.tink.subtle.EngineWrapper;
import com.google.gson.internal.ObjectConstructor;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.security.MessageDigest;
import java.security.Provider;
import java.util.ArrayDeque;
import java.util.TreeMap;
import javax.crypto.KeyAgreement;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.strategy.InstantiatorStrategy;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import u5.c;

/* JADX INFO: loaded from: classes.dex */
public final class b implements InstantiatorStrategy, ILoggerFactory, ViewUtils$OnApplyWindowInsetsListener, EngineWrapper, ObjectConstructor, Clock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5217a;

    public /* synthetic */ b(int i) {
        this.f5217a = i;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f5217a) {
            case 6:
                return new ArrayDeque();
            default:
                return new TreeMap();
        }
    }

    @Override // com.google.crypto.tink.subtle.EngineWrapper
    public Object getInstance(String str, Provider provider) {
        switch (this.f5217a) {
            case 4:
                return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
            default:
                return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
        }
    }

    @Override // org.slf4j.ILoggerFactory
    public Logger getLogger(String str) {
        return C5.b.f176a;
    }

    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // org.objenesis.strategy.InstantiatorStrategy
    public ObjectInstantiator newInstantiatorOf(Class cls) {
        String str = a.b;
        if (!str.startsWith("Java HotSpot") && !str.startsWith("OpenJDK")) {
            if (!str.startsWith("Dalvik")) {
                return str.startsWith("GNU libgcj") ? new c(cls, 1) : str.startsWith("PERC") ? new s5.a(cls, 1) : new x5.a(cls);
            }
            if (a.d) {
                return new x5.a(cls);
            }
            int i = a.c;
            return i <= 10 ? new s5.a(cls, 0) : i <= 17 ? new s5.b(cls, 0) : new s5.b(cls, 1);
        }
        if (a.e == null || !a.f5216a.equals("1.7")) {
            return new u5.a(cls);
        }
        if (Serializable.class.isAssignableFrom(cls)) {
            return new c(cls, 0);
        }
        u5.a aVar = new u5.a();
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            aVar.b = declaredConstructor;
            if (declaredConstructor != null) {
                declaredConstructor.setAccessible(true);
            }
            return aVar;
        } catch (Exception e) {
            throw new r5.a(e);
        }
    }

    @Override // com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, r rVar) {
        rVar.d = windowInsetsCompat.getSystemWindowInsetBottom() + rVar.d;
        boolean z6 = ViewCompat.getLayoutDirection(view) == 1;
        int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
        int systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
        int i = rVar.f2507a + (z6 ? systemWindowInsetRight : systemWindowInsetLeft);
        rVar.f2507a = i;
        int i3 = rVar.c;
        if (!z6) {
            systemWindowInsetLeft = systemWindowInsetRight;
        }
        int i4 = i3 + systemWindowInsetLeft;
        rVar.c = i4;
        ViewCompat.setPaddingRelative(view, i, rVar.b, i4, rVar.d);
        return windowInsetsCompat;
    }
}
