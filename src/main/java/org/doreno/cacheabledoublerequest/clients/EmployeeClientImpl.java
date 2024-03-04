package org.doreno.cacheabledoublerequest.clients;


import org.doreno.cacheabledoublerequest.clients.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeClientImpl {
    private String baseUrl;
    protected static final String EMP_ENDPOINT = "/v1/Employees";

    public EmployeeClientImpl(@Value("${external.api.url}") String url) {
        baseUrl = url;
    }

    @Cacheable(value = "employees")
    public Flux<Employee> findEmployee(Integer empId) {

        return WebClient.create(baseUrl).get()
                .uri(uriBuilder -> uriBuilder.path(EMP_ENDPOINT).queryParam("empId", empId)
                        .build()).retrieve().bodyToFlux(Employee.class);
    }
}

