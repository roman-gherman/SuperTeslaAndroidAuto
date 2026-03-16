package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.8")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002J\u001b\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H¦\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0000H¦\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u0010H¦\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH&¢\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0016"}, d2 = {"Lkotlin/time/ComparableTimeMark;", "Lkotlin/time/TimeMark;", "", "Ll3/a;", TypedValues.TransitionType.S_DURATION, "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "plus", "minus-LRDsOJo", "minus", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "", "compareTo", "(Lkotlin/time/ComparableTimeMark;)I", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalTime
public interface ComparableTimeMark extends TimeMark, Comparable<ComparableTimeMark> {
    int compareTo(@NotNull ComparableTimeMark other);

    boolean equals(@Nullable Object other);

    int hashCode();

    @Override // kotlin.time.TimeMark
    @NotNull
    /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
    ComparableTimeMark mo99minusLRDsOJo(long duration);

    /* JADX INFO: renamed from: minus-UwyO8pc, reason: not valid java name */
    long m100minusUwyO8pc(@NotNull ComparableTimeMark other);

    @Override // kotlin.time.TimeMark
    @NotNull
    /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
    ComparableTimeMark mo101plusLRDsOJo(long duration);
}
