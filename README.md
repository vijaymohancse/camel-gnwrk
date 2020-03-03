#camel-gnwrk

This repository addresses the ground work accomplished to understand the Core concepts of Apache Camel using Spring DSL. Below are the use cases implemented as part of this exercise.

1. Create rest endpoint in camel route which will accept json as request body, than call another POST REST API through camel and log it's response.
2. Create route which will poll file from directory A and place into directory B.
3. Create route to poll zip files from directory, than unzip each zip file and place each unzipped file into directory B.
4. Create cron triggered route which will run on every minute and call other REST API.
5. Create route to consume message from ActiveMQ (QUEUE_A) and push into QUEUE_B.
6. Create route which will poll only xml files from directory A, than parse each xml file parallelly.
7. Implement exception handling into all above created routes by using onException or doTry{}|doCatch()