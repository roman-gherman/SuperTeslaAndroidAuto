package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import android.content.res.loader.ResourcesProvider;
import android.graphics.Color;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.android.billingclient.api.A;
import com.google.android.gms.location.h;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k0.AbstractC0572b;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte f2354a;
    public static final c b = new c(1, "android");
    public static final h c = new h(1);
    public static final n0.d d = new n0.d(4);
    public static final /* synthetic */ int e = 0;

    public static byte[] a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static boolean b(Context context, Map map) throws Throwable {
        FileDescriptor fileDescriptorMemfd_create;
        ResourcesLoader resourcesLoader = null;
        try {
            byte[] bArrD = d(context, map);
            int length = bArrD.length;
            if (bArrD.length != 0) {
                try {
                    fileDescriptorMemfd_create = Os.memfd_create("temp.arsc", 0);
                } catch (Throwable th) {
                    th = th;
                    fileDescriptorMemfd_create = null;
                }
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(fileDescriptorMemfd_create);
                    try {
                        fileOutputStream.write(bArrD);
                        ParcelFileDescriptor parcelFileDescriptorDup = ParcelFileDescriptor.dup(fileDescriptorMemfd_create);
                        try {
                            androidx.core.view.accessibility.c.l();
                            ResourcesLoader resourcesLoaderE = androidx.core.view.accessibility.c.e();
                            resourcesLoaderE.addProvider(ResourcesProvider.loadFromTable(parcelFileDescriptorDup, null));
                            if (parcelFileDescriptorDup != null) {
                                parcelFileDescriptorDup.close();
                            }
                            fileOutputStream.close();
                            if (fileDescriptorMemfd_create != null) {
                                Os.close(fileDescriptorMemfd_create);
                            }
                            resourcesLoader = resourcesLoaderE;
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileDescriptorMemfd_create != null) {
                        Os.close(fileDescriptorMemfd_create);
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            Log.e("g", "Failed to create the ColorResourcesTableCreator.", e6);
        }
        if (resourcesLoader == null) {
            return false;
        }
        context.getResources().addLoaders(resourcesLoader);
        return true;
    }

    public static byte[] c(char c6) {
        return new byte[]{(byte) (c6 & 255), (byte) ((c6 >> '\b') & 255)};
    }

    public static byte[] d(Context context, Map map) throws IOException {
        c cVar;
        if (map.entrySet().isEmpty()) {
            throw new IllegalArgumentException("No color resources provided for harmonization.");
        }
        c cVar2 = new c(127, context.getPackageName());
        HashMap map2 = new HashMap();
        a aVar = null;
        for (Map.Entry entry : map.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            String resourceName = context.getResources().getResourceName(((Integer) entry.getKey()).intValue());
            a aVar2 = new a(iIntValue, ((Integer) entry.getValue()).intValue(), resourceName);
            if (!context.getResources().getResourceTypeName(((Integer) entry.getKey()).intValue()).equals(TypedValues.Custom.S_COLOR)) {
                throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.h(aVar2.b & 255, B2.b.m("Non color resource found: name=", resourceName, ", typeId=")));
            }
            byte b2 = aVar2.f2342a;
            if (b2 == 1) {
                cVar = b;
            } else {
                if (b2 != 127) {
                    throw new IllegalArgumentException(B2.b.c(b2, "Not supported with unknown package id: "));
                }
                cVar = cVar2;
            }
            if (!map2.containsKey(cVar)) {
                map2.put(cVar, new ArrayList());
            }
            ((List) map2.get(cVar)).add(aVar2);
            aVar = aVar2;
        }
        byte b6 = aVar.b;
        f2354a = b6;
        if (b6 == 0) {
            throw new IllegalArgumentException("No color resources found for harmonization.");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ArrayList<b> arrayList = new ArrayList();
        int size = map2.size();
        f fVar = new f(false, new String[0]);
        for (Map.Entry entry2 : map2.entrySet()) {
            List list = (List) entry2.getValue();
            Collections.sort(list, c);
            arrayList.add(new b((c) entry2.getKey(), list));
        }
        Iterator it = arrayList.iterator();
        int iA = 0;
        while (it.hasNext()) {
            iA += ((b) it.next()).a();
        }
        int i = fVar.f2353l + 12 + iA;
        byteArrayOutputStream.write(h((short) 2));
        byteArrayOutputStream.write(h((short) 12));
        byteArrayOutputStream.write(a(i));
        byteArrayOutputStream.write(a(size));
        fVar.a(byteArrayOutputStream);
        for (b bVar : arrayList) {
            bVar.f2343a.a(byteArrayOutputStream);
            c cVar3 = bVar.b;
            byteArrayOutputStream.write(a(cVar3.f2344a));
            char[] charArray = cVar3.b.toCharArray();
            for (int i3 = 0; i3 < 128; i3++) {
                if (i3 < charArray.length) {
                    byteArrayOutputStream.write(c(charArray[i3]));
                } else {
                    byteArrayOutputStream.write(c((char) 0));
                }
            }
            byteArrayOutputStream.write(a(288));
            byteArrayOutputStream.write(a(0));
            f fVar2 = bVar.c;
            byteArrayOutputStream.write(a(fVar2.f2353l + 288));
            byteArrayOutputStream.write(a(0));
            byteArrayOutputStream.write(a(0));
            fVar2.a(byteArrayOutputStream);
            bVar.d.a(byteArrayOutputStream);
            A a6 = bVar.e;
            ((d) a6.b).a(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{f2354a, 0, 0, 0});
            byteArrayOutputStream.write(a(a6.f1800a));
            for (int i4 : (int[]) a6.c) {
                byteArrayOutputStream.write(a(i4));
            }
            Y0.b bVar2 = (Y0.b) a6.d;
            ((d) bVar2.b).a(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{f2354a, 0, 0, 0});
            byteArrayOutputStream.write(a(bVar2.f1478a));
            int[] iArr = (int[]) bVar2.d;
            byteArrayOutputStream.write(a((iArr.length * 4) + 84));
            byteArrayOutputStream.write((byte[]) bVar2.c);
            for (int i5 : iArr) {
                byteArrayOutputStream.write(a(i5));
            }
            for (e eVar : (e[]) bVar2.e) {
                eVar.getClass();
                byteArrayOutputStream.write(h((short) 8));
                byteArrayOutputStream.write(h((short) 2));
                byteArrayOutputStream.write(a(eVar.f2346a));
                byteArrayOutputStream.write(h((short) 8));
                byteArrayOutputStream.write(new byte[]{0, 28});
                byteArrayOutputStream.write(a(eVar.b));
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static int e(Context context, int i, int i3) {
        TypedValue typedValueA = AbstractC0572b.a(context, i);
        if (typedValueA == null) {
            return i3;
        }
        int i4 = typedValueA.resourceId;
        return i4 != 0 ? ContextCompat.getColor(context, i4) : typedValueA.data;
    }

    public static int f(View view, int i) {
        Context context = view.getContext();
        TypedValue typedValueC = AbstractC0572b.c(view.getContext(), i, view.getClass().getCanonicalName());
        int i3 = typedValueC.resourceId;
        return i3 != 0 ? ContextCompat.getColor(context, i3) : typedValueC.data;
    }

    public static int g(int i, int i3, float f6) {
        return ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i3, Math.round(Color.alpha(i3) * f6)), i);
    }

    public static byte[] h(short s3) {
        return new byte[]{(byte) (s3 & 255), (byte) ((s3 >> 8) & 255)};
    }
}
