pipeline{
   agent any
   
   stages{
   stage('Compile Stage'){
   steps{
   withMaven(maven : 'maven_3_6_3'){
   sh 'mvn clean compile'
   }
   stage('Staging Stage'){
   steps{
   withMaven(maven : 'maven_3_6_3'){
   sh 'mvn test'
   }
   stage('Deploy Stage'){
   steps{
   withMaven(maven : 'maven_3_6_3'){
   sh 'mvn deploy'
   }
   
   
   }}}
   
}}}}}