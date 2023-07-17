(ns pegthing-with-hints.core
  (:gen-class))

(defn gen-triangular-number
  ([] (gen-triangular-number 0 1))
  ([sum n]
   (let [new-sum (+ sum n)]
     (cons new-sum (lazy-seq (gen-triangular-number new-sum (inc n)))))))

(def triangular-number (gen-triangular-number))

(defn get-nth-triangular-number
  [n]
  (last (take n triangular-number)))

;; Test get-nth-triangular-number
;; (get-nth-triangular-number 5)

(defn connect-right
  [board max-pos pos])
(defn connect-down-left
  [board max-pos pos])
(defn connect-down-right
  [board max-pos pos])

(defn peg-positioning
  [board max-pos pos]
  (let [pegged-board (assoc-in board [pos :pegged] true)]
    (reduce (fn [new-board connector] (connector new-board max-pos pos))
            pegged-board
            [connect-right connect-down-left connect-down-right])))

(defn get-board
  [rows]
  (let [initial-board {:rows rows}
        max-pos (get-nth-triangular-number rows)]
    (reduce (fn [board pos] (peg-positioning board max-pos pos))
            initial-board
            (range 1 (inc max-pos)))))

(defn print-board
  [board]
  (println "Printing board" board))

(defn initial-board-setup
  [rows]
  (let [board (get-board rows)]
    (print-board board)))

(defn -main
  [& args]
  (println "Enter number of rows you want to start with:")
  (let [rows (Integer/parseInt (read-line))]
    (initial-board-setup rows)))
