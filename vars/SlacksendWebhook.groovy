#!/usr/bin/env groovy

def call(Map args) {
  String webhook ='https://hooks.slack.com/services/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'
  String title = args.title ?: "Deploy Successfull" 
  String pass = args.pass ?: "success" 
  String footer = args.footer ?: "Jenkins"
  String pretext = args.pretext ?: "Notification From Jenkins" 
  String footer_icon = args.footer_icon ?: 'https://jenkins.io/images/logos/jenkins/256.png'
  String teamDomain = args.teamDomain ?: "gkmit"
  def color= '#FF0000'
  def status = "Deploy Failed !!"
  if(pass == 'success'){
    color= '#00FF00'
    status = "Build Successful !!"
  }
  env.BUILD_TRIGGER_BY = "${currentBuild.getBuildCauses()[0].shortDescription} / ${currentBuild.getBuildCauses()[0].userId}" //Fetching the build trigger
  def url = "https://google.com"
  def objects = """'{
     "username": "vaibhavraj",
      "attachments":[
                {
                  "pretext": "${pretext}",
                  "title": "${status}",
                  "title_link": "https://jenkins.gkmit.co",
                  "text": "${BUILD_TRIGGER_BY} \nJob Name: ${env.JOB_NAME} ${env.BUILD_NUMBER} \n Build Output: (<${env.BUILD_URL}/console|Open>) \n Commit URL (<${url}|Open>)",
                  "footer": "${footer}",
                  "footer_icon": "${footer_icon}",
                  "color": "${color}"
                }
              ]
  }' ${webhook}
  """

  sh """
  set +x; 
  curl -X POST -H 'Content-type: application/json' --data ${objects}
  """
}
