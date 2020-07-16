package gettingstarted;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringContentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringContentApplication.class, args);
	}

	@Component
	public static class MyRunner implements CommandLineRunner {

		private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

		@Autowired
		private FileRepository repository;

		@Autowired FileContentStore store;

		@Override
		public void run(String... args) throws Exception {

			File f = repository.save(new File());
			f = store.setContent(f, this.getClass().getResourceAsStream("/symphony.mp3"));
			f = repository.save(f);
		}
	}
}
