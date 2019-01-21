package sc.mobile.checkSystemSettings;

import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class CDVCheckSystemSettings extends CordovaPlugin {
    private String TAG = "CDVCheckSystemSettings";
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        switch (action) {
            case "isADBModeEnabled":
                callbackContext.success( isADBModeEnabled() ? 1 : 0 );
        }
        return true;
    }

    /*
     * checks if ADB mode is on
     * especially for debug mode check
     */
    private boolean isADBModeEnabled() {
        boolean result;
        int mode = 0;
        try {

            if (Build.VERSION.SDK_INT >= 17){ // Jelly_Bean_MR1 and above
                mode = Settings.Global.getInt(cordova.getActivity().getApplicationContext().getContentResolver(), Settings.Global.ADB_ENABLED, 0);
            } else { // Pre-Jelly_Bean_MR1
                mode = Settings.Secure.getInt(cordova.getActivity().getApplicationContext().getContentResolver(), Settings.Secure.ADB_ENABLED, 0);
            }
        } catch (Exception e) {
            Log.d(TAG,  e.getMessage() );
        }
        result = mode == 1;
        Log.d(TAG, "ADB mode enabled: " + result );
        return result;
    }
}