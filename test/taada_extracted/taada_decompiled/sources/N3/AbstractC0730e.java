package n3;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Delay;
import m3.AbstractC0690y;
import m3.p0;

/* JADX INFO: renamed from: n3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0730e extends p0 implements Delay {
    @Override // kotlinx.coroutines.Delay
    public final Object delay(long j6, Continuation continuation) {
        return AbstractC0690y.c(this, j6, continuation);
    }
}
