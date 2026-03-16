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
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\bf\u0018\u00002\u00020\u0001J+\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\nJ\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\fJ+\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\bJ\u001b\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\fJ-\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\u0010H&¢\u0006\u0004\b\u0007\u0010\u0012J1\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\u0010H¦@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0016\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00150\u0010H¦@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J<\u0010\u001d\u001a\u00020\r2'\u0010\u001c\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018¢\u0006\u0002\b\u001bH§@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001fH¦@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001b\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020#H¦@ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u001b\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001b\u0010,\u001a\u00020\r2\u0006\u0010+\u001a\u00020*H¦@ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001b\u00100\u001a\u00020\r2\u0006\u0010/\u001a\u00020.H¦@ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001b\u00104\u001a\u00020\r2\u0006\u00103\u001a\u000202H¦@ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u001b\u00108\u001a\u00020\r2\u0006\u00107\u001a\u000206H¦@ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0019\u0010<\u001a\u00020\u00152\b\u0010;\u001a\u0004\u0018\u00010:H&¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\rH&¢\u0006\u0004\b>\u0010?J\u0013\u0010@\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u001b\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020BH¦@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010CJ1\u0010\u000e\u001a\u00020\r2\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0004H¦@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010NR\u0014\u0010S\u001a\u00020#8&X¦\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0016\u0010V\u001a\u0004\u0018\u00010:8&X¦\u0004¢\u0006\u0006\u001a\u0004\bT\u0010U\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006W"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "", "", "src", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "writeAvailable", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LJ1/b;", "(LJ1/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LN1/m;", "writeFully", "min", "Lkotlin/Function1;", "block", "(ILkotlin/jvm/functions/Function1;)I", "write", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeWhile", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lio/ktor/utils/io/WriterSuspendSession;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "visitor", "writeSuspendSession", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LI1/d;", "packet", "writePacket", "(LI1/d;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "l", "writeLong", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "writeInt", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "s", "writeShort", "(SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "writeByte", "(BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "d", "writeDouble", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "f", "writeFloat", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "close", "(Ljava/lang/Throwable;)Z", "flush", "()V", "awaitFreeSpace", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LI1/a;", "(LI1/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LG1/b;", "memory", "startIndex", "endIndex", "writeFully-JT6ljtQ", "(Ljava/nio/ByteBuffer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAvailableForWrite", "()I", "availableForWrite", "isClosedForWrite", "()Z", "getAutoFlush", "autoFlush", "getTotalBytesWritten", "()J", "totalBytesWritten", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ByteWriteChannel {
    @Nullable
    Object awaitFreeSpace(@NotNull Continuation<? super N1.m> continuation);

    boolean close(@Nullable Throwable cause);

    void flush();

    boolean getAutoFlush();

    int getAvailableForWrite();

    @Nullable
    Throwable getClosedCause();

    long getTotalBytesWritten();

    boolean isClosedForWrite();

    @Nullable
    Object write(int i, @NotNull Function1<? super ByteBuffer, N1.m> function1, @NotNull Continuation<? super N1.m> continuation);

    int writeAvailable(int min, @NotNull Function1<? super ByteBuffer, N1.m> block);

    @Nullable
    Object writeAvailable(@NotNull J1.b bVar, @NotNull Continuation<? super Integer> continuation);

    @Nullable
    Object writeAvailable(@NotNull ByteBuffer byteBuffer, @NotNull Continuation<? super Integer> continuation);

    @Nullable
    Object writeAvailable(@NotNull byte[] bArr, int i, int i3, @NotNull Continuation<? super Integer> continuation);

    @Nullable
    Object writeByte(byte b, @NotNull Continuation<? super N1.m> continuation);

    @Nullable
    Object writeDouble(double d, @NotNull Continuation<? super N1.m> continuation);

    @Nullable
    Object writeFloat(float f6, @NotNull Continuation<? super N1.m> continuation);

    @Nullable
    Object writeFully(@NotNull I1.a aVar, @NotNull Continuation<? super N1.m> continuation);

    @Nullable
    Object writeFully(@NotNull ByteBuffer byteBuffer, @NotNull Continuation<? super N1.m> continuation);

    @Nullable
    Object writeFully(@NotNull byte[] bArr, int i, int i3, @NotNull Continuation<? super N1.m> continuation);

    @Nullable
    /* JADX INFO: renamed from: writeFully-JT6ljtQ, reason: not valid java name */
    Object mo96writeFullyJT6ljtQ(@NotNull ByteBuffer byteBuffer, int i, int i3, @NotNull Continuation<? super N1.m> continuation);

    @Nullable
    Object writeInt(int i, @NotNull Continuation<? super N1.m> continuation);

    @Nullable
    Object writeLong(long j6, @NotNull Continuation<? super N1.m> continuation);

    @Nullable
    Object writePacket(@NotNull I1.d dVar, @NotNull Continuation<? super N1.m> continuation);

    @Nullable
    Object writeShort(short s3, @NotNull Continuation<? super N1.m> continuation);

    @Deprecated(message = "Use write { } instead.")
    @Nullable
    Object writeSuspendSession(@NotNull Function2<? super WriterSuspendSession, ? super Continuation<? super N1.m>, ? extends Object> function2, @NotNull Continuation<? super N1.m> continuation);

    @Nullable
    Object writeWhile(@NotNull Function1<? super ByteBuffer, Boolean> function1, @NotNull Continuation<? super N1.m> continuation);
}
