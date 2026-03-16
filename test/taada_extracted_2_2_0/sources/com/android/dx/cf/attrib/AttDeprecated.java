package com.android.dx.cf.attrib;

/* JADX INFO: loaded from: classes.dex */
public final class AttDeprecated extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "Deprecated";

    public AttDeprecated() {
        super(ATTRIBUTE_NAME);
    }

    @Override // com.android.dx.cf.iface.Attribute
    public int byteLength() {
        return 6;
    }
}
