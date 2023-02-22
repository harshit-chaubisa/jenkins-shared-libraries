#!/usr/bin/env groovy

def call(String urlid, String BUILD_TRIGGER_BY) {
  sh """
      set +x;
      curl -X POST -H 'Content-type: application/json' --data '{
        "username": "sheersh",
        "attachments": [
          {
            "pretext": "Notification From Jenkins",
            "title": "The build has completed",
            "title_link": "https://jenkins.gkmit.co/view/accel/job/accel-staging/",
            \"text\": \"${BUILD_TRIGGER_BY} \nJob Name: ${env.JOB_NAME} ${env.BUILD_NUMBER} \n Build Output: (<${env.BUILD_URL}/console|Open>) \n Commit URL (<${url}|Open>)\",
            "footer": "Accel",
            "footer_icon": "https://media.licdn.com/dms/image/C560BAQGIOZDvliUyqA/company-logo_200_200/0/1637701111354?e=1684972800&v=beta&t=o4C4cxZu226JNl4Td4GPqOct6jbqi_GUnIuC0SlSEgc",
            "color": "#006400"
          }
        ]
      }' ${urlid}
  """
}
