# cicd
CI/CD Pipeline Code


## Install Softwares

---
#### Jenkins

[1. Install Jenkins](https://www.jenkins.io/doc/book/installing/)

Install: brew install jenkins

Upgrade: brew upgrade jenkins

vi /usr/local/Cellar/jenkins/2.378/homebrew.mxcl.jenkins.plist
change httpPort from 8080 to 8101



Start: brew services start jenkins

Install Plugins: 
[AnsiColor](https://plugins.jenkins.io/ansicolor/)
[Timestamper](https://plugins.jenkins.io/timestamper/)
[Workspace-Cleanup](https://plugins.jenkins.io/ws-cleanup/)
[Build-Timeout](https://plugins.jenkins.io/build-timeout/)
[Display-Console Output](https://plugins.jenkins.io/display-console-output/)
[Git](https://plugins.jenkins.io/git)
[Git-Parameter](https://plugins.jenkins.io/git-parameter/)
[Pipeline](https://plugins.jenkins.io/workflow-aggregator/)
[Pipeline-Groovy](https://plugins.jenkins.io/workflow-cps/)
[Pipeline-Build-Step](https://plugins.jenkins.io/pipeline-build-step/)
[Pipeline-Stage-Step](https://plugins.jenkins.io/pipeline-stage-step/)
[Docker-Pipeline](https://plugins.jenkins.io/docker-workflow/)
[Mask-Passwords](https://plugins.jenkins.io/mask-passwords/)
[Log-Parser](https://plugins.jenkins.io/log-parser/)
[Collapsing-Console-Sections](https://plugins.jenkins.io/collapsing-console-sections/)
[Console-Badge](https://plugins.jenkins.io/console-badge/)
[Console-Tail](https://plugins.jenkins.io/console-tail/)
[Job-DSL](https://plugins.jenkins.io/job-dsl/)

Install plugsin using jenkins-cli
export JENKINS_URL=http://localhost:8080/
jenkins-cli -webSocket install-plugin  https://plugins.jenkins.io/docker-workflow/




---
#### Liquibase

[2. Install Liquibase](https://www.liquibase.com/download#download-liquibase)


---
#### Github Desktop
[3. Install GitHub Desktop](https://desktop.github.com/)

---
#### PostgreSQL
[4. Install PostgreSQL](https://www.postgresql.org/download/)

mkdir ${HOME}/GitHub

cd ${HOME}/GitHub

git clone https://github.com/raogaru/cicd.git

git clone https://github.com/raogaru/myapp.git

---
### Airflow Pipeline Diagrams

### CI-Pipeline-Summary
![CI-Pipeline-Summary](ci-pipeline-summary.png?raw=true)

### CI-Main-Gate
![CI-Main-Gate](ci-main-gate.png?raw=true)

### CI-Team-Gate
![CI-Team-Gate](ci-team-gate.png?raw=true)

### CI-System-Gate
![CI-System-Gate](ci-system-gate.png?raw=true)

### CI-Release-Gate
![CI-Release-Gate](ci-release-gate.png?raw=true)

### CI-Pipeline-Detail
![CI-Pipeline-Detail](ci-pipeline-detail.png?raw=true)

