#!groovy

//call from Jenkinsfile: gradleBuild(tasks: 'clean build', outputLevel: 'debug', includeTest:'false')
def call(args) {

    final String tasks = args?.'tasks'?:'build'
    final String outputLevel = args?.'outputLevel'?:'info'
    final String includeTest = args?.'includeTest'?:'true'
    final String remainingOptions = args?.'options'?:''

    String finalGradlewCommand
    String gradlewCore = 'gradlew --no-daemon'
    String outputLevelOption = '--' + outputLevel
    if (includeTest.equals('false')) testOption= '-x test'
    else testOption = ''

    //this is the final gradlew command that we pass to jenkins' underlying system
    finalGradlewCommand = gradlewCore + ' ' + outputLevelOption + ' ' + tasks + ' ' + testOption + ' ' + remainingOptions
    bat finalGradlewCommand
}