package androidx.work.impl.model;

import D0.b;
import E1.k;
import androidx.arch.core.util.Function;
import androidx.constraintlayout.core.motion.a;
import androidx.core.location.LocationRequestCompat;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.OverwritingInputMerger;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.o;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\bD\b\u0087\b\u0018\u0000 j2\u00020\u0001:\u0003jklBé\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b\u0012\b\b\u0002\u0010 \u001a\u00020\u0011\u0012\b\b\u0002\u0010!\u001a\u00020\u0011¢\u0006\u0004\b\"\u0010#B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010%B\u0019\b\u0016\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0000¢\u0006\u0004\b\"\u0010(J\u0015\u0010*\u001a\u00020)2\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020)2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b,\u0010+J\u001d\u0010,\u001a\u00020)2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u000b¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\u0019¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0002H\u0016¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b4\u00103J\u0010\u00105\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b7\u00103J\u0010\u00108\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b8\u00103J\u0010\u00109\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b9\u0010:J\u0010\u0010;\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b;\u0010:J\u0010\u0010<\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b<\u0010/J\u0010\u0010=\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b=\u0010/J\u0010\u0010>\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b>\u0010/J\u0010\u0010?\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b?\u0010@J\u0010\u0010A\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\bA\u0010BJ\u0010\u0010C\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\bC\u0010DJ\u0010\u0010E\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\bE\u0010/J\u0010\u0010F\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\bF\u0010/J\u0010\u0010G\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\bG\u0010/J\u0010\u0010H\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\bH\u0010/J\u0010\u0010I\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\bI\u00101J\u0010\u0010J\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\bJ\u0010KJ\u0010\u0010L\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\bL\u0010BJ\u0010\u0010M\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\bM\u0010BJ\u0010\u0010N\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\bN\u0010/J\u0010\u0010O\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\bO\u0010BJ\u0010\u0010P\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\bP\u0010BJö\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0003\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\bQ\u0010RJ\u0010\u0010S\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\bS\u0010BJ\u001a\u0010T\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bT\u0010UR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010VR\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010WR\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010VR\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010VR\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010XR\u0016\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010XR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010YR\u0016\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010YR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010YR\u0016\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010ZR\u0016\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010[R\u0016\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\\R\u0016\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010YR\u0016\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010YR\u0016\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010YR\u0016\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010YR\u0016\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010]R\u0016\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010^R\"\u0010\u001d\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010[\u001a\u0004\b_\u0010B\"\u0004\b`\u0010aR\u001a\u0010\u001e\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010[\u001a\u0004\bb\u0010BR\"\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010Y\u001a\u0004\bc\u0010/\"\u0004\bd\u0010+R\"\u0010 \u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010[\u001a\u0004\be\u0010B\"\u0004\bf\u0010aR\u001a\u0010!\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010[\u001a\u0004\bg\u0010BR\u0011\u0010h\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\bh\u00101R\u0011\u0010i\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\bi\u00101¨\u0006m"}, d2 = {"Landroidx/work/impl/model/WorkSpec;", "", "", "id", "Landroidx/work/WorkInfo$State;", "state", "workerClassName", "inputMergerClassName", "Landroidx/work/Data;", "input", "output", "", "initialDelay", "intervalDuration", "flexDuration", "Landroidx/work/Constraints;", "constraints", "", "runAttemptCount", "Landroidx/work/BackoffPolicy;", "backoffPolicy", "backoffDelayDuration", "lastEnqueueTime", "minimumRetentionDuration", "scheduleRequestedAt", "", "expedited", "Landroidx/work/OutOfQuotaPolicy;", "outOfQuotaPolicy", "periodCount", "generation", "nextScheduleTimeOverride", "nextScheduleTimeOverrideGeneration", "stopReason", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Ljava/lang/String;Ljava/lang/String;Landroidx/work/Data;Landroidx/work/Data;JJJLandroidx/work/Constraints;ILandroidx/work/BackoffPolicy;JJJJZLandroidx/work/OutOfQuotaPolicy;IIJII)V", "workerClassName_", "(Ljava/lang/String;Ljava/lang/String;)V", "newId", "other", "(Ljava/lang/String;Landroidx/work/impl/model/WorkSpec;)V", "LN1/m;", "setBackoffDelayDuration", "(J)V", "setPeriodic", "(JJ)V", "calculateNextRunTime", "()J", "hasConstraints", "()Z", "toString", "()Ljava/lang/String;", "component1", "component2", "()Landroidx/work/WorkInfo$State;", "component3", "component4", "component5", "()Landroidx/work/Data;", "component6", "component7", "component8", "component9", "component10", "()Landroidx/work/Constraints;", "component11", "()I", "component12", "()Landroidx/work/BackoffPolicy;", "component13", "component14", "component15", "component16", "component17", "component18", "()Landroidx/work/OutOfQuotaPolicy;", "component19", "component20", "component21", "component22", "component23", "copy", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Ljava/lang/String;Ljava/lang/String;Landroidx/work/Data;Landroidx/work/Data;JJJLandroidx/work/Constraints;ILandroidx/work/BackoffPolicy;JJJJZLandroidx/work/OutOfQuotaPolicy;IIJII)Landroidx/work/impl/model/WorkSpec;", "hashCode", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "Landroidx/work/WorkInfo$State;", "Landroidx/work/Data;", "J", "Landroidx/work/Constraints;", "I", "Landroidx/work/BackoffPolicy;", "Z", "Landroidx/work/OutOfQuotaPolicy;", "getPeriodCount", "setPeriodCount", "(I)V", "getGeneration", "getNextScheduleTimeOverride", "setNextScheduleTimeOverride", "getNextScheduleTimeOverrideGeneration", "setNextScheduleTimeOverrideGeneration", "getStopReason", "isPeriodic", "isBackedOff", "Companion", "IdAndState", "WorkInfoPojo", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WorkSpec {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;
    private static final String TAG;
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER;
    public long backoffDelayDuration;
    public BackoffPolicy backoffPolicy;
    public Constraints constraints;
    public boolean expedited;
    public long flexDuration;
    private final int generation;
    public final String id;
    public long initialDelay;
    public Data input;
    public String inputMergerClassName;
    public long intervalDuration;
    public long lastEnqueueTime;
    public long minimumRetentionDuration;
    private long nextScheduleTimeOverride;
    private int nextScheduleTimeOverrideGeneration;
    public OutOfQuotaPolicy outOfQuotaPolicy;
    public Data output;
    private int periodCount;
    public int runAttemptCount;
    public long scheduleRequestedAt;
    public WorkInfo.State state;
    private final int stopReason;
    public String workerClassName;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J^\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/work/impl/model/WorkSpec$Companion;", "", "()V", "SCHEDULE_NOT_REQUESTED_YET", "", "TAG", "", "WORK_INFO_MAPPER", "Landroidx/arch/core/util/Function;", "", "Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "Landroidx/work/WorkInfo;", "calculateNextRunTime", "isBackedOff", "", "runAttemptCount", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "backoffDelayDuration", "lastEnqueueTime", "periodCount", "isPeriodic", "initialDelay", "flexDuration", "intervalDuration", "nextScheduleTimeOverride", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        public final long calculateNextRunTime(boolean isBackedOff, int runAttemptCount, BackoffPolicy backoffPolicy, long backoffDelayDuration, long lastEnqueueTime, int periodCount, boolean isPeriodic, long initialDelay, long flexDuration, long intervalDuration, long nextScheduleTimeOverride) {
            h.f(backoffPolicy, "backoffPolicy");
            if (nextScheduleTimeOverride != LocationRequestCompat.PASSIVE_INTERVAL && isPeriodic) {
                if (periodCount != 0) {
                    long j6 = lastEnqueueTime + PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
                    if (nextScheduleTimeOverride < j6) {
                        return j6;
                    }
                }
                return nextScheduleTimeOverride;
            }
            if (isBackedOff) {
                long jScalb = backoffPolicy == BackoffPolicy.LINEAR ? backoffDelayDuration * ((long) runAttemptCount) : (long) Math.scalb(backoffDelayDuration, runAttemptCount - 1);
                if (jScalb > WorkRequest.MAX_BACKOFF_MILLIS) {
                    jScalb = 18000000;
                }
                return lastEnqueueTime + jScalb;
            }
            if (!isPeriodic) {
                return lastEnqueueTime == -1 ? LocationRequestCompat.PASSIVE_INTERVAL : lastEnqueueTime + initialDelay;
            }
            long j7 = periodCount == 0 ? lastEnqueueTime + initialDelay : lastEnqueueTime + intervalDuration;
            return (flexDuration == intervalDuration || periodCount != 0) ? j7 : (intervalDuration - flexDuration) + j7;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/work/impl/model/WorkSpec$IdAndState;", "", "id", "", "state", "Landroidx/work/WorkInfo$State;", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class IdAndState {
        public String id;
        public WorkInfo.State state;

        public IdAndState(String id, WorkInfo.State state) {
            h.f(id, "id");
            h.f(state, "state");
            this.id = id;
            this.state = state;
        }

        public static /* synthetic */ IdAndState copy$default(IdAndState idAndState, String str, WorkInfo.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                str = idAndState.id;
            }
            if ((i & 2) != 0) {
                state = idAndState.state;
            }
            return idAndState.copy(str, state);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final WorkInfo.State getState() {
            return this.state;
        }

        public final IdAndState copy(String id, WorkInfo.State state) {
            h.f(id, "id");
            h.f(state, "state");
            return new IdAndState(id, state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) other;
            return h.a(this.id, idAndState.id) && this.state == idAndState.state;
        }

        public int hashCode() {
            return this.state.hashCode() + (this.id.hashCode() * 31);
        }

        public String toString() {
            return "IdAndState(id=" + this.id + ", state=" + this.state + ')';
        }
    }

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("WorkSpec");
        h.e(strTagWithPrefix, "tagWithPrefix(\"WorkSpec\")");
        TAG = strTagWithPrefix;
        WORK_INFO_MAPPER = new b(17);
    }

    public WorkSpec(String id, WorkInfo.State state, String workerClassName, String inputMergerClassName, Data input, Data output, long j6, long j7, long j8, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j9, long j10, long j11, long j12, boolean z6, OutOfQuotaPolicy outOfQuotaPolicy, int i3, int i4, long j13, int i5, int i6) {
        h.f(id, "id");
        h.f(state, "state");
        h.f(workerClassName, "workerClassName");
        h.f(inputMergerClassName, "inputMergerClassName");
        h.f(input, "input");
        h.f(output, "output");
        h.f(constraints, "constraints");
        h.f(backoffPolicy, "backoffPolicy");
        h.f(outOfQuotaPolicy, "outOfQuotaPolicy");
        this.id = id;
        this.state = state;
        this.workerClassName = workerClassName;
        this.inputMergerClassName = inputMergerClassName;
        this.input = input;
        this.output = output;
        this.initialDelay = j6;
        this.intervalDuration = j7;
        this.flexDuration = j8;
        this.constraints = constraints;
        this.runAttemptCount = i;
        this.backoffPolicy = backoffPolicy;
        this.backoffDelayDuration = j9;
        this.lastEnqueueTime = j10;
        this.minimumRetentionDuration = j11;
        this.scheduleRequestedAt = j12;
        this.expedited = z6;
        this.outOfQuotaPolicy = outOfQuotaPolicy;
        this.periodCount = i3;
        this.generation = i4;
        this.nextScheduleTimeOverride = j13;
        this.nextScheduleTimeOverrideGeneration = i5;
        this.stopReason = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List WORK_INFO_MAPPER$lambda$1(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(o.D(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((WorkInfoPojo) it.next()).toWorkInfo());
        }
        return arrayList;
    }

    public static /* synthetic */ WorkSpec copy$default(WorkSpec workSpec, String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j6, long j7, long j8, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j9, long j10, long j11, long j12, boolean z6, OutOfQuotaPolicy outOfQuotaPolicy, int i3, int i4, long j13, int i5, int i6, int i7, Object obj) {
        String str4 = (i7 & 1) != 0 ? workSpec.id : str;
        WorkInfo.State state2 = (i7 & 2) != 0 ? workSpec.state : state;
        String str5 = (i7 & 4) != 0 ? workSpec.workerClassName : str2;
        String str6 = (i7 & 8) != 0 ? workSpec.inputMergerClassName : str3;
        Data data3 = (i7 & 16) != 0 ? workSpec.input : data;
        Data data4 = (i7 & 32) != 0 ? workSpec.output : data2;
        long j14 = (i7 & 64) != 0 ? workSpec.initialDelay : j6;
        long j15 = (i7 & 128) != 0 ? workSpec.intervalDuration : j7;
        long j16 = (i7 & 256) != 0 ? workSpec.flexDuration : j8;
        Constraints constraints2 = (i7 & 512) != 0 ? workSpec.constraints : constraints;
        int i8 = (i7 & 1024) != 0 ? workSpec.runAttemptCount : i;
        String str7 = str4;
        BackoffPolicy backoffPolicy2 = (i7 & 2048) != 0 ? workSpec.backoffPolicy : backoffPolicy;
        WorkInfo.State state3 = state2;
        long j17 = (i7 & 4096) != 0 ? workSpec.backoffDelayDuration : j9;
        long j18 = (i7 & 8192) != 0 ? workSpec.lastEnqueueTime : j10;
        long j19 = (i7 & 16384) != 0 ? workSpec.minimumRetentionDuration : j11;
        long j20 = (i7 & 32768) != 0 ? workSpec.scheduleRequestedAt : j12;
        return workSpec.copy(str7, state3, str5, str6, data3, data4, j14, j15, j16, constraints2, i8, backoffPolicy2, j17, j18, j19, j20, (i7 & 65536) != 0 ? workSpec.expedited : z6, (i7 & 131072) != 0 ? workSpec.outOfQuotaPolicy : outOfQuotaPolicy, (i7 & 262144) != 0 ? workSpec.periodCount : i3, (i7 & 524288) != 0 ? workSpec.generation : i4, (i7 & 1048576) != 0 ? workSpec.nextScheduleTimeOverride : j13, (i7 & 2097152) != 0 ? workSpec.nextScheduleTimeOverrideGeneration : i5, (i7 & 4194304) != 0 ? workSpec.stopReason : i6);
    }

    public final long calculateNextRunTime() {
        return INSTANCE.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Constraints getConstraints() {
        return this.constraints;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getRunAttemptCount() {
        return this.runAttemptCount;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final BackoffPolicy getBackoffPolicy() {
        return this.backoffPolicy;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getBackoffDelayDuration() {
        return this.backoffDelayDuration;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final long getLastEnqueueTime() {
        return this.lastEnqueueTime;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final long getMinimumRetentionDuration() {
        return this.minimumRetentionDuration;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final long getScheduleRequestedAt() {
        return this.scheduleRequestedAt;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getExpedited() {
        return this.expedited;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final OutOfQuotaPolicy getOutOfQuotaPolicy() {
        return this.outOfQuotaPolicy;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final int getPeriodCount() {
        return this.periodCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WorkInfo.State getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final int getGeneration() {
        return this.generation;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final long getNextScheduleTimeOverride() {
        return this.nextScheduleTimeOverride;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getNextScheduleTimeOverrideGeneration() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final int getStopReason() {
        return this.stopReason;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getWorkerClassName() {
        return this.workerClassName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getInputMergerClassName() {
        return this.inputMergerClassName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Data getInput() {
        return this.input;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Data getOutput() {
        return this.output;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getInitialDelay() {
        return this.initialDelay;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getIntervalDuration() {
        return this.intervalDuration;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getFlexDuration() {
        return this.flexDuration;
    }

    public final WorkSpec copy(String id, WorkInfo.State state, String workerClassName, String inputMergerClassName, Data input, Data output, long initialDelay, long intervalDuration, long flexDuration, Constraints constraints, int runAttemptCount, BackoffPolicy backoffPolicy, long backoffDelayDuration, long lastEnqueueTime, long minimumRetentionDuration, long scheduleRequestedAt, boolean expedited, OutOfQuotaPolicy outOfQuotaPolicy, int periodCount, int generation, long nextScheduleTimeOverride, int nextScheduleTimeOverrideGeneration, int stopReason) {
        h.f(id, "id");
        h.f(state, "state");
        h.f(workerClassName, "workerClassName");
        h.f(inputMergerClassName, "inputMergerClassName");
        h.f(input, "input");
        h.f(output, "output");
        h.f(constraints, "constraints");
        h.f(backoffPolicy, "backoffPolicy");
        h.f(outOfQuotaPolicy, "outOfQuotaPolicy");
        return new WorkSpec(id, state, workerClassName, inputMergerClassName, input, output, initialDelay, intervalDuration, flexDuration, constraints, runAttemptCount, backoffPolicy, backoffDelayDuration, lastEnqueueTime, minimumRetentionDuration, scheduleRequestedAt, expedited, outOfQuotaPolicy, periodCount, generation, nextScheduleTimeOverride, nextScheduleTimeOverrideGeneration, stopReason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) other;
        return h.a(this.id, workSpec.id) && this.state == workSpec.state && h.a(this.workerClassName, workSpec.workerClassName) && h.a(this.inputMergerClassName, workSpec.inputMergerClassName) && h.a(this.input, workSpec.input) && h.a(this.output, workSpec.output) && this.initialDelay == workSpec.initialDelay && this.intervalDuration == workSpec.intervalDuration && this.flexDuration == workSpec.flexDuration && h.a(this.constraints, workSpec.constraints) && this.runAttemptCount == workSpec.runAttemptCount && this.backoffPolicy == workSpec.backoffPolicy && this.backoffDelayDuration == workSpec.backoffDelayDuration && this.lastEnqueueTime == workSpec.lastEnqueueTime && this.minimumRetentionDuration == workSpec.minimumRetentionDuration && this.scheduleRequestedAt == workSpec.scheduleRequestedAt && this.expedited == workSpec.expedited && this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy && this.periodCount == workSpec.periodCount && this.generation == workSpec.generation && this.nextScheduleTimeOverride == workSpec.nextScheduleTimeOverride && this.nextScheduleTimeOverrideGeneration == workSpec.nextScheduleTimeOverrideGeneration && this.stopReason == workSpec.stopReason;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final long getNextScheduleTimeOverride() {
        return this.nextScheduleTimeOverride;
    }

    public final int getNextScheduleTimeOverrideGeneration() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final int getStopReason() {
        return this.stopReason;
    }

    public final boolean hasConstraints() {
        return !h.a(Constraints.NONE, this.constraints);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    public int hashCode() {
        int iHashCode = (Long.hashCode(this.scheduleRequestedAt) + ((Long.hashCode(this.minimumRetentionDuration) + ((Long.hashCode(this.lastEnqueueTime) + ((Long.hashCode(this.backoffDelayDuration) + ((this.backoffPolicy.hashCode() + ((Integer.hashCode(this.runAttemptCount) + ((this.constraints.hashCode() + ((Long.hashCode(this.flexDuration) + ((Long.hashCode(this.intervalDuration) + ((Long.hashCode(this.initialDelay) + ((this.output.hashCode() + ((this.input.hashCode() + a.c(a.c((this.state.hashCode() + (this.id.hashCode() * 31)) * 31, 31, this.workerClassName), 31, this.inputMergerClassName)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z6 = this.expedited;
        ?? r22 = z6;
        if (z6) {
            r22 = 1;
        }
        return Integer.hashCode(this.stopReason) + ((Integer.hashCode(this.nextScheduleTimeOverrideGeneration) + ((Long.hashCode(this.nextScheduleTimeOverride) + ((Integer.hashCode(this.generation) + ((Integer.hashCode(this.periodCount) + ((this.outOfQuotaPolicy.hashCode() + ((iHashCode + r22) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final boolean isBackedOff() {
        return this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
    }

    public final boolean isPeriodic() {
        return this.intervalDuration != 0;
    }

    public final void setBackoffDelayDuration(long backoffDelayDuration) {
        if (backoffDelayDuration > WorkRequest.MAX_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value");
        }
        if (backoffDelayDuration < WorkRequest.MIN_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration less than minimum value");
        }
        this.backoffDelayDuration = k.k(backoffDelayDuration, WorkRequest.MIN_BACKOFF_MILLIS, WorkRequest.MAX_BACKOFF_MILLIS);
    }

    public final void setNextScheduleTimeOverride(long j6) {
        this.nextScheduleTimeOverride = j6;
    }

    public final void setNextScheduleTimeOverrideGeneration(int i) {
        this.nextScheduleTimeOverrideGeneration = i;
    }

    public final void setPeriodCount(int i) {
        this.periodCount = i;
    }

    public final void setPeriodic(long intervalDuration) {
        if (intervalDuration < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        long j6 = intervalDuration < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS ? 900000L : intervalDuration;
        if (intervalDuration < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            intervalDuration = 900000;
        }
        setPeriodic(j6, intervalDuration);
    }

    public String toString() {
        return a.s(new StringBuilder("{WorkSpec: "), this.id, '}');
    }

    public final void setPeriodic(long intervalDuration, long flexDuration) {
        long j6 = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
        if (intervalDuration < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        if (intervalDuration >= PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            j6 = intervalDuration;
        }
        this.intervalDuration = j6;
        if (flexDuration < PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            Logger.get().warning(TAG, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (flexDuration > this.intervalDuration) {
            Logger.get().warning(TAG, "Flex duration greater than interval duration; Changed to " + intervalDuration);
        }
        this.flexDuration = k.k(flexDuration, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS, this.intervalDuration);
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B§\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019¢\u0006\u0002\u0010\u001bJ\b\u0010@\u001a\u00020\tH\u0002J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\tHÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\t\u0010D\u001a\u00020\u000fHÆ\u0003J\t\u0010E\u001a\u00020\u000fHÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\t\u0010G\u001a\u00020\u000fHÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019HÆ\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\t\u0010L\u001a\u00020\tHÆ\u0003J\t\u0010M\u001a\u00020\tHÆ\u0003J\t\u0010N\u001a\u00020\tHÆ\u0003J\t\u0010O\u001a\u00020\rHÆ\u0003J\t\u0010P\u001a\u00020\u000fHÆ\u0003J\t\u0010Q\u001a\u00020\u0011HÆ\u0003J¿\u0001\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019HÆ\u0001J\u0013\u0010S\u001a\u00020.2\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010U\u001a\u0004\u0018\u00010VH\u0002J\t\u0010W\u001a\u00020\u000fHÖ\u0001J\t\u0010X\u001a\u00020\u0003HÖ\u0001J\u0006\u0010Y\u001a\u00020ZR\u001e\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0016\u0010\u0015\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b-\u0010/R\u0011\u00100\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b0\u0010/R\u001e\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR\u0016\u0010\u0016\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001dR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001e\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010(\"\u0004\b7\u00108R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010(R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0016\u0010\u0017\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010(R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010:¨\u0006["}, d2 = {"Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "", "id", "", "state", "Landroidx/work/WorkInfo$State;", "output", "Landroidx/work/Data;", "initialDelay", "", "intervalDuration", "flexDuration", "constraints", "Landroidx/work/Constraints;", "runAttemptCount", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "backoffDelayDuration", "lastEnqueueTime", "periodCount", "generation", "nextScheduleTimeOverride", "stopReason", "tags", "", "progress", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Landroidx/work/Data;JJJLandroidx/work/Constraints;ILandroidx/work/BackoffPolicy;JJIIJILjava/util/List;Ljava/util/List;)V", "getBackoffDelayDuration", "()J", "setBackoffDelayDuration", "(J)V", "getBackoffPolicy", "()Landroidx/work/BackoffPolicy;", "setBackoffPolicy", "(Landroidx/work/BackoffPolicy;)V", "getConstraints", "()Landroidx/work/Constraints;", "getFlexDuration", "getGeneration", "()I", "getId", "()Ljava/lang/String;", "getInitialDelay", "getIntervalDuration", "isBackedOff", "", "()Z", "isPeriodic", "getLastEnqueueTime", "setLastEnqueueTime", "getNextScheduleTimeOverride", "getOutput", "()Landroidx/work/Data;", "getPeriodCount", "setPeriodCount", "(I)V", "getProgress", "()Ljava/util/List;", "getRunAttemptCount", "getState", "()Landroidx/work/WorkInfo$State;", "getStopReason", "getTags", "calculateNextRunTimeMillis", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getPeriodicityOrNull", "Landroidx/work/WorkInfo$PeriodicityInfo;", "hashCode", "toString", "toWorkInfo", "Landroidx/work/WorkInfo;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class WorkInfoPojo {
        private long backoffDelayDuration;
        private BackoffPolicy backoffPolicy;
        private final Constraints constraints;
        private final long flexDuration;
        private final int generation;
        private final String id;
        private final long initialDelay;
        private final long intervalDuration;
        private long lastEnqueueTime;
        private final long nextScheduleTimeOverride;
        private final Data output;
        private int periodCount;
        private final List<Data> progress;
        private final int runAttemptCount;
        private final WorkInfo.State state;
        private final int stopReason;
        private final List<String> tags;

        public WorkInfoPojo(String id, WorkInfo.State state, Data output, long j6, long j7, long j8, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j9, long j10, int i3, int i4, long j11, int i5, List<String> tags, List<Data> progress) {
            h.f(id, "id");
            h.f(state, "state");
            h.f(output, "output");
            h.f(constraints, "constraints");
            h.f(backoffPolicy, "backoffPolicy");
            h.f(tags, "tags");
            h.f(progress, "progress");
            this.id = id;
            this.state = state;
            this.output = output;
            this.initialDelay = j6;
            this.intervalDuration = j7;
            this.flexDuration = j8;
            this.constraints = constraints;
            this.runAttemptCount = i;
            this.backoffPolicy = backoffPolicy;
            this.backoffDelayDuration = j9;
            this.lastEnqueueTime = j10;
            this.periodCount = i3;
            this.generation = i4;
            this.nextScheduleTimeOverride = j11;
            this.stopReason = i5;
            this.tags = tags;
            this.progress = progress;
        }

        private final long calculateNextRunTimeMillis() {
            return this.state == WorkInfo.State.ENQUEUED ? WorkSpec.INSTANCE.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride) : LocationRequestCompat.PASSIVE_INTERVAL;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WorkInfoPojo copy$default(WorkInfoPojo workInfoPojo, String str, WorkInfo.State state, Data data, long j6, long j7, long j8, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j9, long j10, int i3, int i4, long j11, int i5, List list, List list2, int i6, Object obj) {
            String str2 = (i6 & 1) != 0 ? workInfoPojo.id : str;
            WorkInfo.State state2 = (i6 & 2) != 0 ? workInfoPojo.state : state;
            return workInfoPojo.copy(str2, state2, (i6 & 4) != 0 ? workInfoPojo.output : data, (i6 & 8) != 0 ? workInfoPojo.initialDelay : j6, (i6 & 16) != 0 ? workInfoPojo.intervalDuration : j7, (i6 & 32) != 0 ? workInfoPojo.flexDuration : j8, (i6 & 64) != 0 ? workInfoPojo.constraints : constraints, (i6 & 128) != 0 ? workInfoPojo.runAttemptCount : i, (i6 & 256) != 0 ? workInfoPojo.backoffPolicy : backoffPolicy, (i6 & 512) != 0 ? workInfoPojo.backoffDelayDuration : j9, (i6 & 1024) != 0 ? workInfoPojo.lastEnqueueTime : j10, (i6 & 2048) != 0 ? workInfoPojo.periodCount : i3, (i6 & 4096) != 0 ? workInfoPojo.generation : i4, (i6 & 8192) != 0 ? workInfoPojo.nextScheduleTimeOverride : j11, (i6 & 16384) != 0 ? workInfoPojo.stopReason : i5, (32768 & i6) != 0 ? workInfoPojo.tags : list, (i6 & 65536) != 0 ? workInfoPojo.progress : list2);
        }

        private final WorkInfo.PeriodicityInfo getPeriodicityOrNull() {
            long j6 = this.intervalDuration;
            if (j6 != 0) {
                return new WorkInfo.PeriodicityInfo(j6, this.flexDuration);
            }
            return null;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final long getBackoffDelayDuration() {
            return this.backoffDelayDuration;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final long getLastEnqueueTime() {
            return this.lastEnqueueTime;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final int getPeriodCount() {
            return this.periodCount;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final int getGeneration() {
            return this.generation;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final long getNextScheduleTimeOverride() {
            return this.nextScheduleTimeOverride;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final int getStopReason() {
            return this.stopReason;
        }

        public final List<String> component16() {
            return this.tags;
        }

        public final List<Data> component17() {
            return this.progress;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final WorkInfo.State getState() {
            return this.state;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Data getOutput() {
            return this.output;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getInitialDelay() {
            return this.initialDelay;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getIntervalDuration() {
            return this.intervalDuration;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getFlexDuration() {
            return this.flexDuration;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Constraints getConstraints() {
            return this.constraints;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getRunAttemptCount() {
            return this.runAttemptCount;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final BackoffPolicy getBackoffPolicy() {
            return this.backoffPolicy;
        }

        public final WorkInfoPojo copy(String id, WorkInfo.State state, Data output, long initialDelay, long intervalDuration, long flexDuration, Constraints constraints, int runAttemptCount, BackoffPolicy backoffPolicy, long backoffDelayDuration, long lastEnqueueTime, int periodCount, int generation, long nextScheduleTimeOverride, int stopReason, List<String> tags, List<Data> progress) {
            h.f(id, "id");
            h.f(state, "state");
            h.f(output, "output");
            h.f(constraints, "constraints");
            h.f(backoffPolicy, "backoffPolicy");
            h.f(tags, "tags");
            h.f(progress, "progress");
            return new WorkInfoPojo(id, state, output, initialDelay, intervalDuration, flexDuration, constraints, runAttemptCount, backoffPolicy, backoffDelayDuration, lastEnqueueTime, periodCount, generation, nextScheduleTimeOverride, stopReason, tags, progress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) other;
            return h.a(this.id, workInfoPojo.id) && this.state == workInfoPojo.state && h.a(this.output, workInfoPojo.output) && this.initialDelay == workInfoPojo.initialDelay && this.intervalDuration == workInfoPojo.intervalDuration && this.flexDuration == workInfoPojo.flexDuration && h.a(this.constraints, workInfoPojo.constraints) && this.runAttemptCount == workInfoPojo.runAttemptCount && this.backoffPolicy == workInfoPojo.backoffPolicy && this.backoffDelayDuration == workInfoPojo.backoffDelayDuration && this.lastEnqueueTime == workInfoPojo.lastEnqueueTime && this.periodCount == workInfoPojo.periodCount && this.generation == workInfoPojo.generation && this.nextScheduleTimeOverride == workInfoPojo.nextScheduleTimeOverride && this.stopReason == workInfoPojo.stopReason && h.a(this.tags, workInfoPojo.tags) && h.a(this.progress, workInfoPojo.progress);
        }

        public final long getBackoffDelayDuration() {
            return this.backoffDelayDuration;
        }

        public final BackoffPolicy getBackoffPolicy() {
            return this.backoffPolicy;
        }

        public final Constraints getConstraints() {
            return this.constraints;
        }

        public final long getFlexDuration() {
            return this.flexDuration;
        }

        public final int getGeneration() {
            return this.generation;
        }

        public final String getId() {
            return this.id;
        }

        public final long getInitialDelay() {
            return this.initialDelay;
        }

        public final long getIntervalDuration() {
            return this.intervalDuration;
        }

        public final long getLastEnqueueTime() {
            return this.lastEnqueueTime;
        }

        public final long getNextScheduleTimeOverride() {
            return this.nextScheduleTimeOverride;
        }

        public final Data getOutput() {
            return this.output;
        }

        public final int getPeriodCount() {
            return this.periodCount;
        }

        public final List<Data> getProgress() {
            return this.progress;
        }

        public final int getRunAttemptCount() {
            return this.runAttemptCount;
        }

        public final WorkInfo.State getState() {
            return this.state;
        }

        public final int getStopReason() {
            return this.stopReason;
        }

        public final List<String> getTags() {
            return this.tags;
        }

        public int hashCode() {
            return this.progress.hashCode() + a.d(this.tags, (Integer.hashCode(this.stopReason) + ((Long.hashCode(this.nextScheduleTimeOverride) + ((Integer.hashCode(this.generation) + ((Integer.hashCode(this.periodCount) + ((Long.hashCode(this.lastEnqueueTime) + ((Long.hashCode(this.backoffDelayDuration) + ((this.backoffPolicy.hashCode() + ((Integer.hashCode(this.runAttemptCount) + ((this.constraints.hashCode() + ((Long.hashCode(this.flexDuration) + ((Long.hashCode(this.intervalDuration) + ((Long.hashCode(this.initialDelay) + ((this.output.hashCode() + ((this.state.hashCode() + (this.id.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31, 31);
        }

        public final boolean isBackedOff() {
            return this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
        }

        public final boolean isPeriodic() {
            return this.intervalDuration != 0;
        }

        public final void setBackoffDelayDuration(long j6) {
            this.backoffDelayDuration = j6;
        }

        public final void setBackoffPolicy(BackoffPolicy backoffPolicy) {
            h.f(backoffPolicy, "<set-?>");
            this.backoffPolicy = backoffPolicy;
        }

        public final void setLastEnqueueTime(long j6) {
            this.lastEnqueueTime = j6;
        }

        public final void setPeriodCount(int i) {
            this.periodCount = i;
        }

        public String toString() {
            return "WorkInfoPojo(id=" + this.id + ", state=" + this.state + ", output=" + this.output + ", initialDelay=" + this.initialDelay + ", intervalDuration=" + this.intervalDuration + ", flexDuration=" + this.flexDuration + ", constraints=" + this.constraints + ", runAttemptCount=" + this.runAttemptCount + ", backoffPolicy=" + this.backoffPolicy + ", backoffDelayDuration=" + this.backoffDelayDuration + ", lastEnqueueTime=" + this.lastEnqueueTime + ", periodCount=" + this.periodCount + ", generation=" + this.generation + ", nextScheduleTimeOverride=" + this.nextScheduleTimeOverride + ", stopReason=" + this.stopReason + ", tags=" + this.tags + ", progress=" + this.progress + ')';
        }

        public final WorkInfo toWorkInfo() {
            Data progress = !this.progress.isEmpty() ? this.progress.get(0) : Data.EMPTY;
            UUID uuidFromString = UUID.fromString(this.id);
            h.e(uuidFromString, "fromString(id)");
            WorkInfo.State state = this.state;
            HashSet hashSet = new HashSet(this.tags);
            Data data = this.output;
            h.e(progress, "progress");
            return new WorkInfo(uuidFromString, state, hashSet, data, progress, this.runAttemptCount, this.generation, this.constraints, this.initialDelay, getPeriodicityOrNull(), calculateNextRunTimeMillis(), this.stopReason);
        }

        public /* synthetic */ WorkInfoPojo(String str, WorkInfo.State state, Data data, long j6, long j7, long j8, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j9, long j10, int i3, int i4, long j11, int i5, List list, List list2, int i6, d dVar) {
            this(str, state, data, (i6 & 8) != 0 ? 0L : j6, (i6 & 16) != 0 ? 0L : j7, (i6 & 32) != 0 ? 0L : j8, constraints, i, (i6 & 256) != 0 ? BackoffPolicy.EXPONENTIAL : backoffPolicy, (i6 & 512) != 0 ? 30000L : j9, (i6 & 1024) != 0 ? 0L : j10, (i6 & 2048) != 0 ? 0 : i3, i4, j11, i5, list, list2);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WorkSpec(String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j6, long j7, long j8, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j9, long j10, long j11, long j12, boolean z6, OutOfQuotaPolicy outOfQuotaPolicy, int i3, int i4, long j13, int i5, int i6, int i7, d dVar) {
        Data data3;
        Data data4;
        WorkInfo.State state2 = (i7 & 2) != 0 ? WorkInfo.State.ENQUEUED : state;
        String name = (i7 & 8) != 0 ? OverwritingInputMerger.class.getName() : str3;
        if ((i7 & 16) != 0) {
            Data EMPTY = Data.EMPTY;
            h.e(EMPTY, "EMPTY");
            data3 = EMPTY;
        } else {
            data3 = data;
        }
        if ((i7 & 32) != 0) {
            Data EMPTY2 = Data.EMPTY;
            h.e(EMPTY2, "EMPTY");
            data4 = EMPTY2;
        } else {
            data4 = data2;
        }
        this(str, state2, str2, name, data3, data4, (i7 & 64) != 0 ? 0L : j6, (i7 & 128) != 0 ? 0L : j7, (i7 & 256) != 0 ? 0L : j8, (i7 & 512) != 0 ? Constraints.NONE : constraints, (i7 & 1024) != 0 ? 0 : i, (i7 & 2048) != 0 ? BackoffPolicy.EXPONENTIAL : backoffPolicy, (i7 & 4096) != 0 ? WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS : j9, (i7 & 8192) != 0 ? -1L : j10, (i7 & 16384) == 0 ? j11 : 0L, (32768 & i7) != 0 ? -1L : j12, (65536 & i7) != 0 ? false : z6, (131072 & i7) != 0 ? OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST : outOfQuotaPolicy, (262144 & i7) != 0 ? 0 : i3, (524288 & i7) != 0 ? 0 : i4, (1048576 & i7) != 0 ? Long.MAX_VALUE : j13, (2097152 & i7) != 0 ? 0 : i5, (i7 & 4194304) != 0 ? -256 : i6);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(String id, String workerClassName_) {
        this(id, null, workerClassName_, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, 8388602, null);
        h.f(id, "id");
        h.f(workerClassName_, "workerClassName_");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(String newId, WorkSpec other) {
        this(newId, other.state, other.workerClassName, other.inputMergerClassName, new Data(other.input), new Data(other.output), other.initialDelay, other.intervalDuration, other.flexDuration, new Constraints(other.constraints), other.runAttemptCount, other.backoffPolicy, other.backoffDelayDuration, other.lastEnqueueTime, other.minimumRetentionDuration, other.scheduleRequestedAt, other.expedited, other.outOfQuotaPolicy, other.periodCount, 0, other.nextScheduleTimeOverride, other.nextScheduleTimeOverrideGeneration, other.stopReason, 524288, null);
        h.f(newId, "newId");
        h.f(other, "other");
    }
}
