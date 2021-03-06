(ns frodo.main
  (:gen-class)
  (:require [clojure.java.io :as io]
            [nomad :refer [defconfig]]
            [frodo.core :refer [init-frodo!]])
  (:import [java.util.jar Manifest]))

(defn frodo-config-location []
  (slurp (io/resource "META-INF/frodo-config-resource")))

(defn -main [& [config-file & args]]
  (let [config-resource (or (when config-file
                              (io/file config-file))
                            (io/resource (frodo-config-location)))]
    (init-frodo! config-resource)))
