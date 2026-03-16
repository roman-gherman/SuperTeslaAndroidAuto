package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum GoogleDiagnosticsVendorExtensionMessageId implements Internal.EnumLite {
    DIAGNOSTICS_BUG_REPORT_REQUEST(1),
    DIAGNOSTICS_BUG_REPORT_RESPONSE(2);

    public static final int DIAGNOSTICS_BUG_REPORT_REQUEST_VALUE = 1;
    public static final int DIAGNOSTICS_BUG_REPORT_RESPONSE_VALUE = 2;
    private static final Internal.EnumLiteMap<GoogleDiagnosticsVendorExtensionMessageId> internalValueMap = new Internal.EnumLiteMap<GoogleDiagnosticsVendorExtensionMessageId>() { // from class: fr.sd.taada.proto.GoogleDiagnosticsVendorExtensionMessageId.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public GoogleDiagnosticsVendorExtensionMessageId findValueByNumber(int i) {
            return GoogleDiagnosticsVendorExtensionMessageId.forNumber(i);
        }
    };
    private final int value;

    public static final class GoogleDiagnosticsVendorExtensionMessageIdVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new GoogleDiagnosticsVendorExtensionMessageIdVerifier();

        private GoogleDiagnosticsVendorExtensionMessageIdVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return GoogleDiagnosticsVendorExtensionMessageId.forNumber(i) != null;
        }
    }

    GoogleDiagnosticsVendorExtensionMessageId(int i) {
        this.value = i;
    }

    public static GoogleDiagnosticsVendorExtensionMessageId forNumber(int i) {
        if (i == 1) {
            return DIAGNOSTICS_BUG_REPORT_REQUEST;
        }
        if (i != 2) {
            return null;
        }
        return DIAGNOSTICS_BUG_REPORT_RESPONSE;
    }

    public static Internal.EnumLiteMap<GoogleDiagnosticsVendorExtensionMessageId> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return GoogleDiagnosticsVendorExtensionMessageIdVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static GoogleDiagnosticsVendorExtensionMessageId valueOf(int i) {
        return forNumber(i);
    }
}
