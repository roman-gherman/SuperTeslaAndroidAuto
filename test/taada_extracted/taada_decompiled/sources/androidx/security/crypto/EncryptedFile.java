package androidx.security.crypto;

import B0.b;
import B2.d;
import H0.e;
import android.content.Context;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.a;
import com.google.crypto.tink.f;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public final class EncryptedFile {
    private static final String KEYSET_ALIAS = "__androidx_security_crypto_encrypted_file_keyset__";
    private static final String KEYSET_PREF_NAME = "__androidx_security_crypto_encrypted_file_pref__";
    final Context mContext;
    final File mFile;
    final String mMasterKeyAlias;
    final StreamingAead mStreamingAead;

    public static final class EncryptedFileInputStream extends FileInputStream {
        private final InputStream mEncryptedInputStream;
        private final Object mLock;

        public EncryptedFileInputStream(FileDescriptor fileDescriptor, InputStream inputStream) {
            super(fileDescriptor);
            this.mLock = new Object();
            this.mEncryptedInputStream = inputStream;
        }

        @Override // java.io.FileInputStream, java.io.InputStream
        public int available() {
            return this.mEncryptedInputStream.available();
        }

        @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mEncryptedInputStream.close();
        }

        @Override // java.io.FileInputStream
        public FileChannel getChannel() {
            throw new UnsupportedOperationException("For encrypted files, please open the relevant FileInput/FileOutputStream.");
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            synchronized (this.mLock) {
                this.mEncryptedInputStream.mark(i);
            }
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.mEncryptedInputStream.markSupported();
        }

        @Override // java.io.FileInputStream, java.io.InputStream
        public int read() {
            return this.mEncryptedInputStream.read();
        }

        @Override // java.io.InputStream
        public void reset() {
            synchronized (this.mLock) {
                this.mEncryptedInputStream.reset();
            }
        }

        @Override // java.io.FileInputStream, java.io.InputStream
        public long skip(long j6) {
            return this.mEncryptedInputStream.skip(j6);
        }

        @Override // java.io.FileInputStream, java.io.InputStream
        public int read(byte[] bArr) {
            return this.mEncryptedInputStream.read(bArr);
        }

        @Override // java.io.FileInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i3) {
            return this.mEncryptedInputStream.read(bArr, i, i3);
        }
    }

    public static final class EncryptedFileOutputStream extends FileOutputStream {
        private final OutputStream mEncryptedOutputStream;

        public EncryptedFileOutputStream(FileDescriptor fileDescriptor, OutputStream outputStream) {
            super(fileDescriptor);
            this.mEncryptedOutputStream = outputStream;
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mEncryptedOutputStream.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.mEncryptedOutputStream.flush();
        }

        @Override // java.io.FileOutputStream
        public FileChannel getChannel() {
            throw new UnsupportedOperationException("For encrypted files, please open the relevant FileInput/FileOutputStream.");
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.mEncryptedOutputStream.write(bArr);
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            this.mEncryptedOutputStream.write(i);
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i3) throws IOException {
            this.mEncryptedOutputStream.write(bArr, i, i3);
        }
    }

    public enum FileEncryptionScheme {
        AES256_GCM_HKDF_4KB("AES256_GCM_HKDF_4KB");

        private final String mKeyTemplateName;

        FileEncryptionScheme(String str) {
            this.mKeyTemplateName = str;
        }

        public f getKeyTemplate() {
            return a.a(this.mKeyTemplateName);
        }
    }

    public EncryptedFile(File file, String str, StreamingAead streamingAead, Context context) {
        this.mFile = file;
        this.mContext = context;
        this.mMasterKeyAlias = str;
        this.mStreamingAead = streamingAead;
    }

    public FileInputStream openFileInput() throws FileNotFoundException {
        if (this.mFile.exists()) {
            FileInputStream fileInputStream = new FileInputStream(this.mFile);
            return new EncryptedFileInputStream(fileInputStream.getFD(), this.mStreamingAead.newDecryptingStream(fileInputStream, this.mFile.getName().getBytes(StandardCharsets.UTF_8)));
        }
        throw new FileNotFoundException("file doesn't exist: " + this.mFile.getName());
    }

    public FileOutputStream openFileOutput() throws IOException {
        if (this.mFile.exists()) {
            throw new IOException("output file already exists, please use a new file: " + this.mFile.getName());
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.mFile);
        return new EncryptedFileOutputStream(fileOutputStream.getFD(), this.mStreamingAead.newEncryptingStream(fileOutputStream, this.mFile.getName().getBytes(StandardCharsets.UTF_8)));
    }

    public static final class Builder {
        private static final Object sLock = new Object();
        final Context mContext;
        File mFile;
        final FileEncryptionScheme mFileEncryptionScheme;
        final String mMasterKeyAlias;
        String mKeysetPrefName = EncryptedFile.KEYSET_PREF_NAME;
        String mKeysetAlias = EncryptedFile.KEYSET_ALIAS;

        @Deprecated
        public Builder(File file, Context context, String str, FileEncryptionScheme fileEncryptionScheme) {
            this.mFile = file;
            this.mFileEncryptionScheme = fileEncryptionScheme;
            this.mContext = context.getApplicationContext();
            this.mMasterKeyAlias = str;
        }

        public EncryptedFile build() {
            b bVarA;
            d dVarC;
            e.a();
            B0.a aVar = new B0.a();
            aVar.f116f = this.mFileEncryptionScheme.getKeyTemplate();
            aVar.g(this.mContext, this.mKeysetAlias, this.mKeysetPrefName);
            aVar.f("android-keystore://" + this.mMasterKeyAlias);
            synchronized (sLock) {
                bVarA = aVar.a();
            }
            synchronized (bVarA) {
                dVarC = bVarA.f118a.c();
            }
            return new EncryptedFile(this.mFile, this.mKeysetAlias, (StreamingAead) dVarC.j(StreamingAead.class), this.mContext);
        }

        public Builder setKeysetAlias(String str) {
            this.mKeysetAlias = str;
            return this;
        }

        public Builder setKeysetPrefName(String str) {
            this.mKeysetPrefName = str;
            return this;
        }

        public Builder(Context context, File file, MasterKey masterKey, FileEncryptionScheme fileEncryptionScheme) {
            this.mFile = file;
            this.mFileEncryptionScheme = fileEncryptionScheme;
            this.mContext = context.getApplicationContext();
            this.mMasterKeyAlias = masterKey.getKeyAlias();
        }
    }
}
