node {
    def app
    stage('Clone repository') {
        checkout scm
    }
    stage('Build and push backend') {
        dir('devops-backend') {
            sh 'mvn -B -DskipTests clean package'
            app = docker.build("delenikov/devops-project-backend")
            docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                app.push("${env.BRANCH_NAME}-${env.BUILD_NUMBER}")
                //app.push("${env.BRANCH_NAME}-latest")
                app.push("latest")
            }
        }
    }
    stage('Build and push frontend') {
        dir('devops-backend') {
            app = docker.build("delenikov/devops-project-frontend")
            docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                app.push("${env.BRANCH_NAME}-${env.BUILD_NUMBER}")
                //app.push("${env.BRANCH_NAME}-latest")
                app.push("latest")
            }
        }
    }
}