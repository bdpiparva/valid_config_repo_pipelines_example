def all = [1,2,3,4];

GoCD.script {
  pipelines {
    all.each { p ->
      pipeline("test-groovy-$p") {
        group = 'first'
        materials {
          git {
            branch = 'master'
            shallowClone = false
            url = 'https://github.com/bdpiparva/config_repo_sample'
          }
        }
        stages {
          stage('test') {
            artifactCleanupProhibited = false
            cleanWorkingDir = false
            fetchMaterials = true
            approval {
            }
            jobs {
              job('test') {
                tasks {
                  exec {
                    commandLine = ['ls', '-alh']
                    runIf = 'passed'
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}
