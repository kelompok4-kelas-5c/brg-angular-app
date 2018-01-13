var brgApp= angular.module('BrgApp', []);

brgApp.controller('BrgController', 
    function($scope, $http, $window) {
        $scope.daftarBrg = [];
        $scope.updateDaftarBrg = function(){
            $http.get('/daftar-barang').then(sukses, gagal);
            
            function sukses(response){
            	console.log(response);
            	//isidata mahasiswa
            	$scope.daftarBrg = response.data;
            };
            function gagal(response){
            	console.log(response);
        	};
        };

        $scope.ubah = function(brg){
            //console.log(mhs);
            $window.location.href="/form-edit?id=" + brg.id;
        };
        
        $scope.hapus = function(brg){
            $http.delete('/hapus-data/' + brg.id).then(sukses, gagal);

            function sukses(response){
                $scope.updateDaftarBrg();
            } ;

            function gagal(response){
                console.log(response);
            } ;
        };

        $scope.keluar = function() {
            $http.get('/keluar').then(sukses, gagal);

            function sukses(response){
                $window.location.href="/";
                
                
            };
            function gagal(response){
                console.log(response);
            };
        

        };

        $scope.updateDaftarBrg();
    });
brgApp.controller('FormController', 
    function($scope, $http, $window){
        $scope.simpan = function() {
            //console.log('nim : '+ $scope.mhs.nim);
            //console.log('nama : '+ $scope.mhs.nama);
            //console.log('jurusan : '+ $scope.mhs.jurusan);

            $http.post('/tambah-brg', $scope.brg).then(sukses, gagal);

            function sukses(response){
                $window.location.href = '/';
            };
            function gagal(response){
                console.log(response);
            };
        };

        $scope.batal = function() {
            $window.location.href = '/';
        };
    });