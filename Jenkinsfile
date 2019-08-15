 pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
		stage('Configure') {
			steps {
				step {
					version = '1.0.' + env.BUILD_NUMBER
				}
				step {
					currentBuild.displayName = version
				}
			}

			// properties([
			// 		buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')),
			// 		[$class: 'GithubProjectProperty', displayName: '', projectUrlStr: 'https://github.com/joaoabrodrigues/correios-spring-boot/'],
			// 		pipelineTriggers([[$class: 'GitHubPushTrigger']])
			// ])
		}
		stage('Checkout') {
			steps {
				git 'https://github.com/joaoabrodrigues/correios-spring-boot'
			}
		}

		stage('Version') {
			steps {
				sh "mvn versions:set -DnewVersion=$version"
			}
		}

		stage('Build') {
			steps {
				sh 'mvn clean package'
			}
		}

		stage('Test') {	
			steps {
				sh 'mvn verify'
			}
		}

		stage('Deploy') {
			steps {
				echo 'This is the deploy pipeline.'
			}
		}
    }
}