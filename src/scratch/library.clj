(ns scratch.library)

(defn swap-it [x] (if (= x 0) 1 0))

(def initial-grid (vec (repeat 3 (vec (repeat 3 0)))))

(defn get-random-direction [] (rand-nth [:d-up :v-right :v-middle :v-left :d-down :h-bottom :h-middle :h-top]))

(defn draw [direction grid]
  (let [[a b c] grid]
    (case direction
      :h-top [(swap-row a) b c]
      :h-middle [a (swap-row b) c]
      :h-bottom [a b (swap-row c)]
      :v-left (draw-vertical-left grid)
      :v-middle (draw-vertical-middle grid)
      :v-right (draw-vertical-right grid)
      :d-up (draw-diagonal-up grid)
      :d-down (draw-diagonal-down grid))))

(defn swap-row [row] (let [[a b c] row] [(swap-it a) (swap-it b) (swap-it c)]))

(defn draw-diagonal-up [grid]
  (let [[[a b c] [d e f] [g h i]] grid]
    [[a b (swap-it c)] [d (swap-it e) f] [(swap-it g) h i]]))

(defn draw-diagonal-down [grid]
  (let [[[a b c] [d e f] [g h i]] grid]
    [[(swap-it a) b c] [d (swap-it e) f] [g h (swap-it i)]]))

(defn draw-vertical-left [grid]
  (let [[[a b c] [d e f] [g h i]] grid]
    [[(swap-it a) b c] [(swap-it d) e f] [(swap-it g) h i]]))

(defn draw-vertical-middle [grid]
  (let [[[a b c] [d e f] [g h i]] grid]
    [[a (swap-it b) c] [d (swap-it e) f] [g (swap-it h) i]]))

(defn draw-vertical-right [grid]
  (let [[[a b c] [d e f] [g h i]] grid]
    [[a b (swap-it c)] [d e (swap-it f)] [g h (swap-it i)]]))

(defn print-grid [grid]
  (loop [n 0]
    (when (< n 3)
      (println (nth grid n))
      (recur (inc n)))))