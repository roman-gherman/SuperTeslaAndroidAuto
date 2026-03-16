package fr.sd.taada.helpers;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class HexHelper {
    public static String bytesToHexString(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02X ", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    public static byte[] hexStringToBytes(String str) {
        if (str == null || str.length() == 0) {
            return new byte[0];
        }
        String upperCase = str.replaceAll("\\s", "").toUpperCase(Locale.ROOT);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i3 = i * 2;
            bArr[i] = (byte) Integer.parseInt(upperCase.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }

    public static String bytesToHexString(byte[] bArr, int i, int i3) {
        if (bArr == null) {
            return "null";
        }
        if (i >= 0 && i3 > 0 && i < bArr.length) {
            int iMin = Math.min(i3 + i, bArr.length);
            StringBuilder sb = new StringBuilder();
            while (i < iMin) {
                sb.append(String.format("%02X ", Byte.valueOf(bArr[i])));
                i++;
            }
            return sb.toString();
        }
        return "";
    }
}
