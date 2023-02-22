def call(String URL_ID){
    checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: ${URL_ID}]])
}