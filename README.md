# robot-app
robot-app is a robot application developed using spring-boot.

# Installation
mvn clean install

Run App.class as java application.

# APIs
/robot/api/batteryRemaining?kms=1&load=12

Returns the battery remaining status.

Method: GET

/robot/api/batteryLowIndicator

Returns a boolean value for low battery. 

Method: GET
