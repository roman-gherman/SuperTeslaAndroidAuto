package org.bouncycastle.jcajce.provider.config;

import a4.C0163a;
import java.security.spec.DSAParameterSpec;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
public interface ProviderConfiguration {
    Set getAcceptableNamedCurves();

    Map getAdditionalECParameters();

    DHParameterSpec getDHDefaultParameters(int i);

    DSAParameterSpec getDSADefaultParameters(int i);

    C0163a getEcImplicitlyCa();
}
