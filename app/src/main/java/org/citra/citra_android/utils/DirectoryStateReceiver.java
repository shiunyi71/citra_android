package org.citra.citra_android.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.citra.citra_android.services.DirectoryInitializationService;
import org.citra.citra_android.services.DirectoryInitializationService.DirectoryInitializationState;

import rx.functions.Action1;

public class DirectoryStateReceiver extends BroadcastReceiver {
    Action1<DirectoryInitializationState> callback;
    public DirectoryStateReceiver(Action1<DirectoryInitializationState> callback) {
        this.callback = callback;
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        DirectoryInitializationState state = (DirectoryInitializationState) intent.getSerializableExtra(DirectoryInitializationService.EXTRA_STATE);
        callback.call(state);
    }
}
