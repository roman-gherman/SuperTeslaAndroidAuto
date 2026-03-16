package kotlinx.coroutines;

import N1.a;
import N1.m;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.selects.SelectClause0;
import m3.C0666a0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 42\u00020\u0001:\u00015J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\u000b\u0010\rJ\u001b\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u000b\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J8\u0010\u001d\u001a\u00020\u001c2'\u0010\u001b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0017j\u0002`\u001aH&¢\u0006\u0004\b\u001d\u0010\u001eJL\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00062'\u0010\u001b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0017j\u0002`\u001aH'¢\u0006\u0004\b\u001d\u0010!J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0000H\u0097\u0002¢\u0006\u0004\b#\u0010$R\u001c\u0010(\u001a\u0004\u0018\u00010\u00008&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\r\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\bR\u0014\u0010*\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\bR\u0014\u0010+\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\bR\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00000,8&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008&X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u00102\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "", "start", "()Z", "cause", "LN1/m;", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "()V", "", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "other", "plus", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/Job;", "getParent", "()Lkotlinx/coroutines/Job;", "getParent$annotations", "parent", "isActive", "isCompleted", "isCancelled", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "Key", "m3/a0", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Job extends CoroutineContext.Element {

    @NotNull
    public static final C0666a0 Key = C0666a0.f4118a;

    @InternalCoroutinesApi
    @NotNull
    ChildHandle attachChild(@NotNull ChildJob child);

    @Deprecated(level = a.c, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    void cancel(@Nullable CancellationException cause);

    @Deprecated(level = a.c, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean cancel(Throwable cause);

    @InternalCoroutinesApi
    @NotNull
    CancellationException getCancellationException();

    @NotNull
    Sequence<Job> getChildren();

    @NotNull
    SelectClause0 getOnJoin();

    @Nullable
    Job getParent();

    @NotNull
    DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, m> handler);

    @InternalCoroutinesApi
    @NotNull
    DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, @NotNull Function1<? super Throwable, m> handler);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @Nullable
    Object join(@NotNull Continuation<? super m> continuation);

    @Deprecated(level = a.b, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    Job plus(@NotNull Job other);

    boolean start();
}
