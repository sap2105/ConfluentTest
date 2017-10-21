# Feed API

<h6> This project is a simple Feed API. It is developed as a JAX-WS service using Jersey.</h6>

<h2>Requirements</h2>
1) Eclipse (JEE Version)</br>
2) Tomcat Server 7.0</br>
3) WAMP server with MySQL 5.7</br>
4) Postman (for sending HTTP Requests)</br>

<h2>Running the project</h2>
<h4>1. Clone the repository.</h4>
<p>Initialise a local folder with <b>git init</b> command from your command prompt or terminal.</p>
<p> Then run command <b>git clone https://github.com/sap2105/ConfluentTest.git </b></p></br>
<h4>2. Import the project into Eclipse as a Maven Project.</h4>
<p>Download and Install the latest version of Eclipse and run it. Select your workspace.</p>
<p>Now go to <b>FILE --> Import --> Maven --> Existing Maven Projects</b>. Then select the directory where you cloned this project, check mark <b>Add projects to Working set</b>. Click <b>Finish</b></p></br>
<h4>3. Setup Tomcat Server in Eclipse.</h4>
<p>Go to <b>Servers</b> tab in the bottom centre of the screen. Click on the link to setup the server.</p>
<p>Go to <b>Apache-->Tomcatv7.0 Server-->Next-->Install server (runs in background)-->Give path where it got installed-->Next-->Select project from Available section -->Click ADD>-->Finish</b></p></br>
<h4>4. Create Schema by running the confluenttest.sql file on WAMP PHPMYADMIN.</h4>
<p><b>Open WAMP --> Click on Start All Services</b></p>
<p>Once the WAMP Sign turns green cick on it and Open phpMyAdmin. Then login using your credentials. Click on Database and then create a new database. Select collation as 'utf8_general_ci'.</p>
<p>Now click on the new database. Then <b>Go to Export-->Browse (select the confluenttest.sql file from your pc)-->Go</b>. You will find that all the tables are created along with the example Data.</p></br>
<h4>5. Change the DbConnections.java file to match with your credentials.</h4>
<p>Open DbConnections.java file. Insert your new <b>DATABASE_NAME, USERNAME, PASSOWRD</b></p></br>
<h4>6. Run the project on server.</h4>
<p>To run this project <b>Right click on the project-->Run As--> Run on Server</b>. Wait for the server to start and initialise.</p></br>
<h4>7. Use Postman to send HTTP Requets.</h4>
<p>Open Postman and start running the tests that are listed in the Tests.txt file. To verify the results you can check the changes on your Database and also refer to screenshots from the Explanation.pdf file.</p></br>
<h4>8. A few Tests are included in the Tests.txt file.</h4></br>

<h6>Please refer to the Explanation.pdf file to understand the assumptions and get screenshots of the tests performed.</h6>
<h6>You may get an error when you import the project into Eclipse which will say "JSP Problem". However, this will not stop you from running this project successfully.</h6>
