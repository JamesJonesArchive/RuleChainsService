node('master') {
  env.JAVA_HOME = tool 'jdk8'

  env.PATH = "${env.JENKINS_HOME}/bin:${mvnHome}/bin:${env.GRADLE_HOME}/bin:${env.GRAILS_HOME}/bin:${env.PATH}"
  checkout scm

  stage('Test Build') {
    sh('./gradlew bootRun')
  }

}