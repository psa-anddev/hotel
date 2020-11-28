config.frameworks.push('cucumber-js');
config.files.push({pattern: '../../../../../acceptance/src/commonTest/resources/**/*.feature', included: false})
config.files.push({pattern: '../../../../../acceptance/src/jsTest/kotlin/**/*.kt', watched: true, included: false, served: true})
config.plugins.push(require("karma-cucumber-js-latest"));
config.set({reporters: 'bdd-json'});
config.set('bddJsonReporter', {outputFile: 'results.json'});

