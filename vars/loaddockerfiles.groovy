def call(){

    sh "mkdir -p badreads/templates"
    def all_resource= "badreads/templates/back-end-deployment.yaml badreads/templates/backend-service.yaml badreads/templates/front-end-deployment.yaml badreads/templates/frontend-service.yaml"
    def dirs = all_resource_dir.split(" ")
        for (i in dirs) {
                def file_name = i.split("/")[-1]
                def content = libraryResource i
                writeFile file: "badreads/templates/${file_name}", text: content
            }

}