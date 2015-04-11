(merge-env!
  :resource-paths #{"src"}
  :dependencies   '[[ring "1.3.2"]])

(task-options!
  aot  {:all     true}
  uber {:as-jars true}
  web  {:serve   'boot-war-example.core/serve})

(deftask build-war
  "Build the uberwar file."
  []
  (comp (aot) (web) (uber) (war)))
