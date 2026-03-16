package androidx.core.view;

import android.view.ViewStructure;

/* JADX INFO: loaded from: classes.dex */
public class ViewStructureCompat {
    private final Object mWrappedObj;

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void setClassName(ViewStructure viewStructure, String str) {
            viewStructure.setClassName(str);
        }

        public static void setContentDescription(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        public static void setDimens(ViewStructure viewStructure, int i, int i3, int i4, int i5, int i6, int i7) {
            viewStructure.setDimens(i, i3, i4, i5, i6, i7);
        }

        public static void setText(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }
    }

    private ViewStructureCompat(ViewStructure viewStructure) {
        this.mWrappedObj = viewStructure;
    }

    public static ViewStructureCompat toViewStructureCompat(ViewStructure viewStructure) {
        return new ViewStructureCompat(viewStructure);
    }

    public void setClassName(String str) {
        Api23Impl.setClassName((ViewStructure) this.mWrappedObj, str);
    }

    public void setContentDescription(CharSequence charSequence) {
        Api23Impl.setContentDescription((ViewStructure) this.mWrappedObj, charSequence);
    }

    public void setDimens(int i, int i3, int i4, int i5, int i6, int i7) {
        Api23Impl.setDimens((ViewStructure) this.mWrappedObj, i, i3, i4, i5, i6, i7);
    }

    public void setText(CharSequence charSequence) {
        Api23Impl.setText((ViewStructure) this.mWrappedObj, charSequence);
    }

    public ViewStructure toViewStructure() {
        return (ViewStructure) this.mWrappedObj;
    }
}
