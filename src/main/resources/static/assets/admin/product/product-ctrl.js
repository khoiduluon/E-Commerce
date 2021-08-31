app.controller("product-ctrl", function($scope,$http){
 
    $scope.items=[];
    $scope.cates=[];
    $scope.form={};

    $scope.initialize = function(){
        $http.get("/rest/products").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
        });
        $http.get("/rest/categories").then(resp => {
            $scope.cates = resp.data;
        });
    };

    $scope.initialize();

    $scope.reset = function(){
        $scope.form = {
            date: new Date(),
            image:'',
            available:true,
        };
    };

    $scope.edit = function(items){
        $scope.form = angular.copy(items);
        $(".nav-tabs a:eq(0)").tab("show")
        
    };


    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/products`,item).then(resp => {
            resp.data.date = new Date(resp.data.date)
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Thêm ok");
        }).catch(err => {
            alert("Thêm lỗi");
            console.log(err);
        })
    };

    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/products/${item.productId}`,item).then(resp =>{
            var index = $scope.items.findIndex(p => p.productId == item.productId);
            $scope.items[index] = item;
            alert("Cập nhật ok");
        }).catch(err =>{
            alert("Cập nhật lỗi");
            consolog.log(err);
        })
    }

    $scope.delete = function(item){
        $http.delete(`/rest/products/${item.productId}`).then(resp =>{
            var index = $scope.items.findIndex(p => p.productId == item.productId);
            $scope.items.splice(index, 1);
            $scope.reset();
            alert("Cập nhật ok");
        }).catch(err =>{
            alert("Cập nhật lỗi");
            consolog.log(err);
        })
    }

    $scope.imageChanged = function(files){
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/images',data, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            console.log(resp.data);
            $scope.form.image = resp.data.name;
        }).catch(err => {
            alert("Lỗi upload");
            console.log(err);
        })
    }

    $scope.pager = {
        page:0,
        size:3,
        get items(){
            var start = this.page * this.size;
         return $scope.items.slice(start, start + this.size);
        },
        get count(){
            return Math.ceil(1.0 * $scope.items.length / this.size)
        },
        first(){
            this.page = 0;
        },

        next(){
            this.page++;
            if(this.page >= this.count){
                this.first();
            }
        },

        prev(){
            this.page--;
            if(this.page < 0){
                this.last();
            }
        },

        last(){
            this.page = this.count - 1;
        }
    };
});