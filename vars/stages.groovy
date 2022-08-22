def call(){
    pipeline {    
        agent {label 'jenkins-slave'}
        stages {
            stage('Code Quality Check via SonarQube') {
                steps {
                    script {
                            sonarqube()
                        }
                    }
                }    
            
            stage('build') {
                steps {
                    script{

                        build()
                    }
                        
                    }
            }
            stage('deploy') {
                steps {
                    script{

                        deploy()
                }
                }
            }
        }   
    }
}