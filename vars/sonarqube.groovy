def call() {

    sh "cat ./sonar-projectx.properties | envsubst > sonar-project.properties"
    def scannerHome = tool 'SonarQube Scanner';
    withSonarQubeEnv("sonarqube") {
        sh "${tool("SonarQube Scanner")}/bin/sonar-scanner"
    }
}
