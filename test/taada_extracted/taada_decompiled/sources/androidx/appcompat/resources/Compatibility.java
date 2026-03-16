package androidx.appcompat.resources;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class Compatibility {

    public static class Api15Impl {
        private Api15Impl() {
        }

        public static void getValueForDensity(Resources resources, int i, int i3, TypedValue typedValue, boolean z6) {
            resources.getValueForDensity(i, i3, typedValue, z6);
        }
    }

    public static class Api18Impl {
        private Api18Impl() {
        }

        public static void setAutoCancel(ObjectAnimator objectAnimator, boolean z6) {
            objectAnimator.setAutoCancel(z6);
        }
    }

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static Drawable createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            return Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
        }

        public static int getChangingConfigurations(TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }

        public static void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }
    }

    private Compatibility() {
    }
}
