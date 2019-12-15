# Tweet_Analysis

SpringBoot Web Application
Befoe running the application
Please create MySql database in local machine named : tweet_app 

default user email : test@test.com
          password : test@123

End points : Please use postman app to verify endpoints
1. SignUp : method type :- post 
    http://localhost:8080/users
    
    1.1 : parameters in postman Header
          Content-Type : application/x-www-form-urlencoded
          Accept : application/json
    1.2 : parameters in Body raw
          {
           "firstname":"your first name",
           "lastname":"your last name",
           "email":"your email",
           "password":"password of your choice"
          }
    
2. Login : method type :- post 
    http://localhost:8080/users/login
    
    2.1 : parameters in postman Header
          Content-Type : application/json
          Accept : application/json
    2.2 : parameters in Body raw
          {
           "email":"your email",
           "password":"password"
          }
          
3. search tweet API :

    before using this api please provide value for :  twitter-api-key= 
                                                      twitter-api-secret-key=
                                                      twitter-api-access-token=
                                                      twitter-api-access-token-secret=
                                                in "application.properties" file and run project again.
    http://localhost:8080/v1/tweet/search
    
    3.1 : parameters in postman Header
          Authorization : Bearer Token (please find Bearer token from login response header after login)
          Accept : application/json
    3.2 : parameters in param field
          hashTag : value (eg. cricket) Or you can directly type - http://localhost:8080/v1/tweet/search?hashTag=cricket
          
          
