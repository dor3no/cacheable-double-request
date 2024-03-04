package org.doreno.cacheabledoublerequest;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.doreno.cacheabledoublerequest.clients.EmployeeClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheableDoubleRequestApplication implements CommandLineRunner {
    @Autowired
    EmployeeClientImpl empClient;
    private MockWebServer mockWebServer;

    public static void main(String[] args) {
        SpringApplication.run(CacheableDoubleRequestApplication.class, args).close();
    }

    @Override
    public void run(String... args) throws Exception {
        mockWebServer = new MockWebServer();
        mockWebServer.start(7070);

        mockWebServer.enqueue(new MockResponse().setResponseCode(200)
                .setHeader("content-type", "application/json").setBody("{\"EmployeeID\": 12345}"));
        mockWebServer.enqueue(new MockResponse().setResponseCode(200)
                .setHeader("content-type", "application/json").setBody("{\"EmployeeID\": 12345}"));

        empClient.findEmployee(12345).blockLast();

        mockWebServer.shutdown();
    }
}
