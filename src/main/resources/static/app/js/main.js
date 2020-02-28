var projectApp = angular.module("projectApp", ["ngRoute"]);


projectApp.controller("HomeCtrl", function ($scope, $http, $location) {

    $scope.users = [];

    var getUsers = function () {

        var promise = $http.get("/api/users");
        promise.then(
            function success(response) {
                $scope.users = response.data;
            },
            function error(response) {
                alert("Unable to fetch users")
            }
        )

    }
    getUsers();

    $scope.videos = [];

    var getVideos = function () {

        var promise = $http.get("/api/videos");
        promise.then(
            function success(response) {
                $scope.videos = response.data;
            },
            function error() {
                alert("Unable to fetch users")
            }
        )
    }
    getVideos();

    $scope.videoPage = function (id) {
        $location.path("/videoPage/" + id)
    }

    $scope.register = function () {
        $location.path("/register")
    }

});

projectApp.controller("RegisterCtrl", function ($scope, $http, $location) {

    $scope.newUser = {};

    $scope.newUser.firstName = "";
    $scope.newUser.lastName = "";
    $scope.newUser.userName = "";
    $scope.newUser.email = "";
    $scope.newUser.password = "";
    $scope.newUser.confirmedPassword = "";
    $scope.newUser.description = "";

    $scope.add = function () {
        var promise = $http.post("/api/users", $scope.newUser);
        promise.then(
            function success(response) {
                $location.path("/")
            },
            function error() {
                alert("Unable to add users")
            }
        )
    }

});

projectApp.controller("VideoCtrl", function ($scope, $http, $location, $routeParams) {

    $scope.video = {};

    var getVideo = function () {
        var promise = $http.get("/api/videos/" + $routeParams.id);
        promise.then(
            function success(response) {
                $scope.video = response.data;
            },
            function error() {
                alert("Unable to fetch user")
            }
        )
    }
    getVideo();

});



projectApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: '/app/html/home.html',
            controller: "HomeCtrl"
        })
        .when('/register', {
            templateUrl: '/app/html/register.html',
            controller: "RegisterCtrl"
        })
        .when('/videoPage/:id', {
            templateUrl: '/app/html/videoPage.html',
            controller: "VideoCtrl"
        })
        .otherwise({
            redirectTo: '/'
        });
}]);