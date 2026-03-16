package com.google.gson;

/* JADX INFO: loaded from: classes.dex */
public final class x implements ReflectionAccessFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3062a;

    @Override // com.google.gson.ReflectionAccessFilter
    public final y check(Class cls) {
        switch (this.f3062a) {
            case 0:
                String name = cls.getName();
                if (!name.startsWith("java.") && !name.startsWith("javax.")) {
                }
                break;
            case 1:
                String name2 = cls.getName();
                if (!name2.startsWith("java.") && !name2.startsWith("javax.")) {
                }
                break;
            case 2:
                String name3 = cls.getName();
                if (!name3.startsWith("android.") && !name3.startsWith("androidx.") && !name3.startsWith("java.") && !name3.startsWith("javax.")) {
                }
                break;
            default:
                String name4 = cls.getName();
                if (!name4.startsWith("android.") && !name4.startsWith("androidx.") && !name4.startsWith("java.") && !name4.startsWith("javax.") && !name4.startsWith("kotlin.") && !name4.startsWith("kotlinx.") && !name4.startsWith("scala.")) {
                }
                break;
        }
        return y.d;
    }
}
