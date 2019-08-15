 pipeline {

    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }

    stages {

	stage('Configure') {
		version = '1.0.' + env.BUILD_NUMBER
		currentBuild.displayName = version

        	properties([
                	buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')),
	                [$class: 'GithubProjectProperty', displayName: '', projectUrlStr: 'https://github.com/joaoabrodrigues/correios-spring-boot/'],
	                pipelineTriggers([[$class: 'GitHubPushTrigger']])
        	])
    	}

        stage('Checkout') {
	        git 'https://github.com/joaoabrodrigues/correios-spring-boot'
        }

    	stage('Version') {
		sh "mvn versions:set -DnewVersion=$version"
    	}

    	stage('Build') {
		sh 'mvn clean package'
    	}

    	stage('Test') {
		sh 'mvn verify'
	}

	stage('Archive') {
		junit allowEmptyResults: true, testResults: '**/target/**/TEST*.xml'
	}

    	stage('Deploy') {
		echo 'This is the deploy pipeline.'
    	}

    }
}
