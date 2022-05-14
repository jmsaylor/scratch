(ns scratch.core)

(defn tester [x] x)

(def initial (vec (repeat 3 (vec (repeat 3 0)))))

(defn print-square [square]
  (loop [n 0]
    (when (< n 3)
      (println (nth square n))
      (recur (inc n)))))
