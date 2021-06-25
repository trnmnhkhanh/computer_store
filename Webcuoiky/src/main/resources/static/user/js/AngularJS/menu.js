var app = angular.module("menu",[]);

//Controller part
app.controller("menuController", function($scope, $http) {

    $scope.list = [];
    // Now load the data from server
    _refreshData();
      function _refreshData() {
            $http({
                method: 'GET',
                url: '/menu'
            }).then(
                function(res) { // success
                    $scope.list = res.data;
                },
                function(res) { // error
                    console.log("Error: " + res.status + " : " + res.data);
                }
            );
        }

        function _success(res) {
            _refreshData();
        }

        function _error(res) {
            var data = res.data;
            var status = res.status;
            var header = res.header;
            var config = res.config;
            alert("Error: " + status + ":" + data);
        }
});