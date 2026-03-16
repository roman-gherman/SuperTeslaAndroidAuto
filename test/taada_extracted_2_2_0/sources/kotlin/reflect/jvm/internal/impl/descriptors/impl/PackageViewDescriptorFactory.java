package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import L2.c;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import q2.C0763B;
import q2.E;

/* JADX INFO: loaded from: classes2.dex */
public interface PackageViewDescriptorFactory {

    @NotNull
    public static final E Companion = E.f4544a;

    @NotNull
    PackageViewDescriptor compute(@NotNull C0763B c0763b, @NotNull c cVar, @NotNull StorageManager storageManager);
}
