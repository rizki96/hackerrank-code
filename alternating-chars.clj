(defn input-strings [num]
    (loop [a0 num res []]
        (if (> a0 0)
            (let [string (read-line)]
                (recur (- a0 1) (conj res string))
            )
            res
        )
    )
)

(defn alternate-chars [string]
    (loop [a0 (- (.length string) 1) res 0] (if (> a0 0) (recur (- a0 1) (if (= (nth string (- a0 0)) (nth string (- a0 1))) (inc res) res) ) res ))
)

(let [
    s (read-line)
    size (Integer/parseInt s)]
    (doseq [i (map alternate-chars (input-strings size))] (println i))
)
