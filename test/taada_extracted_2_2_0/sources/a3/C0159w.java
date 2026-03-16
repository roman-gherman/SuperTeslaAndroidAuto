package a3;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import h2.C0497B;
import java.util.Comparator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: a3.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0159w implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1557a;
    public final Object b;

    public /* synthetic */ C0159w(Object obj, int i) {
        this.f1557a = i;
        this.b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f1557a) {
            case 0:
                AbstractC0162z it = (AbstractC0162z) obj;
                kotlin.jvm.internal.h.e(it, "it");
                Function1 function1 = (Function1) this.b;
                String string = function1.invoke(it).toString();
                AbstractC0162z it2 = (AbstractC0162z) obj2;
                kotlin.jvm.internal.h.e(it2, "it");
                return E1.k.n(string, function1.invoke(it2).toString());
            case 1:
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                int iCompareTo = Boolean.valueOf(materialButton.f2263l).compareTo(Boolean.valueOf(materialButton2.f2263l));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                if (iCompareTo2 != 0) {
                    return iCompareTo2;
                }
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.b;
                return Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton)).compareTo(Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton2)));
            default:
                C0497B tmp0 = (C0497B) this.b;
                kotlin.jvm.internal.h.f(tmp0, "$tmp0");
                return ((Number) tmp0.mo5invoke(obj, obj2)).intValue();
        }
    }
}
