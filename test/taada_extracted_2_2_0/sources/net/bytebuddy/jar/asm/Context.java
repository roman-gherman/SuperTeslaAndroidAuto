package net.bytebuddy.jar.asm;

/* JADX INFO: loaded from: classes2.dex */
final class Context {
    Attribute[] attributePrototypes;
    char[] charBuffer;
    int currentFrameLocalCount;
    int currentFrameLocalCountDelta;
    Object[] currentFrameLocalTypes;
    int currentFrameOffset;
    int currentFrameStackCount;
    Object[] currentFrameStackTypes;
    int currentFrameType;
    Label[] currentLocalVariableAnnotationRangeEnds;
    int[] currentLocalVariableAnnotationRangeIndices;
    Label[] currentLocalVariableAnnotationRangeStarts;
    int currentMethodAccessFlags;
    String currentMethodDescriptor;
    Label[] currentMethodLabels;
    String currentMethodName;
    int currentTypeAnnotationTarget;
    TypePath currentTypeAnnotationTargetPath;
    int parsingOptions;
}
