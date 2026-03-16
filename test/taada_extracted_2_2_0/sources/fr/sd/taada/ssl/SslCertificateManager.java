package fr.sd.taada.ssl;

import android.content.Context;
import android.util.Log;
import androidx.preference.PreferenceManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class SslCertificateManager {
    private static final String CERT_FILE_NAME = "dynamic-server-cert.p12";
    private static final String DEFAULT_CERT_URL = "https://cert.taada.top";
    private static final String KEY_CERT_URL = "crt_url";
    private static final String TAG = "SslCertificateManager";

    private static String calculateLocalFingerprint(File file) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        byte[] bArr;
        int i;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
                bArr = new byte[8192];
            } finally {
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to calculate local fingerprint: " + e.getMessage());
            return null;
        }
        while (true) {
            int i3 = fileInputStream.read(bArr);
            if (i3 == -1) {
                break;
            }
            messageDigest.update(bArr, 0, i3);
            Log.e(TAG, "Failed to calculate local fingerprint: " + e.getMessage());
            return null;
        }
        byte[] bArrDigest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        String string = sb.toString();
        fileInputStream.close();
        return string;
    }

    public static void checkAndDownloadCertificate(Context context) {
        try {
            if (needsUpdate(context)) {
                downloadCertificate(context);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error checking/downloading certificate", e);
        }
    }

    private static void downloadCertificate(Context context) {
        FileOutputStream fileOutputStream;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(PreferenceManager.getDefaultSharedPreferences(context).getString(KEY_CERT_URL, DEFAULT_CERT_URL)).openConnection();
        try {
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Failed to download cert, status: " + httpURLConnection.getResponseCode());
            }
            File certFile = getCertFile(context);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                fileOutputStream = new FileOutputStream(certFile);
            } finally {
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i == -1) {
                        certFile.getAbsolutePath();
                        fileOutputStream.close();
                        bufferedInputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } finally {
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private static File getCertFile(Context context) {
        return new File(context.getFilesDir(), CERT_FILE_NAME);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getServerFingerprint(android.content.Context r5) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "SslCertificateManager"
            java.lang.String r1 = "Health endpoint returned: "
            android.content.SharedPreferences r5 = androidx.preference.PreferenceManager.getDefaultSharedPreferences(r5)
            java.lang.String r2 = "crt_url"
            java.lang.String r3 = "https://cert.taada.top"
            java.lang.String r5 = r5.getString(r2, r3)
            java.lang.String r2 = "/health"
            java.lang.String r5 = B2.b.e(r5, r2)
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            java.net.URLConnection r5 = r3.openConnection()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            r3 = 5000(0x1388, float:7.006E-42)
            r5.setConnectTimeout(r3)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            r5.setReadTimeout(r3)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            int r3 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 == r4) goto L4e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            int r1 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            r3.append(r1)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            android.util.Log.w(r0, r1)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            r5.disconnect()
            return r2
        L49:
            r0 = move-exception
            r2 = r5
            goto La3
        L4c:
            r1 = move-exception
            goto L85
        L4e:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            java.io.InputStream r4 = r5.getInputStream()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            r3.<init>()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
        L61:
            java.lang.String r4 = r1.readLine()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            if (r4 == 0) goto L6b
            r3.append(r4)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            goto L61
        L6b:
            r1.close()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            java.lang.String r3 = "certificate_fingerprint"
            java.lang.String r0 = r1.optString(r3, r2)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            r5.disconnect()
            return r0
        L81:
            r0 = move-exception
            goto La3
        L83:
            r1 = move-exception
            r5 = r2
        L85:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49
            r3.<init>()     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = "Failed to get server fingerprint: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L49
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L49
            r3.append(r1)     // Catch: java.lang.Throwable -> L49
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L49
            android.util.Log.w(r0, r1)     // Catch: java.lang.Throwable -> L49
            if (r5 == 0) goto La2
            r5.disconnect()
        La2:
            return r2
        La3:
            if (r2 == 0) goto La8
            r2.disconnect()
        La8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.ssl.SslCertificateManager.getServerFingerprint(android.content.Context):java.lang.String");
    }

    private static boolean needsUpdate(Context context) throws Throwable {
        File certFile = getCertFile(context);
        if (!certFile.exists()) {
            return true;
        }
        try {
            if (getServerFingerprint(context) == null) {
                Log.w(TAG, "Could not get server fingerprint, forcing download");
                return true;
            }
            if (calculateLocalFingerprint(certFile) != null) {
                return !r4.equals(r1);
            }
            Log.w(TAG, "Could not calculate local fingerprint, forcing download");
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Error comparing fingerprints, forcing download", e);
            return true;
        }
    }
}
