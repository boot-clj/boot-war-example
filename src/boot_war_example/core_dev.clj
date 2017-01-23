(ns boot-war-example.core-dev
  "DEVELOPMENT-ONLY entrypoint that wraps the application with a wrap-reload
  handler."
  (:require [boot-war-example.core :as core]
            [ring.middleware.reload :refer [wrap-reload]]
            [clojure.java.io :as io]))

(def src-dirs
  (filter #(not (.endsWith % ".jar"))
          (.split (System/getProperty "fake.class.path") ":")))

(def serve
  (-> #'core/serve
      (wrap-reload {:dirs src-dirs})))

