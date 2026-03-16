package com.android.dx.cf.direct;

import com.android.dx.cf.attrib.RawAttribute;
import com.android.dx.cf.iface.Attribute;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstString;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;

/* JADX INFO: loaded from: classes.dex */
public class AttributeFactory {
    public static final int CTX_CLASS = 0;
    public static final int CTX_CODE = 3;
    public static final int CTX_COUNT = 4;
    public static final int CTX_FIELD = 1;
    public static final int CTX_METHOD = 2;

    public final Attribute parse(DirectClassFile directClassFile, int i, int i3, ParseObserver parseObserver) {
        String str;
        if (directClassFile == null) {
            throw new NullPointerException("cf == null");
        }
        if (i < 0 || i >= 4) {
            throw new IllegalArgumentException("bad context");
        }
        CstString cstString = null;
        try {
            ByteArray bytes = directClassFile.getBytes();
            ConstantPool constantPool = directClassFile.getConstantPool();
            int unsignedShort = bytes.getUnsignedShort(i3);
            int i4 = i3 + 2;
            int i5 = bytes.getInt(i4);
            CstString cstString2 = (CstString) constantPool.get(unsignedShort);
            if (parseObserver != null) {
                try {
                    parseObserver.parsed(bytes, i3, 2, "name: " + cstString2.toHuman());
                    parseObserver.parsed(bytes, i4, 4, "length: " + Hex.u4(i5));
                } catch (ParseException e) {
                    e = e;
                    cstString = cstString2;
                    StringBuilder sb = new StringBuilder("...while parsing ");
                    if (cstString != null) {
                        str = cstString.toHuman() + " ";
                    } else {
                        str = "";
                    }
                    sb.append(str);
                    sb.append("attribute at offset ");
                    sb.append(Hex.u4(i3));
                    e.addContext(sb.toString());
                    throw e;
                }
            }
            return parse0(directClassFile, i, cstString2.getString(), i3 + 6, i5, parseObserver);
        } catch (ParseException e6) {
            e = e6;
        }
    }

    public Attribute parse0(DirectClassFile directClassFile, int i, String str, int i3, int i4, ParseObserver parseObserver) {
        ByteArray bytes = directClassFile.getBytes();
        RawAttribute rawAttribute = new RawAttribute(str, bytes, i3, i4, directClassFile.getConstantPool());
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i3, i4, "attribute data");
        }
        return rawAttribute;
    }
}
