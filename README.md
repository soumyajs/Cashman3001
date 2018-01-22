# Cashman3001
This is a cash dispensing application for use in an ATM or similar device.  There is no need to request authorisation or availability of funds. The application should assume that all requests are legitimate; there will be other components of the system that will do things such as communicating with bank accounts and authorising withdrawals.

Assumptions:

1. This application has been developed using the following<br/>
a. IDE: Eclipse Neon.3 Release (4.6.3)<br/>
b. Framework :  Spring MVC 3.2.13.RELEAS<br/>
c. UI : Bootstrap v3.3.4<br/>
d. Build Tool : Maven<br/>
e. Deployment Environment: WebSphere Application Server Liberty Profile<br/>
f. Package Type : WAR<br/>
g. JDK version : 1.7

2. The currency denominations used as per the supplied document
3. There is no authorisation process kept as per the instructions but a basic authentication has been provided that checks for a valid value for user id and password.
4. The initial funds has been aasumned to be 10 currency notes of each denomination and funds have been initized using a standard @PostConstruct init() method.
5. UI has been designed using Spring MVC tags and BootStrap standard styles.
6. There is no logout functionality provided.
7. No Caching or session tracking mechanism have been used.
8. Exception handling has not been used as per the industry standard due to time constraint.
9. Logger has  not been used due to time constraint.
10. Mendatory features have been achieved but few optional features could not be met due to time constraint.
11. Automated test suite could not be achieved due to time constraint.



