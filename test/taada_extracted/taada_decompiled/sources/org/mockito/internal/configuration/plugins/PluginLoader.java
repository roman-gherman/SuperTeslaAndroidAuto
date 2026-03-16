package org.mockito.internal.configuration.plugins;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.mockito.plugins.PluginSwitch;

/* JADX INFO: loaded from: classes.dex */
class PluginLoader {
    private final PluginInitializer initializer;
    private final DefaultMockitoPlugins plugins;

    public PluginLoader(DefaultMockitoPlugins defaultMockitoPlugins, PluginInitializer pluginInitializer) {
        this.plugins = defaultMockitoPlugins;
        this.initializer = pluginInitializer;
    }

    public <T> T loadPlugin(Class<T> cls) {
        return (T) loadPlugin(cls, null);
    }

    public <T> List<T> loadPlugins(final Class<T> cls) {
        try {
            return this.initializer.loadImpls(cls);
        } catch (Throwable th) {
            return Collections.singletonList(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: org.mockito.internal.configuration.plugins.PluginLoader.2
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    throw new IllegalStateException("Could not initialize plugin: " + cls, th);
                }
            }));
        }
    }

    public <PreferredT, AlternateType> Object loadPlugin(final Class<PreferredT> cls, final Class<AlternateType> cls2) {
        Object objLoadImpl;
        try {
            Object objLoadImpl2 = this.initializer.loadImpl(cls);
            return objLoadImpl2 != null ? objLoadImpl2 : (cls2 == null || (objLoadImpl = this.initializer.loadImpl(cls2)) == null) ? this.plugins.getDefaultPlugin(cls) : objLoadImpl;
        } catch (Throwable th) {
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: org.mockito.internal.configuration.plugins.PluginLoader.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    throw new IllegalStateException("Could not initialize plugin: " + cls + " (alternate: " + cls2 + ")", th);
                }
            });
        }
    }

    public PluginLoader(PluginSwitch pluginSwitch) {
        this(new DefaultMockitoPlugins(), new PluginInitializer(pluginSwitch, Collections.EMPTY_SET));
    }

    public PluginLoader(PluginSwitch pluginSwitch, String... strArr) {
        this(new DefaultMockitoPlugins(), new PluginInitializer(pluginSwitch, new HashSet(Arrays.asList(strArr))));
    }
}
