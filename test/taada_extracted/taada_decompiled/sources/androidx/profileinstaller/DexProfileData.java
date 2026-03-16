package androidx.profileinstaller;

import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
class DexProfileData {
    final String apkName;
    int classSetSize;
    int[] classes;
    final long dexChecksum;
    final String dexName;
    final int hotMethodRegionSize;
    long mTypeIdCount;
    final TreeMap<Integer, Integer> methods;
    final int numMethodIds;

    public DexProfileData(String str, String str2, long j6, long j7, int i, int i3, int i4, int[] iArr, TreeMap<Integer, Integer> treeMap) {
        this.apkName = str;
        this.dexName = str2;
        this.dexChecksum = j6;
        this.mTypeIdCount = j7;
        this.classSetSize = i;
        this.hotMethodRegionSize = i3;
        this.numMethodIds = i4;
        this.classes = iArr;
        this.methods = treeMap;
    }
}
