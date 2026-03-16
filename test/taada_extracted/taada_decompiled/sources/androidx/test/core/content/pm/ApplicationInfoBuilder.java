package androidx.test.core.content.pm;

import android.content.pm.ApplicationInfo;
import androidx.test.internal.util.Checks;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationInfoBuilder {
    private String name;
    private String packageName;

    private ApplicationInfoBuilder() {
    }

    public static ApplicationInfoBuilder newBuilder() {
        return new ApplicationInfoBuilder();
    }

    public ApplicationInfo build() {
        Checks.checkNotNull(this.packageName, "Mandatory field 'packageName' missing.");
        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.name = this.name;
        applicationInfo.packageName = this.packageName;
        return applicationInfo;
    }

    public ApplicationInfoBuilder setName(String str) {
        this.name = str;
        return this;
    }

    public ApplicationInfoBuilder setPackageName(String str) {
        this.packageName = str;
        return this;
    }
}
