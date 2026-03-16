package W;

import android.util.Property;
import android.view.ViewGroup;
import fr.sd.taada.R;

/* JADX INFO: loaded from: classes.dex */
public final class d extends Property {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f1381a = new d(Float.class, "childrenAlpha");

    @Override // android.util.Property
    public final Object get(Object obj) {
        Float f6 = (Float) ((ViewGroup) obj).getTag(R.id.mtrl_internal_children_alpha_tag);
        return f6 != null ? f6 : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        ViewGroup viewGroup = (ViewGroup) obj;
        Float f6 = (Float) obj2;
        float fFloatValue = f6.floatValue();
        viewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, f6);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setAlpha(fFloatValue);
        }
    }
}
