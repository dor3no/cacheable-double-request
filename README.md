# cacheable-double-request

Run application with `mvn spring-boot:run`

Check logs: HTTP request is submitted twice:
```
2024-03-05T10:21:45.721-05:00 TRACE 3096 --- [           main] o.s.cache.interceptor.CacheInterceptor   : No cache entry for key '12345' in cache(s) [employees]
2024-03-05T10:21:45.757-05:00 DEBUG 3096 --- [           main] o.s.w.r.f.client.ExchangeFunctions       : [7d97e06c] HTTP GET http://localhost:7070/v1/Employees?empId=12345
2024-03-05T10:21:45.858-05:00 DEBUG 3096 --- [           main] o.s.w.r.f.client.ExchangeFunctions       : [7d97e06c] HTTP GET http://localhost:7070/v1/Employees?empId=12345
2024-03-05T10:21:45.912-05:00 DEBUG 3096 --- [ctor-http-nio-3] o.s.w.r.f.client.ExchangeFunctions       : [7d97e06c] [41d1d49a-1] Response 200 OK
2024-03-05T10:21:45.912-05:00 DEBUG 3096 --- [ctor-http-nio-4] o.s.w.r.f.client.ExchangeFunctions       : [7d97e06c] [7b479588-1] Response 200 OK
2024-03-05T10:21:45.941-05:00 TRACE 3096 --- [ctor-http-nio-3] o.s.cache.interceptor.CacheInterceptor   : Creating cache entry for key '12345' in cache(s) [employees]
```
