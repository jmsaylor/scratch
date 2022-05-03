(ns scratch.core
  (:require [scratch.library :as lib]))

(def zabo lib/rabo)
(def zayo lib/yabo)

(defn yapo [[x y]]
  (println x y)
  (Thread/sleep 100)
  (if (< x 2000)
  (recur [(zabo x) (zayo y)])))

(defn rapo [x] (yapo [x x]))
