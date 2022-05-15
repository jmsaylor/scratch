(ns scratch.core)

(defn tester [x] x)

(def initial-grid (vec (repeat 3 (vec (repeat 3 0)))))

(defn swap-it [x] (if (= x 0) 1 0))

(defn swap-row [row] (let [[a b c] row] [(swap-it a) (swap-it b) (swap-it c)]))

(defn draw [direction grid]
  (let [[a b c] grid]
    (case direction
      :h-top [(swap-row a) b c]
      :h-middle [a (swap-row b) c]
      :h-bottom [a b (swap-row c)])))

(defn draw-horizontal-top [grid]
  (let [[a b c] grid]
    [(swap-row a) b c]))

(defn draw-horizontal-middle [grid]
  (let [[a b c] grid]
    [a (swap-row b) c]))

;; (defn draw-horizontal-middle [grid]
;;   (let [[[a b c] [d e f] [g h i]] grid]
;;     [[a b c]
;;      [(swap-it d) (swap-it e) (swap-it f)]
;;      [g h i]]))

;;      (defn draw-horizontal-middle [grid]
;;       (let [[[a b c] [d e f] [g h i]] grid]
;;         [[a b c]
;;          [(swap-it d) (swap-it e) (swap-it f)]
;;          [g h i]]))
;; (defn draw-top [grid]
;;   (vec
;;    ((vec ((swap-it (get grid 0 0)) (swap-it (get grid 0 1)) (swap-it (get grid 0 2))))
;;     (vec (get grid 1))
;;     (vec (get grid 2)))))

(defn print-square [square]
  (loop [n 0]
    (when (< n 3)
      (println (nth square n))
      (recur (inc n)))))
