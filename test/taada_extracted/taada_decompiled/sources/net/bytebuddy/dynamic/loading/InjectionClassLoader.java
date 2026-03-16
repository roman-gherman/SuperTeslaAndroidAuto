package net.bytebuddy.dynamic.loading;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InjectionClassLoader extends ClassLoader {
    private final AtomicBoolean sealed;

    public enum Strategy implements ClassLoadingStrategy<InjectionClassLoader> {
        INSTANCE;

        @Override // net.bytebuddy.dynamic.loading.ClassLoadingStrategy
        public /* bridge */ /* synthetic */ Map load(@MaybeNull ClassLoader classLoader, Map map) {
            return load((InjectionClassLoader) classLoader, (Map<TypeDescription, byte[]>) map);
        }

        public Map<TypeDescription, Class<?>> load(@MaybeNull InjectionClassLoader injectionClassLoader, Map<TypeDescription, byte[]> map) {
            if (injectionClassLoader == null) {
                throw new IllegalArgumentException("Cannot add types to bootstrap class loader: " + map);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            HashMap map2 = new HashMap();
            for (Map.Entry<TypeDescription, byte[]> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey().getName(), entry.getValue());
                map2.put(entry.getKey().getName(), entry.getKey());
            }
            HashMap map3 = new HashMap();
            try {
                for (Map.Entry<String, Class<?>> entry2 : injectionClassLoader.defineClasses(linkedHashMap).entrySet()) {
                    map3.put(map2.get(entry2.getKey()), entry2.getValue());
                }
                return map3;
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Cannot load classes: " + map, e);
            }
        }
    }

    static {
        doRegisterAsParallelCapable();
    }

    public InjectionClassLoader(@MaybeNull ClassLoader classLoader, boolean z6) {
        super(classLoader);
        this.sealed = new AtomicBoolean(z6);
    }

    @SuppressFBWarnings(justification = "Must be invoked from targeting class loader type.", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
    private static void doRegisterAsParallelCapable() {
        try {
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public Class<?> defineClass(String str, byte[] bArr) {
        return defineClasses(Collections.singletonMap(str, bArr)).get(str);
    }

    public Map<String, Class<?>> defineClasses(Map<String, byte[]> map) {
        if (this.sealed.get()) {
            throw new IllegalStateException("Cannot inject classes into a sealed class loader");
        }
        return doDefineClasses(map);
    }

    public abstract Map<String, Class<?>> doDefineClasses(Map<String, byte[]> map);

    public boolean isSealed() {
        return this.sealed.get();
    }

    public boolean seal() {
        return !this.sealed.getAndSet(true);
    }
}
