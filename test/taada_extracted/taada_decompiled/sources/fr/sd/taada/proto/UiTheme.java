package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum UiTheme implements Internal.EnumLite {
    UI_THEME_AUTOMATIC(0),
    UI_THEME_LIGHT(1),
    UI_THEME_DARK(2);

    public static final int UI_THEME_AUTOMATIC_VALUE = 0;
    public static final int UI_THEME_DARK_VALUE = 2;
    public static final int UI_THEME_LIGHT_VALUE = 1;
    private static final Internal.EnumLiteMap<UiTheme> internalValueMap = new Internal.EnumLiteMap<UiTheme>() { // from class: fr.sd.taada.proto.UiTheme.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public UiTheme findValueByNumber(int i) {
            return UiTheme.forNumber(i);
        }
    };
    private final int value;

    public static final class UiThemeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new UiThemeVerifier();

        private UiThemeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return UiTheme.forNumber(i) != null;
        }
    }

    UiTheme(int i) {
        this.value = i;
    }

    public static UiTheme forNumber(int i) {
        if (i == 0) {
            return UI_THEME_AUTOMATIC;
        }
        if (i == 1) {
            return UI_THEME_LIGHT;
        }
        if (i != 2) {
            return null;
        }
        return UI_THEME_DARK;
    }

    public static Internal.EnumLiteMap<UiTheme> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return UiThemeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static UiTheme valueOf(int i) {
        return forNumber(i);
    }
}
