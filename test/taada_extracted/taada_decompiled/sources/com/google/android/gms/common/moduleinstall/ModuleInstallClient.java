package com.google.android.gms.common.moduleinstall;

import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.api.a;
import com.google.android.gms.tasks.b;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* JADX INFO: loaded from: classes.dex */
public interface ModuleInstallClient extends HasApiKey<a> {
    b areModulesAvailable(OptionalModuleApi... optionalModuleApiArr);

    b deferredInstall(OptionalModuleApi... optionalModuleApiArr);

    b getInstallModulesIntent(OptionalModuleApi... optionalModuleApiArr);

    @ResultIgnorabilityUnspecified
    b installModules(G.a aVar);

    b releaseModules(OptionalModuleApi... optionalModuleApiArr);

    @ResultIgnorabilityUnspecified
    b unregisterListener(InstallStatusListener installStatusListener);
}
