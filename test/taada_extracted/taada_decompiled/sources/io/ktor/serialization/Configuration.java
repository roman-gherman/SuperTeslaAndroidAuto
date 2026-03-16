package io.ktor.serialization;

import N1.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.bouncycastle.cms.CMSAttributeTableGenerator;
import org.jetbrains.annotations.NotNull;
import u1.C0840e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JD\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/serialization/Configuration;", "", "Lio/ktor/serialization/ContentConverter;", "T", "Lu1/e;", CMSAttributeTableGenerator.CONTENT_TYPE, "converter", "Lkotlin/Function1;", "LN1/m;", "Lkotlin/ExtensionFunctionType;", "configuration", "register", "(Lu1/e;Lio/ktor/serialization/ContentConverter;Lkotlin/jvm/functions/Function1;)V", "ktor-serialization"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Configuration {
    <T extends ContentConverter> void register(@NotNull C0840e contentType, @NotNull T converter, @NotNull Function1<? super T, m> configuration);
}
