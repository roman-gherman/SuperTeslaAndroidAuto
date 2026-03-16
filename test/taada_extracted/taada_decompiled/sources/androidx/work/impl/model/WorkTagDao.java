package androidx.work.impl.model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u000b\u001a\u00020\u0007H'¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u000f\u0010\u000eJ%\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/work/impl/model/WorkTagDao;", "", "Landroidx/work/impl/model/WorkTag;", "workTag", "LN1/m;", "insert", "(Landroidx/work/impl/model/WorkTag;)V", "", "id", "deleteByWorkSpecId", "(Ljava/lang/String;)V", "tag", "", "getWorkSpecIdsWithTag", "(Ljava/lang/String;)Ljava/util/List;", "getTagsForWorkSpecId", "", "tags", "insertTags", "(Ljava/lang/String;Ljava/util/Set;)V", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface WorkTagDao {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void insertTags(WorkTagDao workTagDao, String id, Set<String> tags) {
            h.f(id, "id");
            h.f(tags, "tags");
            WorkTagDao.super.insertTags(id, tags);
        }
    }

    void deleteByWorkSpecId(String id);

    List<String> getTagsForWorkSpecId(String id);

    List<String> getWorkSpecIdsWithTag(String tag);

    void insert(WorkTag workTag);

    default void insertTags(String id, Set<String> tags) {
        h.f(id, "id");
        h.f(tags, "tags");
        Iterator<T> it = tags.iterator();
        while (it.hasNext()) {
            insert(new WorkTag((String) it.next(), id));
        }
    }
}
