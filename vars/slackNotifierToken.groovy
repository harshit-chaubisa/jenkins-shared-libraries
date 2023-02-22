#!/usr/bin/env groovy

def call() {
  post {
        success {
            slackSend (
                botUser: true,
                tokenCredentialId: 'Devops-Team-Slack-App-Token',
                teamDomain: 'gkmit',
                channel: 'C04PN31U0C9',  //Accel-devops
                // channel: 'C04GE4PGS8P', //jenkins-testing
                username: 'Accel',
                attachments: [
                    [
                        color: "#00FF00",
                        pretext: 'Notification From Jenkins',
                        title: 'Deploy successfull !',
                        title_link: "https://jenkins.gkmit.co/view/accel/job/accel-prod-deploy/",
                        text: "Started by ${env.BUILD_TRIGGER_BY} \nJob Name: ${env.JOB_NAME} ${env.BUILD_NUMBER} \n Build Output: (<${env.BUILD_URL}/console|Open>) \n Commit URL (<${env.url}|Open>)",
                        footer: 'Jenkins',
                        footer_icon: 'https://jenkins.io/images/logos/jenkins/256.png'
                    ]
                ],
            )
        }
        failure {
            slackSend (
                botUser: true,
                tokenCredentialId: 'Devops-Team-Slack-App-Token',
                teamDomain: 'gkmit',
                channel: 'C04PN31U0C9',  //Accel-Devops
                // channel: 'C04GE4PGS8P', //jenkins-testing
                username: 'Accel',
                attachments: [
                    [
                        color: "#FF0000",
                        pretext: 'Notification From Jenkins',
                        title: 'Deploy Failed !',
                        title_link: "https://jenkins.gkmit.co/view/accel/job/accel-prod-deploy/",
                        text: "Started by ${env.BUILD_TRIGGER_BY} \nJob Name: ${env.JOB_NAME} ${env.BUILD_NUMBER} \n Build Output: (<${env.BUILD_URL}/console|Open>) \n Commit URL (<${env.url}|Open>)",
                        footer: 'Jenkins',
                        footer_icon: 'https://jenkins.io/images/logos/jenkins/256.png'
                    ]
                ],
            )
        }
    }
}
