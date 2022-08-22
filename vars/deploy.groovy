def call(){
    withCredentials([file(credentialsId: 'kube-config', variable: 'Secretfile')]) {
    sh '''
        helm upgrade badreadsclient-$BRANCH_NAME --install ./badreads --values ./badreads/values-$BRANCH_NAME.yaml --set backend.image.repository=muhammadatef/badreadsserver-$BRANCH_NAME-$BUILD_NUMBER --set frontend.image.repository=muhammadatef/badreadsclient-$BRANCH_NAME-$BUILD_NUMBER --kubeconfig $Secretfile
        '''
    cleanWs()
    }
}