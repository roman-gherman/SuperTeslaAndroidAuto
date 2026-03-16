package org.mockito.android.internal.creation;

import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker;
import org.mockito.internal.util.Platform;
import org.mockito.internal.util.StringUtil;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.MockMaker;

/* JADX INFO: loaded from: classes.dex */
public class AndroidByteBuddyMockMaker implements MockMaker {
    private final MockMaker delegate;

    public AndroidByteBuddyMockMaker() {
        if (Platform.isAndroid() || Platform.isAndroidMockMakerRequired()) {
            this.delegate = new SubclassByteBuddyMockMaker(new AndroidLoadingStrategy());
        } else {
            Plugins.getMockitoLogger().log(StringUtil.join("IMPORTANT NOTE FROM MOCKITO:", "", "You included the 'mockito-android' dependency in a non-Android environment.", "The Android mock maker was disabled. You should only include the latter in your 'androidTestCompile' configuration", "If disabling was a mistake, you can set the 'org.mockito.mock.android' property to 'true' to override this detection.", "", "Visit https://javadoc.io/page/org.mockito/mockito-core/latest/org/mockito/Mockito.html#0.1 for more information"));
            this.delegate = new SubclassByteBuddyMockMaker();
        }
    }

    @Override // org.mockito.plugins.MockMaker
    public void clearAllCaches() {
        this.delegate.clearAllCaches();
    }

    @Override // org.mockito.plugins.MockMaker
    public <T> T createMock(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        return (T) this.delegate.createMock(mockCreationSettings, mockHandler);
    }

    @Override // org.mockito.plugins.MockMaker
    public MockHandler getHandler(Object obj) {
        return this.delegate.getHandler(obj);
    }

    @Override // org.mockito.plugins.MockMaker
    public MockMaker.TypeMockability isTypeMockable(Class<?> cls) {
        return this.delegate.isTypeMockable(cls);
    }

    @Override // org.mockito.plugins.MockMaker
    public void resetMock(Object obj, MockHandler mockHandler, MockCreationSettings mockCreationSettings) {
        this.delegate.resetMock(obj, mockHandler, mockCreationSettings);
    }
}
