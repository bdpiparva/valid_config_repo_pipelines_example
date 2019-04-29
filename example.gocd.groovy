GoCD.script {
  pipelines {
    pipeline('test-groovy') {
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