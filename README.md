# Cordova Plugin Check System Settings
## Features:
###    1. chek USB Debugging
    [參照] https://github.com/dpa99c/cordova-diagnostic-plugin.git , 只加入有用到的功能

## Install
<pre>cordova plugin add cordova-plugin-check-system-settings</pre>
## Usage
### isADBModeEnabled()

Platforms: Android

Checks if the device setting for ADB(debug) is switched on.
Returns true if ADB(debug) setting is switched on.

    cordova.plugins.checkSystemSettings.isADBModeEnabled(successCallback, errorCallback);

#### Parameters

- {Function} successCallback -  The callback which will be called when operation is successful.
The function is passed a single boolean parameter which is TRUE if ADB mode(debug mode) is switched on.
- {Function} errorCallback -  The callback which will be called when operation encounters an error.
The function is passed a single string parameter containing the error message.


#### Example usage

    cordova.plugins.checkSystemSettings.isADBModeEnabled(function(enabled){
        console.log("ADB mode(debug mode) is " + (enabled ? "enabled" : "disabled"));
    }, function(error){
        console.error("The following error occurred: "+error);
    });