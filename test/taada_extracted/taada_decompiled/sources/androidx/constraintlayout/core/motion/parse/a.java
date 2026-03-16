package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.parse.KeyParser;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements KeyParser.Ids, KeyParser.DataType {
    @Override // androidx.constraintlayout.core.motion.parse.KeyParser.DataType
    public int get(int i) {
        return TypedValues.AttributesType.getType(i);
    }

    @Override // androidx.constraintlayout.core.motion.parse.KeyParser.Ids
    public int get(String str) {
        return TypedValues.AttributesType.getId(str);
    }
}
