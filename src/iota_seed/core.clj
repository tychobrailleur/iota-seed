(ns iota-seed.core
  (:require [clojure.string :as str])
  (:import [java.security SecureRandom]))

(def secure-random (SecureRandom/getInstance "SHA1PRNG"))
(def iota-tryte-alphabet "ABCDEFGHIJKLMNOPQRSTUVWXYZ9")

(defn generate-seed []
  (str/join (map (fn [n] (.charAt iota-tryte-alphabet n))
              (take 81 (repeatedly #(.nextInt secure-random 27))))))

(defn -main [& _args]
  (println (generate-seed)))
