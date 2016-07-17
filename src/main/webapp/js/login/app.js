'use strict';

// Declare app level module which depends on filters, and services
angular.module('login', ['login.filters', 'login.services', 'login.directives', 'login.controllers']).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {templateUrl: 'partials/partial1.html', controller: 'MyCtrl1'});
        $routeProvider.when('/game', {templateUrl: 'partials/championSelect.html', controller: 'MyCtrl1'});
        $routeProvider.when('/error', {templateUrl: 'partials/failedLogin.html', controller: 'MyCtrl1'});
        $routeProvider.otherwise({redirectTo: '/'});
    }]);
