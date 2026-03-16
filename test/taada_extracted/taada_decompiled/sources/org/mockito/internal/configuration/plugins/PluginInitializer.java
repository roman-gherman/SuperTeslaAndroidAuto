package org.mockito.internal.configuration.plugins;

import androidx.constraintlayout.core.motion.a;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import org.mockito.internal.util.collections.Iterables;
import org.mockito.plugins.PluginSwitch;

/* JADX INFO: loaded from: classes.dex */
class PluginInitializer {
    private final Set<String> alias;
    private final PluginSwitch pluginSwitch;

    public PluginInitializer(PluginSwitch pluginSwitch, Set<String> set) {
        this.pluginSwitch = pluginSwitch;
        this.alias = set;
    }

    public <T> T loadImpl(Class<T> cls) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ClassLoader.getSystemClassLoader();
        }
        try {
            Enumeration<URL> resources = contextClassLoader.getResources("mockito-extensions/".concat(cls.getName()));
            try {
                String strFindPluginClass = new PluginFinder(this.pluginSwitch).findPluginClass(Iterables.toIterable(resources));
                if (strFindPluginClass == null) {
                    return null;
                }
                if (this.alias.contains(strFindPluginClass)) {
                    strFindPluginClass = DefaultMockitoPlugins.getDefaultPluginClass(strFindPluginClass);
                }
                return cls.cast(contextClassLoader.loadClass(strFindPluginClass).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (Exception e) {
                throw new IllegalStateException("Failed to load " + cls + " implementation declared in " + resources, e);
            }
        } catch (IOException e6) {
            throw new IllegalStateException(a.j(cls, "Failed to load "), e6);
        }
    }

    public <T> List<T> loadImpls(Class<T> cls) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ClassLoader.getSystemClassLoader();
        }
        try {
            Enumeration<URL> resources = contextClassLoader.getResources("mockito-extensions/".concat(cls.getName()));
            try {
                List<String> listFindPluginClasses = new PluginFinder(this.pluginSwitch).findPluginClasses(Iterables.toIterable(resources));
                ArrayList arrayList = new ArrayList();
                for (String defaultPluginClass : listFindPluginClasses) {
                    if (this.alias.contains(defaultPluginClass)) {
                        defaultPluginClass = DefaultMockitoPlugins.getDefaultPluginClass(defaultPluginClass);
                    }
                    arrayList.add(cls.cast(contextClassLoader.loadClass(defaultPluginClass).getDeclaredConstructor(new Class[0]).newInstance(new Object[0])));
                }
                return arrayList;
            } catch (Exception e) {
                throw new IllegalStateException("Failed to load " + cls + " implementation declared in " + resources, e);
            }
        } catch (IOException e6) {
            throw new IllegalStateException(a.j(cls, "Failed to load "), e6);
        }
    }
}
