def call(String url){
    checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: ${url}]])
}