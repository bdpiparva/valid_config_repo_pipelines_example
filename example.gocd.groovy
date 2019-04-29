GoCD.script {
  target_version 2
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
              runInstanceCount = '0'
              timeout = 0
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
