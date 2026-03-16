package androidx.test.services.storage.file;

import android.net.Uri;
import androidx.constraintlayout.core.motion.a;
import androidx.test.services.storage.TestStorageConstants;

/* JADX INFO: loaded from: classes.dex */
public final class HostedFile {

    public enum FileHost {
        TEST_FILE(TestStorageConstants.TEST_RUNFILES_PROVIDER_AUTHORITY, false),
        EXPORT_PROPERTIES(TestStorageConstants.OUTPUT_PROPERTIES_PROVIDER_AUTHORITY, true),
        OUTPUT(TestStorageConstants.TEST_OUTPUT_PROVIDER_AUTHORITY, true),
        INTERNAL_USE_ONLY(TestStorageConstants.INTERNAL_USE_PROVIDER_AUTHORITY, true);

        private final String authority;
        private final boolean writeable;

        FileHost(String str, boolean z6) {
            this.authority = (String) HostedFile.checkNotNull(str);
            this.writeable = z6;
        }

        public String getAuthority() {
            return this.authority;
        }

        public boolean isWritable() {
            return this.writeable;
        }
    }

    public enum FileType {
        FILE("f"),
        DIRECTORY("d");

        private String type;

        FileType(String str) {
            this.type = (String) HostedFile.checkNotNull(str);
        }

        public static FileType fromTypeCode(String str) {
            for (FileType fileType : values()) {
                if (fileType.getTypeCode().equals(str)) {
                    return fileType;
                }
            }
            throw new IllegalArgumentException(a.p("unknown type: ", str));
        }

        public String getTypeCode() {
            return this.type;
        }
    }

    public enum HostedFileColumn {
        NAME("name", String.class, 3, 0),
        TYPE("type", String.class, 3, 1),
        SIZE("size", Long.class, 1, 2),
        DATA("_data", Byte[].class, 4, 3),
        DISPLAY_NAME("_display_name", String.class, 3, 4),
        SIZE_2("_size", Long.class, 2, 5);

        private final int androidType;
        private final String columnName;
        private final Class<?> columnType;
        private final int position;

        HostedFileColumn(String str, Class cls, int i, int i3) {
            this.columnName = (String) HostedFile.checkNotNull(str);
            this.columnType = (Class) HostedFile.checkNotNull(cls);
            this.androidType = i;
            this.position = i3;
        }

        public static String[] getColumnNames() {
            HostedFileColumn[] hostedFileColumnArrValues = values();
            int length = hostedFileColumnArrValues.length;
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = hostedFileColumnArrValues[i].getColumnName();
            }
            return strArr;
        }

        public int getAndroidType() {
            return this.androidType;
        }

        public String getColumnName() {
            return this.columnName;
        }

        public Class<?> getColumnType() {
            return this.columnType;
        }

        public int getPosition() {
            return this.position;
        }
    }

    private HostedFile() {
    }

    public static Uri buildUri(FileHost fileHost, String str) {
        return new Uri.Builder().scheme("content").authority(fileHost.getAuthority()).path(str).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T checkNotNull(T t6) {
        t6.getClass();
        return t6;
    }
}
