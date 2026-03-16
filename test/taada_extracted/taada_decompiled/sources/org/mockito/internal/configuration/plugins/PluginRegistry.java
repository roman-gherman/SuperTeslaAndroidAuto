package org.mockito.internal.configuration.plugins;

import java.util.List;
import org.mockito.plugins.AnnotationEngine;
import org.mockito.plugins.DoNotMockEnforcer;
import org.mockito.plugins.InstantiatorProvider2;
import org.mockito.plugins.MemberAccessor;
import org.mockito.plugins.MockMaker;
import org.mockito.plugins.MockResolver;
import org.mockito.plugins.MockitoLogger;
import org.mockito.plugins.PluginSwitch;
import org.mockito.plugins.StackTraceCleanerProvider;

/* JADX INFO: loaded from: classes.dex */
class PluginRegistry {
    private final AnnotationEngine annotationEngine;
    private final DoNotMockEnforcer doNotMockEnforcer;
    private final InstantiatorProvider2 instantiatorProvider;
    private final MemberAccessor memberAccessor;
    private final MockMaker mockMaker;
    private final List<MockResolver> mockResolvers;
    private final MockitoLogger mockitoLogger;
    private final PluginSwitch pluginSwitch;
    private final StackTraceCleanerProvider stackTraceCleanerProvider;

    public PluginRegistry() {
        PluginSwitch pluginSwitch = (PluginSwitch) new PluginLoader(new DefaultPluginSwitch()).loadPlugin(PluginSwitch.class);
        this.pluginSwitch = pluginSwitch;
        this.mockMaker = (MockMaker) new PluginLoader(pluginSwitch, (String[]) DefaultMockitoPlugins.MOCK_MAKER_ALIASES.toArray(new String[0])).loadPlugin(MockMaker.class);
        this.memberAccessor = (MemberAccessor) new PluginLoader(pluginSwitch, "member-accessor-module").loadPlugin(MemberAccessor.class);
        this.stackTraceCleanerProvider = (StackTraceCleanerProvider) new PluginLoader(pluginSwitch).loadPlugin(StackTraceCleanerProvider.class);
        this.annotationEngine = (AnnotationEngine) new PluginLoader(pluginSwitch).loadPlugin(AnnotationEngine.class);
        this.mockitoLogger = (MockitoLogger) new PluginLoader(pluginSwitch).loadPlugin(MockitoLogger.class);
        this.mockResolvers = new PluginLoader(pluginSwitch).loadPlugins(MockResolver.class);
        this.doNotMockEnforcer = (DoNotMockEnforcer) new PluginLoader(pluginSwitch).loadPlugin(DoNotMockEnforcer.class);
        this.instantiatorProvider = (InstantiatorProvider2) new PluginLoader(pluginSwitch).loadPlugin(InstantiatorProvider2.class);
    }

    public AnnotationEngine getAnnotationEngine() {
        return this.annotationEngine;
    }

    public DoNotMockEnforcer getDoNotMockEnforcer() {
        return this.doNotMockEnforcer;
    }

    public InstantiatorProvider2 getInstantiatorProvider() {
        return this.instantiatorProvider;
    }

    public MemberAccessor getMemberAccessor() {
        return this.memberAccessor;
    }

    public MockMaker getMockMaker() {
        return this.mockMaker;
    }

    public List<MockResolver> getMockResolvers() {
        return this.mockResolvers;
    }

    public MockitoLogger getMockitoLogger() {
        return this.mockitoLogger;
    }

    public StackTraceCleanerProvider getStackTraceCleanerProvider() {
        return this.stackTraceCleanerProvider;
    }
}
