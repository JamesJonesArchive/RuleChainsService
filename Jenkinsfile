node('master') {
  env.JAVA_HOME = tool 'jdk8'

  env.PATH = "${env.JENKINS_HOME}/bin:${env.PATH}"
  checkout scm

  stage('Test Build') {
    sh('#!/bin/sh -e ./gradlew bootRun')
  }

}