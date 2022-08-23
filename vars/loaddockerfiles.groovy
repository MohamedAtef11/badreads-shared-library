def call(){

    sh "mkdir -p badreads/templates/"
    def dir_values= "badreads/Chart.yaml badreads/values-dev.yaml badreads/values-preprod.yaml badreads/values-prod.yaml badreads/values-test.yaml badreads/values.yaml"
    def dirs = dir_values.split(" ")
        for (i in dirs) {
                def file_name = i.split("/")[-1]
                def content = libraryResource i
                writeFile file: "badreads/${file_name}", text: content
            }
    def dir_templates= "badreads/templates/back-end-deployment.yaml badreads/templates/backend-service.yaml badreads/templates/front-end-deployment.yaml badreads/templates/frontend-service.yaml"
    def dirs_templates = dir_templates.split(" ")
        for (x in dirs_templates) {
                def file_name_temp = x.split("/")[-1]
                def contents = libraryResource x
                writeFile file: "badreads/templates/${file_name_temp}", text: contents
            }

}