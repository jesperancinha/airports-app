module.exports = function(grunt){

    grunt.loadNpmTasks('grunt-package-modules');
    grunt.loadNpmTasks('grunt-contrib-clean');

    grunt.initConfig({

      packageModules: {
        dist: {
          src: 'package.json',
          dest: 'src/main/webapp'
        },
      },

      clean:['src/main/webapp/package.json']
      ,

    });

    grunt.registerTask('default', ['packageModules', 'clean']);
}
