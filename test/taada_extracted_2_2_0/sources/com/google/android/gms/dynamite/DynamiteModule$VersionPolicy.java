package com.google.android.gms.dynamite;

import N.a;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface DynamiteModule$VersionPolicy {

    public interface IVersions {
        int zza(Context context, String str);

        int zzb(Context context, String str, boolean z6);
    }

    a selectModule(Context context, String str, IVersions iVersions);
}
