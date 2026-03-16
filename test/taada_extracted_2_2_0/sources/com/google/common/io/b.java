package com.google.common.io;

/* JADX INFO: loaded from: classes.dex */
public final class b extends e {
    public final char[] e;

    /* JADX WARN: Illegal instructions before constructor call */
    public b() {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        super(new a("base16()", charArray), (Character) null);
        this.e = new char[512];
        if (charArray.length != 16) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 256; i++) {
            char[] cArr = this.e;
            cArr[i] = charArray[i >>> 4];
            cArr[i | 256] = charArray[i & 15];
        }
    }

    @Override // com.google.common.io.e
    public final int b(byte[] bArr, CharSequence charSequence) throws d {
        if (charSequence.length() % 2 == 1) {
            throw new d("Invalid input length " + charSequence.length());
        }
        int i = 0;
        int i3 = 0;
        while (i < charSequence.length()) {
            char cCharAt = charSequence.charAt(i);
            a aVar = this.f2787a;
            bArr[i3] = (byte) ((aVar.a(cCharAt) << 4) | aVar.a(charSequence.charAt(i + 1)));
            i += 2;
            i3++;
        }
        return i3;
    }
}
