package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.ProfileInstaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class DeviceProfileWriter {
    private final String mApkName;
    private final AssetManager mAssetManager;
    private final File mCurProfile;
    private final ProfileInstaller.DiagnosticsCallback mDiagnostics;
    private final Executor mExecutor;
    private DexProfileData[] mProfile;
    private final String mProfileMetaSourceLocation;
    private final String mProfileSourceLocation;
    private byte[] mTranscodedProfile;
    private boolean mDeviceSupportsAotProfile = false;
    private final byte[] mDesiredVersion = desiredVersion();

    public DeviceProfileWriter(AssetManager assetManager, Executor executor, ProfileInstaller.DiagnosticsCallback diagnosticsCallback, String str, String str2, String str3, File file) {
        this.mAssetManager = assetManager;
        this.mExecutor = executor;
        this.mDiagnostics = diagnosticsCallback;
        this.mApkName = str;
        this.mProfileSourceLocation = str2;
        this.mProfileMetaSourceLocation = str3;
        this.mCurProfile = file;
    }

    private DeviceProfileWriter addMetadata(DexProfileData[] dexProfileDataArr, byte[] bArr) {
        InputStream inputStreamOpenStreamFromAssets;
        try {
            inputStreamOpenStreamFromAssets = openStreamFromAssets(this.mAssetManager, this.mProfileMetaSourceLocation);
        } catch (FileNotFoundException e) {
            this.mDiagnostics.onResultReceived(9, e);
        } catch (IOException e6) {
            this.mDiagnostics.onResultReceived(7, e6);
        } catch (IllegalStateException e7) {
            this.mProfile = null;
            this.mDiagnostics.onResultReceived(8, e7);
        }
        if (inputStreamOpenStreamFromAssets == null) {
            if (inputStreamOpenStreamFromAssets != null) {
                inputStreamOpenStreamFromAssets.close();
            }
            return null;
        }
        try {
            this.mProfile = ProfileTranscoder.readMeta(inputStreamOpenStreamFromAssets, ProfileTranscoder.readHeader(inputStreamOpenStreamFromAssets, ProfileTranscoder.MAGIC_PROFM), bArr, dexProfileDataArr);
            inputStreamOpenStreamFromAssets.close();
            return this;
        } catch (Throwable th) {
            try {
                inputStreamOpenStreamFromAssets.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if (!this.mDeviceSupportsAotProfile) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] desiredVersion() {
        int i = Build.VERSION.SDK_INT;
        if (i > 33) {
            return null;
        }
        switch (i) {
        }
        return null;
    }

    private InputStream getProfileInputStream(AssetManager assetManager) {
        try {
            return openStreamFromAssets(assetManager, this.mProfileSourceLocation);
        } catch (FileNotFoundException e) {
            this.mDiagnostics.onResultReceived(6, e);
            return null;
        } catch (IOException e6) {
            this.mDiagnostics.onResultReceived(7, e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$result$0(int i, Object obj) {
        this.mDiagnostics.onResultReceived(i, obj);
    }

    private InputStream openStreamFromAssets(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message != null && message.contains("compressed")) {
                this.mDiagnostics.onDiagnosticReceived(5, null);
            }
            return null;
        }
    }

    private DexProfileData[] readProfileInternal(InputStream inputStream) {
        try {
            try {
                try {
                    try {
                        DexProfileData[] profile = ProfileTranscoder.readProfile(inputStream, ProfileTranscoder.readHeader(inputStream, ProfileTranscoder.MAGIC_PROF), this.mApkName);
                        try {
                            inputStream.close();
                            return profile;
                        } catch (IOException e) {
                            this.mDiagnostics.onResultReceived(7, e);
                            return profile;
                        }
                    } catch (IOException e6) {
                        this.mDiagnostics.onResultReceived(7, e6);
                        return null;
                    }
                } catch (IllegalStateException e7) {
                    this.mDiagnostics.onResultReceived(8, e7);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e8) {
                this.mDiagnostics.onResultReceived(7, e8);
                inputStream.close();
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e9) {
                this.mDiagnostics.onResultReceived(7, e9);
            }
            throw th;
        }
    }

    private static boolean requiresMetadata() {
        int i = Build.VERSION.SDK_INT;
        if (i > 33) {
            return false;
        }
        switch (i) {
        }
        return false;
    }

    private void result(int i, Object obj) {
        this.mExecutor.execute(new a(this, i, obj));
    }

    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.mDesiredVersion == null) {
            result(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (this.mCurProfile.canWrite()) {
            this.mDeviceSupportsAotProfile = true;
            return true;
        }
        result(4, null);
        return false;
    }

    public DeviceProfileWriter read() {
        DeviceProfileWriter deviceProfileWriterAddMetadata;
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        if (this.mDesiredVersion != null) {
            InputStream profileInputStream = getProfileInputStream(this.mAssetManager);
            if (profileInputStream != null) {
                this.mProfile = readProfileInternal(profileInputStream);
            }
            DexProfileData[] dexProfileDataArr = this.mProfile;
            if (dexProfileDataArr != null && requiresMetadata() && (deviceProfileWriterAddMetadata = addMetadata(dexProfileDataArr, this.mDesiredVersion)) != null) {
                return deviceProfileWriterAddMetadata;
            }
        }
        return this;
    }

    public DeviceProfileWriter transcodeIfNeeded() {
        ByteArrayOutputStream byteArrayOutputStream;
        DexProfileData[] dexProfileDataArr = this.mProfile;
        byte[] bArr = this.mDesiredVersion;
        if (dexProfileDataArr != null && bArr != null) {
            assertDeviceAllowsProfileInstallerAotWritesCalled();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ProfileTranscoder.writeHeader(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                this.mDiagnostics.onResultReceived(7, e);
            } catch (IllegalStateException e6) {
                this.mDiagnostics.onResultReceived(8, e6);
            }
            if (!ProfileTranscoder.transcodeAndWriteBody(byteArrayOutputStream, bArr, dexProfileDataArr)) {
                this.mDiagnostics.onResultReceived(5, null);
                this.mProfile = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.mTranscodedProfile = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.mProfile = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean write() {
        byte[] bArr = this.mTranscodedProfile;
        if (bArr == null) {
            return false;
        }
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.mCurProfile);
                    try {
                        Encoding.writeAll(byteArrayInputStream, fileOutputStream);
                        result(1, null);
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        return true;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
                this.mTranscodedProfile = null;
                this.mProfile = null;
            }
        } catch (FileNotFoundException e) {
            result(6, e);
            return false;
        } catch (IOException e6) {
            result(7, e6);
            return false;
        }
    }
}
