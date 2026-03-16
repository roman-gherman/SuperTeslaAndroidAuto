package fr.sd.taada.analytics.telemetry;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Database(entities = {TelemetryEvent.class}, exportSchema = false, version = 1)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lfr/sd/taada/analytics/telemetry/TelemetryDatabase;", "Landroidx/room/RoomDatabase;", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "telemetryDao", "Lfr/sd/taada/analytics/telemetry/TelemetryDao;", "Companion", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class TelemetryDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DATABASE_NAME = "taada_telemetry.db";

    @Nullable
    private static volatile TelemetryDatabase instance;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lfr/sd/taada/analytics/telemetry/TelemetryDatabase$Companion;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "DATABASE_NAME", "", "instance", "Lfr/sd/taada/analytics/telemetry/TelemetryDatabase;", "getInstance", "context", "Landroid/content/Context;", "buildDatabase", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nTelemetryDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelemetryDatabase.kt\nfr/sd/taada/analytics/telemetry/TelemetryDatabase$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,43:1\n1#2:44\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        private final TelemetryDatabase buildDatabase(Context context) {
            Context applicationContext = context.getApplicationContext();
            h.e(applicationContext, "getApplicationContext(...)");
            return (TelemetryDatabase) Room.databaseBuilder(applicationContext, TelemetryDatabase.class, TelemetryDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build();
        }

        @NotNull
        public final TelemetryDatabase getInstance(@NotNull Context context) {
            TelemetryDatabase telemetryDatabaseBuildDatabase;
            h.f(context, "context");
            TelemetryDatabase telemetryDatabase = TelemetryDatabase.instance;
            if (telemetryDatabase != null) {
                return telemetryDatabase;
            }
            synchronized (this) {
                telemetryDatabaseBuildDatabase = TelemetryDatabase.instance;
                if (telemetryDatabaseBuildDatabase == null) {
                    telemetryDatabaseBuildDatabase = TelemetryDatabase.INSTANCE.buildDatabase(context);
                    TelemetryDatabase.instance = telemetryDatabaseBuildDatabase;
                }
            }
            return telemetryDatabaseBuildDatabase;
        }

        private Companion() {
        }
    }

    @NotNull
    public abstract TelemetryDao telemetryDao();
}
