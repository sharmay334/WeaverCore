node {

   stage 'Checkout'

      checkout scm 


   stage 'Build'
        // sh "export" 
         def mvnHome = tool 'M3' // these named tool has to be added or installed automatically usin global tool config
         def buildStatus=-1
         def  commitId
         if("${env.BRANCH_NAME}".contains("Release") || "${env.BRANCH_NAME}".contains("master")) {
              buildStatus = sh returnStatus: true, script: "${mvnHome}/bin/mvn clean install -DVERSION=${env.BUILD_NUMBER}"
         } else {
             buildStatus=  sh  returnStatus: true, script:"${mvnHome}/bin/mvn clean package -DVERSION=SNAPSHOT -Dskipcorebuild=true"
         }
        sh "git rev-parse --short HEAD > .git/commit-id"                        
        commitId = readFile('.git/commit-id').trim()
      
        echo commitId
        echo  "BuildStatusPrinting"
        echo  "${buildStatus}"
        if (buildStatus !=0){
            httpRequest customHeaders: [[name: 'PRIVATE-TOKEN', value: "${GIT_TOKEN}"]], httpMode: 'POST', url: "${GIT_URL}${IGAME_CORE_ID}/statuses/${commitId}?state=failed"
            error 'Build Failed'
        }
     
        if(buildStatus==0){
            httpRequest customHeaders: [[name: 'PRIVATE-TOKEN', value: "${GIT_TOKEN}"]], httpMode: 'POST', url: "${GIT_URL}${IGAME_CORE_ID}/statuses/${commitId}?state=success"
        }

        echo 'Status post sent'
        
        junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        echo 'junit done'
        stage 'Create  Package'

 //   sh "${mvnHome}/bin/mvn assembly:single -DVERSION=${env.BUILD_NUMBER}"
sh "${mvnHome}/bin/mvn assembly:single"
    def groupId = getPomValue(readFile("pom.xml"), "groupId")
    def artifactId = getPomValue(readFile("pom.xml"), "artifactId")
    def version= getPomValue(readFile("pom.xml"), "version")
     def releaseVersion= getPomValue(readFile("pom.xml"), "version")
//    def releaseVersion = version.substring(0, version.lastIndexOf("_") + 1) + "${env.BUILD_NUMBER}"
        
    /*  stage ' Publish Package'
            long start_time_5 = System.currentTimeMillis();
            long wait_time_5 = 60000;
            long end_time_5 = start_time_5 + wait_time_5;
            def status_5=0
            while (System.currentTimeMillis() < end_time_5 && status_5 != 200 )
        {
            try {


                          nexusArtifactUploader  artifactId: "${artifactId}",
                           credentialsId: 'Nexus',
                           file: "target/${artifactId}-${releaseVersion}.jar" ,
                           groupId: "com/stpl/igame",
                           nexusUrl: '192.168.124.201:8087',
                           nexusVersion: 'nexus3',
                           protocol: 'http',
                           repository: 'maven-snapshots',
                           type: 'jar',
                           version: "${releaseVersion}"
       
     //def response_5 = httpRequest  timeout: 30, url: "http://${NEXUS_BASE_URL}/repository/wcc/com/stpl/igame/${artifactId}/${releaseVersion}/${artifactId}-${releaseVersion}.zip", validResponseCodes: '200'
                
                //    status_5 = response_5.status 
                                      
               }
            catch(Exception e  ){
            sleep(1)
               }
               }*/
               
               stage ' Publish Package'
               
                file: "target/${artifactId}-${releaseVersion}.jar"
               
          //     sh "cp target/${artifactId}-${releaseVersion}.jar /home/stpl/WeaverJar/"
                sh "curl -v -u admin:admin123 --upload-file target/${artifactId}-${releaseVersion}.jar  http://192.168.124.201:8087/repository/maven-snapshots/com/stpl/igame/WeaverCore/1.0.9-SNAPSHOT/"   
               
     
        }
        
        @NonCPS
def getPomValue(text, element) {
  def matcher = text =~ '<' + element + '>(.+)</' + element + '>'
  matcher ? matcher[0][1] : null
}
