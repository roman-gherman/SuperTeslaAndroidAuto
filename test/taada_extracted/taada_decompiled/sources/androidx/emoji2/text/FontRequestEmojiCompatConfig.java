package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    private static final FontProviderHelper DEFAULT_FONTS_CONTRACT = new FontProviderHelper();

    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {
        private long mRetryOrigin;
        private final long mTotalMs;

        public ExponentialBackoffRetryPolicy(long j6) {
            this.mTotalMs = j6;
        }

        @Override // androidx.emoji2.text.FontRequestEmojiCompatConfig.RetryPolicy
        public long getRetryDelay() {
            if (this.mRetryOrigin == 0) {
                this.mRetryOrigin = SystemClock.uptimeMillis();
                return 0L;
            }
            long jUptimeMillis = SystemClock.uptimeMillis() - this.mRetryOrigin;
            if (jUptimeMillis > this.mTotalMs) {
                return -1L;
            }
            return Math.min(Math.max(jUptimeMillis, 1000L), this.mTotalMs - jUptimeMillis);
        }
    }

    public static class FontProviderHelper {
        public Typeface buildTypeface(Context context, FontsContractCompat.FontInfo fontInfo) {
            return FontsContractCompat.buildTypeface(context, null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        public FontsContractCompat.FontFamilyResult fetchFonts(Context context, FontRequest fontRequest) {
            return FontsContractCompat.fetchFonts(context, null, fontRequest);
        }

        public void registerObserver(Context context, Uri uri, ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void unregisterObserver(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    public static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        private static final String S_TRACE_BUILD_TYPEFACE = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface";
        EmojiCompat.MetadataRepoLoaderCallback mCallback;
        private final Context mContext;
        private Executor mExecutor;
        private final FontProviderHelper mFontProviderHelper;
        private final Object mLock = new Object();
        private Handler mMainHandler;
        private Runnable mMainHandlerLoadCallback;
        private ThreadPoolExecutor mMyThreadPoolExecutor;
        private ContentObserver mObserver;
        private final FontRequest mRequest;
        private RetryPolicy mRetryPolicy;

        public FontRequestMetadataLoader(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
            Preconditions.checkNotNull(context, "Context cannot be null");
            Preconditions.checkNotNull(fontRequest, "FontRequest cannot be null");
            this.mContext = context.getApplicationContext();
            this.mRequest = fontRequest;
            this.mFontProviderHelper = fontProviderHelper;
        }

        private void cleanUp() {
            synchronized (this.mLock) {
                try {
                    this.mCallback = null;
                    ContentObserver contentObserver = this.mObserver;
                    if (contentObserver != null) {
                        this.mFontProviderHelper.unregisterObserver(this.mContext, contentObserver);
                        this.mObserver = null;
                    }
                    Handler handler = this.mMainHandler;
                    if (handler != null) {
                        handler.removeCallbacks(this.mMainHandlerLoadCallback);
                    }
                    this.mMainHandler = null;
                    ThreadPoolExecutor threadPoolExecutor = this.mMyThreadPoolExecutor;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.mExecutor = null;
                    this.mMyThreadPoolExecutor = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private FontsContractCompat.FontInfo retrieveFontInfo() {
            try {
                FontsContractCompat.FontFamilyResult fontFamilyResultFetchFonts = this.mFontProviderHelper.fetchFonts(this.mContext, this.mRequest);
                if (fontFamilyResultFetchFonts.getStatusCode() != 0) {
                    throw new RuntimeException("fetchFonts failed (" + fontFamilyResultFetchFonts.getStatusCode() + ")");
                }
                FontsContractCompat.FontInfo[] fonts = fontFamilyResultFetchFonts.getFonts();
                if (fonts == null || fonts.length == 0) {
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                return fonts[0];
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }

        private void scheduleRetry(Uri uri, long j6) {
            synchronized (this.mLock) {
                try {
                    Handler handlerMainHandlerAsync = this.mMainHandler;
                    if (handlerMainHandlerAsync == null) {
                        handlerMainHandlerAsync = ConcurrencyHelpers.mainHandlerAsync();
                        this.mMainHandler = handlerMainHandlerAsync;
                    }
                    if (this.mObserver == null) {
                        ContentObserver contentObserver = new ContentObserver(handlerMainHandlerAsync) { // from class: androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.1
                            @Override // android.database.ContentObserver
                            public void onChange(boolean z6, Uri uri2) {
                                FontRequestMetadataLoader.this.loadInternal();
                            }
                        };
                        this.mObserver = contentObserver;
                        this.mFontProviderHelper.registerObserver(this.mContext, uri, contentObserver);
                    }
                    if (this.mMainHandlerLoadCallback == null) {
                        this.mMainHandlerLoadCallback = new d(this, 1);
                    }
                    handlerMainHandlerAsync.postDelayed(this.mMainHandlerLoadCallback, j6);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void createMetadata() {
            synchronized (this.mLock) {
                try {
                    if (this.mCallback == null) {
                        return;
                    }
                    try {
                        FontsContractCompat.FontInfo fontInfoRetrieveFontInfo = retrieveFontInfo();
                        int resultCode = fontInfoRetrieveFontInfo.getResultCode();
                        if (resultCode == 2) {
                            synchronized (this.mLock) {
                                try {
                                    RetryPolicy retryPolicy = this.mRetryPolicy;
                                    if (retryPolicy != null) {
                                        long retryDelay = retryPolicy.getRetryDelay();
                                        if (retryDelay >= 0) {
                                            scheduleRetry(fontInfoRetrieveFontInfo.getUri(), retryDelay);
                                            return;
                                        }
                                    }
                                } finally {
                                }
                            }
                        }
                        if (resultCode != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + resultCode + ")");
                        }
                        try {
                            TraceCompat.beginSection(S_TRACE_BUILD_TYPEFACE);
                            Typeface typefaceBuildTypeface = this.mFontProviderHelper.buildTypeface(this.mContext, fontInfoRetrieveFontInfo);
                            ByteBuffer byteBufferMmap = TypefaceCompatUtil.mmap(this.mContext, null, fontInfoRetrieveFontInfo.getUri());
                            if (byteBufferMmap == null || typefaceBuildTypeface == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            MetadataRepo metadataRepoCreate = MetadataRepo.create(typefaceBuildTypeface, byteBufferMmap);
                            TraceCompat.endSection();
                            synchronized (this.mLock) {
                                try {
                                    EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback = this.mCallback;
                                    if (metadataRepoLoaderCallback != null) {
                                        metadataRepoLoaderCallback.onLoaded(metadataRepoCreate);
                                    }
                                } finally {
                                }
                            }
                            cleanUp();
                        } catch (Throwable th) {
                            TraceCompat.endSection();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        synchronized (this.mLock) {
                            try {
                                EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback2 = this.mCallback;
                                if (metadataRepoLoaderCallback2 != null) {
                                    metadataRepoLoaderCallback2.onFailed(th2);
                                }
                                cleanUp();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.checkNotNull(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.mLock) {
                this.mCallback = metadataRepoLoaderCallback;
            }
            loadInternal();
        }

        public void loadInternal() {
            synchronized (this.mLock) {
                try {
                    if (this.mCallback == null) {
                        return;
                    }
                    if (this.mExecutor == null) {
                        ThreadPoolExecutor threadPoolExecutorCreateBackgroundPriorityExecutor = ConcurrencyHelpers.createBackgroundPriorityExecutor("emojiCompat");
                        this.mMyThreadPoolExecutor = threadPoolExecutorCreateBackgroundPriorityExecutor;
                        this.mExecutor = threadPoolExecutorCreateBackgroundPriorityExecutor;
                    }
                    this.mExecutor.execute(new d(this, 0));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void setExecutor(Executor executor) {
            synchronized (this.mLock) {
                this.mExecutor = executor;
            }
        }

        public void setRetryPolicy(RetryPolicy retryPolicy) {
            synchronized (this.mLock) {
                this.mRetryPolicy = retryPolicy;
            }
        }
    }

    public static abstract class RetryPolicy {
        public abstract long getRetryDelay();
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, DEFAULT_FONTS_CONTRACT));
    }

    @Deprecated
    public FontRequestEmojiCompatConfig setHandler(Handler handler) {
        if (handler == null) {
            return this;
        }
        setLoadingExecutor(ConcurrencyHelpers.convertHandlerToExecutor(handler));
        return this;
    }

    public FontRequestEmojiCompatConfig setLoadingExecutor(Executor executor) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setExecutor(executor);
        return this;
    }

    public FontRequestEmojiCompatConfig setRetryPolicy(RetryPolicy retryPolicy) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setRetryPolicy(retryPolicy);
        return this;
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
        super(new FontRequestMetadataLoader(context, fontRequest, fontProviderHelper));
    }
}
