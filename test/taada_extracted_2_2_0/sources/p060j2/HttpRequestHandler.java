package p060j2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.preference.PreferenceManager;
import fr.sd.taada.TransporterService;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.helpers.video.NalStreamManager;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class HttpRequestHandler extends Thread {
    private static final String TAG = "Screen";
    public static BlockingQueue requestQueue = new ArrayBlockingQueue(128);
    private final Context context;
    private LogManager logManager;
    private final Socket socket;

    public static class RequestParams {
        int height;
        boolean webcodec;
        int width;

        private RequestParams() {
            this.width = 1920;
            this.height = 1080;
            this.webcodec = true;
        }
    }

    public HttpRequestHandler(Socket socket, Context context) {
        this.socket = socket;
        this.context = context;
    }

    private void closeQuietly(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
                getLogManager().logError("WebServer", "Error closing resource: " + e.getMessage());
            }
        }
    }

    private int getBuildVersion() {
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
            return Build.VERSION.SDK_INT >= 28 ? (int) packageInfo.getLongVersionCode() : packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            getLogManager().logError("HttpRequestHandler", "Error getting build version", e);
            return 46;
        } catch (Exception e6) {
            getLogManager().logError("HttpRequestHandler", "Error accessing versionCode via reflection", e6);
            return 46;
        }
    }

    private LogManager getLogManager() {
        if (this.logManager == null) {
            this.logManager = LogManager.getInstance(this.context);
        }
        return this.logManager;
    }

    private void handleGetRequest(String str, PrintWriter printWriter, BufferedOutputStream bufferedOutputStream) throws IOException {
        RequestParams queryParameters = parseQueryParameters(str);
        getLogManager().logDebug(TAG, "Values from car: " + queryParameters.width + "x" + queryParameters.height + ", webcodec: " + queryParameters.webcodec);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        sendHttpResponse(handleResolutionUpdate(queryParameters, defaultSharedPreferences, Integer.parseInt(defaultSharedPreferences.getString("resolution", "1")), defaultSharedPreferences.getBoolean("showdebug", false), defaultSharedPreferences.getBoolean("useBT", true)), printWriter, bufferedOutputStream);
    }

    private String handleResolutionUpdate(RequestParams requestParams, SharedPreferences sharedPreferences, int i, boolean z6, boolean z7) {
        sharedPreferences.edit().putInt("stored_width", requestParams.width).putInt("stored_height", requestParams.height).apply();
        getLogManager().logDebug(TAG, "Stored values updated");
        getLogManager().logDebug(TAG, "Adapting resolution dynamically");
        NalStreamManager.MarginResult marginResultAdjustResolution = NalStreamManager.adjustResolution(this.context, requestParams.width, requestParams.height);
        return "{\"width\":" + requestParams.width + ",\"height\":" + requestParams.height + ",\"widthMargin\":" + marginResultAdjustResolution.widthMargin + ",\"heightMargin\":" + marginResultAdjustResolution.heightMargin + ",\"port\":" + TransporterService.webServerPort + ",\"resolution\":" + i + ",\"buildversion\":" + getBuildVersion() + ",\"usebt\":" + z7 + ",\"debug\":" + z6 + ",\"resolutionChanged\":true}";
    }

    private RequestParams parseQueryParameters(String str) {
        RequestParams requestParams = new RequestParams();
        for (String str2 : str.split("\\?")[1].split("&")) {
            String[] strArrSplit = str2.split("=");
            if (strArrSplit.length == 2) {
                String str3 = strArrSplit[0];
                str3.getClass();
                switch (str3) {
                    case "webcodec":
                        requestParams.webcodec = Boolean.parseBoolean(strArrSplit[1]);
                        break;
                    case "h":
                        requestParams.height = Integer.parseInt(strArrSplit[1]);
                        break;
                    case "w":
                        requestParams.width = Integer.parseInt(strArrSplit[1]);
                        break;
                }
            }
        }
        return requestParams;
    }

    private void sendHttpResponse(String str, PrintWriter printWriter, BufferedOutputStream bufferedOutputStream) throws IOException {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (Exception unused) {
            bytes = str.getBytes();
        }
        printWriter.println("HTTP/1.1 200 OK");
        printWriter.println("Server: HUR : 1.0");
        printWriter.println("Date: " + new Date());
        printWriter.println("Content-type: text/html");
        printWriter.println("Content-Length: " + bytes.length);
        printWriter.println("Access-Control-Allow-Origin: *");
        printWriter.println();
        printWriter.flush();
        getLogManager().logDebug(TAG, "Response: " + str);
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException unused2) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        BufferedReader bufferedReader;
        PrintWriter printWriter;
        BufferedOutputStream bufferedOutputStream;
        AutoCloseable autoCloseable = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                try {
                    printWriter = new PrintWriter(this.socket.getOutputStream());
                    try {
                        bufferedOutputStream = new BufferedOutputStream(this.socket.getOutputStream());
                    } catch (Exception e) {
                        e = e;
                    }
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            getLogManager().logDebug("WebServer", "Input: ".concat(line));
                            StringTokenizer stringTokenizer = new StringTokenizer(line);
                            String strNextToken = stringTokenizer.nextToken();
                            Locale locale = Locale.ROOT;
                            String upperCase = strNextToken.toUpperCase(locale);
                            String lowerCase = stringTokenizer.nextToken().toLowerCase(locale);
                            if (upperCase.equals("GET")) {
                                handleGetRequest(lowerCase, printWriter, bufferedOutputStream);
                            }
                        }
                        closeQuietly(bufferedOutputStream);
                        closeQuietly(printWriter);
                        closeQuietly(bufferedReader);
                        closeQuietly(this.socket);
                    } catch (Exception e6) {
                        e = e6;
                        autoCloseable = bufferedOutputStream;
                        getLogManager().logError("WebServer", "Error processing request: " + e.getMessage(), e);
                        closeQuietly(autoCloseable);
                        closeQuietly(printWriter);
                        closeQuietly(bufferedReader);
                        closeQuietly(this.socket);
                    } catch (Throwable th) {
                        th = th;
                        autoCloseable = bufferedOutputStream;
                        closeQuietly(autoCloseable);
                        closeQuietly(printWriter);
                        closeQuietly(bufferedReader);
                        closeQuietly(this.socket);
                        throw th;
                    }
                } catch (Exception e7) {
                    e = e7;
                    printWriter = null;
                } catch (Throwable th2) {
                    th = th2;
                    printWriter = null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e8) {
            e = e8;
            bufferedReader = null;
            printWriter = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            printWriter = null;
        }
    }

    private void closeQuietly(Socket socket) {
        if (socket == null || socket.isClosed()) {
            return;
        }
        try {
            socket.close();
        } catch (IOException e) {
            getLogManager().logError("WebServer", "Error closing socket: " + e.getMessage());
        }
    }
}
