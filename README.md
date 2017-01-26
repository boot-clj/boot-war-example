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

## Develop locally

Start a REPL server and local web server:

    boot dev
    
Visit [http://localhost:8080/](http://localhost:8080/)

You should be able to make changes to `src/boot_war_example/core.clj` and reload
the browser and see your changes take effect.

You can also connect to the running server's JVM in a repl with `boot repl -c`
in the project directory.
