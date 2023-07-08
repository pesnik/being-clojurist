;; 1. Use the str, vector, list, hash-map, and hash-set functions.

;; str
(str "Hello" ", World!")
(let [name "Rakib"]
  (str "Hello " name))

(defn even-odd
  "This function identifies a number whether even or odd"
  [number]
  (if (= (mod number 2) 0)
    (str number " is Even")
    (str number " is Odd")))

(even-odd 48)
(even-odd 45)
