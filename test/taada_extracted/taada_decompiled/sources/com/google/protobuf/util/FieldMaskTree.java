package com.google.protobuf.util;

import B2.b;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.protobuf.Descriptors;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Message;
import com.google.protobuf.util.FieldMaskUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
final class FieldMaskTree {
    private static final String FIELD_PATH_SEPARATOR_REGEX = "\\.";
    private static final Logger logger = Logger.getLogger(FieldMaskTree.class.getName());
    private final Node root = new Node();

    public static final class Node {
        final SortedMap<String, Node> children;

        private Node() {
            this.children = new TreeMap();
        }
    }

    public FieldMaskTree() {
    }

    private void getFieldPaths(Node node, String str, List<String> list) {
        String string;
        if (node.children.isEmpty()) {
            list.add(str);
            return;
        }
        for (Map.Entry<String, Node> entry : node.children.entrySet()) {
            if (str.isEmpty()) {
                string = entry.getKey();
            } else {
                StringBuilder sbL = b.l(str, ".");
                sbL.append(entry.getKey());
                string = sbL.toString();
            }
            getFieldPaths(entry.getValue(), string, list);
        }
    }

    @CanIgnoreReturnValue
    public FieldMaskTree addFieldPath(String str) {
        String[] strArrSplit = str.split(FIELD_PATH_SEPARATOR_REGEX);
        if (strArrSplit.length != 0) {
            Node node = this.root;
            boolean z6 = false;
            for (String str2 : strArrSplit) {
                if (z6 || node == this.root || !node.children.isEmpty()) {
                    if (node.children.containsKey(str2)) {
                        node = node.children.get(str2);
                    } else {
                        Node node2 = new Node();
                        node.children.put(str2, node2);
                        z6 = true;
                        node = node2;
                    }
                }
            }
            node.children.clear();
            return this;
        }
        return this;
    }

    public void intersectFieldPath(String str, FieldMaskTree fieldMaskTree) {
        if (this.root.children.isEmpty()) {
            return;
        }
        String[] strArrSplit = str.split(FIELD_PATH_SEPARATOR_REGEX);
        if (strArrSplit.length == 0) {
            return;
        }
        Node node = this.root;
        for (String str2 : strArrSplit) {
            if (node != this.root && node.children.isEmpty()) {
                fieldMaskTree.addFieldPath(str);
                return;
            } else {
                if (!node.children.containsKey(str2)) {
                    return;
                }
                node = node.children.get(str2);
            }
        }
        ArrayList arrayList = new ArrayList();
        getFieldPaths(node, str, arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            fieldMaskTree.addFieldPath((String) it.next());
        }
    }

    public void merge(Message message, Message.Builder builder, FieldMaskUtil.MergeOptions mergeOptions) {
        if (message.getDescriptorForType() != builder.getDescriptorForType()) {
            throw new IllegalArgumentException("Cannot merge messages of different types.");
        }
        if (this.root.children.isEmpty()) {
            return;
        }
        merge(this.root, "", message, builder, mergeOptions);
    }

    @CanIgnoreReturnValue
    public FieldMaskTree mergeFromFieldMask(FieldMask fieldMask) {
        Iterator<String> it = fieldMask.getPathsList().iterator();
        while (it.hasNext()) {
            addFieldPath(it.next());
        }
        return this;
    }

    public FieldMask toFieldMask() {
        if (this.root.children.isEmpty()) {
            return FieldMask.getDefaultInstance();
        }
        ArrayList arrayList = new ArrayList();
        getFieldPaths(this.root, "", arrayList);
        return FieldMask.newBuilder().addAllPaths(arrayList).build();
    }

    public String toString() {
        return FieldMaskUtil.toString(toFieldMask());
    }

    public FieldMaskTree(FieldMask fieldMask) {
        mergeFromFieldMask(fieldMask);
    }

    private void merge(Node node, String str, Message message, Message.Builder builder, FieldMaskUtil.MergeOptions mergeOptions) {
        FieldMaskUtil.MergeOptions mergeOptions2;
        String string;
        if (message.getDescriptorForType() == builder.getDescriptorForType()) {
            Descriptors.Descriptor descriptorForType = message.getDescriptorForType();
            for (Map.Entry<String, Node> entry : node.children.entrySet()) {
                Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = descriptorForType.findFieldByName(entry.getKey());
                if (fieldDescriptorFindFieldByName == null) {
                    logger.warning("Cannot find field \"" + entry.getKey() + "\" in message type " + descriptorForType.getFullName());
                } else {
                    if (!entry.getValue().children.isEmpty()) {
                        if (!fieldDescriptorFindFieldByName.isRepeated() && fieldDescriptorFindFieldByName.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                            if (message.hasField(fieldDescriptorFindFieldByName) || builder.hasField(fieldDescriptorFindFieldByName)) {
                                if (str.isEmpty()) {
                                    string = entry.getKey();
                                } else {
                                    StringBuilder sbL = b.l(str, ".");
                                    sbL.append(entry.getKey());
                                    string = sbL.toString();
                                }
                                String str2 = string;
                                Message.Builder builder2 = ((Message) builder.getField(fieldDescriptorFindFieldByName)).toBuilder();
                                mergeOptions2 = mergeOptions;
                                merge(entry.getValue(), str2, (Message) message.getField(fieldDescriptorFindFieldByName), builder2, mergeOptions2);
                                builder.setField(fieldDescriptorFindFieldByName, builder2.buildPartial());
                            }
                        } else {
                            mergeOptions2 = mergeOptions;
                            logger.warning("Field \"" + fieldDescriptorFindFieldByName.getFullName() + "\" is not a singular message field and cannot have sub-fields.");
                        }
                    } else {
                        mergeOptions2 = mergeOptions;
                        if (fieldDescriptorFindFieldByName.isRepeated()) {
                            if (mergeOptions2.replaceRepeatedFields()) {
                                builder.setField(fieldDescriptorFindFieldByName, message.getField(fieldDescriptorFindFieldByName));
                            } else {
                                Iterator it = ((List) message.getField(fieldDescriptorFindFieldByName)).iterator();
                                while (it.hasNext()) {
                                    builder.addRepeatedField(fieldDescriptorFindFieldByName, it.next());
                                }
                            }
                        } else if (fieldDescriptorFindFieldByName.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                            if (mergeOptions2.replaceMessageFields()) {
                                if (!message.hasField(fieldDescriptorFindFieldByName)) {
                                    builder.clearField(fieldDescriptorFindFieldByName);
                                } else {
                                    builder.setField(fieldDescriptorFindFieldByName, message.getField(fieldDescriptorFindFieldByName));
                                }
                            } else if (message.hasField(fieldDescriptorFindFieldByName)) {
                                builder.setField(fieldDescriptorFindFieldByName, ((Message) builder.getField(fieldDescriptorFindFieldByName)).toBuilder().mergeFrom((Message) message.getField(fieldDescriptorFindFieldByName)).build());
                            }
                        } else if (!message.hasField(fieldDescriptorFindFieldByName) && mergeOptions2.replacePrimitiveFields()) {
                            builder.clearField(fieldDescriptorFindFieldByName);
                        } else {
                            builder.setField(fieldDescriptorFindFieldByName, message.getField(fieldDescriptorFindFieldByName));
                        }
                    }
                    mergeOptions = mergeOptions2;
                }
            }
            return;
        }
        throw new IllegalArgumentException("source (" + message.getDescriptorForType() + ") and destination (" + builder.getDescriptorForType() + ") descriptor must be equal");
    }
}
