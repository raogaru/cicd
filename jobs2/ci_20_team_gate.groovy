// ######################################################################
pipelineJob('DEMO-CI-20-team-gate') {
  definition {
    cps {
      script('''
pipeline {
	agent any
	options { 
		timestamps()
		ansiColor('xterm')
		disableConcurrentBuilds()
		timeout(59)
		buildDiscarder(logRotator(numToKeepStr: '5', daysToKeepStr: '1'))
//		ws('/tmp/cicd')
	}
	environment {
		vGATE = 'TEAM'
		vSTAGE = ''
		vTEAM = ''
		vPROCEED = 'YES'
	}

	stages {
		stage('start') { steps { echo 'CI-PIPELINE-TEAM-GATE-START' } } 
		stage('Main-Gate-Git') 	{ steps { 
			git(url:'https://github.com/raogaru/cicd.git',branch:'master',credentialsId:'raogaru',poll:'false')
//			dir('myapp') {git(url:'https://github.com/raogaru/myapp.git',branch:'team-MARS',credentialsId:'raogaru',poll:'false')} 
		} }
		stage('Team-Gate-Enter') 	{ steps { sh './ci.sh Team-Gate-Enter' } }
		stage('Teams-in-Parallel') { parallel {
		stage ('DEMO-CI-team-gate-T001') {steps {build job: 'DEMO-CI-team-gate-T001', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T002') {steps {build job: 'DEMO-CI-team-gate-T002', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T003') {steps {build job: 'DEMO-CI-team-gate-T003', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T004') {steps {build job: 'DEMO-CI-team-gate-T004', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T005') {steps {build job: 'DEMO-CI-team-gate-T005', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T006') {steps {build job: 'DEMO-CI-team-gate-T006', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T007') {steps {build job: 'DEMO-CI-team-gate-T007', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T008') {steps {build job: 'DEMO-CI-team-gate-T008', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T009') {steps {build job: 'DEMO-CI-team-gate-T009', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T010') {steps {build job: 'DEMO-CI-team-gate-T010', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T011') {steps {build job: 'DEMO-CI-team-gate-T011', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T012') {steps {build job: 'DEMO-CI-team-gate-T012', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T013') {steps {build job: 'DEMO-CI-team-gate-T013', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T014') {steps {build job: 'DEMO-CI-team-gate-T014', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T015') {steps {build job: 'DEMO-CI-team-gate-T015', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T016') {steps {build job: 'DEMO-CI-team-gate-T016', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T017') {steps {build job: 'DEMO-CI-team-gate-T017', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T018') {steps {build job: 'DEMO-CI-team-gate-T018', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T019') {steps {build job: 'DEMO-CI-team-gate-T019', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T020') {steps {build job: 'DEMO-CI-team-gate-T020', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T021') {steps {build job: 'DEMO-CI-team-gate-T021', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T022') {steps {build job: 'DEMO-CI-team-gate-T022', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T023') {steps {build job: 'DEMO-CI-team-gate-T023', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T024') {steps {build job: 'DEMO-CI-team-gate-T024', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T025') {steps {build job: 'DEMO-CI-team-gate-T025', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T026') {steps {build job: 'DEMO-CI-team-gate-T026', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T027') {steps {build job: 'DEMO-CI-team-gate-T027', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T028') {steps {build job: 'DEMO-CI-team-gate-T028', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T029') {steps {build job: 'DEMO-CI-team-gate-T029', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T030') {steps {build job: 'DEMO-CI-team-gate-T030', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T031') {steps {build job: 'DEMO-CI-team-gate-T031', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T032') {steps {build job: 'DEMO-CI-team-gate-T032', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T033') {steps {build job: 'DEMO-CI-team-gate-T033', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T034') {steps {build job: 'DEMO-CI-team-gate-T034', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T035') {steps {build job: 'DEMO-CI-team-gate-T035', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T036') {steps {build job: 'DEMO-CI-team-gate-T036', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T037') {steps {build job: 'DEMO-CI-team-gate-T037', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T038') {steps {build job: 'DEMO-CI-team-gate-T038', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T039') {steps {build job: 'DEMO-CI-team-gate-T039', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T040') {steps {build job: 'DEMO-CI-team-gate-T040', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T041') {steps {build job: 'DEMO-CI-team-gate-T041', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T042') {steps {build job: 'DEMO-CI-team-gate-T042', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T043') {steps {build job: 'DEMO-CI-team-gate-T043', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T044') {steps {build job: 'DEMO-CI-team-gate-T044', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T045') {steps {build job: 'DEMO-CI-team-gate-T045', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T046') {steps {build job: 'DEMO-CI-team-gate-T046', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T047') {steps {build job: 'DEMO-CI-team-gate-T047', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T048') {steps {build job: 'DEMO-CI-team-gate-T048', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T049') {steps {build job: 'DEMO-CI-team-gate-T049', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T050') {steps {build job: 'DEMO-CI-team-gate-T050', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T051') {steps {build job: 'DEMO-CI-team-gate-T051', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T052') {steps {build job: 'DEMO-CI-team-gate-T052', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T053') {steps {build job: 'DEMO-CI-team-gate-T053', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T054') {steps {build job: 'DEMO-CI-team-gate-T054', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T055') {steps {build job: 'DEMO-CI-team-gate-T055', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T056') {steps {build job: 'DEMO-CI-team-gate-T056', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T057') {steps {build job: 'DEMO-CI-team-gate-T057', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T058') {steps {build job: 'DEMO-CI-team-gate-T058', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T059') {steps {build job: 'DEMO-CI-team-gate-T059', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T060') {steps {build job: 'DEMO-CI-team-gate-T060', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T061') {steps {build job: 'DEMO-CI-team-gate-T061', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T062') {steps {build job: 'DEMO-CI-team-gate-T062', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T063') {steps {build job: 'DEMO-CI-team-gate-T063', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T064') {steps {build job: 'DEMO-CI-team-gate-T064', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T065') {steps {build job: 'DEMO-CI-team-gate-T065', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T066') {steps {build job: 'DEMO-CI-team-gate-T066', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T067') {steps {build job: 'DEMO-CI-team-gate-T067', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T068') {steps {build job: 'DEMO-CI-team-gate-T068', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T069') {steps {build job: 'DEMO-CI-team-gate-T069', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T070') {steps {build job: 'DEMO-CI-team-gate-T070', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T071') {steps {build job: 'DEMO-CI-team-gate-T071', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T072') {steps {build job: 'DEMO-CI-team-gate-T072', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T073') {steps {build job: 'DEMO-CI-team-gate-T073', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T074') {steps {build job: 'DEMO-CI-team-gate-T074', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T075') {steps {build job: 'DEMO-CI-team-gate-T075', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T076') {steps {build job: 'DEMO-CI-team-gate-T076', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T077') {steps {build job: 'DEMO-CI-team-gate-T077', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T078') {steps {build job: 'DEMO-CI-team-gate-T078', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T079') {steps {build job: 'DEMO-CI-team-gate-T079', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T080') {steps {build job: 'DEMO-CI-team-gate-T080', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T081') {steps {build job: 'DEMO-CI-team-gate-T081', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T082') {steps {build job: 'DEMO-CI-team-gate-T082', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T083') {steps {build job: 'DEMO-CI-team-gate-T083', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T084') {steps {build job: 'DEMO-CI-team-gate-T084', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T085') {steps {build job: 'DEMO-CI-team-gate-T085', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T086') {steps {build job: 'DEMO-CI-team-gate-T086', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T087') {steps {build job: 'DEMO-CI-team-gate-T087', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T088') {steps {build job: 'DEMO-CI-team-gate-T088', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T089') {steps {build job: 'DEMO-CI-team-gate-T089', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T090') {steps {build job: 'DEMO-CI-team-gate-T090', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T091') {steps {build job: 'DEMO-CI-team-gate-T091', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T092') {steps {build job: 'DEMO-CI-team-gate-T092', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T093') {steps {build job: 'DEMO-CI-team-gate-T093', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T094') {steps {build job: 'DEMO-CI-team-gate-T094', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T095') {steps {build job: 'DEMO-CI-team-gate-T095', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T096') {steps {build job: 'DEMO-CI-team-gate-T096', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T097') {steps {build job: 'DEMO-CI-team-gate-T097', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T098') {steps {build job: 'DEMO-CI-team-gate-T098', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T099') {steps {build job: 'DEMO-CI-team-gate-T099', parameters: [string(name: 'param1', value: "value1")]}}
		stage ('DEMO-CI-team-gate-T100') {steps {build job: 'DEMO-CI-team-gate-T100', parameters: [string(name: 'param1', value: "value1")]}}
		} }
		stage('Team-Gate-Exit') 		{ steps { sh './ci.sh Team-Gate-Exit' } }
		stage('end') { steps { echo 'CI-PIPELINE-TEAM-GATE-END' } } 
	}
}
      '''.stripIndent())
      sandbox()
    }
  }
}
// ######################################################################
