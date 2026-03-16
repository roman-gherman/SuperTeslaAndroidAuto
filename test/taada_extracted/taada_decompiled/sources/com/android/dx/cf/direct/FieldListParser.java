package com.android.dx.cf.direct;

import com.android.dx.cf.iface.AttributeList;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.StdField;
import com.android.dx.cf.iface.StdFieldList;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstType;

/* JADX INFO: loaded from: classes.dex */
final class FieldListParser extends MemberListParser {
    private final StdFieldList fields;

    public FieldListParser(DirectClassFile directClassFile, CstType cstType, int i, AttributeFactory attributeFactory) {
        super(directClassFile, cstType, i, attributeFactory);
        this.fields = new StdFieldList(getCount());
    }

    @Override // com.android.dx.cf.direct.MemberListParser
    public int getAttributeContext() {
        return 1;
    }

    public StdFieldList getList() {
        parseIfNecessary();
        return this.fields;
    }

    @Override // com.android.dx.cf.direct.MemberListParser
    public String humanAccessFlags(int i) {
        return AccessFlags.fieldString(i);
    }

    @Override // com.android.dx.cf.direct.MemberListParser
    public String humanName() {
        return "field";
    }

    @Override // com.android.dx.cf.direct.MemberListParser
    public Member set(int i, int i3, CstNat cstNat, AttributeList attributeList) {
        StdField stdField = new StdField(getDefiner(), i3, cstNat, attributeList);
        this.fields.set(i, stdField);
        return stdField;
    }
}
