package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class ResourcesFlusher {
    private static final String TAG = "ResourcesFlusher";
    private static Field sDrawableCacheField;
    private static boolean sDrawableCacheFieldFetched;
    private static Field sResourcesImplField;
    private static boolean sResourcesImplFieldFetched;
    private static Class<?> sThemedResourceCacheClazz;
    private static boolean sThemedResourceCacheClazzFetched;
    private static Field sThemedResourceCache_mUnthemedEntriesField;
    private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    public static class Api16Impl {
        private Api16Impl() {
        }

        public static void clear(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }

    private ResourcesFlusher() {
    }

    public static void flush(Resources resources) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        flushNougats(resources);
    }

    private static void flushLollipops(Resources resources) {
        Map map;
        if (!sDrawableCacheFieldFetched) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                sDrawableCacheField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e);
            }
            sDrawableCacheFieldFetched = true;
        }
        Field field = sDrawableCacheField;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e6) {
                Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e6);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void flushMarshmallows(Resources resources) {
        Object obj;
        if (!sDrawableCacheFieldFetched) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                sDrawableCacheField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e);
            }
            sDrawableCacheFieldFetched = true;
        }
        Field field = sDrawableCacheField;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e6) {
                Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e6);
                obj = null;
            }
        } else {
            obj = null;
        }
        if (obj == null) {
            return;
        }
        flushThemedResourcesCache(obj);
    }

    private static void flushNougats(Resources resources) {
        Object obj;
        if (!sResourcesImplFieldFetched) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                sResourcesImplField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e(TAG, "Could not retrieve Resources#mResourcesImpl field", e);
            }
            sResourcesImplFieldFetched = true;
        }
        Field field = sResourcesImplField;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e6) {
            Log.e(TAG, "Could not retrieve value from Resources#mResourcesImpl", e6);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!sDrawableCacheFieldFetched) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                sDrawableCacheField = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e7) {
                Log.e(TAG, "Could not retrieve ResourcesImpl#mDrawableCache field", e7);
            }
            sDrawableCacheFieldFetched = true;
        }
        Field field2 = sDrawableCacheField;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e8) {
                Log.e(TAG, "Could not retrieve value from ResourcesImpl#mDrawableCache", e8);
            }
        }
        if (obj2 != null) {
            flushThemedResourcesCache(obj2);
        }
    }

    private static void flushThemedResourcesCache(Object obj) {
        LongSparseArray longSparseArray;
        if (!sThemedResourceCacheClazzFetched) {
            try {
                sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e(TAG, "Could not find ThemedResourceCache class", e);
            }
            sThemedResourceCacheClazzFetched = true;
        }
        Class<?> cls = sThemedResourceCacheClazz;
        if (cls == null) {
            return;
        }
        if (!sThemedResourceCache_mUnthemedEntriesFieldFetched) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                sThemedResourceCache_mUnthemedEntriesField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e6) {
                Log.e(TAG, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e6);
            }
            sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
        }
        Field field = sThemedResourceCache_mUnthemedEntriesField;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e7) {
            Log.e(TAG, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e7);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            Api16Impl.clear(longSparseArray);
        }
    }
}
