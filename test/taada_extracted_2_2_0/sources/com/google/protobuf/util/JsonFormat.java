package com.google.protobuf.util;

import B2.b;
import E1.k;
import androidx.constraintlayout.core.motion.a;
import androidx.core.location.LocationRequestCompat;
import com.google.common.io.c;
import com.google.common.io.e;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.u;
import com.google.gson.v;
import com.google.protobuf.Any;
import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.Duration;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.FieldMask;
import com.google.protobuf.FloatValue;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Int64Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.NullValue;
import com.google.protobuf.StringValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.protobuf.UInt32Value;
import com.google.protobuf.UInt64Value;
import com.google.protobuf.Value;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Logger;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes2.dex */
public class JsonFormat {
    private static final Logger logger = Logger.getLogger(JsonFormat.class.getName());

    /* JADX INFO: renamed from: com.google.protobuf.util.JsonFormat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    public static final class CompactTextGenerator implements TextGenerator {
        private final Appendable output;

        public /* synthetic */ CompactTextGenerator(Appendable appendable, AnonymousClass1 anonymousClass1) {
            this(appendable);
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void indent() {
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void outdent() {
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void print(CharSequence charSequence) throws IOException {
            this.output.append(charSequence);
        }

        private CompactTextGenerator(Appendable appendable) {
            this.output = appendable;
        }
    }

    public static class Parser {
        private static final int DEFAULT_RECURSION_LIMIT = 100;
        private final boolean ignoringUnknownFields;
        private final TypeRegistry oldRegistry;
        private final int recursionLimit;
        private final com.google.protobuf.TypeRegistry registry;

        public /* synthetic */ Parser(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, boolean z6, int i, AnonymousClass1 anonymousClass1) {
            this(typeRegistry, typeRegistry2, z6, i);
        }

        public Parser ignoringUnknownFields() {
            return new Parser(this.registry, this.oldRegistry, true, this.recursionLimit);
        }

        public void merge(String str, Message.Builder builder) throws InvalidProtocolBufferException {
            new ParserImpl(this.registry, this.oldRegistry, this.ignoringUnknownFields, this.recursionLimit).merge(str, builder);
        }

        public Parser usingRecursionLimit(int i) {
            return new Parser(this.registry, this.oldRegistry, this.ignoringUnknownFields, i);
        }

        public Parser usingTypeRegistry(TypeRegistry typeRegistry) {
            if (this.oldRegistry == TypeRegistry.getEmptyTypeRegistry() && this.registry == com.google.protobuf.TypeRegistry.getEmptyTypeRegistry()) {
                return new Parser(com.google.protobuf.TypeRegistry.getEmptyTypeRegistry(), typeRegistry, this.ignoringUnknownFields, this.recursionLimit);
            }
            throw new IllegalArgumentException("Only one registry is allowed.");
        }

        private Parser(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, boolean z6, int i) {
            this.registry = typeRegistry;
            this.oldRegistry = typeRegistry2;
            this.ignoringUnknownFields = z6;
            this.recursionLimit = i;
        }

        public void merge(Reader reader, Message.Builder builder) throws IOException {
            new ParserImpl(this.registry, this.oldRegistry, this.ignoringUnknownFields, this.recursionLimit).merge(reader, builder);
        }

        public Parser usingTypeRegistry(com.google.protobuf.TypeRegistry typeRegistry) {
            if (this.oldRegistry == TypeRegistry.getEmptyTypeRegistry() && this.registry == com.google.protobuf.TypeRegistry.getEmptyTypeRegistry()) {
                return new Parser(typeRegistry, this.oldRegistry, this.ignoringUnknownFields, this.recursionLimit);
            }
            throw new IllegalArgumentException("Only one registry is allowed.");
        }
    }

    public static final class PrettyTextGenerator implements TextGenerator {
        private boolean atStartOfLine;
        private final StringBuilder indent;
        private final Appendable output;

        public /* synthetic */ PrettyTextGenerator(Appendable appendable, AnonymousClass1 anonymousClass1) {
            this(appendable);
        }

        private void write(CharSequence charSequence) throws IOException {
            if (charSequence.length() == 0) {
                return;
            }
            if (this.atStartOfLine) {
                this.atStartOfLine = false;
                this.output.append(this.indent);
            }
            this.output.append(charSequence);
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void indent() {
            this.indent.append("  ");
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void outdent() {
            int length = this.indent.length();
            if (length < 2) {
                throw new IllegalArgumentException(" Outdent() without matching Indent().");
            }
            this.indent.delete(length - 2, length);
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void print(CharSequence charSequence) throws IOException {
            int length = charSequence.length();
            int i = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (charSequence.charAt(i3) == '\n') {
                    int i4 = i3 + 1;
                    write(charSequence.subSequence(i, i4));
                    this.atStartOfLine = true;
                    i = i4;
                }
            }
            write(charSequence.subSequence(i, length));
        }

        private PrettyTextGenerator(Appendable appendable) {
            this.indent = new StringBuilder();
            this.atStartOfLine = true;
            this.output = appendable;
        }
    }

    public static class Printer {
        private boolean alwaysOutputDefaultValueFields;
        private Set<Descriptors.FieldDescriptor> includingDefaultValueFields;
        private final TypeRegistry oldRegistry;
        private final boolean omittingInsignificantWhitespace;
        private final boolean preservingProtoFieldNames;
        private final boolean printingEnumsAsInts;
        private final com.google.protobuf.TypeRegistry registry;
        private final boolean sortingMapKeys;

        public /* synthetic */ Printer(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, boolean z6, Set set, boolean z7, boolean z8, boolean z9, boolean z10, AnonymousClass1 anonymousClass1) {
            this(typeRegistry, typeRegistry2, z6, set, z7, z8, z9, z10);
        }

        private void checkUnsetIncludingDefaultValueFields() {
            if (this.alwaysOutputDefaultValueFields || !this.includingDefaultValueFields.isEmpty()) {
                throw new IllegalStateException("JsonFormat includingDefaultValueFields has already been set.");
            }
        }

        private void checkUnsetPrintingEnumsAsInts() {
            if (this.printingEnumsAsInts) {
                throw new IllegalStateException("JsonFormat printingEnumsAsInts has already been set.");
            }
        }

        public void appendTo(MessageOrBuilder messageOrBuilder, Appendable appendable) throws InvalidProtocolBufferException {
            new PrinterImpl(this.registry, this.oldRegistry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, appendable, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys).print(messageOrBuilder);
        }

        public Printer includingDefaultValueFields() {
            checkUnsetIncludingDefaultValueFields();
            return new Printer(this.registry, this.oldRegistry, true, Collections.EMPTY_SET, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
        }

        public Printer omittingInsignificantWhitespace() {
            return new Printer(this.registry, this.oldRegistry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, true, this.printingEnumsAsInts, this.sortingMapKeys);
        }

        public Printer preservingProtoFieldNames() {
            return new Printer(this.registry, this.oldRegistry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, true, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
        }

        public String print(MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
            try {
                StringBuilder sb = new StringBuilder();
                appendTo(messageOrBuilder, sb);
                return sb.toString();
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        }

        public Printer printingEnumsAsInts() {
            checkUnsetPrintingEnumsAsInts();
            return new Printer(this.registry, this.oldRegistry, this.alwaysOutputDefaultValueFields, Collections.EMPTY_SET, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, true, this.sortingMapKeys);
        }

        public Printer sortingMapKeys() {
            return new Printer(this.registry, this.oldRegistry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, true);
        }

        public Printer usingTypeRegistry(TypeRegistry typeRegistry) {
            if (this.oldRegistry == TypeRegistry.getEmptyTypeRegistry() && this.registry == com.google.protobuf.TypeRegistry.getEmptyTypeRegistry()) {
                return new Printer(com.google.protobuf.TypeRegistry.getEmptyTypeRegistry(), typeRegistry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
            }
            throw new IllegalArgumentException("Only one registry is allowed.");
        }

        private Printer(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, boolean z6, Set<Descriptors.FieldDescriptor> set, boolean z7, boolean z8, boolean z9, boolean z10) {
            this.registry = typeRegistry;
            this.oldRegistry = typeRegistry2;
            this.alwaysOutputDefaultValueFields = z6;
            this.includingDefaultValueFields = set;
            this.preservingProtoFieldNames = z7;
            this.omittingInsignificantWhitespace = z8;
            this.printingEnumsAsInts = z9;
            this.sortingMapKeys = z10;
        }

        public Printer includingDefaultValueFields(Set<Descriptors.FieldDescriptor> set) {
            if ((set == null || set.isEmpty()) ? false : true) {
                checkUnsetIncludingDefaultValueFields();
                return new Printer(this.registry, this.oldRegistry, false, Collections.unmodifiableSet(new HashSet(set)), this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
            }
            throw new IllegalArgumentException("Non-empty Set must be supplied for includingDefaultValueFields.");
        }

        public Printer usingTypeRegistry(com.google.protobuf.TypeRegistry typeRegistry) {
            if (this.oldRegistry == TypeRegistry.getEmptyTypeRegistry() && this.registry == com.google.protobuf.TypeRegistry.getEmptyTypeRegistry()) {
                return new Printer(typeRegistry, this.oldRegistry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
            }
            throw new IllegalArgumentException("Only one registry is allowed.");
        }
    }

    public static final class PrinterImpl {
        private static final Map<String, WellKnownTypePrinter> wellKnownTypePrinters = buildWellKnownTypePrinters();
        private final boolean alwaysOutputDefaultValueFields;
        private final CharSequence blankOrNewLine;
        private final CharSequence blankOrSpace;
        private final TextGenerator generator;
        private final m gson = GsonHolder.DEFAULT_GSON;
        private final Set<Descriptors.FieldDescriptor> includingDefaultValueFields;
        private final TypeRegistry oldRegistry;
        private final boolean preservingProtoFieldNames;
        private final boolean printingEnumsAsInts;
        private final com.google.protobuf.TypeRegistry registry;
        private final boolean sortingMapKeys;

        public static class GsonHolder {
            private static final m DEFAULT_GSON = new n().a();

            private GsonHolder() {
            }
        }

        public interface WellKnownTypePrinter {
            void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder);
        }

        public PrinterImpl(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, boolean z6, Set<Descriptors.FieldDescriptor> set, boolean z7, Appendable appendable, boolean z8, boolean z9, boolean z10) {
            this.registry = typeRegistry;
            this.oldRegistry = typeRegistry2;
            this.alwaysOutputDefaultValueFields = z6;
            this.includingDefaultValueFields = set;
            this.preservingProtoFieldNames = z7;
            this.printingEnumsAsInts = z9;
            this.sortingMapKeys = z10;
            AnonymousClass1 anonymousClass1 = null;
            if (z8) {
                this.generator = new CompactTextGenerator(appendable, anonymousClass1);
                this.blankOrSpace = "";
                this.blankOrNewLine = "";
            } else {
                this.generator = new PrettyTextGenerator(appendable, anonymousClass1);
                this.blankOrSpace = " ";
                this.blankOrNewLine = "\n";
            }
        }

        private static Map<String, WellKnownTypePrinter> buildWellKnownTypePrinters() {
            HashMap map = new HashMap();
            map.put(Any.getDescriptor().getFullName(), new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.1
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
                    printerImpl.printAny(messageOrBuilder);
                }
            });
            WellKnownTypePrinter wellKnownTypePrinter = new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.2
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
                    printerImpl.printWrapper(messageOrBuilder);
                }
            };
            map.put(BoolValue.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(Int32Value.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(UInt32Value.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(Int64Value.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(UInt64Value.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(StringValue.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(BytesValue.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(FloatValue.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(DoubleValue.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(Timestamp.getDescriptor().getFullName(), new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.3
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) {
                    printerImpl.printTimestamp(messageOrBuilder);
                }
            });
            map.put(Duration.getDescriptor().getFullName(), new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.4
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) {
                    printerImpl.printDuration(messageOrBuilder);
                }
            });
            map.put(FieldMask.getDescriptor().getFullName(), new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.5
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) {
                    printerImpl.printFieldMask(messageOrBuilder);
                }
            });
            map.put(Struct.getDescriptor().getFullName(), new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.6
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
                    printerImpl.printStruct(messageOrBuilder);
                }
            });
            map.put(Value.getDescriptor().getFullName(), new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.7
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
                    printerImpl.printValue(messageOrBuilder);
                }
            });
            map.put(ListValue.getDescriptor().getFullName(), new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.8
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
                    printerImpl.printListValue(messageOrBuilder);
                }
            });
            return map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printAny(MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
            if (Any.getDefaultInstance().equals(messageOrBuilder)) {
                this.generator.print("{}");
                return;
            }
            Descriptors.Descriptor descriptorForType = messageOrBuilder.getDescriptorForType();
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = descriptorForType.findFieldByName("type_url");
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName2 = descriptorForType.findFieldByName("value");
            if (fieldDescriptorFindFieldByName == null || fieldDescriptorFindFieldByName2 == null || fieldDescriptorFindFieldByName.getType() != Descriptors.FieldDescriptor.Type.STRING || fieldDescriptorFindFieldByName2.getType() != Descriptors.FieldDescriptor.Type.BYTES) {
                throw new InvalidProtocolBufferException("Invalid Any type.");
            }
            String str = (String) messageOrBuilder.getField(fieldDescriptorFindFieldByName);
            Descriptors.Descriptor descriptorForTypeUrl = this.registry.getDescriptorForTypeUrl(str);
            if (descriptorForTypeUrl == null && (descriptorForTypeUrl = this.oldRegistry.getDescriptorForTypeUrl(str)) == null) {
                throw new InvalidProtocolBufferException(a.p("Cannot find type for url: ", str));
            }
            DynamicMessage from = DynamicMessage.getDefaultInstance(descriptorForTypeUrl).getParserForType().parseFrom((ByteString) messageOrBuilder.getField(fieldDescriptorFindFieldByName2));
            WellKnownTypePrinter wellKnownTypePrinter = wellKnownTypePrinters.get(JsonFormat.getTypeName(str));
            if (wellKnownTypePrinter == null) {
                print(from, str);
                return;
            }
            this.generator.print("{" + ((Object) this.blankOrNewLine));
            this.generator.indent();
            this.generator.print("\"@type\":" + ((Object) this.blankOrSpace) + this.gson.h(str) + "," + ((Object) this.blankOrNewLine));
            TextGenerator textGenerator = this.generator;
            StringBuilder sb = new StringBuilder("\"value\":");
            sb.append((Object) this.blankOrSpace);
            textGenerator.print(sb.toString());
            wellKnownTypePrinter.print(this, from);
            this.generator.print(this.blankOrNewLine);
            this.generator.outdent();
            this.generator.print("}");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printDuration(MessageOrBuilder messageOrBuilder) {
            Duration from = Duration.parseFrom(toByteString(messageOrBuilder));
            this.generator.print("\"" + Durations.toString(from) + "\"");
        }

        private void printField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) throws InvalidProtocolBufferException {
            if (this.preservingProtoFieldNames) {
                this.generator.print("\"" + fieldDescriptor.getName() + "\":" + ((Object) this.blankOrSpace));
            } else {
                this.generator.print("\"" + fieldDescriptor.getJsonName() + "\":" + ((Object) this.blankOrSpace));
            }
            if (fieldDescriptor.isMapField()) {
                printMapFieldValue(fieldDescriptor, obj);
            } else if (fieldDescriptor.isRepeated()) {
                printRepeatedFieldValue(fieldDescriptor, obj);
            } else {
                printSingleFieldValue(fieldDescriptor, obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printFieldMask(MessageOrBuilder messageOrBuilder) {
            FieldMask from = FieldMask.parseFrom(toByteString(messageOrBuilder));
            this.generator.print("\"" + FieldMaskUtil.toJsonString(from) + "\"");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printListValue(MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = messageOrBuilder.getDescriptorForType().findFieldByName("values");
            if (fieldDescriptorFindFieldByName == null) {
                throw new InvalidProtocolBufferException("Invalid ListValue type.");
            }
            printRepeatedFieldValue(fieldDescriptorFindFieldByName, messageOrBuilder.getField(fieldDescriptorFindFieldByName));
        }

        private void printMapFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj) throws InvalidProtocolBufferException {
            Descriptors.Descriptor messageType = fieldDescriptor.getMessageType();
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = messageType.findFieldByName("key");
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName2 = messageType.findFieldByName("value");
            if (fieldDescriptorFindFieldByName == null || fieldDescriptorFindFieldByName2 == null) {
                throw new InvalidProtocolBufferException("Invalid map field.");
            }
            this.generator.print("{" + ((Object) this.blankOrNewLine));
            this.generator.indent();
            Collection<Message> collectionValues = (List) obj;
            if (this.sortingMapKeys && !collectionValues.isEmpty()) {
                TreeMap treeMap = new TreeMap(fieldDescriptorFindFieldByName.getType() == Descriptors.FieldDescriptor.Type.STRING ? new Comparator<Object>() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.9
                    @Override // java.util.Comparator
                    public int compare(Object obj2, Object obj3) {
                        return ByteString.unsignedLexicographicalComparator().compare(ByteString.copyFromUtf8((String) obj2), ByteString.copyFromUtf8((String) obj3));
                    }
                } : null);
                for (Object obj2 : collectionValues) {
                    treeMap.put(((Message) obj2).getField(fieldDescriptorFindFieldByName), obj2);
                }
                collectionValues = treeMap.values();
            }
            boolean z6 = false;
            for (Message message : collectionValues) {
                Object field = message.getField(fieldDescriptorFindFieldByName);
                Object field2 = message.getField(fieldDescriptorFindFieldByName2);
                if (z6) {
                    this.generator.print("," + ((Object) this.blankOrNewLine));
                } else {
                    z6 = true;
                }
                printSingleFieldValue(fieldDescriptorFindFieldByName, field, true);
                this.generator.print(":" + ((Object) this.blankOrSpace));
                printSingleFieldValue(fieldDescriptorFindFieldByName2, field2);
            }
            if (z6) {
                this.generator.print(this.blankOrNewLine);
            }
            this.generator.outdent();
            this.generator.print("}");
        }

        private void printRepeatedFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.generator.print("[");
            boolean z6 = false;
            for (Object obj2 : (List) obj) {
                if (z6) {
                    this.generator.print("," + ((Object) this.blankOrSpace));
                } else {
                    z6 = true;
                }
                printSingleFieldValue(fieldDescriptor, obj2);
            }
            this.generator.print("]");
        }

        private void printSingleFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            printSingleFieldValue(fieldDescriptor, obj, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printStruct(MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = messageOrBuilder.getDescriptorForType().findFieldByName("fields");
            if (fieldDescriptorFindFieldByName == null) {
                throw new InvalidProtocolBufferException("Invalid Struct type.");
            }
            printMapFieldValue(fieldDescriptorFindFieldByName, messageOrBuilder.getField(fieldDescriptorFindFieldByName));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printTimestamp(MessageOrBuilder messageOrBuilder) {
            Timestamp from = Timestamp.parseFrom(toByteString(messageOrBuilder));
            this.generator.print("\"" + Timestamps.toString(from) + "\"");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printValue(MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
            Map<Descriptors.FieldDescriptor, Object> allFields = messageOrBuilder.getAllFields();
            if (allFields.isEmpty()) {
                this.generator.print("null");
            } else {
                if (allFields.size() != 1) {
                    throw new InvalidProtocolBufferException("Invalid Value type.");
                }
                for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : allFields.entrySet()) {
                    printSingleFieldValue(entry.getKey(), entry.getValue());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printWrapper(MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = messageOrBuilder.getDescriptorForType().findFieldByName("value");
            if (fieldDescriptorFindFieldByName == null) {
                throw new InvalidProtocolBufferException("Invalid Wrapper type.");
            }
            printSingleFieldValue(fieldDescriptorFindFieldByName, messageOrBuilder.getField(fieldDescriptorFindFieldByName));
        }

        private ByteString toByteString(MessageOrBuilder messageOrBuilder) {
            return messageOrBuilder instanceof Message ? ((Message) messageOrBuilder).toByteString() : ((Message.Builder) messageOrBuilder).build().toByteString();
        }

        public void print(MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
            WellKnownTypePrinter wellKnownTypePrinter = wellKnownTypePrinters.get(messageOrBuilder.getDescriptorForType().getFullName());
            if (wellKnownTypePrinter != null) {
                wellKnownTypePrinter.print(this, messageOrBuilder);
            } else {
                print(messageOrBuilder, null);
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private void printSingleFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj, boolean z6) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[fieldDescriptor.getType().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    if (z6) {
                        this.generator.print("\"");
                    }
                    this.generator.print(((Integer) obj).toString());
                    if (z6) {
                        this.generator.print("\"");
                        return;
                    }
                    return;
                case 4:
                case 5:
                case 6:
                    this.generator.print("\"" + ((Long) obj).toString() + "\"");
                    return;
                case 7:
                    if (z6) {
                        this.generator.print("\"");
                    }
                    if (((Boolean) obj).booleanValue()) {
                        this.generator.print("true");
                    } else {
                        this.generator.print("false");
                    }
                    if (z6) {
                        this.generator.print("\"");
                        return;
                    }
                    return;
                case 8:
                    Float f6 = (Float) obj;
                    if (f6.isNaN()) {
                        this.generator.print("\"NaN\"");
                        return;
                    }
                    if (f6.isInfinite()) {
                        if (f6.floatValue() < 0.0f) {
                            this.generator.print("\"-Infinity\"");
                            return;
                        } else {
                            this.generator.print("\"Infinity\"");
                            return;
                        }
                    }
                    if (z6) {
                        this.generator.print("\"");
                    }
                    this.generator.print(f6.toString());
                    if (z6) {
                        this.generator.print("\"");
                        return;
                    }
                    return;
                case 9:
                    Double d = (Double) obj;
                    if (d.isNaN()) {
                        this.generator.print("\"NaN\"");
                        return;
                    }
                    if (d.isInfinite()) {
                        if (d.doubleValue() < 0.0d) {
                            this.generator.print("\"-Infinity\"");
                            return;
                        } else {
                            this.generator.print("\"Infinity\"");
                            return;
                        }
                    }
                    if (z6) {
                        this.generator.print("\"");
                    }
                    this.generator.print(d.toString());
                    if (z6) {
                        this.generator.print("\"");
                        return;
                    }
                    return;
                case 10:
                case 11:
                    if (z6) {
                        this.generator.print("\"");
                    }
                    this.generator.print(JsonFormat.unsignedToString(((Integer) obj).intValue()));
                    if (z6) {
                        this.generator.print("\"");
                        return;
                    }
                    return;
                case 12:
                case 13:
                    this.generator.print("\"" + JsonFormat.unsignedToString(((Long) obj).longValue()) + "\"");
                    return;
                case 14:
                    this.generator.print(this.gson.h(obj));
                    return;
                case 15:
                    this.generator.print("\"");
                    TextGenerator textGenerator = this.generator;
                    c cVar = e.c;
                    byte[] byteArray = ((ByteString) obj).toByteArray();
                    cVar.getClass();
                    int length = byteArray.length;
                    l.h(0, length, byteArray.length);
                    com.google.common.io.a aVar = cVar.f2787a;
                    int i = aVar.e;
                    RoundingMode roundingMode = RoundingMode.CEILING;
                    StringBuilder sb = new StringBuilder(k.x(length, aVar.f2784f) * i);
                    try {
                        cVar.d(sb, byteArray, length);
                        textGenerator.print(sb.toString());
                        this.generator.print("\"");
                        return;
                    } catch (IOException e) {
                        throw new AssertionError(e);
                    }
                case 16:
                    if (fieldDescriptor.getEnumType().getFullName().equals("google.protobuf.NullValue")) {
                        if (z6) {
                            this.generator.print("\"");
                        }
                        this.generator.print("null");
                        if (z6) {
                            this.generator.print("\"");
                            return;
                        }
                        return;
                    }
                    if (!this.printingEnumsAsInts) {
                        Descriptors.EnumValueDescriptor enumValueDescriptor = (Descriptors.EnumValueDescriptor) obj;
                        if (enumValueDescriptor.getIndex() != -1) {
                            this.generator.print("\"" + enumValueDescriptor.getName() + "\"");
                            return;
                        }
                    }
                    this.generator.print(String.valueOf(((Descriptors.EnumValueDescriptor) obj).getNumber()));
                    return;
                case 17:
                case 18:
                    print((Message) obj);
                    return;
                default:
                    return;
            }
        }

        private void print(MessageOrBuilder messageOrBuilder, String str) throws InvalidProtocolBufferException {
            boolean z6;
            Map<Descriptors.FieldDescriptor, Object> allFields;
            this.generator.print("{" + ((Object) this.blankOrNewLine));
            this.generator.indent();
            if (str != null) {
                this.generator.print("\"@type\":" + ((Object) this.blankOrSpace) + this.gson.h(str));
                z6 = true;
            } else {
                z6 = false;
            }
            if (!this.alwaysOutputDefaultValueFields && this.includingDefaultValueFields.isEmpty()) {
                allFields = messageOrBuilder.getAllFields();
            } else {
                TreeMap treeMap = new TreeMap(messageOrBuilder.getAllFields());
                for (Descriptors.FieldDescriptor fieldDescriptor : messageOrBuilder.getDescriptorForType().getFields()) {
                    if (fieldDescriptor.isOptional()) {
                        if (fieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE || messageOrBuilder.hasField(fieldDescriptor)) {
                            if (fieldDescriptor.getContainingOneof() == null || messageOrBuilder.hasField(fieldDescriptor)) {
                            }
                        }
                    }
                    if (!treeMap.containsKey(fieldDescriptor) && (this.alwaysOutputDefaultValueFields || this.includingDefaultValueFields.contains(fieldDescriptor))) {
                        treeMap.put(fieldDescriptor, messageOrBuilder.getField(fieldDescriptor));
                    }
                }
                allFields = treeMap;
            }
            for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : allFields.entrySet()) {
                if (z6) {
                    this.generator.print("," + ((Object) this.blankOrNewLine));
                } else {
                    z6 = true;
                }
                printField(entry.getKey(), entry.getValue());
            }
            if (z6) {
                this.generator.print(this.blankOrNewLine);
            }
            this.generator.outdent();
            this.generator.print("}");
        }
    }

    public interface TextGenerator {
        void indent();

        void outdent();

        void print(CharSequence charSequence);
    }

    public static class TypeRegistry {
        private final Map<String, Descriptors.Descriptor> types;

        public static class Builder {
            private final Set<String> files;
            private Map<String, Descriptors.Descriptor> types;

            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private void addFile(Descriptors.FileDescriptor fileDescriptor) {
                if (this.files.add(fileDescriptor.getFullName())) {
                    Iterator<Descriptors.FileDescriptor> it = fileDescriptor.getDependencies().iterator();
                    while (it.hasNext()) {
                        addFile(it.next());
                    }
                    Iterator<Descriptors.Descriptor> it2 = fileDescriptor.getMessageTypes().iterator();
                    while (it2.hasNext()) {
                        addMessage(it2.next());
                    }
                }
            }

            private void addMessage(Descriptors.Descriptor descriptor) {
                Iterator<Descriptors.Descriptor> it = descriptor.getNestedTypes().iterator();
                while (it.hasNext()) {
                    addMessage(it.next());
                }
                if (!this.types.containsKey(descriptor.getFullName())) {
                    this.types.put(descriptor.getFullName(), descriptor);
                    return;
                }
                JsonFormat.logger.warning("Type " + descriptor.getFullName() + " is added multiple times.");
            }

            @CanIgnoreReturnValue
            public Builder add(Descriptors.Descriptor descriptor) {
                if (this.types == null) {
                    throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
                }
                addFile(descriptor.getFile());
                return this;
            }

            public TypeRegistry build() {
                TypeRegistry typeRegistry = new TypeRegistry(this.types, null);
                this.types = null;
                return typeRegistry;
            }

            private Builder() {
                this.files = new HashSet();
                this.types = new HashMap();
            }

            @CanIgnoreReturnValue
            public Builder add(Iterable<Descriptors.Descriptor> iterable) {
                if (this.types != null) {
                    Iterator<Descriptors.Descriptor> it = iterable.iterator();
                    while (it.hasNext()) {
                        addFile(it.next().getFile());
                    }
                    return this;
                }
                throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
            }
        }

        public static class EmptyTypeRegistryHolder {
            private static final TypeRegistry EMPTY = new TypeRegistry(Collections.EMPTY_MAP, null);

            private EmptyTypeRegistryHolder() {
            }
        }

        public /* synthetic */ TypeRegistry(Map map, AnonymousClass1 anonymousClass1) {
            this(map);
        }

        public static TypeRegistry getEmptyTypeRegistry() {
            return EmptyTypeRegistryHolder.EMPTY;
        }

        public static Builder newBuilder() {
            return new Builder(null);
        }

        public Descriptors.Descriptor find(String str) {
            return this.types.get(str);
        }

        public Descriptors.Descriptor getDescriptorForTypeUrl(String str) {
            return find(JsonFormat.getTypeName(str));
        }

        private TypeRegistry(Map<String, Descriptors.Descriptor> map) {
            this.types = map;
        }
    }

    private JsonFormat() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getTypeName(String str) throws InvalidProtocolBufferException {
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length != 1) {
            return strArrSplit[strArrSplit.length - 1];
        }
        throw new InvalidProtocolBufferException("Invalid type url found: ".concat(str));
    }

    public static Parser parser() {
        return new Parser(com.google.protobuf.TypeRegistry.getEmptyTypeRegistry(), TypeRegistry.getEmptyTypeRegistry(), false, 100, null);
    }

    public static Printer printer() {
        return new Printer(com.google.protobuf.TypeRegistry.getEmptyTypeRegistry(), TypeRegistry.getEmptyTypeRegistry(), false, Collections.EMPTY_SET, false, false, false, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String unsignedToString(int i) {
        return i >= 0 ? Integer.toString(i) : Long.toString(((long) i) & 4294967295L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String unsignedToString(long j6) {
        if (j6 >= 0) {
            return Long.toString(j6);
        }
        return BigInteger.valueOf(j6 & LocationRequestCompat.PASSIVE_INTERVAL).setBit(63).toString();
    }

    public static class ParserImpl {
        private static final double EPSILON = 1.0E-6d;
        private static final BigDecimal MAX_DOUBLE;
        private static final BigDecimal MIN_DOUBLE;
        private static final BigDecimal MORE_THAN_ONE;
        private final boolean ignoringUnknownFields;
        private final TypeRegistry oldRegistry;
        private final int recursionLimit;
        private final com.google.protobuf.TypeRegistry registry;
        private static final Map<String, WellKnownTypeParser> wellKnownTypeParsers = buildWellKnownTypeParsers();
        private static final BigInteger MAX_UINT64 = new BigInteger("FFFFFFFFFFFFFFFF", 16);
        private final Map<Descriptors.Descriptor, Map<String, Descriptors.FieldDescriptor>> fieldNameMaps = new HashMap();
        private final u jsonParser = new u();
        private int currentDepth = 0;

        public interface WellKnownTypeParser {
            void merge(ParserImpl parserImpl, p pVar, Message.Builder builder);
        }

        static {
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(1.000001d));
            MORE_THAN_ONE = bigDecimal;
            MAX_DOUBLE = new BigDecimal(String.valueOf(Double.MAX_VALUE)).multiply(bigDecimal);
            MIN_DOUBLE = new BigDecimal(String.valueOf(-1.7976931348623157E308d)).multiply(bigDecimal);
        }

        public ParserImpl(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, boolean z6, int i) {
            this.registry = typeRegistry;
            this.oldRegistry = typeRegistry2;
            this.ignoringUnknownFields = z6;
            this.recursionLimit = i;
        }

        private static Map<String, WellKnownTypeParser> buildWellKnownTypeParsers() {
            HashMap map = new HashMap();
            map.put(Any.getDescriptor().getFullName(), new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.1
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeAny(pVar, builder);
                }
            });
            WellKnownTypeParser wellKnownTypeParser = new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.2
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeWrapper(pVar, builder);
                }
            };
            map.put(BoolValue.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(Int32Value.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(UInt32Value.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(Int64Value.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(UInt64Value.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(StringValue.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(BytesValue.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(FloatValue.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(DoubleValue.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(Timestamp.getDescriptor().getFullName(), new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.3
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeTimestamp(pVar, builder);
                }
            });
            map.put(Duration.getDescriptor().getFullName(), new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.4
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeDuration(pVar, builder);
                }
            });
            map.put(FieldMask.getDescriptor().getFullName(), new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.5
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, p pVar, Message.Builder builder) {
                    parserImpl.mergeFieldMask(pVar, builder);
                }
            });
            map.put(Struct.getDescriptor().getFullName(), new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.6
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeStruct(pVar, builder);
                }
            });
            map.put(ListValue.getDescriptor().getFullName(), new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.7
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeListValue(pVar, builder);
                }
            });
            map.put(Value.getDescriptor().getFullName(), new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.8
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeValue(pVar, builder);
                }
            });
            return map;
        }

        private Map<String, Descriptors.FieldDescriptor> getFieldNameMap(Descriptors.Descriptor descriptor) {
            if (this.fieldNameMaps.containsKey(descriptor)) {
                return this.fieldNameMaps.get(descriptor);
            }
            HashMap map = new HashMap();
            for (Descriptors.FieldDescriptor fieldDescriptor : descriptor.getFields()) {
                map.put(fieldDescriptor.getName(), fieldDescriptor);
                map.put(fieldDescriptor.getJsonName(), fieldDescriptor);
            }
            this.fieldNameMaps.put(descriptor, map);
            return map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAny(p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
            Descriptors.Descriptor descriptorForType = builder.getDescriptorForType();
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = descriptorForType.findFieldByName("type_url");
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName2 = descriptorForType.findFieldByName("value");
            if (fieldDescriptorFindFieldByName == null || fieldDescriptorFindFieldByName2 == null || fieldDescriptorFindFieldByName.getType() != Descriptors.FieldDescriptor.Type.STRING || fieldDescriptorFindFieldByName2.getType() != Descriptors.FieldDescriptor.Type.BYTES) {
                throw new InvalidProtocolBufferException("Invalid Any type.");
            }
            if (!(pVar instanceof s)) {
                throw new InvalidProtocolBufferException("Expect message object but got: " + pVar);
            }
            s sVar = (s) pVar;
            if (((AbstractCollection) sVar.f3042a.entrySet()).isEmpty()) {
                return;
            }
            com.google.gson.internal.n nVar = sVar.f3042a;
            p pVar2 = (p) nVar.get("@type");
            if (pVar2 == null) {
                throw new InvalidProtocolBufferException("Missing type url when parsing: " + pVar);
            }
            String strA = pVar2.a();
            Descriptors.Descriptor descriptorForTypeUrl = this.registry.getDescriptorForTypeUrl(strA);
            if (descriptorForTypeUrl == null && (descriptorForTypeUrl = this.oldRegistry.getDescriptorForTypeUrl(strA)) == null) {
                throw new InvalidProtocolBufferException(a.p("Cannot resolve type: ", strA));
            }
            builder.setField(fieldDescriptorFindFieldByName, strA);
            DynamicMessage.Builder builderNewBuilderForType = DynamicMessage.getDefaultInstance(descriptorForTypeUrl).newBuilderForType();
            WellKnownTypeParser wellKnownTypeParser = wellKnownTypeParsers.get(descriptorForTypeUrl.getFullName());
            if (wellKnownTypeParser != null) {
                p pVar3 = (p) nVar.get("value");
                if (pVar3 != null) {
                    wellKnownTypeParser.merge(this, pVar3, builderNewBuilderForType);
                }
            } else {
                mergeMessage(pVar, builderNewBuilderForType, true);
            }
            builder.setField(fieldDescriptorFindFieldByName2, builderNewBuilderForType.build().toByteString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDuration(p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
            try {
                builder.mergeFrom(Durations.parse(pVar.a()).toByteString());
            } catch (ParseException unused) {
                throw new InvalidProtocolBufferException("Failed to parse duration: " + pVar);
            }
        }

        private void mergeField(Descriptors.FieldDescriptor fieldDescriptor, p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
            if (fieldDescriptor.isRepeated()) {
                if (builder.getRepeatedFieldCount(fieldDescriptor) > 0) {
                    throw new InvalidProtocolBufferException("Field " + fieldDescriptor.getFullName() + " has already been set.");
                }
            } else if (builder.hasField(fieldDescriptor)) {
                throw new InvalidProtocolBufferException("Field " + fieldDescriptor.getFullName() + " has already been set.");
            }
            if (fieldDescriptor.isRepeated() && (pVar instanceof r)) {
                return;
            }
            if (fieldDescriptor.isMapField()) {
                mergeMapField(fieldDescriptor, pVar, builder);
                return;
            }
            if (fieldDescriptor.isRepeated()) {
                mergeRepeatedField(fieldDescriptor, pVar, builder);
                return;
            }
            if (fieldDescriptor.getContainingOneof() != null) {
                mergeOneofField(fieldDescriptor, pVar, builder);
                return;
            }
            Object fieldValue = parseFieldValue(fieldDescriptor, pVar, builder);
            if (fieldValue != null) {
                builder.setField(fieldDescriptor, fieldValue);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFieldMask(p pVar, Message.Builder builder) {
            builder.mergeFrom(FieldMaskUtil.fromJsonString(pVar.a()).toByteString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeListValue(p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = builder.getDescriptorForType().findFieldByName("values");
            if (fieldDescriptorFindFieldByName == null) {
                throw new InvalidProtocolBufferException("Invalid ListValue type.");
            }
            mergeRepeatedField(fieldDescriptorFindFieldByName, pVar, builder);
        }

        private void mergeMapField(Descriptors.FieldDescriptor fieldDescriptor, p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
            if (!(pVar instanceof s)) {
                throw new InvalidProtocolBufferException("Expect a map object but found: " + pVar);
            }
            Descriptors.Descriptor messageType = fieldDescriptor.getMessageType();
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = messageType.findFieldByName("key");
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName2 = messageType.findFieldByName("value");
            if (fieldDescriptorFindFieldByName == null || fieldDescriptorFindFieldByName2 == null) {
                throw new InvalidProtocolBufferException("Invalid map field: " + fieldDescriptor.getFullName());
            }
            for (Map.Entry entry : (com.google.gson.internal.l) ((s) pVar).f3042a.entrySet()) {
                Message.Builder builderNewBuilderForField = builder.newBuilderForField(fieldDescriptor);
                Object fieldValue = parseFieldValue(fieldDescriptorFindFieldByName, new v((String) entry.getKey()), builderNewBuilderForField);
                Object fieldValue2 = parseFieldValue(fieldDescriptorFindFieldByName2, (p) entry.getValue(), builderNewBuilderForField);
                if (fieldValue2 != null) {
                    builderNewBuilderForField.setField(fieldDescriptorFindFieldByName, fieldValue);
                    builderNewBuilderForField.setField(fieldDescriptorFindFieldByName2, fieldValue2);
                    builder.addRepeatedField(fieldDescriptor, builderNewBuilderForField.build());
                } else if (!this.ignoringUnknownFields || fieldDescriptorFindFieldByName2.getType() != Descriptors.FieldDescriptor.Type.ENUM) {
                    throw new InvalidProtocolBufferException("Map value cannot be null.");
                }
            }
        }

        private void mergeMessage(p pVar, Message.Builder builder, boolean z6) throws InvalidProtocolBufferException {
            if (!(pVar instanceof s)) {
                throw new InvalidProtocolBufferException("Expect message object but got: " + pVar);
            }
            Map<String, Descriptors.FieldDescriptor> fieldNameMap = getFieldNameMap(builder.getDescriptorForType());
            for (Map.Entry entry : (com.google.gson.internal.l) ((s) pVar).f3042a.entrySet()) {
                if (!z6 || !((String) entry.getKey()).equals("@type")) {
                    Descriptors.FieldDescriptor fieldDescriptor = fieldNameMap.get(entry.getKey());
                    if (fieldDescriptor != null) {
                        mergeField(fieldDescriptor, (p) entry.getValue(), builder);
                    } else if (!this.ignoringUnknownFields) {
                        throw new InvalidProtocolBufferException("Cannot find field: " + ((String) entry.getKey()) + " in message " + builder.getDescriptorForType().getFullName());
                    }
                }
            }
        }

        private void mergeOneofField(Descriptors.FieldDescriptor fieldDescriptor, p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
            Object fieldValue = parseFieldValue(fieldDescriptor, pVar, builder);
            if (fieldValue == null) {
                return;
            }
            if (builder.getOneofFieldDescriptor(fieldDescriptor.getContainingOneof()) == null) {
                builder.setField(fieldDescriptor, fieldValue);
                return;
            }
            throw new InvalidProtocolBufferException("Cannot set field " + fieldDescriptor.getFullName() + " because another field " + builder.getOneofFieldDescriptor(fieldDescriptor.getContainingOneof()).getFullName() + " belonging to the same oneof has already been set ");
        }

        private void mergeRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
            if (!(pVar instanceof o)) {
                throw new InvalidProtocolBufferException("Expect an array but found: " + pVar);
            }
            o oVar = (o) pVar;
            for (int i = 0; i < oVar.f3039a.size(); i++) {
                Object fieldValue = parseFieldValue(fieldDescriptor, (p) oVar.f3039a.get(i), builder);
                if (fieldValue != null) {
                    builder.addRepeatedField(fieldDescriptor, fieldValue);
                } else if (!this.ignoringUnknownFields || fieldDescriptor.getType() != Descriptors.FieldDescriptor.Type.ENUM) {
                    throw new InvalidProtocolBufferException("Repeated field elements cannot be null in field: " + fieldDescriptor.getFullName());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeStruct(p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = builder.getDescriptorForType().findFieldByName("fields");
            if (fieldDescriptorFindFieldByName == null) {
                throw new InvalidProtocolBufferException("Invalid Struct type.");
            }
            mergeMapField(fieldDescriptorFindFieldByName, pVar, builder);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTimestamp(p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
            try {
                builder.mergeFrom(Timestamps.parse(pVar.a()).toByteString());
            } catch (ParseException unused) {
                throw new InvalidProtocolBufferException("Failed to parse timestamp: " + pVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeValue(p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
            Descriptors.Descriptor descriptorForType = builder.getDescriptorForType();
            if (pVar instanceof v) {
                v vVar = (v) pVar;
                Serializable serializable = vVar.f3061a;
                if (serializable instanceof Boolean) {
                    builder.setField(descriptorForType.findFieldByName("bool_value"), Boolean.valueOf(vVar.b()));
                    return;
                } else if (serializable instanceof Number) {
                    builder.setField(descriptorForType.findFieldByName("number_value"), Double.valueOf(vVar.f3061a instanceof Number ? vVar.c().doubleValue() : Double.parseDouble(vVar.a())));
                    return;
                } else {
                    builder.setField(descriptorForType.findFieldByName("string_value"), vVar.a());
                    return;
                }
            }
            if (pVar instanceof s) {
                Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = descriptorForType.findFieldByName("struct_value");
                Message.Builder builderNewBuilderForField = builder.newBuilderForField(fieldDescriptorFindFieldByName);
                merge(pVar, builderNewBuilderForField);
                builder.setField(fieldDescriptorFindFieldByName, builderNewBuilderForField.build());
                return;
            }
            if (pVar instanceof o) {
                Descriptors.FieldDescriptor fieldDescriptorFindFieldByName2 = descriptorForType.findFieldByName("list_value");
                Message.Builder builderNewBuilderForField2 = builder.newBuilderForField(fieldDescriptorFindFieldByName2);
                merge(pVar, builderNewBuilderForField2);
                builder.setField(fieldDescriptorFindFieldByName2, builderNewBuilderForField2.build());
                return;
            }
            if (pVar instanceof r) {
                builder.setField(descriptorForType.findFieldByName("null_value"), NullValue.NULL_VALUE.getValueDescriptor());
            } else {
                throw new IllegalStateException("Unexpected json data: " + pVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeWrapper(p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
            Descriptors.Descriptor descriptorForType = builder.getDescriptorForType();
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = descriptorForType.findFieldByName("value");
            if (fieldDescriptorFindFieldByName != null) {
                builder.setField(fieldDescriptorFindFieldByName, parseFieldValue(fieldDescriptorFindFieldByName, pVar, builder));
            } else {
                throw new InvalidProtocolBufferException("Invalid wrapper type: " + descriptorForType.getFullName());
            }
        }

        private boolean parseBool(p pVar) throws InvalidProtocolBufferException {
            if (pVar.a().equals("true")) {
                return true;
            }
            if (pVar.a().equals("false")) {
                return false;
            }
            throw new InvalidProtocolBufferException("Invalid bool value: " + pVar);
        }

        private ByteString parseBytes(p pVar) {
            try {
                return ByteString.copyFrom(e.c.a(pVar.a()));
            } catch (IllegalArgumentException unused) {
                return ByteString.copyFrom(e.d.a(pVar.a()));
            }
        }

        private double parseDouble(p pVar) throws InvalidProtocolBufferException {
            if (pVar.a().equals("NaN")) {
                return Double.NaN;
            }
            if (pVar.a().equals("Infinity")) {
                return Double.POSITIVE_INFINITY;
            }
            if (pVar.a().equals("-Infinity")) {
                return Double.NEGATIVE_INFINITY;
            }
            try {
                BigDecimal bigDecimal = new BigDecimal(pVar.a());
                if (bigDecimal.compareTo(MAX_DOUBLE) <= 0 && bigDecimal.compareTo(MIN_DOUBLE) >= 0) {
                    return bigDecimal.doubleValue();
                }
                throw new InvalidProtocolBufferException("Out of range double value: " + pVar);
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (Exception unused) {
                throw new InvalidProtocolBufferException("Not an double value: " + pVar);
            }
        }

        private Descriptors.EnumValueDescriptor parseEnum(Descriptors.EnumDescriptor enumDescriptor, p pVar) throws InvalidProtocolBufferException {
            String strA = pVar.a();
            Descriptors.EnumValueDescriptor enumValueDescriptorFindValueByName = enumDescriptor.findValueByName(strA);
            if (enumValueDescriptorFindValueByName == null) {
                try {
                    int int32 = parseInt32(pVar);
                    enumValueDescriptorFindValueByName = enumDescriptor.getFile().getSyntax() == Descriptors.FileDescriptor.Syntax.PROTO3 ? enumDescriptor.findValueByNumberCreatingIfUnknown(int32) : enumDescriptor.findValueByNumber(int32);
                } catch (InvalidProtocolBufferException unused) {
                }
                if (enumValueDescriptorFindValueByName == null && !this.ignoringUnknownFields) {
                    StringBuilder sbM = b.m("Invalid enum value: ", strA, " for enum type: ");
                    sbM.append(enumDescriptor.getFullName());
                    throw new InvalidProtocolBufferException(sbM.toString());
                }
            }
            return enumValueDescriptorFindValueByName;
        }

        private Object parseFieldValue(Descriptors.FieldDescriptor fieldDescriptor, p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
            if (pVar instanceof r) {
                if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE && fieldDescriptor.getMessageType().getFullName().equals(Value.getDescriptor().getFullName())) {
                    return builder.newBuilderForField(fieldDescriptor).mergeFrom(Value.newBuilder().setNullValueValue(0).build().toByteString()).build();
                }
                if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM && fieldDescriptor.getEnumType().getFullName().equals(NullValue.getDescriptor().getFullName())) {
                    return fieldDescriptor.getEnumType().findValueByNumber(0);
                }
                return null;
            }
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[fieldDescriptor.getType().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    return Integer.valueOf(parseInt32(pVar));
                case 4:
                case 5:
                case 6:
                    return Long.valueOf(parseInt64(pVar));
                case 7:
                    return Boolean.valueOf(parseBool(pVar));
                case 8:
                    return Float.valueOf(parseFloat(pVar));
                case 9:
                    return Double.valueOf(parseDouble(pVar));
                case 10:
                case 11:
                    return Integer.valueOf(parseUint32(pVar));
                case 12:
                case 13:
                    return Long.valueOf(parseUint64(pVar));
                case 14:
                    return parseString(pVar);
                case 15:
                    return parseBytes(pVar);
                case 16:
                    return parseEnum(fieldDescriptor.getEnumType(), pVar);
                case 17:
                case 18:
                    int i = this.currentDepth;
                    if (i >= this.recursionLimit) {
                        throw new InvalidProtocolBufferException("Hit recursion limit.");
                    }
                    this.currentDepth = i + 1;
                    Message.Builder builderNewBuilderForField = builder.newBuilderForField(fieldDescriptor);
                    merge(pVar, builderNewBuilderForField);
                    this.currentDepth--;
                    return builderNewBuilderForField.build();
                default:
                    throw new InvalidProtocolBufferException("Invalid field type: " + fieldDescriptor.getType());
            }
        }

        private float parseFloat(p pVar) throws InvalidProtocolBufferException {
            if (pVar.a().equals("NaN")) {
                return Float.NaN;
            }
            if (pVar.a().equals("Infinity")) {
                return Float.POSITIVE_INFINITY;
            }
            if (pVar.a().equals("-Infinity")) {
                return Float.NEGATIVE_INFINITY;
            }
            try {
                double d = Double.parseDouble(pVar.a());
                if (d <= 3.402826869208755E38d && d >= -3.402826869208755E38d) {
                    return (float) d;
                }
                throw new InvalidProtocolBufferException("Out of range float value: " + pVar);
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (Exception unused) {
                throw new InvalidProtocolBufferException("Not a float value: " + pVar);
            }
        }

        private int parseInt32(p pVar) throws InvalidProtocolBufferException {
            try {
                try {
                    return Integer.parseInt(pVar.a());
                } catch (Exception unused) {
                    return new BigDecimal(pVar.a()).intValueExact();
                }
            } catch (Exception unused2) {
                throw new InvalidProtocolBufferException("Not an int32 value: " + pVar);
            }
        }

        private long parseInt64(p pVar) throws InvalidProtocolBufferException {
            try {
                try {
                    return Long.parseLong(pVar.a());
                } catch (Exception unused) {
                    return new BigDecimal(pVar.a()).longValueExact();
                }
            } catch (Exception unused2) {
                throw new InvalidProtocolBufferException("Not an int64 value: " + pVar);
            }
        }

        private String parseString(p pVar) {
            return pVar.a();
        }

        private int parseUint32(p pVar) throws InvalidProtocolBufferException {
            try {
                try {
                    long j6 = Long.parseLong(pVar.a());
                    if (j6 >= 0 && j6 <= 4294967295L) {
                        return (int) j6;
                    }
                    throw new InvalidProtocolBufferException("Out of range uint32 value: " + pVar);
                } catch (InvalidProtocolBufferException e) {
                    throw e;
                } catch (Exception unused) {
                    throw new InvalidProtocolBufferException("Not an uint32 value: " + pVar);
                }
            } catch (InvalidProtocolBufferException e6) {
                throw e6;
            } catch (Exception unused2) {
                BigInteger bigIntegerExact = new BigDecimal(pVar.a()).toBigIntegerExact();
                if (bigIntegerExact.signum() >= 0 && bigIntegerExact.compareTo(new BigInteger("FFFFFFFF", 16)) <= 0) {
                    return bigIntegerExact.intValue();
                }
                throw new InvalidProtocolBufferException("Out of range uint32 value: " + pVar);
            }
        }

        private long parseUint64(p pVar) throws InvalidProtocolBufferException {
            try {
                BigInteger bigIntegerExact = new BigDecimal(pVar.a()).toBigIntegerExact();
                if (bigIntegerExact.compareTo(BigInteger.ZERO) >= 0 && bigIntegerExact.compareTo(MAX_UINT64) <= 0) {
                    return bigIntegerExact.longValue();
                }
                throw new InvalidProtocolBufferException("Out of range uint64 value: " + pVar);
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (Exception unused) {
                throw new InvalidProtocolBufferException("Not an uint64 value: " + pVar);
            }
        }

        public void merge(Reader reader, Message.Builder builder) throws IOException {
            try {
                com.google.gson.stream.b bVar = new com.google.gson.stream.b(reader);
                bVar.b = false;
                this.jsonParser.getClass();
                merge(u.a(bVar), builder);
            } catch (q e) {
                if (!(e.getCause() instanceof IOException)) {
                    throw new InvalidProtocolBufferException(e.getMessage());
                }
                throw ((IOException) e.getCause());
            } catch (InvalidProtocolBufferException e6) {
                throw e6;
            } catch (Exception e7) {
                throw new InvalidProtocolBufferException(e7.getMessage());
            }
        }

        public void merge(String str, Message.Builder builder) throws InvalidProtocolBufferException {
            try {
                com.google.gson.stream.b bVar = new com.google.gson.stream.b(new StringReader(str));
                bVar.b = false;
                this.jsonParser.getClass();
                merge(u.a(bVar), builder);
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (Exception e6) {
                throw new InvalidProtocolBufferException(e6.getMessage());
            }
        }

        private void merge(p pVar, Message.Builder builder) throws InvalidProtocolBufferException {
            WellKnownTypeParser wellKnownTypeParser = wellKnownTypeParsers.get(builder.getDescriptorForType().getFullName());
            if (wellKnownTypeParser != null) {
                wellKnownTypeParser.merge(this, pVar, builder);
            } else {
                mergeMessage(pVar, builder, false);
            }
        }
    }
}
