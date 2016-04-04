(defn fac [num]
    (when (> num 0)
        (if (< num 2)
            1
            (if (= num 2)
                2
                (* num (fac (- num 1)))
            )
        )
    )
)

(defn pascal-elem [row column]
    (let [n row r column]
        (/ (fac n) (* (fac r) (fac (- n r) )))
    )
)

(defn pascal-triangle [num]
    (loop [a0 0 res []]
        (if (< a0 num)
            (if (= a0 0) (recur (+ a0 1) (conj res [1]))
                (if (= a0 1) (recur (+ a0 1) (conj res [1 1]))
                    (if (> a0 1) 
                        (recur (+ a0 1) (conj res (loop [a1 1 res1 [1]] (if (< a1 a0) (recur (+ a1 1) (assoc res1 a1 (pascal-elem a0 a1))) (conj res1 1) ))) )
                        res
                    )
                )
            )
            res
        )
    )
)

(let [
    n (read-line)
    num (Integer/parseInt n)
    ]
    (doseq [i (pascal-triangle num)] (println (clojure.string/join " " i)))
)
