package androidx.test.platform.io;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface PlatformTestStorage {
    void addOutputProperties(Map<String, Serializable> map);

    String getInputArg(String str);

    Map<String, String> getInputArgs();

    Map<String, Serializable> getOutputProperties();

    InputStream openInputFile(String str);

    InputStream openInternalInputFile(String str);

    OutputStream openInternalOutputFile(String str);

    OutputStream openOutputFile(String str);

    OutputStream openOutputFile(String str, boolean z6);
}
