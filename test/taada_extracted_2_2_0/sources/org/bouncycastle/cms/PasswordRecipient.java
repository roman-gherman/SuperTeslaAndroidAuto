package org.bouncycastle.cms;

/* JADX INFO: loaded from: classes2.dex */
public interface PasswordRecipient extends Recipient {
    public static final int PKCS5_SCHEME2 = 0;
    public static final int PKCS5_SCHEME2_UTF8 = 1;

    byte[] calculateDerivedKey(int i, H3.a aVar, int i3);

    char[] getPassword();

    int getPasswordConversionScheme();

    a getRecipientOperator(H3.a aVar, H3.a aVar2, byte[] bArr, byte[] bArr2);
}
