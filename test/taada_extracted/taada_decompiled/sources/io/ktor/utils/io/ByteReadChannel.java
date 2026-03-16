package io.ktor.utils.io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\bf\u0018\u0000 ^2\u00020\u0001:\u0001_J-\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b\b\u0010\tJ+\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u000eJ\u001b\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0010J\u001b\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0011J+\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000eJ#\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0014J\u001b\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0011J\u001b\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u0019H¦@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u0019H¦@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001eJ\u0013\u0010!\u001a\u00020 H¦@ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001eJ\u0013\u0010#\u001a\u00020\"H¦@ø\u0001\u0000¢\u0006\u0004\b#\u0010\u001eJ\u0013\u0010%\u001a\u00020$H¦@ø\u0001\u0000¢\u0006\u0004\b%\u0010\u001eJ\u0013\u0010'\u001a\u00020&H¦@ø\u0001\u0000¢\u0006\u0004\b'\u0010\u001eJ\u0013\u0010)\u001a\u00020(H¦@ø\u0001\u0000¢\u0006\u0004\b)\u0010\u001eJ(\u0010-\u001a\u00020\u00062\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b+H'¢\u0006\u0004\b-\u0010.J<\u00102\u001a\u00020\u00062'\u0010,\u001a#\b\u0001\u0012\u0004\u0012\u000200\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000601\u0012\u0006\u0012\u0004\u0018\u00010\u00010/¢\u0006\u0002\b+H§@ø\u0001\u0000¢\u0006\u0004\b2\u00103J.\u00107\u001a\u00028\u0000\"\u0004\b\u0000\u001042\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\b+H'¢\u0006\u0004\b7\u00108JB\u0010:\u001a\u00028\u0000\"\u0004\b\u0000\u001042'\u00106\u001a#\b\u0001\u0012\u0004\u0012\u000209\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000001\u0012\u0006\u0012\u0004\u0018\u00010\u00010/¢\u0006\u0002\b+H§@ø\u0001\u0000¢\u0006\u0004\b:\u00103J1\u0010?\u001a\u00020$\"\f\b\u0000\u0010=*\u00060;j\u0002`<2\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u001d\u0010B\u001a\u0004\u0018\u00010A2\u0006\u0010\u001a\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\bB\u0010\u0018J1\u0010C\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H¦@ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u0019\u0010G\u001a\u00020$2\b\u0010F\u001a\u0004\u0018\u00010EH&¢\u0006\u0004\bG\u0010HJ\u001b\u0010J\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u0019H¦@ø\u0001\u0000¢\u0006\u0004\bJ\u0010\u001cJG\u0010P\u001a\u00020\u00192\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020\u00192\b\b\u0002\u0010\f\u001a\u00020\u00192\b\b\u0002\u0010\u0003\u001a\u00020\u00192\b\b\u0002\u0010I\u001a\u00020\u0019H¦@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bN\u0010OJ\u0013\u0010Q\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0004\bQ\u0010\u001eR\u0014\u0010T\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020$8&X¦\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0014\u0010W\u001a\u00020$8&X¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010VR\u0016\u0010Z\u001a\u0004\u0018\u00010E8&X¦\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010]\u001a\u00020\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006`"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "", "min", "Lkotlin/Function1;", "Ljava/nio/ByteBuffer;", "LN1/m;", "block", "readAvailable", "(ILkotlin/jvm/functions/Function1;)I", "", "dst", TypedValues.CycleType.S_WAVE_OFFSET, "length", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LJ1/b;", "(LJ1/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFully", "n", "(LJ1/b;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "size", "LI1/d;", "readPacket", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "limit", "readRemaining", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readLong", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readInt", "", "readShort", "", "readByte", "", "readBoolean", "", "readDouble", "", "readFloat", "Lio/ktor/utils/io/ReadSession;", "Lkotlin/ExtensionFunctionType;", "consumer", "readSession", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "Lio/ktor/utils/io/SuspendableReadSession;", "Lkotlin/coroutines/Continuation;", "readSuspendableSession", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "Lio/ktor/utils/io/LookAheadSession;", "visitor", "lookAhead", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "lookAheadSuspend", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "A", "out", "readUTF8LineTo", "(Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "readUTF8Line", "read", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "max", "discard", "LG1/b;", "destination", "destinationOffset", "peekTo-lBXzO7A", "(Ljava/nio/ByteBuffer;JJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peekTo", "awaitContent", "getAvailableForRead", "()I", "availableForRead", "isClosedForRead", "()Z", "isClosedForWrite", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "getTotalBytesRead", "()J", "totalBytesRead", "Companion", "io/ktor/utils/io/X", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ByteReadChannel {

    @NotNull
    public static final X Companion = X.f3544a;

    @Nullable
    Object awaitContent(@NotNull Continuation<? super N1.m> continuation);

    boolean cancel(@Nullable Throwable cause);

    @Nullable
    Object discard(long j6, @NotNull Continuation<? super Long> continuation);

    int getAvailableForRead();

    @Nullable
    Throwable getClosedCause();

    long getTotalBytesRead();

    boolean isClosedForRead();

    boolean isClosedForWrite();

    @Deprecated(message = "Use read { } instead.")
    <R> R lookAhead(@NotNull Function1<? super LookAheadSession, ? extends R> visitor);

    @Deprecated(message = "Use read { } instead.")
    @Nullable
    <R> Object lookAheadSuspend(@NotNull Function2<? super LookAheadSuspendSession, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation);

    @Nullable
    /* JADX INFO: renamed from: peekTo-lBXzO7A, reason: not valid java name */
    Object mo95peekTolBXzO7A(@NotNull ByteBuffer byteBuffer, long j6, long j7, long j8, long j9, @NotNull Continuation<? super Long> continuation);

    @Nullable
    Object read(int i, @NotNull Function1<? super ByteBuffer, N1.m> function1, @NotNull Continuation<? super N1.m> continuation);

    int readAvailable(int min, @NotNull Function1<? super ByteBuffer, N1.m> block);

    @Nullable
    Object readAvailable(@NotNull J1.b bVar, @NotNull Continuation<? super Integer> continuation);

    @Nullable
    Object readAvailable(@NotNull ByteBuffer byteBuffer, @NotNull Continuation<? super Integer> continuation);

    @Nullable
    Object readAvailable(@NotNull byte[] bArr, int i, int i3, @NotNull Continuation<? super Integer> continuation);

    @Nullable
    Object readBoolean(@NotNull Continuation<? super Boolean> continuation);

    @Nullable
    Object readByte(@NotNull Continuation<? super Byte> continuation);

    @Nullable
    Object readDouble(@NotNull Continuation<? super Double> continuation);

    @Nullable
    Object readFloat(@NotNull Continuation<? super Float> continuation);

    @Nullable
    Object readFully(@NotNull J1.b bVar, int i, @NotNull Continuation<? super N1.m> continuation);

    @Nullable
    Object readFully(@NotNull ByteBuffer byteBuffer, @NotNull Continuation<? super Integer> continuation);

    @Nullable
    Object readFully(@NotNull byte[] bArr, int i, int i3, @NotNull Continuation<? super N1.m> continuation);

    @Nullable
    Object readInt(@NotNull Continuation<? super Integer> continuation);

    @Nullable
    Object readLong(@NotNull Continuation<? super Long> continuation);

    @Nullable
    Object readPacket(int i, @NotNull Continuation<? super I1.d> continuation);

    @Nullable
    Object readRemaining(long j6, @NotNull Continuation<? super I1.d> continuation);

    @Deprecated(message = "Use read { } instead.")
    void readSession(@NotNull Function1<? super ReadSession, N1.m> consumer);

    @Nullable
    Object readShort(@NotNull Continuation<? super Short> continuation);

    @Deprecated(message = "Use read { } instead.")
    @Nullable
    Object readSuspendableSession(@NotNull Function2<? super SuspendableReadSession, ? super Continuation<? super N1.m>, ? extends Object> function2, @NotNull Continuation<? super N1.m> continuation);

    @Nullable
    Object readUTF8Line(int i, @NotNull Continuation<? super String> continuation);

    @Nullable
    <A extends Appendable> Object readUTF8LineTo(@NotNull A a6, int i, @NotNull Continuation<? super Boolean> continuation);
}
