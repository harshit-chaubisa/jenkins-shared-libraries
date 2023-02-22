def call(){
    String harshit = evaluate('url')
    checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: harshit]])
}