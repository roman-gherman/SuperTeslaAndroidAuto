package androidx.test.services.storage;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.test.internal.util.Checks;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.platform.io.PlatformTestStorage;
import androidx.test.services.storage.file.HostedFile;
import androidx.test.services.storage.file.PropertyFile;
import androidx.test.services.storage.internal.TestStorageUtil;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes.dex */
public final class TestStorage implements PlatformTestStorage {
    private static final String PROPERTIES_FILE_NAME = "properties.dat";
    private static final String TAG = "TestStorage";
    private final ContentResolver contentResolver;

    public TestStorage() {
        this(InstrumentationRegistry.getInstrumentation().getTargetContext().getContentResolver());
    }

    private static Cursor doQuery(ContentResolver contentResolver, Uri uri) {
        Checks.checkNotNull(contentResolver);
        Checks.checkNotNull(uri);
        Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
        if (cursorQuery != null) {
            return cursorQuery;
        }
        throw new TestStorageException(String.format("Failed to resolve query for URI: %s", uri));
    }

    public static Uri getInputFileUri(@Nonnull String str) {
        Checks.checkNotNull(str);
        return HostedFile.buildUri(HostedFile.FileHost.TEST_FILE, str);
    }

    public static Uri getOutputFileUri(@Nonnull String str) {
        Checks.checkNotNull(str);
        return HostedFile.buildUri(HostedFile.FileHost.OUTPUT, str);
    }

    private static Map<String, String> getProperties(Cursor cursor) {
        Checks.checkNotNull(cursor);
        HashMap map = new HashMap();
        while (cursor.moveToNext()) {
            map.put(cursor.getString(PropertyFile.Column.NAME.getPosition()), cursor.getString(PropertyFile.Column.VALUE.getPosition()));
        }
        return map;
    }

    private static Uri getPropertyFileUri() {
        return HostedFile.buildUri(HostedFile.FileHost.EXPORT_PROPERTIES, PROPERTIES_FILE_NAME);
    }

    private static void silentlyClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public void addOutputProperties(Map<String, Serializable> map) throws Throwable {
        ObjectOutputStream objectOutputStream;
        if (map == null || map.isEmpty()) {
            return;
        }
        Map<String, Serializable> outputProperties = getOutputProperties();
        outputProperties.putAll(map);
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(TestStorageUtil.getOutputStream(getPropertyFileUri(), this.contentResolver)));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (IOException e6) {
            e = e6;
        }
        try {
            objectOutputStream.writeObject(outputProperties);
            silentlyClose(objectOutputStream);
        } catch (FileNotFoundException e7) {
            e = e7;
            throw new TestStorageException("Unable to create file", e);
        } catch (IOException e8) {
            e = e8;
            throw new TestStorageException("I/O error occurred during reading test properties.", e);
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            silentlyClose(objectOutputStream2);
            throw th;
        }
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public String getInputArg(@Nonnull String str) {
        Checks.checkNotNull(str);
        Uri uriBuildUri = PropertyFile.buildUri(PropertyFile.Authority.TEST_ARGS, str);
        Cursor cursor = null;
        try {
            Cursor cursorDoQuery = doQuery(this.contentResolver, uriBuildUri);
            if (cursorDoQuery.getCount() == 0) {
                throw new TestStorageException(String.format("Query for URI '%s' did not return any results. Make sure the argName is actually being passed in as a test argument.", uriBuildUri));
            }
            if (cursorDoQuery.getCount() > 1) {
                throw new TestStorageException(String.format("Query for URI '%s' returned more than one result. Weird.", uriBuildUri));
            }
            cursorDoQuery.moveToFirst();
            String string = cursorDoQuery.getString(PropertyFile.Column.VALUE.getPosition());
            cursorDoQuery.close();
            return string;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public Map<String, String> getInputArgs() {
        Cursor cursorDoQuery = null;
        try {
            cursorDoQuery = doQuery(this.contentResolver, PropertyFile.buildUri(PropertyFile.Authority.TEST_ARGS));
            return getProperties(cursorDoQuery);
        } finally {
            if (cursorDoQuery != null) {
                cursorDoQuery.close();
            }
        }
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public Map<String, Serializable> getOutputProperties() throws Throwable {
        InputStream inputStream;
        ObjectInputStream objectInputStream;
        Uri propertyFileUri = getPropertyFileUri();
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                inputStream = TestStorageUtil.getInputStream(propertyFileUri, this.contentResolver);
                try {
                    objectInputStream = new ObjectInputStream(inputStream);
                } catch (FileNotFoundException unused) {
                } catch (IOException e) {
                    e = e;
                } catch (ClassNotFoundException e6) {
                    e = e6;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                Map<String, Serializable> map = (Map) objectInputStream.readObject();
                if (map == null) {
                    map = new HashMap<>();
                }
                silentlyClose(objectInputStream);
                silentlyClose(inputStream);
                return map;
            } catch (FileNotFoundException unused2) {
                objectInputStream2 = objectInputStream;
                String.format("%s: does not exist, we must be the first call.", propertyFileUri);
                silentlyClose(objectInputStream2);
                silentlyClose(inputStream);
                return new HashMap();
            } catch (IOException e7) {
                e = e7;
                objectInputStream2 = objectInputStream;
                Log.w(TAG, "Failed to read recorded stats!", e);
                silentlyClose(objectInputStream2);
                silentlyClose(inputStream);
                return new HashMap();
            } catch (ClassNotFoundException e8) {
                e = e8;
                objectInputStream2 = objectInputStream;
                Log.w(TAG, "Failed to read recorded stats!", e);
                silentlyClose(objectInputStream2);
                silentlyClose(inputStream);
                return new HashMap();
            } catch (Throwable th2) {
                th = th2;
                objectInputStream2 = objectInputStream;
                silentlyClose(objectInputStream2);
                silentlyClose(inputStream);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            inputStream = null;
        } catch (IOException e9) {
            e = e9;
            inputStream = null;
            Log.w(TAG, "Failed to read recorded stats!", e);
            silentlyClose(objectInputStream2);
            silentlyClose(inputStream);
            return new HashMap();
        } catch (ClassNotFoundException e10) {
            e = e10;
            inputStream = null;
            Log.w(TAG, "Failed to read recorded stats!", e);
            silentlyClose(objectInputStream2);
            silentlyClose(inputStream);
            return new HashMap();
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public InputStream openInputFile(@Nonnull String str) {
        return TestStorageUtil.getInputStream(getInputFileUri(str), this.contentResolver);
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public InputStream openInternalInputFile(String str) {
        Checks.checkNotNull(str);
        return TestStorageUtil.getInputStream(HostedFile.buildUri(HostedFile.FileHost.INTERNAL_USE_ONLY, str), this.contentResolver);
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public OutputStream openInternalOutputFile(String str) {
        Checks.checkNotNull(str);
        return TestStorageUtil.getOutputStream(HostedFile.buildUri(HostedFile.FileHost.INTERNAL_USE_ONLY, str), this.contentResolver);
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public OutputStream openOutputFile(@Nonnull String str) {
        return openOutputFile(str, false);
    }

    public TestStorage(@Nonnull ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    private static void silentlyClose(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public OutputStream openOutputFile(@Nonnull String str, boolean z6) {
        Checks.checkNotNull(str);
        return TestStorageUtil.getOutputStream(getOutputFileUri(str), this.contentResolver, z6);
    }
}
