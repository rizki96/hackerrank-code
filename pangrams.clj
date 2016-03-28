(require '[clojure.string :as str])
(defn pangrams [string]
    (let [lc (str/lower-case string)]
        (reduce 
            (fn [m v] (+ m (if (> (count (re-seq (java.util.regex.Pattern/compile (str "" (first (first v)))) lc)) 0) 1 0))) 0 (into [] (map #(identity {% 0}) (seq "abcdefghijklmnopqrstuvwxyz")))
        )
    )
)

(let [
    word (read-line) 
    ]
    (println (if (< (pangrams word) 26) "not pangram" "pangram"))
)
