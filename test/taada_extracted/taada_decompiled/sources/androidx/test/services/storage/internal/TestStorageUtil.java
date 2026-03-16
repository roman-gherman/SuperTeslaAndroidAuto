package androidx.test.services.storage.internal;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import androidx.test.internal.util.Checks;
import androidx.test.services.storage.TestStorageException;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class TestStorageUtil {
    private TestStorageUtil() {
    }

    public static InputStream getInputStream(Uri uri, ContentResolver contentResolver) {
        Checks.checkNotNull(uri);
        ContentProviderClient contentProviderClientMakeContentProviderClient = null;
        try {
            try {
                contentProviderClientMakeContentProviderClient = makeContentProviderClient(contentResolver, uri);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new ParcelFileDescriptor.AutoCloseInputStream(contentProviderClientMakeContentProviderClient.openFile(uri, "r")));
                contentProviderClientMakeContentProviderClient.release();
                return bufferedInputStream;
            } catch (RemoteException e) {
                throw new TestStorageException("Unable to access content provider: ".concat(String.valueOf(uri)), e);
            }
        } catch (Throwable th) {
            if (contentProviderClientMakeContentProviderClient != null) {
                contentProviderClientMakeContentProviderClient.release();
            }
            throw th;
        }
    }

    public static OutputStream getOutputStream(Uri uri, ContentResolver contentResolver) {
        return getOutputStream(uri, contentResolver, false);
    }

    private static ContentProviderClient makeContentProviderClient(ContentResolver contentResolver, Uri uri) {
        Checks.checkNotNull(contentResolver);
        ContentProviderClient contentProviderClientAcquireContentProviderClient = contentResolver.acquireContentProviderClient(uri);
        if (contentProviderClientAcquireContentProviderClient != null) {
            return contentProviderClientAcquireContentProviderClient;
        }
        throw new TestStorageException(String.format("No content provider registered for: %s. Are all test services apks installed?", uri));
    }

    public static OutputStream getOutputStream(Uri uri, ContentResolver contentResolver, boolean z6) {
        Checks.checkNotNull(uri);
        ContentProviderClient contentProviderClientMakeContentProviderClient = null;
        try {
            try {
                contentProviderClientMakeContentProviderClient = makeContentProviderClient(contentResolver, uri);
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(contentProviderClientMakeContentProviderClient.openFile(uri, z6 ? "wa" : "w"));
                contentProviderClientMakeContentProviderClient.release();
                return autoCloseOutputStream;
            } catch (RemoteException e) {
                throw new TestStorageException("Unable to access content provider: ".concat(String.valueOf(uri)), e);
            }
        } catch (Throwable th) {
            if (contentProviderClientMakeContentProviderClient != null) {
                contentProviderClientMakeContentProviderClient.release();
            }
            throw th;
        }
    }
}
