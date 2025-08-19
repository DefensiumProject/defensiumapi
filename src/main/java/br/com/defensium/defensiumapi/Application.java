package br.com.defensium.defensiumapi;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import br.com.defensium.defensiumapi.utility.DateUtility;

@SpringBootApplication
@RestController
@RequestMapping({ "", "/", "defensium", "defensium/" })
@EnableFeignClients(basePackages = "br.com.defensium.defensiumapi.client")
public class Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Value(value = "${spring.application.name}")
	private String application;

	@Value(value = "${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping
	public Map<String, String> api() throws UnknownHostException {
		InetAddress inet = InetAddress.getLocalHost();
		Map<String, String> information = new LinkedHashMap<>();
			information.put("Application", application);
			information.put("Port", port);
			information.put("Version", "v1.1.10");
			information.put("Issue", DateUtility.getIssue());
			information.put("Build", DateUtility.getDataHoraAtualFormatada());
			information.put("Environment", "Desenvolvimento");
			information.put("Server", System.getProperty("os.name"));
			information.put("IP", inet.getHostAddress());
		return information;
	}

	@Override
	public void run(String... args) throws Exception {
		Map<String, String> information = api();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		log.warn(objectMapper.writeValueAsString(information));
	}

}
