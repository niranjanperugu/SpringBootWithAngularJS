<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TutorRegistration Form</title>
<script src="angular.js"></script>
        <script type="text/javascript" src="app.js">
        
        </script>
          <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body ng-app="MyTutorManagement" ng-controller="TutorManagementController">
<h1>Tutor Form</h1>
    <form ng-submit="submitTutorData()">
        <table>
        
        <!--  <tr>
                    <td>Id</td>
                    <td><input type="text" ng-model="form.Id" size="60" /></td>
                </tr> -->
               
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Age</th>
                <th>Qualification</th>
                <th>TeachingSubjects</th>
                <th>Mobile</th>
                <th>Address</th>
                 <th>Action</th>
            </tr>
 

            <tr ng-repeat="tutor in tutors">
                <td>{{ tutor.name }}</td>
                <td>{{ tutor.email }}</td>
                <td>{{ tutor.age }}</td>
                <td>{{ tutor.qualification }}</td>
                <td>{{ tutor.teachingSubjects }}</td>
                <td>{{ tutor.mobileNo }}</td>
                 <td>{{ tutor.address }}</td>
                <td><a ng-click="editTutor( tutor )" class="button">Edit</a> | <a ng-click="removeTutor( tutor )" class="button">Remove</a></td>
            </tr>
 
        </table>
 
             <table>   
                <tr>
                    <td>TutorName</td>
                    <td><input type="text" ng-model="form.name" size="60" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" ng-model="form.email" size="60" /></td>
                </tr>
                <tr>
                    <td>Age</td>
                    <td><input type="text" ng-model="form.age" size="60" /></td>
                </tr>
                <tr>
                    <td>Qualification</td>
                    <td><input type="text" ng-model="form.qualification" size="60" /></td>
                </tr>
                  <tr>
                    <td>TeachingSubjects</td>
                    <td><input type="text" ng-model="form.teachingSubjects" size="60" /></td>
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
        <p />
        
    </form>
</body>
</html>