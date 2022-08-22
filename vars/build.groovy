def call() {

    withCredentials([usernamePassword(credentialsId: 'docker_cred', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh """
            docker login -u '${USERNAME}' -p '${PASSWORD}'
            docker build -t muhammadatef/badreadsclient-$BRANCH_NAME-$BUILD_NUMBER ./badreads-frontend
            docker build -t muhammadatef/badreadsserver-$BRANCH_NAME-$BUILD_NUMBER ./badreads-backend 
            docker push muhammadatef/badreadsclient-$BRANCH_NAME-$BUILD_NUMBER 
            docker push muhammadatef/badreadsserver-$BRANCH_NAME-$BUILD_NUMBER 

            """
        }

}