package V0;

import com.tenjin.android.params.base.ParamProvider;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements ParamProvider {
    @Override // com.tenjin.android.params.base.ParamProvider
    public final Map getParams() {
        return apply(new HashMap());
    }
}
