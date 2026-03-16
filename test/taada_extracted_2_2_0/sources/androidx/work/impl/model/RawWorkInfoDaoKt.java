package androidx.work.impl.model;

import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.flow.Flow;
import m3.AbstractC0684s;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/work/impl/model/RawWorkInfoDao;", "Lm3/s;", "dispatcher", "Landroidx/sqlite/db/SupportSQLiteQuery;", "query", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/work/WorkInfo;", "getWorkInfoPojosFlow", "(Landroidx/work/impl/model/RawWorkInfoDao;Lm3/s;Landroidx/sqlite/db/SupportSQLiteQuery;)Lkotlinx/coroutines/flow/Flow;", "work-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RawWorkInfoDaoKt {
    public static final Flow<List<WorkInfo>> getWorkInfoPojosFlow(RawWorkInfoDao rawWorkInfoDao, AbstractC0684s dispatcher, SupportSQLiteQuery query) {
        h.f(rawWorkInfoDao, "<this>");
        h.f(dispatcher, "dispatcher");
        h.f(query, "query");
        return WorkSpecDaoKt.dedup(rawWorkInfoDao.getWorkInfoPojosFlow(query), dispatcher);
    }
}
