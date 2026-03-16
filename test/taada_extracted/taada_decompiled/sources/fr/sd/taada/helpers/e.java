package fr.sd.taada.helpers;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Comparator;
import org.mockito.internal.util.reflection.SuperTypesLastSorter;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3278a;

    public /* synthetic */ e(int i) {
        this.f3278a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f3278a) {
            case 0:
                return LogManager.lambda$getLogFiles$10((File) obj, (File) obj2);
            case 1:
                return LogManager.lambda$cleanupOldLogFiles$8((File) obj, (File) obj2);
            default:
                return SuperTypesLastSorter.lambda$static$0((Field) obj, (Field) obj2);
        }
    }
}
