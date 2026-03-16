package androidx.room;

import N1.m;
import P1.j;
import e2.C0429e;
import e2.C0430f;
import fr.sd.taada.helpers.LocaleHelper;
import io.ktor.utils.io.Z;
import io.ktor.utils.io.internal.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.o;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.v;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u001d\u001e\u001fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJQ\u0010\u0013\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042$\u0010\u0012\u001a \u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u00110\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J]\u0010\u001b\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00152\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u000b2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00102\u0018\u0010\u001a\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020\u00110\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Landroidx/room/AmbiguousColumnResolver;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "", "", "resultColumns", "mappings", "", "resolve", "([Ljava/lang/String;[[Ljava/lang/String;)[[I", "", "Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "content", "pattern", "Lkotlin/Function3;", "", "LN1/m;", "onHashMatch", "rabinKarpSearch", "(Ljava/util/List;[Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "T", "", "current", "depth", "Lkotlin/Function1;", "block", "dfs", "(Ljava/util/List;Ljava/util/List;ILkotlin/jvm/functions/Function1;)V", "Match", "ResultColumn", "Solution", "room-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Match;", "", "Le2/f;", "resultRange", "", "", "resultIndices", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Le2/f;Ljava/util/List;)V", "Le2/f;", "getResultRange", "()Le2/f;", "Ljava/util/List;", "getResultIndices", "()Ljava/util/List;", "room-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Match {
        private final List<Integer> resultIndices;
        private final C0430f resultRange;

        public Match(C0430f resultRange, List<Integer> resultIndices) {
            h.f(resultRange, "resultRange");
            h.f(resultIndices, "resultIndices");
            this.resultRange = resultRange;
            this.resultIndices = resultIndices;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        public final C0430f getResultRange() {
            return this.resultRange;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "", "name", "", "index", "", "(Ljava/lang/String;I)V", "getIndex", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "room-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ResultColumn {
        private final int index;
        private final String name;

        public ResultColumn(String name, int i) {
            h.f(name, "name");
            this.name = name;
            this.index = i;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn resultColumn, String str, int i, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = resultColumn.name;
            }
            if ((i3 & 2) != 0) {
                i = resultColumn.index;
            }
            return resultColumn.copy(str, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        public final ResultColumn copy(String name, int index) {
            h.f(name, "name");
            return new ResultColumn(name, index);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) other;
            return h.a(this.name, resultColumn.name) && this.index == resultColumn.index;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return Integer.hashCode(this.index) + (this.name.hashCode() * 31);
        }

        public String toString() {
            return "ResultColumn(name=" + this.name + ", index=" + this.index + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution;", "", "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "coverageOffset", "", "overlaps", "(Ljava/util/List;II)V", "getCoverageOffset", "()I", "getMatches", "()Ljava/util/List;", "getOverlaps", "compareTo", "other", "Companion", "room-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Solution implements Comparable<Solution> {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Solution NO_SOLUTION = new Solution(u.f3805a, Integer.MAX_VALUE, Integer.MAX_VALUE);
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution$Companion;", "", "()V", "NO_SOLUTION", "Landroidx/room/AmbiguousColumnResolver$Solution;", "getNO_SOLUTION", "()Landroidx/room/AmbiguousColumnResolver$Solution;", "build", "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "room-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.d dVar) {
                this();
            }

            public final Solution build(List<Match> matches) {
                h.f(matches, "matches");
                int i = 0;
                int size = 0;
                for (Match match : matches) {
                    size += ((match.getResultRange().b - match.getResultRange().f3132a) + 1) - match.getResultIndices().size();
                }
                Iterator<T> it = matches.iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                int i3 = ((Match) it.next()).getResultRange().f3132a;
                while (it.hasNext()) {
                    int i4 = ((Match) it.next()).getResultRange().f3132a;
                    if (i3 > i4) {
                        i3 = i4;
                    }
                }
                Iterator<T> it2 = matches.iterator();
                if (!it2.hasNext()) {
                    throw new NoSuchElementException();
                }
                int i5 = ((Match) it2.next()).getResultRange().b;
                while (it2.hasNext()) {
                    int i6 = ((Match) it2.next()).getResultRange().b;
                    if (i5 < i6) {
                        i5 = i6;
                    }
                }
                Iterable c0430f = new C0430f(i3, i5, 1);
                if (!(c0430f instanceof Collection) || !((Collection) c0430f).isEmpty()) {
                    C0429e it3 = c0430f.iterator();
                    int i7 = 0;
                    while (it3.c) {
                        int iNextInt = it3.nextInt();
                        Iterator<T> it4 = matches.iterator();
                        int i8 = 0;
                        while (true) {
                            if (!it4.hasNext()) {
                                break;
                            }
                            if (((Match) it4.next()).getResultRange().b(iNextInt)) {
                                i8++;
                            }
                            if (i8 > 1) {
                                i7++;
                                if (i7 < 0) {
                                    throw new ArithmeticException("Count overflow has happened.");
                                }
                            }
                        }
                    }
                    i = i7;
                }
                return new Solution(matches, size, i);
            }

            public final Solution getNO_SOLUTION() {
                return Solution.NO_SOLUTION;
            }

            private Companion() {
            }
        }

        public Solution(List<Match> matches, int i, int i3) {
            h.f(matches, "matches");
            this.matches = matches;
            this.coverageOffset = i;
            this.overlaps = i3;
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }

        @Override // java.lang.Comparable
        public int compareTo(Solution other) {
            h.f(other, "other");
            int iH = h.h(this.overlaps, other.overlaps);
            return iH != 0 ? iH : h.h(this.coverageOffset, other.coverageOffset);
        }
    }

    /* JADX INFO: renamed from: androidx.room.AmbiguousColumnResolver$resolve$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Landroidx/room/AmbiguousColumnResolver$Match;", LocaleHelper.LANGUAGE_ITALIAN, "LN1/m;", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass4 extends i implements Function1<List<? extends Match>, m> {
        final /* synthetic */ v $bestSolution;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(v vVar) {
            super(1);
            this.$bestSolution = vVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ m invoke(List<? extends Match> list) {
            invoke2((List<Match>) list);
            return m.f1129a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Match> it) {
            h.f(it, "it");
            Solution solutionBuild = Solution.INSTANCE.build(it);
            if (solutionBuild.compareTo((Solution) this.$bestSolution.f3817a) < 0) {
                this.$bestSolution.f3817a = solutionBuild;
            }
        }
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> content, List<T> current, int depth, Function1<? super List<? extends T>, m> block) {
        if (depth == content.size()) {
            block.invoke(kotlin.collections.m.o0(current));
            return;
        }
        Iterator<T> it = content.get(depth).iterator();
        while (it.hasNext()) {
            current.add(it.next());
            INSTANCE.dfs(content, current, depth + 1, block);
            s.I(current);
        }
    }

    public static /* synthetic */ void dfs$default(AmbiguousColumnResolver ambiguousColumnResolver, List list, List list2, int i, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((i3 & 4) != 0) {
            i = 0;
        }
        ambiguousColumnResolver.dfs(list, list2, i, function1);
    }

    private final void rabinKarpSearch(List<ResultColumn> content, String[] pattern, Function3<? super Integer, ? super Integer, ? super List<ResultColumn>, m> onHashMatch) {
        int i = 0;
        int iHashCode = 0;
        for (String str : pattern) {
            iHashCode += str.hashCode();
        }
        int length = pattern.length;
        Iterator<T> it = content.subList(0, length).iterator();
        int iHashCode2 = 0;
        while (it.hasNext()) {
            iHashCode2 += ((ResultColumn) it.next()).getName().hashCode();
        }
        while (true) {
            if (iHashCode == iHashCode2) {
                onHashMatch.invoke(Integer.valueOf(i), Integer.valueOf(length), content.subList(i, length));
            }
            int i3 = i + 1;
            int i4 = length + 1;
            if (i4 > content.size()) {
                return;
            }
            iHashCode2 = (iHashCode2 - content.get(i).getName().hashCode()) + content.get(length).getName().hashCode();
            i = i3;
            length = i4;
        }
    }

    @JvmStatic
    public static final int[][] resolve(String[] resultColumns, String[][] mappings) {
        h.f(resultColumns, "resultColumns");
        h.f(mappings, "mappings");
        int length = resultColumns.length;
        int i = 0;
        for (int i3 = 0; i3 < length; i3++) {
            String strSubstring = resultColumns[i3];
            if (strSubstring.charAt(0) == '`' && strSubstring.charAt(strSubstring.length() - 1) == '`') {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            Locale US = Locale.US;
            h.e(US, "US");
            String lowerCase = strSubstring.toLowerCase(US);
            h.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            resultColumns[i3] = lowerCase;
        }
        int length2 = mappings.length;
        for (int i4 = 0; i4 < length2; i4++) {
            int length3 = mappings[i4].length;
            for (int i5 = 0; i5 < length3; i5++) {
                String[] strArr = mappings[i4];
                String str = strArr[i5];
                Locale US2 = Locale.US;
                h.e(US2, "US");
                String lowerCase2 = str.toLowerCase(US2);
                h.e(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                strArr[i5] = lowerCase2;
            }
        }
        j jVar = new j();
        for (String[] strArr2 : mappings) {
            s.G(jVar, strArr2);
        }
        t.b(jVar);
        P1.b bVar = new P1.b();
        int length4 = resultColumns.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length4) {
            String str2 = resultColumns[i6];
            int i8 = i7 + 1;
            if (jVar.f1215a.containsKey(str2)) {
                bVar.add(new ResultColumn(str2, i7));
            }
            i6++;
            i7 = i8;
        }
        Z.b(bVar);
        int length5 = mappings.length;
        ArrayList arrayList = new ArrayList(length5);
        for (int i9 = 0; i9 < length5; i9++) {
            arrayList.add(new ArrayList());
        }
        int length6 = mappings.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length6) {
            String[] strArr3 = mappings[i10];
            int i12 = i11 + 1;
            INSTANCE.rabinKarpSearch(bVar, strArr3, new AmbiguousColumnResolver$resolve$1$1(strArr3, arrayList, i11));
            if (((List) arrayList.get(i11)).isEmpty()) {
                ArrayList arrayList2 = new ArrayList(strArr3.length);
                int length7 = strArr3.length;
                for (int i13 = i; i13 < length7; i13++) {
                    String str3 = strArr3[i13];
                    P1.b bVar2 = new P1.b();
                    Iterator it = bVar.iterator();
                    while (true) {
                        P1.a aVar = (P1.a) it;
                        if (!aVar.hasNext()) {
                            break;
                        }
                        ResultColumn resultColumn = (ResultColumn) aVar.next();
                        if (h.a(str3, resultColumn.getName())) {
                            bVar2.add(Integer.valueOf(resultColumn.getIndex()));
                        }
                    }
                    Z.b(bVar2);
                    if (bVar2.isEmpty()) {
                        throw new IllegalStateException(androidx.constraintlayout.core.motion.a.q("Column ", str3, " not found in result").toString());
                    }
                    arrayList2.add(bVar2);
                }
                dfs$default(INSTANCE, arrayList2, null, 0, new AmbiguousColumnResolver$resolve$1$2(arrayList, i11), 6, null);
            }
            i10++;
            i11 = i12;
            i = 0;
        }
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (((List) it2.next()).isEmpty()) {
                    throw new IllegalStateException("Failed to find matches for all mappings");
                }
            }
        }
        v vVar = new v();
        vVar.f3817a = Solution.INSTANCE.getNO_SOLUTION();
        dfs$default(INSTANCE, arrayList, null, 0, new AnonymousClass4(vVar), 6, null);
        List<Match> matches = ((Solution) vVar.f3817a).getMatches();
        ArrayList arrayList3 = new ArrayList(o.D(matches));
        Iterator<T> it3 = matches.iterator();
        while (it3.hasNext()) {
            arrayList3.add(kotlin.collections.m.n0(((Match) it3.next()).getResultIndices()));
        }
        return (int[][]) arrayList3.toArray(new int[0][]);
    }
}
