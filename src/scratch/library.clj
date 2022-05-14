(ns scratch.library)

(defn rabo [x] (+ x 2))

(defn yabo [x] (+ x 3))

(defn yapo [[x y]]
    (println x y)
    (Thread/sleep 100)
    (if (< x 2000)
    (recur [(zabo x) (zayo y)])))
  
  (defn rapo [x] (yapo [x x]))