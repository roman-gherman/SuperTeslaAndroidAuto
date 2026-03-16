package androidx.room.util;

import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ljava/nio/channels/ReadableByteChannel;", "input", "Ljava/nio/channels/FileChannel;", "output", "LN1/m;", "copy", "(Ljava/nio/channels/ReadableByteChannel;Ljava/nio/channels/FileChannel;)V", "room-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FileUtil {
    public static final void copy(ReadableByteChannel input, FileChannel output) throws IOException {
        h.f(input, "input");
        h.f(output, "output");
        try {
            output.transferFrom(input, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
            output.force(false);
        } finally {
            input.close();
            output.close();
        }
    }
}
