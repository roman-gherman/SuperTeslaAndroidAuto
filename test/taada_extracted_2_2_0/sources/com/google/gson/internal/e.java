package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class e implements ObjectConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2997a;
    public final /* synthetic */ InstanceCreator b;
    public final /* synthetic */ Type c;

    public /* synthetic */ e(InstanceCreator instanceCreator, Type type, int i) {
        this.f2997a = i;
        this.b = instanceCreator;
        this.c = type;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public final Object construct() {
        switch (this.f2997a) {
        }
        return this.b.createInstance(this.c);
    }
}
