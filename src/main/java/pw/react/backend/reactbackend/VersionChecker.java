package pw.react.backend.reactbackend;

import org.springframework.core.SpringVersion;

public class VersionChecker {
    public static void main(String [] args)
    {
        System.out.println("version: " + SpringVersion.getVersion());
        //result was version: 5.1.10.RELEASE
        //soooo https://docs.spring.io/spring/docs/5.1.10.RELEASE/spring-framework-reference/
    }
}