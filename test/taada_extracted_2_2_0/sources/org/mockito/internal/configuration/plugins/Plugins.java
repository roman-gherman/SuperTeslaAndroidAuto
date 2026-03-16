package org.mockito.internal.configuration.plugins;

import java.util.List;
import org.mockito.plugins.AnnotationEngine;
import org.mockito.plugins.DoNotMockEnforcer;
import org.mockito.plugins.InstantiatorProvider2;
import org.mockito.plugins.MemberAccessor;
import org.mockito.plugins.MockMaker;
import org.mockito.plugins.MockResolver;
import org.mockito.plugins.MockitoLogger;
import org.mockito.plugins.MockitoPlugins;
import org.mockito.plugins.StackTraceCleanerProvider;

/* JADX INFO: loaded from: classes.dex */
public final class Plugins {
    private static final PluginRegistry registry = new PluginRegistry();

    private Plugins() {
    }

    public static AnnotationEngine getAnnotationEngine() {
        return registry.getAnnotationEngine();
    }

    public static DoNotMockEnforcer getDoNotMockEnforcer() {
        return registry.getDoNotMockEnforcer();
    }

    public static InstantiatorProvider2 getInstantiatorProvider() {
        return registry.getInstantiatorProvider();
    }

    public static MemberAccessor getMemberAccessor() {
        return registry.getMemberAccessor();
    }

    public static MockMaker getMockMaker() {
        return registry.getMockMaker();
    }

    public static List<MockResolver> getMockResolvers() {
        return registry.getMockResolvers();
    }

    public static MockitoLogger getMockitoLogger() {
        return registry.getMockitoLogger();
    }

    public static MockitoPlugins getPlugins() {
        return new DefaultMockitoPlugins();
    }

    public static StackTraceCleanerProvider getStackTraceCleanerProvider() {
        return registry.getStackTraceCleanerProvider();
    }
}
