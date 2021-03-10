package com.desen.hscastro.envio;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class MessageEnvioKafka {
	
	//envia uma mensagem para algum receptor receber via kafa,...
	public static void envioDaMensagem() {
		//cria um objeto do tipo Properties
		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		try(KafkaProducer<String, String> producer = new KafkaProducer<>(properties)){
			ProducerRecord<String, String> record = new ProducerRecord<String, String>("helloworld",
					"Olá, bem vindos ao mundo das mensagerias");			
			//envio da mensagem
			producer.send(record);
		}		
	}

	public static void main(String[] args) {
		//Chama o método de envio da mensagem
		envioDaMensagem();
	}

}
