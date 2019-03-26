workflow "MergeIfGreen" {
  on = "pull_request"
  resolves = ["MergePR"]
}

action "MergePR" {
  uses = "MergePR"
  secrets = ["GITHUB_TOKEN"]
}
