# boot-war-example

Example of an uberwar kind of thing.

## Test with jetty runner

Build the war:

    boot build-war

Download [jetty-runner](http://central.maven.org/maven2/org/eclipse/jetty/jetty-runner/9.4.1.v20170120/jetty-runner-9.4.1.v20170120.jar):

    curl -o jetty-runner.jar http://central.maven.org/maven2/org/eclipse/jetty/jetty-runner/9.4.1.v20170120/jetty-runner-9.4.1.v20170120.jar
    
Run the war:

    java -jar jetty-runner.jar target/app.war

Visit [http://localhost:8080/](http://localhost:8080/)
