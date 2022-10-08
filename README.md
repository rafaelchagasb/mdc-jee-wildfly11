# MDC to tracing logs - JEE Wildfly 11 

## How do I run?

1 Compile project

```mvn package```

2 Configure your standalone(wildfly/jboss). Add tag to print your correlation-id

```xml
<subsystem xmlns="urn:jboss:domain:logging:3.0">
    ...
    <formatter name="PATTERN">
        <pattern-formatter pattern="%d{yyyy-MM-dd HH:mm:ss,SSS} %-5p [%c] (%t) [CORRELATION-ID:%X{correlation-id}] %s%e%n"/>
    </formatter>
    <formatter name="COLOR-PATTERN">
        <pattern-formatter pattern="%K{level}%d{HH:mm:ss,SSS} %-5p [%c] (%t) [CORRELATION-ID:%X{correlation-id}] %s%e%n"/>
    </formatter>
</subsystem>
```

3 Deploy war and run Jboss

```run jboss```


## How do I test?

Send a request

```shell
curl --location --request GET 'http://localhost:8080/mdc-jee-wildfly11/api/hello/Mart'
```

Open logs

```
13:27:58,811 INFO  [HelloResource] (default task-2) [CORRELATION-ID:6452d09a-1cf6-437a-8abb-a550bac46fed] Hello: 

13:27:58,849 INFO  [Service] (default task-2) [CORRELATION-ID:6452d09a-1cf6-437a-8abb-a550bac46fed] Service running
```

For provided tracing between endpoints you can send value in header

```shell
curl --location --request GET 'http://localhost:8080/mdc-jee-wildfly11/api/hello/Mart' --header 'correlation-id: custom-e93de11b-91ee-4aed-bc9d-d61042dba4bc'
```