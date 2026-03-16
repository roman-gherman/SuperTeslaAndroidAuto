package G2;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;

/* JADX INFO: renamed from: G2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public enum EnumC0104d implements Internal$EnumLite {
    BYTE(0),
    CHAR(1),
    SHORT(2),
    INT(3),
    LONG(4),
    FLOAT(5),
    DOUBLE(6),
    BOOLEAN(7),
    STRING(8),
    CLASS(9),
    ENUM(10),
    ANNOTATION(11),
    ARRAY(12);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f560a;

    EnumC0104d(int i) {
        this.f560a = i;
    }

    public static EnumC0104d a(int i) {
        switch (i) {
            case 0:
                return BYTE;
            case 1:
                return CHAR;
            case 2:
                return SHORT;
            case 3:
                return INT;
            case 4:
                return LONG;
            case 5:
                return FLOAT;
            case 6:
                return DOUBLE;
            case 7:
                return BOOLEAN;
            case 8:
                return STRING;
            case 9:
                return CLASS;
            case 10:
                return ENUM;
            case 11:
                return ANNOTATION;
            case 12:
                return ARRAY;
            default:
                return null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
    public final int getNumber() {
        return this.f560a;
    }
}
