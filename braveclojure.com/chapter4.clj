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

;; Polymorphisomic functions?
;; Arity overloading.
(defn call-me
  ([x]
  (str "I was only called with one param, " x))
  ([x y]
  (str "Now having " x " I also have " y)))

(call-me 4)
(call-me 4 "another second param")

;; map, first, rest, cons
(seq '(1 2 3 4))
(seq [1 2 3 4])
(seq {:name "Rakib" :age 28})
(into {} (seq {:name "Rakib" :age 28}))
(first (seq [1 2 3 4]))
(get [1 2 3 4 5] 3)

(defn rest-func
  [[x & rest]]
  (seq rest))

(rest-func [1 2 3 4 5])

;; Seq Function Examples
;; If you’re new to Lisp and functional programming, these examples will be surprising and delightful.
;;
(def subjects ["math", "english", "science", "religion"])
(def student1 [90, 33, 95, 80])
(def student2 [98, 93, 95, 80])

(defn result-card
  [subject number]
  {:subject subject
   :number number})

(map result-card subjects student1)

;;
(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))

(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))

(stats [1 2 3 4])

;; getting dictionary data
(def students
  [{:first-name "Rakibul" :last-name "Hasan" :roll 1}
   {:first-name "Rohid" :last-name "Hasan" :roll 2}])

(map :first-name students)

;;
;; Reduce
;;
(reduce + [1 2 3 4])

;; make a total bill invoice for a resurant order
(def bill
  [{:item "platter"    :price 100}
   {:item "meat-bull"  :price 150}
   {:item "lemonade"   :price 45}])

;; forget to add a bill for the coffee??
(defn update-bill
  [new-item]
  (conj bill new-item))

(update-bill {:item "coffee" :price 67}) ;; ??
(update-bill {:item "parota" :price 71}) ;; not adding to the final bill???

(println bill)

(def total-price
  (reduce
   (fn [init {:keys [price]}]
     (+ init price))
   0
   bill))
(println "Total price:" total-price)

;; (def total-price
;;   (reduce
;;    (fn [init {:keys [price]}]
;;      (+ init price))
;;    0
;;    [{:item "coffee" :price 30}
;;     {:item "parota" :price 43}]))
;; (println "Total price:" total-price)



(def data
  [{:name "Alice" :age 25}
   {:name "Bob" :age 30}
   {:name "Charlie" :age 35}])

(defn sum-ages [total-map current-map]
  (update total-map :age + (:age current-map)))

(def total-age (reduce sum-ages {:age 0} data))

(println "Total age:" (:age total-age))
