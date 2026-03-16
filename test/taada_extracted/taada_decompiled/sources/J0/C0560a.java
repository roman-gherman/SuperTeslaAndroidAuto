package j0;

import android.R;
import android.content.res.ColorStateList;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.color.g;

/* JADX INFO: renamed from: j0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0560a extends AppCompatRadioButton {
    public static final int[][] c = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ColorStateList f3645a;
    public boolean b;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f3645a == null) {
            int iF = g.f(this, fr.sd.taada.R.attr.colorControlActivated);
            int iF2 = g.f(this, fr.sd.taada.R.attr.colorOnSurface);
            int iF3 = g.f(this, fr.sd.taada.R.attr.colorSurface);
            this.f3645a = new ColorStateList(c, new int[]{g.g(iF3, iF, 1.0f), g.g(iF3, iF2, 0.54f), g.g(iF3, iF2, 0.38f), g.g(iF3, iF2, 0.38f)});
        }
        return this.f3645a;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b && CompoundButtonCompat.getButtonTintList(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z6) {
        this.b = z6;
        if (z6) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }
}
