package org.mockito.internal.configuration.plugins;

import androidx.constraintlayout.core.motion.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.mockito.plugins.AnnotationEngine;
import org.mockito.plugins.DoNotMockEnforcer;
import org.mockito.plugins.InstantiatorProvider2;
import org.mockito.plugins.MemberAccessor;
import org.mockito.plugins.MockMaker;
import org.mockito.plugins.MockitoLogger;
import org.mockito.plugins.MockitoPlugins;
import org.mockito.plugins.PluginSwitch;
import org.mockito.plugins.StackTraceCleanerProvider;

/* JADX INFO: loaded from: classes.dex */
public class DefaultMockitoPlugins implements MockitoPlugins {
    private static final Map<String, String> DEFAULT_PLUGINS;
    static final String INLINE_ALIAS = "mock-maker-inline";
    public static final Set<String> MOCK_MAKER_ALIASES;
    static final String MODULE_ALIAS = "member-accessor-module";
    static final String PROXY_ALIAS = "mock-maker-proxy";
    static final String SUBCLASS_ALIAS = "mock-maker-subclass";

    static {
        HashMap map = new HashMap();
        DEFAULT_PLUGINS = map;
        HashSet hashSet = new HashSet();
        MOCK_MAKER_ALIASES = hashSet;
        map.put(PluginSwitch.class.getName(), DefaultPluginSwitch.class.getName());
        map.put(MockMaker.class.getName(), "org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker");
        map.put(StackTraceCleanerProvider.class.getName(), "org.mockito.internal.exceptions.stacktrace.DefaultStackTraceCleanerProvider");
        map.put(InstantiatorProvider2.class.getName(), "org.mockito.internal.creation.instance.DefaultInstantiatorProvider");
        map.put(AnnotationEngine.class.getName(), "org.mockito.internal.configuration.InjectingAnnotationEngine");
        map.put("mock-maker-inline", "org.mockito.internal.creation.bytebuddy.InlineByteBuddyMockMaker");
        map.put("mock-maker-proxy", "org.mockito.internal.creation.proxy.ProxyMockMaker");
        map.put("mock-maker-subclass", "org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker");
        map.put(MockitoLogger.class.getName(), "org.mockito.internal.util.ConsoleMockitoLogger");
        map.put(MemberAccessor.class.getName(), "org.mockito.internal.util.reflection.ReflectionMemberAccessor");
        map.put(MODULE_ALIAS, "org.mockito.internal.util.reflection.ModuleMemberAccessor");
        map.put(DoNotMockEnforcer.class.getName(), "org.mockito.internal.configuration.DefaultDoNotMockEnforcer");
        hashSet.add("mock-maker-inline");
        hashSet.add("mock-maker-proxy");
        hashSet.add("mock-maker-subclass");
    }

    private <T> T create(Class<T> cls, String str) {
        if (str != null) {
            try {
                return cls.cast(Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (Exception e) {
                throw new IllegalStateException(a.j(cls, "Internal problem occurred, please report it. Mockito is unable to load the default implementation of class that is a part of Mockito distribution. Failed to load "), e);
            }
        }
        throw new IllegalStateException("No default implementation for requested Mockito plugin type: " + cls.getName() + "\nIs this a valid Mockito plugin type? If yes, please report this problem to Mockito team.\nOtherwise, please check if you are passing valid plugin type.\nExamples of valid plugin types: MockMaker, StackTraceCleanerProvider.");
    }

    public static String getDefaultPluginClass(String str) {
        return DEFAULT_PLUGINS.get(str);
    }

    @Override // org.mockito.plugins.MockitoPlugins
    public <T> T getDefaultPlugin(Class<T> cls) {
        return (T) create(cls, DEFAULT_PLUGINS.get(cls.getName()));
    }

    @Override // org.mockito.plugins.MockitoPlugins
    public MockMaker getInlineMockMaker() {
        return (MockMaker) create(MockMaker.class, DEFAULT_PLUGINS.get("mock-maker-inline"));
    }
}
