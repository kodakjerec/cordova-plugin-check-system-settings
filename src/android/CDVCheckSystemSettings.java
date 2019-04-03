package sc.mobile.checkSystemSettings;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class CDVCheckSystemSettings extends CordovaPlugin {
    private String TAG = "CDVCheckSystemSettings";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            switch (action) {
                case "isADBModeEnabled":
                    callbackContext.success( isADBModeEnabled() ? 1 : 0 );
            }
            return true;
        } catch (Exception error) {
            callbackContext.error( error.getMessage() );
            return false;
        }
    }

    /*
     * checks if ADB mode is on
     * especially for debug mode check
     */
    private boolean isADBModeEnabled() {
        boolean result;
        int mode = 0;
        try {
            ApplicationInfo appInfo = cordova.getActivity().getPackageManager().getApplicationInfo(cordova.getActivity().getPackageName(), PackageManager.GET_META_DATA);
            if ((appInfo.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0) {
                // debug = Ignore USB Debugging
                mode = 0;
            } else {
                mode = Settings.Global.getInt( cordova.getActivity().getApplicationContext().getContentResolver(), Settings.Global.ADB_ENABLED, 0 );
            }
        } catch (Exception e) {
            Log.d(TAG,  e.getMessage() );
        }
        result = mode == 1;
        Log.d(TAG, "ADB mode enabled: " + result );
        return result;
    }
}