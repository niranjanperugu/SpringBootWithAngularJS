   var app = angular.module("MyTutorManagement", []);
         
            //Controller Part
            app.controller("UserManagementController", function($scope, $http) {
         
                //Initialize page with default data which is blank in this example
                $scope.employees = [];
                $scope.form = {
                    id : -1,
                    firstName : "",
                    lastName : "",
                    email : ""
                };
         
                //Now load the data from server
				var endpoint="http://localhost:8500/data/";
                _refreshPageData();
				
                //HTTP POST/PUT methods for add/edit employee
                $scope.submitEmployee = function() {
         
                    var method = "";
                    var url = "";
                    if ($scope.form.id == -1) {
                        //Id is absent so add employee - POST operation
                        method = "POST";
                        url = endpoint+'employees';
                    } else {
                        //If Id is present, it's edit operation - PUT operation
                        method = "PUT";
                        url = endpoint+'employees/' + $scope.form.id;
                    }
         
                    $http({
                        method : method,
                        url : url,
                        data : angular.toJson($scope.form),
                        headers : {
                            'Content-Type' : 'application/json'
                        }
						
                    }).then( _success, _error );
                };
         
                //HTTP DELETE- delete employee by Id
                $scope.removeEmployee = function(employee) {
                    $http({
                        method : 'DELETE',
                        url : endpoint+'employees/' + employee.id
                    }).then(_success, _error);
                };
 
                //In case of edit employee, populate form with employee data
                $scope.editEmployee = function(employee) {
                    $scope.form.firstName = employee.firstName;
                    $scope.form.lastName = employee.lastName;
                    $scope.form.email = employee.email;
                    $scope.form.id = employee.id;
                };
         
                /* Private Methods */
                //HTTP GET- get all employees collection
                function _refreshPageData() {
                    $http({
                        method : 'GET',
                        url : endpoint+'employees'
                    }).then(function successCallback(response) {
                        $scope.employees = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }
         
                function _success(response) {
                    _refreshPageData();
                    _clearForm()
                }
         
                function _error(response) {
                    console.log(response.statusText);
                }
         
                //Clear the form
                function _clearForm() {
                    $scope.form.firstName = "";
                    $scope.form.lastName = "";
                    $scope.form.email = "";
                    $scope.form.id = -1;
                };
            });
            
            
            app.controller("ParentManagementController", function($scope, $http) {
                
                //Initialize page with default data which is blank in this example
                $scope.parents = [];
                $scope.form = {
                    id : -1,
                    name : "",
                    email : "",
                    studentName : "",
                    relation : "",
                    studentQualification : "",
                    intrestedSubjects : "",
                    mobileNo : "",
                    address : ""
                    
                };
         
                //Now load the data from server
				var endpoint="http://localhost:8500/parents/";
                _refreshPageData();
				
                //HTTP POST/PUT methods for add/edit employee
                $scope.submitParentData = function() {
         
                    var method = "";
                    var url = "";
                    var json=angular.toJson($scope.form);
                    if ($scope.form.id == -1) {
                        //Id is absent so add employee - POST operation
                        method = "POST";
                        url = endpoint+'parent';
                    } else {
                        //If Id is present, it's edit operation - PUT operation
                        method = "PUT";
                        url = endpoint+'parent/' + $scope.form.id;
                    }
         
                    $http({
                        method : method,
                        url : url,
                        data : angular.toJson($scope.form),
                        headers : {
                            'Content-Type' : 'application/json'
                        }
						
                    }).then( _success, _error );
                };
         
                //HTTP DELETE- delete employee by Id
                $scope.removeParent = function(parent) {
                    $http({
                        method : 'DELETE',
                        url : endpoint+'parent/' + parent.id
                    }).then(_success, _error);
                };
 
                //In case of edit employee, populate form with employee data
                $scope.editParent = function(parent) {
                	$scope.form.id = parent.id;
                    $scope.form.name = parent.name;
                    $scope.form.email = parent.email;
                    $scope.form.studentName = parent.studentName;
                    $scope.form.relation = parent.relation;
                    $scope.form.studentQualification = parent.studentQualification;
                    $scope.form.intrestedSubjects = parent.intrestedSubjects;
                    $scope.form.mobileNo = parent.mobileNo;
                    $scope.form.address = parent.address;
               
                };
         
                /* Private Methods */
                //HTTP GET- get all employees collection
                function _refreshPageData() {
                    $http({
                        method : 'GET',
                        url : endpoint+'parent'
                    }).then(function successCallback(response) {
                        $scope.parents = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }
         
                function _success(response) {
                    _refreshPageData();
                    _clearForm()
                }
         
                function _error(response) {
                    console.log(response.statusText);
                }
         
                //Clear the form
                function _clearForm() {
                	$scope.form.id = -1;
                    $scope.form.name = "";
                    $scope.form.email = "";
                    $scope.form.studentName = "";
                    $scope.form.relation = "";
                    $scope.form.studentQualification = "";
                    $scope.form.intrestedSubjects = "";
                    $scope.form.mobileNo = "";
                    $scope.form.address = "";
                };
            });
            
  //Aswartrh Testing          
            
app.controller("TutorManagementController", function($scope, $http) {
                
                //Initialize page with default data which is blank in this example
                $scope.tutors = [];
                $scope.form = {
                    id : -1,
                    name : "",
                    email : "",
                    age: "",
                    qualification : "",
                    teachingSubjects : "",
                    mobileNo : "",
                    address : ""
                    
                   
                };
         
                //Now load the data from server
				var endpoint="http://localhost:8500/tutors/";
                _refreshPageData();
				
                //HTTP POST/PUT methods for add/edit employee
                $scope.submitTutorData = function() {
         
                    var method = "";
                    var url = "";
                    var json=angular.toJson($scope.form);
                    if ($scope.form.id == -1) {
                        //Id is absent so add tutor- POST operation
                        method = "POST";
                        url = endpoint+'tutor';
                    } else {
                        //If Id is present, it's edit operation - PUT operation
                        method = "PUT";
                        url = endpoint+'tutor/' + $scope.form.id;
                    }
         
                    $http({
                        method : method,
                        url : url,
                        data : angular.toJson($scope.form),
                        headers : {
                            'Content-Type' : 'application/json'
                        }
						
                    }).then( _success, _error );
                };
         
                //HTTP DELETE- delete tutor by Id
                $scope.removeTutor = function(tutor) {
                    $http({
                        method : 'DELETE',
                        url : endpoint+'tutor/' + tutor.id
                    }).then(_success, _error);
                };
 
                //In case of edit tutor, populate form with tutor data
                $scope.editTutor = function(tutor) {
                	$scope.form.id = tutor.id;
                    $scope.form.name = tutor.name;
                    $scope.form.email = tutor.email;
                    $scope.form.age   = tutor.age;
                    $scope.form.qualification = tutor.qualification;
                    $scope.form.teachingSubjects = tutor.teachingSubjects;
                    $scope.form.mobileNo = tutor.mobileNo;
                    $scope.form.address = tutor.address;
               
                };
         
                /* Private Methods */
                //HTTP GET- get all employees collection
                function _refreshPageData() {
                    $http({
                        method : 'GET',
                        url : endpoint+'tutor'
                    }).then(function successCallback(response) {
                        $scope.tutors = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }
         
                function _success(response) {
                    _refreshPageData();
                    _clearForm()
                }
         
                function _error(response) {
                    console.log(response.statusText);
                }
         
                //Clear the form
                function _clearForm() {
                	$scope.form.id = -1;
                    $scope.form.name = "";
                    $scope.form.email = "";
                    $scope.form.age= "";
                    $scope.form.qualification = "";
                    $scope.form.teachingSubjects = "";
                    $scope.form.mobileNo = "";
                    $scope.form.address = "";
                };
            });