(ns training.block)

(defrecord ^:private Block [hash transactions])

(defn- calc-hash
  "Вычисляет хеш блока."
  [previous-hash transactions]
  (hash [previous-hash transactions])
  )

(defn create
  "Создаёт блок"
  [previous-hash transactions]
  {:pre [(number? previous-hash)
         (coll? transactions)]
   }
  (->Block (calc-hash previous-hash transactions) transactions)
  )

