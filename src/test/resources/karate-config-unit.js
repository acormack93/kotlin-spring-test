function fn() {
    var port = karate.properties['local.server.port'];

    karate.log(' ------- unit tests on localhost:' + port + '  -------');

    var config = {
       baseUrl:'http://localhost:' + port
    };

    if(!port) {
        karate.log(' ------- Local port not found -------');
    } else {
        karate.log('------- base url is : ' + config.baseUrl + '--------');
    }


    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    karate.configure('report', { showLog: true, showAllSteps: true })
    return config;
}