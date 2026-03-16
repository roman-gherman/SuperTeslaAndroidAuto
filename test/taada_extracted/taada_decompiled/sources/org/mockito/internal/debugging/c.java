package org.mockito.internal.debugging;

import java.util.function.Function;
import java.util.stream.Stream;
import org.mockito.exceptions.stacktrace.StackTraceCleaner;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4449a;

    public /* synthetic */ c(int i) {
        this.f4449a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4449a) {
            case 0:
                return Java9PlusLocationImpl.lambda$static$0(obj);
            case 1:
                return Java9PlusLocationImpl.lambda$framesToSkip$3((Stream) obj);
            default:
                return ((StackTraceCleaner.StackFrameMetadata) obj).getClassName();
        }
    }
}
