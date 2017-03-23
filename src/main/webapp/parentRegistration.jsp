<!doctype html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>
            Parents Registration Form
        </title>
        <!-- Load AngularJS -->
        <script src="angular.js"></script>
        <script type="text/javascript" src="app.js">
        
        </script>
          <link rel="stylesheet" type="text/css" href="style.css">
        
    <head>
    <body ng-app="MyTutorManagement" ng-controller="ParentManagementController">
         <h1>
            Parents Registration Form
        </h1>
 
        <table>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Student Name</th>
                <th>Relation</th>
                <th>Student Qualification</th>
                <th>Intrested Subjects</th>
                <th>Mobile</th>
                <th>Address</th>
                 <th>Action</th>
            </tr>
 

            <tr ng-repeat="parent in parents">
                <td>{{ parent.name }}</td>
                <td>{{ parent.email }}</td>
                <td>{{ parent.studentName }}</td>
                <td>{{ parent.relation }}</td>
                <td>{{ parent.studentQualification }}</td>
                <td>{{ parent.intrestedSubjects }}</td>
                <td>{{ parent.mobileNo }}</td>
                 <td>{{ parent.address }}</td>
                <td><a ng-click="editParent( parent )" class="button">Edit</a> | <a ng-click="removeParent( parent )" class="button">Remove</a></td>
            </tr>
 
        </table>
 
        <h2>Register or Update</h2>
 
        <form ng-submit="submitParentData()">
            <table>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" ng-model="form.name" size="60" /></td>
                </tr>
                
                <tr>
                    <td>Email</td>
                    <td><input type="text" ng-model="form.email" size="60" /></td>
                </tr>
                <tr>
                    <td>Student Name</td>
                    <td><input type="text" ng-model="form.studentName" size="60" /></td>
                </tr>
                <tr>
                    <td>Relation</td>
                    <td><input type="text" ng-model="form.relation" size="60" /></td>
                </tr>
                <tr>
                    <td>Student Qualification</td>
                    <td><input type="text" ng-model="form.studentQualification" size="60" /></td>
                </tr>
                  <tr>
                    <td>Subjects</td>
                    <td><input type="text" ng-model="form.intrestedSubjects" size="60" /></td>
                </tr>
                <tr>
                    <td>Mobile No</td>
                    <td><input type="text" ng-model="form.mobileNo" size="60" /></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" ng-model="form.address" size="60" /></td>
                </tr>
    			 <tr>
                    <td colspan="2"><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form>
 
    </body>
</html>