## date 0617:

the rabbitMQ is installed by brew in my Mac

start: cd /usr/local/Cellar/rabbitmq
type: find the rabbitmq-server
: rabbitmq-server


### date 0619
for producer:
confirmCallBack: when the message is sent to Broker
returnCallBack:  when the message is failed to send to Broker(like can't find the routing key)
  to complete the above call back, first: setMandatory, second: persisting the Exchange and Queue
for consumer:
acknowledgeMode: Manual
 Acknowledge Message: channel.basicAck(tag, false)
 No Acknowledge message: channel.basicNack(tag, false, false)
    the second parameter: boolean, multiple confirm or reject base on the tag number
    the third parameter in basicNack: requeue or not

* NOTE: the consumer only concern the Queue!!! not the routing key or the Exchange!!!

for routing key:
 when binding(direct and topic), note the routing key
    ````
    BindingBuilder.bind(topicQueue).to(topicExchange).with(TOPIC_QUEUE_ROUTING_KEY);
    ````
 when sending, note the routing key 
    ````
    rabbitTemplate.convertAndSend(ExchangeAndQueue.TOPIC_EXCHANGE_NAME, "animal.grass.rabbit", e);
    ````

  