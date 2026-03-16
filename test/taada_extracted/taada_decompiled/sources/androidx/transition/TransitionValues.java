package androidx.transition;

import B2.b;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TransitionValues {
    public View view;
    public final Map<String, Object> values = new HashMap();
    final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sbL = b.l("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbL.append(this.view);
        sbL.append("\n");
        String strE = b.e(sbL.toString(), "    values:");
        for (String str : this.values.keySet()) {
            strE = strE + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return strE;
    }

    public TransitionValues(View view) {
        this.view = view;
    }
}
