#!groovy

//optional arguments: tasks=clean build, level=info, test=true, options=xxx
//bat 'gradlew --info build -x test'
def call(args) {

    bat 'echo i am called from testLib.groovy in jenkins-pipeline-lib-core'

    final String tasks = args?.'tasks'?:'build'
    final String outputLevel = args?.'level'?:'info'
    final String includeTest = args?.'test'?:'true'
    final String remainingOptions = args?.'options'?:''

    String finalGradlewCommand
    String gradlewCore = 'gradlew --no-daemon'
    String outputLevelOption = '--' + outputLevel
    if (includeTest.equals('false')) testOption= '-x test'
    else testOption = ''

    finalGradlewCommand = gradlewCore + ' ' + outputLevelOption + ' ' + tasks + ' ' + testOption + ' ' + remainingOptions
    bat finalGradlewCommand
}