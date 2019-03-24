node {
    properties([parameters([string(defaultValue: '127.0.0.1', description: 'Please specify IP', name: 'IP', trim: true)])])
    satge("Remove container") {
        try{
            sh "ssh root@${IP} docker rm -rf flaskex_centos7"
        }
        catch (exc){
            sh "echo container deleted"
        }
    }

    stage("Run container") {
        sh "ssh root@IP docker run -d --name flaskex_centos7 -p 6000:4000 aliyaaa/flaskex_centos7"
    } 
}