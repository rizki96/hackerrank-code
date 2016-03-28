; https://www.hackerrank.com/challenges/lonely-integer
(require '[clojure.string :as str])
(def array-of-ints 
    (fn [string]
        (str/split string #" ")
    )
)
(defn min-number-count [string size]
    (first (last (reduce-kv (fn [m k v] (if (or (= {} m) (< v (second (last m)) )) (assoc {} k v) m) ) {}
    (into {} 
        (map #(identity {(str "" %) (count (re-seq (java.util.regex.Pattern/compile (str "" %)) string))})
            (array-of-ints string)
        )
    ))))
)
(println (let [size (read-line)] (let [stream (read-line)] (min-number-count stream size))))
