package androidx.test.platform.io;

import android.util.Log;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class FileTestStorage implements PlatformTestStorage {
    private static final String TAG = "FileTestStorage";

    @Override // androidx.test.platform.io.PlatformTestStorage
    public void addOutputProperties(Map<String, Serializable> map) {
        Log.w(TAG, "Output properties is not supported.");
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public String getInputArg(String str) {
        Log.w(TAG, "Test input args is not supported.");
        return null;
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public Map<String, String> getInputArgs() {
        Log.w(TAG, "Test input args is not supported.");
        return new HashMap();
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public Map<String, Serializable> getOutputProperties() {
        Log.w(TAG, "Output properties is not supported.");
        return new HashMap();
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public InputStream openInputFile(String str) {
        return new FileInputStream(str);
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public InputStream openInternalInputFile(String str) {
        return new FileInputStream(str);
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public OutputStream openInternalOutputFile(String str) {
        return new FileOutputStream(str);
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public OutputStream openOutputFile(String str) {
        return new FileOutputStream(str);
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public OutputStream openOutputFile(String str, boolean z6) {
        return new FileOutputStream(str, z6);
    }
}
