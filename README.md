# Zensar Apigee Demo

The application is a Spring boot MVC application. It returns products which have prices reduction.

URI: /categories/{category}/reduced-products?labelType=:labelType
Request Method: GET
Content Type: Application/json

labelType can be one of (ShowWasNow, ShowWasThenNow, ShowPercDscount)



For creating jar file and executing it ...
### Step 1:
Create a clone of git repository on your machine <br/>
`git clone https://github.com/alibaseit/zensar-apigee-demo.git`

### Step 2:
Create a runnable jar by using maven. <br/>
`mvn package`
<br/>
Jar file is going to be created under target directory.

### Step 3:
Run the application. <br/>
`java -jar target/zensar-apigee-demo.jar`


### Step 4:

from Browser http://localhost:8080/categories/600001506/reduced-products?labelType=ShowWasThenNow

or with curl tool

curl http://localhost:8080/categories/600001506/reduced-products?labelType=ShowWasThenNow |json_pp
