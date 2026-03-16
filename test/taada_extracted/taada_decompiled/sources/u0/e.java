package U0;

import C0.t;
import E1.k;
import R0.h;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import c4.AbstractC0246d;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends V0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f1313a;

    public static e a(Context context) {
        Class<?> cls;
        String str;
        Class<?> cls2;
        Class<?> cls3;
        Object objNewProxyInstance;
        Object objA0;
        Object objD;
        t tVar;
        int i = 6;
        boolean z6 = false;
        Boolean bool = Boolean.FALSE;
        String string = "";
        if (("Amazon".equals(Build.MANUFACTURER) ? "amazon" : "android").equals("amazon")) {
            tVar = new t(i, z6);
            try {
                ContentResolver contentResolver = context.getContentResolver();
                int i3 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 2);
                if (i3 == 0) {
                    string = Settings.Secure.getString(contentResolver, "advertising_id");
                } else {
                    bool = i3 == 2 ? Boolean.TRUE : Boolean.TRUE;
                }
            } catch (Exception unused) {
            }
            tVar.b = string;
            tVar.e = bool;
        } else {
            Object objB = b(context, 3);
            String deviceId = null;
            String str2 = (String) AbstractC0246d.z0(objB, "getId", null, new Object[0]);
            Boolean bool2 = (Boolean) AbstractC0246d.z0(objB, "isLimitAdTrackingEnabled", null, new Object[0]);
            t tVar2 = new t(i, z6);
            tVar2.b = str2;
            tVar2.e = bool2;
            if (context == null) {
                Log.e("OaidRequester", "invalid input param");
                str = null;
            } else {
                try {
                    cls = Class.forName("com.huawei.hms.ads.identifier.AdvertisingIdClient");
                } catch (Throwable unused2) {
                    cls = null;
                }
                if (cls == null || !TextUtils.isEmpty(null) || (objD = k.D(context, 3)) == null) {
                    str = null;
                } else {
                    str = (String) AbstractC0246d.z0(objD, "getId", null, new Object[0]);
                    ((Boolean) AbstractC0246d.z0(objD, "isLimitAdTrackingEnabled", null, new Object[0])).getClass();
                }
                if (str == null) {
                    try {
                        cls2 = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
                    } catch (Throwable unused3) {
                        cls2 = null;
                    }
                    if (cls2 != null) {
                        Y0.a aVar = new Y0.a();
                        aVar.b = null;
                        aVar.f1477a = context.getApplicationContext();
                        aVar.b = new LinkedBlockingQueue(1);
                        try {
                            cls3 = Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
                        } catch (Throwable unused4) {
                            cls3 = null;
                        }
                        if (cls3 != null) {
                            try {
                                objNewProxyInstance = Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, aVar);
                            } catch (IllegalArgumentException | NullPointerException e) {
                                e.printStackTrace();
                                objNewProxyInstance = null;
                            }
                            if (objNewProxyInstance != null) {
                                try {
                                    objA0 = AbstractC0246d.A0("com.bun.miitmdid.core.MdidSdkHelper", "InitSdk", new Class[]{Context.class, Boolean.TYPE, cls3}, aVar.f1477a, Boolean.TRUE, objNewProxyInstance);
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                    objA0 = null;
                                }
                                if (objA0 != null) {
                                }
                                string = (String) aVar.b.poll(3000L, TimeUnit.MILLISECONDS);
                            }
                        }
                        str = string;
                    }
                }
            }
            tVar2.c = str;
            if (context == null) {
                Log.e("ImeiRequester", "invalid input param");
            } else {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                try {
                    AtomicBoolean atomicBoolean = h.f1257o;
                    deviceId = telephonyManager.getDeviceId();
                } catch (SecurityException unused5) {
                    Log.e("ImeiRequester", "IMEI request failed with SecurityException");
                } catch (Exception unused6) {
                    Log.e("ImeiRequester", "IMEI request failed");
                }
            }
            tVar2.d = deviceId;
            tVar = tVar2;
        }
        e eVar = new e();
        eVar.f1313a = tVar;
        return eVar;
    }

    public static Object b(Context context, Integer num) {
        Class<?> cls;
        if (num.intValue() <= 0) {
            Log.e("Tenjin", "Failed to retrieve advertising ID - giving up");
            return null;
        }
        try {
            return AbstractC0246d.A0("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class}, context);
        } catch (Exception e) {
            if (e instanceof InvocationTargetException) {
                Throwable targetException = ((InvocationTargetException) e).getTargetException();
                targetException.getLocalizedMessage();
                try {
                    cls = Class.forName("com.google.android.gms.common.GooglePlayServicesRepairableException");
                } catch (Throwable unused) {
                    cls = null;
                }
                if ((targetException instanceof IOException) || (cls != null && targetException.getClass().isAssignableFrom(cls))) {
                    return b(context, Integer.valueOf(num.intValue() - 1));
                }
            }
            return null;
        }
    }

    @Override // com.tenjin.android.params.base.ParamProvider
    public final Map apply(Map map) {
        t tVar = this.f1313a;
        map.put("advertising_id", (String) tVar.b);
        map.put("limit_ad_tracking", String.valueOf((Boolean) tVar.e));
        String str = (String) tVar.c;
        if (str != null) {
            map.put("oaid", str);
        }
        String str2 = (String) tVar.d;
        if (str2 != null) {
            map.put("imei", str2);
        }
        return map;
    }
}
