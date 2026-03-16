package org.mockito.internal.configuration;

import java.io.Serializable;
import org.mockito.configuration.DefaultMockitoConfiguration;
import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.plugins.AnnotationEngine;
import org.mockito.stubbing.Answer;

/* JADX INFO: loaded from: classes.dex */
public class GlobalConfiguration implements IMockitoConfiguration, Serializable {
    private static final ThreadLocal<IMockitoConfiguration> GLOBAL_CONFIGURATION = new ThreadLocal<>();
    private static final long serialVersionUID = -2860353062105505938L;

    public GlobalConfiguration() {
        ThreadLocal<IMockitoConfiguration> threadLocal = GLOBAL_CONFIGURATION;
        if (threadLocal.get() == null) {
            threadLocal.set(createConfig());
        }
    }

    private IMockitoConfiguration createConfig() {
        DefaultMockitoConfiguration defaultMockitoConfiguration = new DefaultMockitoConfiguration();
        IMockitoConfiguration iMockitoConfigurationLoadConfiguration = new ClassPathLoader().loadConfiguration();
        return iMockitoConfigurationLoadConfiguration != null ? iMockitoConfigurationLoadConfiguration : defaultMockitoConfiguration;
    }

    public static void validate() {
        new GlobalConfiguration();
    }

    @Override // org.mockito.configuration.IMockitoConfiguration
    public boolean cleansStackTrace() {
        return GLOBAL_CONFIGURATION.get().cleansStackTrace();
    }

    @Override // org.mockito.configuration.IMockitoConfiguration
    public boolean enableClassCache() {
        return GLOBAL_CONFIGURATION.get().enableClassCache();
    }

    @Override // org.mockito.configuration.IMockitoConfiguration
    public Answer<Object> getDefaultAnswer() {
        return GLOBAL_CONFIGURATION.get().getDefaultAnswer();
    }

    public IMockitoConfiguration getIt() {
        return GLOBAL_CONFIGURATION.get();
    }

    public AnnotationEngine tryGetPluginAnnotationEngine() {
        return Plugins.getAnnotationEngine();
    }
}
