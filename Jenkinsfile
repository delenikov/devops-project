node {
    def app
    stage('Clone repository') {
        checkout scm
    }
    stage('Build backend and push image') {
        steps {
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
    }
    stage('Build frontend and push image') {
        steps {
            dir('devops-frontend') {
                app = docker.build("delenikov/devops-project-frontend")
                docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                    app.push("${env.BRANCH_NAME}-${env.BUILD_NUMBER}")
                    //app.push("${env.BRANCH_NAME}-latest")
                    app.push("latest")
                }
            }
        }
    }
}