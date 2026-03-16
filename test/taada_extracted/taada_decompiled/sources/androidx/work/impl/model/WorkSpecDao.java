package androidx.work.impl.model;

import android.view.LiveData;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u001b\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH'¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\u0014H'¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u001e\u0010\nJ\u001f\u0010!\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H'¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b'\u0010\u001dJ\u0017\u0010(\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b(\u0010\u001dJ\u001f\u0010*\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010)\u001a\u00020#H'¢\u0006\u0004\b*\u0010&J\u001f\u0010,\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0019H'¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u0004\u0018\u00010\u00172\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b.\u0010/J\u0019\u00101\u001a\u0004\u0018\u0001002\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b1\u00102J#\u00104\u001a\b\u0012\u0004\u0012\u0002000\u000e2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH'¢\u0006\u0004\b4\u00105J)\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000e0\u00142\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH'¢\u0006\u0004\b6\u00107J)\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000e082\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH'¢\u0006\u0004\b9\u0010:J\u001d\u0010<\u001a\b\u0012\u0004\u0012\u0002000\u000e2\u0006\u0010;\u001a\u00020\u0007H'¢\u0006\u0004\b<\u0010\u0011J#\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000e082\u0006\u0010;\u001a\u00020\u0007H'¢\u0006\u0004\b=\u0010>J#\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000e0\u00142\u0006\u0010;\u001a\u00020\u0007H'¢\u0006\u0004\b?\u0010@J\u001d\u0010A\u001a\b\u0012\u0004\u0012\u0002000\u000e2\u0006\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\bA\u0010\u0011J#\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000e0\u00142\u0006\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\bB\u0010@J#\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000e082\u0006\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\bC\u0010>J\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000e2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\bD\u0010\u0011J\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010;\u001a\u00020\u0007H'¢\u0006\u0004\bE\u0010\u0011J\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\bF\u0010\u0011J\u0015\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH'¢\u0006\u0004\bG\u0010\u0013J\u000f\u0010I\u001a\u00020HH'¢\u0006\u0004\bI\u0010JJ\u001f\u0010L\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010K\u001a\u00020#H'¢\u0006\u0004\bL\u0010MJ\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020#0\u00142\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\bN\u0010@J\u000f\u0010O\u001a\u00020\u0019H'¢\u0006\u0004\bO\u0010PJ\u001d\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010Q\u001a\u00020\u0019H'¢\u0006\u0004\bR\u0010SJ\u0015\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH'¢\u0006\u0004\bT\u0010\u0013J\u001d\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010U\u001a\u00020\u0019H'¢\u0006\u0004\bV\u0010SJ\u0015\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH'¢\u0006\u0004\bW\u0010\u0013J\u0015\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH'¢\u0006\u0004\bX\u0010\u0013J\u001d\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010Y\u001a\u00020#H'¢\u0006\u0004\bZ\u0010[J\u000f\u0010\\\u001a\u00020\u0004H'¢\u0006\u0004\b\\\u0010]J\u0017\u0010^\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b^\u0010\nJ\u0017\u0010_\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b_\u0010\u0006J\u000f\u0010`\u001a\u00020\u0019H'¢\u0006\u0004\b`\u0010PJ\u001f\u0010b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u0019H'¢\u0006\u0004\bb\u0010-ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006cÀ\u0006\u0001"}, d2 = {"Landroidx/work/impl/model/WorkSpecDao;", "", "Landroidx/work/impl/model/WorkSpec;", "workSpec", "LN1/m;", "insertWorkSpec", "(Landroidx/work/impl/model/WorkSpec;)V", "", "id", "delete", "(Ljava/lang/String;)V", "getWorkSpec", "(Ljava/lang/String;)Landroidx/work/impl/model/WorkSpec;", "name", "", "Landroidx/work/impl/model/WorkSpec$IdAndState;", "getWorkSpecIdAndStatesForName", "(Ljava/lang/String;)Ljava/util/List;", "getAllWorkSpecIds", "()Ljava/util/List;", "Landroidx/lifecycle/LiveData;", "getAllWorkSpecIdsLiveData", "()Landroidx/lifecycle/LiveData;", "Landroidx/work/WorkInfo$State;", "state", "", "setState", "(Landroidx/work/WorkInfo$State;Ljava/lang/String;)I", "setCancelledState", "(Ljava/lang/String;)I", "incrementPeriodCount", "Landroidx/work/Data;", "output", "setOutput", "(Ljava/lang/String;Landroidx/work/Data;)V", "", "enqueueTime", "setLastEnqueueTime", "(Ljava/lang/String;J)V", "incrementWorkSpecRunAttemptCount", "resetWorkSpecRunAttemptCount", "nextScheduleTimeOverrideMillis", "setNextScheduleTimeOverride", "overrideGeneration", "resetWorkSpecNextScheduleTimeOverride", "(Ljava/lang/String;I)V", "getState", "(Ljava/lang/String;)Landroidx/work/WorkInfo$State;", "Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "getWorkStatusPojoForId", "(Ljava/lang/String;)Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "ids", "getWorkStatusPojoForIds", "(Ljava/util/List;)Ljava/util/List;", "getWorkStatusPojoLiveDataForIds", "(Ljava/util/List;)Landroidx/lifecycle/LiveData;", "Lkotlinx/coroutines/flow/Flow;", "getWorkStatusPojoFlowDataForIds", "(Ljava/util/List;)Lkotlinx/coroutines/flow/Flow;", "tag", "getWorkStatusPojoForTag", "getWorkStatusPojoFlowForTag", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "getWorkStatusPojoLiveDataForTag", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "getWorkStatusPojoForName", "getWorkStatusPojoLiveDataForName", "getWorkStatusPojoFlowForName", "getInputsFromPrerequisites", "getUnfinishedWorkWithTag", "getUnfinishedWorkWithName", "getAllUnfinishedWork", "", "hasUnfinishedWork", "()Z", "startTime", "markWorkSpecScheduled", "(Ljava/lang/String;J)I", "getScheduleRequestedAtLiveData", "resetScheduledState", "()I", "schedulerLimit", "getEligibleWorkForScheduling", "(I)Ljava/util/List;", "getEligibleWorkForSchedulingWithContentUris", "maxLimit", "getAllEligibleWorkSpecsForScheduling", "getScheduledWork", "getRunningWork", "startingAt", "getRecentlyCompletedWork", "(J)Ljava/util/List;", "pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast", "()V", "incrementGeneration", "updateWorkSpec", "countNonFinishedContentUriTriggerWorkers", "stopReason", "setStopReason", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface WorkSpecDao {
    int countNonFinishedContentUriTriggerWorkers();

    void delete(String id);

    List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int maxLimit);

    List<String> getAllUnfinishedWork();

    List<String> getAllWorkSpecIds();

    LiveData<List<String>> getAllWorkSpecIdsLiveData();

    List<WorkSpec> getEligibleWorkForScheduling(int schedulerLimit);

    List<WorkSpec> getEligibleWorkForSchedulingWithContentUris();

    List<Data> getInputsFromPrerequisites(String id);

    List<WorkSpec> getRecentlyCompletedWork(long startingAt);

    List<WorkSpec> getRunningWork();

    LiveData<Long> getScheduleRequestedAtLiveData(String id);

    List<WorkSpec> getScheduledWork();

    WorkInfo.State getState(String id);

    List<String> getUnfinishedWorkWithName(String name);

    List<String> getUnfinishedWorkWithTag(String tag);

    WorkSpec getWorkSpec(String id);

    List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String name);

    Flow<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoFlowDataForIds(List<String> ids);

    Flow<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoFlowForName(String name);

    Flow<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoFlowForTag(String tag);

    WorkSpec.WorkInfoPojo getWorkStatusPojoForId(String id);

    List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> ids);

    List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String name);

    List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String tag);

    LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> ids);

    LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String name);

    LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String tag);

    boolean hasUnfinishedWork();

    void incrementGeneration(String id);

    void incrementPeriodCount(String id);

    int incrementWorkSpecRunAttemptCount(String id);

    void insertWorkSpec(WorkSpec workSpec);

    int markWorkSpecScheduled(String id, long startTime);

    void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();

    int resetScheduledState();

    void resetWorkSpecNextScheduleTimeOverride(String id, int overrideGeneration);

    int resetWorkSpecRunAttemptCount(String id);

    int setCancelledState(String id);

    void setLastEnqueueTime(String id, long enqueueTime);

    void setNextScheduleTimeOverride(String id, long nextScheduleTimeOverrideMillis);

    void setOutput(String id, Data output);

    int setState(WorkInfo.State state, String id);

    void setStopReason(String id, int stopReason);

    void updateWorkSpec(WorkSpec workSpec);
}
