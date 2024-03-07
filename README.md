# Consumer

## This microservice is responsible for consuming messages from Kafka 📬, creating users, and saving them to a PostgreSQL database 🗃️.

* If you don't have PostgreSQL installed, you can find installation instructions [here](https://www.postgresql.org/download/).

* Ensure that the Kafka environment is set up. If not, follow the [instructions here](https://kafka.apache.org/quickstart).

### Alternatively, use the *following* scripts

* STEP 1: GET KAFKA
```
 $ tar -xzf kafka_2.13-3.7.0.tgz
 $ cd kafka_2.13-3.7.0
```

* STEP 2: START THE KAFKA ENVIRONMENT

  Apache Kafka can be started using ZooKeeper. Run the following commands in order to start all services in the correct order:

*Start the ZooKeeper service*
```
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```

Open another terminal session and run:

*Start the Kafka broker service*
```
$ bin/kafka-server-start.sh config/server.properties
```

Once all services have successfully launched, you will have a basic Kafka environment running and ready to use.

## Usage

To run the application, you need to pass variables to the `.env` file as done in the `.env.example` file.

The application runs on port 8082.

* **Kafka Topics**

  The microservice listens to the Kafka topic named `user_Topic`. Ensure that the topic exists in your Kafka environment.

  *! to check the availability of a topic, use this script*

````
$ bin/kafka-console-consumer.sh --topic user_Topic --from-beginning --bootstrap-server localhost:9092
````
* **PostgreSQL Database**

  The application connects to a PostgreSQL database. Ensure that you have created a database and updated the `.env` file with the correct database URL, username, and password.


This will start the consumer microservice, and it will begin consuming messages from the Kafka topic, creating users, and saving them to the PostgreSQL database.