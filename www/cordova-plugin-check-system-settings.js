var exec = require('cordova/exec');

exports.isADBModeEnabled() = function (success, error) {
    exec(success, error, 'CDVCheckSystemSettings', 'isADBModeEnabled', []);
};
