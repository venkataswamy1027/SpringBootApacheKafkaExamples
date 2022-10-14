# SpringBootApacheKafkaExamples

What is Apache Kafka exactly? It is a powerful publish-subscribe messaging system that not only ensures speed, scalability, 
and durability but also stores and processes streams of records. Its unique design allows us to send and listen to messages in real-time.

# Apache Kafka uses 5 components to process messages:
.Topic contains records or a collection of messages.
.Producer publishes messages to a topic or topics.
.Consumer subscribes to topics, reads, and processes messages from the topics. It is basically a listener.
.Broker manages the storage of messages in the topics. If there is more than one broker, it is called Cluster.
.ZooKeeper tracks the status of cluster nodes, topics, partitions, etc.