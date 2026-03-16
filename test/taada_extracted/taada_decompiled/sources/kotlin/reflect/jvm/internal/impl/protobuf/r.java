package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MessageLite f3874a;

    public r(String str) {
        super(str);
        this.f3874a = null;
    }

    public static r a() {
        return new r("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }
}
