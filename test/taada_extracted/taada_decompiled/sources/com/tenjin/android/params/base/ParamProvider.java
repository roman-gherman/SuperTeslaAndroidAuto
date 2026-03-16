package com.tenjin.android.params.base;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface ParamProvider {
    Map<String, String> apply(Map<String, String> map);

    Map<String, String> getParams();
}
