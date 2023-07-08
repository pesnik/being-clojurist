(ns chapter4)
;; Core Functions in Depth

(defn incrementer
  "This function will increment each entry of the sequence"
  [x]
  (inc x))

(defn multiply-by-two
  "This function will multiply each sequence entry by 2"
  [x]
  (* x 2))

(map incrementer [1 2 3 4 5])
(map multiply-by-two [1 2 3 4 5])

;; Adding a higher order function to take a seq and inc each by 1 and
;; multipy by dynamic input value

(defn increment-then-multiply
  [x]
  #(map (fn [incremented-number] (* incremented-number %)) (map inc x)))

(def itm-by-val (increment-then-multiply [1 2 3 4 5]))
(itm-by-val 4)
(itm-by-val 6)
