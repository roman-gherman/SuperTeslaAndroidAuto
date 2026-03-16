package androidx.room;

import N1.m;
import android.os.CancellationSignal;
import androidx.sqlite.db.SupportSQLiteCompat;
import fr.sd.taada.helpers.LocaleHelper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "", LocaleHelper.LANGUAGE_ITALIAN, "LN1/m;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class CoroutinesRoom$Companion$execute$4$1 extends i implements Function1<Throwable, m> {
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ Job $job;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$execute$4$1(CancellationSignal cancellationSignal, Job job) {
        super(1);
        this.$cancellationSignal = cancellationSignal;
        this.$job = job;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ m invoke(Throwable th) {
        invoke2(th);
        return m.f1129a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        CancellationSignal cancellationSignal = this.$cancellationSignal;
        if (cancellationSignal != null) {
            SupportSQLiteCompat.Api16Impl.cancel(cancellationSignal);
        }
        this.$job.cancel((CancellationException) null);
    }
}
