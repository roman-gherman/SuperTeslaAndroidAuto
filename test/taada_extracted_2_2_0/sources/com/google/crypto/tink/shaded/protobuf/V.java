package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class V extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2850a;

    public static V a() {
        return new V("Protocol message contained an invalid tag (zero).");
    }

    public static V b() {
        return new V("Protocol message had invalid UTF-8.");
    }

    public static U c() {
        return new U("Protocol message tag had invalid wire type.");
    }

    public static V d() {
        return new V("CodedInputStream encountered a malformed varint.");
    }

    public static V e() {
        return new V("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static V f() {
        return new V("Failed to parse the message.");
    }

    public static V g() {
        return new V("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
