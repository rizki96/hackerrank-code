(defn fibonacci [n] 
    (when (> n 0)
        (if (= n 1)
            0
            (if (= n 2)
                1
                (when (> n 2)
                    (+ (fibonacci (- n 1)) (fibonacci (- n 2))) 
                )
            )
        )
    )
)

(let [
    num (read-line)
    n (Integer/parseInt num)]
    (println (fibonacci n))
)
