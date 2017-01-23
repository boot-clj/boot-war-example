(merge-env!
  :resource-paths #{"src"}
  :dependencies   (template
                   [[org.clojure/clojure ~(clojure-version)]
                    [ring "1.5.1" :exclusions [org.clojure/clojure]]]))

(task-options!
 uber {:as-jars true}
 web  {:serve 'boot-war-example.core/serve}
 war  {:file "app.war"})

(deftask build-war
  "Build the target/app.war file"
  []
  (comp
   (web)
   (uber)
   (war :file "app.war")
   (sift :include [#"app.war"])
   (target)))
