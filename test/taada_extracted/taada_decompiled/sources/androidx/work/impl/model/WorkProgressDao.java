package androidx.work.impl.model;

import androidx.work.Data;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H'¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/work/impl/model/WorkProgressDao;", "", "Landroidx/work/impl/model/WorkProgress;", "progress", "LN1/m;", "insert", "(Landroidx/work/impl/model/WorkProgress;)V", "", "workSpecId", "delete", "(Ljava/lang/String;)V", "deleteAll", "()V", "Landroidx/work/Data;", "getProgressForWorkSpecId", "(Ljava/lang/String;)Landroidx/work/Data;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface WorkProgressDao {
    void delete(String workSpecId);

    void deleteAll();

    Data getProgressForWorkSpecId(String workSpecId);

    void insert(WorkProgress progress);
}
