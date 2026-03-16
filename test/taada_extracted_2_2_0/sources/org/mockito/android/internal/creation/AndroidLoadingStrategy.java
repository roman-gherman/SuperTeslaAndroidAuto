package org.mockito.android.internal.creation;

import java.io.File;
import net.bytebuddy.android.AndroidClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.creation.bytebuddy.SubclassLoader;
import org.mockito.internal.util.StringUtil;

/* JADX INFO: loaded from: classes.dex */
class AndroidLoadingStrategy implements SubclassLoader {
    @Override // org.mockito.internal.creation.bytebuddy.SubclassLoader
    public boolean isDisrespectingOpenness() {
        return false;
    }

    @Override // org.mockito.internal.creation.bytebuddy.SubclassLoader
    public ClassLoadingStrategy<ClassLoader> resolveStrategy(Class<?> cls, ClassLoader classLoader, boolean z6) {
        File file = AndroidTempFileLocator.target;
        if (file != null) {
            return new AndroidClassLoadingStrategy.Injecting(file);
        }
        throw new MockitoException(StringUtil.join("Could not look up implicit location for storing generated classes", "", "You can configure an explicit location by setting the system property", "'org.mockito.android.target' to a folder for storing generated class files", "This location must be in private scope for most API versions, for example:", "", "MyActivity.this.getDir(\"target\", Context.MODE_PRIVATE)", "or", "getInstrumentation().getTargetContext().getCacheDir().getPath()"));
    }
}
