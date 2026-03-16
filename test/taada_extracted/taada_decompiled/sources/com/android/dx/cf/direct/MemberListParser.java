package com.android.dx.cf.direct;

import com.android.dx.cf.iface.AttributeList;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.cf.iface.StdAttributeList;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;

/* JADX INFO: loaded from: classes.dex */
abstract class MemberListParser {
    private final AttributeFactory attributeFactory;
    private final DirectClassFile cf;
    private final CstType definer;
    private int endOffset;
    private ParseObserver observer;
    private final int offset;

    public MemberListParser(DirectClassFile directClassFile, CstType cstType, int i, AttributeFactory attributeFactory) {
        if (directClassFile == null) {
            throw new NullPointerException("cf == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("offset < 0");
        }
        if (attributeFactory == null) {
            throw new NullPointerException("attributeFactory == null");
        }
        this.cf = directClassFile;
        this.definer = cstType;
        this.offset = i;
        this.attributeFactory = attributeFactory;
        this.endOffset = -1;
    }

    private void parse() {
        int i;
        int i3;
        ConstantPool constantPool;
        char c;
        int i4;
        int attributeContext = getAttributeContext();
        int count = getCount();
        int i5 = this.offset + 2;
        ByteArray bytes = this.cf.getBytes();
        ConstantPool constantPool2 = this.cf.getConstantPool();
        ParseObserver parseObserver = this.observer;
        if (parseObserver != null) {
            parseObserver.parsed(bytes, this.offset, 2, humanName() + "s_count: " + Hex.u2(count));
        }
        int i6 = 0;
        while (i6 < count) {
            try {
                int unsignedShort = bytes.getUnsignedShort(i5);
                int i7 = i5 + 2;
                int unsignedShort2 = bytes.getUnsignedShort(i7);
                int i8 = i5 + 4;
                int unsignedShort3 = bytes.getUnsignedShort(i8);
                CstString cstString = (CstString) constantPool2.get(unsignedShort2);
                CstString cstString2 = (CstString) constantPool2.get(unsignedShort3);
                ParseObserver parseObserver2 = this.observer;
                if (parseObserver2 != null) {
                    i3 = count;
                    constantPool = constantPool2;
                    parseObserver2.startParsingMember(bytes, i5, cstString.getString(), cstString2.getString());
                    this.observer.parsed(bytes, i5, 0, "\n" + humanName() + "s[" + i6 + "]:\n");
                    this.observer.changeIndent(1);
                    ParseObserver parseObserver3 = this.observer;
                    StringBuilder sb = new StringBuilder();
                    sb.append("access_flags: ");
                    sb.append(humanAccessFlags(unsignedShort));
                    parseObserver3.parsed(bytes, i5, 2, sb.toString());
                    this.observer.parsed(bytes, i7, 2, "name: " + cstString.toHuman());
                    c = 2;
                    this.observer.parsed(bytes, i8, 2, "descriptor: " + cstString2.toHuman());
                } else {
                    i3 = count;
                    constantPool = constantPool2;
                    c = 2;
                }
                AttributeListParser attributeListParser = new AttributeListParser(this.cf, attributeContext, i5 + 6, this.attributeFactory);
                attributeListParser.setObserver(this.observer);
                int endOffset = attributeListParser.getEndOffset();
                StdAttributeList list = attributeListParser.getList();
                list.setImmutable();
                Member member = set(i6, unsignedShort, new CstNat(cstString, cstString2), list);
                ParseObserver parseObserver4 = this.observer;
                if (parseObserver4 != null) {
                    parseObserver4.changeIndent(-1);
                    this.observer.parsed(bytes, endOffset, 0, "end " + humanName() + "s[" + i6 + "]\n");
                    i = i6;
                    try {
                        i4 = endOffset;
                        this.observer.endParsingMember(bytes, i4, cstString.getString(), cstString2.getString(), member);
                    } catch (ParseException e) {
                        e = e;
                        e.addContext("...while parsing " + humanName() + "s[" + i + "]");
                        throw e;
                    } catch (RuntimeException e6) {
                        e = e6;
                        ParseException parseException = new ParseException(e);
                        parseException.addContext("...while parsing " + humanName() + "s[" + i + "]");
                        throw parseException;
                    }
                } else {
                    i4 = endOffset;
                    i = i6;
                }
                i6 = i + 1;
                i5 = i4;
                count = i3;
                constantPool2 = constantPool;
            } catch (ParseException e7) {
                e = e7;
                i = i6;
            } catch (RuntimeException e8) {
                e = e8;
                i = i6;
            }
        }
        this.endOffset = i5;
    }

    public abstract int getAttributeContext();

    public final int getCount() {
        return this.cf.getBytes().getUnsignedShort(this.offset);
    }

    public final CstType getDefiner() {
        return this.definer;
    }

    public int getEndOffset() {
        parseIfNecessary();
        return this.endOffset;
    }

    public abstract String humanAccessFlags(int i);

    public abstract String humanName();

    public final void parseIfNecessary() {
        if (this.endOffset < 0) {
            parse();
        }
    }

    public abstract Member set(int i, int i3, CstNat cstNat, AttributeList attributeList);

    public final void setObserver(ParseObserver parseObserver) {
        this.observer = parseObserver;
    }
}
