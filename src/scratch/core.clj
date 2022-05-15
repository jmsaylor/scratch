(ns scratch.core
  (:require [scratch.library :as d]))

(def initial-grid d/initial-grid)

(defn tester [] (d/get-random-direction))

(defn main []
  (loop [n 0 grid d/initial-grid]
    (when (< n 2000)
      (Thread/sleep 1000)
      (d/print-grid grid)
      (recur (inc n) (d/draw (d/get-random-direction) grid)))))