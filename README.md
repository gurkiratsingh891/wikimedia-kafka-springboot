# wikimedia-kafka-springboot

1. The projects consists of two modules, kafka-producer-application and kafka-consumer-database. 
2.  The kafka-producer-application module reads the events from the wikimedia recent changes and publishes them to the topic.
3.  The kafka-consumer-database module reads the messages from the kafka topic and adds them to the mysql database.
4. We have created a event handler WikimediaChangesHandler which implements the EventHandler interface, and we
    override the onmessage method and in that send the message received to the kafka topic.
5. We create an event source using the event and the url and start the event.
6. Finally our main application file implements the commandLineRunner interface to start our eventsource.

 Note1 - In order to create modules in the springboot project, we need to add this property in the parent pom file: <packaging>pom</packaging>
 
 We need to update some properties in application.properties for the kafka configuration and mysql connectivity.
