; https://www.hackerrank.com/challenges/anagram
(defn input-strings [t]
    (loop [a0 t res []]
        (if (> a0 0)
             (let [word (read-line)] (recur (- a0 1) (conj res word)))
             res
        )
    )
)

(defn char-count [string]
    (let [half-len (/ (.length string) 2)] 
        (when (= (mod (.length string) 2) 0)
            (loop [a0 half-len res []]
                (if (> a0 0) 
                    (recur (- a0 1) 
                        (if (get res (nth string (dec (+ a0 half-len)))) 
                            (into {} (conj res (identity {(nth string (dec (+ a0 half-len))) (inc (get res (nth string (dec (+ a0 half-len)))))})))
                            (into {} (conj res (identity {(nth string (dec (+ a0 half-len))) 1})))
                        )
                    )
                    res
                )
            )
        )            
    )
)

(defn replace-char-anagram [string]
    (let [half-len (/ (.length string) 2)]
        (- (if (= (mod (.length string) 2) 0) half-len -1) 
            (reduce 
                (fn [res c] 
                    (let [first-half-count (count (re-seq (java.util.regex.Pattern/compile (str "" (first c))) (subs string 0 half-len))) ] 
                        (+ res (if (< first-half-count (second c)) first-half-count (second c) ) ) 
                    )
                ) 
                0 
                (char-count string)
            ) 
        )
    )
)

(let [
        t (Integer/parseInt (read-line))
    ]
    
    (doseq [i (map replace-char-anagram (input-strings t))] (println i))
)
