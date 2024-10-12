A simple cab-booking-backend to send asynchronous Driver Location Updates to a User using Spring Boot and Kafka

The Kafka server is hosted directly on my local machine using Zookeeper. For larger scale use, Dockerized containers to host Kafka is recommended

To test this out, head over to 
https://kafka.apache.org/quickstart

Follow the Steps 1 and 2 (Kafka with ZooKeeper), or follow these
Step 1 : download Kafka and unzip it. CD into its directory on your machine
```
tar -xzf kafka_2.13-3.8.0.tgz
cd kafka_2.13-3.8.0
```
Step 2 : launch the Zookeeper service first
```
bin/zookeeper-server-start.sh config/zookeeper.properties
```
Make sure to launch Zookeeper first, as Kafka depends on it. Kafka server is hosted on Zookeeper. 

Step 3 : Now in a new terminal tab, run Kafka server
```
bin/kafka-server-start.sh config/server.properties
```

That is all for Kafka. After this, launch the Spring Boot application that you can download from this repository

Run both the Driver-app and the User-app

I have used PostMan to send an `HTTP PUT request` to PUBLISH (or start the talking) from Driver.
For now, Randomized coordinates (which can be adapted to actual real-life coordinates in business) are sent every few seconds. You can alter the timing and the total amount of updates per each HTTP request
In practice, we would want this service to send Infinite Updates until Driver reaches User every few seconds (15-20 seconds) and accordingly reduce the frequency based to Load to adjust and make sure our app doesn't crash

Once the Driver reaches the User, this service should terminate the Location Updates and a new service can be started (based on journey destination)



Tools used : 
1. Java Spring Boot
2. Apache Kafka (for Publishing and Listening to Topics)
3. PostMan (to publish a topic via HTTP PUT request)
4. IntelliJ Idea to maintain Code and Github for versioning control
