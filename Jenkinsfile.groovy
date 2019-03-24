
node{
    properties([parameters([string(defaultValue: '157.230.81.21', description: 'Docker host', name: 'IP', trim: false), string(defaultValue: 'latest', description: 'version of the App', name: 'VER', trim: false), string(defaultValue: '4000', description: 'Which port you would like to use', name: 'PORT', trim: false)])])
        stage("Remove container"){
        try{
            sh "ssh root@${IP} docker rm -f Flaskex"
        }
        catch(exc){
            sh "echo container deleted"
        }
    }
    
    stage("Run container"){
        sh "ssh   root@${IP}   docker run -d --name Flaskex  -p ${PORT}:4000 farrukhsadykov/flaskex:${VER}  "
    }
}