function(config) {
    config.set({
        files: [
            // These are not watched because they're not expected to change.
            // These are not included because they are not JavaScript files and Karma inserts 
            // these as <script> tags.
            // These are served however, as the adapter will load them into the captured browsers.
            // The cucumber-html.css file can be copied and customized, simply change the path.
            // The adapter will load any file ending with '.css' into the captured browsers.
            {pattern: 'build/js/node_modules/karma-cucumberjs/vendor/cucumber-html.css', watched: false, 
                included: false, served: true},
            {pattern: 'build/js/karma-cucumberjs/app.template', watched: false, included: false, served: true},


            // These are not included because they're text feature files and shouldn't go in script tags.
            // These are watched because feature files will change during dev and you want Karma to run
            // tests when these change.
            // These are served by Karma so the adapter can load their contents when its time to test.
            {pattern: 'acceptance/src/commonTest/resources/**/*.feature', watched: true, included: false, served: true},



            // The step definitions should be loaded last so the adapter can load the global functions 
            // needed by the step defs.
            // The step defs are watched and served so Karma runs when they change.
            {pattern: 'acceptance/src/jsTest/kotlin/**/*.kt', watched: true, included: true, served: true}
        ],

        frameworks: ['cucumberjs']
    })
