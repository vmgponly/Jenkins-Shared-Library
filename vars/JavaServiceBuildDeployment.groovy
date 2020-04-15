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
               sh '''
                 echo ${config.service_name}
                 echo ${config.application}
                 '''
            def subFunction = new javaServiceSubFunction()
             }        
            
         }
      }
   }
 }
}
