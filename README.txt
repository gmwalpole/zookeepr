Final Project:

ZooKeepr

ZooKeepr is a proof of concept application that keeps track animals and animal enclosures. 
The application is meant to be a single user application without login, registration, or security. 



////////////////////////////////////////INSTALLATION//////////////////////////////////////////

ZooKeepr uses a PostGres database and needs to have one set up before it may be run successfully.

A SQL script to create the database, named 'db_create.sql', should 
be located in the same folder as this README.

In postgres, open your server, click on the postgres database, then in the top menu, select 
Tools => Scripts => CREATE.  A SQL input window will appear. Replace the contents of this window with the 
contents of the db_create.sql file, and Execute Query. (The leftmost green triangle in the second top 
menu icons)

This should create the database to specifications. You may need to refresh before it will appear.


A SQL script to populate the database with test data, named 'db_populate.sql', should 
be located in the same folder as this README.

In postgres, click on the finalproject database, then in the top icon menu, select Execute Arbitrary SQL queries.
(The magnifying glass with "SQL" in it.) A SQL input window will appear. Copy the contents of the db_populate.sql 
file into this window, and Execute Query. (The leftmost green triangle in the second top menu icons)

This should add and populate all the tables to specification.


To run Zookeepr once you have successfully created the database, open Eclipse, right-click the Project or Package 
Explorer, and select Import. In the new window that appears, select Existing Maven Project. Click Browse, navigate to the 
finalproject folder (if the only folder in finalproject is also finalproject, navigate to that folder) and hit OK, and 
Finish.

Once the project is in eclipse, open it, open 'src', open 'main.java.com.catalyst.springboot', right-click AppRunner.java, 
select 'Run As', and select 'Java Application'. This will run the local server, and when it finishes, going to 
"localhost:8080" in your web browser will open ZooKeepr.