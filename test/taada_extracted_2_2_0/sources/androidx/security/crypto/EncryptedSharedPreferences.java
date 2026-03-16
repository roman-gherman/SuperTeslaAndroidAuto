package androidx.security.crypto;

import B2.b;
import B2.d;
import G0.S;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import androidx.collection.ArraySet;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.a;
import com.google.crypto.tink.f;
import com.google.crypto.tink.subtle.m;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import v0.AbstractC0847a;
import y0.AbstractC0928a;
import z0.AbstractC0940a;
import z0.c;

/* JADX INFO: loaded from: classes.dex */
public final class EncryptedSharedPreferences implements SharedPreferences {
    private static final String KEY_KEYSET_ALIAS = "__androidx_security_crypto_encrypted_prefs_key_keyset__";
    private static final String NULL_VALUE = "__NULL__";
    private static final String VALUE_KEYSET_ALIAS = "__androidx_security_crypto_encrypted_prefs_value_keyset__";
    final String mFileName;
    final DeterministicAead mKeyDeterministicAead;
    final CopyOnWriteArrayList<SharedPreferences.OnSharedPreferenceChangeListener> mListeners = new CopyOnWriteArrayList<>();
    final String mMasterKeyAlias;
    final SharedPreferences mSharedPreferences;
    final Aead mValueAead;

    /* JADX INFO: renamed from: androidx.security.crypto.EncryptedSharedPreferences$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType;

        static {
            int[] iArr = new int[EncryptedType.values().length];
            $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType = iArr;
            try {
                iArr[EncryptedType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType[EncryptedType.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType[EncryptedType.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType[EncryptedType.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType[EncryptedType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType[EncryptedType.STRING_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static final class Editor implements SharedPreferences.Editor {
        private final SharedPreferences.Editor mEditor;
        private final EncryptedSharedPreferences mEncryptedSharedPreferences;
        private final AtomicBoolean mClearRequested = new AtomicBoolean(false);
        private final List<String> mKeysChanged = new CopyOnWriteArrayList();

        public Editor(EncryptedSharedPreferences encryptedSharedPreferences, SharedPreferences.Editor editor) {
            this.mEncryptedSharedPreferences = encryptedSharedPreferences;
            this.mEditor = editor;
        }

        private void clearKeysIfNeeded() {
            if (this.mClearRequested.getAndSet(false)) {
                for (String str : this.mEncryptedSharedPreferences.getAll().keySet()) {
                    if (!this.mKeysChanged.contains(str) && !this.mEncryptedSharedPreferences.isReservedKey(str)) {
                        this.mEditor.remove(this.mEncryptedSharedPreferences.encryptKey(str));
                    }
                }
            }
        }

        private void notifyListeners() {
            for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.mEncryptedSharedPreferences.mListeners) {
                Iterator<String> it = this.mKeysChanged.iterator();
                while (it.hasNext()) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.mEncryptedSharedPreferences, it.next());
                }
            }
        }

        private void putEncryptedObject(String str, byte[] bArr) {
            if (this.mEncryptedSharedPreferences.isReservedKey(str)) {
                throw new SecurityException(b.e(str, " is a reserved key for the encryption keyset."));
            }
            this.mKeysChanged.add(str);
            if (str == null) {
                str = EncryptedSharedPreferences.NULL_VALUE;
            }
            try {
                Pair<String, String> pairEncryptKeyValuePair = this.mEncryptedSharedPreferences.encryptKeyValuePair(str, bArr);
                this.mEditor.putString((String) pairEncryptKeyValuePair.first, (String) pairEncryptKeyValuePair.second);
            } catch (GeneralSecurityException e) {
                throw new SecurityException("Could not encrypt data: " + e.getMessage(), e);
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            clearKeysIfNeeded();
            this.mEditor.apply();
            notifyListeners();
            this.mKeysChanged.clear();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.mClearRequested.set(true);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            clearKeysIfNeeded();
            try {
                return this.mEditor.commit();
            } finally {
                notifyListeners();
                this.mKeysChanged.clear();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z6) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
            byteBufferAllocate.putInt(EncryptedType.BOOLEAN.getId());
            byteBufferAllocate.put(z6 ? (byte) 1 : (byte) 0);
            putEncryptedObject(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f6) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            byteBufferAllocate.putInt(EncryptedType.FLOAT.getId());
            byteBufferAllocate.putFloat(f6);
            putEncryptedObject(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            byteBufferAllocate.putInt(EncryptedType.INT.getId());
            byteBufferAllocate.putInt(i);
            putEncryptedObject(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j6) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
            byteBufferAllocate.putInt(EncryptedType.LONG.getId());
            byteBufferAllocate.putLong(j6);
            putEncryptedObject(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            if (str2 == null) {
                str2 = EncryptedSharedPreferences.NULL_VALUE;
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + 8);
            byteBufferAllocate.putInt(EncryptedType.STRING.getId());
            byteBufferAllocate.putInt(length);
            byteBufferAllocate.put(bytes);
            putEncryptedObject(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            if (set == null) {
                set = new ArraySet<>();
                set.add(EncryptedSharedPreferences.NULL_VALUE);
            }
            ArrayList<byte[]> arrayList = new ArrayList(set.size());
            int size = set.size() * 4;
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                byte[] bytes = it.next().getBytes(StandardCharsets.UTF_8);
                arrayList.add(bytes);
                size += bytes.length;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(size + 4);
            byteBufferAllocate.putInt(EncryptedType.STRING_SET.getId());
            for (byte[] bArr : arrayList) {
                byteBufferAllocate.putInt(bArr.length);
                byteBufferAllocate.put(bArr);
            }
            putEncryptedObject(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            if (this.mEncryptedSharedPreferences.isReservedKey(str)) {
                throw new SecurityException(b.e(str, " is a reserved key for the encryption keyset."));
            }
            this.mEditor.remove(this.mEncryptedSharedPreferences.encryptKey(str));
            this.mKeysChanged.add(str);
            return this;
        }
    }

    public enum EncryptedType {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);

        private final int mId;

        EncryptedType(int i) {
            this.mId = i;
        }

        public static EncryptedType fromId(int i) {
            if (i == 0) {
                return STRING;
            }
            if (i == 1) {
                return STRING_SET;
            }
            if (i == 2) {
                return INT;
            }
            if (i == 3) {
                return LONG;
            }
            if (i == 4) {
                return FLOAT;
            }
            if (i != 5) {
                return null;
            }
            return BOOLEAN;
        }

        public int getId() {
            return this.mId;
        }
    }

    public enum PrefKeyEncryptionScheme {
        AES256_SIV("AES256_SIV");

        private final String mDeterministicAeadKeyTemplateName;

        PrefKeyEncryptionScheme(String str) {
            this.mDeterministicAeadKeyTemplateName = str;
        }

        public f getKeyTemplate() {
            return a.a(this.mDeterministicAeadKeyTemplateName);
        }
    }

    public enum PrefValueEncryptionScheme {
        AES256_GCM("AES256_GCM");

        private final String mAeadKeyTemplateName;

        PrefValueEncryptionScheme(String str) {
            this.mAeadKeyTemplateName = str;
        }

        public f getKeyTemplate() {
            return a.a(this.mAeadKeyTemplateName);
        }
    }

    public EncryptedSharedPreferences(String str, String str2, SharedPreferences sharedPreferences, Aead aead, DeterministicAead deterministicAead) {
        this.mFileName = str;
        this.mSharedPreferences = sharedPreferences;
        this.mMasterKeyAlias = str2;
        this.mValueAead = aead;
        this.mKeyDeterministicAead = deterministicAead;
    }

    public static SharedPreferences create(Context context, String str, MasterKey masterKey, PrefKeyEncryptionScheme prefKeyEncryptionScheme, PrefValueEncryptionScheme prefValueEncryptionScheme) {
        return create(str, masterKey.getKeyAlias(), context, prefKeyEncryptionScheme, prefValueEncryptionScheme);
    }

    private Object getDecryptedObject(String str) {
        if (isReservedKey(str)) {
            throw new SecurityException(b.e(str, " is a reserved key for the encryption keyset."));
        }
        if (str == null) {
            str = NULL_VALUE;
        }
        try {
            String strEncryptKey = encryptKey(str);
            String string = this.mSharedPreferences.getString(strEncryptKey, null);
            if (string != null) {
                byte[] bArrA = m.a(string);
                Aead aead = this.mValueAead;
                Charset charset = StandardCharsets.UTF_8;
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(aead.decrypt(bArrA, strEncryptKey.getBytes(charset)));
                byteBufferWrap.position(0);
                int i = byteBufferWrap.getInt();
                EncryptedType encryptedTypeFromId = EncryptedType.fromId(i);
                if (encryptedTypeFromId == null) {
                    throw new SecurityException("Unknown type ID for encrypted pref value: " + i);
                }
                switch (AnonymousClass1.$SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType[encryptedTypeFromId.ordinal()]) {
                    case 1:
                        int i3 = byteBufferWrap.getInt();
                        ByteBuffer byteBufferSlice = byteBufferWrap.slice();
                        byteBufferWrap.limit(i3);
                        String string2 = charset.decode(byteBufferSlice).toString();
                        if (!string2.equals(NULL_VALUE)) {
                            return string2;
                        }
                        break;
                    case 2:
                        return Integer.valueOf(byteBufferWrap.getInt());
                    case 3:
                        return Long.valueOf(byteBufferWrap.getLong());
                    case 4:
                        return Float.valueOf(byteBufferWrap.getFloat());
                    case 5:
                        return Boolean.valueOf(byteBufferWrap.get() != 0);
                    case 6:
                        ArraySet arraySet = new ArraySet();
                        while (byteBufferWrap.hasRemaining()) {
                            int i4 = byteBufferWrap.getInt();
                            ByteBuffer byteBufferSlice2 = byteBufferWrap.slice();
                            byteBufferSlice2.limit(i4);
                            byteBufferWrap.position(byteBufferWrap.position() + i4);
                            arraySet.add(StandardCharsets.UTF_8.decode(byteBufferSlice2).toString());
                        }
                        if (arraySet.size() != 1 || !NULL_VALUE.equals(arraySet.valueAt(0))) {
                            return arraySet;
                        }
                        break;
                        break;
                    default:
                        throw new SecurityException("Unhandled type for encrypted pref value: " + encryptedTypeFromId);
                }
            }
            return null;
        } catch (GeneralSecurityException e) {
            throw new SecurityException("Could not decrypt value. " + e.getMessage(), e);
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (isReservedKey(str)) {
            throw new SecurityException(b.e(str, " is a reserved key for the encryption keyset."));
        }
        return this.mSharedPreferences.contains(encryptKey(str));
    }

    public String decryptKey(String str) {
        try {
            String str2 = new String(this.mKeyDeterministicAead.decryptDeterministically(m.a(str), this.mFileName.getBytes()), StandardCharsets.UTF_8);
            if (str2.equals(NULL_VALUE)) {
                return null;
            }
            return str2;
        } catch (GeneralSecurityException e) {
            throw new SecurityException("Could not decrypt key. " + e.getMessage(), e);
        }
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new Editor(this, this.mSharedPreferences.edit());
    }

    public String encryptKey(String str) {
        if (str == null) {
            str = NULL_VALUE;
        }
        try {
            try {
                return new String(m.b(this.mKeyDeterministicAead.encryptDeterministically(str.getBytes(StandardCharsets.UTF_8), this.mFileName.getBytes())), "US-ASCII");
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        } catch (GeneralSecurityException e6) {
            throw new SecurityException("Could not encrypt key. " + e6.getMessage(), e6);
        }
    }

    public Pair<String, String> encryptKeyValuePair(String str, byte[] bArr) {
        String strEncryptKey = encryptKey(str);
        try {
            return new Pair<>(strEncryptKey, new String(m.b(this.mValueAead.encrypt(bArr, strEncryptKey.getBytes(StandardCharsets.UTF_8))), "US-ASCII"));
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : this.mSharedPreferences.getAll().entrySet()) {
            if (!isReservedKey(entry.getKey())) {
                String strDecryptKey = decryptKey(entry.getKey());
                map.put(strDecryptKey, getDecryptedObject(strDecryptKey));
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z6) {
        Object decryptedObject = getDecryptedObject(str);
        return decryptedObject instanceof Boolean ? ((Boolean) decryptedObject).booleanValue() : z6;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f6) {
        Object decryptedObject = getDecryptedObject(str);
        return decryptedObject instanceof Float ? ((Float) decryptedObject).floatValue() : f6;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        Object decryptedObject = getDecryptedObject(str);
        return decryptedObject instanceof Integer ? ((Integer) decryptedObject).intValue() : i;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j6) {
        Object decryptedObject = getDecryptedObject(str);
        return decryptedObject instanceof Long ? ((Long) decryptedObject).longValue() : j6;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object decryptedObject = getDecryptedObject(str);
        return decryptedObject instanceof String ? (String) decryptedObject : str2;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Object decryptedObject = getDecryptedObject(str);
        Set<String> arraySet = decryptedObject instanceof Set ? (Set) decryptedObject : new ArraySet<>();
        return arraySet.size() > 0 ? arraySet : set;
    }

    public boolean isReservedKey(String str) {
        return KEY_KEYSET_ALIAS.equals(str) || VALUE_KEYSET_ALIAS.equals(str);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mListeners.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mListeners.remove(onSharedPreferenceChangeListener);
    }

    @Deprecated
    public static SharedPreferences create(String str, String str2, Context context, PrefKeyEncryptionScheme prefKeyEncryptionScheme, PrefValueEncryptionScheme prefValueEncryptionScheme) {
        d dVarC;
        d dVarC2;
        int i = AbstractC0940a.f5168a;
        com.google.crypto.tink.m.h(c.b);
        if (!AbstractC0928a.a()) {
            com.google.crypto.tink.m.f(new H0.a(S.class, new D0.c[]{new D0.c(DeterministicAead.class, 13)}, 10), true);
        }
        AbstractC0847a.a();
        Context applicationContext = context.getApplicationContext();
        B0.a aVar = new B0.a();
        aVar.f116f = prefKeyEncryptionScheme.getKeyTemplate();
        aVar.g(applicationContext, KEY_KEYSET_ALIAS, str);
        aVar.f("android-keystore://" + str2);
        B0.b bVarA = aVar.a();
        synchronized (bVarA) {
            dVarC = bVarA.f118a.c();
        }
        B0.a aVar2 = new B0.a();
        aVar2.f116f = prefValueEncryptionScheme.getKeyTemplate();
        aVar2.g(applicationContext, VALUE_KEYSET_ALIAS, str);
        aVar2.f("android-keystore://" + str2);
        B0.b bVarA2 = aVar2.a();
        synchronized (bVarA2) {
            dVarC2 = bVarA2.f118a.c();
        }
        return new EncryptedSharedPreferences(str, str2, applicationContext.getSharedPreferences(str, 0), (Aead) dVarC2.j(Aead.class), (DeterministicAead) dVarC.j(DeterministicAead.class));
    }
}
