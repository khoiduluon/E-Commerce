app.controller("authority-ctrl", function($scope,$http,$location){
    $scope.roles=[];
    $scope.admins=[];
    $scope.authorities=[];
    
    $scope.intialize = function(){
        $http.get("/rest/roles").then(resp => {
            $scope.roles = resp.data;
        })
    }

    $http.get("/rest/accounts?admin=true").then(resp => {
        $scope.admins = resp.data;
    })

    $http.get("/rest/authorities?admin=true").then(resp => {
        $scope.authorities = resp.data;
    }).catch(err => {
        $location.path("/unauthorized");
    })


    $scope.authority_of = function(acc, role){
        if($scope.authorities){
            return $scope.authorities.find(ur => 
                ur.username.username == acc.username && ur.roleid.roleId==role.roleId)
        }
    }

    $scope.authority_changed = function(acc, role){
        var authority = $scope.authority_of(acc, role);
        if(authority){
            $scope.revoke_authority(authority);
        } else {
            authority = {username:acc, roleid: role};
            $scope.grant_authority(authority);
        }
    }

    $scope.grant_authority = function(authority){
        $http.post(`/rest/authorities`,authority).then(resp => {
            $scope.authorities.push(resp.data)
            alert("Cấp quyền ok");
        }).catch(err => {
            alert("Cấp quyền lỗi");
            console.log("Err", err);
        })
    }

    $scope.revoke_authority = function(authority){
        $http.delete(`/rest/authorities/${authority.authorityId}`).then(resp => {
            var index = $scope.authorities.findIndex(a => a.authorityId == authority.authorityId);
            console.log("OK");
            console.log($scope.authorities);
            console.log("index: ",index);
            //$scope.authorites.splice(index, 1);
            alert("Thu hồi ok");
        }).catch(err => {
            alert("Thu hồi thất bại");
            console.log("Err", err);
        })
    }
    $scope.intialize();
})