package org.mockito.internal.configuration;

import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.exceptions.misusing.MockitoConfigurationException;

/* JADX INFO: loaded from: classes.dex */
public class ClassPathLoader {
    public static final String MOCKITO_CONFIGURATION_CLASS_NAME = "org.mockito.configuration.MockitoConfiguration";

    public IMockitoConfiguration loadConfiguration() {
        try {
            try {
                return (IMockitoConfiguration) Class.forName(MOCKITO_CONFIGURATION_CLASS_NAME).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassCastException e) {
                throw new MockitoConfigurationException("MockitoConfiguration class must implement " + IMockitoConfiguration.class.getName() + " interface.", e);
            } catch (Exception e6) {
                throw new MockitoConfigurationException("Unable to instantiate org.mockito.configuration.MockitoConfiguration class. Does it have a safe, no-arg constructor?", e6);
            }
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
