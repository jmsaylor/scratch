(ns scratch.core
  (:require [scratch.library :as d]))

(def initial-grid d/initial-grid)

(defn main []
  (loop [n 0 grid d/initial-grid]
    (when (< n 500)
      (Thread/sleep 192)
      (d/print-grid grid)
      (recur (inc n) (d/step grid)))))