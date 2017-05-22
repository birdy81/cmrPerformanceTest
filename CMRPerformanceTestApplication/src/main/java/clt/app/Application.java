package clt.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import clt.app.controller.TaskExecutionWorker;
import clt.app.controller.TaskRegistry;

@SpringBootApplication
public class Application {

	@Autowired
	private TaskRegistry taskRegistry;

	private final static int THREADPOOL = 100;
	
	private ExecutorService executor = Executors.newFixedThreadPool(THREADPOOL);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void controllerConnection() throws Exception {
			
		for (int i = 0; i < THREADPOOL; i++) {
			executor.execute(new TaskExecutionWorker(taskRegistry));
		}
		
	}
}