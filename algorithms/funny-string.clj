; https://www.hackerrank.com/challenges/funny-string
(defn input-strings [t]
    (loop [a0 t res []]
        (if (> a0 0)
             (let [word (read-line)] (recur (- a0 1) (conj res word)))
             res
        )
    )
)

(defn abs [v] (max v (- v)))

(defn funny-string [string]
    (into [] (reverse 
        (loop [a0 (.length string) res []] 
            (if (> a0 1) 
                (recur (- a0 1) 
                    (conj res 
                        (=
                            (abs (- (int (nth string (+ (- (.length string) a0) 1) )) (int (nth string (- (- (.length string) a0) 0) ))))
                            (abs (- (int (nth string (- a0 1) )) (int (nth string (- a0 2) )) ))
                        )
                    )
                ) 
                res 
            )
        )
    ))
)

(let [
        t (Integer/parseInt (read-line))
    ]
    (doseq [i (reduce (fn [res v] (conj res (every? identity v)) ) [] (map funny-string (input-strings t)))] (if i (println "Funny") (println "Not Funny")))
)
