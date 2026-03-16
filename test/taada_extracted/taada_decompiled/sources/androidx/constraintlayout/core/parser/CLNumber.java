package androidx.constraintlayout.core.parser;

import B2.b;

/* JADX INFO: loaded from: classes.dex */
public class CLNumber extends CLElement {
    float value;

    public CLNumber(char[] cArr) {
        super(cArr);
        this.value = Float.NaN;
    }

    public static CLElement allocate(char[] cArr) {
        return new CLNumber(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public float getFloat() {
        if (Float.isNaN(this.value)) {
            this.value = Float.parseFloat(content());
        }
        return this.value;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int getInt() {
        if (Float.isNaN(this.value)) {
            this.value = Integer.parseInt(content());
        }
        return (int) this.value;
    }

    public boolean isInt() {
        float f6 = getFloat();
        return ((float) ((int) f6)) == f6;
    }

    public void putValue(float f6) {
        this.value = f6;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i3) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        float f6 = getFloat();
        int i4 = (int) f6;
        if (i4 == f6) {
            sb.append(i4);
        } else {
            sb.append(f6);
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        float f6 = getFloat();
        int i = (int) f6;
        if (i == f6) {
            return b.c(i, "");
        }
        return "" + f6;
    }

    public CLNumber(float f6) {
        super(null);
        this.value = f6;
    }
}
