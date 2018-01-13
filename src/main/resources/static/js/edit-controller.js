brgApp.controller('EditController',
	function($scope, $window, $http){


		$scope.brg={};

		$scope.simpan = function() {
			$http.post('/tambah-brg', $scope.brg).then(sukses, gagal);

            function sukses(response){
                $window.location.href = '/';
            };
            function gagal(response){
                console.log(response);
            };
		};

		$scope.batal = function() {
			$window.location.href = "/";
		};

		$scope.updateById = function() {
			id=$window.location.search.split('=')[1];
			//console.log(nim);
			$scope.brg.id = id;

			$http.get("/get-brg-by-id/" + id).then(sukses, gagal);

			function sukses(response){
                //$window.location.href = '/';
                $scope.brg = response.data;
            };
            function gagal(response){
                console.log(response);
            };
		};

		$scope.updateById();

	});