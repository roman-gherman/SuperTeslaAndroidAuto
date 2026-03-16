package fr.sd.taada.helpers;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3278a;

    public /* synthetic */ d(int i) {
        this.f3278a = i;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f3278a) {
            case 0:
                return LogManager.lambda$clearAllLogs$11(file, str);
            case 1:
                return LogManager.lambda$getLogFiles$9(file, str);
            default:
                return LogManager.lambda$cleanupOldLogFiles$7(file, str);
        }
    }
}
