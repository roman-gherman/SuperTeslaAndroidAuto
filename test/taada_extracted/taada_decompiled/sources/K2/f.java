package K2;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends I2.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f939h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f940f;

    static {
        f fVar = new f(new int[]{1, 8, 0}, false);
        f938g = fVar;
        int i = fVar.c;
        int i3 = fVar.b;
        f939h = (i3 == 1 && i == 9) ? new f(new int[]{2, 0, 0}, false) : new f(new int[]{i3, i + 1, 0}, false);
        new f(new int[0], false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(int[] versionArray, boolean z6) {
        super(Arrays.copyOf(versionArray, versionArray.length));
        kotlin.jvm.internal.h.f(versionArray, "versionArray");
        this.f940f = z6;
    }

    public final boolean b(f metadataVersionFromLanguageVersion) {
        kotlin.jvm.internal.h.f(metadataVersionFromLanguageVersion, "metadataVersionFromLanguageVersion");
        f fVar = f938g;
        int i = this.b;
        int i3 = this.c;
        if (i == 2 && i3 == 0 && fVar.b == 1 && fVar.c == 8) {
            return true;
        }
        if (!this.f940f) {
            fVar = f939h;
        }
        fVar.getClass();
        int i4 = metadataVersionFromLanguageVersion.b;
        int i5 = fVar.b;
        if (i5 > i4 || (i5 >= i4 && fVar.c > metadataVersionFromLanguageVersion.c)) {
            metadataVersionFromLanguageVersion = fVar;
        }
        boolean z6 = false;
        if ((i == 1 && i3 == 0) || i == 0) {
            return false;
        }
        int i6 = metadataVersionFromLanguageVersion.b;
        if (i > i6 || (i >= i6 && i3 > metadataVersionFromLanguageVersion.c)) {
            z6 = true;
        }
        return !z6;
    }
}
