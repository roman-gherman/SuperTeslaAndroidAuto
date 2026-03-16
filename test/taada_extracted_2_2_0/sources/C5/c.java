package C5;

import java.io.Serializable;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Logger, Serializable {
    private static final long serialVersionUID = 7535258609338176893L;

    public Object readResolve() {
        return A5.a.e("NOP");
    }
}
