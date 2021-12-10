function fn() {
    karate.log('--- base config --- ')
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    karate.configure('report', { showLog: true, showAllSteps: true })
    return {};
}