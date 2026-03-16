package n0;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import androidx.work.WorkRequest;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.material.color.ColorResourcesOverride;
import com.google.crypto.tink.subtle.EngineWrapper;
import com.google.gson.internal.ObjectConstructor;
import fr.sd.taada.R;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider;
import z2.C0946f;

/* JADX INFO: loaded from: classes.dex */
public class d implements StatusExceptionMapper, SyntheticJavaPartsProvider, ColorResourcesOverride, EngineWrapper, ObjectConstructor, Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4164a;

    public /* synthetic */ d(int i) {
        this.f4164a = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static l2.C0620d a(java.lang.String r7, L2.c r8) {
        /*
            l2.e[] r0 = l2.EnumC0621e.values()
            int r1 = r0.length
            r2 = 0
            r3 = r2
        L7:
            r4 = 0
            if (r3 >= r1) goto L20
            r5 = r0[r3]
            L2.c r6 = r5.f3973a
            boolean r6 = kotlin.jvm.internal.h.a(r6, r8)
            if (r6 == 0) goto L1d
            java.lang.String r6 = r5.b
            boolean r6 = kotlin.text.r.C(r7, r6)
            if (r6 == 0) goto L1d
            goto L21
        L1d:
            int r3 = r3 + 1
            goto L7
        L20:
            r5 = r4
        L21:
            if (r5 != 0) goto L24
            goto L64
        L24:
            java.lang.String r8 = r5.b
            int r8 = r8.length()
            java.lang.String r7 = r7.substring(r8)
            java.lang.String r8 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.h.e(r7, r8)
            int r8 = r7.length()
            if (r8 != 0) goto L3b
        L39:
            r7 = r4
            goto L58
        L3b:
            int r8 = r7.length()
            r0 = r2
        L40:
            if (r2 >= r8) goto L54
            char r1 = r7.charAt(r2)
            int r1 = r1 + (-48)
            if (r1 < 0) goto L39
            r3 = 10
            if (r1 >= r3) goto L39
            int r0 = r0 * 10
            int r0 = r0 + r1
            int r2 = r2 + 1
            goto L40
        L54:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
        L58:
            if (r7 == 0) goto L64
            int r7 = r7.intValue()
            l2.d r8 = new l2.d
            r8.<init>(r5, r7)
            return r8
        L64:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.d.a(java.lang.String, L2.c):l2.d");
    }

    @Override // com.google.android.material.color.ColorResourcesOverride
    public boolean applyIfPossible(Context context, Map map) {
        View viewPeekDecorView;
        Context context2;
        if (!com.google.android.material.color.g.b(context, map)) {
            return false;
        }
        context.getTheme().applyStyle(R.style.ThemeOverlay_Material3_PersonalizedColors, true);
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            Resources.Theme theme = (window == null || (viewPeekDecorView = window.peekDecorView()) == null || (context2 = viewPeekDecorView.getContext()) == null) ? null : context2.getTheme();
            if (theme != null) {
                theme.applyStyle(R.style.ThemeOverlay_Material3_PersonalizedColors, true);
            }
        }
        return true;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f4164a) {
            case 6:
                return new TreeSet();
            case 7:
                return new ConcurrentSkipListMap();
            default:
                return new com.google.gson.internal.n(true);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateConstructors(C0946f _context_receiver_0, ClassDescriptor thisDescriptor, List result) {
        kotlin.jvm.internal.h.f(_context_receiver_0, "_context_receiver_0");
        kotlin.jvm.internal.h.f(thisDescriptor, "thisDescriptor");
        kotlin.jvm.internal.h.f(result, "result");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateMethods(C0946f _context_receiver_0, ClassDescriptor thisDescriptor, L2.f name, Collection result) {
        kotlin.jvm.internal.h.f(_context_receiver_0, "_context_receiver_0");
        kotlin.jvm.internal.h.f(thisDescriptor, "thisDescriptor");
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(result, "result");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateNestedClass(C0946f _context_receiver_0, ClassDescriptor thisDescriptor, L2.f name, List result) {
        kotlin.jvm.internal.h.f(_context_receiver_0, "_context_receiver_0");
        kotlin.jvm.internal.h.f(thisDescriptor, "thisDescriptor");
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(result, "result");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateStaticFunctions(C0946f _context_receiver_0, ClassDescriptor thisDescriptor, L2.f name, Collection result) {
        kotlin.jvm.internal.h.f(_context_receiver_0, "_context_receiver_0");
        kotlin.jvm.internal.h.f(thisDescriptor, "thisDescriptor");
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(result, "result");
    }

    @Override // javax.inject.Provider
    public Object get() {
        D.d dVar = new D.d(11, (byte) 0);
        HashMap map = new HashMap();
        k.d dVar2 = k.d.f3677a;
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(dVar2, new s.b(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, 86400000L, set));
        k.d dVar3 = k.d.c;
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(dVar3, new s.b(1000L, 86400000L, set));
        k.d dVar4 = k.d.b;
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(s.d.b)));
        if (setUnmodifiableSet == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(dVar4, new s.b(86400000L, 86400000L, setUnmodifiableSet));
        if (map.keySet().size() < k.d.values().length) {
            throw new IllegalStateException("Not all priorities have been configured");
        }
        new HashMap();
        return new s.a(dVar, map);
    }

    @Override // com.google.android.gms.common.api.internal.StatusExceptionMapper
    public Exception getException(Status status) {
        return status.c != null ? new A.f(status) : new A.a(status);
    }

    @Override // com.google.crypto.tink.subtle.EngineWrapper
    public Object getInstance(String str, Provider provider) {
        return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List getMethodNames(C0946f _context_receiver_0, ClassDescriptor thisDescriptor) {
        kotlin.jvm.internal.h.f(_context_receiver_0, "_context_receiver_0");
        kotlin.jvm.internal.h.f(thisDescriptor, "thisDescriptor");
        return new ArrayList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List getNestedClassNames(C0946f _context_receiver_0, ClassDescriptor thisDescriptor) {
        kotlin.jvm.internal.h.f(_context_receiver_0, "_context_receiver_0");
        kotlin.jvm.internal.h.f(thisDescriptor, "thisDescriptor");
        return new ArrayList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List getStaticFunctionNames(C0946f _context_receiver_0, ClassDescriptor thisDescriptor) {
        kotlin.jvm.internal.h.f(_context_receiver_0, "_context_receiver_0");
        kotlin.jvm.internal.h.f(thisDescriptor, "thisDescriptor");
        return new ArrayList();
    }

    @Override // com.google.android.material.color.ColorResourcesOverride
    public Context wrapContextIfPossible(Context context, Map map) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, R.style.ThemeOverlay_Material3_PersonalizedColors);
        contextThemeWrapper.applyOverrideConfiguration(new Configuration());
        return com.google.android.material.color.g.b(contextThemeWrapper, map) ? contextThemeWrapper : context;
    }
}
