package kotlin.io.path;

import a2.EnumC0135a;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.8")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/io/path/CopyActionContext;", "", "Ljava/nio/file/Path;", "target", "", "followLinks", "La2/a;", "copyToIgnoringExistingDirectory", "(Ljava/nio/file/Path;Ljava/nio/file/Path;Z)La2/a;", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalPathApi
public interface CopyActionContext {
    @NotNull
    EnumC0135a copyToIgnoringExistingDirectory(@NotNull Path path, @NotNull Path path2, boolean z6);
}
