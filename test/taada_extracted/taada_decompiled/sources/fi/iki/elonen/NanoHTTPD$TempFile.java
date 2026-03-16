package fi.iki.elonen;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface NanoHTTPD$TempFile {
    void delete();

    String getName();

    OutputStream open();
}
