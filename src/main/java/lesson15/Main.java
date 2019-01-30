package lesson15;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/mate", new MateGroupServiceImpl());
    }
}
