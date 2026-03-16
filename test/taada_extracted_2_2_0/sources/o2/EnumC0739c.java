package o2;

import net.bytebuddy.implementation.MethodDelegation;

/* JADX INFO: renamed from: o2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public enum EnumC0739c {
    FIELD(null),
    FILE(null),
    PROPERTY(null),
    PROPERTY_GETTER("get"),
    PROPERTY_SETTER("set"),
    RECEIVER(null),
    CONSTRUCTOR_PARAMETER("param"),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD(MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4287a;

    EnumC0739c(String str) {
        this.f4287a = str == null ? C5.f.l0(name()) : str;
    }
}
