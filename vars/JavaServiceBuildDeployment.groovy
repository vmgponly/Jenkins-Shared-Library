def call(body) {

        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()

pipeline {
   agent any
   tools
   {
       
       maven 'maven'
       nodejs 'node'
       
   }

   stages {
      stage('Build') {
         steps {
            script
             {    
               def subFunction = new javaServiceSubFunction()
             
             }
            
         }
      }
           stage('Test'){
                   steps {
                    sh '''
             echo ${config.service_name}
             echo ${config.application}
                 '''
       
                   }
           }
           
   }
 }
}
