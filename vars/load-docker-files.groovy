def call(){

    def dockerclient = libraryResource "badreads-frontend/Dockerfile"
    writeFile file: "Dockerfile-front" , text: dockerclient
    def dockerserver = libraryResource "badreads-backend/Dockerfile"
    writeFile file: "Dockerfile-back" , text: dockerserver

}