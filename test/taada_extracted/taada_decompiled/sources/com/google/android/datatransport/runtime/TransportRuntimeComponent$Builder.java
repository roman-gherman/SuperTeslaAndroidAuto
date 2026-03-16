package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.BindsInstance;
import com.google.android.datatransport.runtime.dagger.Component;

/* JADX INFO: loaded from: classes.dex */
@Component.Builder
interface TransportRuntimeComponent$Builder {
    w build();

    @BindsInstance
    TransportRuntimeComponent$Builder setApplicationContext(Context context);
}
