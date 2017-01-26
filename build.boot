(merge-env!
  :resource-paths #{"src"}
  :dependencies   (template
                   [[org.clojure/clojure ~(clojure-version)]
                    [ring "1.5.1" :exclusions [org.clojure/clojure]]

                    [tailrecursion/boot-jetty "0.1.3" :scope "test"]
                    [ring/ring-devel "1.5.1" :scope "test"]]))

(require '[tailrecursion.boot-jetty :refer [serve]])

(task-options!
 uber {:as-jars true}
 war  {:file "app.war"})

(deftask dev
  "Local dev task. Starts repl server and reloads Clojure on request."
  []
  (comp
   (repl :server true)
   (web :serve 'boot-war-example.core-dev/serve)
   (serve :port 8000)
   (wait)))

(deftask build-war
  "Build the target/app.war file"
  []
  (comp
   (web :serve 'boot-war-example.core/serve)
   (uber)
   (war :file "app.war")
   (sift :include [#"app.war"])
   (target)))
