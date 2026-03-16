package fr.sd.taada.helpers.permissions;

import fr.sd.taada.helpers.permissions.PermissionItem;

/* JADX INFO: loaded from: classes2.dex */
public interface PermissionCallback {
    default void onFlowCancelled() {
    }

    void onFlowComplete(boolean z6);

    default void onPermissionDenied(PermissionItem.PermissionType permissionType) {
    }

    default void onPermissionGranted(PermissionItem.PermissionType permissionType) {
    }
}
